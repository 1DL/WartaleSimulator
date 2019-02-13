/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import view.MainFrame;
import view.Sound;

/**
 * @author Luiz int delay = 1000; //milliseconds ActionListener taskPerformer =
 * new ActionListener() { public void actionPerformed(ActionEvent evt) {
 * <em>//...Perform a task...</em>
 * }
 * }; new Timer(delay, taskPerformer).start();</pre>
 *
 */
public class InterfaceCharInfo extends Animation {

    
    static boolean panelOpen = false;
    Point p;
    MainFrame mainFrame;    
    Timer timer;
    JPanel panel;
    int velY = 20;
    
    public static boolean isPanelOpen() {
        return panelOpen;
    }

    public void openOrClose(MainFrame mainFrame) {
        panel = mainFrame.getPanCharInfo();
        ActionListener closePanelAction = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            p = panel.getLocation();
            velY = (int) (velY * 0.95);
            if (velY < 1) {
                p.y++;
            } else {
                p.y += velY;
            }
            panel.setLocation(p);
            if (p.y >= 600) {
                p.y = 600;
                panel.setLocation(p);
                
                timer.stop();
                velY = 20;
                animationActive = false;
                mainFrame.setPanCharInfo(panel);
            }
        }
    };
    
    ActionListener openPanelAction = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            p = panel.getLocation();
            velY = (int) (velY * 0.95);
            if (velY < 1) {
                p.y--;
            } else {
                p.y -= velY;
            }
            panel.setLocation(p);
            if (p.y <= 400) {
                p.y = 400;
                panel.setLocation(p);
                panel.validate();
                timer.stop();
                velY = 20;
                animationActive = false;
                mainFrame.setPanCharInfo(panel);
            }
        }
    };
        
        if (!animationActive) {
            if (InterfaceInventory.panelOpen) {
                InterfaceInventory anim = new InterfaceInventory();
                anim.openOrClose(mainFrame);
            }
            if (panelOpen) {
                this.timer = new Timer(1000 / 120, closePanelAction);
                panelOpen = false;
                animationActive = true;
                timer.start();
            } else {
                this.timer = new Timer(1000 / 120, openPanelAction);
                
                panelOpen = true;
                Sound.playSound("interface.wav");
                animationActive = true;
                timer.start();
            }            
        }
        
        
    }
    
    
}
