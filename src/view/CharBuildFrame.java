/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import animation.ChooseGear;
import animation.FadeInOut;
import animation.FadeWorker;
import animation.ShowCharSelectBtn;
import formula.CharacterStats;
import formula.morion.Atalanta;
import formula.morion.Knight;
import formula.morion.Magician;
import formula.morion.Priestess;
import formula.morion.Shaman;
import formula.tempskron.Archer;
import formula.tempskron.Assassin;
import formula.tempskron.Fighter;
import formula.tempskron.Mechanician;
import formula.tempskron.Pikeman;
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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.PlainDocument;
import javazoom.jl.decoder.JavaLayerException;

/**
 *
 * @author Administrator
 */
public class CharBuildFrame extends javax.swing.JFrame {

    SwingWorker worker;
    FadeWorker fw = new FadeWorker();
    
     ChooseGear animGear = new ChooseGear();

    final boolean IN = true;
    final boolean OUT = false;
    final boolean PLAYER = true;
    final boolean ENEMY = false;
    
    JdiGearSelector equipGear;

    

    int counter = 0;
    boolean flagHideGUI = false;
    int contadorAnimGearSlots = -3;
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

                    //fadeBackGround.animarFade(bg, 5, 60, bgc.bgImagePath, true, false, 0);
                    worker.cancel(true);
                    worker = fw.bufferImg(bgc.bgImagePath, 0.03f, 16, IN, bg, barBuffer);
                    worker.execute();

                    Thread.sleep(100);
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
        setPlayerEnemyCharacter();
        initComponents();
        
      
        
        ToolTipManager.sharedInstance().setDismissDelay(Integer.MAX_VALUE);
        UIManager.put("ToolTip.background", new ColorUIResource(255, 255, 255)); 
        Border border = BorderFactory.createLineBorder(new Color(147, 83, 0),2); // The color is #4c4f53.
        UIManager.put("ToolTip.border", border);
        
        setFiltroTexto();

        btnHideGUI.setVisible(false);

        TimerTask showInventorySlots = new TimerTask() {
            public void run() {
                switch (contadorAnimGearSlots) {
                    case -2:
                        sfx.playSound("/woosh/woosh" + gerarRng(1, 3) + ".wav");
                        break;
                    case -1:
                        sfx.playSound("/woosh/woosh" + gerarRng(1, 3) + ".wav");
                        break;
                    case 0:
                        ShowCharSelectBtn scsbPS = new ShowCharSelectBtn();
                        scsbPS.showLeftPanel(panPlayerStats, 197, 50);
                        scsbPS.showDown(lblFraseAjuda, 2, 12);
                        break;
                    case 1:
                        ShowCharSelectBtn scsbES = new ShowCharSelectBtn();
                        scsbES.showRightPanel(panEnemyStats, 440, 50);
                        break;
                    case 2:
                        ShowCharSelectBtn scsbP = new ShowCharSelectBtn();
                        scsbP.showLeftLabel(lblPlayer, 0, 50);
                        scsbP.showLeftLabel(lblPlayerClassName, 10, 50);
                        break;
                    case 3:
                        ShowCharSelectBtn scsbE = new ShowCharSelectBtn();
                        scsbE.showRightLabel(lblEnemy, 290, 50);
                        scsbE.showRightLabel(lblEnemyClassName, 580, 50);
                        sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");
                        break;
                    case 4:
                        ShowCharSelectBtn scsb = new ShowCharSelectBtn();
                        scsb.showLeftPanel(panPlayerAcessorySlots, 57, 35);
                        sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");
                        break;
                    case 5:
                        ShowCharSelectBtn scsb2 = new ShowCharSelectBtn();
                        scsb2.showLeftPanel(panPlayerDefenseSlots, 214, 35);
                        sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");
                        break;
                    case 6:
                        ShowCharSelectBtn scsb3 = new ShowCharSelectBtn();
                        scsb3.showLeftPanel(panPlayerMainGearSlots, 57, 38);
                        sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");
                        break;
                    case 7:
                        ShowCharSelectBtn scsb4 = new ShowCharSelectBtn();
                        scsb4.showRightPanel(panEnemyAcessorySlots, 440, 35);
                        sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");
                        break;
                    case 8:
                        ShowCharSelectBtn scsb5 = new ShowCharSelectBtn();
                        scsb5.showRightPanel(panEnemyDefenseSlots, 598, 35);
                        break;
                    case 9:
                        ShowCharSelectBtn scsb6 = new ShowCharSelectBtn();
                        scsb6.showRightPanel(panEnemyMainGearSlots, 440, 35);
                        sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");
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
            Image = ImageIO.read(new File("src/assets/images/character/" + main.player.toLowerCase() + "_player.png"));
            lblPlayer.setIcon(new ImageIcon(Image));
            Image = ImageIO.read(new File("src/assets/images/character/" + main.enemy.toLowerCase() + "_enemy.png"));
            lblEnemy.setIcon(new ImageIcon(Image));
            Image = ImageIO.read(new File("src/assets/images/classtitle/" + main.player + "Name.png"));
            lblPlayerClassName.setIcon(new ImageIcon(Image));
            Image = ImageIO.read(new File("src/assets/images/classtitle/" + main.enemy + "Name.png"));
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
            if (!main.flagBgm) {
                music.pause();
            }
        } catch (JavaLayerException ex) {
            Logger.getLogger(CharBuildFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CharBuildFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        timer2.scheduleAtFixedRate(showInventorySlots, 0, 200);

        /*
         Inicialização dos campos de status
         */
        setDefaultPlayerStats();
        setDefaultEnemyStats();
        
        equipGear = new JdiGearSelector(this, true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barBuffer = new javax.swing.JProgressBar();
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
        btnPReset = new javax.swing.JButton();
        txtPRemainStats = new javax.swing.JTextField();
        lblPlayerStats = new javax.swing.JLabel();
        panEnemyStats = new javax.swing.JPanel();
        btnEReset = new javax.swing.JButton();
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
        lblScreenFlash = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wartale Simulator "+main.version+" - Character Building - Set character's status, gears and skill points."+main.by);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(800, 630));
        setResizable(false);
        getContentPane().setLayout(null);

        barBuffer.setMaximum(200);
        getContentPane().add(barBuffer);
        barBuffer.setBounds(630, 560, 146, 14);

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
        txtPlayerName.setToolTipText("<html><font color='blue'>Set the character's name.<br>\nThere isn't a better name than the default one. <br>\nLegend says that the player who fought by this name<br>\nendured countless battles, many of them being outnumbered.<br>\nThe noble, stout Knight always stood on his feet, <br>\nwith a great sense of justice and perseverance.");
        txtPlayerName.setBorder(null);
        txtPlayerName.setOpaque(false);
        txtPlayerName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPlayerNameFocusGained(evt);
            }
        });
        panPlayerStats.add(txtPlayerName);
        txtPlayerName.setBounds(20, 31, 120, 20);

        txtPLevel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtPLevel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPLevel.setText("155");
        txtPLevel.setToolTipText("<html><font color='blue'>Set the character's level. You can set a level within the range of 1 ~ 255.<br>\nWhen setting a lower level, if the total sum of stats are higher than<br>\nthe max status allowed, all status will be reset.<br>");
        txtPLevel.setBorder(null);
        txtPLevel.setOpaque(false);
        txtPLevel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPLevelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPLevelFocusLost(evt);
            }
        });
        panPlayerStats.add(txtPLevel);
        txtPLevel.setBounds(89, 57, 54, 13);

        txtPStrenght.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtPStrenght.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPStrenght.setText("155");
        txtPStrenght.setToolTipText("<html><font color='blue'>Set the character's strenght.<br>\nStrenght is the primary source of Attack Damage when<br>\nusing melee weapons. It is a secondary source of HP<br>\nfor non-magic characters. ");
        txtPStrenght.setBorder(null);
        txtPStrenght.setOpaque(false);
        txtPStrenght.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPStrenghtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPStrenghtFocusLost(evt);
            }
        });
        panPlayerStats.add(txtPStrenght);
        txtPStrenght.setBounds(89, 96, 54, 13);

        txtPSpirit.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtPSpirit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPSpirit.setText("155");
        txtPSpirit.setToolTipText("<html><font color='blue'>Set the character's spirit.<br>\nSpirit is the primary source of Mana and Attack Damage when<br>\nwearing magic weapons, like Wands, Staves and Phantoms.");
        txtPSpirit.setBorder(null);
        txtPSpirit.setOpaque(false);
        txtPSpirit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPSpiritFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPSpiritFocusLost(evt);
            }
        });
        panPlayerStats.add(txtPSpirit);
        txtPSpirit.setBounds(89, 116, 54, 13);

        txtPTalent.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtPTalent.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPTalent.setText("155");
        txtPTalent.setToolTipText("<html><font color='blue'>Set the character's Talent.<br>\nTalent primary function is to enable characters to wear<br>\nmost of the game items. It also adds a bit of Attack Damage,<br>\nAttack Rating and Defense.");
        txtPTalent.setBorder(null);
        txtPTalent.setOpaque(false);
        txtPTalent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPTalentFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPTalentFocusLost(evt);
            }
        });
        panPlayerStats.add(txtPTalent);
        txtPTalent.setBounds(89, 136, 54, 13);

        txtPAgility.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtPAgility.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPAgility.setText("155");
        txtPAgility.setToolTipText("<html><font color='blue'>Set the character's Agility.<br>\nIt is the primary source of Attack Damage when <br>\nwearing ranged weapons like Bows and Javelins.<br>\nIt is also the primary source of Attack Rating and Defense.");
        txtPAgility.setBorder(null);
        txtPAgility.setOpaque(false);
        txtPAgility.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPAgilityFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPAgilityFocusLost(evt);
            }
        });
        panPlayerStats.add(txtPAgility);
        txtPAgility.setBounds(89, 156, 54, 13);

        txtPHealth.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtPHealth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPHealth.setText("155");
        txtPHealth.setToolTipText("<html><font color='blue'>Set the character's Health. <br>\nIt is the primary source of HP. It is also the primary source <br>\nof Running Speed and Stamina.");
        txtPHealth.setBorder(null);
        txtPHealth.setNextFocusableComponent(txtEnemyName);
        txtPHealth.setOpaque(false);
        txtPHealth.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPHealthFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPHealthFocusLost(evt);
            }
        });
        panPlayerStats.add(txtPHealth);
        txtPHealth.setBounds(89, 176, 54, 13);

        btnPReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/btnResetStats.png"))); // NOI18N
        btnPReset.setToolTipText("<html><font color='blue'>Resets status points to base ones.");
        btnPReset.setBorder(null);
        btnPReset.setBorderPainted(false);
        btnPReset.setContentAreaFilled(false);
        btnPReset.setFocusPainted(false);
        btnPReset.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/btnResetStats.png"))); // NOI18N
        btnPReset.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/btnResetStatsHover.png"))); // NOI18N
        btnPReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPResetActionPerformed(evt);
            }
        });
        panPlayerStats.add(btnPReset);
        btnPReset.setBounds(92, 192, 46, 23);

        txtPRemainStats.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtPRemainStats.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPRemainStats.setText("155");
        txtPRemainStats.setToolTipText("<html><font color='blue'>This is the remaining status that can be<br>\nallocated to any of status types.");
        txtPRemainStats.setBorder(null);
        txtPRemainStats.setFocusable(false);
        txtPRemainStats.setOpaque(false);
        panPlayerStats.add(txtPRemainStats);
        txtPRemainStats.setBounds(89, 217, 54, 13);

        lblPlayerStats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/playerStatsFields.png"))); // NOI18N
        lblPlayerStats.setToolTipText("<html><font color='blue'>Click on a status field and type a value. <br>\nSetting a value lower than the base ones will always <br>\nreset it to the base value. <br><br>\nTIP: If you plan to use all your remaining status points on a single<br>\nstatus type, set a high value, like 9999. It will automatically allocate <br>\nall the remaining status at once.");
        panPlayerStats.add(lblPlayerStats);
        lblPlayerStats.setBounds(0, 0, 161, 250);

        getContentPane().add(panPlayerStats);
        panPlayerStats.setBounds(-171, 140, 161, 250);

        panEnemyStats.setOpaque(false);
        panEnemyStats.setLayout(null);

        btnEReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/btnResetStats.png"))); // NOI18N
        btnEReset.setToolTipText("<html><font color='red'>Resets status points to base ones.");
        btnEReset.setBorder(null);
        btnEReset.setBorderPainted(false);
        btnEReset.setContentAreaFilled(false);
        btnEReset.setFocusPainted(false);
        btnEReset.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/btnResetStats.png"))); // NOI18N
        btnEReset.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/btnResetStatsHover.png"))); // NOI18N
        btnEReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEResetActionPerformed(evt);
            }
        });
        panEnemyStats.add(btnEReset);
        btnEReset.setBounds(92, 192, 46, 23);

        txtEnemyName.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtEnemyName.setText("DarkLink64");
        txtEnemyName.setToolTipText("<html><font color='red'>Set the character's name.<br>\nThere isn't a better name than the default one. <br>\nLegend says that whoever faced a warrior standing by <br>\nthe default name, always got their face beaten and stumped upon<br>\nthe ground. Facing this noble warrior alone always ended in <br>\nutter defeat. Some tales says that it required at least of a horde<br>\nof more than 10 mans to kill this single stout Knight.");
        txtEnemyName.setBorder(null);
        txtEnemyName.setOpaque(false);
        txtEnemyName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEnemyNameFocusGained(evt);
            }
        });
        txtEnemyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnemyNameActionPerformed(evt);
            }
        });
        panEnemyStats.add(txtEnemyName);
        txtEnemyName.setBounds(20, 31, 120, 20);

        txtELevel.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtELevel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtELevel.setText("155");
        txtELevel.setToolTipText("<html><font color='red'>Set the character's level. You can set a level within the range of 1 ~ 255.<br>\nWhen setting a lower level, if the total sum of stats are higher than<br>\nthe max status allowed, all status will be reset.<br>");
        txtELevel.setBorder(null);
        txtELevel.setOpaque(false);
        txtELevel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtELevelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtELevelFocusLost(evt);
            }
        });
        panEnemyStats.add(txtELevel);
        txtELevel.setBounds(89, 57, 54, 13);

        txtEStrenght.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtEStrenght.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEStrenght.setText("155");
        txtEStrenght.setToolTipText("<html><font color='red'>Set the character's strenght.<br>\nStrenght is the primary source of Attack Damage when<br>\nusing melee weapons. It is a secondary source of HP<br>\nfor non-magic characters. ");
        txtEStrenght.setBorder(null);
        txtEStrenght.setOpaque(false);
        txtEStrenght.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEStrenghtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEStrenghtFocusLost(evt);
            }
        });
        panEnemyStats.add(txtEStrenght);
        txtEStrenght.setBounds(89, 96, 54, 13);

        txtESpirit.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtESpirit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtESpirit.setText("155");
        txtESpirit.setToolTipText("<html><font color='red'>Set the character's spirit.<br>\nSpirit is the primary source of Mana and Attack Damage when<br>\nwearing magic weapons, like Wands, Staves and Phantoms.\n");
        txtESpirit.setBorder(null);
        txtESpirit.setOpaque(false);
        txtESpirit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtESpiritFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtESpiritFocusLost(evt);
            }
        });
        panEnemyStats.add(txtESpirit);
        txtESpirit.setBounds(89, 116, 54, 13);

        txtETalent.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtETalent.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtETalent.setText("155");
        txtETalent.setToolTipText("<html><font color='red'>Set the character's Talent.<br>\nTalent primary function is to enable characters to wear<br>\nmost of the game items. It also adds a bit of Attack Damage,<br>\nAttack Rating and Defense.");
        txtETalent.setBorder(null);
        txtETalent.setOpaque(false);
        txtETalent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtETalentFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtETalentFocusLost(evt);
            }
        });
        panEnemyStats.add(txtETalent);
        txtETalent.setBounds(89, 136, 54, 13);

        txtEAgility.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtEAgility.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEAgility.setText("155");
        txtEAgility.setToolTipText("<html><font color='red'>Set the character's Agility.<br>\nIt is the primary source of Attack Damage when <br>\nwearing ranged weapons like Bows and Javelins.<br>\nIt is also the primary source of Attack Rating and Defense.");
        txtEAgility.setBorder(null);
        txtEAgility.setOpaque(false);
        txtEAgility.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEAgilityFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEAgilityFocusLost(evt);
            }
        });
        panEnemyStats.add(txtEAgility);
        txtEAgility.setBounds(89, 156, 54, 13);

        txtEHealth.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtEHealth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEHealth.setText("155");
        txtEHealth.setToolTipText("<html><font color='red'>Set the character's Health. <br>\nIt is the primary source of HP. It is also the primary source <br>\nof Running Speed and Stamina.\n");
        txtEHealth.setBorder(null);
        txtEHealth.setNextFocusableComponent(txtPlayerName);
        txtEHealth.setOpaque(false);
        txtEHealth.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEHealthFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEHealthFocusLost(evt);
            }
        });
        panEnemyStats.add(txtEHealth);
        txtEHealth.setBounds(89, 176, 54, 13);

        txtERemainStats.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtERemainStats.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtERemainStats.setText("155");
        txtERemainStats.setToolTipText("<html><font color='red'>This is the remaining status that can be<br>\nallocated to any of status types.");
        txtERemainStats.setBorder(null);
        txtERemainStats.setFocusable(false);
        txtERemainStats.setOpaque(false);
        panEnemyStats.add(txtERemainStats);
        txtERemainStats.setBounds(89, 217, 54, 13);

        lblEnemyStats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/enemyStatsFields.png"))); // NOI18N
        lblEnemyStats.setToolTipText("<html><font color='red'>Click on a status field and type a value. <br>\nSetting a value lower than the base ones will always <br>\nreset it to the base value. <br><br>\nTIP: If you plan to use all your remaining status points on a single<br>\nstatus type, set a high value, like 9999. It will automatically allocate <br>\nall the remaining status at once.");
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
        lblFraseAjuda.setBounds(0, -50, 621, 40);

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
        getContentPane().add(lblScreenFlash);
        lblScreenFlash.setBounds(0, 0, 0, 0);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayStopBGMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayStopBGMActionPerformed
        music.playPause(btnPlayStopBGM);
    }//GEN-LAST:event_btnPlayStopBGMActionPerformed

    private void btnPlayerNecklaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerNecklaceActionPerformed
        equipGear.setFlags("necklace", main.pChar);
        equipGear.setVisible(true); 
    }//GEN-LAST:event_btnPlayerNecklaceActionPerformed

    private void btnPlayerRing1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerRing1ActionPerformed
        equipGear.setFlags("ring", main.pChar);
        equipGear.setVisible(true); 
        
    }//GEN-LAST:event_btnPlayerRing1ActionPerformed

    private void btnPlayerRing2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerRing2ActionPerformed
        equipGear.setFlags("ring", main.pChar);
        equipGear.setVisible(true); 
    }//GEN-LAST:event_btnPlayerRing2ActionPerformed

    private void btnPlayerSheltomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerSheltomActionPerformed
        equipGear.setFlags("sheltom", main.pChar);
        equipGear.setVisible(true); 
    }//GEN-LAST:event_btnPlayerSheltomActionPerformed

    private void btnPlayerBraceletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerBraceletActionPerformed
        equipGear.setFlags("bracelet", main.pChar);
        equipGear.setVisible(true); 
    }//GEN-LAST:event_btnPlayerBraceletActionPerformed

    private void btnPlayerGauntletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerGauntletActionPerformed
        equipGear.setFlags("gauntlet", main.pChar);
        equipGear.setVisible(true); 
    }//GEN-LAST:event_btnPlayerGauntletActionPerformed

    private void btnPlayerBootsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerBootsActionPerformed
        equipGear.setFlags("boots", main.pChar);
        equipGear.setVisible(true); 
    }//GEN-LAST:event_btnPlayerBootsActionPerformed

    private void btnPlayerWeapon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerWeapon1ActionPerformed
        equipGear.setFlags("1h", main.pChar);
        animGear.open(equipGear.getPanelGear(), true);
        equipGear.setVisible(true);
        
        
    }//GEN-LAST:event_btnPlayerWeapon1ActionPerformed

    private void btnPlayerWeapon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerWeapon2ActionPerformed
        equipGear.setFlags("2h", main.pChar);
        equipGear.setVisible(true); 
    }//GEN-LAST:event_btnPlayerWeapon2ActionPerformed

    private void btnPlayerArmorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerArmorActionPerformed
        equipGear.setFlags("armor", main.pChar);
        equipGear.setVisible(true); 
    }//GEN-LAST:event_btnPlayerArmorActionPerformed

    private void btnPlayerShieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerShieldActionPerformed
        equipGear.setFlags("shield", main.pChar);
        equipGear.setVisible(true); 
    }//GEN-LAST:event_btnPlayerShieldActionPerformed

    private void btnEnemyNecklaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyNecklaceActionPerformed
        equipGear.setFlags("necklace", main.eChar);
        equipGear.setVisible(true);
    }//GEN-LAST:event_btnEnemyNecklaceActionPerformed

    private void btnEnemyRing1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyRing1ActionPerformed
        equipGear.setFlags("ring", main.eChar);
        equipGear.setVisible(true);
    }//GEN-LAST:event_btnEnemyRing1ActionPerformed

    private void btnEnemyRing2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyRing2ActionPerformed
        equipGear.setFlags("ring", main.eChar);
        equipGear.setVisible(true);
    }//GEN-LAST:event_btnEnemyRing2ActionPerformed

    private void btnEnemySheltomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemySheltomActionPerformed
        equipGear.setFlags("sheltom", main.eChar);
        equipGear.setVisible(true);
    }//GEN-LAST:event_btnEnemySheltomActionPerformed

    private void btnEnemyBraceletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyBraceletActionPerformed
        equipGear.setFlags("bracelet", main.eChar);
        equipGear.setVisible(true);
    }//GEN-LAST:event_btnEnemyBraceletActionPerformed

    private void btnEnemyGauntletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyGauntletActionPerformed
        equipGear.setFlags("gauntlet", main.eChar);
        equipGear.setVisible(true);
    }//GEN-LAST:event_btnEnemyGauntletActionPerformed

    private void btnEnemyBootsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyBootsActionPerformed
        equipGear.setFlags("boots", main.eChar);
        equipGear.setVisible(true);
    }//GEN-LAST:event_btnEnemyBootsActionPerformed

    private void btnEnemyWeapon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyWeapon1ActionPerformed
        equipGear.setFlags("1h", main.eChar);
        equipGear.setVisible(true);
    }//GEN-LAST:event_btnEnemyWeapon1ActionPerformed

    private void btnEnemyWeapon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyWeapon2ActionPerformed
        equipGear.setFlags("2h", main.eChar);
        equipGear.setVisible(true);
    }//GEN-LAST:event_btnEnemyWeapon2ActionPerformed

    private void btnEnemyShieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyShieldActionPerformed
        equipGear.setFlags("shield", main.eChar);
        equipGear.setVisible(true);
    }//GEN-LAST:event_btnEnemyShieldActionPerformed

    private void btnEnemyArmorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyArmorActionPerformed
        equipGear.setFlags("armor", main.eChar);
        equipGear.setVisible(true);
    }//GEN-LAST:event_btnEnemyArmorActionPerformed

    private void btnSwapCharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwapCharActionPerformed
        backToCharSelect();
    }//GEN-LAST:event_btnSwapCharActionPerformed

    private void btnHideGUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHideGUIActionPerformed
        hideShowGUI(flagHideGUI);
    }//GEN-LAST:event_btnHideGUIActionPerformed

    private void txtPLevelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPLevelFocusGained
        txtPLevel.selectAll();
    }//GEN-LAST:event_txtPLevelFocusGained

    private void txtPStrenghtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPStrenghtFocusGained
        txtPStrenght.selectAll();
    }//GEN-LAST:event_txtPStrenghtFocusGained

    private void txtPSpiritFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPSpiritFocusGained
        txtPSpirit.selectAll();
    }//GEN-LAST:event_txtPSpiritFocusGained

    private void txtPTalentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPTalentFocusGained
        txtPTalent.selectAll();
    }//GEN-LAST:event_txtPTalentFocusGained

    private void txtPAgilityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPAgilityFocusGained
        txtPAgility.selectAll();
    }//GEN-LAST:event_txtPAgilityFocusGained

    private void txtPHealthFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPHealthFocusGained
        txtPHealth.selectAll();
    }//GEN-LAST:event_txtPHealthFocusGained

    private void btnPResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPResetActionPerformed
        sfx.playSound("drink2.wav");
        setDefaultPlayerStats();
    }//GEN-LAST:event_btnPResetActionPerformed

    private void btnEResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEResetActionPerformed
        sfx.playSound("drink2.wav");
        setDefaultEnemyStats();
    }//GEN-LAST:event_btnEResetActionPerformed

    private void txtPStrenghtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPStrenghtFocusLost
        txtPStrenght.setText(String.valueOf(statLimit("str", PLAYER, txtPStrenght.getText())));
        txtPRemainStats.setText(String.valueOf(main.pChar.getRemainStats()));
    }//GEN-LAST:event_txtPStrenghtFocusLost

    private void txtPSpiritFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPSpiritFocusLost
        txtPSpirit.setText(String.valueOf(statLimit("spi", PLAYER, txtPSpirit.getText())));
        txtPRemainStats.setText(String.valueOf(main.pChar.getRemainStats()));
    }//GEN-LAST:event_txtPSpiritFocusLost

    private void txtPTalentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPTalentFocusLost
        txtPTalent.setText(String.valueOf(statLimit("tal", PLAYER, txtPTalent.getText())));
        txtPRemainStats.setText(String.valueOf(main.pChar.getRemainStats()));
    }//GEN-LAST:event_txtPTalentFocusLost

    private void txtPAgilityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPAgilityFocusLost
        txtPAgility.setText(String.valueOf(statLimit("agi", PLAYER, txtPAgility.getText())));
        txtPRemainStats.setText(String.valueOf(main.pChar.getRemainStats()));
    }//GEN-LAST:event_txtPAgilityFocusLost

    private void txtPHealthFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPHealthFocusLost
        txtPHealth.setText(String.valueOf(statLimit("vit", PLAYER, txtPHealth.getText())));
        txtPRemainStats.setText(String.valueOf(main.pChar.getRemainStats()));
    }//GEN-LAST:event_txtPHealthFocusLost

    private void txtEnemyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnemyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnemyNameActionPerformed

    private void txtPLevelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPLevelFocusLost
        int level;
        try {
            level = Integer.parseInt(txtPLevel.getText());
            if (level > 255) level = 255;
        } catch (NumberFormatException nfe) {
            level = 155;
        }
        txtPLevel.setText(String.valueOf(level));
        setDefaultPlayerStats();
    }//GEN-LAST:event_txtPLevelFocusLost

    private void txtELevelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtELevelFocusGained
        txtELevel.selectAll();
    }//GEN-LAST:event_txtELevelFocusGained

    private void txtELevelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtELevelFocusLost
        int level;
        try {
            level = Integer.parseInt(txtPLevel.getText());
            if (level > 255) level = 255;
        } catch (NumberFormatException nfe) {
            level = 155;
        }
        txtELevel.setText(String.valueOf(level));
        setDefaultEnemyStats();
    }//GEN-LAST:event_txtELevelFocusLost

    private void txtEStrenghtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEStrenghtFocusGained
        txtEStrenght.selectAll();
    }//GEN-LAST:event_txtEStrenghtFocusGained

    private void txtEStrenghtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEStrenghtFocusLost
        txtEStrenght.setText(String.valueOf(statLimit("str", PLAYER, txtEStrenght.getText())));
        txtERemainStats.setText(String.valueOf(main.eChar.getRemainStats()));
    }//GEN-LAST:event_txtEStrenghtFocusLost

    private void txtESpiritFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtESpiritFocusGained
        txtESpirit.selectAll();
    }//GEN-LAST:event_txtESpiritFocusGained

    private void txtESpiritFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtESpiritFocusLost
        txtESpirit.setText(String.valueOf(statLimit("spi", PLAYER, txtESpirit.getText())));
        txtERemainStats.setText(String.valueOf(main.eChar.getRemainStats()));
    }//GEN-LAST:event_txtESpiritFocusLost

    private void txtETalentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtETalentFocusGained
        txtETalent.selectAll();
    }//GEN-LAST:event_txtETalentFocusGained

    private void txtETalentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtETalentFocusLost
        txtETalent.setText(String.valueOf(statLimit("tal", PLAYER, txtETalent.getText())));
        txtERemainStats.setText(String.valueOf(main.eChar.getRemainStats()));
    }//GEN-LAST:event_txtETalentFocusLost

    private void txtEAgilityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEAgilityFocusGained
        txtEAgility.selectAll();
    }//GEN-LAST:event_txtEAgilityFocusGained

    private void txtEAgilityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEAgilityFocusLost
        txtEAgility.setText(String.valueOf(statLimit("agi", PLAYER, txtEAgility.getText())));
        txtERemainStats.setText(String.valueOf(main.eChar.getRemainStats()));
    }//GEN-LAST:event_txtEAgilityFocusLost

    private void txtEHealthFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEHealthFocusGained
        txtEHealth.selectAll();
    }//GEN-LAST:event_txtEHealthFocusGained

    private void txtEHealthFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEHealthFocusLost
        txtEHealth.setText(String.valueOf(statLimit("vit", PLAYER, txtEHealth.getText())));
        txtERemainStats.setText(String.valueOf(main.eChar.getRemainStats()));
    }//GEN-LAST:event_txtEHealthFocusLost

    private void txtEnemyNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEnemyNameFocusGained
        txtEnemyName.selectAll();
    }//GEN-LAST:event_txtEnemyNameFocusGained

    private void txtPlayerNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPlayerNameFocusGained
        txtPlayerName.selectAll();
    }//GEN-LAST:event_txtPlayerNameFocusGained

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
    private javax.swing.JProgressBar barBuffer;
    private javax.swing.JButton btnEReset;
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
    private javax.swing.JButton btnPReset;
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
    private javax.swing.JLabel lblScreenFlash;
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
        //fadeBackGround.animarFade(lblBackground1, 5, 60, "/assets/images/background/" + listaImgBg.get(0), true, false, 0);
        //fadeBackGround.animarFade(lblBackground2, 5, 60, "/assets/images/background/pillai02.png", true, false, 0);
        //worker.cancel(true);
        worker = fw.bufferImg("/assets/images/background/" + listaImgBg.get(0), 0.05f, 16, IN, lblBackground1, barBuffer);
        worker.execute();

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
        this.getContentPane().setComponentZOrder(bg, 17 + z);
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
            System.out.println("Imagem exibida: " + listaImgBg.get(listaIndex));
            return listaImgBg.get(listaIndex);
        }
    }

    private void buildTrackList() {
        trackList.add("tos_SoundTeMP_Topaz.mp3");
        trackList.add("tos_SFA_The_Dignity_of_Wrath.mp3");
        trackList.add("tos_SFA_Journey_In_Heaven.mp3");
    }

    private void popularListaPlayer() {
        listPlayer.add(panPlayerAcessorySlots);
        listPlayer.add(panPlayerDefenseSlots);
        listPlayer.add(panPlayerMainGearSlots);
        Collections.shuffle(listPlayer);
    }

    private void popularListaEnemy() {
        listEnemy.add(panEnemyAcessorySlots);
        listEnemy.add(panEnemyDefenseSlots);
        listEnemy.add(panEnemyMainGearSlots);
        Collections.shuffle(listEnemy);
    }

    private void hideShowGUI(boolean flagHideGUI) {
        if (flagHideGUI) {
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

    public Point getFrameLocation() {
        return this.getLocation();
    }

    private void backToCharSelect() {
        sfx.playSound("GameStart.wav");
        //System.out.println(this.getContentPane().getComponentZOrder(btnArcher));
        lblScreenFlash.setSize(800, 600);
        this.getContentPane().setComponentZOrder(lblScreenFlash, 0);
        //FadeInOut fadeScreen = new FadeInOut();
        //fadeScreen.fade(lblScreenFlash, 5, 30, "/assets/images/blackbg.png", true, false, 0);
        worker.cancel(true);
        worker = fw.bufferImg("/assets/images/blackbg.png", 0.1f, 16, IN, lblScreenFlash, barBuffer);
        worker.execute();
        Timer t = new Timer();
        TimerTask closeScreen = new TimerTask() {
            public void run() {
                counter++;
                if (counter == 2) {
                    music.close();
                    timer.cancel();
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

    private void setDefaultPlayerStats() {
        main.pChar.setLevel(Integer.valueOf(txtPLevel.getText()));
        txtPRemainStats.setText(String.valueOf(main.pChar.getRemainStats()));
        txtPAgility.setText(String.valueOf(main.pChar.getAgility()));
        txtPStrenght.setText(String.valueOf(main.pChar.getStrenght()));
        txtPTalent.setText(String.valueOf(main.pChar.getTalent()));
        txtPSpirit.setText(String.valueOf(main.pChar.getSpirit()));
        txtPHealth.setText(String.valueOf(main.pChar.getHealth()));
    }

    private void setDefaultEnemyStats() {
        main.eChar.setLevel(Integer.valueOf(txtPLevel.getText()));
        txtERemainStats.setText(String.valueOf(main.eChar.getRemainStats()));
        txtEAgility.setText(String.valueOf(main.eChar.getAgility()));
        txtEStrenght.setText(String.valueOf(main.eChar.getStrenght()));
        txtETalent.setText(String.valueOf(main.eChar.getTalent()));
        txtESpirit.setText(String.valueOf(main.eChar.getSpirit()));
        txtEHealth.setText(String.valueOf(main.eChar.getHealth()));
    }

    private int statLimit(String stat, boolean playerOrEnemy, String strValue) {
        int value;
        try {
            value = Integer.parseInt(strValue);
        } catch (NumberFormatException nfe) {
            value = 0;
        }
        CharacterStats character;
        int retValue = 0;
        if (playerOrEnemy = PLAYER) {
            character = main.pChar;
        } else {
            character = main.eChar;
        }
        switch (stat) {
            case "str":
                if (value < character.getBaseStr()) {
                    character.setStrenght(character.getBaseStr());
                    retValue = character.getBaseStr();
                } else if (value > (character.getRemainStats() + character.getStrenght())) {
                    character.setStrenght(character.getBaseStr() + character.getRemainStats());
                    retValue = character.getStrenght();
                } else {
                    character.setStrenght(value);
                    retValue = value;
                }
                break;
            case "spi":
                if (value < character.getBaseSpi()) {
                    character.setSpirit(character.getBaseSpi());
                    retValue = character.getBaseSpi();
                } else if (value > (character.getRemainStats() + character.getSpirit())) {
                    character.setSpirit(character.getBaseSpi() + character.getRemainStats());
                    retValue = character.getSpirit();
                } else {
                    character.setSpirit(value);
                    retValue = value;
                }
                break;
            case "tal":
                if (value < character.getBaseTal()) {
                    character.setTalent(character.getBaseTal());
                    retValue =  character.getBaseTal();
                } else if (value > (character.getRemainStats()+character.getTalent())) {
                    character.setTalent(character.getBaseTal()+ character.getRemainStats());
                    retValue =  character.getTalent();
                } else {
                    character.setTalent(value);
                    retValue =  value;
                }
                break;
            case "agi":
                if (value < character.getBaseAgi()) {
                    character.setAgility(character.getBaseAgi());
                    retValue =  character.getBaseAgi();
                } else if (value > (character.getRemainStats()+character.getAgility())) {
                    character.setAgility(character.getBaseAgi()+ character.getRemainStats());
                    retValue =  character.getAgility();
                } else {
                    character.setAgility(value);
                    retValue =  value;
                }
                break;
            case "vit":
                if (value < character.getBaseVit()) {
                    character.setHealth(character.getBaseVit());
                    retValue =  character.getBaseVit();
                } else if (value > (character.getRemainStats()+character.getHealth())) {
                    character.setHealth(character.getBaseVit()+ character.getRemainStats());
                    retValue =  character.getHealth();
                } else {
                    character.setHealth(value);
                    retValue =  value;
                }
                break;
            default:
                retValue = 9999;
                break;
        }

        if (playerOrEnemy = PLAYER) {
            main.pChar = character;
        } else {
            main.eChar = character;
        }

        return retValue;
    }

    private void setPlayerEnemyCharacter() {
        switch (main.player) {
            case "Atalanta":
                main.pChar = new Atalanta();
                break;
            case "Knight":
                main.pChar = new Knight();
                break;
            case "Magician":
                main.pChar = new Magician();
                break;
            case "Priestess":
                main.pChar = new Priestess();
                break;
            case "Shaman":
                main.pChar = new Shaman();
                break;
            case "Archer":
                main.pChar = new Archer();
                break;
            case "Assassin":
                main.pChar = new Assassin();
                break;
            case "Fighter":
                main.pChar = new Fighter();
                break;
            case "Mechanician":
                main.pChar = new Mechanician();
                break;
            case "Pikeman":
                main.pChar = new Pikeman();
                break;
        }

        switch (main.enemy) {
            case "Atalanta":
                main.eChar = new Atalanta();
                break;
            case "Knight":
                main.eChar = new Knight();
                break;
            case "Magician":
                main.eChar = new Magician();
                break;
            case "Priestess":
                main.eChar = new Priestess();
                break;
            case "Shaman":
                main.eChar = new Shaman();
                break;
            case "Archer":
                main.eChar = new Archer();
                break;
            case "Assassin":
                main.eChar = new Assassin();
                break;
            case "Fighter":
                main.eChar = new Fighter();
                break;
            case "Mechanician":
                main.eChar = new Mechanician();
                break;
            case "Pikeman":
                main.eChar = new Pikeman();
                break;
        }
    }
    
     
}
