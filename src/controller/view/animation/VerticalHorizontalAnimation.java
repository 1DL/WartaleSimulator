/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.view.animation;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class VerticalHorizontalAnimation {

    Point p;
    Timer timer = new Timer("Animation SCSB", true);
    int lVelX;
    int lVelY;

    JPanel pnl;
    int endX;
    int velX;

    public void showUp(JButton btn, int endY, int velY) {
        lVelY = velY;
        TimerTask up = new TimerTask() {
            public void run() {
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
                    lVelY = velY;
                    timer.cancel();
                }
            }
        };
        
        timer.scheduleAtFixedRate(up, 0, (1000 / 60));

    }

    public void showDown(JLabel lbl, int endY, int velY) {
        lVelY = velY;
        TimerTask up = new TimerTask() {
            public void run() {
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
                    timer.cancel();
                    lVelY = velY;
                }
            }
        };

        timer.scheduleAtFixedRate(up, 0, (1000/60));

    }

    public void showLeftPanel(JPanel pnl, int endX, int velX) {
        lVelX = velX;
        TimerTask left = new TimerTask() {
            public void run() {
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
                    timer.cancel();
                    lVelX = velX;
                }
            }
        };

        timer.scheduleAtFixedRate(left, 0, (1000 / 60));
    }

    public void showLeftLabel(JLabel lbl, int endX, int velX) {
        lVelX = velX;
        TimerTask left = new TimerTask() {
            public void run() {
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
                    timer.cancel();
                    lVelX = velX;
                }
            }
        };

        timer.scheduleAtFixedRate(left, 0, (1000 / 60));
    }

    public void showRightPanel(JPanel pnl, int endX, int velX) {
        lVelX = velX;
        TimerTask right = new TimerTask() {
            public void run() {
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
                    timer.cancel();
                    lVelX = velX;
                }

                System.out.println("ShowRightPanel");
            }
        };

        timer.scheduleAtFixedRate(right, 0, (1000 / 60));

    }

    public void showRightLabel(JLabel lbl, int endX, int velX) {
        lVelX = velX;
        TimerTask right = new TimerTask() {
            public void run() {
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
                    timer.cancel();
                    lVelX = velX;
                }
            }
        };

        timer.scheduleAtFixedRate(right, 0, (1000 / 60));

    }
}
