/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import animation.FadeInOut;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Administrator
 */
public class CharbuildFrame extends javax.swing.JFrame {

    String buildingChar = main.player;
    String previousChar = buildingChar;

    Sound music = new Sound();
    JLabel bg;
    Background bgc;
    ArrayList<String> listaImgBg;
    int listaIndex = 0;
    int flagDirecaoAnimBg = 0;
    boolean flagStopBgAnim = false;
    boolean flagActiveBgAnim = false;
    boolean flagAnimationActive = false;
    int animSpeedX = 0;
    int animSpeedY = 0;

    Timer timer = new Timer();
    Timer timer2 = new Timer();

    FadeInOut fadeBackGround = new FadeInOut();

    TimerTask moveBg = new TimerTask() {
        public void run() {

            if (flagStopBgAnim) {
                try {
                    if (!flagActiveBgAnim) {
                        bgc.bgImagePath = ("/assets/images/background/" + nextBgImg());
                        bg = lblBackground2;
                        flagActiveBgAnim = true;
                    } else {
                        bgc.bgImagePath = ("/assets/images/background/" + nextBgImg());
                        bg = lblBackground1;
                        flagActiveBgAnim = false;
                    }

                    fadeBackGround.animarFade(bg, 5, 60, bgc.bgImagePath, true, false, 0);
                    Thread.sleep(30);
                    flagAnimationActive = false;
                    flagStopBgAnim = false;
                    definirZOrder(bg, 0);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CharbuildFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            animarBackGround(bg, bgc);

        }

    };

    /**
     * Creates new form CharbuildFrame
     */
    public CharbuildFrame() {
        initComponents();
        CustomCursor();
        getContentPane().setBackground(Color.BLACK);
        bg = lblBackground1;
        lblBackground1.setSize(1024, 768);
        lblBackground2.setSize(1024, 768);

        animateBackgrounds();

        music.playMusic("tos_SoundTeMP_Topaz.wav");
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
        int fps = 60;
        bgc = new Background(1024, 768, buildingChar);

        FadeInOut fadeBackGround = new FadeInOut();

        listaImgBg = bgc.generateBGImages(main.player);
        //lblBackground1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/background/pillai01.png")));
        //lblBackground2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/background/pillai02.png")));
        fadeBackGround.animarFade(lblBackground1, 5, 60, "/assets/images/background/" + listaImgBg.get(0), true, false, 0);
        //fadeBackGround.animarFade(lblBackground2, 5, 60, "/assets/images/background/pillai02.png", true, false, 0);

        lblBackground1.setLocation(0, 0);

        flagStopBgAnim = false;
        flagActiveBgAnim = false;
        timer.scheduleAtFixedRate(moveBg, 0, fps);
        System.out.println("Background animation timer FPS: " + fps);

    }

    public int definirDirecaoAnimBg() {
        int rng;
        rng = (int) (Math.random() * (8)) + 1;
        System.out.println("Número direção animação BG: " + rng);
        return rng;
    }

    public int gerarRng(int min, int max) {
        int rng;
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        rng = (int) (Math.random() * ((max - min) + 1)) + min;
        System.out.println(rng);
        return rng;
    }

    public void animarBackGround(JLabel bg, Background bgc) {
        if (!flagAnimationActive) {
            flagDirecaoAnimBg = definirDirecaoAnimBg();
            //flagDirecaoAnimBg = 2;
            switch (flagDirecaoAnimBg) {
                case 1:
                    bg.setLocation((gerarRng(bgc.NegX, 0)), 0);
                    break;
                case 2:
                    bg.setLocation(bgc.NegX, 0);
                    break;
                case 3:
                    bg.setLocation(bgc.NegX, (gerarRng(bgc.NegY, 0)));
                    break;
                case 4:
                    bg.setLocation(bgc.NegX, bgc.NegY);
                    break;
                case 5:
                    bg.setLocation((gerarRng(bgc.NegX, 0)), bgc.NegY);
                    break;
                case 6:
                    bg.setLocation(0, bgc.NegY);
                    break;
                case 7:
                    bg.setLocation(0, (gerarRng(bgc.NegY, 0)));
                    break;
                case 8:
                    bg.setLocation(0, 0);
                    break;
            }
            System.out.print("Animation X Speed: ");
            animSpeedX = gerarRng(1, 3);
            System.out.print("Animation Y Speed: ");
            animSpeedY = gerarRng(1, 2);

        }
        Point p = bg.getLocation();
        switch (flagDirecaoAnimBg) {
            case 1:
                flagAnimationActive = true;
                p.y -= animSpeedY;
                bg.setLocation(p);
                if (p.y <= bgc.NegY) {
                    flagStopBgAnim = true;
                }
                break;
            case 2:
                flagAnimationActive = true;
                p.x += animSpeedX;
                p.y -= animSpeedY;
                if (p.y <= bgc.NegY || p.x >= 0) {
                    flagStopBgAnim = true;
                }
                bg.setLocation(p);
                break;
            case 3:
                flagAnimationActive = true;
                p.x += animSpeedX;
                bg.setLocation(p);
                if (p.x >= 0) {
                    flagStopBgAnim = true;
                }
                break;
            case 4:
                flagAnimationActive = true;
                p.x += animSpeedX;
                p.y += animSpeedY;
                bg.setLocation(p);
                if (p.y >= 0 || p.x >= 0) {
                    flagStopBgAnim = true;
                }
                break;
            case 5:
                flagAnimationActive = true;
                p.y += animSpeedY;
                bg.setLocation(p);
                if (p.y >= 0) {
                    flagStopBgAnim = true;
                }
                break;
            case 6:
                flagAnimationActive = true;
                p.x -= animSpeedX;
                p.y += animSpeedY;
                bg.setLocation(p);
                if (p.x <= bgc.NegX || p.y >= 0) {
                    flagStopBgAnim = true;
                }
                break;
            case 7:
                flagAnimationActive = true;
                p.x -= animSpeedX;
                bg.setLocation(p);
                if (p.x <= bgc.NegX) {
                    flagStopBgAnim = true;
                }
                break;
            case 8:
                flagAnimationActive = true;
                p.x -= animSpeedX;
                p.y -= animSpeedY;
                if (p.y <= bgc.NegY || p.x <= bgc.NegX) {
                    flagStopBgAnim = true;
                }
                bg.setLocation(p);
                break;
        }
    }

    private void definirZOrder(JLabel bg, int z) {
        this.getContentPane().setComponentZOrder(bg, z);
    }

    public void CustomCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("default.png");
        Point point = new Point(0, 0);
        Cursor cursor = toolkit.createCustomCursor(img, point, "Cursor");

        setCursor(cursor);
    }

    public String nextBgImg() {
        if (buildingChar != previousChar) {
            bgc.generateBGImages(buildingChar);
            listaIndex = 0;
            previousChar = buildingChar;
            return listaImgBg.get(listaIndex);
        } else {
            listaIndex++;
            if (listaIndex > listaImgBg.size() - 1) {
                listaIndex = 0;
                listaImgBg = bgc.generateBGImages(buildingChar);
            }
            System.out.println("Imagem exibida: "+listaImgBg.get(listaIndex));
            return listaImgBg.get(listaIndex);
        }
    }
}
