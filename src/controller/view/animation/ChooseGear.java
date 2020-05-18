/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.view.animation;

import controller.assets.assetsController;
import static controller.view.animation.Animation.animationActiveChooseGear;
import controller.game.main;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Administrator
 */
public class ChooseGear extends Animation {
//[810, 540]

    Dimension d = new Dimension();
    int velHb = 44;
    int velWb = 46;
    int velH = velHb;
    int velW = velWb;
    int maxH = 563;
    int maxW = 850;
    Timer timer;
    
    public void open(JPanel panel, boolean openOrClose, JDialog dialog) {
        ActionListener openAction = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (d.height >= maxH) {
                    d.height = maxH;
                } else if (d.height < 250) {
                    d.height += velH;
                } else {
                    velH = (int) (velH * 0.9);
                    if (velH < 1) {
                        velH = 1;
                    }
                    d.height += velH;
                }
                
                if (d.width >= maxW) {
                    d.width = maxW;
                } else if (d.width < 542) {
                    d.width += velW;
                } else {
                    velW = (int) (velW * 0.9);
                    if (velW < 1) {
                        velW = 1;
                    }
                    d.width += velW;
                }
                
                if (d.height >= maxH && d.width >= maxW) {
                    d.height = maxH;
                    d.width = maxW;
                    panel.validate();
                    timer.stop();
                    velH = velHb;
                    velW = velWb;
                    animationActiveChooseGear = false;
                    
                }
                panel.setSize(d);
            }
        };
        
        ActionListener closeAction = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (d.height > 200) {
                    d.height -= velH;
                } else {
                    velH = (int) (velH * 0.9);
                    if (velH < 1) {
                        velH = 1;
                    }
                    d.height -= velH;
                }
                
                if (d.width > 200) {
                    d.width -= velW;
                } else {
                    velW = (int) (velW * 0.9);
                    if (velW < 1) {
                        velW = 1;
                    }
                    d.width -= velW;
                }
                
                if (d.height <= 0 && d.width <= 0) {
                    d.height = 0;
                    d.width = 0;
                    panel.validate();
                    timer.stop();
                    velH = velHb;
                    velW = velWb;
                    animationActiveChooseGear = false;
                    dialog.setVisible(false);
                    dialog.dispose();
                    
                }
                panel.setSize(d);
            }
        };
        
        if (!animationActiveChooseGear) {
            if (openOrClose) {
                panel.setLocation(20, 35);
                d.height = 0;
                d.width = 0;
                panel.setSize(d);
                velH = velHb;
                velW = velWb;
                this.timer = new Timer(1000 / 60, openAction);
                animationActiveChooseGear = true;
                timer.start();
                main.sfx.playSound(assetsController.GUISFX_DIR + "interface-on.wav");
            } else {
                panel.setLocation(20, 35);
                d.height = 425;
                d.width = 750;
                panel.setSize(d);
                velH = velHb;
                velW = velWb;
                this.timer = new Timer(1000 / 60, closeAction);
                animationActiveChooseGear = true;
                timer.start();
            }
            
        }
    }
}
