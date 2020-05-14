/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.game.main;
import controller.view.animation.FadeInOut;
import java.awt.Color;

/**
 *
 * @author Administrator
 */
public class StartupFrame extends javax.swing.JFrame {
    
    
    FadeInOut fade = new FadeInOut();

    /**
     * Creates new form StartupFrame
     */
    public StartupFrame() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        fade.animarLogoStartUp(lbl_logo, 5, "/assets/images/logo.png", true, true, 100, this);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_logo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wartale Simulator "+main.version+" - Launcher "+main.by);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Open");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 410, Short.MAX_VALUE)
                .addComponent(lbl_logo)
                .addGap(0, 410, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(41, 41, 41)
                .addComponent(jButton1)
                .addGap(285, 285, 285))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 148, Short.MAX_VALUE)
                .addComponent(lbl_logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        fecharStartup();
    }//GEN-LAST:event_formMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fecharStartup();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(StartupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartupFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lbl_logo;
    // End of variables declaration//GEN-END:variables

//    private void animarLogo() {
//        
//        ActionListener sumirImagem = new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                try {
//                    if (timerCount >= 0 ) {
////                        if (timerCount >= 200) {
////                            timerCount = 100;
////                        }
//                        URL url = this.getClass().getResource("/assets/images/logo.png");
//                        BufferedImage logo = ImageIO.read(new File(url.toURI()));
//                        BufferedImage aLogo = new BufferedImage(logo.getWidth(), logo.getHeight(), BufferedImage.TYPE_INT_ARGB);
//                        Graphics2D createGraphics = aLogo.createGraphics();
//                        createGraphics.drawImage(logo, null, 0, 0);
//                        float alp[] = new float[]{1f, 1f, 1f, (timerCount / 100)};
//                        float def[] = new float[]{0, 0, 0, 0};
//                        RescaleOp r = new RescaleOp(alp, def, null);
//                        BufferedImage filter = r.filter(aLogo, null);
//                        lbl_logo.setIcon(new ImageIcon(filter));
//                        timerCount=timerCount - 5;
//                    }
//                    
//                    if (timerCount <= 0) {
//                        timer.stop();
//                        timerCount = 0;
//                        fecharStartup();
//                    }
//                    
//                } catch (IOException | URISyntaxException ex) {
//                    Logger.getLogger(StartupFrame.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        };
//        
//        ActionListener aparecerImagem = new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                try {
//                    if (timerCount <= 100) {
//                        URL url = this.getClass().getResource("/assets/images/logo.png");
//                        BufferedImage logo = ImageIO.read(new File(url.toURI()));
//                        BufferedImage aLogo = new BufferedImage(logo.getWidth(), logo.getHeight(), BufferedImage.TYPE_INT_ARGB);
//                        Graphics2D createGraphics = aLogo.createGraphics();
//                        createGraphics.drawImage(logo, null, 0, 0);
//                        float alp[] = new float[]{1f, 1f, 1f, (timerCount / 100)};
//                        float def[] = new float[]{0, 0, 0, 0};
//                        RescaleOp r = new RescaleOp(alp, def, null);
//                        BufferedImage filter = r.filter(aLogo, null);
//                        lbl_logo.setIcon(new ImageIcon(filter));
//                        
//                    }
//                        timerCount=timerCount + 2;
//                        
//                    if (timerCount >= 200) {
//                        timer.addActionListener(sumirImagem);
//                    }
//                    
//                } catch (IOException | URISyntaxException ex) {
//                    Logger.getLogger(StartupFrame.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        };
//        
//        
//        
//        timer = new Timer(1000 / 60, aparecerImagem);
//        timer.start();

//    }
    
    public void fecharStartup() {
        
        fade.killFade();
        fade = null;
        CharSelectFrame csf = new CharSelectFrame();
        csf.setVisible(true);
        this.dispose();
    }
}
