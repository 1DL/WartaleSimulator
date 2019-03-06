/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
import view.StartupFrame;

/**
 *
 * @author Administrator
 */
public class FadeInOut {

    Timer timer;
    float timerCounter;
    boolean animationActive = false;
    boolean lFadeInOut;
    BufferedImage img;
    BufferedImage nimg;
    Graphics2D createGraphics; 
    
    /**
     * Efeito de fadeIn e fadeOut para imagens de JLabels.
     * @param lbl - jlabel a ter a imagem de Icon a receber o efeito
     * @param speed - velocidade do efeito
     * @param timerSpeed - velocidade do timer
     * @param imagePath - String contendo o classpath da imagem da jlabel
     * @param fadeInOut - Booleano que define o tipo de efeito. True = Fade In, False = Fade Out
     * @param fadeOutAfterIn  - Booleano que define um FadeOut automático após Fade In for realizado
     * @param delay - Caso fadeOutAfterIn seja True, tempo de atraso para começar o efeito de Fade Out após acabar o Fade In.
     */
    
    public void killFade() {
        timer.stop();
        animationActive = false;
        timerCounter = 0;
    }
    
    public void fade(JLabel lbl, int speed, int timerSpeed, String imagePath, boolean fadeInOut, boolean fadeOutAfterIn, int delay) {
        
        
        lFadeInOut = fadeInOut;
        

        animationActive = true;

        URL url = this.getClass().getResource(imagePath);

        if (fadeInOut) {
            timerCounter = 0;
        } else {
            timerCounter = 100;
        }
        
        try {
            img = ImageIO.read(new File(url.toURI()));
            nimg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
            createGraphics = nimg.createGraphics();
            createGraphics.drawImage(img, null, 0, 0);
        } catch (IOException ioe){
            Logger.getLogger(FadeInOut.class.getName()).log(Level.SEVERE, null, ioe);
        } catch (URISyntaxException ex) {
            Logger.getLogger(FadeInOut.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        ActionListener aparecerImagem = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                float alphaValue = 0f;
                if (timerCounter >= 100) {
                    alphaValue = 1f;
                } else {
                    alphaValue = timerCounter / 100;
                }
                float alp[] = new float[]{1f, 1f, 1f, alphaValue};
                float def[] = new float[]{0, 0, 0, 0};
                RescaleOp r = new RescaleOp(alp, def, null);
                BufferedImage filter = r.filter(nimg, null);
                lbl.setIcon(new ImageIcon(filter));
                if (lFadeInOut && fadeOutAfterIn && timerCounter >= 100) {
                    lbl.setIcon (new ImageIcon(img));
                    timerCounter = timerCounter + delay;
                    lFadeInOut = false;
                } else if (lFadeInOut && !fadeOutAfterIn && timerCounter >= 100) {
                    lbl.setIcon (new ImageIcon(img));
                    timer.stop();
                    animationActive = false;
                } else if (!lFadeInOut && timerCounter <= 0) {
                    timer.stop();
                    animationActive = false;
                }
                if (lFadeInOut) {
                    timerCounter = timerCounter + speed;
                } else {
                    timerCounter = timerCounter - speed;
                }
            }
        };

        timer = new Timer((1000 / timerSpeed), aparecerImagem);
        timer.start();

    }
    
    
    
    public void animarFade(JLabel lbl, int speed, int timerSpeed, String imagePath, boolean fadeInOut, boolean fadeOutAfterIn, int delay) {
        
        
        lFadeInOut = fadeInOut;
        

        animationActive = true;

        URL url = this.getClass().getResource(imagePath);

        if (fadeInOut) {
            timerCounter = 0;
        } else {
            timerCounter = 100;
        }

        ActionListener aparecerImagem = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {

                        float alphaValue = 0f;
                        
                        BufferedImage img = ImageIO.read(new File(url.toURI()));
                        BufferedImage nimg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
                        Graphics2D createGraphics = nimg.createGraphics();
                        createGraphics.drawImage(img, null, 0, 0);
                        
                        if (timerCounter >= 100) {
                            alphaValue = 1f;
                        } else {
                            alphaValue = timerCounter / 100;
                        }
                        float alp[] = new float[]{1f, 1f, 1f, alphaValue};
                        float def[] = new float[]{0, 0, 0, 0};
                        RescaleOp r = new RescaleOp(alp, def, null);
                        BufferedImage filter = r.filter(nimg, null);
                        
                        lbl.setIcon(new ImageIcon(filter));

                        if (lFadeInOut && fadeOutAfterIn && timerCounter >= 100) {
                            lbl.setIcon (new ImageIcon(img));
                            timerCounter = timerCounter + delay;
                            lFadeInOut = false;
                        } else if (lFadeInOut && !fadeOutAfterIn && timerCounter >= 100) {
                            lbl.setIcon (new ImageIcon(img));
                            timer.stop();
                            animationActive = false;
                        } else if (!lFadeInOut && timerCounter <= 0) {
                            timer.stop();
                            animationActive = false;
                        }
                        
                        if (lFadeInOut) {
                            timerCounter = timerCounter + speed;
                        } else {
                            timerCounter = timerCounter - speed;
                        }
                        


                } catch (IOException | URISyntaxException ex) {
                    Logger.getLogger(StartupFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        timer = new Timer((1000 / timerSpeed), aparecerImagem);
        timer.start();

    }
    
    public void animarLogoStartUp(JLabel lbl, int speed, String imagePath, boolean fadeInOut, boolean fadeOutAfterIn, int delay, StartupFrame startup) {
        
        
        lFadeInOut = fadeInOut;
        

        animationActive = true;

        URL url = this.getClass().getResource(imagePath);

        if (fadeInOut) {
            timerCounter = 0;
        } else {
            timerCounter = 100;
        }

        ActionListener aparecerImagem = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {

                        float alphaValue = 0f;
                        
                        BufferedImage img = ImageIO.read(new File(url.toURI()));
                        BufferedImage nimg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
                        Graphics2D createGraphics = nimg.createGraphics();
                        createGraphics.drawImage(img, null, 0, 0);
                        
                        if (timerCounter >= 100) {
                            alphaValue = 1f;
                        } else {
                            alphaValue = timerCounter / 100;
                        }
                        float alp[] = new float[]{1f, 1f, 1f, alphaValue};
                        float def[] = new float[]{0, 0, 0, 0};
                        RescaleOp r = new RescaleOp(alp, def, null);
                        BufferedImage filter = r.filter(nimg, null);
                        
                        lbl.setIcon(new ImageIcon(filter));

                        if (lFadeInOut && fadeOutAfterIn && timerCounter >= 100) {
                            lbl.setIcon (new ImageIcon(img));
                            timerCounter = timerCounter + delay;
                            lFadeInOut = false;
                        } else if (lFadeInOut && !fadeOutAfterIn && timerCounter >= 100) {
                            lbl.setIcon (new ImageIcon(img));
                            timer.stop();
                            animationActive = false;
                            startup.fecharStartup();
                        } else if (!lFadeInOut && timerCounter <= 0) {
                            timer.stop();
                            animationActive = false;
                            startup.fecharStartup();
                        }
                        
                        if (lFadeInOut) {
                            timerCounter = timerCounter + speed;
                        } else {
                            timerCounter = timerCounter - speed;
                        }
                        


                } catch (IOException | URISyntaxException ex) {
                    Logger.getLogger(StartupFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        timer = new Timer((1000 / 60), aparecerImagem);
        timer.start();

    }

}
