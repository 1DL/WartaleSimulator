/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import animation.FadeInOut;
import animation.ShowCharSelectBtn;
import animation.CharSelect;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javazoom.jl.decoder.JavaLayerException;

/**
 *
 * @author Administrator
 */
public class CharSelectFrame extends javax.swing.JFrame {
    int counter = 0;
    int indexArrayBtn = 0;
    int bgAnimCounter = 0;
    ArrayList<JButton> listTempskron = new ArrayList<>();
    ArrayList<JButton> listMorion = new ArrayList<>();
    CharSelect animPlayer = new CharSelect();
    CharSelect animEnemy = new CharSelect();
    boolean playerSet = false;
    boolean enemySet = false;
    Mp3 music;
    Sound sfx = new Sound();
    String playerChar = "";
    String enemyChar = "";
    Timer timer = new Timer();
    Timer timer2 = new Timer();
    int xModifier = 0;
    int xEModifier = 0;

    /**
     * Creates new form CharSelectFrame
     */
    public CharSelectFrame() {

        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lblWhiteFlash.setSize(0, 0);
        lblPlayerClassName.setVisible(false);
        lblEnemyClassName.setVisible(false);
        showStatsPlayer(false);
        showStatsEnemy(false);
        popularListaTempskronBtn();
        popularListaMorionBtn();

        TimerTask showCharButtons = new TimerTask() {
            public void run() {

                if (indexArrayBtn <= 4) {
                    ShowCharSelectBtn scsb = new ShowCharSelectBtn();
                    scsb.showUp(listTempskron.get(indexArrayBtn), 390, 0, 25, true);
                } else if (indexArrayBtn <= 9) {
                    ShowCharSelectBtn scsb = new ShowCharSelectBtn();
                    scsb.showUp(listMorion.get(indexArrayBtn - 5), 490, 0, 15, true);
                } else {
                    timer.cancel();
                }
                indexArrayBtn++;
            }
        };
        TimerTask animateBackground = new TimerTask() {
            public void run() {

                if (bgAnimCounter < 8) {
                    Point p;
                    p = lblBackground.getLocation();
                    p.y += 1;
                    lblBackground.setLocation(p);

                    p = lblPlayer.getLocation();
                    p.y += 1;
                    lblPlayer.setLocation(p);

                    p = lblEnemy.getLocation();
                    p.y += 1;
                    lblEnemy.setLocation(p);

                    bgAnimCounter++;
                } else if (bgAnimCounter >= 8 && bgAnimCounter <= 15) {
                    Point p;
                    p = lblBackground.getLocation();
                    p.y += -1;
                    lblBackground.setLocation(p);

                    p = lblPlayer.getLocation();
                    p.y += -1;
                    lblPlayer.setLocation(p);

                    p = lblEnemy.getLocation();
                    p.y += -1;
                    lblEnemy.setLocation(p);

                    bgAnimCounter++;
                } else {
                    bgAnimCounter = 0;
                }
            }
        };

        try {
            music = new Mp3("CharacterSelect.mp3");
            music.play();
        } catch (JavaLayerException ex) {
            Logger.getLogger(CharSelectFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CharSelectFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sfx.playSound("NewChar.wav");
        getContentPane().setBackground(Color.BLACK);
        FadeInOut fadeBackGround = new FadeInOut();
        fadeBackGround.animarFade(lblBackground, 5, 60, "/assets/images/charselectbackground.png", true, false, 0);
        timer.scheduleAtFixedRate(showCharButtons, 100, 100);
        timer2.scheduleAtFixedRate(animateBackground, 100, 120);

        CustomCursor();

        FadeInOut animVs = new FadeInOut();
        FadeInOut animTemps = new FadeInOut();
        FadeInOut animMorion = new FadeInOut();

        animVs.animarFade(lblVersus, 5, 60, "/assets/images/vs.png", true, false, 0);
        animTemps.animarFade(lblTempskrons, 5, 60, "/assets/images/logoTempskrons.png", true, false, 0);
        animMorion.animarFade(lblMorions, 5, 60, "/assets/images/logoMorions.png", true, false, 0);

        txtaPlayerDesc.setBackground(new Color(0, 0, 0, 0));
        txtaEnemyDesc.setBackground(new Color(0, 0, 0, 0));

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
        lblEnemySet = new javax.swing.JLabel();
        lblPlayerSet = new javax.swing.JLabel();
        lblEnemyClassName = new javax.swing.JLabel();
        lblPlayerClassName = new javax.swing.JLabel();
        txtaEnemyDesc = new javax.swing.JTextArea();
        txtaPlayerDesc = new javax.swing.JTextArea();
        lblEStr = new javax.swing.JLabel();
        lblEStrVal = new javax.swing.JLabel();
        barEStr = new javax.swing.JProgressBar();
        lblESpi = new javax.swing.JLabel();
        lblESpiVal = new javax.swing.JLabel();
        barESpi = new javax.swing.JProgressBar();
        lblETal = new javax.swing.JLabel();
        lblETalVal = new javax.swing.JLabel();
        barETal = new javax.swing.JProgressBar();
        lblEAgi = new javax.swing.JLabel();
        lblEAgiVal = new javax.swing.JLabel();
        barEAgi = new javax.swing.JProgressBar();
        lblEVit = new javax.swing.JLabel();
        barEVit = new javax.swing.JProgressBar();
        lblEVitVal = new javax.swing.JLabel();
        lblPSpi = new javax.swing.JLabel();
        lblPTal = new javax.swing.JLabel();
        barPTal = new javax.swing.JProgressBar();
        lblPAgi = new javax.swing.JLabel();
        barPAgi = new javax.swing.JProgressBar();
        lblPVit = new javax.swing.JLabel();
        barPVit = new javax.swing.JProgressBar();
        lblPSpiVal = new javax.swing.JLabel();
        barPStr = new javax.swing.JProgressBar();
        lblPStr = new javax.swing.JLabel();
        lblPTalVal = new javax.swing.JLabel();
        lblPAgiVal = new javax.swing.JLabel();
        lblPVitVal = new javax.swing.JLabel();
        lblPStrVal = new javax.swing.JLabel();
        barPSpi = new javax.swing.JProgressBar();
        lblTempskrons = new javax.swing.JLabel();
        lblMorions = new javax.swing.JLabel();
        btnArcher = new javax.swing.JButton();
        btnKnight = new javax.swing.JButton();
        btnMagician = new javax.swing.JButton();
        btnPriestess = new javax.swing.JButton();
        btnAtalanta = new javax.swing.JButton();
        btnShaman = new javax.swing.JButton();
        btnFighter = new javax.swing.JButton();
        btnAssassin = new javax.swing.JButton();
        btnMechanician = new javax.swing.JButton();
        btnPikeman = new javax.swing.JButton();
        lblVersus = new javax.swing.JLabel();
        lblEnemy = new javax.swing.JLabel();
        lblPlayer = new javax.swing.JLabel();
        btnDeselect = new javax.swing.JButton();
        lblWhiteFlash = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

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

        lblEnemySet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/EnemySet.png"))); // NOI18N
        getContentPane().add(lblEnemySet);
        lblEnemySet.setBounds(1000, 1000, 90, 30);

        lblPlayerSet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/PlayerSet.png"))); // NOI18N
        getContentPane().add(lblPlayerSet);
        lblPlayerSet.setBounds(1100, 1100, 90, 30);

        lblEnemyClassName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classtitle/KnightName.png"))); // NOI18N
        getContentPane().add(lblEnemyClassName);
        lblEnemyClassName.setBounds(480, 340, 210, 40);

        lblPlayerClassName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classtitle/KnightName.png"))); // NOI18N
        getContentPane().add(lblPlayerClassName);
        lblPlayerClassName.setBounds(120, 340, 210, 40);

        txtaEnemyDesc.setEditable(false);
        txtaEnemyDesc.setBackground(new java.awt.Color(0, 0, 0));
        txtaEnemyDesc.setColumns(20);
        txtaEnemyDesc.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        txtaEnemyDesc.setForeground(new java.awt.Color(255, 255, 255));
        txtaEnemyDesc.setLineWrap(true);
        txtaEnemyDesc.setRows(5);
        txtaEnemyDesc.setText("Knights are warriors of Morion with noble mind and stout body. Their attacking power comes from their religious mind, which represents the great power of Morion. They think about the body of oneself as pure, and train hard. When they use a sword, their holy powers are at their strongest. ");
        txtaEnemyDesc.setBorder(null);
        txtaEnemyDesc.setFocusable(false);
        txtaEnemyDesc.setOpaque(false);
        getContentPane().add(txtaEnemyDesc);
        txtaEnemyDesc.setBounds(600, 100, 180, 130);

        txtaPlayerDesc.setEditable(false);
        txtaPlayerDesc.setBackground(new java.awt.Color(0, 0, 0));
        txtaPlayerDesc.setColumns(20);
        txtaPlayerDesc.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        txtaPlayerDesc.setForeground(new java.awt.Color(255, 255, 255));
        txtaPlayerDesc.setLineWrap(true);
        txtaPlayerDesc.setRows(5);
        txtaPlayerDesc.setText("Knights are warriors of Morion with noble mind and stout body. Their attacking power comes from their religious mind, which represents the great power of Morion. They think about the body of oneself as pure, and train hard. When they use a sword, their holy powers are at their strongest. ");
        txtaPlayerDesc.setBorder(null);
        txtaPlayerDesc.setFocusable(false);
        txtaPlayerDesc.setOpaque(false);
        getContentPane().add(txtaPlayerDesc);
        txtaPlayerDesc.setBounds(10, 100, 180, 130);

        lblEStr.setForeground(new java.awt.Color(255, 255, 255));
        lblEStr.setText("Strenght: ");
        getContentPane().add(lblEStr);
        lblEStr.setBounds(703, 225, 60, 20);

        lblEStrVal.setForeground(new java.awt.Color(255, 255, 255));
        lblEStrVal.setText("26");
        getContentPane().add(lblEStrVal);
        lblEStrVal.setBounds(760, 225, 20, 20);

        barEStr.setMaximum(30);
        barEStr.setValue(26);
        getContentPane().add(barEStr);
        barEStr.setBounds(700, 240, 80, 16);

        lblESpi.setForeground(new java.awt.Color(255, 255, 255));
        lblESpi.setText("Spirit:");
        getContentPane().add(lblESpi);
        lblESpi.setBounds(703, 250, 50, 20);

        lblESpiVal.setForeground(new java.awt.Color(255, 255, 255));
        lblESpiVal.setText("13");
        getContentPane().add(lblESpiVal);
        lblESpiVal.setBounds(760, 250, 20, 20);

        barESpi.setMaximum(30);
        barESpi.setValue(13);
        getContentPane().add(barESpi);
        barESpi.setBounds(700, 265, 80, 16);

        lblETal.setForeground(new java.awt.Color(255, 255, 255));
        lblETal.setText("Talent:");
        getContentPane().add(lblETal);
        lblETal.setBounds(703, 275, 50, 20);

        lblETalVal.setForeground(new java.awt.Color(255, 255, 255));
        lblETalVal.setText("17");
        getContentPane().add(lblETalVal);
        lblETalVal.setBounds(760, 275, 20, 20);

        barETal.setMaximum(30);
        barETal.setValue(17);
        getContentPane().add(barETal);
        barETal.setBounds(700, 290, 80, 16);

        lblEAgi.setForeground(new java.awt.Color(255, 255, 255));
        lblEAgi.setText("Agility:");
        getContentPane().add(lblEAgi);
        lblEAgi.setBounds(703, 300, 50, 20);

        lblEAgiVal.setForeground(new java.awt.Color(255, 255, 255));
        lblEAgiVal.setText("19");
        getContentPane().add(lblEAgiVal);
        lblEAgiVal.setBounds(760, 300, 20, 20);

        barEAgi.setMaximum(30);
        barEAgi.setValue(19);
        getContentPane().add(barEAgi);
        barEAgi.setBounds(700, 315, 80, 16);

        lblEVit.setForeground(new java.awt.Color(255, 255, 255));
        lblEVit.setText("Health:");
        getContentPane().add(lblEVit);
        lblEVit.setBounds(703, 325, 50, 20);

        barEVit.setMaximum(30);
        barEVit.setValue(24);
        getContentPane().add(barEVit);
        barEVit.setBounds(700, 340, 80, 16);

        lblEVitVal.setForeground(new java.awt.Color(255, 255, 255));
        lblEVitVal.setText("24");
        getContentPane().add(lblEVitVal);
        lblEVitVal.setBounds(760, 325, 20, 20);

        lblPSpi.setForeground(new java.awt.Color(255, 255, 255));
        lblPSpi.setText("Spirit:");
        getContentPane().add(lblPSpi);
        lblPSpi.setBounds(13, 250, 50, 20);

        lblPTal.setForeground(new java.awt.Color(255, 255, 255));
        lblPTal.setText("Talent:");
        getContentPane().add(lblPTal);
        lblPTal.setBounds(13, 275, 50, 20);

        barPTal.setMaximum(30);
        barPTal.setValue(17);
        getContentPane().add(barPTal);
        barPTal.setBounds(10, 290, 80, 16);

        lblPAgi.setForeground(new java.awt.Color(255, 255, 255));
        lblPAgi.setText("Agility:");
        getContentPane().add(lblPAgi);
        lblPAgi.setBounds(13, 300, 50, 20);

        barPAgi.setMaximum(30);
        barPAgi.setValue(19);
        getContentPane().add(barPAgi);
        barPAgi.setBounds(10, 315, 80, 16);

        lblPVit.setForeground(new java.awt.Color(255, 255, 255));
        lblPVit.setText("Health:");
        getContentPane().add(lblPVit);
        lblPVit.setBounds(13, 325, 50, 20);

        barPVit.setMaximum(30);
        barPVit.setValue(24);
        getContentPane().add(barPVit);
        barPVit.setBounds(10, 340, 80, 16);

        lblPSpiVal.setForeground(new java.awt.Color(255, 255, 255));
        lblPSpiVal.setText("13");
        getContentPane().add(lblPSpiVal);
        lblPSpiVal.setBounds(70, 250, 20, 20);

        barPStr.setMaximum(30);
        barPStr.setValue(26);
        getContentPane().add(barPStr);
        barPStr.setBounds(10, 240, 80, 16);

        lblPStr.setForeground(new java.awt.Color(255, 255, 255));
        lblPStr.setText("Strenght: ");
        getContentPane().add(lblPStr);
        lblPStr.setBounds(13, 225, 60, 20);

        lblPTalVal.setForeground(new java.awt.Color(255, 255, 255));
        lblPTalVal.setText("17");
        getContentPane().add(lblPTalVal);
        lblPTalVal.setBounds(70, 275, 20, 20);

        lblPAgiVal.setForeground(new java.awt.Color(255, 255, 255));
        lblPAgiVal.setText("19");
        getContentPane().add(lblPAgiVal);
        lblPAgiVal.setBounds(70, 300, 20, 20);

        lblPVitVal.setForeground(new java.awt.Color(255, 255, 255));
        lblPVitVal.setText("24");
        getContentPane().add(lblPVitVal);
        lblPVitVal.setBounds(70, 325, 20, 20);

        lblPStrVal.setForeground(new java.awt.Color(255, 255, 255));
        lblPStrVal.setText("26");
        getContentPane().add(lblPStrVal);
        lblPStrVal.setBounds(70, 225, 20, 20);

        barPSpi.setMaximum(30);
        barPSpi.setValue(13);
        getContentPane().add(barPSpi);
        barPSpi.setBounds(10, 265, 80, 16);
        getContentPane().add(lblTempskrons);
        lblTempskrons.setBounds(20, 350, 126, 124);
        getContentPane().add(lblMorions);
        lblMorions.setBounds(20, 470, 126, 124);

        btnArcher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/archer.png"))); // NOI18N
        btnArcher.setBorderPainted(false);
        btnArcher.setContentAreaFilled(false);
        btnArcher.setFocusPainted(false);
        btnArcher.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/archer.png"))); // NOI18N
        btnArcher.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/archer_hover.png"))); // NOI18N
        btnArcher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnArcherMouseEntered(evt);
            }
        });
        btnArcher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArcherActionPerformed(evt);
            }
        });
        getContentPane().add(btnArcher);
        btnArcher.setBounds(190, 600, 88, 88);

        btnKnight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/knight.png"))); // NOI18N
        btnKnight.setBorderPainted(false);
        btnKnight.setContentAreaFilled(false);
        btnKnight.setFocusPainted(false);
        btnKnight.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/knight.png"))); // NOI18N
        btnKnight.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/knight_hover.png"))); // NOI18N
        btnKnight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnKnightMouseEntered(evt);
            }
        });
        btnKnight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKnightActionPerformed(evt);
            }
        });
        getContentPane().add(btnKnight);
        btnKnight.setBounds(290, 600, 88, 88);

        btnMagician.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/magician.png"))); // NOI18N
        btnMagician.setBorderPainted(false);
        btnMagician.setContentAreaFilled(false);
        btnMagician.setFocusPainted(false);
        btnMagician.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/magician.png"))); // NOI18N
        btnMagician.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/magician_hover.png"))); // NOI18N
        btnMagician.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMagicianMouseEntered(evt);
            }
        });
        btnMagician.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMagicianActionPerformed(evt);
            }
        });
        getContentPane().add(btnMagician);
        btnMagician.setBounds(490, 600, 88, 88);

        btnPriestess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/priestess.png"))); // NOI18N
        btnPriestess.setBorderPainted(false);
        btnPriestess.setContentAreaFilled(false);
        btnPriestess.setFocusPainted(false);
        btnPriestess.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/priestess.png"))); // NOI18N
        btnPriestess.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/priestess_hover.png"))); // NOI18N
        btnPriestess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPriestessMouseEntered(evt);
            }
        });
        btnPriestess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPriestessActionPerformed(evt);
            }
        });
        getContentPane().add(btnPriestess);
        btnPriestess.setBounds(590, 600, 88, 88);

        btnAtalanta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/atalanta.png"))); // NOI18N
        btnAtalanta.setBorderPainted(false);
        btnAtalanta.setContentAreaFilled(false);
        btnAtalanta.setFocusPainted(false);
        btnAtalanta.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/atalanta.png"))); // NOI18N
        btnAtalanta.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/atalanta_hover.png"))); // NOI18N
        btnAtalanta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAtalantaMouseEntered(evt);
            }
        });
        btnAtalanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtalantaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtalanta);
        btnAtalanta.setBounds(190, 600, 88, 88);

        btnShaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/shaman.png"))); // NOI18N
        btnShaman.setBorderPainted(false);
        btnShaman.setContentAreaFilled(false);
        btnShaman.setFocusPainted(false);
        btnShaman.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/shaman.png"))); // NOI18N
        btnShaman.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/shaman_hover.png"))); // NOI18N
        btnShaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnShamanMouseEntered(evt);
            }
        });
        btnShaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShamanActionPerformed(evt);
            }
        });
        getContentPane().add(btnShaman);
        btnShaman.setBounds(390, 600, 88, 88);

        btnFighter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/fighter.png"))); // NOI18N
        btnFighter.setBorderPainted(false);
        btnFighter.setContentAreaFilled(false);
        btnFighter.setFocusPainted(false);
        btnFighter.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/fighter.png"))); // NOI18N
        btnFighter.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/fighter_hover.png"))); // NOI18N
        btnFighter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFighterMouseEntered(evt);
            }
        });
        btnFighter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFighterActionPerformed(evt);
            }
        });
        getContentPane().add(btnFighter);
        btnFighter.setBounds(290, 600, 88, 88);

        btnAssassin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/assassin.png"))); // NOI18N
        btnAssassin.setBorderPainted(false);
        btnAssassin.setContentAreaFilled(false);
        btnAssassin.setFocusPainted(false);
        btnAssassin.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/assassin.png"))); // NOI18N
        btnAssassin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/assassin_hover.png"))); // NOI18N
        btnAssassin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAssassinMouseEntered(evt);
            }
        });
        btnAssassin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssassinActionPerformed(evt);
            }
        });
        getContentPane().add(btnAssassin);
        btnAssassin.setBounds(390, 600, 88, 88);

        btnMechanician.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/mechanician.png"))); // NOI18N
        btnMechanician.setBorderPainted(false);
        btnMechanician.setContentAreaFilled(false);
        btnMechanician.setFocusPainted(false);
        btnMechanician.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/mechanician.png"))); // NOI18N
        btnMechanician.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/mechanician_hover.png"))); // NOI18N
        btnMechanician.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMechanicianMouseEntered(evt);
            }
        });
        btnMechanician.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMechanicianActionPerformed(evt);
            }
        });
        getContentPane().add(btnMechanician);
        btnMechanician.setBounds(490, 600, 88, 88);

        btnPikeman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/pikeman.png"))); // NOI18N
        btnPikeman.setBorderPainted(false);
        btnPikeman.setContentAreaFilled(false);
        btnPikeman.setFocusPainted(false);
        btnPikeman.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/pikeman.png"))); // NOI18N
        btnPikeman.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classicon/pikeman_hover.png"))); // NOI18N
        btnPikeman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPikemanMouseEntered(evt);
            }
        });
        btnPikeman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPikemanActionPerformed(evt);
            }
        });
        getContentPane().add(btnPikeman);
        btnPikeman.setBounds(590, 600, 88, 88);

        lblVersus.setText("vs");
        getContentPane().add(lblVersus);
        lblVersus.setBounds(330, 310, 140, 90);
        getContentPane().add(lblEnemy);
        lblEnemy.setBounds(1000, 0, 1000, 480);
        getContentPane().add(lblPlayer);
        lblPlayer.setBounds(1000, 0, 1000, 480);

        btnDeselect.setText("Deselect");
        btnDeselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeselectActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeselect);
        btnDeselect.setBounds(680, 490, 100, 23);

        lblWhiteFlash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/whitebg.png"))); // NOI18N
        getContentPane().add(lblWhiteFlash);
        lblWhiteFlash.setBounds(0, 0, 800, 600);
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, 0, 800, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnKnightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKnightActionPerformed
        charClick("Knight", btnKnight);
    }//GEN-LAST:event_btnKnightActionPerformed

    private void btnMagicianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMagicianActionPerformed
        charClick("Magician", btnMagician);
    }//GEN-LAST:event_btnMagicianActionPerformed

    private void btnPriestessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPriestessActionPerformed
        charClick("Priestess", btnPriestess);
    }//GEN-LAST:event_btnPriestessActionPerformed

    private void btnAtalantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtalantaActionPerformed
        charClick("Atalanta", btnAtalanta);
    }//GEN-LAST:event_btnAtalantaActionPerformed

    private void btnShamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShamanActionPerformed
        charClick("Shaman", btnShaman);
    }//GEN-LAST:event_btnShamanActionPerformed

    private void btnArcherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArcherActionPerformed
        charClick("Archer", btnArcher);
    }//GEN-LAST:event_btnArcherActionPerformed

    private void btnFighterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFighterActionPerformed
        charClick("Fighter", btnFighter);
    }//GEN-LAST:event_btnFighterActionPerformed

    private void btnAssassinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssassinActionPerformed
        charClick("Assassin", btnAssassin);
    }//GEN-LAST:event_btnAssassinActionPerformed

    private void btnMechanicianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMechanicianActionPerformed
        charClick("Mechanician", btnMechanician);
    }//GEN-LAST:event_btnMechanicianActionPerformed

    private void btnPikemanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPikemanActionPerformed
        charClick("Pikeman", btnPikeman);
    }//GEN-LAST:event_btnPikemanActionPerformed

    private void btnKnightMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKnightMouseEntered
        String charName = "Knight";
        hoverPlayerEnemySet(btnKnight, charName);
        charHover(charName);

    }//GEN-LAST:event_btnKnightMouseEntered

    private void btnArcherMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArcherMouseEntered
        String charName = "Archer";
        hoverPlayerEnemySet(btnArcher, charName);
        charHover(charName);
    }//GEN-LAST:event_btnArcherMouseEntered

    private void btnMagicianMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMagicianMouseEntered
        String charName = "Magician";
        hoverPlayerEnemySet(btnMagician, charName);
        charHover(charName);
    }//GEN-LAST:event_btnMagicianMouseEntered

    private void btnPriestessMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPriestessMouseEntered
        String charName = "Priestess";
        hoverPlayerEnemySet(btnPriestess, charName);
        charHover(charName);

    }//GEN-LAST:event_btnPriestessMouseEntered

    private void btnAtalantaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtalantaMouseEntered
        String charName = "Atalanta";
        hoverPlayerEnemySet(btnAtalanta, charName);
        charHover(charName);
    }//GEN-LAST:event_btnAtalantaMouseEntered

    private void btnShamanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShamanMouseEntered
        String charName = "Shaman";
        hoverPlayerEnemySet(btnShaman, charName);
        charHover(charName);
    }//GEN-LAST:event_btnShamanMouseEntered

    private void btnFighterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFighterMouseEntered
        String charName = "Fighter";
        hoverPlayerEnemySet(btnFighter, charName);
        charHover(charName);
    }//GEN-LAST:event_btnFighterMouseEntered

    private void btnAssassinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAssassinMouseEntered
        String charName = "Assassin";
        hoverPlayerEnemySet(btnAssassin, charName);
        charHover(charName);
    }//GEN-LAST:event_btnAssassinMouseEntered

    private void btnMechanicianMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMechanicianMouseEntered
        String charName = "Mechanician";
        hoverPlayerEnemySet(btnMechanician, charName);
        charHover(charName);
    }//GEN-LAST:event_btnMechanicianMouseEntered

    private void btnPikemanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPikemanMouseEntered
        String charName = "Pikeman";
        hoverPlayerEnemySet(btnPikeman, charName);
        charHover(charName);
    }//GEN-LAST:event_btnPikemanMouseEntered

    private void btnDeselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeselectActionPerformed
        if (!playerSet && !enemySet) {

        } else {
            deselectChars();
        }

    }//GEN-LAST:event_btnDeselectActionPerformed

    private void btnPlayStopBGMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayStopBGMActionPerformed
        music.playPause(btnPlayStopBGM);
    }//GEN-LAST:event_btnPlayStopBGMActionPerformed

    private void btnSwapCharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwapCharActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSwapCharActionPerformed

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
            java.util.logging.Logger.getLogger(CharSelectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CharSelectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CharSelectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CharSelectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CharSelectFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barEAgi;
    private javax.swing.JProgressBar barESpi;
    private javax.swing.JProgressBar barEStr;
    private javax.swing.JProgressBar barETal;
    private javax.swing.JProgressBar barEVit;
    private javax.swing.JProgressBar barPAgi;
    private javax.swing.JProgressBar barPSpi;
    private javax.swing.JProgressBar barPStr;
    private javax.swing.JProgressBar barPTal;
    private javax.swing.JProgressBar barPVit;
    private javax.swing.JButton btnArcher;
    private javax.swing.JButton btnAssassin;
    private javax.swing.JButton btnAtalanta;
    private javax.swing.JButton btnDeselect;
    private javax.swing.JButton btnFighter;
    private javax.swing.JButton btnKnight;
    private javax.swing.JButton btnMagician;
    private javax.swing.JButton btnMechanician;
    private javax.swing.JButton btnPikeman;
    private javax.swing.JButton btnPlayStopBGM;
    private javax.swing.JButton btnPriestess;
    private javax.swing.JButton btnShaman;
    private javax.swing.JButton btnSwapChar;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblEAgi;
    private javax.swing.JLabel lblEAgiVal;
    private javax.swing.JLabel lblESpi;
    private javax.swing.JLabel lblESpiVal;
    private javax.swing.JLabel lblEStr;
    private javax.swing.JLabel lblEStrVal;
    private javax.swing.JLabel lblETal;
    private javax.swing.JLabel lblETalVal;
    private javax.swing.JLabel lblEVit;
    private javax.swing.JLabel lblEVitVal;
    private javax.swing.JLabel lblEnemy;
    private javax.swing.JLabel lblEnemyClassName;
    private javax.swing.JLabel lblEnemySet;
    private javax.swing.JLabel lblMorions;
    private javax.swing.JLabel lblPAgi;
    private javax.swing.JLabel lblPAgiVal;
    private javax.swing.JLabel lblPSpi;
    private javax.swing.JLabel lblPSpiVal;
    private javax.swing.JLabel lblPStr;
    private javax.swing.JLabel lblPStrVal;
    private javax.swing.JLabel lblPTal;
    private javax.swing.JLabel lblPTalVal;
    private javax.swing.JLabel lblPVit;
    private javax.swing.JLabel lblPVitVal;
    private javax.swing.JLabel lblPlayer;
    private javax.swing.JLabel lblPlayerClassName;
    private javax.swing.JLabel lblPlayerSet;
    private javax.swing.JLabel lblTempskrons;
    private javax.swing.JLabel lblVersus;
    private javax.swing.JLabel lblWhiteFlash;
    private javax.swing.JTextArea txtaEnemyDesc;
    private javax.swing.JTextArea txtaPlayerDesc;
    // End of variables declaration//GEN-END:variables

    private void popularListaTempskronBtn() {
        listTempskron.add(btnArcher);
        listTempskron.add(btnMechanician);
        listTempskron.add(btnAssassin);
        listTempskron.add(btnFighter);
        listTempskron.add(btnPikeman);
        Collections.shuffle(listTempskron);

    }

    private void popularListaMorionBtn() {
        listMorion.add(btnAtalanta);
        listMorion.add(btnKnight);
        listMorion.add(btnShaman);
        listMorion.add(btnMagician);
        listMorion.add(btnPriestess);
        Collections.shuffle(listMorion);

    }

    public void CustomCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("default.png");
        Point point = new Point(0, 0);
        Cursor cursor = toolkit.createCustomCursor(img, point, "Cursor");

        setCursor(cursor);
    }

    public void updateSelectedChar(String character) {
        int str = 0, spi = 0, tal = 0, agi = 0, vit = 0;
        String classDesc = "";
        switch (character) {
            case "Knight":
                str = 26;
                spi = 13;
                tal = 17;
                agi = 19;
                vit = 24;
                classDesc = "Knights are warriors of Morion with noble mind and stout body. "
                        + "Their attacking power comes from their religious mind, "
                        + "which represents the great power of Morion. They think "
                        + "about the body of oneself as pure, and train hard. When "
                        + "they use a sword, their holy powers are at their strongest.";
                break;
            case "Atalanta":
                str = 23;
                spi = 15;
                tal = 19;
                agi = 19;
                vit = 23;
                classDesc = "Atalanta's can attack enemies by using their magical "
                        + "power with spears of javelins. Their power can be truly "
                        + "seen when attacking with javelin throws in a long-range "
                        + "battle. They are extremely swift. ";
                break;
            case "Magician":
                str = 16;
                spi = 29;
                tal = 19;
                agi = 14;
                vit = 21;
                classDesc = "Their spiritual abilites are very powerful and their "
                        + "powerful spells prove it. They prefer using destructive "
                        + "magic over any other type. They use robes as armour and "
                        + "wands as weapons. ";
                break;
            case "Priestess":
                str = 15;
                spi = 28;
                tal = 21;
                agi = 15;
                vit = 20;
                classDesc = "They are pure and the holy people, and they do sacred "
                        + "work all the time. They always help other people and have "
                        + "strong faith. Their main armour consists of robes, and their "
                        + "weapons are mainly Staves or Wands. They are usually both "
                        + "slender and agile.";
                break;
            case "Shaman":
                str = 15;
                spi = 27;
                tal = 20;
                agi = 15;
                vit = 22;
                classDesc = "Arising from hidden forces, Shaman has a vast knowledge "
                        + "of the occult arts and control over the dead. \n"
                        + "His skills are based on the darkness and curses. \n"
                        + "His weapon is a magical weapon called Phantom, a powerful "
                        + "weapon that facilitates and enhances their magical powers.";
                break;
            case "Archer":
                str = 17;
                spi = 11;
                tal = 21;
                agi = 27;
                vit = 23;
                classDesc = "These female warriors are unmatched in their skills "
                        + "in projectile weapons. Preferring to take enemies out "
                        + "from a distance, their favorite weapon is the bow. "
                        + "Archers are the essential ranged supporters of any battle, "
                        + "and they tend to blend into the environment, out of sight.";
                break;
            case "Mechanician":
                str = 24;
                spi = 8;
                tal = 25;
                agi = 18;
                vit = 24;
                classDesc = "One of the most unique classes on the continent of "
                        + "Priston, a mechanician is a master of mechanical objects. "
                        + "Endlessly researching about mechanics, they have developed "
                        + "a set of skills like no other. Mechanicians tend to have "
                        + "heavy built suits and are nonetheless very aggressive.";
                break;
            case "Fighter":
                str = 28;
                spi = 6;
                tal = 21;
                agi = 17;
                vit = 27;
                classDesc = "They exist only to fight, and they like their fights "
                        + "up close and personal. Their highly trained bodies can "
                        + "withstand the harshest of environments, and can survive "
                        + "under the worst odds. Fighters tend not to wear protective "
                        + "armor or shields, preferring to travel light. Their rigorous "
                        + "training is obvious from their strong muscles, and they "
                        + "are always on a lookout for a good fight. ";
                break;
            case "Pikeman":
                str = 26;
                spi = 9;
                tal = 20;
                agi = 19;
                vit = 25;
                classDesc = "A master of scythes, these warriors strike terror "
                        + "deep into the hearts of enemies. Their gift of far "
                        + "sight and intimate knowledge of terrain gives them "
                        + "access to the most inaccessible of places. In fact, "
                        + "especially the ones that are impossible to access.";
                break;
            case "Assassin":
                str = 25;
                spi = 10;
                tal = 22;
                agi = 20;
                vit = 22;
                classDesc = "Despite their fragile and delicate appearance, an "
                        + "Assassin can kill before being noticed. \n"
                        + "As part of the Tempskrons tribe, their main weapon are "
                        + "daggers which they won't hesitate to use with poison "
                        + "whoever crosses their way.";
                break;
            default:
                break;

        }

        if (!playerSet && !enemySet) {
            lblPStrVal.setText(String.valueOf(str));
            lblPSpiVal.setText(String.valueOf(spi));
            lblPTalVal.setText(String.valueOf(tal));
            lblPAgiVal.setText(String.valueOf(agi));
            lblPVitVal.setText(String.valueOf(vit));
            barPStr.setValue(str);
            barPSpi.setValue(spi);
            barPTal.setValue(tal);
            barPAgi.setValue(agi);
            barPVit.setValue(vit);
            txtaPlayerDesc.setText(classDesc);
            lblPlayerClassName.setIcon(new ImageIcon(getClass().getResource("/assets/images/classtitle/" + character + "Name.png")));
            lblPlayerClassName.setVisible(true);
            showStatsPlayer(true);
        } else if (playerSet && !enemySet) {
            lblEStrVal.setText(String.valueOf(str));
            lblESpiVal.setText(String.valueOf(spi));
            lblETalVal.setText(String.valueOf(tal));
            lblEAgiVal.setText(String.valueOf(agi));
            lblEVitVal.setText(String.valueOf(vit));
            barEStr.setValue(str);
            barESpi.setValue(spi);
            barETal.setValue(tal);
            barEAgi.setValue(agi);
            barEVit.setValue(vit);
            txtaEnemyDesc.setText(classDesc);
            lblEnemyClassName.setIcon(new ImageIcon(getClass().getResource("/assets/images/classtitle/" + character + "Name.png")));
            lblEnemyClassName.setVisible(true);
            showStatsEnemy(true);
        }
    }

    public void hoverPlayerEnemySet(JButton btn, String charHover) {
        if (!playerSet && !enemySet) {
            sfx.playSound("ButtonHover.wav");
            Point p = new Point();
            p = btn.getLocation();
            p.y -= 10;
            lblPlayerSet.setLocation(p);
            lblPlayerSet.validate();
        } else if (playerSet && !enemySet) {
            sfx.playSound("ButtonHover.wav");
            Point p = new Point();
            p = btn.getLocation();
            if (playerSet && charHover.equals(playerChar)) {
                p.y += 60;
            } else {
                p.y -= 10;
            }

            lblEnemySet.setLocation(p);
            lblEnemySet.validate();
        }
    }

    public void showStatsPlayer(boolean visible) {
        lblPStr.setVisible(visible);
        lblPAgi.setVisible(visible);
        lblPTal.setVisible(visible);
        lblPSpi.setVisible(visible);
        lblPVit.setVisible(visible);
        lblPStrVal.setVisible(visible);
        lblPAgiVal.setVisible(visible);
        lblPTalVal.setVisible(visible);
        lblPSpiVal.setVisible(visible);
        lblPVitVal.setVisible(visible);
        barPStr.setVisible(visible);
        barPSpi.setVisible(visible);
        barPTal.setVisible(visible);
        barPAgi.setVisible(visible);
        barPVit.setVisible(visible);
        txtaPlayerDesc.setVisible(visible);
    }

    public void showStatsEnemy(boolean visible) {
        lblEStr.setVisible(visible);
        lblEAgi.setVisible(visible);
        lblETal.setVisible(visible);
        lblESpi.setVisible(visible);
        lblEVit.setVisible(visible);
        lblEStrVal.setVisible(visible);
        lblEAgiVal.setVisible(visible);
        lblETalVal.setVisible(visible);
        lblESpiVal.setVisible(visible);
        lblEVitVal.setVisible(visible);
        barEStr.setVisible(visible);
        barESpi.setVisible(visible);
        barETal.setVisible(visible);
        barEAgi.setVisible(visible);
        barEVit.setVisible(visible);
        txtaEnemyDesc.setVisible(visible);
    }

    public void confirmPlayerEnemy() {
        if (playerSet && enemySet) {
            lblWhiteFlash.setSize(800, 600);
            FadeInOut fade = new FadeInOut();
            fade.fade(lblWhiteFlash, 5, 60, "/assets/images/whitebg.png", false, false, 0);
            JdiConfirm msgBox = new JdiConfirm(this, true);
            msgBox.setPlayerChar(playerChar);
            msgBox.setEnemyChar(enemyChar);
            msgBox.setLocationRelativeTo(this);
            msgBox.setVisible(true);
            int aux = msgBox.returnFlag;
            System.err.println(aux);
            switch (aux) {
                case 0:
                    deselectChars();
                    break;
                case 1:
                    swapChars();
                    break;
                case 2:
                    sfx.playSound("GameStart.wav");
                    System.out.println(this.getContentPane().getComponentZOrder(btnArcher));

                    this.getContentPane().setComponentZOrder(lblWhiteFlash, 0);
                    FadeInOut fadeScreen = new FadeInOut();
                    fadeScreen.fade(lblWhiteFlash, 5, 30, "/assets/images/blackbg.png", true, false, 0);
                    Timer t = new Timer();                    
                    TimerTask closeScreen = new TimerTask() {
                        public void run() {
                            counter++;
                            if (counter == 3) {
                                music.close();
                                animEnemy = null;
                                animPlayer = null;
                                timer.cancel();
                                timer2.cancel();
                                main.player = playerChar;
                                main.enemy = enemyChar;
                                CharBuildFrame buildWindow = new CharBuildFrame();
                                buildWindow.setLocation(getFrameLocation());
                                buildWindow.setVisible(true);     
                                
                                dispose();
                                t.cancel();                                                           
                            }
                        }
                    };
                    t.scheduleAtFixedRate(closeScreen, 10, 1000);
                    break;
                default:
                    break;
            }
        }
    }

    private void deselectChars() {
        playerSet = false;
        enemySet = false;
        playerChar = "";
        enemyChar = "";
        lblPlayerSet.setLocation(1000, 1000);
        lblEnemySet.setLocation(1000, 1000);
        Point p = new Point();
        p = lblPlayer.getLocation();
        p.x = 1000;
        lblPlayer.setLocation(p);
        p = lblEnemy.getLocation();
        p.x = 1000;
        lblEnemy.setLocation(p);
        lblPlayerClassName.setVisible(false);
        lblEnemyClassName.setVisible(false);
        showStatsPlayer(false);
        showStatsEnemy(false);
        sfx.playSound("DeselectChar.wav");
    }

    private void charHover(String charName) {
        xModifier = 0;
        xEModifier = 0;
        switch (charName) {
            case "Pikeman":
                xModifier = 150;
                xEModifier = +100;
                break;
            case "Fighter":
                xModifier = -50;
                break;
            case "Assassin":
                xModifier = -25;
                xEModifier = +35;
                break;
            case "Magician":
                xModifier = -50;
                xEModifier = +50;
                break;
            case "Mechanician":
                xEModifier = 100;
                break;
            case "Atalanta":
                xModifier = -50;
                break;
            case "Knight":
                xModifier = -20;
                xEModifier = +25;
                break;
            case "Shaman":
                xModifier = -40;
                xEModifier = +20;
                break;
            case "Priestess":
                xModifier = -30;
                xEModifier = +30;
                break;
                
        }

        if (!playerSet && !enemySet) {
            animPlayer.showUp(lblPlayer, "/assets/images/character/" + charName.toLowerCase() + "_player.png", -380, 140-xModifier, 30, true);
        } else if (playerSet && !enemySet) {
            animEnemy.showUp(lblEnemy, "/assets/images/character/" + charName.toLowerCase() + "_enemy.png", 810, 410-xEModifier, 30, false);
        }

        updateSelectedChar(charName);
    }

    private void charClick(String charName, JButton btn) {
        if (!playerSet && !enemySet) {
            sfx.playSound("ButtonSelectChar.wav");
            playerChar = charName;
            playerSet = true;
            hoverPlayerEnemySet(btn, charName);
            updateSelectedChar(charName);
            charHover(charName);
            //animEnemy.showUp(lblEnemy, "/assets/images/character/" + charName.toLowerCase() + "_enemy.png", 810, 410, 30, false);
        } else if (playerSet && !enemySet) {
            sfx.playSound("ConfirmChar.wav");
            enemyChar = charName;
            enemySet = true;
            confirmPlayerEnemy();
        }
    }

    private void swapChars() {
        playerSet = false;
        enemySet = false;
        String aux = playerChar;
        playerChar = enemyChar;
        enemyChar = aux;
        updateSelectedChar(playerChar);
        playerSet = true;
        animPlayer.showUp(lblPlayer, "/assets/images/character/" + playerChar.toLowerCase() + "_player.png", -380, 140-xModifier, 30, true);
        animEnemy.showUp(lblEnemy, "/assets/images/character/" + enemyChar.toLowerCase() + "_enemy.png", 810, 410-xEModifier, 30, false);
        updateSelectedChar(enemyChar);
        playerSet = true;
        enemySet = true;
        sfx.playSound("ConfirmChar.wav");
        Point p;
        Point e;
        p = lblPlayerSet.getLocation();
        e = lblEnemySet.getLocation();
        lblPlayerSet.setLocation(e);
        lblEnemySet.setLocation(p);
        confirmPlayerEnemy();
    }
    
    public Point getFrameLocation(){
        return this.getLocation();
    }

}