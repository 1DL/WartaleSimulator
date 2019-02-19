/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author LuizV1
 */
public class CharSelect {

    Point p = new Point();
    Timer timer;
    int lVelX;
    int lStartX;
    int lEndX;
    Boolean animActive = false;
    JLabel lbl;
    boolean leftOrRight;
    
    ActionListener up = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                animActive = true;

                if (leftOrRight) {
                    p.x = p.x + lVelX;
                } else {
                    p.x = p.x - lVelX;
                }
                lbl.setLocation(p);
                lbl.validate();
                if (leftOrRight && p.x >= lEndX) {
                    p.x = lEndX;
                    lbl.setLocation(p);
                    lbl.validate();
                    animActive = false;
                    timer.stop();
                } else if (!leftOrRight && p.x <= lEndX) {
                    p.x = lEndX;
                    lbl.setLocation(p);
                    lbl.validate();
                    animActive = false;
                    timer.stop();
                }
            }
        };

    public void showUp(JLabel lbl, String pathImg, int startX, int endX, int velX, boolean leftOrRight) {
        lStartX = startX;
        lVelX = velX;
        lEndX = endX;
        this.lbl = lbl;
        this.leftOrRight = leftOrRight;
        
        if (animActive) {
            timer.stop();
            p = this.lbl.getLocation();
            p.x = lStartX;
            this.lbl.setLocation(p);
            this.lbl.validate();
            this.lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource(pathImg)));
        } else {
            p.x = startX;
            this.lbl.setLocation(p);            
            this.lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource(pathImg)));
        }
        
        

        timer = new Timer((1000 / 60), up);
        timer.start();

        
    }

}
