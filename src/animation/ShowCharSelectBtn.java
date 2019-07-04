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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    
    public void showDown (JLabel lbl, int endY, int velY) {
        lVelY = velY;
        ActionListener up = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            p = lbl.getLocation();
            lVelY = (int) (lVelY * 0.95);
            if (lVelY < 1) {
                p.y++;
            } else {
                p.y += lVelY;
            }
            lbl.setLocation(p);
            if (p.y >= endY) {
                p.y = endY;
                lbl.setLocation(p);
                lbl.validate();
                timer.stop();
                lVelY = velY;
            }
        }
    };
        
        timer = new Timer ((1000 / 60), up);
        timer.start();
        
    }
    
    public void showLeftPanel (JPanel pnl, int endX, int velX) {
        lVelX = velX;
        ActionListener left = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            p = pnl.getLocation();
            lVelX = (int) (lVelX * 0.95);
            if (lVelX < 1) {
                p.x++;
            } else {
                p.x += lVelX;
            }
            pnl.setLocation(p);
            if (p.x >= endX) {
                p.x = endX;
                pnl.setLocation(p);
                pnl.validate();
                timer.stop();
                lVelX = velX;
            }
        }
    };
        
        
        
        timer = new Timer ((1000 / 60), left);
        timer.start();
        
    }
    
    public void showLeftLabel(JLabel lbl, int endX, int velX) {
        lVelX = velX;
        ActionListener left = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            p = lbl.getLocation();
            lVelX = (int) (lVelX * 0.95);
            if (lVelX < 1) {
                p.x++;
            } else {
                p.x += lVelX;
            }
            lbl.setLocation(p);
            if (p.x >= endX) {
                p.x = endX;
                lbl.setLocation(p);
                lbl.validate();
                timer.stop();
                lVelX = velX;
            }
        }
    };
        
        
        
        timer = new Timer ((1000 / 60), left);
        timer.start();
        
    }
    
    public void showRightPanel (JPanel pnl, int endX, int velX) {
        lVelX = velX;
        ActionListener right = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            p = pnl.getLocation();
            lVelX = (int) (lVelX * 0.95);
            if (lVelX < 1) {
                p.x--;
            } else {
                p.x -= lVelX;
            }
            pnl.setLocation(p);
            if (p.x <= endX) {
                p.x = endX;
                pnl.setLocation(p);
                pnl.validate();
                timer.stop();
                lVelX = velX;
            }
            
            
            System.out.println("ShowRightPanel");
        }
    };
        
        timer = new Timer ((1000 / 60), right);
        timer.start();
        
    }
    
    public void showRightLabel (JLabel lbl, int endX, int velX) {
        lVelX = velX;
        ActionListener right = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            p = lbl.getLocation();
            lVelX = (int) (lVelX * 0.95);
            if (lVelX < 1) {
                p.x--;
            } else {
                p.x -= lVelX;
            }
            lbl.setLocation(p);
            if (p.x <= endX) {
                p.x = endX;
                lbl.setLocation(p);
                lbl.validate();
                timer.stop();
                lVelX = velX;
            }
        }
    };
        
        timer = new Timer ((1000 / 60), right);
        timer.start();
        
    }
}
