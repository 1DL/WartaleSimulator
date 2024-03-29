/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.game.item.Item;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Luiz
 */
public class TextureWork {

    public String getFileNameHover(JLabel lbl, Item item) {
        String lblIconPath = "" + lbl.getIcon();
        File file = new File(lblIconPath);
        try {
            item.checkStatusReq();
            if (item.isRequirementsMatch()) {
                return "H" + file.getName();
            } else {
                return "R" + file.getName();
            }
        } catch (NullPointerException npe) {
            System.err.println(npe);

        }

        return "H" + file.getName();
    }

    public String getFileName(JLabel lbl) {
        String lblIconPath = "" + lbl.getIcon();
        File file = new File(lblIconPath);
        return file.getName().substring(1);
    }

    public Icon addTranspBMP(String imgDir) {

        try {

            BufferedImage image = ImageIO.read(getClass().getResourceAsStream(imgDir));

            Image transpImg1 = TransformColorToTransparency(image, new Color(0, 0, 0), new Color(0, 0, 0));
            BufferedImage resultImage1 = ImageToBufferedImage(transpImg1, image.getWidth(), image.getHeight());

            ImageIcon icon = new ImageIcon(resultImage1);
            return icon;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public void addTranspBMPandSave(String imgDir, String fileName[]) {

        for (String img : fileName) {
            try {

                BufferedImage image = ImageIO.read(getClass().getResourceAsStream(imgDir+img));

                Image transpImg1 = TransformColorToTransparency(image, new Color(0, 0, 0), new Color(0, 0, 0));
                BufferedImage resultImage1 = ImageToBufferedImage(transpImg1, image.getWidth(), image.getHeight());

                ImageIcon icon = new ImageIcon(resultImage1);

                Image img2 = icon.getImage();

                BufferedImage bi = new BufferedImage(img2.getWidth(null), img2.getHeight(null), BufferedImage.TYPE_INT_ARGB);

                Graphics2D g2 = bi.createGraphics();
                g2.drawImage(img2, 0, 0, null);
                g2.dispose();
                String filePath = img.substring(0, img.length()-3)+"png";
                ImageIO.write(bi, "png", new File(filePath));//img.substring(0, img.length() - 3)+"png"));
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }

    

    private Image TransformGrayToTransparency(BufferedImage image) {
        ImageFilter filter = new RGBImageFilter() {
            public final int filterRGB(int x, int y, int rgb) {
                return (rgb << 8) & 0xFF000000;
            }
        };

        ImageProducer ip = new FilteredImageSource(image.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }

    private Image TransformColorToTransparency(BufferedImage image, Color c1, Color c2) {
        // Primitive test, just an example
        final int r1 = c1.getRed();
        final int g1 = c1.getGreen();
        final int b1 = c1.getBlue();
        final int r2 = c2.getRed();
        final int g2 = c2.getGreen();
        final int b2 = c2.getBlue();
        ImageFilter filter = new RGBImageFilter() {
            public final int filterRGB(int x, int y, int rgb) {
                int r = (rgb & 0xFF0000) >> 16;
                int g = (rgb & 0xFF00) >> 8;
                int b = rgb & 0xFF;
                if (r >= r1 && r <= r2
                        && g >= g1 && g <= g2
                        && b >= b1 && b <= b2) {
                    // Set fully transparent but keep color
                    return rgb & 0xFFFFFF;
                }
                return rgb;
            }
        };

        ImageProducer ip = new FilteredImageSource(image.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }

    private BufferedImage ImageToBufferedImage(Image image, int width, int height) {
        BufferedImage dest = new BufferedImage(
                width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = dest.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return dest;
    }

}
