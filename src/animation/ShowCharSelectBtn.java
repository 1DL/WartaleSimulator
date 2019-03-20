/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 *
 * @author Administrator
 */
public class ShowCharSelectBtn {
    
    Point p;
    Timer timer;
    int lVelX;
    int lVelY;
    
    public void showUp (JButton btn, int endY, int velX, int velY, boolean upOrDown) {
        lVelX = velX;
        lVelY = velY;
        ActionListener up = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            p = btn.getLocation();
            lVelY = (int) (lVelY * 0.95);
            if (lVelY < 1) {
                p.y--;
            } else {
                p.y -= lVelY;
            }
            btn.setLocation(p);
            if (p.y <= endY) {
                p.y = endY;
                btn.setLocation(p);
                btn.validate();
                timer.stop();
                lVelY = velY;
            }
        }
    };
        
        timer = new Timer ((1000 / 60), up);
        timer.start();
        
    }
}
