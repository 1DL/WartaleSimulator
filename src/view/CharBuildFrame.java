/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import animation.FadeInOut;
import animation.ShowCharSelectBtn;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TimerTask;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.PlainDocument;
import javazoom.jl.decoder.JavaLayerException;

/**
 *
 * @author Administrator
 */
public class CharBuildFrame extends javax.swing.JFrame {
    int counter = 0;
    boolean flagHideGUI = false;
    int contadorAnimGearSlots = -6;
    ArrayList<JPanel> listPlayer = new ArrayList<>();
    ArrayList<JPanel> listEnemy = new ArrayList<>();

    String buildingChar = main.player;
    String previousChar = buildingChar;

    Mp3 music;
    Sound sfx = new Sound();
    JLabel bg;
    Background bgc;
    ArrayList<String> listaImgBg;
    ArrayList<String> trackList = new ArrayList<>();
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
                    Logger.getLogger(CharBuildFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            animarBackGround(bg, bgc);

        }

    };

    /**
     * Creates new form CharbuildFrame
     */
    public CharBuildFrame() {
        initComponents();
        setFiltroTexto();
        
        btnHideGUI.setVisible(false);
        
        TimerTask showInventorySlots = new TimerTask() {
            public void run() {
                switch (contadorAnimGearSlots) {
                    case -2:
                        sfx.playSound("/woosh/woosh"+gerarRng(1, 3)+".wav");
                        break;
                    case -1:
                        sfx.playSound("/woosh/woosh"+gerarRng(1, 3)+".wav");
                        break;
                    case 0:
                        ShowCharSelectBtn scsbPS = new ShowCharSelectBtn();
                        scsbPS.showLeftPanel(panPlayerStats,197, 50);
                        scsbPS.showDown(lblFraseAjuda, 2, 12);
                        break;
                    case 1:
                        ShowCharSelectBtn scsbES = new ShowCharSelectBtn();
                        scsbES.showRightPanel(panEnemyStats,440, 50);
                        break;
                    case 2:
                        ShowCharSelectBtn scsbP = new ShowCharSelectBtn();
                        scsbP.showLeftLabel(lblPlayer,0, 50);
                        scsbP.showLeftLabel(lblPlayerClassName, 10, 50);
                        break;
                    case 3:
                        ShowCharSelectBtn scsbE = new ShowCharSelectBtn();
                        scsbE.showRightLabel(lblEnemy,290, 50);
                        scsbE.showRightLabel(lblEnemyClassName,580, 50);
                        sfx.playSound("/woosh/woosh"+gerarRng(4, 8)+".wav");
                        break;
                    case 4:
                        ShowCharSelectBtn scsb = new ShowCharSelectBtn();
                        scsb.showLeftPanel(panPlayerAcessorySlots,57, 35);
                        sfx.playSound("/woosh/woosh"+gerarRng(4, 8)+".wav");
                        break;
                    case 5:
                        ShowCharSelectBtn scsb2 = new ShowCharSelectBtn();
                        scsb2.showLeftPanel(panPlayerDefenseSlots,214, 35);
                        sfx.playSound("/woosh/woosh"+gerarRng(4, 8)+".wav");
                        break;
                    case 6:
                        ShowCharSelectBtn scsb3 = new ShowCharSelectBtn();
                        scsb3.showLeftPanel(panPlayerMainGearSlots,57, 38);
                        sfx.playSound("/woosh/woosh"+gerarRng(4, 8)+".wav");
                        break;
                    case 7:
                        ShowCharSelectBtn scsb4 = new ShowCharSelectBtn();
                        scsb4.showRightPanel(panEnemyAcessorySlots,440, 35);
                        sfx.playSound("/woosh/woosh"+gerarRng(4, 8)+".wav");
                        break;
                    case 8:
                        ShowCharSelectBtn scsb5 = new ShowCharSelectBtn();
                        scsb5.showRightPanel(panEnemyDefenseSlots,598, 35);
                        break;
                    case 9:
                        ShowCharSelectBtn scsb6 = new ShowCharSelectBtn();
                        scsb6.showRightPanel(panEnemyMainGearSlots,440, 35);
                        sfx.playSound("/woosh/woosh"+gerarRng(4, 8)+".wav");
                        break;
                    case 10:
                        btnHideGUI.setVisible(true);
                        timer2.cancel();                        
                        break;
                }
                
                contadorAnimGearSlots++;
            }
        };
        
        BufferedImage Image;
        try {
            Image = ImageIO.read(new File("src/assets/images/character/"+main.player.toLowerCase()+"_player.png"));
            lblPlayer.setIcon(new ImageIcon(Image));
            Image = ImageIO.read(new File("src/assets/images/character/"+main.enemy.toLowerCase()+"_enemy.png"));
            lblEnemy.setIcon(new ImageIcon(Image));
            Image = ImageIO.read(new File("src/assets/images/classtitle/"+main.player+"Name.png"));
            lblPlayerClassName.setIcon(new ImageIcon(Image));
            Image = ImageIO.read(new File("src/assets/images/classtitle/"+main.enemy+"Name.png"));
            lblEnemyClassName.setIcon(new ImageIcon(Image));
        } catch (IOException ex) {
            Logger.getLogger(CharBuildFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if (!main.flagBgm) {
            btnPlayStopBGM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/btnBGMoff.png")));
        }
        buildTrackList();
        CustomCursor();
        getContentPane().setBackground(Color.BLACK);
        bg = lblBackground1;
        lblBackground1.setSize(1024, 768);
        lblBackground2.setSize(1024, 768);

        animateBackgrounds();

        try {
            music = new Mp3(trackList);
            music.play();
            if (!main.flagBgm){
                music.pause();
            }
        } catch (JavaLayerException ex) {
            Logger.getLogger(CharBuildFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CharBuildFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        timer2.scheduleAtFixedRate(showInventorySlots, 0, 200);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPlayStopBGM = new javax.swing.JButton();
        btnSwapChar = new javax.swing.JButton();
        btnHideGUI = new javax.swing.JButton();
        panPlayerStats = new javax.swing.JPanel();
        txtPlayerName = new javax.swing.JTextField();
        txtPLevel = new javax.swing.JTextField();
        txtPStrenght = new javax.swing.JTextField();
        txtPSpirit = new javax.swing.JTextField();
        txtPTalent = new javax.swing.JTextField();
        txtPAgility = new javax.swing.JTextField();
        txtPHealth = new javax.swing.JTextField();
        txtPRemainStats = new javax.swing.JTextField();
        lblPlayerStats = new javax.swing.JLabel();
        panEnemyStats = new javax.swing.JPanel();
        txtEnemyName = new javax.swing.JTextField();
        txtELevel = new javax.swing.JTextField();
        txtEStrenght = new javax.swing.JTextField();
        txtESpirit = new javax.swing.JTextField();
        txtETalent = new javax.swing.JTextField();
        txtEAgility = new javax.swing.JTextField();
        txtEHealth = new javax.swing.JTextField();
        txtERemainStats = new javax.swing.JTextField();
        lblEnemyStats = new javax.swing.JLabel();
        lblPlayer = new javax.swing.JLabel();
        lblEnemy = new javax.swing.JLabel();
        panPlayerAcessorySlots = new javax.swing.JPanel();
        btnPlayerNecklace = new javax.swing.JButton();
        btnPlayerRing1 = new javax.swing.JButton();
        btnPlayerRing2 = new javax.swing.JButton();
        btnPlayerSheltom = new javax.swing.JButton();
        lblPlayerAcessorySlots = new javax.swing.JLabel();
        panPlayerDefenseSlots = new javax.swing.JPanel();
        btnPlayerBracelet = new javax.swing.JButton();
        btnPlayerGauntlet = new javax.swing.JButton();
        btnPlayerBoots = new javax.swing.JButton();
        lblPlayerDefenseSlots = new javax.swing.JLabel();
        panPlayerMainGearSlots = new javax.swing.JPanel();
        btnPlayerWeapon1 = new javax.swing.JButton();
        btnPlayerWeapon2 = new javax.swing.JButton();
        btnPlayerShield = new javax.swing.JButton();
        btnPlayerArmor = new javax.swing.JButton();
        lblPlayerMainGearSlots = new javax.swing.JLabel();
        panEnemyAcessorySlots = new javax.swing.JPanel();
        btnEnemyNecklace = new javax.swing.JButton();
        btnEnemyRing1 = new javax.swing.JButton();
        btnEnemyRing2 = new javax.swing.JButton();
        btnEnemySheltom = new javax.swing.JButton();
        lblEnemyAcessorySlots = new javax.swing.JLabel();
        panEnemyDefenseSlots = new javax.swing.JPanel();
        btnEnemyBracelet = new javax.swing.JButton();
        btnEnemyGauntlet = new javax.swing.JButton();
        btnEnemyBoots = new javax.swing.JButton();
        lblEnemyDefenseSlots = new javax.swing.JLabel();
        panEnemyMainGearSlots = new javax.swing.JPanel();
        btnEnemyWeapon1 = new javax.swing.JButton();
        btnEnemyArmor = new javax.swing.JButton();
        btnEnemyShield = new javax.swing.JButton();
        btnEnemyWeapon2 = new javax.swing.JButton();
        lblEnemyMainGearSlots = new javax.swing.JLabel();
        lblFraseAjuda = new javax.swing.JLabel();
        lblPlayerClassName = new javax.swing.JLabel();
        lblEnemyClassName = new javax.swing.JLabel();
        lblBackground1 = new javax.swing.JLabel();
        lblBackground2 = new javax.swing.JLabel();
        lblWhiteFlash = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(800, 630));
        setResizable(false);
        getContentPane().setLayout(null);

        btnPlayStopBGM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/btnBGM.png"))); // NOI18N
        btnPlayStopBGM.setBorder(null);
        btnPlayStopBGM.setBorderPainted(false);
        btnPlayStopBGM.setContentAreaFilled(false);
        btnPlayStopBGM.setFocusPainted(false);
        btnPlayStopBGM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayStopBGMActionPerformed(evt);
            }
        });
        getContentPane().add(btnPlayStopBGM);
        btnPlayStopBGM.setBounds(740, 10, 30, 30);

        btnSwapChar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/btnInverter.png"))); // NOI18N
        btnSwapChar.setBorder(null);
        btnSwapChar.setBorderPainted(false);
        btnSwapChar.setContentAreaFilled(false);
        btnSwapChar.setFocusPainted(false);
        btnSwapChar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwapCharActionPerformed(evt);
            }
        });
        getContentPane().add(btnSwapChar);
        btnSwapChar.setBounds(700, 10, 30, 30);

        btnHideGUI.setText("Hide");
        btnHideGUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHideGUIActionPerformed(evt);
            }
        });
        getContentPane().add(btnHideGUI);
        btnHideGUI.setBounds(365, 570, 70, 23);

        panPlayerStats.setOpaque(false);
        panPlayerStats.setLayout(null);

        txtPlayerName.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtPlayerName.setText("DarkLink64");
        txtPlayerName.setBorder(null);
        txtPlayerName.setOpaque(false);
        panPlayerStats.add(txtPlayerName);
        txtPlayerName.setBounds(20, 31, 120, 20);

        txtPLevel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtPLevel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPLevel.setText("155");
        txtPLevel.setBorder(null);
        txtPLevel.setOpaque(false);
        panPlayerStats.add(txtPLevel);
        txtPLevel.setBounds(89, 57, 54, 13);

        txtPStrenght.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtPStrenght.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPStrenght.setText("155");
        txtPStrenght.setBorder(null);
        txtPStrenght.setOpaque(false);
        panPlayerStats.add(txtPStrenght);
        txtPStrenght.setBounds(89, 97, 54, 13);

        txtPSpirit.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtPSpirit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPSpirit.setText("155");
        txtPSpirit.setBorder(null);
        txtPSpirit.setOpaque(false);
        panPlayerStats.add(txtPSpirit);
        txtPSpirit.setBounds(89, 116, 54, 13);

        txtPTalent.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtPTalent.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPTalent.setText("155");
        txtPTalent.setBorder(null);
        txtPTalent.setOpaque(false);
        panPlayerStats.add(txtPTalent);
        txtPTalent.setBounds(89, 136, 54, 13);

        txtPAgility.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtPAgility.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPAgility.setText("155");
        txtPAgility.setBorder(null);
        txtPAgility.setOpaque(false);
        panPlayerStats.add(txtPAgility);
        txtPAgility.setBounds(89, 156, 54, 13);

        txtPHealth.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtPHealth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPHealth.setText("155");
        txtPHealth.setBorder(null);
        txtPHealth.setOpaque(false);
        panPlayerStats.add(txtPHealth);
        txtPHealth.setBounds(89, 176, 54, 13);

        txtPRemainStats.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtPRemainStats.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPRemainStats.setText("155");
        txtPRemainStats.setBorder(null);
        txtPRemainStats.setFocusable(false);
        txtPRemainStats.setOpaque(false);
        panPlayerStats.add(txtPRemainStats);
        txtPRemainStats.setBounds(89, 217, 54, 13);

        lblPlayerStats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/playerStatsFields.png"))); // NOI18N
        panPlayerStats.add(lblPlayerStats);
        lblPlayerStats.setBounds(0, 0, 161, 250);

        getContentPane().add(panPlayerStats);
        panPlayerStats.setBounds(-171, 140, 161, 250);

        panEnemyStats.setOpaque(false);
        panEnemyStats.setLayout(null);

        txtEnemyName.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtEnemyName.setText("DarkLink64");
        txtEnemyName.setBorder(null);
        txtEnemyName.setOpaque(false);
        panEnemyStats.add(txtEnemyName);
        txtEnemyName.setBounds(20, 31, 120, 20);

        txtELevel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtELevel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtELevel.setText("155");
        txtELevel.setBorder(null);
        txtELevel.setOpaque(false);
        panEnemyStats.add(txtELevel);
        txtELevel.setBounds(89, 57, 54, 13);

        txtEStrenght.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtEStrenght.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEStrenght.setText("155");
        txtEStrenght.setBorder(null);
        txtEStrenght.setOpaque(false);
        panEnemyStats.add(txtEStrenght);
        txtEStrenght.setBounds(89, 97, 54, 13);

        txtESpirit.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtESpirit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtESpirit.setText("155");
        txtESpirit.setBorder(null);
        txtESpirit.setOpaque(false);
        panEnemyStats.add(txtESpirit);
        txtESpirit.setBounds(89, 116, 54, 13);

        txtETalent.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtETalent.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtETalent.setText("155");
        txtETalent.setBorder(null);
        txtETalent.setOpaque(false);
        panEnemyStats.add(txtETalent);
        txtETalent.setBounds(89, 136, 54, 13);

        txtEAgility.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtEAgility.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEAgility.setText("155");
        txtEAgility.setBorder(null);
        txtEAgility.setOpaque(false);
        panEnemyStats.add(txtEAgility);
        txtEAgility.setBounds(89, 156, 54, 13);

        txtEHealth.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtEHealth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEHealth.setText("155");
        txtEHealth.setBorder(null);
        txtEHealth.setOpaque(false);
        panEnemyStats.add(txtEHealth);
        txtEHealth.setBounds(89, 176, 54, 13);

        txtERemainStats.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtERemainStats.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtERemainStats.setText("155");
        txtERemainStats.setBorder(null);
        txtERemainStats.setFocusable(false);
        txtERemainStats.setOpaque(false);
        panEnemyStats.add(txtERemainStats);
        txtERemainStats.setBounds(89, 217, 54, 13);

        lblEnemyStats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/enemyStatsFields.png"))); // NOI18N
        panEnemyStats.add(lblEnemyStats);
        lblEnemyStats.setBounds(0, 0, 161, 250);

        getContentPane().add(panEnemyStats);
        panEnemyStats.setBounds(871, 140, 161, 250);
        getContentPane().add(lblPlayer);
        lblPlayer.setBounds(-500, 0, 500, 480);

        lblEnemy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lblEnemy);
        lblEnemy.setBounds(810, 0, 500, 480);

        panPlayerAcessorySlots.setOpaque(false);
        panPlayerAcessorySlots.setLayout(null);

        btnPlayerNecklace.setBorder(null);
        btnPlayerNecklace.setBorderPainted(false);
        btnPlayerNecklace.setContentAreaFilled(false);
        btnPlayerNecklace.setFocusPainted(false);
        btnPlayerNecklace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerNecklaceActionPerformed(evt);
            }
        });
        panPlayerAcessorySlots.add(btnPlayerNecklace);
        btnPlayerNecklace.setBounds(2, 2, 23, 23);

        btnPlayerRing1.setBorder(null);
        btnPlayerRing1.setBorderPainted(false);
        btnPlayerRing1.setContentAreaFilled(false);
        btnPlayerRing1.setFocusPainted(false);
        btnPlayerRing1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerRing1ActionPerformed(evt);
            }
        });
        panPlayerAcessorySlots.add(btnPlayerRing1);
        btnPlayerRing1.setBounds(28, 2, 23, 23);

        btnPlayerRing2.setBorder(null);
        btnPlayerRing2.setBorderPainted(false);
        btnPlayerRing2.setContentAreaFilled(false);
        btnPlayerRing2.setFocusPainted(false);
        btnPlayerRing2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerRing2ActionPerformed(evt);
            }
        });
        panPlayerAcessorySlots.add(btnPlayerRing2);
        btnPlayerRing2.setBounds(54, 2, 23, 23);

        btnPlayerSheltom.setBorder(null);
        btnPlayerSheltom.setBorderPainted(false);
        btnPlayerSheltom.setContentAreaFilled(false);
        btnPlayerSheltom.setFocusPainted(false);
        btnPlayerSheltom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerSheltomActionPerformed(evt);
            }
        });
        panPlayerAcessorySlots.add(btnPlayerSheltom);
        btnPlayerSheltom.setBounds(80, 2, 23, 23);

        lblPlayerAcessorySlots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/acessorySlots.png"))); // NOI18N
        lblPlayerAcessorySlots.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panPlayerAcessorySlots.add(lblPlayerAcessorySlots);
        lblPlayerAcessorySlots.setBounds(0, 0, 105, 27);

        getContentPane().add(panPlayerAcessorySlots);
        panPlayerAcessorySlots.setBounds(-150, 415, 105, 27);

        panPlayerDefenseSlots.setOpaque(false);
        panPlayerDefenseSlots.setLayout(null);

        btnPlayerBracelet.setBorder(null);
        btnPlayerBracelet.setBorderPainted(false);
        btnPlayerBracelet.setContentAreaFilled(false);
        btnPlayerBracelet.setFocusPainted(false);
        btnPlayerBracelet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerBraceletActionPerformed(evt);
            }
        });
        panPlayerDefenseSlots.add(btnPlayerBracelet);
        btnPlayerBracelet.setBounds(2, 2, 45, 45);

        btnPlayerGauntlet.setBorder(null);
        btnPlayerGauntlet.setBorderPainted(false);
        btnPlayerGauntlet.setContentAreaFilled(false);
        btnPlayerGauntlet.setFocusPainted(false);
        btnPlayerGauntlet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerGauntletActionPerformed(evt);
            }
        });
        panPlayerDefenseSlots.add(btnPlayerGauntlet);
        btnPlayerGauntlet.setBounds(50, 2, 45, 45);

        btnPlayerBoots.setBorder(null);
        btnPlayerBoots.setBorderPainted(false);
        btnPlayerBoots.setContentAreaFilled(false);
        btnPlayerBoots.setFocusPainted(false);
        btnPlayerBoots.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerBootsActionPerformed(evt);
            }
        });
        panPlayerDefenseSlots.add(btnPlayerBoots);
        btnPlayerBoots.setBounds(98, 2, 45, 45);

        lblPlayerDefenseSlots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/defenseSlots.png"))); // NOI18N
        lblPlayerDefenseSlots.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panPlayerDefenseSlots.add(lblPlayerDefenseSlots);
        lblPlayerDefenseSlots.setBounds(0, 0, 145, 49);

        getContentPane().add(panPlayerDefenseSlots);
        panPlayerDefenseSlots.setBounds(-150, 415, 145, 49);

        panPlayerMainGearSlots.setOpaque(false);
        panPlayerMainGearSlots.setLayout(null);

        btnPlayerWeapon1.setBorder(null);
        btnPlayerWeapon1.setBorderPainted(false);
        btnPlayerWeapon1.setContentAreaFilled(false);
        btnPlayerWeapon1.setFocusPainted(false);
        btnPlayerWeapon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerWeapon1ActionPerformed(evt);
            }
        });
        panPlayerMainGearSlots.add(btnPlayerWeapon1);
        btnPlayerWeapon1.setBounds(8, 7, 67, 112);

        btnPlayerWeapon2.setBorder(null);
        btnPlayerWeapon2.setBorderPainted(false);
        btnPlayerWeapon2.setContentAreaFilled(false);
        btnPlayerWeapon2.setFocusPainted(false);
        btnPlayerWeapon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerWeapon2ActionPerformed(evt);
            }
        });
        panPlayerMainGearSlots.add(btnPlayerWeapon2);
        btnPlayerWeapon2.setBounds(230, 7, 67, 112);

        btnPlayerShield.setBorder(null);
        btnPlayerShield.setBorderPainted(false);
        btnPlayerShield.setContentAreaFilled(false);
        btnPlayerShield.setFocusPainted(false);
        btnPlayerShield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerShieldActionPerformed(evt);
            }
        });
        panPlayerMainGearSlots.add(btnPlayerShield);
        btnPlayerShield.setBounds(156, 7, 67, 112);

        btnPlayerArmor.setBorder(null);
        btnPlayerArmor.setBorderPainted(false);
        btnPlayerArmor.setContentAreaFilled(false);
        btnPlayerArmor.setFocusPainted(false);
        btnPlayerArmor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerArmorActionPerformed(evt);
            }
        });
        panPlayerMainGearSlots.add(btnPlayerArmor);
        btnPlayerArmor.setBounds(83, 7, 67, 112);

        lblPlayerMainGearSlots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/mainGearsSlots.png"))); // NOI18N
        lblPlayerMainGearSlots.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panPlayerMainGearSlots.add(lblPlayerMainGearSlots);
        lblPlayerMainGearSlots.setBounds(0, 0, 303, 127);

        getContentPane().add(panPlayerMainGearSlots);
        panPlayerMainGearSlots.setBounds(-350, 470, 303, 127);

        panEnemyAcessorySlots.setOpaque(false);
        panEnemyAcessorySlots.setLayout(null);

        btnEnemyNecklace.setBorder(null);
        btnEnemyNecklace.setBorderPainted(false);
        btnEnemyNecklace.setContentAreaFilled(false);
        btnEnemyNecklace.setFocusPainted(false);
        btnEnemyNecklace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemyNecklaceActionPerformed(evt);
            }
        });
        panEnemyAcessorySlots.add(btnEnemyNecklace);
        btnEnemyNecklace.setBounds(2, 2, 23, 23);

        btnEnemyRing1.setBorder(null);
        btnEnemyRing1.setBorderPainted(false);
        btnEnemyRing1.setContentAreaFilled(false);
        btnEnemyRing1.setFocusPainted(false);
        btnEnemyRing1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemyRing1ActionPerformed(evt);
            }
        });
        panEnemyAcessorySlots.add(btnEnemyRing1);
        btnEnemyRing1.setBounds(28, 2, 23, 23);

        btnEnemyRing2.setBorder(null);
        btnEnemyRing2.setBorderPainted(false);
        btnEnemyRing2.setContentAreaFilled(false);
        btnEnemyRing2.setFocusPainted(false);
        btnEnemyRing2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemyRing2ActionPerformed(evt);
            }
        });
        panEnemyAcessorySlots.add(btnEnemyRing2);
        btnEnemyRing2.setBounds(54, 2, 23, 23);

        btnEnemySheltom.setBorder(null);
        btnEnemySheltom.setBorderPainted(false);
        btnEnemySheltom.setContentAreaFilled(false);
        btnEnemySheltom.setFocusPainted(false);
        btnEnemySheltom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemySheltomActionPerformed(evt);
            }
        });
        panEnemyAcessorySlots.add(btnEnemySheltom);
        btnEnemySheltom.setBounds(80, 2, 23, 23);

        lblEnemyAcessorySlots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/acessorySlots.png"))); // NOI18N
        lblEnemyAcessorySlots.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panEnemyAcessorySlots.add(lblEnemyAcessorySlots);
        lblEnemyAcessorySlots.setBounds(0, 0, 105, 27);

        getContentPane().add(panEnemyAcessorySlots);
        panEnemyAcessorySlots.setBounds(810, 415, 105, 27);

        panEnemyDefenseSlots.setOpaque(false);
        panEnemyDefenseSlots.setLayout(null);

        btnEnemyBracelet.setBorder(null);
        btnEnemyBracelet.setBorderPainted(false);
        btnEnemyBracelet.setContentAreaFilled(false);
        btnEnemyBracelet.setFocusPainted(false);
        btnEnemyBracelet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemyBraceletActionPerformed(evt);
            }
        });
        panEnemyDefenseSlots.add(btnEnemyBracelet);
        btnEnemyBracelet.setBounds(2, 2, 45, 45);

        btnEnemyGauntlet.setBorder(null);
        btnEnemyGauntlet.setBorderPainted(false);
        btnEnemyGauntlet.setContentAreaFilled(false);
        btnEnemyGauntlet.setFocusPainted(false);
        btnEnemyGauntlet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemyGauntletActionPerformed(evt);
            }
        });
        panEnemyDefenseSlots.add(btnEnemyGauntlet);
        btnEnemyGauntlet.setBounds(50, 2, 45, 45);

        btnEnemyBoots.setBorder(null);
        btnEnemyBoots.setBorderPainted(false);
        btnEnemyBoots.setContentAreaFilled(false);
        btnEnemyBoots.setFocusPainted(false);
        btnEnemyBoots.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemyBootsActionPerformed(evt);
            }
        });
        panEnemyDefenseSlots.add(btnEnemyBoots);
        btnEnemyBoots.setBounds(98, 2, 45, 45);

        lblEnemyDefenseSlots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/defenseSlots.png"))); // NOI18N
        lblEnemyDefenseSlots.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panEnemyDefenseSlots.add(lblEnemyDefenseSlots);
        lblEnemyDefenseSlots.setBounds(0, 0, 145, 49);

        getContentPane().add(panEnemyDefenseSlots);
        panEnemyDefenseSlots.setBounds(810, 415, 145, 49);

        panEnemyMainGearSlots.setOpaque(false);
        panEnemyMainGearSlots.setLayout(null);

        btnEnemyWeapon1.setBorder(null);
        btnEnemyWeapon1.setBorderPainted(false);
        btnEnemyWeapon1.setContentAreaFilled(false);
        btnEnemyWeapon1.setFocusPainted(false);
        btnEnemyWeapon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemyWeapon1ActionPerformed(evt);
            }
        });
        panEnemyMainGearSlots.add(btnEnemyWeapon1);
        btnEnemyWeapon1.setBounds(8, 7, 67, 112);

        btnEnemyArmor.setBorder(null);
        btnEnemyArmor.setBorderPainted(false);
        btnEnemyArmor.setContentAreaFilled(false);
        btnEnemyArmor.setFocusPainted(false);
        btnEnemyArmor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemyArmorActionPerformed(evt);
            }
        });
        panEnemyMainGearSlots.add(btnEnemyArmor);
        btnEnemyArmor.setBounds(83, 7, 67, 112);

        btnEnemyShield.setBorder(null);
        btnEnemyShield.setBorderPainted(false);
        btnEnemyShield.setContentAreaFilled(false);
        btnEnemyShield.setFocusPainted(false);
        btnEnemyShield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemyShieldActionPerformed(evt);
            }
        });
        panEnemyMainGearSlots.add(btnEnemyShield);
        btnEnemyShield.setBounds(156, 7, 67, 112);

        btnEnemyWeapon2.setBorder(null);
        btnEnemyWeapon2.setBorderPainted(false);
        btnEnemyWeapon2.setContentAreaFilled(false);
        btnEnemyWeapon2.setFocusPainted(false);
        btnEnemyWeapon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemyWeapon2ActionPerformed(evt);
            }
        });
        panEnemyMainGearSlots.add(btnEnemyWeapon2);
        btnEnemyWeapon2.setBounds(230, 7, 67, 112);

        lblEnemyMainGearSlots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/mainGearsSlots.png"))); // NOI18N
        lblEnemyMainGearSlots.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panEnemyMainGearSlots.add(lblEnemyMainGearSlots);
        lblEnemyMainGearSlots.setBounds(0, 0, 303, 127);

        getContentPane().add(panEnemyMainGearSlots);
        panEnemyMainGearSlots.setBounds(810, 470, 303, 127);

        lblFraseAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/fraseBuild.png"))); // NOI18N
        getContentPane().add(lblFraseAjuda);
        lblFraseAjuda.setBounds(0, -50, 618, 40);

        lblPlayerClassName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classtitle/KnightName.png"))); // NOI18N
        getContentPane().add(lblPlayerClassName);
        lblPlayerClassName.setBounds(-220, 40, 210, 40);

        lblEnemyClassName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classtitle/KnightName.png"))); // NOI18N
        getContentPane().add(lblEnemyClassName);
        lblEnemyClassName.setBounds(810, 40, 210, 40);
        getContentPane().add(lblBackground1);
        lblBackground1.setBounds(12, 20, 0, 0);

        lblBackground2.setName(""); // NOI18N
        getContentPane().add(lblBackground2);
        lblBackground2.setBounds(12, 47, 0, 0);
        getContentPane().add(lblWhiteFlash);
        lblWhiteFlash.setBounds(0, 0, 0, 0);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayStopBGMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayStopBGMActionPerformed
        music.playPause(btnPlayStopBGM);
    }//GEN-LAST:event_btnPlayStopBGMActionPerformed

    private void btnPlayerNecklaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerNecklaceActionPerformed
        //equipGear("Knight", "Necklace", btnPlayerNecklace);
    }//GEN-LAST:event_btnPlayerNecklaceActionPerformed

    private void btnPlayerRing1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerRing1ActionPerformed
        //equipGear("Knight", "Ring1", btnPlayerRing1);
    }//GEN-LAST:event_btnPlayerRing1ActionPerformed

    private void btnPlayerRing2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerRing2ActionPerformed
        //equipGear("Knight", "Ring2", btnPlayerRing2);
    }//GEN-LAST:event_btnPlayerRing2ActionPerformed

    private void btnPlayerSheltomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerSheltomActionPerformed
        //equipGear("Knight", "Sheltom", btnPlayerSheltom);
    }//GEN-LAST:event_btnPlayerSheltomActionPerformed

    private void btnPlayerBraceletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerBraceletActionPerformed
       // equipGear("Knight", "Bracelet", btnPlayerBracelet);
    }//GEN-LAST:event_btnPlayerBraceletActionPerformed

    private void btnPlayerGauntletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerGauntletActionPerformed
       // equipGear("Knight", "Gauntlet", btnPlayerGauntlet);
    }//GEN-LAST:event_btnPlayerGauntletActionPerformed

    private void btnPlayerBootsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerBootsActionPerformed
       // equipGear("Knight", "Boots", btnPlayerBoots);
    }//GEN-LAST:event_btnPlayerBootsActionPerformed

    private void btnPlayerWeapon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerWeapon1ActionPerformed
       // equipGear("Knight", "Weapon1", btnPlayerWeapon1);
    }//GEN-LAST:event_btnPlayerWeapon1ActionPerformed

    private void btnPlayerWeapon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerWeapon2ActionPerformed
       // equipGear("Knight", "Weapon2", btnPlayerWeapon2);
    }//GEN-LAST:event_btnPlayerWeapon2ActionPerformed

    private void btnPlayerArmorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerArmorActionPerformed
       // equipGear("Knight", "Armor", btnPlayerArmor);
    }//GEN-LAST:event_btnPlayerArmorActionPerformed

    private void btnPlayerShieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerShieldActionPerformed
       // equipGear("Knight", "Shield1", btnPlayerShield);
    }//GEN-LAST:event_btnPlayerShieldActionPerformed

    private void btnEnemyNecklaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyNecklaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnemyNecklaceActionPerformed

    private void btnEnemyRing1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyRing1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnemyRing1ActionPerformed

    private void btnEnemyRing2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyRing2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnemyRing2ActionPerformed

    private void btnEnemySheltomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemySheltomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnemySheltomActionPerformed

    private void btnEnemyBraceletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyBraceletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnemyBraceletActionPerformed

    private void btnEnemyGauntletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyGauntletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnemyGauntletActionPerformed

    private void btnEnemyBootsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyBootsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnemyBootsActionPerformed

    private void btnEnemyWeapon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyWeapon1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnemyWeapon1ActionPerformed

    private void btnEnemyWeapon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyWeapon2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnemyWeapon2ActionPerformed

    private void btnEnemyShieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyShieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnemyShieldActionPerformed

    private void btnEnemyArmorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyArmorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnemyArmorActionPerformed

    private void btnSwapCharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwapCharActionPerformed
        backToCharSelect();        
    }//GEN-LAST:event_btnSwapCharActionPerformed

    private void btnHideGUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHideGUIActionPerformed
        hideShowGUI(flagHideGUI);
    }//GEN-LAST:event_btnHideGUIActionPerformed

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
            java.util.logging.Logger.getLogger(CharBuildFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CharBuildFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CharBuildFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CharBuildFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CharBuildFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnemyArmor;
    private javax.swing.JButton btnEnemyBoots;
    private javax.swing.JButton btnEnemyBracelet;
    private javax.swing.JButton btnEnemyGauntlet;
    private javax.swing.JButton btnEnemyNecklace;
    private javax.swing.JButton btnEnemyRing1;
    private javax.swing.JButton btnEnemyRing2;
    private javax.swing.JButton btnEnemySheltom;
    private javax.swing.JButton btnEnemyShield;
    private javax.swing.JButton btnEnemyWeapon1;
    private javax.swing.JButton btnEnemyWeapon2;
    private javax.swing.JButton btnHideGUI;
    private javax.swing.JButton btnPlayStopBGM;
    private javax.swing.JButton btnPlayerArmor;
    private javax.swing.JButton btnPlayerBoots;
    private javax.swing.JButton btnPlayerBracelet;
    private javax.swing.JButton btnPlayerGauntlet;
    private javax.swing.JButton btnPlayerNecklace;
    private javax.swing.JButton btnPlayerRing1;
    private javax.swing.JButton btnPlayerRing2;
    private javax.swing.JButton btnPlayerSheltom;
    private javax.swing.JButton btnPlayerShield;
    private javax.swing.JButton btnPlayerWeapon1;
    private javax.swing.JButton btnPlayerWeapon2;
    private javax.swing.JButton btnSwapChar;
    private javax.swing.JLabel lblBackground1;
    private javax.swing.JLabel lblBackground2;
    private javax.swing.JLabel lblEnemy;
    private javax.swing.JLabel lblEnemyAcessorySlots;
    private javax.swing.JLabel lblEnemyClassName;
    private javax.swing.JLabel lblEnemyDefenseSlots;
    private javax.swing.JLabel lblEnemyMainGearSlots;
    private javax.swing.JLabel lblEnemyStats;
    private javax.swing.JLabel lblFraseAjuda;
    private javax.swing.JLabel lblPlayer;
    private javax.swing.JLabel lblPlayerAcessorySlots;
    private javax.swing.JLabel lblPlayerClassName;
    private javax.swing.JLabel lblPlayerDefenseSlots;
    private javax.swing.JLabel lblPlayerMainGearSlots;
    private javax.swing.JLabel lblPlayerStats;
    private javax.swing.JLabel lblWhiteFlash;
    private javax.swing.JPanel panEnemyAcessorySlots;
    private javax.swing.JPanel panEnemyDefenseSlots;
    private javax.swing.JPanel panEnemyMainGearSlots;
    private javax.swing.JPanel panEnemyStats;
    private javax.swing.JPanel panPlayerAcessorySlots;
    private javax.swing.JPanel panPlayerDefenseSlots;
    private javax.swing.JPanel panPlayerMainGearSlots;
    private javax.swing.JPanel panPlayerStats;
    private javax.swing.JTextField txtEAgility;
    private javax.swing.JTextField txtEHealth;
    private javax.swing.JTextField txtELevel;
    private javax.swing.JTextField txtERemainStats;
    private javax.swing.JTextField txtESpirit;
    private javax.swing.JTextField txtEStrenght;
    private javax.swing.JTextField txtETalent;
    private javax.swing.JTextField txtEnemyName;
    private javax.swing.JTextField txtPAgility;
    private javax.swing.JTextField txtPHealth;
    private javax.swing.JTextField txtPLevel;
    private javax.swing.JTextField txtPRemainStats;
    private javax.swing.JTextField txtPSpirit;
    private javax.swing.JTextField txtPStrenght;
    private javax.swing.JTextField txtPTalent;
    private javax.swing.JTextField txtPlayerName;
    // End of variables declaration//GEN-END:variables

    private void animateBackgrounds() {
        int fps = 50;
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
            System.out.print("Animação Velocidade X:");
            //animSpeedX = gerarRng(1, 2);
            animSpeedX = 1;
            System.out.print("Animation Velocidade Y:");
            //animSpeedY = gerarRng(1, 2);
            animSpeedY = 1;

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
        this.getContentPane().setComponentZOrder(bg, 16+z);
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

    private void buildTrackList() {
        trackList.add("tos_SoundTeMP_Topaz.mp3");
        trackList.add("tos_SFA_The_Dignity_of_Wrath.mp3");
    }
    
    private void popularListaPlayer(){
        listPlayer.add(panPlayerAcessorySlots);
        listPlayer.add(panPlayerDefenseSlots);
        listPlayer.add(panPlayerMainGearSlots);
        Collections.shuffle(listPlayer);
    }
    
    private void popularListaEnemy(){
        listEnemy.add(panEnemyAcessorySlots);
        listEnemy.add(panEnemyDefenseSlots);
        listEnemy.add(panEnemyMainGearSlots);
        Collections.shuffle(listEnemy);
    }

    private void hideShowGUI(boolean flagHideGUI) {
        if (flagHideGUI){
            lblPlayer.setVisible(flagHideGUI);
            lblEnemy.setVisible(flagHideGUI);
            btnPlayStopBGM.setVisible(flagHideGUI);
            btnSwapChar.setVisible(flagHideGUI);
            panEnemyAcessorySlots.setVisible(flagHideGUI);
            panEnemyDefenseSlots.setVisible(flagHideGUI);
            panEnemyMainGearSlots.setVisible(flagHideGUI);
            panPlayerAcessorySlots.setVisible(flagHideGUI);
            panPlayerDefenseSlots.setVisible(flagHideGUI);
            panPlayerMainGearSlots.setVisible(flagHideGUI);
            lblPlayerClassName.setVisible(flagHideGUI);
            lblEnemyClassName.setVisible(flagHideGUI);
            lblFraseAjuda.setVisible(flagHideGUI);
            panPlayerStats.setVisible(flagHideGUI);
            panEnemyStats.setVisible(flagHideGUI);
            
            
            this.flagHideGUI = false;
            btnHideGUI.setText("Hide");
        } else {
            lblPlayer.setVisible(flagHideGUI);
            lblEnemy.setVisible(flagHideGUI);
            btnPlayStopBGM.setVisible(flagHideGUI);
            btnSwapChar.setVisible(flagHideGUI);
            panEnemyAcessorySlots.setVisible(flagHideGUI);
            panEnemyDefenseSlots.setVisible(flagHideGUI);
            panEnemyMainGearSlots.setVisible(flagHideGUI);
            panPlayerAcessorySlots.setVisible(flagHideGUI);
            panPlayerDefenseSlots.setVisible(flagHideGUI);
            panPlayerMainGearSlots.setVisible(flagHideGUI);
            lblPlayerClassName.setVisible(flagHideGUI);
            lblEnemyClassName.setVisible(flagHideGUI);
            lblFraseAjuda.setVisible(flagHideGUI);
            panPlayerStats.setVisible(flagHideGUI);
            panEnemyStats.setVisible(flagHideGUI);
            this.flagHideGUI = true;
            btnHideGUI.setText("Show");
        }
    }
    
    public Point getFrameLocation(){
        return this.getLocation();
    }

    private void backToCharSelect() {
        sfx.playSound("GameStart.wav");
                    //System.out.println(this.getContentPane().getComponentZOrder(btnArcher));
                    lblWhiteFlash.setSize(800, 600);
                    this.getContentPane().setComponentZOrder(lblWhiteFlash, 0);
                    FadeInOut fadeScreen = new FadeInOut();
                    fadeScreen.fade(lblWhiteFlash, 5, 30, "/assets/images/blackbg.png", true, false, 0);
                    Timer t = new Timer();                    
                    TimerTask closeScreen = new TimerTask() {
                        public void run() {
                            counter++;
                            if (counter == 3) {
                                music.close();                                timer.cancel();
                                timer2.cancel();
                                CharSelectFrame charSelectWindow = new CharSelectFrame();
                                charSelectWindow.setLocation(getFrameLocation());
                                charSelectWindow.setVisible(true);     
                                
                                dispose();
                                t.cancel();                                                           
                            }
                        }
                    };
                    t.scheduleAtFixedRate(closeScreen, 10, 1000);
    }

    private void setFiltroTexto() {
        PlainDocument document = (PlainDocument) txtPLevel.getDocument();
        document.setDocumentFilter(new FiltroTexto());
        PlainDocument document2 = (PlainDocument) txtPStrenght.getDocument();
        document2.setDocumentFilter(new FiltroTexto());
        PlainDocument document3 = (PlainDocument) txtPSpirit.getDocument();
        document3.setDocumentFilter(new FiltroTexto());
        PlainDocument document4 = (PlainDocument) txtPTalent.getDocument();
        document4.setDocumentFilter(new FiltroTexto());
        PlainDocument document5 = (PlainDocument) txtPAgility.getDocument();
        document5.setDocumentFilter(new FiltroTexto());
        PlainDocument document6 = (PlainDocument) txtPHealth.getDocument();
        document6.setDocumentFilter(new FiltroTexto());
        
        
        
        
        
    }
}
