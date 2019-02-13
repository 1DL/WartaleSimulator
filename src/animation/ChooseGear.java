/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import static animation.Animation.animationActiveChooseGear;
import static animation.InterfaceCharInfo.panelOpen;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import view.Sound;

/**
 *
 * @author Administrator
 */
public class ChooseGear extends Animation {

    Dimension d = new Dimension();
    int velH = 30;
    int velW = 30;
    Timer timer;

    public void open(JPanel panel, boolean openOrClose) {
        ActionListener openAction = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (d.height >= 425) {
                    d.height = 425;
                } else if (d.height < 250) {
                    d.height += velH;
                } else {
                    velH = (int) (velH * 0.9);
                    if (velH < 1) {
                        velH = 1;
                    }
                    d.height += velH;
                }
                
                
                if (d.width >= 750) {
                    d.width = 750;
                } else if (d.width < 600) {
                    d.width += velW;
                } else {
                    velW = (int) (velW * 0.9);
                    if (velW < 1) {
                        velW = 1;
                    }
                    d.width += velW;
                }
                

                if (d.height >= 425 && d.width >= 750) {
                    d.height = 425;
                    d.width = 750;
                    panel.validate();
                    timer.stop();
                    velH = 30;
                    velW = 30;
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
                    velH = 30;
                    velW = 30;
                    animationActiveChooseGear = false;
                }
                panel.setSize(d);
            }
        };
        
        if (!animationActiveChooseGear){
            if (openOrClose) {
            panel.setLocation(20, 35);
            d.height = 0;
            d.width = 0;
            panel.setSize(d);
            velH = 30;
            velW = 30;
            this.timer = new Timer(1000 / 60, openAction);
            animationActiveChooseGear = true;
            timer.start();
            Sound.playSound("interface-on.wav");
        } else {
            panel.setLocation(20, 35);
            d.height = 425;
            d.width = 750;
            panel.setSize(d);
            velH = 30;
            velW = 30;
            this.timer = new Timer(1000 / 60, closeAction);
            animationActiveChooseGear = true;
            timer.start();
        }
        
        
        }
    }
}
