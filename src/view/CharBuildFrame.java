/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import animation.ChooseGear;
import animation.FadeInOut;
import animation.FadeWorker;
import animation.VerticalHorizontalAnimation;
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
import item.Item;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
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
import javax.swing.AbstractButton;
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

    //Arrays de imagens e botões relacionados a skills
    //Flag para toggle entre exibir skills e os stats
    boolean toggleSkillP = false;
    boolean toggleSkillE = false;

    SwingWorker worker;
    FadeWorker fw = new FadeWorker();

    ChooseGear animGear = new ChooseGear();

    TextureWork textureWork = new TextureWork();

    final boolean IN = true;
    final boolean OUT = false;
    final boolean PLAYER = true;
    final boolean ENEMY = false;

    final int LVTXTLIMIT = 3;
    final int NAMETXTLIMIT = 13;
    final int STATTXTLIMIT = 3;

    final byte START = 0;
    final byte RESETALL = 1;
    final byte RESETTIER5 = 2;
    final byte RAISE = 3;
    final byte DECREASE = 4;

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

        equipGear = new JdiGearSelector(this, true);
        equipGear.setLocationRelativeTo(this);

        ToolTipManager.sharedInstance().setDismissDelay(Integer.MAX_VALUE);
        UIManager.put("ToolTip.background", new ColorUIResource(0, 0, 0));
        Border border = BorderFactory.createLineBorder(new Color(147, 83, 0), 2); // The color is #4c4f53.
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
                        VerticalHorizontalAnimation scsbPS = new VerticalHorizontalAnimation();
                        VerticalHorizontalAnimation scsbPS2 = new VerticalHorizontalAnimation();
                        scsbPS.showLeftPanel(panPlayerStats, 197, 50);
                        scsbPS2.showDown(lblFraseAjuda, 0, 12);
                        break;
                    case 1:
                        VerticalHorizontalAnimation scsbES = new VerticalHorizontalAnimation();
                        scsbES.showRightPanel(panEnemyStats, 440, 50);
                        break;
                    case 2:
                        VerticalHorizontalAnimation scsbP = new VerticalHorizontalAnimation();
                        VerticalHorizontalAnimation scsbP2 = new VerticalHorizontalAnimation();
                        scsbP.showLeftLabel(lblPlayer, 0, 50);
                        scsbP2.showLeftLabel(lblPlayerClassName, 10, 50);
                        break;
                    case 3:
                        VerticalHorizontalAnimation scsbE = new VerticalHorizontalAnimation();
                        VerticalHorizontalAnimation scsbE2 = new VerticalHorizontalAnimation();
                        scsbE.showRightLabel(lblEnemy, 290, 50);
                        scsbE2.showRightLabel(lblEnemyClassName, 580, 50);
                        sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");
                        break;
                    case 4:
                        VerticalHorizontalAnimation scsb = new VerticalHorizontalAnimation(); //214, 35
                        scsb.showLeftPanel(panPlayerAcessorySlots, 225, 35);
                        sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");
                        break;
                    case 5:
                        VerticalHorizontalAnimation scsb2 = new VerticalHorizontalAnimation();
                        scsb2.showLeftPanel(panPlayerDefenseSlots, 27, 35);
                        sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");
                        break;
                    case 6:
                        VerticalHorizontalAnimation scsb3 = new VerticalHorizontalAnimation();
                        scsb3.showLeftPanel(panPlayerMainGearSlots, 27, 38);
                        sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");
                        break;
                    case 7:
                        VerticalHorizontalAnimation scsb4 = new VerticalHorizontalAnimation();
                        scsb4.showRightPanel(panEnemyAcessorySlots, 468, 35);
                        sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");
                        break;
                    case 8:
                        VerticalHorizontalAnimation scsb5 = new VerticalHorizontalAnimation();
                        scsb5.showRightPanel(panEnemyDefenseSlots, 626, 35);
                        break;
                    case 9:
                        VerticalHorizontalAnimation scsb6 = new VerticalHorizontalAnimation();
                        scsb6.showRightPanel(panEnemyMainGearSlots, 468, 35);
                        sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");
                        break;
                    case 10:
                        VerticalHorizontalAnimation btnSkillP = new VerticalHorizontalAnimation();
                        btnSkillP.showUp(btnShowSkillP, 426, 25);
                        VerticalHorizontalAnimation btnSkillE = new VerticalHorizontalAnimation();
                        btnSkillE.showUp(btnShowSkillE, 426, 25);
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
         Inicialização dos campos de status e skills
         */
        updatePlayerStats();
        updateEnemyStats();

        popularArraysSkillsP();
        popularArraysSkillsE();

        main.pChar.setBaseSkillPoints();
        main.pChar.setInitialSkillPoints();
        
        main.eChar.setBaseSkillPoints();
        main.eChar.setInitialSkillPoints();

        skillWorker(START, main.pChar, 99, 99);
        skillWorker(START, main.eChar, 99, 99);
        //skillWorker(START, main.eChar, 99, 99);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFraseAjuda = new javax.swing.JLabel();
        barBuffer = new javax.swing.JProgressBar();
        btnPlayStopBGM = new javax.swing.JButton();
        btnSwapChar = new javax.swing.JButton();
        btnHideGUI = new javax.swing.JButton();
        panSkillPlayer = new javax.swing.JPanel();
        btnCloseSkillP = new javax.swing.JButton();
        panSkillT1P = new javax.swing.JPanel();
        lblLevelSkill11P = new javax.swing.JLabel();
        lblLevelSkill12P = new javax.swing.JLabel();
        lblLevelSkill13P = new javax.swing.JLabel();
        lblLevelSkill14P = new javax.swing.JLabel();
        btnSkill11P = new javax.swing.JButton();
        lblImgSkill11P = new javax.swing.JLabel();
        btnSkill12P = new javax.swing.JButton();
        lblImgSkill12P = new javax.swing.JLabel();
        btnSkill13P = new javax.swing.JButton();
        lblImgSkill13P = new javax.swing.JLabel();
        btnSkill14P = new javax.swing.JButton();
        lblImgSkill14P = new javax.swing.JLabel();
        btnResetTALLP = new javax.swing.JButton();
        lblClassTitle1P = new javax.swing.JLabel();
        lblFrameTitle1P = new javax.swing.JLabel();
        panSkillT2P = new javax.swing.JPanel();
        lblLevelSkill21P = new javax.swing.JLabel();
        lblLevelSkill22P = new javax.swing.JLabel();
        lblLevelSkill23P = new javax.swing.JLabel();
        lblLevelSkill24P = new javax.swing.JLabel();
        btnSkill21P = new javax.swing.JButton();
        lblImgSkill21P = new javax.swing.JLabel();
        btnSkill22P = new javax.swing.JButton();
        lblImgSkill22P = new javax.swing.JLabel();
        btnSkill23P = new javax.swing.JButton();
        lblImgSkill23P = new javax.swing.JLabel();
        btnSkill24P = new javax.swing.JButton();
        lblImgSkill24P = new javax.swing.JLabel();
        lblClassTitle2P = new javax.swing.JLabel();
        lblFrameTitle2P = new javax.swing.JLabel();
        panSkillT3P = new javax.swing.JPanel();
        lblLevelSkill31P = new javax.swing.JLabel();
        lblLevelSkill32P = new javax.swing.JLabel();
        lblLevelSkill33P = new javax.swing.JLabel();
        lblLevelSkill34P = new javax.swing.JLabel();
        btnSkill31P = new javax.swing.JButton();
        lblImgSkill31P = new javax.swing.JLabel();
        btnSkill32P = new javax.swing.JButton();
        lblImgSkill32P = new javax.swing.JLabel();
        btnSkill33P = new javax.swing.JButton();
        lblImgSkill33P = new javax.swing.JLabel();
        btnSkill34P = new javax.swing.JButton();
        lblImgSkill34P = new javax.swing.JLabel();
        lblClassTitle3P = new javax.swing.JLabel();
        lblFrameTitle3P = new javax.swing.JLabel();
        panSkillT4P = new javax.swing.JPanel();
        lblLevelSkill41P = new javax.swing.JLabel();
        lblLevelSkill42P = new javax.swing.JLabel();
        lblLevelSkill43P = new javax.swing.JLabel();
        lblLevelSkill44P = new javax.swing.JLabel();
        btnSkill41P = new javax.swing.JButton();
        lblImgSkill41P = new javax.swing.JLabel();
        btnSkill42P = new javax.swing.JButton();
        lblImgSkill42P = new javax.swing.JLabel();
        btnSkill43P = new javax.swing.JButton();
        lblImgSkill43P = new javax.swing.JLabel();
        btnSkill44P = new javax.swing.JButton();
        lblImgSkill44P = new javax.swing.JLabel();
        lblClassTitle4P = new javax.swing.JLabel();
        lblFrameTitle4P = new javax.swing.JLabel();
        panSkillT5P = new javax.swing.JPanel();
        lblLevelSkill51P = new javax.swing.JLabel();
        lblLevelSkill52P = new javax.swing.JLabel();
        lblLevelSkill53P = new javax.swing.JLabel();
        lblLevelSkill54P = new javax.swing.JLabel();
        btnSkill51P = new javax.swing.JButton();
        lblImgSkill51P = new javax.swing.JLabel();
        btnSkill52P = new javax.swing.JButton();
        lblImgSkill52P = new javax.swing.JLabel();
        btnSkill53P = new javax.swing.JButton();
        lblImgSkill53P = new javax.swing.JLabel();
        btnSkill54P = new javax.swing.JButton();
        lblImgSkill54P = new javax.swing.JLabel();
        btnResetT5P = new javax.swing.JButton();
        lblClassTitle5P = new javax.swing.JLabel();
        lblFrameTitle5P = new javax.swing.JLabel();
        lblRemainSPP = new javax.swing.JLabel();
        lblRemainEPP = new javax.swing.JLabel();
        lblRemainRSPP = new javax.swing.JLabel();
        lblPlayerSkillBGP = new javax.swing.JLabel();
        panSkillEnemy = new javax.swing.JPanel();
        btnCloseSkillE = new javax.swing.JButton();
        panSkillT1E = new javax.swing.JPanel();
        lblLevelSkill11E = new javax.swing.JLabel();
        lblLevelSkill12E = new javax.swing.JLabel();
        lblLevelSkill13E = new javax.swing.JLabel();
        lblLevelSkill14E = new javax.swing.JLabel();
        btnSkill11E = new javax.swing.JButton();
        lblImgSkill11E = new javax.swing.JLabel();
        btnSkill12E = new javax.swing.JButton();
        lblImgSkill12E = new javax.swing.JLabel();
        btnSkill13E = new javax.swing.JButton();
        lblImgSkill13E = new javax.swing.JLabel();
        btnSkill14E = new javax.swing.JButton();
        lblImgSkill14E = new javax.swing.JLabel();
        btnResetTALLE = new javax.swing.JButton();
        lblClassTitle1E = new javax.swing.JLabel();
        lblFrameTitle1E = new javax.swing.JLabel();
        panSkillT2E = new javax.swing.JPanel();
        lblLevelSkill21E = new javax.swing.JLabel();
        lblLevelSkill22E = new javax.swing.JLabel();
        lblLevelSkill23E = new javax.swing.JLabel();
        lblLevelSkill24E = new javax.swing.JLabel();
        btnSkill21E = new javax.swing.JButton();
        lblImgSkill21E = new javax.swing.JLabel();
        btnSkill22E = new javax.swing.JButton();
        lblImgSkill22E = new javax.swing.JLabel();
        btnSkill23E = new javax.swing.JButton();
        lblImgSkill23E = new javax.swing.JLabel();
        btnSkill24E = new javax.swing.JButton();
        lblImgSkill24E = new javax.swing.JLabel();
        lblClassTitle2E = new javax.swing.JLabel();
        lblFrameTitle2E = new javax.swing.JLabel();
        panSkillT3E = new javax.swing.JPanel();
        lblLevelSkill31E = new javax.swing.JLabel();
        lblLevelSkill32E = new javax.swing.JLabel();
        lblLevelSkill33E = new javax.swing.JLabel();
        lblLevelSkill34E = new javax.swing.JLabel();
        btnSkill31E = new javax.swing.JButton();
        lblImgSkill31E = new javax.swing.JLabel();
        btnSkill32E = new javax.swing.JButton();
        lblImgSkill32E = new javax.swing.JLabel();
        btnSkill33E = new javax.swing.JButton();
        lblImgSkill33E = new javax.swing.JLabel();
        btnSkill34E = new javax.swing.JButton();
        lblImgSkill34E = new javax.swing.JLabel();
        lblClassTitle3E = new javax.swing.JLabel();
        lblFrameTitle3E = new javax.swing.JLabel();
        panSkillT4E = new javax.swing.JPanel();
        lblLevelSkill41E = new javax.swing.JLabel();
        lblLevelSkill42E = new javax.swing.JLabel();
        lblLevelSkill43E = new javax.swing.JLabel();
        lblLevelSkill44E = new javax.swing.JLabel();
        btnSkill41E = new javax.swing.JButton();
        lblImgSkill41E = new javax.swing.JLabel();
        btnSkill42E = new javax.swing.JButton();
        lblImgSkill42E = new javax.swing.JLabel();
        btnSkill43E = new javax.swing.JButton();
        lblImgSkill43E = new javax.swing.JLabel();
        btnSkill44E = new javax.swing.JButton();
        lblImgSkill44E = new javax.swing.JLabel();
        lblClassTitle4E = new javax.swing.JLabel();
        lblFrameTitle4E = new javax.swing.JLabel();
        panSkillT5E = new javax.swing.JPanel();
        lblLevelSkill51E = new javax.swing.JLabel();
        lblLevelSkill52E = new javax.swing.JLabel();
        lblLevelSkill53E = new javax.swing.JLabel();
        lblLevelSkill54E = new javax.swing.JLabel();
        btnSkill51E = new javax.swing.JButton();
        lblImgSkill51E = new javax.swing.JLabel();
        btnSkill52E = new javax.swing.JButton();
        lblImgSkill52E = new javax.swing.JLabel();
        btnSkill53E = new javax.swing.JButton();
        lblImgSkill53E = new javax.swing.JLabel();
        btnSkill54E = new javax.swing.JButton();
        lblImgSkill54E = new javax.swing.JLabel();
        btnResetT5E = new javax.swing.JButton();
        lblClassTitle5E = new javax.swing.JLabel();
        lblFrameTitle5E = new javax.swing.JLabel();
        lblRemainSPE = new javax.swing.JLabel();
        lblRemainEPE = new javax.swing.JLabel();
        lblRemainRSPE = new javax.swing.JLabel();
        lblPlayerSkillBGE = new javax.swing.JLabel();
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
        btnPlayerAmulet = new javax.swing.JButton();
        btnPlayerRing1 = new javax.swing.JButton();
        btnPlayerRing2 = new javax.swing.JButton();
        btnPlayerSheltom = new javax.swing.JButton();
        lblImgCoverAmulet = new javax.swing.JLabel();
        lblImgCoverRing1 = new javax.swing.JLabel();
        lblImgCoverRing2 = new javax.swing.JLabel();
        lblImgCoverSheltom = new javax.swing.JLabel();
        lblPlayerAcessorySlots = new javax.swing.JLabel();
        panPlayerDefenseSlots = new javax.swing.JPanel();
        btnPlayerBracelet = new javax.swing.JButton();
        btnPlayerGauntlet = new javax.swing.JButton();
        btnPlayerBoots = new javax.swing.JButton();
        lblImgCoverBracelet = new javax.swing.JLabel();
        lblImgCoverGauntlet = new javax.swing.JLabel();
        lblImgCoverBoots = new javax.swing.JLabel();
        lblPlayerDefenseSlots = new javax.swing.JLabel();
        panPlayerMainGearSlots = new javax.swing.JPanel();
        btnPlayerWeapon1 = new javax.swing.JButton();
        btnPlayerWeapon2 = new javax.swing.JButton();
        btnPlayerShield = new javax.swing.JButton();
        btnPlayerArmor = new javax.swing.JButton();
        lblImgCover1H = new javax.swing.JLabel();
        lblImgCoverArmor = new javax.swing.JLabel();
        lblImgCoverShield = new javax.swing.JLabel();
        lblImgCover2H = new javax.swing.JLabel();
        lblPlayerMainGearSlots = new javax.swing.JLabel();
        panEnemyAcessorySlots = new javax.swing.JPanel();
        btnEnemyAmulet = new javax.swing.JButton();
        btnEnemyRing1 = new javax.swing.JButton();
        btnEnemyRing2 = new javax.swing.JButton();
        btnEnemySheltom = new javax.swing.JButton();
        lblImgCoverAmuletE = new javax.swing.JLabel();
        lblImgCoverRing1E = new javax.swing.JLabel();
        lblImgCoverRing2E = new javax.swing.JLabel();
        lblImgCoverSheltomE = new javax.swing.JLabel();
        lblEnemyAcessorySlots = new javax.swing.JLabel();
        panEnemyDefenseSlots = new javax.swing.JPanel();
        btnEnemyBracelet = new javax.swing.JButton();
        btnEnemyGauntlet = new javax.swing.JButton();
        btnEnemyBoots = new javax.swing.JButton();
        lblImgCoverBraceletE = new javax.swing.JLabel();
        lblImgCoverGauntletE = new javax.swing.JLabel();
        lblImgCoverBootsE = new javax.swing.JLabel();
        lblEnemyDefenseSlots = new javax.swing.JLabel();
        panEnemyMainGearSlots = new javax.swing.JPanel();
        btnEnemyWeapon1 = new javax.swing.JButton();
        btnEnemyArmor = new javax.swing.JButton();
        btnEnemyShield = new javax.swing.JButton();
        btnEnemyWeapon2 = new javax.swing.JButton();
        lblImgCover1HE = new javax.swing.JLabel();
        lblImgCoverArmorE = new javax.swing.JLabel();
        lblImgCoverShieldE = new javax.swing.JLabel();
        lblImgCover2HE = new javax.swing.JLabel();
        lblEnemyMainGearSlots = new javax.swing.JLabel();
        lblPlayerClassName = new javax.swing.JLabel();
        lblEnemyClassName = new javax.swing.JLabel();
        panSidePlayer = new javax.swing.JPanel();
        btnShowSkillP = new javax.swing.JButton();
        panSideEnemy = new javax.swing.JPanel();
        btnShowSkillE = new javax.swing.JButton();
        lblScreenFlash = new javax.swing.JLabel();
        lblBackground1 = new javax.swing.JLabel();
        lblBackground2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wartale Simulator "+main.version+" - Character Building - Set character's status, gears and skill points."+main.by);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(800, 630));
        setResizable(false);
        getContentPane().setLayout(null);

        lblFraseAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/fraseBuild.png"))); // NOI18N
        getContentPane().add(lblFraseAjuda);
        lblFraseAjuda.setBounds(0, -50, 621, 40);

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

        panSkillPlayer.setOpaque(false);
        panSkillPlayer.setLayout(null);

        btnCloseSkillP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/buttons/btnXClose.png"))); // NOI18N
        btnCloseSkillP.setBorder(null);
        btnCloseSkillP.setBorderPainted(false);
        btnCloseSkillP.setContentAreaFilled(false);
        btnCloseSkillP.setFocusPainted(false);
        btnCloseSkillP.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/buttons/btnXClose.png"))); // NOI18N
        btnCloseSkillP.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/buttons/HbtnXClose.png"))); // NOI18N
        btnCloseSkillP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseSkillPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseSkillPMouseExited(evt);
            }
        });
        btnCloseSkillP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseSkillPActionPerformed(evt);
            }
        });
        panSkillPlayer.add(btnCloseSkillP);
        btnCloseSkillP.setBounds(193, 0, 26, 26);

        panSkillT1P.setOpaque(false);
        panSkillT1P.setLayout(null);

        lblLevelSkill11P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill11P.setText("Lv: 0");
        panSkillT1P.add(lblLevelSkill11P);
        lblLevelSkill11P.setBounds(10, 65, 40, 14);

        lblLevelSkill12P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill12P.setText("Lv: 0");
        panSkillT1P.add(lblLevelSkill12P);
        lblLevelSkill12P.setBounds(60, 65, 40, 14);

        lblLevelSkill13P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill13P.setText("Lv: 0");
        panSkillT1P.add(lblLevelSkill13P);
        lblLevelSkill13P.setBounds(110, 65, 40, 14);

        lblLevelSkill14P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill14P.setText("Lv: 0");
        panSkillT1P.add(lblLevelSkill14P);
        lblLevelSkill14P.setBounds(160, 65, 40, 14);

        btnSkill11P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill11P.setBorder(null);
        btnSkill11P.setBorderPainted(false);
        btnSkill11P.setContentAreaFilled(false);
        btnSkill11P.setFocusPainted(false);
        btnSkill11P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill11P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill11P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill11PMouseClicked(evt);
            }
        });
        btnSkill11P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkill11PActionPerformed(evt);
            }
        });
        panSkillT1P.add(btnSkill11P);
        btnSkill11P.setBounds(0, 25, 48, 44);

        lblImgSkill11P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT1P.add(lblImgSkill11P);
        lblImgSkill11P.setBounds(0, 24, 49, 46);

        btnSkill12P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill12P.setBorder(null);
        btnSkill12P.setBorderPainted(false);
        btnSkill12P.setContentAreaFilled(false);
        btnSkill12P.setFocusPainted(false);
        btnSkill12P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill12P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill12P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill12PMouseClicked(evt);
            }
        });
        btnSkill12P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkill12PActionPerformed(evt);
            }
        });
        panSkillT1P.add(btnSkill12P);
        btnSkill12P.setBounds(50, 25, 48, 44);

        lblImgSkill12P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT1P.add(lblImgSkill12P);
        lblImgSkill12P.setBounds(50, 24, 49, 46);

        btnSkill13P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill13P.setBorder(null);
        btnSkill13P.setBorderPainted(false);
        btnSkill13P.setContentAreaFilled(false);
        btnSkill13P.setFocusPainted(false);
        btnSkill13P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill13P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill13P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill13PMouseClicked(evt);
            }
        });
        panSkillT1P.add(btnSkill13P);
        btnSkill13P.setBounds(100, 25, 48, 44);

        lblImgSkill13P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT1P.add(lblImgSkill13P);
        lblImgSkill13P.setBounds(100, 24, 49, 46);

        btnSkill14P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill14P.setBorder(null);
        btnSkill14P.setBorderPainted(false);
        btnSkill14P.setContentAreaFilled(false);
        btnSkill14P.setFocusPainted(false);
        btnSkill14P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill14P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill14P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill14PMouseClicked(evt);
            }
        });
        panSkillT1P.add(btnSkill14P);
        btnSkill14P.setBounds(150, 25, 48, 44);

        lblImgSkill14P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT1P.add(lblImgSkill14P);
        lblImgSkill14P.setBounds(150, 24, 49, 46);

        btnResetTALLP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/btnResetTALL.png"))); // NOI18N
        btnResetTALLP.setToolTipText("<html><font color='blue'>Reset all skill points.");
        btnResetTALLP.setBorder(null);
        btnResetTALLP.setBorderPainted(false);
        btnResetTALLP.setContentAreaFilled(false);
        btnResetTALLP.setFocusPainted(false);
        btnResetTALLP.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/btnResetTALL.png"))); // NOI18N
        btnResetTALLP.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/HbtnResetTALL.png"))); // NOI18N
        btnResetTALLP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTALLPActionPerformed(evt);
            }
        });
        panSkillT1P.add(btnResetTALLP);
        btnResetTALLP.setBounds(132, -1, 50, 27);

        lblClassTitle1P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/title.png"))); // NOI18N
        panSkillT1P.add(lblClassTitle1P);
        lblClassTitle1P.setBounds(20, 3, 100, 20);

        lblFrameTitle1P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/classTitleFrame1.png"))); // NOI18N
        panSkillT1P.add(lblFrameTitle1P);
        lblFrameTitle1P.setBounds(0, 0, 209, 25);

        panSkillPlayer.add(panSkillT1P);
        panSkillT1P.setBounds(10, 20, 209, 77);

        panSkillT2P.setOpaque(false);
        panSkillT2P.setLayout(null);

        lblLevelSkill21P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill21P.setText("Lv: 0");
        panSkillT2P.add(lblLevelSkill21P);
        lblLevelSkill21P.setBounds(10, 65, 40, 14);

        lblLevelSkill22P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill22P.setText("Lv: 0");
        panSkillT2P.add(lblLevelSkill22P);
        lblLevelSkill22P.setBounds(60, 65, 40, 14);

        lblLevelSkill23P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill23P.setText("Lv: 0");
        panSkillT2P.add(lblLevelSkill23P);
        lblLevelSkill23P.setBounds(110, 65, 40, 14);

        lblLevelSkill24P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill24P.setText("Lv: 0");
        panSkillT2P.add(lblLevelSkill24P);
        lblLevelSkill24P.setBounds(160, 65, 40, 14);

        btnSkill21P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill21P.setBorder(null);
        btnSkill21P.setBorderPainted(false);
        btnSkill21P.setContentAreaFilled(false);
        btnSkill21P.setFocusPainted(false);
        btnSkill21P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill21P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill21P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill21PMouseClicked(evt);
            }
        });
        panSkillT2P.add(btnSkill21P);
        btnSkill21P.setBounds(0, 25, 48, 44);

        lblImgSkill21P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT2P.add(lblImgSkill21P);
        lblImgSkill21P.setBounds(0, 24, 49, 46);

        btnSkill22P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill22P.setBorder(null);
        btnSkill22P.setBorderPainted(false);
        btnSkill22P.setContentAreaFilled(false);
        btnSkill22P.setFocusPainted(false);
        btnSkill22P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill22P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill22P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill22PMouseClicked(evt);
            }
        });
        panSkillT2P.add(btnSkill22P);
        btnSkill22P.setBounds(50, 25, 48, 44);

        lblImgSkill22P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT2P.add(lblImgSkill22P);
        lblImgSkill22P.setBounds(50, 24, 49, 46);

        btnSkill23P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill23P.setBorder(null);
        btnSkill23P.setBorderPainted(false);
        btnSkill23P.setContentAreaFilled(false);
        btnSkill23P.setFocusPainted(false);
        btnSkill23P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill23P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill23P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill23PMouseClicked(evt);
            }
        });
        panSkillT2P.add(btnSkill23P);
        btnSkill23P.setBounds(100, 25, 48, 44);

        lblImgSkill23P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT2P.add(lblImgSkill23P);
        lblImgSkill23P.setBounds(100, 24, 49, 46);

        btnSkill24P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill24P.setBorder(null);
        btnSkill24P.setBorderPainted(false);
        btnSkill24P.setContentAreaFilled(false);
        btnSkill24P.setFocusPainted(false);
        btnSkill24P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill24P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill24P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill24PMouseClicked(evt);
            }
        });
        panSkillT2P.add(btnSkill24P);
        btnSkill24P.setBounds(150, 25, 48, 44);

        lblImgSkill24P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT2P.add(lblImgSkill24P);
        lblImgSkill24P.setBounds(150, 24, 49, 46);

        lblClassTitle2P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/title.png"))); // NOI18N
        panSkillT2P.add(lblClassTitle2P);
        lblClassTitle2P.setBounds(20, 3, 100, 20);

        lblFrameTitle2P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/classTitleFrame2.png"))); // NOI18N
        panSkillT2P.add(lblFrameTitle2P);
        lblFrameTitle2P.setBounds(0, 0, 209, 25);

        panSkillPlayer.add(panSkillT2P);
        panSkillT2P.setBounds(10, 97, 209, 77);

        panSkillT3P.setOpaque(false);
        panSkillT3P.setLayout(null);

        lblLevelSkill31P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill31P.setText("Lv: 0");
        panSkillT3P.add(lblLevelSkill31P);
        lblLevelSkill31P.setBounds(10, 65, 40, 14);

        lblLevelSkill32P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill32P.setText("Lv: 0");
        panSkillT3P.add(lblLevelSkill32P);
        lblLevelSkill32P.setBounds(60, 65, 40, 14);

        lblLevelSkill33P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill33P.setText("Lv: 0");
        panSkillT3P.add(lblLevelSkill33P);
        lblLevelSkill33P.setBounds(110, 65, 40, 14);

        lblLevelSkill34P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill34P.setText("Lv: 0");
        panSkillT3P.add(lblLevelSkill34P);
        lblLevelSkill34P.setBounds(160, 65, 40, 14);

        btnSkill31P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill31P.setBorder(null);
        btnSkill31P.setBorderPainted(false);
        btnSkill31P.setContentAreaFilled(false);
        btnSkill31P.setFocusPainted(false);
        btnSkill31P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill31P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill31P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill31PMouseClicked(evt);
            }
        });
        panSkillT3P.add(btnSkill31P);
        btnSkill31P.setBounds(0, 25, 48, 44);

        lblImgSkill31P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT3P.add(lblImgSkill31P);
        lblImgSkill31P.setBounds(0, 24, 49, 46);

        btnSkill32P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill32P.setBorder(null);
        btnSkill32P.setBorderPainted(false);
        btnSkill32P.setContentAreaFilled(false);
        btnSkill32P.setFocusPainted(false);
        btnSkill32P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill32P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill32P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill32PMouseClicked(evt);
            }
        });
        panSkillT3P.add(btnSkill32P);
        btnSkill32P.setBounds(50, 25, 48, 44);

        lblImgSkill32P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT3P.add(lblImgSkill32P);
        lblImgSkill32P.setBounds(50, 24, 49, 46);

        btnSkill33P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill33P.setBorder(null);
        btnSkill33P.setBorderPainted(false);
        btnSkill33P.setContentAreaFilled(false);
        btnSkill33P.setFocusPainted(false);
        btnSkill33P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill33P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill33P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill33PMouseClicked(evt);
            }
        });
        panSkillT3P.add(btnSkill33P);
        btnSkill33P.setBounds(100, 25, 48, 44);

        lblImgSkill33P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT3P.add(lblImgSkill33P);
        lblImgSkill33P.setBounds(100, 24, 49, 46);

        btnSkill34P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill34P.setBorder(null);
        btnSkill34P.setBorderPainted(false);
        btnSkill34P.setContentAreaFilled(false);
        btnSkill34P.setFocusPainted(false);
        btnSkill34P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill34P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill34P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill34PMouseClicked(evt);
            }
        });
        panSkillT3P.add(btnSkill34P);
        btnSkill34P.setBounds(150, 25, 48, 44);

        lblImgSkill34P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT3P.add(lblImgSkill34P);
        lblImgSkill34P.setBounds(150, 24, 49, 46);

        lblClassTitle3P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/title.png"))); // NOI18N
        panSkillT3P.add(lblClassTitle3P);
        lblClassTitle3P.setBounds(20, 3, 100, 20);

        lblFrameTitle3P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/classTitleFrame1.png"))); // NOI18N
        panSkillT3P.add(lblFrameTitle3P);
        lblFrameTitle3P.setBounds(0, 0, 209, 25);

        panSkillPlayer.add(panSkillT3P);
        panSkillT3P.setBounds(10, 174, 209, 77);

        panSkillT4P.setOpaque(false);
        panSkillT4P.setLayout(null);

        lblLevelSkill41P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill41P.setText("Lv: 0");
        panSkillT4P.add(lblLevelSkill41P);
        lblLevelSkill41P.setBounds(10, 65, 40, 14);

        lblLevelSkill42P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill42P.setText("Lv: 0");
        panSkillT4P.add(lblLevelSkill42P);
        lblLevelSkill42P.setBounds(60, 65, 40, 14);

        lblLevelSkill43P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill43P.setText("Lv: 0");
        panSkillT4P.add(lblLevelSkill43P);
        lblLevelSkill43P.setBounds(110, 65, 40, 14);

        lblLevelSkill44P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill44P.setText("Lv: 0");
        panSkillT4P.add(lblLevelSkill44P);
        lblLevelSkill44P.setBounds(160, 65, 40, 14);

        btnSkill41P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill41P.setBorder(null);
        btnSkill41P.setBorderPainted(false);
        btnSkill41P.setContentAreaFilled(false);
        btnSkill41P.setFocusPainted(false);
        btnSkill41P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill41P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill41P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill41PMouseClicked(evt);
            }
        });
        panSkillT4P.add(btnSkill41P);
        btnSkill41P.setBounds(0, 25, 48, 44);

        lblImgSkill41P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT4P.add(lblImgSkill41P);
        lblImgSkill41P.setBounds(0, 24, 49, 46);

        btnSkill42P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill42P.setBorder(null);
        btnSkill42P.setBorderPainted(false);
        btnSkill42P.setContentAreaFilled(false);
        btnSkill42P.setFocusPainted(false);
        btnSkill42P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill42P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill42P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill42PMouseClicked(evt);
            }
        });
        panSkillT4P.add(btnSkill42P);
        btnSkill42P.setBounds(50, 25, 48, 44);

        lblImgSkill42P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT4P.add(lblImgSkill42P);
        lblImgSkill42P.setBounds(50, 24, 49, 46);

        btnSkill43P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill43P.setBorder(null);
        btnSkill43P.setBorderPainted(false);
        btnSkill43P.setContentAreaFilled(false);
        btnSkill43P.setFocusPainted(false);
        btnSkill43P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill43P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill43P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill43PMouseClicked(evt);
            }
        });
        panSkillT4P.add(btnSkill43P);
        btnSkill43P.setBounds(100, 25, 48, 44);

        lblImgSkill43P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT4P.add(lblImgSkill43P);
        lblImgSkill43P.setBounds(100, 24, 49, 46);

        btnSkill44P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill44P.setBorder(null);
        btnSkill44P.setBorderPainted(false);
        btnSkill44P.setContentAreaFilled(false);
        btnSkill44P.setFocusPainted(false);
        btnSkill44P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill44P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill44P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill44PMouseClicked(evt);
            }
        });
        panSkillT4P.add(btnSkill44P);
        btnSkill44P.setBounds(150, 25, 48, 44);

        lblImgSkill44P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT4P.add(lblImgSkill44P);
        lblImgSkill44P.setBounds(150, 24, 49, 46);

        lblClassTitle4P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/title.png"))); // NOI18N
        panSkillT4P.add(lblClassTitle4P);
        lblClassTitle4P.setBounds(20, 3, 100, 20);

        lblFrameTitle4P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/classTitleFrame1.png"))); // NOI18N
        panSkillT4P.add(lblFrameTitle4P);
        lblFrameTitle4P.setBounds(0, 0, 209, 25);

        panSkillPlayer.add(panSkillT4P);
        panSkillT4P.setBounds(10, 251, 209, 77);

        panSkillT5P.setOpaque(false);
        panSkillT5P.setLayout(null);

        lblLevelSkill51P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill51P.setText("Lv: 0");
        panSkillT5P.add(lblLevelSkill51P);
        lblLevelSkill51P.setBounds(10, 65, 40, 14);

        lblLevelSkill52P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill52P.setText("Lv: 0");
        panSkillT5P.add(lblLevelSkill52P);
        lblLevelSkill52P.setBounds(60, 65, 40, 14);

        lblLevelSkill53P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill53P.setText("Lv: 0");
        panSkillT5P.add(lblLevelSkill53P);
        lblLevelSkill53P.setBounds(110, 65, 40, 14);

        lblLevelSkill54P.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill54P.setText("Lv: 0");
        panSkillT5P.add(lblLevelSkill54P);
        lblLevelSkill54P.setBounds(160, 65, 40, 14);

        btnSkill51P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill51P.setBorder(null);
        btnSkill51P.setBorderPainted(false);
        btnSkill51P.setContentAreaFilled(false);
        btnSkill51P.setFocusPainted(false);
        btnSkill51P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill51P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill51P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill51PMouseClicked(evt);
            }
        });
        panSkillT5P.add(btnSkill51P);
        btnSkill51P.setBounds(0, 25, 48, 44);

        lblImgSkill51P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT5P.add(lblImgSkill51P);
        lblImgSkill51P.setBounds(0, 24, 49, 46);

        btnSkill52P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill52P.setBorder(null);
        btnSkill52P.setBorderPainted(false);
        btnSkill52P.setContentAreaFilled(false);
        btnSkill52P.setFocusPainted(false);
        btnSkill52P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill52P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill52P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill52PMouseClicked(evt);
            }
        });
        panSkillT5P.add(btnSkill52P);
        btnSkill52P.setBounds(50, 25, 48, 44);

        lblImgSkill52P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT5P.add(lblImgSkill52P);
        lblImgSkill52P.setBounds(50, 24, 49, 46);

        btnSkill53P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill53P.setBorder(null);
        btnSkill53P.setBorderPainted(false);
        btnSkill53P.setContentAreaFilled(false);
        btnSkill53P.setFocusPainted(false);
        btnSkill53P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill53P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill53P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill53PMouseClicked(evt);
            }
        });
        panSkillT5P.add(btnSkill53P);
        btnSkill53P.setBounds(100, 25, 48, 44);

        lblImgSkill53P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT5P.add(lblImgSkill53P);
        lblImgSkill53P.setBounds(100, 24, 49, 46);

        btnSkill54P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill54P.setBorder(null);
        btnSkill54P.setBorderPainted(false);
        btnSkill54P.setContentAreaFilled(false);
        btnSkill54P.setFocusPainted(false);
        btnSkill54P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill54P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill54P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill54PMouseClicked(evt);
            }
        });
        panSkillT5P.add(btnSkill54P);
        btnSkill54P.setBounds(150, 25, 48, 44);

        lblImgSkill54P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT5P.add(lblImgSkill54P);
        lblImgSkill54P.setBounds(150, 24, 49, 46);

        btnResetT5P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/btnResetT5.png"))); // NOI18N
        btnResetT5P.setToolTipText("<html><font color='blue'>Reset only Tier5 (RSP) skill points.");
        btnResetT5P.setBorder(null);
        btnResetT5P.setBorderPainted(false);
        btnResetT5P.setContentAreaFilled(false);
        btnResetT5P.setFocusPainted(false);
        btnResetT5P.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/btnResetT5.png"))); // NOI18N
        btnResetT5P.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/HbtnResetT5.png"))); // NOI18N
        btnResetT5P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetT5PActionPerformed(evt);
            }
        });
        panSkillT5P.add(btnResetT5P);
        btnResetT5P.setBounds(132, -1, 50, 27);

        lblClassTitle5P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/title.png"))); // NOI18N
        panSkillT5P.add(lblClassTitle5P);
        lblClassTitle5P.setBounds(20, 3, 100, 20);

        lblFrameTitle5P.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/classTitleFrame1.png"))); // NOI18N
        panSkillT5P.add(lblFrameTitle5P);
        lblFrameTitle5P.setBounds(0, 0, 209, 25);

        panSkillPlayer.add(panSkillT5P);
        panSkillT5P.setBounds(10, 328, 209, 77);

        lblRemainSPP.setForeground(new java.awt.Color(255, 255, 255));
        lblRemainSPP.setText("99");
        panSkillPlayer.add(lblRemainSPP);
        lblRemainSPP.setBounds(33, 6, 20, 10);

        lblRemainEPP.setForeground(new java.awt.Color(255, 255, 255));
        lblRemainEPP.setText("99");
        panSkillPlayer.add(lblRemainEPP);
        lblRemainEPP.setBounds(65, 6, 20, 10);

        lblRemainRSPP.setForeground(new java.awt.Color(255, 255, 255));
        lblRemainRSPP.setText("99");
        panSkillPlayer.add(lblRemainRSPP);
        lblRemainRSPP.setBounds(105, 6, 20, 10);

        lblPlayerSkillBGP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/playerSkillFrame.png"))); // NOI18N
        lblPlayerSkillBGP.setText("jLabel1");
        panSkillPlayer.add(lblPlayerSkillBGP);
        lblPlayerSkillBGP.setBounds(0, 0, 220, 410);

        getContentPane().add(panSkillPlayer);
        panSkillPlayer.setBounds(-220, 34, 220, 410);

        panSkillEnemy.setOpaque(false);
        panSkillEnemy.setLayout(null);

        btnCloseSkillE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/buttons/btnXClose.png"))); // NOI18N
        btnCloseSkillE.setBorder(null);
        btnCloseSkillE.setBorderPainted(false);
        btnCloseSkillE.setContentAreaFilled(false);
        btnCloseSkillE.setFocusPainted(false);
        btnCloseSkillE.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/buttons/btnXClose.png"))); // NOI18N
        btnCloseSkillE.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/buttons/HbtnXClose.png"))); // NOI18N
        btnCloseSkillE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseSkillEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseSkillEMouseExited(evt);
            }
        });
        btnCloseSkillE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseSkillEActionPerformed(evt);
            }
        });
        panSkillEnemy.add(btnCloseSkillE);
        btnCloseSkillE.setBounds(193, 0, 26, 26);

        panSkillT1E.setOpaque(false);
        panSkillT1E.setLayout(null);

        lblLevelSkill11E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill11E.setText("Lv: 0");
        panSkillT1E.add(lblLevelSkill11E);
        lblLevelSkill11E.setBounds(10, 65, 40, 14);

        lblLevelSkill12E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill12E.setText("Lv: 0");
        panSkillT1E.add(lblLevelSkill12E);
        lblLevelSkill12E.setBounds(60, 65, 40, 14);

        lblLevelSkill13E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill13E.setText("Lv: 0");
        panSkillT1E.add(lblLevelSkill13E);
        lblLevelSkill13E.setBounds(110, 65, 40, 14);

        lblLevelSkill14E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill14E.setText("Lv: 0");
        panSkillT1E.add(lblLevelSkill14E);
        lblLevelSkill14E.setBounds(160, 65, 40, 14);

        btnSkill11E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill11E.setBorder(null);
        btnSkill11E.setBorderPainted(false);
        btnSkill11E.setContentAreaFilled(false);
        btnSkill11E.setFocusPainted(false);
        btnSkill11E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill11E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill11E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill11EMouseClicked(evt);
            }
        });
        btnSkill11E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkill11EActionPerformed(evt);
            }
        });
        panSkillT1E.add(btnSkill11E);
        btnSkill11E.setBounds(0, 25, 48, 44);

        lblImgSkill11E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT1E.add(lblImgSkill11E);
        lblImgSkill11E.setBounds(0, 24, 49, 46);

        btnSkill12E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill12E.setBorder(null);
        btnSkill12E.setBorderPainted(false);
        btnSkill12E.setContentAreaFilled(false);
        btnSkill12E.setFocusPainted(false);
        btnSkill12E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill12E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill12E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill12EMouseClicked(evt);
            }
        });
        panSkillT1E.add(btnSkill12E);
        btnSkill12E.setBounds(50, 25, 48, 44);

        lblImgSkill12E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT1E.add(lblImgSkill12E);
        lblImgSkill12E.setBounds(50, 24, 49, 46);

        btnSkill13E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill13E.setBorder(null);
        btnSkill13E.setBorderPainted(false);
        btnSkill13E.setContentAreaFilled(false);
        btnSkill13E.setFocusPainted(false);
        btnSkill13E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill13E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill13E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill13EMouseClicked(evt);
            }
        });
        panSkillT1E.add(btnSkill13E);
        btnSkill13E.setBounds(100, 25, 48, 44);

        lblImgSkill13E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT1E.add(lblImgSkill13E);
        lblImgSkill13E.setBounds(100, 24, 49, 46);

        btnSkill14E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill14E.setBorder(null);
        btnSkill14E.setBorderPainted(false);
        btnSkill14E.setContentAreaFilled(false);
        btnSkill14E.setFocusPainted(false);
        btnSkill14E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill14E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill14E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill14EMouseClicked(evt);
            }
        });
        panSkillT1E.add(btnSkill14E);
        btnSkill14E.setBounds(150, 25, 48, 44);

        lblImgSkill14E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT1E.add(lblImgSkill14E);
        lblImgSkill14E.setBounds(150, 24, 49, 46);

        btnResetTALLE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/btnResetTALL.png"))); // NOI18N
        btnResetTALLE.setToolTipText("<html><font color='blue'>Reset all skill points.");
        btnResetTALLE.setBorder(null);
        btnResetTALLE.setBorderPainted(false);
        btnResetTALLE.setContentAreaFilled(false);
        btnResetTALLE.setFocusPainted(false);
        btnResetTALLE.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/btnResetTALL.png"))); // NOI18N
        btnResetTALLE.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/HbtnResetTALL.png"))); // NOI18N
        btnResetTALLE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTALLEActionPerformed(evt);
            }
        });
        panSkillT1E.add(btnResetTALLE);
        btnResetTALLE.setBounds(132, -1, 50, 27);

        lblClassTitle1E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/title.png"))); // NOI18N
        panSkillT1E.add(lblClassTitle1E);
        lblClassTitle1E.setBounds(20, 3, 100, 20);

        lblFrameTitle1E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/classTitleFrame1.png"))); // NOI18N
        panSkillT1E.add(lblFrameTitle1E);
        lblFrameTitle1E.setBounds(0, 0, 209, 25);

        panSkillEnemy.add(panSkillT1E);
        panSkillT1E.setBounds(10, 20, 209, 77);

        panSkillT2E.setOpaque(false);
        panSkillT2E.setLayout(null);

        lblLevelSkill21E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill21E.setText("Lv: 0");
        panSkillT2E.add(lblLevelSkill21E);
        lblLevelSkill21E.setBounds(10, 65, 40, 14);

        lblLevelSkill22E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill22E.setText("Lv: 0");
        panSkillT2E.add(lblLevelSkill22E);
        lblLevelSkill22E.setBounds(60, 65, 40, 14);

        lblLevelSkill23E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill23E.setText("Lv: 0");
        panSkillT2E.add(lblLevelSkill23E);
        lblLevelSkill23E.setBounds(110, 65, 40, 14);

        lblLevelSkill24E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill24E.setText("Lv: 0");
        panSkillT2E.add(lblLevelSkill24E);
        lblLevelSkill24E.setBounds(160, 65, 40, 14);

        btnSkill21E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill21E.setBorder(null);
        btnSkill21E.setBorderPainted(false);
        btnSkill21E.setContentAreaFilled(false);
        btnSkill21E.setFocusPainted(false);
        btnSkill21E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill21E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill21E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill21EMouseClicked(evt);
            }
        });
        btnSkill21E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkill21EActionPerformed(evt);
            }
        });
        panSkillT2E.add(btnSkill21E);
        btnSkill21E.setBounds(0, 25, 48, 44);

        lblImgSkill21E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT2E.add(lblImgSkill21E);
        lblImgSkill21E.setBounds(0, 24, 49, 46);

        btnSkill22E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill22E.setBorder(null);
        btnSkill22E.setBorderPainted(false);
        btnSkill22E.setContentAreaFilled(false);
        btnSkill22E.setFocusPainted(false);
        btnSkill22E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill22E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill22E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill22EMouseClicked(evt);
            }
        });
        panSkillT2E.add(btnSkill22E);
        btnSkill22E.setBounds(50, 25, 48, 44);

        lblImgSkill22E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT2E.add(lblImgSkill22E);
        lblImgSkill22E.setBounds(50, 24, 49, 46);

        btnSkill23E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill23E.setBorder(null);
        btnSkill23E.setBorderPainted(false);
        btnSkill23E.setContentAreaFilled(false);
        btnSkill23E.setFocusPainted(false);
        btnSkill23E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill23E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill23E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill23EMouseClicked(evt);
            }
        });
        panSkillT2E.add(btnSkill23E);
        btnSkill23E.setBounds(100, 25, 48, 44);

        lblImgSkill23E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT2E.add(lblImgSkill23E);
        lblImgSkill23E.setBounds(100, 24, 49, 46);

        btnSkill24E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill24E.setBorder(null);
        btnSkill24E.setBorderPainted(false);
        btnSkill24E.setContentAreaFilled(false);
        btnSkill24E.setFocusPainted(false);
        btnSkill24E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill24E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill24E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill24EMouseClicked(evt);
            }
        });
        panSkillT2E.add(btnSkill24E);
        btnSkill24E.setBounds(150, 25, 48, 44);

        lblImgSkill24E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT2E.add(lblImgSkill24E);
        lblImgSkill24E.setBounds(150, 24, 49, 46);

        lblClassTitle2E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/title.png"))); // NOI18N
        panSkillT2E.add(lblClassTitle2E);
        lblClassTitle2E.setBounds(20, 3, 100, 20);

        lblFrameTitle2E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/classTitleFrame2.png"))); // NOI18N
        panSkillT2E.add(lblFrameTitle2E);
        lblFrameTitle2E.setBounds(0, 0, 209, 25);

        panSkillEnemy.add(panSkillT2E);
        panSkillT2E.setBounds(10, 97, 209, 77);

        panSkillT3E.setOpaque(false);
        panSkillT3E.setLayout(null);

        lblLevelSkill31E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill31E.setText("Lv: 0");
        panSkillT3E.add(lblLevelSkill31E);
        lblLevelSkill31E.setBounds(10, 65, 40, 14);

        lblLevelSkill32E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill32E.setText("Lv: 0");
        panSkillT3E.add(lblLevelSkill32E);
        lblLevelSkill32E.setBounds(60, 65, 40, 14);

        lblLevelSkill33E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill33E.setText("Lv: 0");
        panSkillT3E.add(lblLevelSkill33E);
        lblLevelSkill33E.setBounds(110, 65, 40, 14);

        lblLevelSkill34E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill34E.setText("Lv: 0");
        panSkillT3E.add(lblLevelSkill34E);
        lblLevelSkill34E.setBounds(160, 65, 40, 14);

        btnSkill31E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill31E.setBorder(null);
        btnSkill31E.setBorderPainted(false);
        btnSkill31E.setContentAreaFilled(false);
        btnSkill31E.setFocusPainted(false);
        btnSkill31E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill31E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill31E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill31EMouseClicked(evt);
            }
        });
        panSkillT3E.add(btnSkill31E);
        btnSkill31E.setBounds(0, 25, 48, 44);

        lblImgSkill31E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT3E.add(lblImgSkill31E);
        lblImgSkill31E.setBounds(0, 24, 49, 46);

        btnSkill32E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill32E.setBorder(null);
        btnSkill32E.setBorderPainted(false);
        btnSkill32E.setContentAreaFilled(false);
        btnSkill32E.setFocusPainted(false);
        btnSkill32E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill32E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill32E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill32EMouseClicked(evt);
            }
        });
        panSkillT3E.add(btnSkill32E);
        btnSkill32E.setBounds(50, 25, 48, 44);

        lblImgSkill32E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT3E.add(lblImgSkill32E);
        lblImgSkill32E.setBounds(50, 24, 49, 46);

        btnSkill33E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill33E.setBorder(null);
        btnSkill33E.setBorderPainted(false);
        btnSkill33E.setContentAreaFilled(false);
        btnSkill33E.setFocusPainted(false);
        btnSkill33E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill33E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill33E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill33EMouseClicked(evt);
            }
        });
        panSkillT3E.add(btnSkill33E);
        btnSkill33E.setBounds(100, 25, 48, 44);

        lblImgSkill33E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT3E.add(lblImgSkill33E);
        lblImgSkill33E.setBounds(100, 24, 49, 46);

        btnSkill34E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill34E.setBorder(null);
        btnSkill34E.setBorderPainted(false);
        btnSkill34E.setContentAreaFilled(false);
        btnSkill34E.setFocusPainted(false);
        btnSkill34E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill34E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill34E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill34EMouseClicked(evt);
            }
        });
        panSkillT3E.add(btnSkill34E);
        btnSkill34E.setBounds(150, 25, 48, 44);

        lblImgSkill34E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT3E.add(lblImgSkill34E);
        lblImgSkill34E.setBounds(150, 24, 49, 46);

        lblClassTitle3E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/title.png"))); // NOI18N
        panSkillT3E.add(lblClassTitle3E);
        lblClassTitle3E.setBounds(20, 3, 100, 20);

        lblFrameTitle3E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/classTitleFrame1.png"))); // NOI18N
        panSkillT3E.add(lblFrameTitle3E);
        lblFrameTitle3E.setBounds(0, 0, 209, 25);

        panSkillEnemy.add(panSkillT3E);
        panSkillT3E.setBounds(10, 174, 209, 77);

        panSkillT4E.setOpaque(false);
        panSkillT4E.setLayout(null);

        lblLevelSkill41E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill41E.setText("Lv: 0");
        panSkillT4E.add(lblLevelSkill41E);
        lblLevelSkill41E.setBounds(10, 65, 40, 14);

        lblLevelSkill42E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill42E.setText("Lv: 0");
        panSkillT4E.add(lblLevelSkill42E);
        lblLevelSkill42E.setBounds(60, 65, 40, 14);

        lblLevelSkill43E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill43E.setText("Lv: 0");
        panSkillT4E.add(lblLevelSkill43E);
        lblLevelSkill43E.setBounds(110, 65, 40, 14);

        lblLevelSkill44E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill44E.setText("Lv: 0");
        panSkillT4E.add(lblLevelSkill44E);
        lblLevelSkill44E.setBounds(160, 65, 40, 14);

        btnSkill41E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill41E.setBorder(null);
        btnSkill41E.setBorderPainted(false);
        btnSkill41E.setContentAreaFilled(false);
        btnSkill41E.setFocusPainted(false);
        btnSkill41E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill41E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill41E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill41EMouseClicked(evt);
            }
        });
        panSkillT4E.add(btnSkill41E);
        btnSkill41E.setBounds(0, 25, 48, 44);

        lblImgSkill41E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT4E.add(lblImgSkill41E);
        lblImgSkill41E.setBounds(0, 24, 49, 46);

        btnSkill42E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill42E.setBorder(null);
        btnSkill42E.setBorderPainted(false);
        btnSkill42E.setContentAreaFilled(false);
        btnSkill42E.setFocusPainted(false);
        btnSkill42E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill42E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill42E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill42EMouseClicked(evt);
            }
        });
        panSkillT4E.add(btnSkill42E);
        btnSkill42E.setBounds(50, 25, 48, 44);

        lblImgSkill42E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT4E.add(lblImgSkill42E);
        lblImgSkill42E.setBounds(50, 24, 49, 46);

        btnSkill43E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill43E.setBorder(null);
        btnSkill43E.setBorderPainted(false);
        btnSkill43E.setContentAreaFilled(false);
        btnSkill43E.setFocusPainted(false);
        btnSkill43E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill43E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill43E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill43EMouseClicked(evt);
            }
        });
        panSkillT4E.add(btnSkill43E);
        btnSkill43E.setBounds(100, 25, 48, 44);

        lblImgSkill43E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT4E.add(lblImgSkill43E);
        lblImgSkill43E.setBounds(100, 24, 49, 46);

        btnSkill44E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill44E.setBorder(null);
        btnSkill44E.setBorderPainted(false);
        btnSkill44E.setContentAreaFilled(false);
        btnSkill44E.setFocusPainted(false);
        btnSkill44E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill44E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill44E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill44EMouseClicked(evt);
            }
        });
        panSkillT4E.add(btnSkill44E);
        btnSkill44E.setBounds(150, 25, 48, 44);

        lblImgSkill44E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT4E.add(lblImgSkill44E);
        lblImgSkill44E.setBounds(150, 24, 49, 46);

        lblClassTitle4E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/title.png"))); // NOI18N
        panSkillT4E.add(lblClassTitle4E);
        lblClassTitle4E.setBounds(20, 3, 100, 20);

        lblFrameTitle4E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/classTitleFrame1.png"))); // NOI18N
        panSkillT4E.add(lblFrameTitle4E);
        lblFrameTitle4E.setBounds(0, 0, 209, 25);

        panSkillEnemy.add(panSkillT4E);
        panSkillT4E.setBounds(10, 251, 209, 77);

        panSkillT5E.setOpaque(false);
        panSkillT5E.setLayout(null);

        lblLevelSkill51E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill51E.setText("Lv: 0");
        panSkillT5E.add(lblLevelSkill51E);
        lblLevelSkill51E.setBounds(10, 65, 40, 14);

        lblLevelSkill52E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill52E.setText("Lv: 0");
        panSkillT5E.add(lblLevelSkill52E);
        lblLevelSkill52E.setBounds(60, 65, 40, 14);

        lblLevelSkill53E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill53E.setText("Lv: 0");
        panSkillT5E.add(lblLevelSkill53E);
        lblLevelSkill53E.setBounds(110, 65, 40, 14);

        lblLevelSkill54E.setForeground(new java.awt.Color(255, 0, 0));
        lblLevelSkill54E.setText("Lv: 0");
        panSkillT5E.add(lblLevelSkill54E);
        lblLevelSkill54E.setBounds(160, 65, 40, 14);

        btnSkill51E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill51E.setBorder(null);
        btnSkill51E.setBorderPainted(false);
        btnSkill51E.setContentAreaFilled(false);
        btnSkill51E.setFocusPainted(false);
        btnSkill51E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill51E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill51E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill51EMouseClicked(evt);
            }
        });
        panSkillT5E.add(btnSkill51E);
        btnSkill51E.setBounds(0, 25, 48, 44);

        lblImgSkill51E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT5E.add(lblImgSkill51E);
        lblImgSkill51E.setBounds(0, 24, 49, 46);

        btnSkill52E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill52E.setBorder(null);
        btnSkill52E.setBorderPainted(false);
        btnSkill52E.setContentAreaFilled(false);
        btnSkill52E.setFocusPainted(false);
        btnSkill52E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill52E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill52E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill52EMouseClicked(evt);
            }
        });
        panSkillT5E.add(btnSkill52E);
        btnSkill52E.setBounds(50, 25, 48, 44);

        lblImgSkill52E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT5E.add(lblImgSkill52E);
        lblImgSkill52E.setBounds(50, 24, 49, 46);

        btnSkill53E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill53E.setBorder(null);
        btnSkill53E.setBorderPainted(false);
        btnSkill53E.setContentAreaFilled(false);
        btnSkill53E.setFocusPainted(false);
        btnSkill53E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill53E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill53E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill53EMouseClicked(evt);
            }
        });
        panSkillT5E.add(btnSkill53E);
        btnSkill53E.setBounds(100, 25, 48, 44);

        lblImgSkill53E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT5E.add(lblImgSkill53E);
        lblImgSkill53E.setBounds(100, 24, 49, 46);

        btnSkill54E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill54E.setBorder(null);
        btnSkill54E.setBorderPainted(false);
        btnSkill54E.setContentAreaFilled(false);
        btnSkill54E.setFocusPainted(false);
        btnSkill54E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/btnskill.png"))); // NOI18N
        btnSkill54E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/Hbtnskill.png"))); // NOI18N
        btnSkill54E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSkill54EMouseClicked(evt);
            }
        });
        panSkillT5E.add(btnSkill54E);
        btnSkill54E.setBounds(150, 25, 48, 44);

        lblImgSkill54E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/ks1.png"))); // NOI18N
        panSkillT5E.add(lblImgSkill54E);
        lblImgSkill54E.setBounds(150, 24, 49, 46);

        btnResetT5E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/btnResetT5.png"))); // NOI18N
        btnResetT5E.setToolTipText("<html><font color='blue'>Reset only Tier5 (RSP) skill points.");
        btnResetT5E.setBorder(null);
        btnResetT5E.setBorderPainted(false);
        btnResetT5E.setContentAreaFilled(false);
        btnResetT5E.setFocusPainted(false);
        btnResetT5E.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/btnResetT5.png"))); // NOI18N
        btnResetT5E.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/HbtnResetT5.png"))); // NOI18N
        btnResetT5E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetT5EActionPerformed(evt);
            }
        });
        panSkillT5E.add(btnResetT5E);
        btnResetT5E.setBounds(132, -1, 50, 27);

        lblClassTitle5E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/title.png"))); // NOI18N
        panSkillT5E.add(lblClassTitle5E);
        lblClassTitle5E.setBounds(20, 3, 100, 20);

        lblFrameTitle5E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/skills/inter/classTitleFrame1.png"))); // NOI18N
        panSkillT5E.add(lblFrameTitle5E);
        lblFrameTitle5E.setBounds(0, 0, 209, 25);

        panSkillEnemy.add(panSkillT5E);
        panSkillT5E.setBounds(10, 328, 209, 77);

        lblRemainSPE.setForeground(new java.awt.Color(255, 255, 255));
        lblRemainSPE.setText("99");
        panSkillEnemy.add(lblRemainSPE);
        lblRemainSPE.setBounds(33, 6, 20, 10);

        lblRemainEPE.setForeground(new java.awt.Color(255, 255, 255));
        lblRemainEPE.setText("99");
        panSkillEnemy.add(lblRemainEPE);
        lblRemainEPE.setBounds(65, 6, 20, 10);

        lblRemainRSPE.setForeground(new java.awt.Color(255, 255, 255));
        lblRemainRSPE.setText("99");
        panSkillEnemy.add(lblRemainRSPE);
        lblRemainRSPE.setBounds(105, 6, 20, 10);

        lblPlayerSkillBGE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/enemySkillFrame.png"))); // NOI18N
        lblPlayerSkillBGE.setText("jLabel1");
        panSkillEnemy.add(lblPlayerSkillBGE);
        lblPlayerSkillBGE.setBounds(0, 0, 220, 410);

        getContentPane().add(panSkillEnemy);
        panSkillEnemy.setBounds(800, 34, 220, 410);

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
        txtPlayerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPlayerNameKeyPressed(evt);
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
        txtPLevel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPLevelKeyPressed(evt);
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
        txtPStrenght.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPStrenghtKeyPressed(evt);
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
        txtPSpirit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPSpiritKeyPressed(evt);
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
        txtPTalent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPTalentKeyPressed(evt);
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
        txtPAgility.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPAgilityKeyPressed(evt);
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
        txtPHealth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPHealthKeyPressed(evt);
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
        txtEnemyName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEnemyNameKeyPressed(evt);
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
        txtELevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtELevelActionPerformed(evt);
            }
        });
        txtELevel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtELevelKeyPressed(evt);
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
        txtEStrenght.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEStrenghtActionPerformed(evt);
            }
        });
        txtEStrenght.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEStrenghtKeyPressed(evt);
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
        txtESpirit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtESpiritKeyPressed(evt);
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
        txtETalent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtETalentKeyPressed(evt);
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
        txtEAgility.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEAgilityKeyPressed(evt);
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
        txtEHealth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEHealthKeyPressed(evt);
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

        btnPlayerAmulet.setBorder(null);
        btnPlayerAmulet.setBorderPainted(false);
        btnPlayerAmulet.setContentAreaFilled(false);
        btnPlayerAmulet.setFocusPainted(false);
        btnPlayerAmulet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayerAmuletMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlayerAmuletMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlayerAmuletMouseExited(evt);
            }
        });
        btnPlayerAmulet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerAmuletActionPerformed(evt);
            }
        });
        panPlayerAcessorySlots.add(btnPlayerAmulet);
        btnPlayerAmulet.setBounds(2, 2, 23, 23);

        btnPlayerRing1.setBorder(null);
        btnPlayerRing1.setBorderPainted(false);
        btnPlayerRing1.setContentAreaFilled(false);
        btnPlayerRing1.setFocusPainted(false);
        btnPlayerRing1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayerRing1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlayerRing1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlayerRing1MouseExited(evt);
            }
        });
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
        btnPlayerRing2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayerRing2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlayerRing2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlayerRing2MouseExited(evt);
            }
        });
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
        btnPlayerSheltom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayerSheltomMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlayerSheltomMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlayerSheltomMouseExited(evt);
            }
        });
        btnPlayerSheltom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerSheltomActionPerformed(evt);
            }
        });
        panPlayerAcessorySlots.add(btnPlayerSheltom);
        btnPlayerSheltom.setBounds(80, 2, 23, 23);

        lblImgCoverAmulet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverAmulet.png"))); // NOI18N
        panPlayerAcessorySlots.add(lblImgCoverAmulet);
        lblImgCoverAmulet.setBounds(2, 2, 23, 23);

        lblImgCoverRing1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverRing.png"))); // NOI18N
        panPlayerAcessorySlots.add(lblImgCoverRing1);
        lblImgCoverRing1.setBounds(29, 2, 23, 23);

        lblImgCoverRing2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverRing.png"))); // NOI18N
        panPlayerAcessorySlots.add(lblImgCoverRing2);
        lblImgCoverRing2.setBounds(54, 2, 23, 23);

        lblImgCoverSheltom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverSheltom.png"))); // NOI18N
        panPlayerAcessorySlots.add(lblImgCoverSheltom);
        lblImgCoverSheltom.setBounds(80, 2, 23, 23);

        lblPlayerAcessorySlots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/acessorySlots.png"))); // NOI18N
        lblPlayerAcessorySlots.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panPlayerAcessorySlots.add(lblPlayerAcessorySlots);
        lblPlayerAcessorySlots.setBounds(0, 0, 105, 27);

        getContentPane().add(panPlayerAcessorySlots);
        panPlayerAcessorySlots.setBounds(-150, 443, 105, 27);

        panPlayerDefenseSlots.setOpaque(false);
        panPlayerDefenseSlots.setLayout(null);

        btnPlayerBracelet.setBorder(null);
        btnPlayerBracelet.setBorderPainted(false);
        btnPlayerBracelet.setContentAreaFilled(false);
        btnPlayerBracelet.setFocusPainted(false);
        btnPlayerBracelet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayerBraceletMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlayerBraceletMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlayerBraceletMouseExited(evt);
            }
        });
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
        btnPlayerGauntlet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayerGauntletMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlayerGauntletMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlayerGauntletMouseExited(evt);
            }
        });
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
        btnPlayerBoots.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayerBootsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlayerBootsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlayerBootsMouseExited(evt);
            }
        });
        btnPlayerBoots.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerBootsActionPerformed(evt);
            }
        });
        panPlayerDefenseSlots.add(btnPlayerBoots);
        btnPlayerBoots.setBounds(98, 2, 45, 45);

        lblImgCoverBracelet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverBracelet.png"))); // NOI18N
        panPlayerDefenseSlots.add(lblImgCoverBracelet);
        lblImgCoverBracelet.setBounds(3, 3, 43, 43);

        lblImgCoverGauntlet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverGauntlet.png"))); // NOI18N
        panPlayerDefenseSlots.add(lblImgCoverGauntlet);
        lblImgCoverGauntlet.setBounds(51, 3, 43, 43);

        lblImgCoverBoots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverBoots.png"))); // NOI18N
        panPlayerDefenseSlots.add(lblImgCoverBoots);
        lblImgCoverBoots.setBounds(99, 3, 43, 43);

        lblPlayerDefenseSlots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/defenseSlots.png"))); // NOI18N
        lblPlayerDefenseSlots.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panPlayerDefenseSlots.add(lblPlayerDefenseSlots);
        lblPlayerDefenseSlots.setBounds(0, 0, 145, 49);

        getContentPane().add(panPlayerDefenseSlots);
        panPlayerDefenseSlots.setBounds(-150, 421, 145, 49);

        panPlayerMainGearSlots.setOpaque(false);
        panPlayerMainGearSlots.setLayout(null);

        btnPlayerWeapon1.setBorder(null);
        btnPlayerWeapon1.setBorderPainted(false);
        btnPlayerWeapon1.setContentAreaFilled(false);
        btnPlayerWeapon1.setFocusPainted(false);
        btnPlayerWeapon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayerWeapon1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlayerWeapon1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlayerWeapon1MouseExited(evt);
            }
        });
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
        btnPlayerWeapon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayerWeapon2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlayerWeapon2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlayerWeapon2MouseExited(evt);
            }
        });
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
        btnPlayerShield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayerShieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlayerShieldMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlayerShieldMouseExited(evt);
            }
        });
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
        btnPlayerArmor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayerArmorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlayerArmorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlayerArmorMouseExited(evt);
            }
        });
        btnPlayerArmor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerArmorActionPerformed(evt);
            }
        });
        panPlayerMainGearSlots.add(btnPlayerArmor);
        btnPlayerArmor.setBounds(83, 7, 67, 112);

        lblImgCover1H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/cover1H.png"))); // NOI18N
        panPlayerMainGearSlots.add(lblImgCover1H);
        lblImgCover1H.setBounds(9, 7, 67, 112);

        lblImgCoverArmor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverArmor.png"))); // NOI18N
        panPlayerMainGearSlots.add(lblImgCoverArmor);
        lblImgCoverArmor.setBounds(83, 7, 67, 112);

        lblImgCoverShield.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverShield.png"))); // NOI18N
        panPlayerMainGearSlots.add(lblImgCoverShield);
        lblImgCoverShield.setBounds(157, 7, 67, 112);

        lblImgCover2H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/cover2H.png"))); // NOI18N
        panPlayerMainGearSlots.add(lblImgCover2H);
        lblImgCover2H.setBounds(231, 7, 67, 112);

        lblPlayerMainGearSlots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/mainGearsSlots.png"))); // NOI18N
        lblPlayerMainGearSlots.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panPlayerMainGearSlots.add(lblPlayerMainGearSlots);
        lblPlayerMainGearSlots.setBounds(0, 0, 303, 127);

        getContentPane().add(panPlayerMainGearSlots);
        panPlayerMainGearSlots.setBounds(-350, 472, 303, 127);

        panEnemyAcessorySlots.setOpaque(false);
        panEnemyAcessorySlots.setLayout(null);

        btnEnemyAmulet.setBorder(null);
        btnEnemyAmulet.setBorderPainted(false);
        btnEnemyAmulet.setContentAreaFilled(false);
        btnEnemyAmulet.setFocusPainted(false);
        btnEnemyAmulet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnemyAmuletMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnemyAmuletMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnemyAmuletMouseExited(evt);
            }
        });
        btnEnemyAmulet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemyAmuletActionPerformed(evt);
            }
        });
        panEnemyAcessorySlots.add(btnEnemyAmulet);
        btnEnemyAmulet.setBounds(2, 2, 23, 23);

        btnEnemyRing1.setBorder(null);
        btnEnemyRing1.setBorderPainted(false);
        btnEnemyRing1.setContentAreaFilled(false);
        btnEnemyRing1.setFocusPainted(false);
        btnEnemyRing1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnemyRing1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnemyRing1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnemyRing1MouseExited(evt);
            }
        });
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
        btnEnemyRing2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnemyRing2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnemyRing2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnemyRing2MouseExited(evt);
            }
        });
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
        btnEnemySheltom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnemySheltomMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnemySheltomMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnemySheltomMouseExited(evt);
            }
        });
        btnEnemySheltom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemySheltomActionPerformed(evt);
            }
        });
        panEnemyAcessorySlots.add(btnEnemySheltom);
        btnEnemySheltom.setBounds(80, 2, 23, 23);

        lblImgCoverAmuletE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverAmulet.png"))); // NOI18N
        panEnemyAcessorySlots.add(lblImgCoverAmuletE);
        lblImgCoverAmuletE.setBounds(2, 2, 23, 23);

        lblImgCoverRing1E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverRing.png"))); // NOI18N
        panEnemyAcessorySlots.add(lblImgCoverRing1E);
        lblImgCoverRing1E.setBounds(29, 2, 23, 23);

        lblImgCoverRing2E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverRing.png"))); // NOI18N
        panEnemyAcessorySlots.add(lblImgCoverRing2E);
        lblImgCoverRing2E.setBounds(54, 2, 23, 23);

        lblImgCoverSheltomE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverSheltom.png"))); // NOI18N
        panEnemyAcessorySlots.add(lblImgCoverSheltomE);
        lblImgCoverSheltomE.setBounds(80, 2, 23, 23);

        lblEnemyAcessorySlots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/acessorySlots.png"))); // NOI18N
        lblEnemyAcessorySlots.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panEnemyAcessorySlots.add(lblEnemyAcessorySlots);
        lblEnemyAcessorySlots.setBounds(0, 0, 105, 27);

        getContentPane().add(panEnemyAcessorySlots);
        panEnemyAcessorySlots.setBounds(810, 443, 105, 27);

        panEnemyDefenseSlots.setOpaque(false);
        panEnemyDefenseSlots.setLayout(null);

        btnEnemyBracelet.setBorder(null);
        btnEnemyBracelet.setBorderPainted(false);
        btnEnemyBracelet.setContentAreaFilled(false);
        btnEnemyBracelet.setFocusPainted(false);
        btnEnemyBracelet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnemyBraceletMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnemyBraceletMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnemyBraceletMouseExited(evt);
            }
        });
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
        btnEnemyGauntlet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnemyGauntletMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnemyGauntletMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnemyGauntletMouseExited(evt);
            }
        });
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
        btnEnemyBoots.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnemyBootsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnemyBootsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnemyBootsMouseExited(evt);
            }
        });
        btnEnemyBoots.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemyBootsActionPerformed(evt);
            }
        });
        panEnemyDefenseSlots.add(btnEnemyBoots);
        btnEnemyBoots.setBounds(98, 2, 45, 45);

        lblImgCoverBraceletE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverBracelet.png"))); // NOI18N
        panEnemyDefenseSlots.add(lblImgCoverBraceletE);
        lblImgCoverBraceletE.setBounds(3, 3, 43, 43);

        lblImgCoverGauntletE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverGauntlet.png"))); // NOI18N
        panEnemyDefenseSlots.add(lblImgCoverGauntletE);
        lblImgCoverGauntletE.setBounds(51, 3, 43, 43);

        lblImgCoverBootsE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverBoots.png"))); // NOI18N
        panEnemyDefenseSlots.add(lblImgCoverBootsE);
        lblImgCoverBootsE.setBounds(99, 3, 43, 43);

        lblEnemyDefenseSlots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/defenseSlots.png"))); // NOI18N
        lblEnemyDefenseSlots.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panEnemyDefenseSlots.add(lblEnemyDefenseSlots);
        lblEnemyDefenseSlots.setBounds(0, 0, 145, 49);

        getContentPane().add(panEnemyDefenseSlots);
        panEnemyDefenseSlots.setBounds(810, 421, 145, 49);

        panEnemyMainGearSlots.setOpaque(false);
        panEnemyMainGearSlots.setLayout(null);

        btnEnemyWeapon1.setBorder(null);
        btnEnemyWeapon1.setBorderPainted(false);
        btnEnemyWeapon1.setContentAreaFilled(false);
        btnEnemyWeapon1.setFocusPainted(false);
        btnEnemyWeapon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnemyWeapon1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnemyWeapon1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnemyWeapon1MouseExited(evt);
            }
        });
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
        btnEnemyArmor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnemyArmorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnemyArmorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnemyArmorMouseExited(evt);
            }
        });
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
        btnEnemyShield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnemyShieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnemyShieldMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnemyShieldMouseExited(evt);
            }
        });
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
        btnEnemyWeapon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnemyWeapon2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnemyWeapon2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnemyWeapon2MouseExited(evt);
            }
        });
        btnEnemyWeapon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnemyWeapon2ActionPerformed(evt);
            }
        });
        panEnemyMainGearSlots.add(btnEnemyWeapon2);
        btnEnemyWeapon2.setBounds(230, 7, 67, 112);

        lblImgCover1HE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/cover1H.png"))); // NOI18N
        panEnemyMainGearSlots.add(lblImgCover1HE);
        lblImgCover1HE.setBounds(9, 7, 67, 112);

        lblImgCoverArmorE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverArmor.png"))); // NOI18N
        panEnemyMainGearSlots.add(lblImgCoverArmorE);
        lblImgCoverArmorE.setBounds(83, 7, 67, 112);

        lblImgCoverShieldE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverShield.png"))); // NOI18N
        panEnemyMainGearSlots.add(lblImgCoverShieldE);
        lblImgCoverShieldE.setBounds(157, 7, 67, 112);

        lblImgCover2HE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/cover2H.png"))); // NOI18N
        panEnemyMainGearSlots.add(lblImgCover2HE);
        lblImgCover2HE.setBounds(231, 7, 67, 112);

        lblEnemyMainGearSlots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/mainGearsSlots.png"))); // NOI18N
        lblEnemyMainGearSlots.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panEnemyMainGearSlots.add(lblEnemyMainGearSlots);
        lblEnemyMainGearSlots.setBounds(0, 0, 303, 127);

        getContentPane().add(panEnemyMainGearSlots);
        panEnemyMainGearSlots.setBounds(810, 472, 303, 127);

        lblPlayerClassName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classtitle/KnightName.png"))); // NOI18N
        getContentPane().add(lblPlayerClassName);
        lblPlayerClassName.setBounds(-220, 40, 210, 40);

        lblEnemyClassName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/classtitle/KnightName.png"))); // NOI18N
        getContentPane().add(lblEnemyClassName);
        lblEnemyClassName.setBounds(810, 40, 210, 40);

        panSidePlayer.setOpaque(false);
        panSidePlayer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panSidePlayerMouseEntered(evt);
            }
        });
        panSidePlayer.setLayout(null);

        btnShowSkillP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/btnSkill.png"))); // NOI18N
        btnShowSkillP.setBorder(null);
        btnShowSkillP.setBorderPainted(false);
        btnShowSkillP.setContentAreaFilled(false);
        btnShowSkillP.setDisabledIcon(null);
        btnShowSkillP.setFocusPainted(false);
        btnShowSkillP.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/btnSkill.png"))); // NOI18N
        btnShowSkillP.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/HbtnSkill.png"))); // NOI18N
        btnShowSkillP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowSkillPActionPerformed(evt);
            }
        });
        panSidePlayer.add(btnShowSkillP);
        btnShowSkillP.setBounds(177, 610, 44, 44);

        getContentPane().add(panSidePlayer);
        panSidePlayer.setBounds(0, 0, 400, 600);

        panSideEnemy.setOpaque(false);
        panSideEnemy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panSideEnemyMouseEntered(evt);
            }
        });
        panSideEnemy.setLayout(null);

        btnShowSkillE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/btnSkill.png"))); // NOI18N
        btnShowSkillE.setBorder(null);
        btnShowSkillE.setBorderPainted(false);
        btnShowSkillE.setContentAreaFilled(false);
        btnShowSkillE.setDisabledIcon(null);
        btnShowSkillE.setFocusPainted(false);
        btnShowSkillE.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/btnSkill.png"))); // NOI18N
        btnShowSkillE.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/HbtnSkill.png"))); // NOI18N
        btnShowSkillE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowSkillEActionPerformed(evt);
            }
        });
        panSideEnemy.add(btnShowSkillE);
        btnShowSkillE.setBounds(177, 610, 44, 44);

        getContentPane().add(panSideEnemy);
        panSideEnemy.setBounds(400, 0, 400, 600);
        getContentPane().add(lblScreenFlash);
        lblScreenFlash.setBounds(0, 0, 0, 0);
        getContentPane().add(lblBackground1);
        lblBackground1.setBounds(12, 20, 0, 0);

        lblBackground2.setName(""); // NOI18N
        getContentPane().add(lblBackground2);
        lblBackground2.setBounds(12, 47, 0, 0);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayStopBGMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayStopBGMActionPerformed
        music.playPause(btnPlayStopBGM);
    }//GEN-LAST:event_btnPlayStopBGMActionPerformed

    private void btnPlayerAmuletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerAmuletActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("necklace", main.pChar, animGear, "amulet", btnPlayerAmulet, lblImgCoverAmulet);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshPlayerStats();
    }//GEN-LAST:event_btnPlayerAmuletActionPerformed

    private void btnPlayerRing1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerRing1ActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("ring", main.pChar, animGear, "ring1", btnPlayerRing1, lblImgCoverRing1);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshPlayerStats();
    }//GEN-LAST:event_btnPlayerRing1ActionPerformed

    private void btnPlayerRing2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerRing2ActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("ring", main.pChar, animGear, "ring2", btnPlayerRing2, lblImgCoverRing2);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshPlayerStats();
    }//GEN-LAST:event_btnPlayerRing2ActionPerformed

    private void btnPlayerSheltomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerSheltomActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("sheltom", main.pChar, animGear, "sheltom", btnPlayerSheltom, lblImgCoverSheltom);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshPlayerStats();
    }//GEN-LAST:event_btnPlayerSheltomActionPerformed

    private void btnPlayerBraceletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerBraceletActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("bracelet", main.pChar, animGear, "bracelet", btnPlayerBracelet, lblImgCoverBracelet);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshPlayerStats();
    }//GEN-LAST:event_btnPlayerBraceletActionPerformed

    private void btnPlayerGauntletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerGauntletActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("gauntlet", main.pChar, animGear, "gauntlet", btnPlayerGauntlet, lblImgCoverGauntlet);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshPlayerStats();
    }//GEN-LAST:event_btnPlayerGauntletActionPerformed

    private void btnPlayerBootsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerBootsActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("boots", main.pChar, animGear, "boots", btnPlayerBoots, lblImgCoverBoots);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshPlayerStats();
    }//GEN-LAST:event_btnPlayerBootsActionPerformed

    private void btnPlayerWeapon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerWeapon1ActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("1h", main.pChar, animGear, "1h", btnPlayerWeapon1, lblImgCover1H);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshPlayerStats();
    }//GEN-LAST:event_btnPlayerWeapon1ActionPerformed

    private void btnPlayerWeapon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerWeapon2ActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("2h", main.pChar, animGear, "2h", btnPlayerWeapon2, lblImgCover2H);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshPlayerStats();
    }//GEN-LAST:event_btnPlayerWeapon2ActionPerformed

    private void btnPlayerArmorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerArmorActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("armor", main.pChar, animGear, "armor", btnPlayerArmor, lblImgCoverArmor);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshPlayerStats();
    }//GEN-LAST:event_btnPlayerArmorActionPerformed

    private void btnPlayerShieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerShieldActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("shield", main.pChar, animGear, "shield", btnPlayerShield, lblImgCoverShield);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshPlayerStats();
    }//GEN-LAST:event_btnPlayerShieldActionPerformed

    private void btnEnemyAmuletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyAmuletActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("necklace", main.eChar, animGear, "amulet", btnEnemyAmulet, lblImgCoverAmulet);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshEnemyStats();
    }//GEN-LAST:event_btnEnemyAmuletActionPerformed

    private void btnEnemyRing1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyRing1ActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("ring", main.eChar, animGear, "ring1", btnEnemyRing1, lblImgCoverRing1E);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshEnemyStats();
    }//GEN-LAST:event_btnEnemyRing1ActionPerformed

    private void btnEnemyRing2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyRing2ActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("ring", main.eChar, animGear, "ring2", btnEnemyRing2, lblImgCoverRing2E);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshEnemyStats();
    }//GEN-LAST:event_btnEnemyRing2ActionPerformed

    private void btnEnemySheltomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemySheltomActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("sheltom", main.eChar, animGear, "sheltom", btnEnemySheltom, lblImgCoverSheltomE);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshEnemyStats();
    }//GEN-LAST:event_btnEnemySheltomActionPerformed

    private void btnEnemyBraceletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyBraceletActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("bracelet", main.eChar, animGear, "bracelet", btnEnemyBracelet, lblImgCoverBraceletE);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshEnemyStats();
    }//GEN-LAST:event_btnEnemyBraceletActionPerformed

    private void btnEnemyGauntletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyGauntletActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("gauntlet", main.eChar, animGear, "gauntlet", btnEnemyGauntlet, lblImgCoverGauntletE);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshEnemyStats();
    }//GEN-LAST:event_btnEnemyGauntletActionPerformed

    private void btnEnemyBootsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyBootsActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("boots", main.eChar, animGear, "boots", btnEnemyBoots, lblImgCoverBootsE);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshEnemyStats();
    }//GEN-LAST:event_btnEnemyBootsActionPerformed

    private void btnEnemyWeapon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyWeapon1ActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("1h", main.eChar, animGear, "1h", btnEnemyWeapon1, lblImgCover1HE);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshEnemyStats();
    }//GEN-LAST:event_btnEnemyWeapon1ActionPerformed

    private void btnEnemyWeapon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyWeapon2ActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("2h", main.eChar, animGear, "2h", btnEnemyWeapon2, lblImgCover2HE);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshEnemyStats();
    }//GEN-LAST:event_btnEnemyWeapon2ActionPerformed

    private void btnEnemyShieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyShieldActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("shield", main.eChar, animGear, "shield", btnEnemyShield, lblImgCoverShieldE);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshPlayerStats();
    }//GEN-LAST:event_btnEnemyShieldActionPerformed

    private void btnEnemyArmorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnemyArmorActionPerformed
        equipGear.setLocation(this.getLocation());
        equipGear.clearSelectingItem();
        equipGear.setFlags("armor", main.eChar, animGear, "armor", btnEnemyArmor, lblImgCoverArmorE);
        animGear.open(equipGear.getPanelGear(), true, null);
        equipGear.setVisible(true);
        refreshEnemyStats();
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
        resetStatus(PLAYER);
    }//GEN-LAST:event_btnPResetActionPerformed

    private void btnEResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEResetActionPerformed
        sfx.playSound("drink2.wav");
        resetStatus(ENEMY);
    }//GEN-LAST:event_btnEResetActionPerformed

    private void txtPStrenghtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPStrenghtFocusLost

        txtPStrenght.setText(String.valueOf(statLimit("str", main.pChar, txtPStrenght.getText())));
        refreshPlayerStats();
    }//GEN-LAST:event_txtPStrenghtFocusLost

    private void txtPSpiritFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPSpiritFocusLost

        txtPSpirit.setText(String.valueOf(statLimit("spi", main.pChar, txtPSpirit.getText())));
        refreshPlayerStats();
    }//GEN-LAST:event_txtPSpiritFocusLost

    private void txtPTalentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPTalentFocusLost

        txtPTalent.setText(String.valueOf(statLimit("tal", main.pChar, txtPTalent.getText())));
        refreshPlayerStats();
    }//GEN-LAST:event_txtPTalentFocusLost

    private void txtPAgilityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPAgilityFocusLost

        txtPAgility.setText(String.valueOf(statLimit("agi", main.pChar, txtPAgility.getText())));
        refreshPlayerStats();
    }//GEN-LAST:event_txtPAgilityFocusLost

    private void txtPHealthFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPHealthFocusLost

        txtPHealth.setText(String.valueOf(statLimit("vit", main.pChar, txtPHealth.getText())));
        refreshPlayerStats();
    }//GEN-LAST:event_txtPHealthFocusLost

    private void txtPLevelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPLevelFocusLost
        int level;
        int prevLevel;
        prevLevel = main.pChar.getLevel();
        try {
            level = Integer.parseInt(txtPLevel.getText());
            if (level > 255) {
                level = 255;
            } else if (level <= 0) {
                level = 1;
            }
        } catch (NumberFormatException nfe) {
            level = prevLevel;
        }
        txtPLevel.setText(String.valueOf(level));
        updatePlayerStats();
        String aux = "";
        aux = main.pChar.setBaseSkillPoints();
        if (aux.equals("resetall")){
            skillWorker(RESETALL, main.pChar, 99, 99);
            lblFraseAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/frasePlayerTALLReset.png")));
        } else if (aux.equals("resettier5")){
            skillWorker(RESETTIER5, main.pChar, 99, 99);
            lblFraseAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/frasePlayerT5Reset.png")));
        } else {
            atualizarPlayerSP();
        }
    }//GEN-LAST:event_txtPLevelFocusLost

    private void txtELevelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtELevelFocusGained
        txtELevel.selectAll();
    }//GEN-LAST:event_txtELevelFocusGained

    private void txtELevelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtELevelFocusLost
        int level;
        int prevLevel;
        prevLevel = main.eChar.getLevel();
        try {
            level = Integer.parseInt(txtELevel.getText());
            if (level > 255) {
                level = 255;
            } else if (level <= 0) {
                level = 1;
            }
        } catch (NumberFormatException nfe) {
            level = prevLevel;
        }
        txtELevel.setText(String.valueOf(level));
        updateEnemyStats();
        String aux = "";
        aux = main.eChar.setBaseSkillPoints();
        if (aux.equals("resetall")){
            skillWorker(RESETALL, main.eChar, 99, 99);
            lblFraseAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/fraseEnemyTALLReset.png")));
        } else if (aux.equals("resettier5")){
            skillWorker(RESETTIER5, main.eChar, 99, 99);
            lblFraseAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/fraseEnemyT5Reset.png")));
        } else {
            atualizarEnemySP();
        }
    }//GEN-LAST:event_txtELevelFocusLost

    private void txtEStrenghtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEStrenghtFocusGained
        txtEStrenght.selectAll();
    }//GEN-LAST:event_txtEStrenghtFocusGained

    private void txtEStrenghtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEStrenghtFocusLost

        txtEStrenght.setText(String.valueOf(statLimit("str", main.eChar, txtEStrenght.getText())));
        refreshEnemyStats();
    }//GEN-LAST:event_txtEStrenghtFocusLost

    private void txtESpiritFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtESpiritFocusGained
        txtESpirit.selectAll();
    }//GEN-LAST:event_txtESpiritFocusGained

    private void txtESpiritFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtESpiritFocusLost

        txtESpirit.setText(String.valueOf(statLimit("spi", main.eChar, txtESpirit.getText())));
        refreshEnemyStats();
    }//GEN-LAST:event_txtESpiritFocusLost

    private void txtETalentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtETalentFocusGained
        txtETalent.selectAll();
    }//GEN-LAST:event_txtETalentFocusGained

    private void txtETalentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtETalentFocusLost

        txtETalent.setText(String.valueOf(statLimit("tal", main.eChar, txtETalent.getText())));
        refreshEnemyStats();
    }//GEN-LAST:event_txtETalentFocusLost

    private void txtEAgilityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEAgilityFocusGained
        txtEAgility.selectAll();
    }//GEN-LAST:event_txtEAgilityFocusGained

    private void txtEAgilityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEAgilityFocusLost

        txtEAgility.setText(String.valueOf(statLimit("agi", main.eChar, txtEAgility.getText())));
        refreshEnemyStats();
    }//GEN-LAST:event_txtEAgilityFocusLost

    private void txtEHealthFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEHealthFocusGained
        txtEHealth.selectAll();
    }//GEN-LAST:event_txtEHealthFocusGained

    private void txtEHealthFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEHealthFocusLost

        txtEHealth.setText(String.valueOf(statLimit("vit", main.eChar, txtEHealth.getText())));
        refreshEnemyStats();
    }//GEN-LAST:event_txtEHealthFocusLost

    private void txtEnemyNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEnemyNameFocusGained
        txtEnemyName.selectAll();
    }//GEN-LAST:event_txtEnemyNameFocusGained

    private void txtPlayerNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPlayerNameFocusGained
        txtPlayerName.selectAll();
    }//GEN-LAST:event_txtPlayerNameFocusGained

    private void panSidePlayerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panSidePlayerMouseEntered
        buildingChar = main.player;
    }//GEN-LAST:event_panSidePlayerMouseEntered

    private void panSideEnemyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panSideEnemyMouseEntered
        buildingChar = main.enemy;
    }//GEN-LAST:event_panSideEnemyMouseEntered

    private void btnPlayerWeapon1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerWeapon1MouseEntered
        try {
            lblImgCover1H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCover1H, main.pChar.getItemWeaponOneHand()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerWeapon1MouseEntered

    private void btnPlayerWeapon1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerWeapon1MouseExited
        try {
            lblImgCover1H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCover1H))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerWeapon1MouseExited

    private void btnPlayerArmorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerArmorMouseEntered
        try {
            lblImgCoverArmor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCoverArmor, main.pChar.getItemArmor()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerArmorMouseEntered

    private void btnPlayerArmorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerArmorMouseExited
        try {
            lblImgCoverArmor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCoverArmor))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerArmorMouseExited

    private void btnPlayerShieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerShieldMouseEntered
        try {
            lblImgCoverShield.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCoverShield, main.pChar.getItemShield()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerShieldMouseEntered

    private void btnPlayerShieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerShieldMouseExited
        try {
            lblImgCoverShield.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCoverShield))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerShieldMouseExited

    private void btnPlayerWeapon2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerWeapon2MouseEntered
        try {
            lblImgCover2H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCover2H, main.pChar.getItemWeaponTwoHand()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerWeapon2MouseEntered

    private void btnPlayerWeapon2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerWeapon2MouseExited
        try {
            lblImgCover2H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCover2H))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerWeapon2MouseExited

    private void btnPlayerBraceletMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerBraceletMouseEntered
        try {
            lblImgCoverBracelet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCoverBracelet, main.pChar.getItemBoots()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerBraceletMouseEntered

    private void btnPlayerBraceletMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerBraceletMouseExited
        try {
            lblImgCoverBracelet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCoverBracelet))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerBraceletMouseExited

    private void btnPlayerGauntletMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerGauntletMouseEntered
        try {
            lblImgCoverGauntlet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCoverGauntlet, main.pChar.getItemGauntlet()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerGauntletMouseEntered

    private void btnPlayerGauntletMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerGauntletMouseExited
        try {
            lblImgCoverGauntlet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCoverGauntlet))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerGauntletMouseExited

    private void btnPlayerBootsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerBootsMouseEntered
        try {
            lblImgCoverBoots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCoverBoots, main.pChar.getItemBoots()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerBootsMouseEntered

    private void btnPlayerBootsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerBootsMouseExited
        try {
            lblImgCoverBoots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCoverBoots))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerBootsMouseExited

    private void btnPlayerAmuletMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerAmuletMouseEntered
        try {
            lblImgCoverAmulet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCoverAmulet, main.pChar.getItemAmulet()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerAmuletMouseEntered

    private void btnPlayerAmuletMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerAmuletMouseExited
        try {
            lblImgCoverAmulet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCoverAmulet))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerAmuletMouseExited

    private void btnPlayerRing1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerRing1MouseEntered
        try {
            lblImgCoverRing1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCoverRing1, main.pChar.getItemRing1()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerRing1MouseEntered

    private void btnPlayerRing1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerRing1MouseExited
        try {
            lblImgCoverRing1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCoverRing1))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerRing1MouseExited

    private void btnPlayerRing2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerRing2MouseEntered
        try {
            lblImgCoverRing2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCoverRing2, main.pChar.getItemRing2()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerRing2MouseEntered

    private void btnPlayerRing2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerRing2MouseExited
        try {
            lblImgCoverRing2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCoverRing2))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerRing2MouseExited

    private void btnPlayerSheltomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerSheltomMouseEntered
        try {
            lblImgCoverSheltom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCoverSheltom, main.pChar.getItemSheltom()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerSheltomMouseEntered

    private void btnPlayerSheltomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerSheltomMouseExited
        try {
            lblImgCoverSheltom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCoverSheltom))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnPlayerSheltomMouseExited

    private void btnEnemyAmuletMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyAmuletMouseEntered
        try {
            lblImgCoverAmuletE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCoverAmuletE, main.eChar.getItemAmulet()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyAmuletMouseEntered

    private void btnEnemyAmuletMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyAmuletMouseExited
        try {
            lblImgCoverAmuletE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCoverAmuletE))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyAmuletMouseExited

    private void btnEnemyRing1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyRing1MouseEntered
        try {
            lblImgCoverRing1E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCoverRing1E, main.eChar.getItemRing1()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyRing1MouseEntered

    private void btnEnemyRing1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyRing1MouseExited
        try {
            lblImgCoverRing1E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCoverRing1E))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyRing1MouseExited

    private void btnEnemyRing2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyRing2MouseEntered
        try {
            lblImgCoverRing2E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCoverRing2E, main.eChar.getItemRing2()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyRing2MouseEntered

    private void btnEnemyRing2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyRing2MouseExited
        try {
            lblImgCoverRing2E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCoverRing2E))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyRing2MouseExited

    private void btnEnemySheltomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemySheltomMouseEntered
        try {
            lblImgCoverSheltomE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCoverSheltomE, main.eChar.getItemSheltom()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemySheltomMouseEntered

    private void btnEnemySheltomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemySheltomMouseExited
        try {
            lblImgCoverSheltomE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCoverSheltomE))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemySheltomMouseExited

    private void btnEnemyBraceletMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyBraceletMouseEntered
        try {
            lblImgCoverBraceletE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCoverBraceletE, main.eChar.getItemBracelet()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyBraceletMouseEntered

    private void btnEnemyBraceletMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyBraceletMouseExited
        try {
            lblImgCoverBraceletE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCoverBraceletE))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyBraceletMouseExited

    private void btnEnemyGauntletMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyGauntletMouseEntered
        try {
            lblImgCoverGauntletE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCoverGauntletE, main.eChar.getItemGauntlet()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyGauntletMouseEntered

    private void btnEnemyGauntletMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyGauntletMouseExited
        try {
            lblImgCoverGauntletE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCoverGauntletE))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyGauntletMouseExited

    private void btnEnemyBootsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyBootsMouseEntered
        try {
            lblImgCoverBootsE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCoverBootsE, main.eChar.getItemBoots()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyBootsMouseEntered

    private void btnEnemyBootsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyBootsMouseExited
        try {
            lblImgCoverBootsE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCoverBootsE))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyBootsMouseExited

    private void btnEnemyWeapon1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyWeapon1MouseEntered
        try {
            lblImgCover1HE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCover1HE, main.eChar.getItemWeaponOneHand()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyWeapon1MouseEntered

    private void btnEnemyWeapon1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyWeapon1MouseExited
        try {
            lblImgCover1HE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCover1HE))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyWeapon1MouseExited

    private void btnEnemyArmorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyArmorMouseEntered
        try {
            lblImgCoverArmorE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCoverArmorE, main.eChar.getItemArmor()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyArmorMouseEntered

    private void btnEnemyArmorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyArmorMouseExited
        try {
            lblImgCoverArmorE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCoverArmorE))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyArmorMouseExited

    private void btnEnemyShieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyShieldMouseEntered
        try {
            lblImgCoverShieldE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCoverShieldE, main.eChar.getItemShield()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyShieldMouseEntered

    private void btnEnemyShieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyShieldMouseExited
        try {
            lblImgCoverShieldE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCoverShieldE))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyShieldMouseExited

    private void btnEnemyWeapon2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyWeapon2MouseEntered
        try {
            lblImgCover2HE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileNameHover(lblImgCover2HE, main.eChar.getItemWeaponTwoHand()))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyWeapon2MouseEntered

    private void btnEnemyWeapon2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyWeapon2MouseExited
        try {
            lblImgCover2HE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/" + textureWork.getFileName(lblImgCover2HE))));
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnEnemyWeapon2MouseExited

    private void btnEnemyWeapon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyWeapon1MouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.eChar.getItemWeaponOneHand().getItemType() + ".wav");
                btnEnemyWeapon1.setIcon(null);
                btnEnemyWeapon1.setToolTipText("");
                lblImgCover1HE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/cover1H.png")));
                main.eChar.setItemWeaponOneHand(new Item ("No Gear Weapon"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnEnemyWeapon1MouseClicked

    private void btnEnemyArmorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyArmorMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.eChar.getItemArmor().getItemType() + ".wav");
                btnEnemyArmor.setIcon(null);
                btnEnemyArmor.setToolTipText("");
                lblImgCoverArmorE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverArmor.png")));
                main.eChar.setItemArmor(new Item("No Gear"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnEnemyArmorMouseClicked

    private void btnEnemyShieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyShieldMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.eChar.getItemShield().getItemType() + ".wav");
                btnEnemyShield.setIcon(null);
                btnEnemyShield.setToolTipText("");
                lblImgCoverShieldE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverShield.png")));
                main.eChar.setItemShield(new Item("No Gear"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnEnemyShieldMouseClicked

    private void btnEnemyWeapon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyWeapon2MouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.eChar.getItemWeaponTwoHand().getItemType() + ".wav");
                btnEnemyWeapon2.setIcon(null);
                btnEnemyWeapon2.setToolTipText("");
                lblImgCover2HE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/cover2H.png")));
                main.eChar.setItemWeaponTwoHand(new Item("No Gear Weapon"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnEnemyWeapon2MouseClicked

    private void btnEnemyBraceletMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyBraceletMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.eChar.getItemBracelet().getItemType() + ".wav");
                btnEnemyBracelet.setIcon(null);
                btnEnemyBracelet.setToolTipText("");
                lblImgCoverBraceletE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverBracelet.png")));
                main.eChar.setItemBracelet(new Item("No Gear"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnEnemyBraceletMouseClicked

    private void btnEnemyGauntletMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyGauntletMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.eChar.getItemGauntlet().getItemType() + ".wav");
                btnEnemyGauntlet.setIcon(null);
                btnEnemyGauntlet.setToolTipText("");
                lblImgCoverGauntletE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverGauntlet.png")));
                main.eChar.setItemGauntlet(new Item("No Gear"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnEnemyGauntletMouseClicked

    private void btnEnemyBootsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyBootsMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.eChar.getItemBoots().getItemType() + ".wav");
                btnEnemyBoots.setIcon(null);
                btnEnemyBoots.setToolTipText("");
                lblImgCoverBootsE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverBoots.png")));
                main.eChar.setItemBoots(new Item("No Gear"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnEnemyBootsMouseClicked

    private void btnEnemyAmuletMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyAmuletMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.eChar.getItemAmulet().getItemType() + ".wav");
                btnEnemyAmulet.setIcon(null);
                btnEnemyAmulet.setToolTipText("");
                lblImgCoverAmuletE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverAmulet.png")));
                main.eChar.setItemAmulet(new Item("No Gear"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnEnemyAmuletMouseClicked

    private void btnEnemyRing1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyRing1MouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.eChar.getItemRing1().getItemType() + ".wav");
                btnEnemyRing1.setIcon(null);
                btnEnemyRing1.setToolTipText("");
                lblImgCoverRing1E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverRing.png")));
                main.eChar.setItemRing1(new Item("No Gear"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnEnemyRing1MouseClicked

    private void btnEnemyRing2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemyRing2MouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.eChar.getItemRing2().getItemType() + ".wav");
                btnEnemyRing2.setIcon(null);
                btnEnemyRing2.setToolTipText("");
                lblImgCoverRing2E.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverRing.png")));
                main.eChar.setItemRing2(new Item("No Gear"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnEnemyRing2MouseClicked

    private void btnEnemySheltomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnemySheltomMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.eChar.getItemSheltom().getItemType() + ".wav");
                btnEnemySheltom.setIcon(null);
                btnEnemySheltom.setToolTipText("");
                lblImgCoverSheltomE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverSheltom.png")));
                main.eChar.setItemSheltom(new Item("No Gear"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnEnemySheltomMouseClicked

    private void btnPlayerAmuletMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerAmuletMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.pChar.getItemAmulet().getItemType() + ".wav");
                btnPlayerAmulet.setIcon(null);
                btnPlayerAmulet.setToolTipText("");
                lblImgCoverAmulet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverAmulet.png")));
                main.pChar.setItemAmulet(new Item("No Gear"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnPlayerAmuletMouseClicked

    private void btnPlayerRing1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerRing1MouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.pChar.getItemRing1().getItemType() + ".wav");
                btnPlayerRing1.setIcon(null);
                btnPlayerRing1.setToolTipText("");
                lblImgCoverRing1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverRing.png")));
                main.pChar.setItemRing1(new Item("No Gear"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnPlayerRing1MouseClicked

    private void btnPlayerRing2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerRing2MouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.pChar.getItemRing2().getItemType() + ".wav");
                btnPlayerRing2.setIcon(null);
                btnPlayerRing2.setToolTipText("");
                lblImgCoverRing2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverRing.png")));
                main.pChar.setItemRing2(new Item("No Gear"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnPlayerRing2MouseClicked

    private void btnPlayerSheltomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerSheltomMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.pChar.getItemSheltom().getItemType() + ".wav");
                btnPlayerSheltom.setIcon(null);
                btnPlayerSheltom.setToolTipText("");
                lblImgCoverSheltom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverSheltom.png")));
                main.pChar.setItemSheltom(new Item("No Gear"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnPlayerSheltomMouseClicked

    private void btnPlayerBraceletMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerBraceletMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.pChar.getItemBracelet().getItemType() + ".wav");
                btnPlayerBracelet.setIcon(null);
                btnPlayerBracelet.setToolTipText("");
                lblImgCoverBracelet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverBracelet.png")));
                main.pChar.setItemBracelet(new Item("No Gear"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnPlayerBraceletMouseClicked

    private void btnPlayerGauntletMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerGauntletMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.pChar.getItemGauntlet().getItemType() + ".wav");
                btnPlayerGauntlet.setIcon(null);
                btnPlayerGauntlet.setToolTipText("");
                lblImgCoverGauntlet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverGauntlet.png")));
                main.pChar.setItemGauntlet(new Item("No Gear"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnPlayerGauntletMouseClicked

    private void btnPlayerBootsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerBootsMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.pChar.getItemBoots().getItemType() + ".wav");
                btnPlayerBoots.setIcon(null);
                btnPlayerBoots.setToolTipText("");
                lblImgCoverBoots.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverBoots.png")));
                main.pChar.setItemBoots(new Item("No Gear"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnPlayerBootsMouseClicked

    private void btnPlayerWeapon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerWeapon1MouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.pChar.getItemWeaponOneHand().getItemType() + ".wav");
                btnPlayerWeapon1.setIcon(null);
                btnPlayerWeapon1.setToolTipText("");
                lblImgCover1H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/cover1H.png")));
                main.pChar.setItemWeaponOneHand(new Item("No Gear Weapon"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnPlayerWeapon1MouseClicked

    private void btnPlayerArmorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerArmorMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.pChar.getItemArmor().getItemType() + ".wav");
                btnPlayerArmor.setIcon(null);
                btnPlayerArmor.setToolTipText("");
                lblImgCoverArmor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverArmor.png")));
                main.pChar.setItemArmor(new Item("No Gear"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnPlayerArmorMouseClicked

    private void btnPlayerShieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerShieldMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.pChar.getItemShield().getItemType() + ".wav");
                btnPlayerShield.setIcon(null);
                btnPlayerShield.setToolTipText("");
                lblImgCoverShield.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverShield.png")));
                main.pChar.setItemShield(new Item("No Gear"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnPlayerShieldMouseClicked

    private void btnPlayerWeapon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayerWeapon2MouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            try {
                sfx.playSound(main.pChar.getItemWeaponTwoHand().getItemType() + ".wav");
                btnPlayerWeapon2.setIcon(null);
                btnPlayerWeapon2.setToolTipText("");
                lblImgCover2H.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/cover2H.png")));
                main.pChar.setItemWeaponTwoHand(new Item("No Gear Weapon"));
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnPlayerWeapon2MouseClicked

    private void txtPlayerNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlayerNameKeyPressed
        FiltroTexto.limitarTexto(txtPlayerName, NAMETXTLIMIT);
    }//GEN-LAST:event_txtPlayerNameKeyPressed

    private void txtPLevelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPLevelKeyPressed
        FiltroTexto.limitarTexto(txtPLevel, LVTXTLIMIT);
    }//GEN-LAST:event_txtPLevelKeyPressed

    private void txtPStrenghtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPStrenghtKeyPressed
        FiltroTexto.limitarTexto(txtPStrenght, STATTXTLIMIT);
    }//GEN-LAST:event_txtPStrenghtKeyPressed

    private void txtPSpiritKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPSpiritKeyPressed
        FiltroTexto.limitarTexto(txtPSpirit, STATTXTLIMIT);
    }//GEN-LAST:event_txtPSpiritKeyPressed

    private void txtPAgilityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPAgilityKeyPressed
        FiltroTexto.limitarTexto(txtPAgility, STATTXTLIMIT);
    }//GEN-LAST:event_txtPAgilityKeyPressed

    private void txtPTalentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPTalentKeyPressed
        FiltroTexto.limitarTexto(txtPTalent, STATTXTLIMIT);
    }//GEN-LAST:event_txtPTalentKeyPressed

    private void txtPHealthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPHealthKeyPressed
        FiltroTexto.limitarTexto(txtPHealth, STATTXTLIMIT);
    }//GEN-LAST:event_txtPHealthKeyPressed

    private void txtEnemyNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnemyNameKeyPressed
        FiltroTexto.limitarTexto(txtEnemyName, NAMETXTLIMIT);
    }//GEN-LAST:event_txtEnemyNameKeyPressed

    private void txtELevelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtELevelKeyPressed
        FiltroTexto.limitarTexto(txtELevel, LVTXTLIMIT);
    }//GEN-LAST:event_txtELevelKeyPressed

    private void txtEStrenghtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEStrenghtKeyPressed
        FiltroTexto.limitarTexto(txtEStrenght, STATTXTLIMIT);
    }//GEN-LAST:event_txtEStrenghtKeyPressed

    private void txtESpiritKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtESpiritKeyPressed
        FiltroTexto.limitarTexto(txtESpirit, STATTXTLIMIT);
    }//GEN-LAST:event_txtESpiritKeyPressed

    private void txtETalentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtETalentKeyPressed
        FiltroTexto.limitarTexto(txtETalent, STATTXTLIMIT);
    }//GEN-LAST:event_txtETalentKeyPressed

    private void txtEAgilityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEAgilityKeyPressed
        FiltroTexto.limitarTexto(txtEAgility, STATTXTLIMIT);
    }//GEN-LAST:event_txtEAgilityKeyPressed

    private void txtEHealthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEHealthKeyPressed
        FiltroTexto.limitarTexto(txtEHealth, STATTXTLIMIT);
    }//GEN-LAST:event_txtEHealthKeyPressed

    private void txtELevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtELevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtELevelActionPerformed

    private void txtEStrenghtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEStrenghtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEStrenghtActionPerformed

    private void btnCloseSkillPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseSkillPMouseEntered

    }//GEN-LAST:event_btnCloseSkillPMouseEntered

    private void btnCloseSkillPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseSkillPMouseExited

    }//GEN-LAST:event_btnCloseSkillPMouseExited

    private void btnCloseSkillPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseSkillPActionPerformed
        showHideSkillPlayer();
        disableButton(btnCloseSkillP, 500);
        disableButton(btnShowSkillP, 500);
    }//GEN-LAST:event_btnCloseSkillPActionPerformed

    private void btnShowSkillPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowSkillPActionPerformed
        showHideSkillPlayer();
        disableButton(btnShowSkillP, 500);
    }//GEN-LAST:event_btnShowSkillPActionPerformed

    private void btnResetTALLPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTALLPActionPerformed
        sfx.playSound("drink2.wav");
        skillWorker(RESETALL, main.pChar, 99, 99);
    }//GEN-LAST:event_btnResetTALLPActionPerformed

    private void btnResetT5PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetT5PActionPerformed
        sfx.playSound("drink2.wav");
        skillWorker(RESETTIER5, main.pChar, 99, 99);
    }//GEN-LAST:event_btnResetT5PActionPerformed

    private void btnSkill11PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill11PMouseClicked
        int tier = 0;
        int skill = 0;
        if (!btnSkill11P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, tier, skill);
            btnSkill11P.setToolTipText(main.pChar.getSkill(tier, skill).getTooltip());
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, skill, tier);
            if (main.pChar.getSkillLvl()[tier][skill] != 0) {
                btnSkill11P.setToolTipText(main.pChar.getSkill(tier, skill).getTooltip());
            }
        }
    }//GEN-LAST:event_btnSkill11PMouseClicked

    private void btnSkill12PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill12PMouseClicked
        if (!btnSkill12P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 0, 1);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 0, 1);
        }
    }//GEN-LAST:event_btnSkill12PMouseClicked

    private void btnSkill13PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill13PMouseClicked
        if (!btnSkill13P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 0, 2);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 0, 2);
        }
    }//GEN-LAST:event_btnSkill13PMouseClicked

    private void btnSkill14PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill14PMouseClicked
        if (!btnSkill14P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 0, 3);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 0, 3);
        }
    }//GEN-LAST:event_btnSkill14PMouseClicked

    private void btnSkill21PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill21PMouseClicked
        if (!btnSkill21P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 1, 0);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 1, 0);
        }
    }//GEN-LAST:event_btnSkill21PMouseClicked

    private void btnSkill22PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill22PMouseClicked
        if (!btnSkill22P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 1, 1);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 1, 1);
        }
    }//GEN-LAST:event_btnSkill22PMouseClicked

    private void btnSkill23PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill23PMouseClicked
        if (!btnSkill23P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 1, 2);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 1, 2);
        }
    }//GEN-LAST:event_btnSkill23PMouseClicked

    private void btnSkill24PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill24PMouseClicked
        if (!btnSkill24P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 1, 3);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 1, 3);
        }
    }//GEN-LAST:event_btnSkill24PMouseClicked

    private void btnSkill31PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill31PMouseClicked
        if (!btnSkill31P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 2, 0);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 2, 0);
        }
    }//GEN-LAST:event_btnSkill31PMouseClicked

    private void btnSkill32PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill32PMouseClicked
        if (!btnSkill32P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 2, 1);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 2, 1);
        }
    }//GEN-LAST:event_btnSkill32PMouseClicked

    private void btnSkill33PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill33PMouseClicked
        if (!btnSkill33P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 2, 2);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 2, 2);
        }
    }//GEN-LAST:event_btnSkill33PMouseClicked

    private void btnSkill34PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill34PMouseClicked
        if (!btnSkill34P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 2, 3);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 2, 3);
        }
    }//GEN-LAST:event_btnSkill34PMouseClicked

    private void btnSkill41PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill41PMouseClicked
        if (!btnSkill41P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 3, 0);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 3, 0);
        }
    }//GEN-LAST:event_btnSkill41PMouseClicked

    private void btnSkill42PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill42PMouseClicked
        if (!btnSkill42P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 3, 1);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 3, 1);
        }
    }//GEN-LAST:event_btnSkill42PMouseClicked

    private void btnSkill43PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill43PMouseClicked
        if (!btnSkill43P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 3, 2);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 3, 2);
        }
    }//GEN-LAST:event_btnSkill43PMouseClicked

    private void btnSkill44PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill44PMouseClicked
        if (!btnSkill44P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 3, 3);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 3, 3);
        }
    }//GEN-LAST:event_btnSkill44PMouseClicked

    private void btnSkill51PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill51PMouseClicked
        if (!btnSkill51P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 4, 0);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 4, 0);
        }
    }//GEN-LAST:event_btnSkill51PMouseClicked

    private void btnSkill52PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill52PMouseClicked
        if (!btnSkill52P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 4, 1);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 4, 1);
        }
    }//GEN-LAST:event_btnSkill52PMouseClicked

    private void btnSkill53PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill53PMouseClicked
        if (!btnSkill53P.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 4, 2);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 4, 2);
        }
    }//GEN-LAST:event_btnSkill53PMouseClicked

    private void btnSkill54PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill54PMouseClicked
        if (!btnSkill54P.isEnabled()) {
            return;
        }        
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.pChar, 4, 3);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.pChar, 4, 3);
        }
    }//GEN-LAST:event_btnSkill54PMouseClicked

    private void btnShowSkillEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowSkillEActionPerformed
        showHideSkillEnemy();
        disableButton(btnShowSkillE, 500);
    }//GEN-LAST:event_btnShowSkillEActionPerformed

    private void btnCloseSkillEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseSkillEMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseSkillEMouseEntered

    private void btnCloseSkillEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseSkillEMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseSkillEMouseExited

    private void btnCloseSkillEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseSkillEActionPerformed
        showHideSkillEnemy();
        disableButton(btnCloseSkillE, 500);
        disableButton(btnShowSkillE, 500);
    }//GEN-LAST:event_btnCloseSkillEActionPerformed

    private void btnSkill11EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill11EMouseClicked
        int tier = 0;
        int skill = 0;
        if (!btnSkill11E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, tier, skill);
            btnSkill11E.setToolTipText(main.pChar.getSkill(tier, skill).getTooltip());
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, skill, tier);
            if (main.eChar.getSkillLvl()[tier][skill] != 0) {
                btnSkill11E.setToolTipText(main.eChar.getSkill(tier, skill).getTooltip());
            }
        }
    }//GEN-LAST:event_btnSkill11EMouseClicked

    private void btnSkill12EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill12EMouseClicked
        if (!btnSkill12E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 0, 1);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 0, 1);
        }
    }//GEN-LAST:event_btnSkill12EMouseClicked

    private void btnSkill13EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill13EMouseClicked
        if (!btnSkill13E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 0, 2);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 0, 2);
        }
    }//GEN-LAST:event_btnSkill13EMouseClicked

    private void btnSkill14EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill14EMouseClicked
        if (!btnSkill14E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 0, 3);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 0, 3);
        }
    }//GEN-LAST:event_btnSkill14EMouseClicked

    private void btnResetTALLEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTALLEActionPerformed
        sfx.playSound("drink2.wav");
        skillWorker(RESETALL, main.eChar, 99, 99);
    }//GEN-LAST:event_btnResetTALLEActionPerformed

    private void btnSkill21EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill21EMouseClicked
        if (!btnSkill21E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 1, 0);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 1, 0);
        }
    }//GEN-LAST:event_btnSkill21EMouseClicked

    private void btnSkill22EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill22EMouseClicked
        if (!btnSkill22E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 1, 1);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 1, 1);
        }
    }//GEN-LAST:event_btnSkill22EMouseClicked

    private void btnSkill23EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill23EMouseClicked
        if (!btnSkill23E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 1, 2);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 1, 2);
        }
    }//GEN-LAST:event_btnSkill23EMouseClicked

    private void btnSkill24EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill24EMouseClicked
        if (!btnSkill24E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 1, 3);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 1, 3);
        }
    }//GEN-LAST:event_btnSkill24EMouseClicked

    private void btnSkill31EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill31EMouseClicked
        if (!btnSkill31E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 2, 0);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 2, 0);
        }
    }//GEN-LAST:event_btnSkill31EMouseClicked

    private void btnSkill32EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill32EMouseClicked
        if (!btnSkill32E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 2, 1);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 2, 1);
        }
    }//GEN-LAST:event_btnSkill32EMouseClicked

    private void btnSkill33EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill33EMouseClicked
        if (!btnSkill33E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 2, 2);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 2, 2);
        }
    }//GEN-LAST:event_btnSkill33EMouseClicked

    private void btnSkill34EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill34EMouseClicked
        if (!btnSkill34E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 2, 3);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 2, 3);
        }
    }//GEN-LAST:event_btnSkill34EMouseClicked

    private void btnSkill41EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill41EMouseClicked
        if (!btnSkill41E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 3, 0);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 3, 0);
        }
    }//GEN-LAST:event_btnSkill41EMouseClicked

    private void btnSkill42EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill42EMouseClicked
        if (!btnSkill42E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 3, 1);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 3, 1);
        }
    }//GEN-LAST:event_btnSkill42EMouseClicked

    private void btnSkill43EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill43EMouseClicked
        if (!btnSkill43E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 3, 2);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 3, 2);
        }
    }//GEN-LAST:event_btnSkill43EMouseClicked

    private void btnSkill44EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill44EMouseClicked
        if (!btnSkill44E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 3, 3);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 3, 3);
        }
    }//GEN-LAST:event_btnSkill44EMouseClicked

    private void btnSkill51EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill51EMouseClicked
        if (!btnSkill51E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 4, 0);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 4, 0);
        }
    }//GEN-LAST:event_btnSkill51EMouseClicked

    private void btnSkill52EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill52EMouseClicked
        if (!btnSkill52E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 4, 1);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 4, 1);
        }
    }//GEN-LAST:event_btnSkill52EMouseClicked

    private void btnSkill53EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill53EMouseClicked
        if (!btnSkill53E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 4, 2);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 4, 2);
        }
    }//GEN-LAST:event_btnSkill53EMouseClicked

    private void btnSkill54EMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSkill54EMouseClicked
        if (!btnSkill54E.isEnabled()) {
            return;
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            skillWorker(RAISE, main.eChar, 4, 3);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            skillWorker(DECREASE, main.eChar, 4, 3);
        }
    }//GEN-LAST:event_btnSkill54EMouseClicked

    private void btnResetT5EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetT5EActionPerformed
        sfx.playSound("drink2.wav");
        skillWorker(RESETTIER5, main.eChar, 99, 99);
    }//GEN-LAST:event_btnResetT5EActionPerformed

    private void btnSkill11EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkill11EActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSkill11EActionPerformed

    private void btnSkill11PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkill11PActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSkill11PActionPerformed

    private void btnSkill12PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkill12PActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSkill12PActionPerformed

    private void btnSkill21EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkill21EActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSkill21EActionPerformed
    
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
    private javax.swing.JButton btnCloseSkillE;
    private javax.swing.JButton btnCloseSkillP;
    private javax.swing.JButton btnEReset;
    private javax.swing.JButton btnEnemyAmulet;
    private javax.swing.JButton btnEnemyArmor;
    private javax.swing.JButton btnEnemyBoots;
    private javax.swing.JButton btnEnemyBracelet;
    private javax.swing.JButton btnEnemyGauntlet;
    private javax.swing.JButton btnEnemyRing1;
    private javax.swing.JButton btnEnemyRing2;
    private javax.swing.JButton btnEnemySheltom;
    private javax.swing.JButton btnEnemyShield;
    private javax.swing.JButton btnEnemyWeapon1;
    private javax.swing.JButton btnEnemyWeapon2;
    private javax.swing.JButton btnHideGUI;
    private javax.swing.JButton btnPReset;
    private javax.swing.JButton btnPlayStopBGM;
    private javax.swing.JButton btnPlayerAmulet;
    private javax.swing.JButton btnPlayerArmor;
    private javax.swing.JButton btnPlayerBoots;
    private javax.swing.JButton btnPlayerBracelet;
    private javax.swing.JButton btnPlayerGauntlet;
    private javax.swing.JButton btnPlayerRing1;
    private javax.swing.JButton btnPlayerRing2;
    private javax.swing.JButton btnPlayerSheltom;
    private javax.swing.JButton btnPlayerShield;
    private javax.swing.JButton btnPlayerWeapon1;
    private javax.swing.JButton btnPlayerWeapon2;
    private javax.swing.JButton btnResetT5E;
    private javax.swing.JButton btnResetT5P;
    private javax.swing.JButton btnResetTALLE;
    private javax.swing.JButton btnResetTALLP;
    private javax.swing.JButton btnShowSkillE;
    private javax.swing.JButton btnShowSkillP;
    private javax.swing.JButton btnSkill11E;
    private javax.swing.JButton btnSkill11P;
    private javax.swing.JButton btnSkill12E;
    private javax.swing.JButton btnSkill12P;
    private javax.swing.JButton btnSkill13E;
    private javax.swing.JButton btnSkill13P;
    private javax.swing.JButton btnSkill14E;
    private javax.swing.JButton btnSkill14P;
    private javax.swing.JButton btnSkill21E;
    private javax.swing.JButton btnSkill21P;
    private javax.swing.JButton btnSkill22E;
    private javax.swing.JButton btnSkill22P;
    private javax.swing.JButton btnSkill23E;
    private javax.swing.JButton btnSkill23P;
    private javax.swing.JButton btnSkill24E;
    private javax.swing.JButton btnSkill24P;
    private javax.swing.JButton btnSkill31E;
    private javax.swing.JButton btnSkill31P;
    private javax.swing.JButton btnSkill32E;
    private javax.swing.JButton btnSkill32P;
    private javax.swing.JButton btnSkill33E;
    private javax.swing.JButton btnSkill33P;
    private javax.swing.JButton btnSkill34E;
    private javax.swing.JButton btnSkill34P;
    private javax.swing.JButton btnSkill41E;
    private javax.swing.JButton btnSkill41P;
    private javax.swing.JButton btnSkill42E;
    private javax.swing.JButton btnSkill42P;
    private javax.swing.JButton btnSkill43E;
    private javax.swing.JButton btnSkill43P;
    private javax.swing.JButton btnSkill44E;
    private javax.swing.JButton btnSkill44P;
    private javax.swing.JButton btnSkill51E;
    private javax.swing.JButton btnSkill51P;
    private javax.swing.JButton btnSkill52E;
    private javax.swing.JButton btnSkill52P;
    private javax.swing.JButton btnSkill53E;
    private javax.swing.JButton btnSkill53P;
    private javax.swing.JButton btnSkill54E;
    private javax.swing.JButton btnSkill54P;
    private javax.swing.JButton btnSwapChar;
    private javax.swing.JLabel lblBackground1;
    private javax.swing.JLabel lblBackground2;
    private javax.swing.JLabel lblClassTitle1E;
    private javax.swing.JLabel lblClassTitle1P;
    private javax.swing.JLabel lblClassTitle2E;
    private javax.swing.JLabel lblClassTitle2P;
    private javax.swing.JLabel lblClassTitle3E;
    private javax.swing.JLabel lblClassTitle3P;
    private javax.swing.JLabel lblClassTitle4E;
    private javax.swing.JLabel lblClassTitle4P;
    private javax.swing.JLabel lblClassTitle5E;
    private javax.swing.JLabel lblClassTitle5P;
    private javax.swing.JLabel lblEnemy;
    private javax.swing.JLabel lblEnemyAcessorySlots;
    private javax.swing.JLabel lblEnemyClassName;
    private javax.swing.JLabel lblEnemyDefenseSlots;
    private javax.swing.JLabel lblEnemyMainGearSlots;
    private javax.swing.JLabel lblEnemyStats;
    private javax.swing.JLabel lblFrameTitle1E;
    private javax.swing.JLabel lblFrameTitle1P;
    private javax.swing.JLabel lblFrameTitle2E;
    private javax.swing.JLabel lblFrameTitle2P;
    private javax.swing.JLabel lblFrameTitle3E;
    private javax.swing.JLabel lblFrameTitle3P;
    private javax.swing.JLabel lblFrameTitle4E;
    private javax.swing.JLabel lblFrameTitle4P;
    private javax.swing.JLabel lblFrameTitle5E;
    private javax.swing.JLabel lblFrameTitle5P;
    private javax.swing.JLabel lblFraseAjuda;
    private javax.swing.JLabel lblImgCover1H;
    private javax.swing.JLabel lblImgCover1HE;
    private javax.swing.JLabel lblImgCover2H;
    private javax.swing.JLabel lblImgCover2HE;
    private javax.swing.JLabel lblImgCoverAmulet;
    private javax.swing.JLabel lblImgCoverAmuletE;
    private javax.swing.JLabel lblImgCoverArmor;
    private javax.swing.JLabel lblImgCoverArmorE;
    private javax.swing.JLabel lblImgCoverBoots;
    private javax.swing.JLabel lblImgCoverBootsE;
    private javax.swing.JLabel lblImgCoverBracelet;
    private javax.swing.JLabel lblImgCoverBraceletE;
    private javax.swing.JLabel lblImgCoverGauntlet;
    private javax.swing.JLabel lblImgCoverGauntletE;
    private javax.swing.JLabel lblImgCoverRing1;
    private javax.swing.JLabel lblImgCoverRing1E;
    private javax.swing.JLabel lblImgCoverRing2;
    private javax.swing.JLabel lblImgCoverRing2E;
    private javax.swing.JLabel lblImgCoverSheltom;
    private javax.swing.JLabel lblImgCoverSheltomE;
    private javax.swing.JLabel lblImgCoverShield;
    private javax.swing.JLabel lblImgCoverShieldE;
    private javax.swing.JLabel lblImgSkill11E;
    private javax.swing.JLabel lblImgSkill11P;
    private javax.swing.JLabel lblImgSkill12E;
    private javax.swing.JLabel lblImgSkill12P;
    private javax.swing.JLabel lblImgSkill13E;
    private javax.swing.JLabel lblImgSkill13P;
    private javax.swing.JLabel lblImgSkill14E;
    private javax.swing.JLabel lblImgSkill14P;
    private javax.swing.JLabel lblImgSkill21E;
    private javax.swing.JLabel lblImgSkill21P;
    private javax.swing.JLabel lblImgSkill22E;
    private javax.swing.JLabel lblImgSkill22P;
    private javax.swing.JLabel lblImgSkill23E;
    private javax.swing.JLabel lblImgSkill23P;
    private javax.swing.JLabel lblImgSkill24E;
    private javax.swing.JLabel lblImgSkill24P;
    private javax.swing.JLabel lblImgSkill31E;
    private javax.swing.JLabel lblImgSkill31P;
    private javax.swing.JLabel lblImgSkill32E;
    private javax.swing.JLabel lblImgSkill32P;
    private javax.swing.JLabel lblImgSkill33E;
    private javax.swing.JLabel lblImgSkill33P;
    private javax.swing.JLabel lblImgSkill34E;
    private javax.swing.JLabel lblImgSkill34P;
    private javax.swing.JLabel lblImgSkill41E;
    private javax.swing.JLabel lblImgSkill41P;
    private javax.swing.JLabel lblImgSkill42E;
    private javax.swing.JLabel lblImgSkill42P;
    private javax.swing.JLabel lblImgSkill43E;
    private javax.swing.JLabel lblImgSkill43P;
    private javax.swing.JLabel lblImgSkill44E;
    private javax.swing.JLabel lblImgSkill44P;
    private javax.swing.JLabel lblImgSkill51E;
    private javax.swing.JLabel lblImgSkill51P;
    private javax.swing.JLabel lblImgSkill52E;
    private javax.swing.JLabel lblImgSkill52P;
    private javax.swing.JLabel lblImgSkill53E;
    private javax.swing.JLabel lblImgSkill53P;
    private javax.swing.JLabel lblImgSkill54E;
    private javax.swing.JLabel lblImgSkill54P;
    private javax.swing.JLabel lblLevelSkill11E;
    private javax.swing.JLabel lblLevelSkill11P;
    private javax.swing.JLabel lblLevelSkill12E;
    private javax.swing.JLabel lblLevelSkill12P;
    private javax.swing.JLabel lblLevelSkill13E;
    private javax.swing.JLabel lblLevelSkill13P;
    private javax.swing.JLabel lblLevelSkill14E;
    private javax.swing.JLabel lblLevelSkill14P;
    private javax.swing.JLabel lblLevelSkill21E;
    private javax.swing.JLabel lblLevelSkill21P;
    private javax.swing.JLabel lblLevelSkill22E;
    private javax.swing.JLabel lblLevelSkill22P;
    private javax.swing.JLabel lblLevelSkill23E;
    private javax.swing.JLabel lblLevelSkill23P;
    private javax.swing.JLabel lblLevelSkill24E;
    private javax.swing.JLabel lblLevelSkill24P;
    private javax.swing.JLabel lblLevelSkill31E;
    private javax.swing.JLabel lblLevelSkill31P;
    private javax.swing.JLabel lblLevelSkill32E;
    private javax.swing.JLabel lblLevelSkill32P;
    private javax.swing.JLabel lblLevelSkill33E;
    private javax.swing.JLabel lblLevelSkill33P;
    private javax.swing.JLabel lblLevelSkill34E;
    private javax.swing.JLabel lblLevelSkill34P;
    private javax.swing.JLabel lblLevelSkill41E;
    private javax.swing.JLabel lblLevelSkill41P;
    private javax.swing.JLabel lblLevelSkill42E;
    private javax.swing.JLabel lblLevelSkill42P;
    private javax.swing.JLabel lblLevelSkill43E;
    private javax.swing.JLabel lblLevelSkill43P;
    private javax.swing.JLabel lblLevelSkill44E;
    private javax.swing.JLabel lblLevelSkill44P;
    private javax.swing.JLabel lblLevelSkill51E;
    private javax.swing.JLabel lblLevelSkill51P;
    private javax.swing.JLabel lblLevelSkill52E;
    private javax.swing.JLabel lblLevelSkill52P;
    private javax.swing.JLabel lblLevelSkill53E;
    private javax.swing.JLabel lblLevelSkill53P;
    private javax.swing.JLabel lblLevelSkill54E;
    private javax.swing.JLabel lblLevelSkill54P;
    private javax.swing.JLabel lblPlayer;
    private javax.swing.JLabel lblPlayerAcessorySlots;
    private javax.swing.JLabel lblPlayerClassName;
    private javax.swing.JLabel lblPlayerDefenseSlots;
    private javax.swing.JLabel lblPlayerMainGearSlots;
    private javax.swing.JLabel lblPlayerSkillBGE;
    private javax.swing.JLabel lblPlayerSkillBGP;
    private javax.swing.JLabel lblPlayerStats;
    private javax.swing.JLabel lblRemainEPE;
    private javax.swing.JLabel lblRemainEPP;
    private javax.swing.JLabel lblRemainRSPE;
    private javax.swing.JLabel lblRemainRSPP;
    private javax.swing.JLabel lblRemainSPE;
    private javax.swing.JLabel lblRemainSPP;
    private javax.swing.JLabel lblScreenFlash;
    private javax.swing.JPanel panEnemyAcessorySlots;
    private javax.swing.JPanel panEnemyDefenseSlots;
    private javax.swing.JPanel panEnemyMainGearSlots;
    private javax.swing.JPanel panEnemyStats;
    private javax.swing.JPanel panPlayerAcessorySlots;
    private javax.swing.JPanel panPlayerDefenseSlots;
    private javax.swing.JPanel panPlayerMainGearSlots;
    private javax.swing.JPanel panPlayerStats;
    private javax.swing.JPanel panSideEnemy;
    private javax.swing.JPanel panSidePlayer;
    private javax.swing.JPanel panSkillEnemy;
    private javax.swing.JPanel panSkillPlayer;
    private javax.swing.JPanel panSkillT1E;
    private javax.swing.JPanel panSkillT1P;
    private javax.swing.JPanel panSkillT2E;
    private javax.swing.JPanel panSkillT2P;
    private javax.swing.JPanel panSkillT3E;
    private javax.swing.JPanel panSkillT3P;
    private javax.swing.JPanel panSkillT4E;
    private javax.swing.JPanel panSkillT4P;
    private javax.swing.JPanel panSkillT5E;
    private javax.swing.JPanel panSkillT5P;
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
        this.getContentPane().setComponentZOrder(bg, 21 + z);
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
        PlainDocument document7 = (PlainDocument) txtELevel.getDocument();
        document7.setDocumentFilter(new FiltroTexto());
        PlainDocument document8 = (PlainDocument) txtEStrenght.getDocument();
        document8.setDocumentFilter(new FiltroTexto());
        PlainDocument document9 = (PlainDocument) txtESpirit.getDocument();
        document9.setDocumentFilter(new FiltroTexto());
        PlainDocument document10 = (PlainDocument) txtETalent.getDocument();
        document10.setDocumentFilter(new FiltroTexto());
        PlainDocument document11 = (PlainDocument) txtEAgility.getDocument();
        document11.setDocumentFilter(new FiltroTexto());
        PlainDocument document12 = (PlainDocument) txtEHealth.getDocument();
        document12.setDocumentFilter(new FiltroTexto());

    }

    public void updatePlayerStats() {
        main.pChar.setLevel(Integer.valueOf(txtPLevel.getText()));
        refreshPlayerStats();
    }

    public void refreshPlayerStats() {
        txtPLevel.setText(String.valueOf(main.pChar.getLevel()));
        //main.pChar.resetStats();
        txtPRemainStats.setText(String.valueOf(main.pChar.getRemainStats()));
        txtPStrenght.setText(String.valueOf(main.pChar.getStrenght()));
        txtPSpirit.setText(String.valueOf(main.pChar.getSpirit()));
        txtPTalent.setText(String.valueOf(main.pChar.getTalent()));
        txtPAgility.setText(String.valueOf(main.pChar.getAgility()));
        txtPHealth.setText(String.valueOf(main.pChar.getHealth()));
        main.pChar.checkAllItemReqStatsMatch();
        atualizarTooltipP();
    }

    private void updateEnemyStats() {
        main.eChar.setLevel(Integer.valueOf(txtELevel.getText()));
        refreshEnemyStats();
    }

    private void refreshEnemyStats() {
        txtELevel.setText(String.valueOf(main.eChar.getLevel()));
        //main.eChar.resetStats();
        txtERemainStats.setText(String.valueOf(main.eChar.getRemainStats()));
        txtEStrenght.setText(String.valueOf(main.eChar.getStrenght()));
        txtESpirit.setText(String.valueOf(main.eChar.getSpirit()));
        txtETalent.setText(String.valueOf(main.eChar.getTalent()));
        txtEAgility.setText(String.valueOf(main.eChar.getAgility()));
        txtEHealth.setText(String.valueOf(main.eChar.getHealth()));
        main.eChar.checkAllItemReqStatsMatch();
        atualizarTooltipE();
    }

    private int statLimit(String stat, CharacterStats c, String strValue) {
        int value;
        try {
            value = Integer.parseInt(strValue);
        } catch (NumberFormatException nfe) {
            value = 0;
        }
        int retValue = 0;
        switch (stat) {
            case "str":
                if (value < c.getBaseStr()) {
                    c.setStrenght(c.getBaseStr());
                    retValue = c.getBaseStr();
                } else if (value > (c.getRemainStats() + c.getStrenght())) {
                    c.setStrenght(c.getBaseStr() + c.getRemainStats());
                    retValue = c.getStrenght();
                } else {
                    c.setStrenght(value);
                    retValue = value;
                }
                break;
            case "spi":
                if (value < c.getBaseSpi()) {
                    c.setSpirit(c.getBaseSpi());
                    retValue = c.getBaseSpi();
                } else if (value > (c.getRemainStats() + c.getSpirit())) {
                    c.setSpirit(c.getBaseSpi() + c.getRemainStats());
                    retValue = c.getSpirit();
                } else {
                    c.setSpirit(value);
                    retValue = value;
                }
                break;
            case "tal":
                if (value < c.getBaseTal()) {
                    c.setTalent(c.getBaseTal());
                    retValue = c.getBaseTal();
                } else if (value > (c.getRemainStats() + c.getTalent())) {
                    c.setTalent(c.getBaseTal() + c.getRemainStats());
                    retValue = c.getTalent();
                } else {
                    c.setTalent(value);
                    retValue = value;
                }
                break;
            case "agi":
                if (value < c.getBaseAgi()) {
                    c.setAgility(c.getBaseAgi());
                    retValue = c.getBaseAgi();
                } else if (value > (c.getRemainStats() + c.getAgility())) {
                    c.setAgility(c.getBaseAgi() + c.getRemainStats());
                    retValue = c.getAgility();
                } else {
                    c.setAgility(value);
                    retValue = value;
                }
                break;
            case "vit":
                if (value < c.getBaseVit()) {
                    c.setHealth(c.getBaseVit());
                    retValue = c.getBaseVit();
                } else if (value > (c.getRemainStats() + c.getHealth())) {
                    c.setHealth(c.getBaseVit() + c.getRemainStats());
                    retValue = c.getHealth();
                } else {
                    c.setHealth(value);
                    retValue = value;
                }
                break;
            default:
                retValue = 9999;
                break;
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

    public void resetStatus(boolean playerOrEnemy) {
        if (playerOrEnemy == PLAYER) {
            main.pChar.resetStats();
            updatePlayerStats();
        } else {
            main.eChar.resetStats();
            updateEnemyStats();
        }
    }

    private void atualizarTooltipP() {
        btnPlayerWeapon1.setToolTipText(main.pChar.getItemWeaponOneHand().getItemDesc());
        btnPlayerWeapon2.setToolTipText(main.pChar.getItemWeaponTwoHand().getItemDesc());
        btnPlayerArmor.setToolTipText(main.pChar.getItemArmor().getItemDesc());
        btnPlayerShield.setToolTipText(main.pChar.getItemShield().getItemDesc());
        btnPlayerBracelet.setToolTipText(main.pChar.getItemBracelet().getItemDesc());
        btnPlayerGauntlet.setToolTipText(main.pChar.getItemGauntlet().getItemDesc());
        btnPlayerBoots.setToolTipText(main.pChar.getItemBoots().getItemDesc());
        btnPlayerAmulet.setToolTipText(main.pChar.getItemAmulet().getItemDesc());
        btnPlayerRing1.setToolTipText(main.pChar.getItemRing1().getItemDesc());
        btnPlayerRing2.setToolTipText(main.pChar.getItemRing2().getItemDesc());
        btnPlayerSheltom.setToolTipText(main.pChar.getItemSheltom().getItemDesc());
    }

    private void atualizarTooltipE() {
        btnEnemyWeapon1.setToolTipText(main.eChar.getItemWeaponOneHand().getItemDesc());
        btnEnemyWeapon2.setToolTipText(main.eChar.getItemWeaponTwoHand().getItemDesc());
        btnEnemyArmor.setToolTipText(main.eChar.getItemArmor().getItemDesc());
        btnEnemyShield.setToolTipText(main.eChar.getItemShield().getItemDesc());
        btnEnemyBracelet.setToolTipText(main.eChar.getItemBracelet().getItemDesc());
        btnEnemyGauntlet.setToolTipText(main.eChar.getItemGauntlet().getItemDesc());
        btnEnemyBoots.setToolTipText(main.eChar.getItemBoots().getItemDesc());
        btnEnemyAmulet.setToolTipText(main.eChar.getItemAmulet().getItemDesc());
        btnEnemyRing1.setToolTipText(main.eChar.getItemRing1().getItemDesc());
        btnEnemyRing2.setToolTipText(main.eChar.getItemRing2().getItemDesc());
        btnEnemySheltom.setToolTipText(main.eChar.getItemSheltom().getItemDesc());
    }

    private void popularArraysSkillsP() {
        //Image labels
        main.pChar.imgSkill[0][0] = lblImgSkill11P;
        main.pChar.imgSkill[0][1] = lblImgSkill12P;
        main.pChar.imgSkill[0][2] = lblImgSkill13P;
        main.pChar.imgSkill[0][3] = lblImgSkill14P;
        main.pChar.imgSkill[1][0] = lblImgSkill21P;
        main.pChar.imgSkill[1][1] = lblImgSkill22P;
        main.pChar.imgSkill[1][2] = lblImgSkill23P;
        main.pChar.imgSkill[1][3] = lblImgSkill24P;
        main.pChar.imgSkill[2][0] = lblImgSkill31P;
        main.pChar.imgSkill[2][1] = lblImgSkill32P;
        main.pChar.imgSkill[2][2] = lblImgSkill33P;
        main.pChar.imgSkill[2][3] = lblImgSkill34P;
        main.pChar.imgSkill[3][0] = lblImgSkill41P;
        main.pChar.imgSkill[3][1] = lblImgSkill42P;
        main.pChar.imgSkill[3][2] = lblImgSkill43P;
        main.pChar.imgSkill[3][3] = lblImgSkill44P;
        main.pChar.imgSkill[4][0] = lblImgSkill51P;
        main.pChar.imgSkill[4][1] = lblImgSkill52P;
        main.pChar.imgSkill[4][2] = lblImgSkill53P;
        main.pChar.imgSkill[4][3] = lblImgSkill54P;

        //Buttons
        main.pChar.btnSkill[0][0] = btnSkill11P;
        main.pChar.btnSkill[0][1] = btnSkill12P;
        main.pChar.btnSkill[0][2] = btnSkill13P;
        main.pChar.btnSkill[0][3] = btnSkill14P;
        main.pChar.btnSkill[1][0] = btnSkill21P;
        main.pChar.btnSkill[1][1] = btnSkill22P;
        main.pChar.btnSkill[1][2] = btnSkill23P;
        main.pChar.btnSkill[1][3] = btnSkill24P;
        main.pChar.btnSkill[2][0] = btnSkill31P;
        main.pChar.btnSkill[2][1] = btnSkill32P;
        main.pChar.btnSkill[2][2] = btnSkill33P;
        main.pChar.btnSkill[2][3] = btnSkill34P;
        main.pChar.btnSkill[3][0] = btnSkill41P;
        main.pChar.btnSkill[3][1] = btnSkill42P;
        main.pChar.btnSkill[3][2] = btnSkill43P;
        main.pChar.btnSkill[3][3] = btnSkill44P;
        main.pChar.btnSkill[4][0] = btnSkill51P;
        main.pChar.btnSkill[4][1] = btnSkill52P;
        main.pChar.btnSkill[4][2] = btnSkill53P;
        main.pChar.btnSkill[4][3] = btnSkill54P;

        //Level Labels
        main.pChar.lvlSkill[0][0] = lblLevelSkill11P;
        main.pChar.lvlSkill[0][1] = lblLevelSkill12P;
        main.pChar.lvlSkill[0][2] = lblLevelSkill13P;
        main.pChar.lvlSkill[0][3] = lblLevelSkill14P;
        main.pChar.lvlSkill[1][0] = lblLevelSkill21P;
        main.pChar.lvlSkill[1][1] = lblLevelSkill22P;
        main.pChar.lvlSkill[1][2] = lblLevelSkill23P;
        main.pChar.lvlSkill[1][3] = lblLevelSkill24P;
        main.pChar.lvlSkill[2][0] = lblLevelSkill31P;
        main.pChar.lvlSkill[2][1] = lblLevelSkill32P;
        main.pChar.lvlSkill[2][2] = lblLevelSkill33P;
        main.pChar.lvlSkill[2][3] = lblLevelSkill34P;
        main.pChar.lvlSkill[3][0] = lblLevelSkill41P;
        main.pChar.lvlSkill[3][1] = lblLevelSkill42P;
        main.pChar.lvlSkill[3][2] = lblLevelSkill43P;
        main.pChar.lvlSkill[3][3] = lblLevelSkill44P;
        main.pChar.lvlSkill[4][0] = lblLevelSkill51P;
        main.pChar.lvlSkill[4][1] = lblLevelSkill52P;
        main.pChar.lvlSkill[4][2] = lblLevelSkill53P;
        main.pChar.lvlSkill[4][3] = lblLevelSkill54P;

        //Frame do título de classe
        main.pChar.classTitleFrame[0] = lblFrameTitle1P;
        main.pChar.classTitleFrame[1] = lblFrameTitle2P;
        main.pChar.classTitleFrame[2] = lblFrameTitle3P;
        main.pChar.classTitleFrame[3] = lblFrameTitle4P;
        main.pChar.classTitleFrame[4] = lblFrameTitle5P;

        //Nome da classe
        main.pChar.classTitleName[0] = lblClassTitle1P;
        main.pChar.classTitleName[1] = lblClassTitle2P;
        main.pChar.classTitleName[2] = lblClassTitle3P;
        main.pChar.classTitleName[3] = lblClassTitle4P;
        main.pChar.classTitleName[4] = lblClassTitle5P;

    }
    
    private void popularArraysSkillsE() {
        //Image labels
        main.eChar.imgSkill[0][0] = lblImgSkill11E;
        main.eChar.imgSkill[0][1] = lblImgSkill12E;
        main.eChar.imgSkill[0][2] = lblImgSkill13E;
        main.eChar.imgSkill[0][3] = lblImgSkill14E;
        main.eChar.imgSkill[1][0] = lblImgSkill21E;
        main.eChar.imgSkill[1][1] = lblImgSkill22E;
        main.eChar.imgSkill[1][2] = lblImgSkill23E;
        main.eChar.imgSkill[1][3] = lblImgSkill24E;
        main.eChar.imgSkill[2][0] = lblImgSkill31E;
        main.eChar.imgSkill[2][1] = lblImgSkill32E;
        main.eChar.imgSkill[2][2] = lblImgSkill33E;
        main.eChar.imgSkill[2][3] = lblImgSkill34E;
        main.eChar.imgSkill[3][0] = lblImgSkill41E;
        main.eChar.imgSkill[3][1] = lblImgSkill42E;
        main.eChar.imgSkill[3][2] = lblImgSkill43E;
        main.eChar.imgSkill[3][3] = lblImgSkill44E;
        main.eChar.imgSkill[4][0] = lblImgSkill51E;
        main.eChar.imgSkill[4][1] = lblImgSkill52E;
        main.eChar.imgSkill[4][2] = lblImgSkill53E;
        main.eChar.imgSkill[4][3] = lblImgSkill54E;

        //Buttons
        main.eChar.btnSkill[0][0] = btnSkill11E;
        main.eChar.btnSkill[0][1] = btnSkill12E;
        main.eChar.btnSkill[0][2] = btnSkill13E;
        main.eChar.btnSkill[0][3] = btnSkill14E;
        main.eChar.btnSkill[1][0] = btnSkill21E;
        main.eChar.btnSkill[1][1] = btnSkill22E;
        main.eChar.btnSkill[1][2] = btnSkill23E;
        main.eChar.btnSkill[1][3] = btnSkill24E;
        main.eChar.btnSkill[2][0] = btnSkill31E;
        main.eChar.btnSkill[2][1] = btnSkill32E;
        main.eChar.btnSkill[2][2] = btnSkill33E;
        main.eChar.btnSkill[2][3] = btnSkill34E;
        main.eChar.btnSkill[3][0] = btnSkill41E;
        main.eChar.btnSkill[3][1] = btnSkill42E;
        main.eChar.btnSkill[3][2] = btnSkill43E;
        main.eChar.btnSkill[3][3] = btnSkill44E;
        main.eChar.btnSkill[4][0] = btnSkill51E;
        main.eChar.btnSkill[4][1] = btnSkill52E;
        main.eChar.btnSkill[4][2] = btnSkill53E;
        main.eChar.btnSkill[4][3] = btnSkill54E;

        //Level Labels
        main.eChar.lvlSkill[0][0] = lblLevelSkill11E;
        main.eChar.lvlSkill[0][1] = lblLevelSkill12E;
        main.eChar.lvlSkill[0][2] = lblLevelSkill13E;
        main.eChar.lvlSkill[0][3] = lblLevelSkill14E;
        main.eChar.lvlSkill[1][0] = lblLevelSkill21E;
        main.eChar.lvlSkill[1][1] = lblLevelSkill22E;
        main.eChar.lvlSkill[1][2] = lblLevelSkill23E;
        main.eChar.lvlSkill[1][3] = lblLevelSkill24E;
        main.eChar.lvlSkill[2][0] = lblLevelSkill31E;
        main.eChar.lvlSkill[2][1] = lblLevelSkill32E;
        main.eChar.lvlSkill[2][2] = lblLevelSkill33E;
        main.eChar.lvlSkill[2][3] = lblLevelSkill34E;
        main.eChar.lvlSkill[3][0] = lblLevelSkill41E;
        main.eChar.lvlSkill[3][1] = lblLevelSkill42E;
        main.eChar.lvlSkill[3][2] = lblLevelSkill43E;
        main.eChar.lvlSkill[3][3] = lblLevelSkill44E;
        main.eChar.lvlSkill[4][0] = lblLevelSkill51E;
        main.eChar.lvlSkill[4][1] = lblLevelSkill52E;
        main.eChar.lvlSkill[4][2] = lblLevelSkill53E;
        main.eChar.lvlSkill[4][3] = lblLevelSkill54E;

        //Frame do título de classe
        main.eChar.classTitleFrame[0] = lblFrameTitle1E;
        main.eChar.classTitleFrame[1] = lblFrameTitle2E;
        main.eChar.classTitleFrame[2] = lblFrameTitle3E;
        main.eChar.classTitleFrame[3] = lblFrameTitle4E;
        main.eChar.classTitleFrame[4] = lblFrameTitle5E;

        //Nome da classe
        main.eChar.classTitleName[0] = lblClassTitle1E;
        main.eChar.classTitleName[1] = lblClassTitle2E;
        main.eChar.classTitleName[2] = lblClassTitle3E;
        main.eChar.classTitleName[3] = lblClassTitle4E;
        main.eChar.classTitleName[4] = lblClassTitle5E;

    }

    

    private void showHideSkillPlayer() {
        //toggle = false -> Abre skills, fecha status
        //toggle = true -> Fecha skills, abre status
        if (!toggleSkillP) {
            VerticalHorizontalAnimation panRight = new VerticalHorizontalAnimation();
            panRight.showRightPanel(panPlayerStats, -171, 38);
            sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");

            VerticalHorizontalAnimation panLeft = new VerticalHorizontalAnimation();
            panLeft.showLeftPanel(panSkillPlayer, 170, 38);
            sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");
            toggleSkillP = true;
        } else {
            VerticalHorizontalAnimation scsb = new VerticalHorizontalAnimation();
            scsb.showLeftPanel(panPlayerStats, 197, 38);
            sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");

            VerticalHorizontalAnimation scsb2 = new VerticalHorizontalAnimation();
            scsb2.showRightPanel(panSkillPlayer, -220, 38);
            sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");
            toggleSkillP = false;
        }
    }
    
    private void showHideSkillEnemy() {
        //toggle = false -> Abre skills, fecha status
        //toggle = true -> Fecha skills, abre status
        if (!toggleSkillE) {
            VerticalHorizontalAnimation panLeft = new VerticalHorizontalAnimation();
            panLeft.showLeftPanel(panEnemyStats, 800, 38);
            sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");
            
            VerticalHorizontalAnimation panRight = new VerticalHorizontalAnimation();
            panRight.showRightPanel(panSkillEnemy, 409, 38);
            sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");
            toggleSkillE = true;
            
        } else {
            VerticalHorizontalAnimation scsb = new VerticalHorizontalAnimation();
            scsb.showRightPanel(panEnemyStats, 440, 38);
            sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");
            
            VerticalHorizontalAnimation scsb2 = new VerticalHorizontalAnimation();
            scsb2.showLeftPanel(panSkillEnemy, 800, 38);
            sfx.playSound("/woosh/woosh" + gerarRng(4, 8) + ".wav");
            toggleSkillE = false;
        }
    }

    static void disableButton(final AbstractButton b, final long ms) {
        b.setEnabled(false);
        new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                Thread.sleep(ms);
                return null;
            }

            @Override
            protected void done() {
                b.setEnabled(true);
            }
        }.execute();
    }

    private void skillWorker(byte action, CharacterStats c, int oTier, int oSkill) {
        switch (action) {
            case START:
                for (int tier = 0; tier <= 4; tier++) {
                    for (int skill = 0; skill <= 3; skill++) {
                        c.btnSkill[tier][skill].setEnabled(false);
                        c.imgSkill[tier][skill].setIcon(textureWork.addTranspBMP("/assets/images/skills/" + c.getClasse() + "/Button/" + (tier + 1) + (skill + 1) + "-.bmp"));
                    }
                    c.classTitleFrame[tier].setIcon(textureWork.addTranspBMP("/assets/images/skills/inter/classTitleFrame" + (tier + 1) + ".png"));
                    c.classTitleName[tier].setIcon(textureWork.addTranspBMP("/assets/images/skills/" + c.getClasse() + "/JobTitle/" + (tier + 1) + ".bmp"));
                }
                c.btnSkill[0][0].setEnabled(true);
                c.imgSkill[0][0].setIcon(textureWork.addTranspBMP("/assets/images/skills/" + c.getClasse() + "/Button/" + (1) + (1) + ".bmp"));
                break;
            case RESETTIER5:
                if (c.getSkillLvl()[3][3] != 0) {
                    c.resetSkillPoints(CharacterStats.TIER5);
                    for (int tier = 4; tier <= 4; tier++) {
                        for (int skill = 0; skill <= 3; skill++) {
                            c.lvlSkill[tier][skill].setText("Lv: " + main.pChar.getSkillLvl()[tier][skill]);
                            c.lvlSkill[tier][skill].setForeground(Color.RED);
                            c.imgSkill[tier][skill].setIcon(textureWork.addTranspBMP("/assets/images/skills/" + c.getClasse() + "/Button/" + (tier + 1) + (skill + 1) + "-.bmp"));
                            c.btnSkill[tier][skill].setEnabled(false);
                        }
                    }
                    c.btnSkill[4][0].setEnabled(true);
                    c.imgSkill[4][0].setIcon(textureWork.addTranspBMP("/assets/images/skills/" + c.getClasse() + "/Button/" + (5) + (1) + ".bmp"));
                }
                break;
            case RESETALL:
                c.resetSkillPoints(CharacterStats.ALL);
                for (int tier = 0; tier <= 4; tier++) {
                    for (int skill = 0; skill <= 3; skill++) {
                        c.lvlSkill[tier][skill].setText("Lv: " + main.pChar.getSkillLvl()[tier][skill]);
                        c.lvlSkill[tier][skill].setForeground(Color.RED);
                        c.imgSkill[tier][skill].setIcon(textureWork.addTranspBMP("/assets/images/skills/" + c.getClasse() + "/Button/" + (tier + 1) + (skill + 1) + "-.bmp"));
                        c.btnSkill[tier][skill].setEnabled(false);
                    }
                }
                c.btnSkill[0][0].setEnabled(true);
                c.imgSkill[0][0].setIcon(textureWork.addTranspBMP("/assets/images/skills/" + c.getClasse() + "/Button/" + (1) + (1) + ".bmp"));
                break;
            case RAISE:
                if (c.getSkillLvl()[oTier][oSkill] == 10 || ((oTier < 3 && c.getrSP() == 0) || (oTier == 3 && c.getrEP() == 0) || (oTier == 4 && c.getrRSP() == 0)) 
                        || (!c.isSkillLvlMatch(oTier, oSkill))) {

                } else {
                    c.raiseSkillLevel(oTier, oSkill, CharacterStats.UP);
                    if (c.getSkillLvl()[oTier][oSkill] != 0) {
                        c.lvlSkill[oTier][oSkill].setText("Lv: " + String.valueOf(c.getSkillLvl()[oTier][oSkill]));
                        c.imgSkill[oTier][oSkill].setIcon(textureWork.addTranspBMP("/assets/images/skills/" + c.getClasse() + "/Button/" + (oTier + 1) + (oSkill + 1) + ".bmp"));
                        if (c.getSkillLvl()[oTier][oSkill] == 10) {
                            c.lvlSkill[oTier][oSkill].setForeground(Color.CYAN);
                        } else {
                            c.lvlSkill[oTier][oSkill].setForeground(Color.WHITE);
                        }
                        if (oTier < 4) {
                            if (oSkill < 3) {
                                c.btnSkill[oTier][oSkill + 1].setEnabled(true);
                                c.imgSkill[oTier][oSkill + 1].setIcon(textureWork.addTranspBMP("/assets/images/skills/" + c.getClasse() + "/Button/" + (oTier + 1) + (oSkill + 2) + ".bmp"));
                            } else {
                                c.btnSkill[oTier + 1][0].setEnabled(true);
                                c.imgSkill[oTier + 1][0].setIcon(textureWork.addTranspBMP("/assets/images/skills/" + c.getClasse() + "/Button/" + (oTier + 2) + (1) + ".bmp"));
                            }
                        } else {
                            if (oSkill < 3) {
                                c.btnSkill[oTier][oSkill + 1].setEnabled(true);
                                c.imgSkill[oTier][oSkill + 1].setIcon(textureWork.addTranspBMP("/assets/images/skills/" + c.getClasse() + "/Button/" + (oTier + 1) + (oSkill + 2) + ".bmp"));
                            }
                        }
                    }
                    sfx.playSound("Learn_Skill.wav");
                    lblFraseAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/fraseBuild.png")));
                }
                break;
            case DECREASE:
                if (c.getSkillLvl()[oTier][oSkill] == 0) {
                    c.lvlSkill[oTier][oSkill].setForeground(Color.RED);
                    c.lvlSkill[oTier][oSkill].setText("Lv: " + String.valueOf(c.getSkillLvl()[oTier][oSkill]));
                }
                c.raiseSkillLevel(oTier, oSkill, CharacterStats.DOWN);
                if (c.getSkillLvl()[oTier][oSkill] >= 1 && c.getSkillLvl()[oTier][oSkill] < 10) {
                    c.lvlSkill[oTier][oSkill].setForeground(Color.WHITE);
                    c.lvlSkill[oTier][oSkill].setText("Lv: " + String.valueOf(c.getSkillLvl()[oTier][oSkill]));
                } else 
                break;
        }
        atualizarPlayerSP();
        atualizarEnemySP();
    }
    
    private void atualizarPlayerSP() {
        lblRemainSPP.setText(String.valueOf(main.pChar.getrSP()));
        lblRemainEPP.setText(String.valueOf(main.pChar.getrEP()));
        lblRemainRSPP.setText(String.valueOf(main.pChar.getrRSP()));
    }

    private void atualizarEnemySP() {
        lblRemainSPE.setText(String.valueOf(main.eChar.getrSP()));
        lblRemainEPE.setText(String.valueOf(main.eChar.getrEP()));
        lblRemainRSPE.setText(String.valueOf(main.eChar.getrRSP()));
    }
}
