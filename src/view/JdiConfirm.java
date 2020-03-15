/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * @author Administrator
 */
public class JdiConfirm extends javax.swing.JDialog {

    int returnFlag;
    
    TextureWork textureWork = new TextureWork();
    
    public JdiConfirm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        CustomCursor();
        
        lblHoverBuild.setVisible(false);
        lblHoverSwap.setVisible(false);
        lblHoverCancel.setVisible(false);
        
        btnSwap.setIcon(textureWork.addTranspBMP("/assets/images/buttons/trade.bmp"));
        btnSwap.setPressedIcon(textureWork.addTranspBMP("/assets/images/buttons/trade.bmp"));
        btnSwap.setRolloverIcon(textureWork.addTranspBMP("/assets/images/buttons/Htrade.bmp"));
        
        btnBuild.setIcon(textureWork.addTranspBMP("/assets/images/buttons/repairAll.bmp"));
        btnBuild.setPressedIcon(textureWork.addTranspBMP("/assets/images/buttons/repairAll.bmp"));
        btnBuild.setRolloverIcon(textureWork.addTranspBMP("/assets/images/buttons/HrepairAll.bmp"));
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHoverBuild = new javax.swing.JLabel();
        lblHoverSwap = new javax.swing.JLabel();
        lblHoverCancel = new javax.swing.JLabel();
        lblMensagem = new javax.swing.JLabel();
        lblPlayerClass = new javax.swing.JLabel();
        lblEnemyClass = new javax.swing.JLabel();
        lblIconPlayer = new javax.swing.JLabel();
        lblIconEnemy = new javax.swing.JLabel();
        btnSwap = new javax.swing.JButton();
        btnBuild = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(429, 166));
        setMinimumSize(new java.awt.Dimension(429, 166));
        setUndecorated(true);
        getContentPane().setLayout(null);

        lblHoverBuild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/tooltip/build.png"))); // NOI18N
        getContentPane().add(lblHoverBuild);
        lblHoverBuild.setBounds(106, 45, 76, 27);

        lblHoverSwap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/tooltip/swap.png"))); // NOI18N
        getContentPane().add(lblHoverSwap);
        lblHoverSwap.setBounds(53, 45, 76, 27);

        lblHoverCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/tooltip/cancel.png"))); // NOI18N
        getContentPane().add(lblHoverCancel);
        lblHoverCancel.setBounds(1, 45, 76, 27);

        lblMensagem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMensagem.setForeground(new java.awt.Color(255, 255, 255));
        lblMensagem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMensagem.setText("Confirm both characters.");
        lblMensagem.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(lblMensagem);
        lblMensagem.setBounds(13, 7, 153, 15);

        lblPlayerClass.setForeground(new java.awt.Color(255, 255, 255));
        lblPlayerClass.setText("Player: Knight");
        getContentPane().add(lblPlayerClass);
        lblPlayerClass.setBounds(50, 30, 130, 14);

        lblEnemyClass.setForeground(new java.awt.Color(255, 255, 255));
        lblEnemyClass.setText("Enemy: Knight");
        getContentPane().add(lblEnemyClass);
        lblEnemyClass.setBounds(50, 50, 130, 14);
        getContentPane().add(lblIconPlayer);
        lblIconPlayer.setBounds(20, 27, 20, 20);
        getContentPane().add(lblIconEnemy);
        lblIconEnemy.setBounds(20, 47, 20, 20);

        btnSwap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/buttons/btnXClose.png"))); // NOI18N
        btnSwap.setBorder(null);
        btnSwap.setBorderPainted(false);
        btnSwap.setContentAreaFilled(false);
        btnSwap.setFocusPainted(false);
        btnSwap.setNextFocusableComponent(btnBuild);
        btnSwap.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/buttons/btnXClose.png"))); // NOI18N
        btnSwap.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/buttons/HbtnXClose.png"))); // NOI18N
        btnSwap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSwapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSwapMouseExited(evt);
            }
        });
        btnSwap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwapActionPerformed(evt);
            }
        });
        getContentPane().add(btnSwap);
        btnSwap.setBounds(77, 75, 26, 26);

        btnBuild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/buttons/btnXClose.png"))); // NOI18N
        btnBuild.setBorder(null);
        btnBuild.setBorderPainted(false);
        btnBuild.setContentAreaFilled(false);
        btnBuild.setFocusPainted(false);
        btnBuild.setName(""); // NOI18N
        btnBuild.setNextFocusableComponent(btnCancel);
        btnBuild.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/buttons/btnXClose.png"))); // NOI18N
        btnBuild.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/buttons/HbtnXClose.png"))); // NOI18N
        btnBuild.setSelected(true);
        btnBuild.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuildMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuildMouseExited(evt);
            }
        });
        btnBuild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuildActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuild);
        btnBuild.setBounds(130, 75, 26, 26);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/buttons/btnXClose.png"))); // NOI18N
        btnCancel.setBorder(null);
        btnCancel.setBorderPainted(false);
        btnCancel.setContentAreaFilled(false);
        btnCancel.setFocusPainted(false);
        btnCancel.setNextFocusableComponent(btnBuild);
        btnCancel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/buttons/btnXClose.png"))); // NOI18N
        btnCancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/buttons/HbtnXClose.png"))); // NOI18N
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelMouseExited(evt);
            }
        });
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel);
        btnCancel.setBounds(25, 75, 26, 26);

        lblBackground.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/confirmselect/msgFrame.png"))); // NOI18N
        lblBackground.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, 0, 183, 123);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSwapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwapActionPerformed
        returnFlag = 1;
        clickBotao();
    }//GEN-LAST:event_btnSwapActionPerformed

    private void btnBuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuildActionPerformed
        returnFlag = 2;
        clickBotao();
    }//GEN-LAST:event_btnBuildActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        returnFlag = 0;
        clickBotao();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnBuildMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuildMouseEntered
        lblHoverBuild.setVisible(true);
    }//GEN-LAST:event_btnBuildMouseEntered

    private void btnBuildMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuildMouseExited
        lblHoverBuild.setVisible(false);
    }//GEN-LAST:event_btnBuildMouseExited

    private void btnSwapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSwapMouseEntered
        lblHoverSwap.setVisible(true);
    }//GEN-LAST:event_btnSwapMouseEntered

    private void btnSwapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSwapMouseExited
        lblHoverSwap.setVisible(false);
    }//GEN-LAST:event_btnSwapMouseExited

    private void btnCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseEntered
        lblHoverCancel.setVisible(true);
    }//GEN-LAST:event_btnCancelMouseEntered

    private void btnCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseExited
        lblHoverCancel.setVisible(false);
    }//GEN-LAST:event_btnCancelMouseExited

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
            java.util.logging.Logger.getLogger(JdiConfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdiConfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdiConfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdiConfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdiConfirm dialog = new JdiConfirm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuild;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSwap;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblEnemyClass;
    private javax.swing.JLabel lblHoverBuild;
    private javax.swing.JLabel lblHoverCancel;
    private javax.swing.JLabel lblHoverSwap;
    private javax.swing.JLabel lblIconEnemy;
    private javax.swing.JLabel lblIconPlayer;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblPlayerClass;
    // End of variables declaration//GEN-END:variables

    public void setPlayerChar(String playerClass) {
        lblPlayerClass.setText("Player: " + playerClass);
        lblIconPlayer.setIcon(textureWork.addTranspBMP("/assets/images/character/"+playerClass+"_icon.bmp"));
    }

    public void setEnemyChar(String enemyClass) {
        lblEnemyClass.setText("Enemy: " + enemyClass);
        lblIconEnemy.setIcon(textureWork.addTranspBMP("/assets/images/character/"+enemyClass+"_icon.bmp"));
    }
    
    private void clickBotao(){
        this.setVisible(false);
        this.dispose();
    }
    
    public void CustomCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("default.png");
        Point point = new Point(0, 0);
        Cursor cursor = toolkit.createCustomCursor(img, point, "Cursor");

        setCursor(cursor);
    }
}
