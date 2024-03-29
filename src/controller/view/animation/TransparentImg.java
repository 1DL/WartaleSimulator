/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.view.animation;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author LuizV1
 */
public class TransparentImg {

    String imagePath;
    float opacity;
    BufferedImage image;
    BufferedImage tmpImg;
    ImageIcon icon;

    private final Object threadLock = new Object();

    URL url;

    public TransparentImg(String imagePath, float opacity) {
        this.imagePath = imagePath;
        this.opacity = opacity;
        url = this.getClass().getResource(imagePath);

        try {

            image = ImageIO.read(getClass().getResourceAsStream(imagePath));
            tmpImg = new BufferedImage(image.getWidth(), image.getHeight(),
                    BufferedImage.TYPE_INT_ARGB);
            

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    /*
    public ImageIcon bufferTransparentImages(float opacity) {
        this.opacity = opacity;
        synchronized (threadLock) {

            final Runnable r = new Runnable() {
                public void run() {
                    icon = gerarImgTransp();
                }
            };
            final Thread t = new Thread(r);
            t.setDaemon(true);
            t.setPriority(Thread.MAX_PRIORITY);
            t.start();
        }
        return icon;
                
    }*/

    public ImageIcon gerarImgTransp() {

        Graphics2D g2d = (Graphics2D) tmpImg.getGraphics();
        g2d.setComposite(AlphaComposite.SrcOver.derive(opacity));
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        return new ImageIcon(tmpImg);

    }

}
