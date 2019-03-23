/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    int aux = 0;
    
    ActionListener up = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                animActive = true;

                if (leftOrRight) {
                    p.x = p.x + lVelX;
                    if (p.x >= lEndX) {
                        p.x = lEndX;
                    }
                } else {
                    p.x = p.x - lVelX;
                    if (p.x <= lEndX) {
                        p.x = lEndX;
                    }
                }
                
                lbl.setLocation(p);
                lbl.validate();
                if (leftOrRight && p.x >= lEndX) {
                    p.x = lEndX;
                    lbl.setLocation(p);
                    lbl.validate();
                    timer.stop();
                    timer.removeActionListener(up);
                     System.out.println(timer.isRunning());
                    System.out.println("Running Player"+aux);
                    aux ++;
                } else if (!leftOrRight && p.x <= lEndX) {
                    p.x = lEndX;
                    lbl.setLocation(p);
                    lbl.validate();
                    timer.stop();
                    timer.removeActionListener(up);
                     System.out.println(timer.isRunning());
                    System.out.println("Running Enemy"+aux);
                    aux ++;
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
        
        

        timer = new Timer(16, up);
        timer.start();

        
    }
    
    

}
