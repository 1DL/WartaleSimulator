/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author LuizV1
 */
public class TransparentImg {
    
    String imagePath;

    ArrayList<Icon> listaIcon = new ArrayList<>();

    private final Object threadLock = new Object();
    
    URL url;
    
    public TransparentImg() {
        
    }

    public void bufferTransparentImages(String imagePath) {
        
        this.imagePath = imagePath;
        url = this.getClass().getResource(imagePath);

        synchronized (threadLock) {

            final Runnable r = new Runnable() {
                public void run() {
                    gerarLista();
                }
            };
            final Thread t = new Thread(r);
            t.setDaemon(true);
            t.setPriority(Thread.MAX_PRIORITY);
            t.start();
        }
    }

    

    private void gerarLista() {
        float opacity = 0f;
        do {
            listaIcon.add(new ImageIcon(gerarImgTransp(opacity)));
            opacity = opacity + 0.05f;
        } while (opacity <= 1f);
    }
    
    private BufferedImage gerarImgTransp(Float opacity){
        try {
            BufferedImage image = ImageIO.read(new File(url.toURI()));
            BufferedImage tmpImg = new BufferedImage(image.getWidth(), image.getHeight(),
                BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = (Graphics2D) tmpImg.getGraphics();
            g2d.setComposite(AlphaComposite.SrcOver.derive(opacity));
            g2d.drawImage(image, 0, 0, null);
            g2d.dispose();
            return tmpImg;
        } catch (URISyntaxException ex) {
            Logger.getLogger(TransparentImg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException iex) {
            Logger.getLogger(FadeInOut.class.getName()).log(Level.SEVERE, null, iex);
        }
        return null;
    }

    public ArrayList<Icon> getListaIcon() {
        return listaIcon;
    }
    
    
}
