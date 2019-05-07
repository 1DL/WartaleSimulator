/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import animation.FadeInOut;
import java.awt.Point;
import java.util.TimerTask;
import java.util.Timer;

/**
 *
 * @author Administrator
 */
public class CharbuildFrame extends javax.swing.JFrame {
    
    Background bg;

    /**
     * Creates new form CharbuildFrame
     */
    public CharbuildFrame() {
        initComponents();
        lblBackground1.setLocation(0,0);
        lblBackground2.setLocation(0,0);
        lblBackground1.setSize(1024,768);
        FadeInOut fadeBackGround = new FadeInOut();
        fadeBackGround.animarFade(lblBackground1, 5, 60, "/assets/images/background/pillai01.png", true, false, 0);
        animateBackgrounds();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBackground1 = new javax.swing.JLabel();
        lblBackground2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(800, 630));
        setMinimumSize(new java.awt.Dimension(800, 630));
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(lblBackground1);
        lblBackground1.setBounds(12, 20, 0, 0);

        lblBackground2.setName(""); // NOI18N
        getContentPane().add(lblBackground2);
        lblBackground2.setBounds(12, 47, 0, 0);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CharbuildFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CharbuildFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CharbuildFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CharbuildFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CharbuildFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBackground1;
    private javax.swing.JLabel lblBackground2;
    // End of variables declaration//GEN-END:variables

    private void animateBackgrounds() {
        bg = new Background(1024, 768, "/assets/images/background/pillai01.png");
        Timer timer = new Timer();
        
        TimerTask moveBg1 = new TimerTask() {
            public void run() {
                Point p = new Point();
                p = lblBackground1.getLocation();
                Point np = new Point();
                np.setLocation(p.getX()-1, p.getY()-1);
                lblBackground1.setLocation(np);
                
                if (np.x <= bg.maxNegY && !bg.flagFadeActive) {
                    FadeInOut fadeBackGround = new FadeInOut();
                    fadeBackGround.animarFade(lblBackground1, 5, 60, bg.bgImagePath, false, false, 0);
                    timer.cancel();
                }
                
                
            }
        };
        
        
        timer.scheduleAtFixedRate(moveBg1, 0, 60);
        
        
        
        
    }
}
