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

    public void showUp(JLabel lbl, String pathImg, int startX, int endX, int velX, boolean leftOrRight) {
        lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource(pathImg)));
        if (animActive) {
            timer.stop();
            p = lbl.getLocation();
            p.x = startX;
            lbl.setLocation(p);
            lbl.validate();
        } else {
            p.x = startX;
        }
        lVelX = velX;
        
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
                if (leftOrRight && p.x >= endX) {
                    p.y = lEndX;
                    lbl.setLocation(p);
                    lbl.validate();
                    animActive = false;
                    timer.stop();
                } else if (!leftOrRight && p.x <= endX) {
                    p.y = lEndX;
                    lbl.setLocation(p);
                    lbl.validate();
                    animActive = false;
                    timer.stop();
                }
            }
        };

        timer = new Timer((1000 / 60), up);
        timer.start();

        
    }

}
