/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TextureWork;
import controller.assets.assetsController;
import controller.view.animation.ChooseGear;
import controller.game.main;
import controller.view.JdiGearSelectorController;
import controller.game.formula.CharacterStats;
import controller.game.item.ItemList;
import controller.game.item.Item;
import controller.game.item.ItemMix;
import controller.view.CursorController;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author LuizV1
 */
public class JdiGearSelector extends javax.swing.JDialog {
    
    public static final int EQUIP_MODE = 0;
    public static final int VIEW_MODE = 1;

    public static final byte EQUIPANDO = 0;
    public static final byte COMPARANDO = 1;
    
    public static final boolean ACTIVE = true;
    public static final boolean INACTIVE = false;
    
   static final boolean CLOSE = false;
   static final boolean OPEN = true;
    
    private boolean mixState = INACTIVE;
    
    public int viewMode = EQUIP_MODE;
    

    ItemList itemList = new ItemList();
    private Item selectingItem = new Item();
    private Item comparingItem = new Item();
    String slotToEquip;
    JButton btnSlotToEquip;
    JLabel lblCover;

    TextureWork textureWork = new TextureWork();

    private String callType;
    boolean playerOrEnemy;
    CharacterStats character;

    ChooseGear animGear;

    private final boolean SELECTINGITEM = true;
    private final boolean COMPARINGITEM = false;

    protected byte lastSelectedMixOrAge = 0;
    protected byte lastSelectedMixOrAgeC = 0;

    public byte getLastSelectedMixOrAge() {
        return lastSelectedMixOrAge;
    }

    public void setLastSelectedMixOrAge(byte lastSelectedMixOrAge) {
        this.lastSelectedMixOrAge = lastSelectedMixOrAge;
    }

    public byte getLastSelectedMixOrAgeC() {
        return lastSelectedMixOrAgeC;
    }

    public void setLastSelectedMixOrAgeC(byte lastSelectedMixOrAgeC) {
        this.lastSelectedMixOrAgeC = lastSelectedMixOrAgeC;
    }

    private boolean allowEquip = false;

    public static final byte NONE = 0;
    public static final byte AGING = 1;
    public static final byte MIX = 2;

    private boolean readOnly = false;
    private boolean firstView = true;
    
    JdiGearSelectorController gsControl = new JdiGearSelectorController();

    public ItemList getItemList() {
        return itemList;
    }

    public void setItemList(ItemList itemList) {
        this.itemList = itemList;
    }

    public JList<String> getJlistItem() {
        return jlistItem;
    }

    public void setJlistItem(JList<String> jlistItem) {
        this.jlistItem = jlistItem;
    }

    
    public JdiGearSelector(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        adicionarTranspSheltomUsado();
        
        setBackground(new Color(0, 0, 0, 0));

        setCursor(new CursorController().getDefaultCursor());

        jScrollPaneListaItem.getViewport().setOpaque(false);

        jScrollPaneListaItem.setOpaque(false);
        jScrollPaneListaItem.getViewport().setOpaque(false);
        jlistItem.setOpaque(false);
        jlistItem.setCellRenderer(new TransparentListCellRenderer());

        //Permite selecionar a jList com o click direito.
        jlistItem.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    JList list = (JList) e.getSource();
                    int row = list.locationToIndex(e.getPoint());
                    list.setSelectedIndex(row);
                }
            }

        });

        //Adiciona listener de quando uma lista foi selecionada
        class ItemChangeListener implements ItemListener {

            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    Object item = event.getItem();
                    // do something with object
                }
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        gearSection = new javax.swing.ButtonGroup();
        gearType = new javax.swing.ButtonGroup();
        panGearSelect = new javax.swing.JPanel();
        itemSelect = new javax.swing.JPanel();
        jScrollPaneListaItem = new javax.swing.JScrollPane();
        jlistItem = new javax.swing.JList<>();
        panItem = new javax.swing.JPanel();
        lblGearImage = new javax.swing.JLabel();
        lblGearDesc = new javax.swing.JLabel();
        lblGearDescFrame = new javax.swing.JLabel();
        lblGearImageBG = new javax.swing.JLabel();
        panSheltomUsado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblImgLucidy = new javax.swing.JLabel();
        lblLucidy = new javax.swing.JLabel();
        lblImgSereneo = new javax.swing.JLabel();
        lblSereneo = new javax.swing.JLabel();
        lblImgFadeo = new javax.swing.JLabel();
        lblFadeo = new javax.swing.JLabel();
        lblImgSparky = new javax.swing.JLabel();
        lblSparky = new javax.swing.JLabel();
        lblImgRaident = new javax.swing.JLabel();
        lblRaident = new javax.swing.JLabel();
        lblImgTransparo = new javax.swing.JLabel();
        lblTransparo = new javax.swing.JLabel();
        lblImgDevine = new javax.swing.JLabel();
        lblImgMirage = new javax.swing.JLabel();
        lblMirage = new javax.swing.JLabel();
        lblImgInferna = new javax.swing.JLabel();
        lblInferna = new javax.swing.JLabel();
        lblImgEnigma = new javax.swing.JLabel();
        lblEnigma = new javax.swing.JLabel();
        lblImgBellum = new javax.swing.JLabel();
        lblBellum = new javax.swing.JLabel();
        lblImgMurky = new javax.swing.JLabel();
        lblMurky = new javax.swing.JLabel();
        lblImgCelesto = new javax.swing.JLabel();
        lblCelesto = new javax.swing.JLabel();
        lblImgOredo = new javax.swing.JLabel();
        lblOredo = new javax.swing.JLabel();
        lblImgSapphire = new javax.swing.JLabel();
        lblSapphire = new javax.swing.JLabel();
        lblImgSol = new javax.swing.JLabel();
        lblSol = new javax.swing.JLabel();
        lblDevine = new javax.swing.JLabel();
        lblTotalSheltom = new javax.swing.JLabel();
        panCompareItem = new javax.swing.JPanel();
        lblGearImageC = new javax.swing.JLabel();
        lblGearDescC = new javax.swing.JLabel();
        lblGearDescFrameC = new javax.swing.JLabel();
        lblGearImageBGC = new javax.swing.JLabel();
        panSheltomUsadoC = new javax.swing.JPanel();
        jLabel2C = new javax.swing.JLabel();
        lblImgLucidyC = new javax.swing.JLabel();
        lblLucidyC = new javax.swing.JLabel();
        lblImgSereneoC = new javax.swing.JLabel();
        lblSereneoC = new javax.swing.JLabel();
        lblImgFadeoC = new javax.swing.JLabel();
        lblFadeoC = new javax.swing.JLabel();
        lblImgSparkyC = new javax.swing.JLabel();
        lblSparkyC = new javax.swing.JLabel();
        lblImgRaidentC = new javax.swing.JLabel();
        lblRaidentC = new javax.swing.JLabel();
        lblImgTransparoC = new javax.swing.JLabel();
        lblTransparoC = new javax.swing.JLabel();
        lblImgDevineC = new javax.swing.JLabel();
        lblImgMirageC = new javax.swing.JLabel();
        lblMirageC = new javax.swing.JLabel();
        lblImgInfernaC = new javax.swing.JLabel();
        lblInfernaC = new javax.swing.JLabel();
        lblImgEnigmaC = new javax.swing.JLabel();
        lblEnigmaC = new javax.swing.JLabel();
        lblImgBellumC = new javax.swing.JLabel();
        lblBellumC = new javax.swing.JLabel();
        lblImgMurkyC = new javax.swing.JLabel();
        lblMurkyC = new javax.swing.JLabel();
        lblImgCelestoC = new javax.swing.JLabel();
        lblCelestoC = new javax.swing.JLabel();
        lblImgOredoC = new javax.swing.JLabel();
        lblOredoC = new javax.swing.JLabel();
        lblImgSapphireC = new javax.swing.JLabel();
        lblSapphireC = new javax.swing.JLabel();
        lblImgSolC = new javax.swing.JLabel();
        lblSolC = new javax.swing.JLabel();
        lblDevineC = new javax.swing.JLabel();
        lblTotalSheltomC = new javax.swing.JLabel();
        cmbAgingLevel = new javax.swing.JComboBox<>();
        cmbMix = new javax.swing.JComboBox<>();
        lblAging = new javax.swing.JLabel();
        btnEquip = new javax.swing.JButton();
        cmbSpec = new javax.swing.JComboBox<>();
        lblClassSpec = new javax.swing.JLabel();
        lblAgingC = new javax.swing.JLabel();
        lblClassSpecC = new javax.swing.JLabel();
        cmbAgingLevelC = new javax.swing.JComboBox<>();
        cmbSpecC = new javax.swing.JComboBox<>();
        cmbMixC = new javax.swing.JComboBox<>();
        btnCleanItem = new javax.swing.JButton();
        btnCleanItemC = new javax.swing.JButton();
        lblArrowCompare = new javax.swing.JLabel();
        rbtAcessory = new javax.swing.JRadioButton();
        rbtDefense = new javax.swing.JRadioButton();
        rbtWeapon = new javax.swing.JRadioButton();
        rbtType10 = new javax.swing.JRadioButton();
        rbtType9 = new javax.swing.JRadioButton();
        rbtType8 = new javax.swing.JRadioButton();
        rbtType7 = new javax.swing.JRadioButton();
        rbtType6 = new javax.swing.JRadioButton();
        rbtType5 = new javax.swing.JRadioButton();
        rbtType4 = new javax.swing.JRadioButton();
        rbtType3 = new javax.swing.JRadioButton();
        rbtType2 = new javax.swing.JRadioButton();
        rbtType1 = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblMsg = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        lblBackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(850, 630));
        getContentPane().setLayout(null);

        panGearSelect.setOpaque(false);
        panGearSelect.setLayout(null);

        itemSelect.setOpaque(false);
        itemSelect.setLayout(null);

        jScrollPaneListaItem.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 102, 0), 2, true), javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED)));
        jScrollPaneListaItem.setOpaque(false);

        jlistItem.setBackground(new java.awt.Color(0, 0, 0));
        jlistItem.setForeground(new java.awt.Color(204, 204, 204));
        jlistItem.setOpaque(false);
        jlistItem.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jlistItemMouseClicked(evt);
            }
        });
        jlistItem.addListSelectionListener(new javax.swing.event.ListSelectionListener()
        {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt)
            {
                jlistItemValueChanged(evt);
            }
        });
        jScrollPaneListaItem.setViewportView(jlistItem);

        itemSelect.add(jScrollPaneListaItem);
        jScrollPaneListaItem.setBounds(3, 0, 170, 465);

        panItem.setBackground(new java.awt.Color(0, 0, 0));
        panItem.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true), new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));
        panItem.setOpaque(false);
        panItem.setLayout(null);

        lblGearImage.setBackground(new java.awt.Color(255, 255, 255));
        lblGearImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGearImage.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), null));
        panItem.add(lblGearImage);
        lblGearImage.setBounds(5, 90, 70, 100);

        lblGearDesc.setForeground(new java.awt.Color(255, 255, 255));
        lblGearDesc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGearDesc.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panItem.add(lblGearDesc);
        lblGearDesc.setBounds(90, 10, 200, 390);

        lblGearDescFrame.setForeground(new java.awt.Color(255, 255, 255));
        lblGearDescFrame.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGearDescFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/gearselect/itemdescframeTransp.png"))); // NOI18N
        lblGearDescFrame.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panItem.add(lblGearDescFrame);
        lblGearDescFrame.setBounds(80, 5, 200, 390);

        lblGearImageBG.setBackground(new java.awt.Color(255, 255, 255));
        lblGearImageBG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGearImageBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/selectetingItemBG.png"))); // NOI18N
        lblGearImageBG.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), null));
        panItem.add(lblGearImageBG);
        lblGearImageBG.setBounds(5, 90, 70, 100);

        panSheltomUsado.setOpaque(false);
        panSheltomUsado.setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sheltoms used on Aging/Mix manufacturing:");
        panSheltomUsado.add(jLabel1);
        jLabel1.setBounds(3, 0, 250, 14);

        lblImgLucidy.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImgLucidy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/lucidy.png"))); // NOI18N
        lblImgLucidy.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panSheltomUsado.add(lblImgLucidy);
        lblImgLucidy.setBounds(0, 15, 22, 22);

        lblLucidy.setForeground(new java.awt.Color(255, 255, 255));
        lblLucidy.setText("0");
        panSheltomUsado.add(lblLucidy);
        lblLucidy.setBounds(23, 20, 30, 14);

        lblImgSereneo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImgSereneo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/sereneo.png"))); // NOI18N
        lblImgSereneo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panSheltomUsado.add(lblImgSereneo);
        lblImgSereneo.setBounds(35, 15, 22, 22);

        lblSereneo.setForeground(new java.awt.Color(255, 255, 255));
        lblSereneo.setText("0");
        panSheltomUsado.add(lblSereneo);
        lblSereneo.setBounds(58, 20, 30, 14);

        lblImgFadeo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImgFadeo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/fadeo.png"))); // NOI18N
        lblImgFadeo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panSheltomUsado.add(lblImgFadeo);
        lblImgFadeo.setBounds(70, 15, 22, 22);

        lblFadeo.setForeground(new java.awt.Color(255, 255, 255));
        lblFadeo.setText("0");
        panSheltomUsado.add(lblFadeo);
        lblFadeo.setBounds(93, 20, 30, 14);

        lblImgSparky.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImgSparky.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/sparky.png"))); // NOI18N
        lblImgSparky.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panSheltomUsado.add(lblImgSparky);
        lblImgSparky.setBounds(103, 15, 22, 22);

        lblSparky.setForeground(new java.awt.Color(255, 255, 255));
        lblSparky.setText("0");
        panSheltomUsado.add(lblSparky);
        lblSparky.setBounds(125, 20, 30, 14);

        lblImgRaident.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImgRaident.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/raident.png"))); // NOI18N
        lblImgRaident.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panSheltomUsado.add(lblImgRaident);
        lblImgRaident.setBounds(135, 15, 22, 22);

        lblRaident.setForeground(new java.awt.Color(255, 255, 255));
        lblRaident.setText("0");
        panSheltomUsado.add(lblRaident);
        lblRaident.setBounds(157, 20, 30, 14);

        lblImgTransparo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImgTransparo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/transparo.png"))); // NOI18N
        lblImgTransparo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panSheltomUsado.add(lblImgTransparo);
        lblImgTransparo.setBounds(169, 15, 22, 22);

        lblTransparo.setForeground(new java.awt.Color(255, 255, 255));
        lblTransparo.setText("0");
        panSheltomUsado.add(lblTransparo);
        lblTransparo.setBounds(192, 20, 30, 14);

        lblImgDevine.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImgDevine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/devine.png"))); // NOI18N
        lblImgDevine.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panSheltomUsado.add(lblImgDevine);
        lblImgDevine.setBounds(240, 15, 22, 22);

        lblImgMirage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImgMirage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/mirage.png"))); // NOI18N
        lblImgMirage.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panSheltomUsado.add(lblImgMirage);
        lblImgMirage.setBounds(35, 40, 22, 22);

        lblMirage.setForeground(new java.awt.Color(255, 255, 255));
        lblMirage.setText("0");
        panSheltomUsado.add(lblMirage);
        lblMirage.setBounds(58, 45, 30, 14);

        lblImgInferna.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImgInferna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/inferna.png"))); // NOI18N
        lblImgInferna.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panSheltomUsado.add(lblImgInferna);
        lblImgInferna.setBounds(70, 40, 22, 22);

        lblInferna.setForeground(new java.awt.Color(255, 255, 255));
        lblInferna.setText("0");
        panSheltomUsado.add(lblInferna);
        lblInferna.setBounds(93, 45, 30, 14);

        lblImgEnigma.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImgEnigma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/enigma.png"))); // NOI18N
        lblImgEnigma.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panSheltomUsado.add(lblImgEnigma);
        lblImgEnigma.setBounds(103, 40, 22, 22);

        lblEnigma.setForeground(new java.awt.Color(255, 255, 255));
        lblEnigma.setText("0");
        panSheltomUsado.add(lblEnigma);
        lblEnigma.setBounds(125, 45, 30, 14);

        lblImgBellum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImgBellum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/bellum.png"))); // NOI18N
        lblImgBellum.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panSheltomUsado.add(lblImgBellum);
        lblImgBellum.setBounds(135, 40, 22, 22);

        lblBellum.setForeground(new java.awt.Color(255, 255, 255));
        lblBellum.setText("0");
        panSheltomUsado.add(lblBellum);
        lblBellum.setBounds(157, 45, 30, 14);

        lblImgMurky.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImgMurky.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/murky.png"))); // NOI18N
        lblImgMurky.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panSheltomUsado.add(lblImgMurky);
        lblImgMurky.setBounds(205, 15, 22, 22);

        lblMurky.setForeground(new java.awt.Color(255, 255, 255));
        lblMurky.setText("0");
        panSheltomUsado.add(lblMurky);
        lblMurky.setBounds(227, 20, 30, 14);

        lblImgCelesto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImgCelesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/celesto.png"))); // NOI18N
        lblImgCelesto.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panSheltomUsado.add(lblImgCelesto);
        lblImgCelesto.setBounds(0, 40, 22, 22);

        lblCelesto.setForeground(new java.awt.Color(255, 255, 255));
        lblCelesto.setText("0");
        panSheltomUsado.add(lblCelesto);
        lblCelesto.setBounds(23, 45, 30, 14);

        lblImgOredo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImgOredo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/oredo.png"))); // NOI18N
        lblImgOredo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panSheltomUsado.add(lblImgOredo);
        lblImgOredo.setBounds(169, 40, 22, 22);

        lblOredo.setForeground(new java.awt.Color(255, 255, 255));
        lblOredo.setText("0");
        panSheltomUsado.add(lblOredo);
        lblOredo.setBounds(192, 45, 30, 14);

        lblImgSapphire.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImgSapphire.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/sapphire.png"))); // NOI18N
        lblImgSapphire.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panSheltomUsado.add(lblImgSapphire);
        lblImgSapphire.setBounds(205, 40, 22, 22);

        lblSapphire.setForeground(new java.awt.Color(255, 255, 255));
        lblSapphire.setText("0");
        panSheltomUsado.add(lblSapphire);
        lblSapphire.setBounds(227, 45, 30, 14);

        lblImgSol.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImgSol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/sol.png"))); // NOI18N
        lblImgSol.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panSheltomUsado.add(lblImgSol);
        lblImgSol.setBounds(240, 40, 22, 22);

        lblSol.setForeground(new java.awt.Color(255, 255, 255));
        lblSol.setText("0");
        panSheltomUsado.add(lblSol);
        lblSol.setBounds(265, 45, 30, 14);

        lblDevine.setForeground(new java.awt.Color(255, 255, 255));
        lblDevine.setText("0");
        panSheltomUsado.add(lblDevine);
        lblDevine.setBounds(265, 20, 30, 14);

        lblTotalSheltom.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalSheltom.setText("0");
        panSheltomUsado.add(lblTotalSheltom);
        lblTotalSheltom.setBounds(225, 0, 50, 14);

        panItem.add(panSheltomUsado);
        panSheltomUsado.setBounds(10, 400, 290, 70);

        itemSelect.add(panItem);
        panItem.setBounds(175, 0, 300, 465);

        panCompareItem.setBackground(new java.awt.Color(0, 0, 0));
        panCompareItem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        panCompareItem.setOpaque(false);
        panCompareItem.setLayout(null);

        lblGearImageC.setBackground(new java.awt.Color(255, 255, 255));
        lblGearImageC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGearImageC.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), null));
        panCompareItem.add(lblGearImageC);
        lblGearImageC.setBounds(5, 90, 70, 100);

        lblGearDescC.setForeground(new java.awt.Color(255, 255, 255));
        lblGearDescC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGearDescC.setToolTipText("");
        lblGearDescC.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panCompareItem.add(lblGearDescC);
        lblGearDescC.setBounds(90, 10, 200, 390);

        lblGearDescFrameC.setForeground(new java.awt.Color(255, 255, 255));
        lblGearDescFrameC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGearDescFrameC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/gearselect/itemdescframeTransp.png"))); // NOI18N
        lblGearDescFrameC.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panCompareItem.add(lblGearDescFrameC);
        lblGearDescFrameC.setBounds(80, 5, 200, 390);

        lblGearImageBGC.setBackground(new java.awt.Color(255, 255, 255));
        lblGearImageBGC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGearImageBGC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/selectetingItemBG.png"))); // NOI18N
        lblGearImageBGC.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), null));
        panCompareItem.add(lblGearImageBGC);
        lblGearImageBGC.setBounds(5, 90, 70, 100);

        panSheltomUsadoC.setOpaque(false);
        panSheltomUsadoC.setLayout(null);

        jLabel2C.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2C.setText("Sheltoms used on Aging/Mix manufacturing:");
        panSheltomUsadoC.add(jLabel2C);
        jLabel2C.setBounds(3, 0, 250, 14);

        lblImgLucidyC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/lucidy.png"))); // NOI18N
        panSheltomUsadoC.add(lblImgLucidyC);
        lblImgLucidyC.setBounds(0, 15, 22, 22);

        lblLucidyC.setForeground(new java.awt.Color(255, 255, 255));
        lblLucidyC.setText("0");
        panSheltomUsadoC.add(lblLucidyC);
        lblLucidyC.setBounds(23, 20, 30, 14);

        lblImgSereneoC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/sereneo.png"))); // NOI18N
        panSheltomUsadoC.add(lblImgSereneoC);
        lblImgSereneoC.setBounds(35, 15, 22, 22);

        lblSereneoC.setForeground(new java.awt.Color(255, 255, 255));
        lblSereneoC.setText("0");
        panSheltomUsadoC.add(lblSereneoC);
        lblSereneoC.setBounds(58, 20, 30, 14);

        lblImgFadeoC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/fadeo.png"))); // NOI18N
        panSheltomUsadoC.add(lblImgFadeoC);
        lblImgFadeoC.setBounds(70, 15, 22, 22);

        lblFadeoC.setForeground(new java.awt.Color(255, 255, 255));
        lblFadeoC.setText("0");
        panSheltomUsadoC.add(lblFadeoC);
        lblFadeoC.setBounds(93, 20, 30, 14);

        lblImgSparkyC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/sparky.png"))); // NOI18N
        panSheltomUsadoC.add(lblImgSparkyC);
        lblImgSparkyC.setBounds(103, 15, 22, 22);

        lblSparkyC.setForeground(new java.awt.Color(255, 255, 255));
        lblSparkyC.setText("0");
        panSheltomUsadoC.add(lblSparkyC);
        lblSparkyC.setBounds(125, 20, 30, 14);

        lblImgRaidentC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/raident.png"))); // NOI18N
        panSheltomUsadoC.add(lblImgRaidentC);
        lblImgRaidentC.setBounds(135, 15, 22, 22);

        lblRaidentC.setForeground(new java.awt.Color(255, 255, 255));
        lblRaidentC.setText("0");
        panSheltomUsadoC.add(lblRaidentC);
        lblRaidentC.setBounds(157, 20, 30, 14);

        lblImgTransparoC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/transparo.png"))); // NOI18N
        panSheltomUsadoC.add(lblImgTransparoC);
        lblImgTransparoC.setBounds(169, 15, 22, 22);

        lblTransparoC.setForeground(new java.awt.Color(255, 255, 255));
        lblTransparoC.setText("0");
        panSheltomUsadoC.add(lblTransparoC);
        lblTransparoC.setBounds(192, 20, 30, 14);

        lblImgDevineC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/devine.png"))); // NOI18N
        panSheltomUsadoC.add(lblImgDevineC);
        lblImgDevineC.setBounds(240, 15, 22, 22);

        lblImgMirageC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/mirage.png"))); // NOI18N
        panSheltomUsadoC.add(lblImgMirageC);
        lblImgMirageC.setBounds(35, 40, 22, 22);

        lblMirageC.setForeground(new java.awt.Color(255, 255, 255));
        lblMirageC.setText("0");
        panSheltomUsadoC.add(lblMirageC);
        lblMirageC.setBounds(58, 45, 30, 14);

        lblImgInfernaC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/inferna.png"))); // NOI18N
        panSheltomUsadoC.add(lblImgInfernaC);
        lblImgInfernaC.setBounds(70, 40, 22, 22);

        lblInfernaC.setForeground(new java.awt.Color(255, 255, 255));
        lblInfernaC.setText("0");
        panSheltomUsadoC.add(lblInfernaC);
        lblInfernaC.setBounds(93, 45, 30, 14);

        lblImgEnigmaC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/enigma.png"))); // NOI18N
        panSheltomUsadoC.add(lblImgEnigmaC);
        lblImgEnigmaC.setBounds(103, 40, 22, 22);

        lblEnigmaC.setForeground(new java.awt.Color(255, 255, 255));
        lblEnigmaC.setText("0");
        panSheltomUsadoC.add(lblEnigmaC);
        lblEnigmaC.setBounds(125, 45, 30, 14);

        lblImgBellumC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/bellum.png"))); // NOI18N
        panSheltomUsadoC.add(lblImgBellumC);
        lblImgBellumC.setBounds(135, 40, 22, 22);

        lblBellumC.setForeground(new java.awt.Color(255, 255, 255));
        lblBellumC.setText("0");
        panSheltomUsadoC.add(lblBellumC);
        lblBellumC.setBounds(157, 45, 30, 14);

        lblImgMurkyC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/murky.png"))); // NOI18N
        panSheltomUsadoC.add(lblImgMurkyC);
        lblImgMurkyC.setBounds(205, 15, 22, 22);

        lblMurkyC.setForeground(new java.awt.Color(255, 255, 255));
        lblMurkyC.setText("0");
        panSheltomUsadoC.add(lblMurkyC);
        lblMurkyC.setBounds(227, 20, 30, 14);

        lblImgCelestoC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/celesto.png"))); // NOI18N
        panSheltomUsadoC.add(lblImgCelestoC);
        lblImgCelestoC.setBounds(0, 40, 22, 22);

        lblCelestoC.setForeground(new java.awt.Color(255, 255, 255));
        lblCelestoC.setText("0");
        panSheltomUsadoC.add(lblCelestoC);
        lblCelestoC.setBounds(23, 45, 30, 14);

        lblImgOredoC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/oredo.png"))); // NOI18N
        panSheltomUsadoC.add(lblImgOredoC);
        lblImgOredoC.setBounds(169, 40, 22, 22);

        lblOredoC.setForeground(new java.awt.Color(255, 255, 255));
        lblOredoC.setText("0");
        panSheltomUsadoC.add(lblOredoC);
        lblOredoC.setBounds(192, 45, 30, 14);

        lblImgSapphireC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/sapphire.png"))); // NOI18N
        panSheltomUsadoC.add(lblImgSapphireC);
        lblImgSapphireC.setBounds(205, 40, 22, 22);

        lblSapphireC.setForeground(new java.awt.Color(255, 255, 255));
        lblSapphireC.setText("0");
        panSheltomUsadoC.add(lblSapphireC);
        lblSapphireC.setBounds(227, 45, 30, 14);

        lblImgSolC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/item/sheltom/sol.png"))); // NOI18N
        panSheltomUsadoC.add(lblImgSolC);
        lblImgSolC.setBounds(240, 40, 22, 22);

        lblSolC.setForeground(new java.awt.Color(255, 255, 255));
        lblSolC.setText("0");
        panSheltomUsadoC.add(lblSolC);
        lblSolC.setBounds(265, 45, 30, 14);

        lblDevineC.setForeground(new java.awt.Color(255, 255, 255));
        lblDevineC.setText("0");
        panSheltomUsadoC.add(lblDevineC);
        lblDevineC.setBounds(265, 20, 30, 14);

        lblTotalSheltomC.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalSheltomC.setText("0");
        panSheltomUsadoC.add(lblTotalSheltomC);
        lblTotalSheltomC.setBounds(225, 0, 50, 14);

        panCompareItem.add(panSheltomUsadoC);
        panSheltomUsadoC.setBounds(10, 400, 290, 70);

        itemSelect.add(panCompareItem);
        panCompareItem.setBounds(490, 0, 295, 465);

        cmbAgingLevel.setMaximumRowCount(25);
        cmbAgingLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+0", "+1", "+2", "+3", "+4", "+5", "+6", "+7", "+8", "+9", "+10", "+11", "+12", "+13", "+14", "+15", "+16", "+17", "+18", "+19", "+20", "+21", "+22", "+23", "+24" }));
        cmbAgingLevel.setEnabled(false);
        cmbAgingLevel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmbAgingLevelActionPerformed(evt);
            }
        });
        itemSelect.add(cmbAgingLevel);
        cmbAgingLevel.setBounds(220, 490, 50, 22);

        cmbMix.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        cmbMix.setMaximumRowCount(50);
        cmbMix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No mix" }));
        cmbMix.setEnabled(false);
        cmbMix.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmbMixActionPerformed(evt);
            }
        });
        itemSelect.add(cmbMix);
        cmbMix.setBounds(175, 470, 300, 19);

        lblAging.setForeground(new java.awt.Color(255, 255, 255));
        lblAging.setText("Aging:");
        itemSelect.add(lblAging);
        lblAging.setBounds(175, 490, 50, 14);

        btnEquip.setText("Equip");
        btnEquip.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnEquipActionPerformed(evt);
            }
        });
        itemSelect.add(btnEquip);
        btnEquip.setBounds(3, 470, 170, 35);

        cmbSpec.setMaximumRowCount(11);
        cmbSpec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Spec" }));
        cmbSpec.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmbSpecActionPerformed(evt);
            }
        });
        itemSelect.add(cmbSpec);
        cmbSpec.setBounds(381, 490, 94, 22);

        lblClassSpec.setForeground(new java.awt.Color(255, 255, 255));
        lblClassSpec.setText("Class Spec:");
        itemSelect.add(lblClassSpec);
        lblClassSpec.setBounds(320, 490, 100, 14);

        lblAgingC.setForeground(new java.awt.Color(255, 255, 255));
        lblAgingC.setText("Aging:");
        itemSelect.add(lblAgingC);
        lblAgingC.setBounds(490, 490, 50, 14);

        lblClassSpecC.setForeground(new java.awt.Color(255, 255, 255));
        lblClassSpecC.setText("Class Spec:");
        itemSelect.add(lblClassSpecC);
        lblClassSpecC.setBounds(636, 490, 100, 14);

        cmbAgingLevelC.setMaximumRowCount(25);
        cmbAgingLevelC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+0", "+1", "+2", "+3", "+4", "+5", "+6", "+7", "+8", "+9", "+10", "+11", "+12", "+13", "+14", "+15", "+16", "+17", "+18", "+19", "+20", "+21", "+22", "+23", "+24" }));
        cmbAgingLevelC.setEnabled(false);
        cmbAgingLevelC.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmbAgingLevelCActionPerformed(evt);
            }
        });
        itemSelect.add(cmbAgingLevelC);
        cmbAgingLevelC.setBounds(540, 490, 50, 22);

        cmbSpecC.setMaximumRowCount(11);
        cmbSpecC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Spec" }));
        cmbSpecC.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmbSpecCActionPerformed(evt);
            }
        });
        itemSelect.add(cmbSpecC);
        cmbSpecC.setBounds(696, 490, 89, 22);

        cmbMixC.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        cmbMixC.setMaximumRowCount(50);
        cmbMixC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No mix" }));
        cmbMixC.setEnabled(false);
        cmbMixC.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmbMixCActionPerformed(evt);
            }
        });
        itemSelect.add(cmbMixC);
        cmbMixC.setBounds(490, 470, 295, 19);

        btnCleanItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/btnCleanItem.png"))); // NOI18N
        btnCleanItem.setToolTipText("<html><font color='blue'>Removes the Aging or Mix on the <br>\nselected Item.");
        btnCleanItem.setBorder(null);
        btnCleanItem.setBorderPainted(false);
        btnCleanItem.setContentAreaFilled(false);
        btnCleanItem.setFocusPainted(false);
        btnCleanItem.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/btnCleanItem.png"))); // NOI18N
        btnCleanItem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/btnCleanItemH.png"))); // NOI18N
        btnCleanItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCleanItemActionPerformed(evt);
            }
        });
        itemSelect.add(btnCleanItem);
        btnCleanItem.setBounds(280, 485, 27, 27);

        btnCleanItemC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/btnCleanItem.png"))); // NOI18N
        btnCleanItemC.setToolTipText("<html><font color='blue'>Removes the Aging or Mix on the <br>\ncomparing Item.");
        btnCleanItemC.setBorder(null);
        btnCleanItemC.setBorderPainted(false);
        btnCleanItemC.setContentAreaFilled(false);
        btnCleanItemC.setFocusPainted(false);
        btnCleanItemC.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/btnCleanItem.png"))); // NOI18N
        btnCleanItemC.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/btnCleanItemH.png"))); // NOI18N
        btnCleanItemC.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCleanItemCActionPerformed(evt);
            }
        });
        itemSelect.add(btnCleanItemC);
        btnCleanItemC.setBounds(600, 485, 27, 27);

        lblArrowCompare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/gearselect/compareArrow.png"))); // NOI18N
        itemSelect.add(lblArrowCompare);
        lblArrowCompare.setBounds(476, 135, 13, 11);

        panGearSelect.add(itemSelect);
        itemSelect.setBounds(5, 42, 800, 520);

        gearSection.add(rbtAcessory);
        rbtAcessory.setForeground(new java.awt.Color(255, 255, 255));
        rbtAcessory.setText("Acessory");
        rbtAcessory.setOpaque(false);
        rbtAcessory.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbtAcessoryActionPerformed(evt);
            }
        });
        panGearSelect.add(rbtAcessory);
        rbtAcessory.setBounds(150, 5, 100, 15);

        gearSection.add(rbtDefense);
        rbtDefense.setForeground(new java.awt.Color(255, 255, 255));
        rbtDefense.setText("Defense");
        rbtDefense.setOpaque(false);
        rbtDefense.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbtDefenseActionPerformed(evt);
            }
        });
        panGearSelect.add(rbtDefense);
        rbtDefense.setBounds(80, 5, 100, 15);

        gearSection.add(rbtWeapon);
        rbtWeapon.setForeground(new java.awt.Color(255, 255, 255));
        rbtWeapon.setSelected(true);
        rbtWeapon.setText("Weapon");
        rbtWeapon.setOpaque(false);
        rbtWeapon.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbtWeaponActionPerformed(evt);
            }
        });
        panGearSelect.add(rbtWeapon);
        rbtWeapon.setBounds(10, 5, 100, 15);

        gearType.add(rbtType10);
        rbtType10.setForeground(new java.awt.Color(255, 255, 255));
        rbtType10.setText("Phantom");
        rbtType10.setOpaque(false);
        rbtType10.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbtType10ActionPerformed(evt);
            }
        });
        panGearSelect.add(rbtType10);
        rbtType10.setBounds(640, 25, 110, 15);

        gearType.add(rbtType9);
        rbtType9.setForeground(new java.awt.Color(255, 255, 255));
        rbtType9.setText("Wand");
        rbtType9.setOpaque(false);
        rbtType9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbtType9ActionPerformed(evt);
            }
        });
        panGearSelect.add(rbtType9);
        rbtType9.setBounds(570, 25, 100, 15);

        gearType.add(rbtType8);
        rbtType8.setForeground(new java.awt.Color(255, 255, 255));
        rbtType8.setText("Javelin");
        rbtType8.setOpaque(false);
        rbtType8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbtType8ActionPerformed(evt);
            }
        });
        panGearSelect.add(rbtType8);
        rbtType8.setBounds(500, 25, 100, 15);

        gearType.add(rbtType7);
        rbtType7.setForeground(new java.awt.Color(255, 255, 255));
        rbtType7.setText("Bow");
        rbtType7.setOpaque(false);
        rbtType7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbtType7ActionPerformed(evt);
            }
        });
        panGearSelect.add(rbtType7);
        rbtType7.setBounds(430, 25, 100, 15);

        gearType.add(rbtType6);
        rbtType6.setForeground(new java.awt.Color(255, 255, 255));
        rbtType6.setText("Dagger");
        rbtType6.setOpaque(false);
        rbtType6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbtType6ActionPerformed(evt);
            }
        });
        panGearSelect.add(rbtType6);
        rbtType6.setBounds(360, 25, 100, 15);

        gearType.add(rbtType5);
        rbtType5.setForeground(new java.awt.Color(255, 255, 255));
        rbtType5.setText("Scythe");
        rbtType5.setOpaque(false);
        rbtType5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbtType5ActionPerformed(evt);
            }
        });
        panGearSelect.add(rbtType5);
        rbtType5.setBounds(290, 25, 100, 15);

        gearType.add(rbtType4);
        rbtType4.setForeground(new java.awt.Color(255, 255, 255));
        rbtType4.setText("Claw");
        rbtType4.setOpaque(false);
        rbtType4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbtType4ActionPerformed(evt);
            }
        });
        panGearSelect.add(rbtType4);
        rbtType4.setBounds(220, 25, 100, 15);

        gearType.add(rbtType3);
        rbtType3.setForeground(new java.awt.Color(255, 255, 255));
        rbtType3.setText("Hammer");
        rbtType3.setOpaque(false);
        rbtType3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbtType3ActionPerformed(evt);
            }
        });
        panGearSelect.add(rbtType3);
        rbtType3.setBounds(150, 25, 100, 15);

        gearType.add(rbtType2);
        rbtType2.setForeground(new java.awt.Color(255, 255, 255));
        rbtType2.setText("Axe");
        rbtType2.setOpaque(false);
        rbtType2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbtType2ActionPerformed(evt);
            }
        });
        panGearSelect.add(rbtType2);
        rbtType2.setBounds(80, 25, 100, 15);

        gearType.add(rbtType1);
        rbtType1.setForeground(new java.awt.Color(255, 255, 255));
        rbtType1.setSelected(true);
        rbtType1.setText("Sword");
        rbtType1.setOpaque(false);
        rbtType1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rbtType1ActionPerformed(evt);
            }
        });
        panGearSelect.add(rbtType1);
        rbtType1.setBounds(10, 25, 100, 15);
        panGearSelect.add(jSeparator1);
        jSeparator1.setBounds(10, 22, 700, 2);

        lblMsg.setForeground(new java.awt.Color(255, 255, 255));
        lblMsg.setText("To select an item to equip, left click on any item name on the list. Right click to compare.");
        panGearSelect.add(lblMsg);
        lblMsg.setBounds(270, 5, 470, 14);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/buttons/btnXClose.png"))); // NOI18N
        btnCancel.setBorder(null);
        btnCancel.setBorderPainted(false);
        btnCancel.setContentAreaFilled(false);
        btnCancel.setFocusPainted(false);
        btnCancel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/buttons/btnXClose.png"))); // NOI18N
        btnCancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/buttons/HbtnXClose.png"))); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCancelActionPerformed(evt);
            }
        });
        panGearSelect.add(btnCancel);
        btnCancel.setBounds(760, 10, 26, 26);

        lblBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/gearselect/frameGearSelecWindow.png"))); // NOI18N
        panGearSelect.add(lblBackGround);
        lblBackGround.setBounds(0, 0, 800, 560);

        getContentPane().add(panGearSelect);
        panGearSelect.setBounds(0, 0, 800, 560);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public TextureWork getTextureWork() {
        return textureWork;
    }

    public JLabel getLblGearImage() {
        return lblGearImage;
    }

    public void setLblGearImage(JLabel lblGearImage) {
        this.lblGearImage = lblGearImage;
    }

    public boolean isAllowEquip() {
        return allowEquip;
    }

    public void setAllowEquip(boolean allowEquip) {
        this.allowEquip = allowEquip;
    }

    public CharacterStats getCharacter() {
        return character;
    }

    public void setCharacter(CharacterStats character) {
        this.character = character;
    }

    public ButtonGroup getGearType() {
        return gearType;
    }

    public void setGearType(ButtonGroup gearType) {
        this.gearType = gearType;
    }

    public void setFlags(String callType, CharacterStats c, ChooseGear animGear, String slotToEquip, JButton btnSlotToEquip, JLabel lblCover) {
        
        this.character = c;
        this.animGear = animGear;
        this.slotToEquip = slotToEquip;
        this.btnSlotToEquip = btnSlotToEquip;
        this.lblCover = lblCover;
        this.callType = callType;
        //this.selectingItem = null;
        definirBotoes();
    }

    public void setFlagsView(String callType, ChooseGear animGear) {
        this.callType = callType;
        this.animGear = animGear;
        this.lblMsg.setText("Select an item with Left click. To compare, use Right click.");
        this.btnEquip.setVisible(false);
        this.readOnly = true;
        definirBotoes();
    }

    public void definirBotoes() {
        definirBotoesCategoria();

        switch (callType) {
            case "all":
                break;
            case "1h":
                switch (character.getClasse()) {
                    case "Magician":
                    case "Priestess":
                        rbtType1.setEnabled(false);
                        rbtType2.setEnabled(false);
                        rbtType3.setEnabled(false);
                        rbtType4.setEnabled(false);
                        rbtType5.setEnabled(false);
                        rbtType6.setEnabled(false);
                        rbtType7.setEnabled(false);
                        rbtType8.setEnabled(false);
                        rbtType9.setEnabled(true);
                        rbtType10.setEnabled(false);
                        break;
                    case "Shaman":
                        rbtType1.setEnabled(false);
                        rbtType2.setEnabled(false);
                        rbtType3.setEnabled(false);
                        rbtType4.setEnabled(false);
                        rbtType5.setEnabled(false);
                        rbtType6.setEnabled(false);
                        rbtType7.setEnabled(false);
                        rbtType8.setEnabled(false);
                        rbtType9.setEnabled(false);
                        rbtType10.setEnabled(true);
                        break;
                    default:
                        rbtType1.setEnabled(true);
                        rbtType2.setEnabled(true);
                        rbtType3.setEnabled(true);
                        rbtType4.setEnabled(true);
                        rbtType5.setEnabled(true);
                        rbtType6.setEnabled(true);
                        rbtType7.setEnabled(true);
                        rbtType8.setEnabled(true);
                        rbtType9.setEnabled(false);
                        rbtType10.setEnabled(false);
                        break;
                }
                break;
            case "2h":
                if (character.getClasse().equals("Magician") || character.getClasse().equals("Priestess")) {
                    rbtType1.setEnabled(false);
                    rbtType2.setEnabled(false);
                    rbtType3.setEnabled(false);
                    rbtType4.setEnabled(false);
                    rbtType5.setEnabled(false);
                    rbtType6.setEnabled(false);
                    rbtType7.setEnabled(false);
                    rbtType8.setEnabled(false);
                    rbtType9.setEnabled(true);
                    rbtType10.setEnabled(false);
                } else if (character.getClasse().equals("Shaman")) {
                    rbtType1.setEnabled(false);
                    rbtType2.setEnabled(false);
                    rbtType3.setEnabled(false);
                    rbtType4.setEnabled(false);
                    rbtType5.setEnabled(false);
                    rbtType6.setEnabled(false);
                    rbtType7.setEnabled(false);
                    rbtType8.setEnabled(false);
                    rbtType9.setEnabled(false);
                    rbtType10.setEnabled(false);
                } else if (character.getClasse().equals("Assassin")) {
                    rbtType1.setEnabled(false);
                    rbtType2.setEnabled(false);
                    rbtType3.setEnabled(false);
                    rbtType4.setEnabled(false);
                    rbtType5.setEnabled(false);
                    rbtType6.setEnabled(true);
                    rbtType7.setEnabled(false);
                    rbtType8.setEnabled(false);
                    rbtType9.setEnabled(false);
                    rbtType10.setEnabled(false);
                } else {
                    rbtType1.setEnabled(true);
                    rbtType2.setEnabled(true);
                    rbtType3.setEnabled(true);
                    rbtType4.setEnabled(false);
                    rbtType5.setEnabled(true);
                    rbtType6.setEnabled(false);
                    rbtType7.setEnabled(true);
                    rbtType8.setEnabled(false);
                    rbtType9.setEnabled(false);
                    rbtType10.setEnabled(false);
                }
                break;
            case "armor":
                if (character.getClasse().equals("Magician") || character.getClasse().equals("Priestess") || character.getClasse().equals("Shaman")) {
                    rbtType1.setEnabled(false);
                    rbtType2.setEnabled(true);
                    rbtType3.setEnabled(false);
                    rbtType4.setEnabled(false);
                    rbtType5.setEnabled(false);
                    rbtType6.setEnabled(false);
                    rbtType7.setEnabled(false);
                    rbtType8.setEnabled(false);
                    rbtType9.setEnabled(false);
                    rbtType10.setEnabled(false);
                } else {
                    rbtType1.setEnabled(true);
                    rbtType2.setEnabled(false);
                    rbtType3.setEnabled(false);
                    rbtType4.setEnabled(false);
                    rbtType5.setEnabled(false);
                    rbtType6.setEnabled(false);
                    rbtType7.setEnabled(false);
                    rbtType8.setEnabled(false);
                    rbtType9.setEnabled(false);
                    rbtType10.setEnabled(false);
                }
                break;
            case "shield":
                if (character.getClasse().equals("Magician") || character.getClasse().equals("Priestess") || character.getClasse().equals("Shaman")) {
                    rbtType1.setEnabled(false);
                    rbtType2.setEnabled(false);
                    rbtType3.setEnabled(true);
                    rbtType4.setEnabled(true);
                    rbtType5.setEnabled(false);
                    rbtType6.setEnabled(false);
                    rbtType7.setEnabled(false);
                    rbtType8.setEnabled(false);
                    rbtType9.setEnabled(false);
                    rbtType10.setEnabled(false);
                } else {
                    rbtType1.setEnabled(false);
                    rbtType2.setEnabled(false);
                    rbtType3.setEnabled(true);
                    rbtType4.setEnabled(false);
                    rbtType5.setEnabled(false);
                    rbtType6.setEnabled(false);
                    rbtType7.setEnabled(false);
                    rbtType8.setEnabled(false);
                    rbtType9.setEnabled(false);
                    rbtType10.setEnabled(false);
                }
                break;
            case "boots":
                rbtType1.setEnabled(false);
                rbtType2.setEnabled(false);
                rbtType3.setEnabled(false);
                rbtType4.setEnabled(false);
                rbtType5.setEnabled(false);
                rbtType6.setEnabled(false);
                rbtType7.setEnabled(true);
                rbtType8.setEnabled(false);
                rbtType9.setEnabled(false);
                rbtType10.setEnabled(false);
                break;
            case "gauntlet":
                rbtType1.setEnabled(false);
                rbtType2.setEnabled(false);
                rbtType3.setEnabled(false);
                rbtType4.setEnabled(false);
                rbtType5.setEnabled(false);
                rbtType6.setEnabled(true);
                rbtType7.setEnabled(false);
                rbtType8.setEnabled(false);
                rbtType9.setEnabled(false);
                rbtType10.setEnabled(false);
                break;
            case "bracelet":
                rbtType1.setEnabled(false);
                rbtType2.setEnabled(false);
                rbtType3.setEnabled(false);
                rbtType4.setEnabled(false);
                rbtType5.setEnabled(true);
                rbtType6.setEnabled(false);
                rbtType7.setEnabled(false);
                rbtType8.setEnabled(false);
                rbtType9.setEnabled(false);
                rbtType10.setEnabled(false);
                break;
            case "necklace":
                rbtType1.setEnabled(true);
                rbtType2.setEnabled(false);
                rbtType3.setEnabled(false);
                rbtType4.setEnabled(false);
                rbtType5.setEnabled(false);
                rbtType6.setEnabled(false);
                rbtType7.setEnabled(false);
                rbtType8.setEnabled(false);
                rbtType9.setEnabled(false);
                rbtType10.setEnabled(false);
                break;
            case "ring":
                rbtType1.setEnabled(false);
                rbtType2.setEnabled(true);
                rbtType3.setEnabled(false);
                rbtType4.setEnabled(false);
                rbtType5.setEnabled(false);
                rbtType6.setEnabled(false);
                rbtType7.setEnabled(false);
                rbtType8.setEnabled(false);
                rbtType9.setEnabled(false);
                rbtType10.setEnabled(false);
                break;
            case "sheltom":
                rbtType1.setEnabled(false);
                rbtType2.setEnabled(false);
                rbtType3.setEnabled(true);
                rbtType4.setEnabled(false);
                rbtType5.setEnabled(false);
                rbtType6.setEnabled(false);
                rbtType7.setEnabled(false);
                rbtType8.setEnabled(false);
                rbtType9.setEnabled(false);
                rbtType10.setEnabled(false);
                break;

        }

        if (readOnly) {
            if (firstView) {
                definirListaInicial();
                firstView = false;
            }
        } else {
            definirListaInicial();
        }

    }

    private void definirListaInicial() {
        String callTypeModifier = callType;

        switch (callType) {
            case "1h":
            case "2h":
                switch (character.getClasse()) {
                    case "Knight":
                        rbtType1.setSelected(true);
                        callTypeModifier = callType + ",sword";
                        break;
                    case "Fighter":
                        rbtType2.setSelected(true);
                        callTypeModifier = callType + ",axe";
                        break;
                    case "Mechanician":
                        if ("1h".equals(callType)) {
                            rbtType4.setSelected(true);
                            callTypeModifier = callType + ",claw";
                        } else if ("2h".equals(callType)) {
                            rbtType3.setSelected(true);
                            callTypeModifier = callType + ",hammer";
                        }
                        break;
                    case "Pikeman":
                        rbtType5.setSelected(true);
                        callTypeModifier = callType + ",scythe";
                        break;
                    case "Assassin":
                        rbtType6.setSelected(true);
                        callTypeModifier = "1h,dagger";
                        break;
                    case "Archer":
                        rbtType7.setSelected(true);
                        callTypeModifier = callType + ",bow";
                        break;
                    case "Atalanta":
                        if ("1h".equals(callType)) {
                            rbtType8.setSelected(true);
                            callTypeModifier = callType + ",javelin";
                        } else if ("2h".equals(callType)) {
                            rbtType5.setSelected(true);
                            callTypeModifier = callType + ",scythe";
                        }
                        break;
                    case "Priestess":
                    case "Magician":
                        rbtType9.setSelected(true);
                        callTypeModifier = callType + ",wand";
                        break;
                    case "Shaman":
                        rbtType10.setSelected(true);
                        callTypeModifier = callType + ",phantom";
                        break;
                }
                break;
            case "armor":
                if (character.getClasse().equals("Magician") || character.getClasse().equals("Priestess") || character.getClasse().equals("Shaman")) {
                    rbtType2.setSelected(true);
                    callTypeModifier = "robe";
                } else {
                    rbtType1.setSelected(true);
                }
                break;
            case "shield":
                if (character.getClasse().equals("Magician") || character.getClasse().equals("Priestess") || character.getClasse().equals("Shaman")) {
                    rbtType4.setSelected(true);
                    callTypeModifier = "orb";
                } else {
                    rbtType3.setSelected(true);
                }
                break;
            case "bracelet":
                rbtType5.setSelected(true);
                break;
            case "gauntlet":
                rbtType6.setSelected(true);
                break;
            case "boots":
                rbtType7.setSelected(true);
                break;
            case "necklace":
                rbtType1.setSelected(true);
                break;
            case "ring":
                rbtType2.setSelected(true);
                break;
            case "sheltom":
                rbtType3.setSelected(true);
                break;
            case "all":
                rbtType1.setSelected(true);
                callTypeModifier = callType + ",sword";
                break;

        }

        jlistItem.setModel(itemList.gerarLista(callTypeModifier));
        atualizarListaMix(cmbMix);
        atualizarListaMix(cmbMixC);

        lblGearDesc.setText("");
    }

    private void definirBotoesCategoria() {
        switch (callType) {
            case "all":
                break;
            case "armor":
            case "shield":
            case "robe":
            case "orb":
            case "boots":
            case "gauntlet":
            case "bracelet":
                rbtWeapon.setEnabled(false);
                rbtWeapon.setVisible(false);
                rbtDefense.setEnabled(false);
                rbtDefense.setVisible(true);
                rbtAcessory.setEnabled(false);
                rbtAcessory.setVisible(false);
                rbtDefense.setSelected(true);
                rbtType1.setText("Armor");
                rbtType2.setText("Robe");
                rbtType3.setText("Shield");
                rbtType4.setText("Orb");
                rbtType4.setVisible(true);
                rbtType5.setText("Bracelet");
                rbtType5.setVisible(true);
                rbtType6.setText("Gauntlet");
                rbtType6.setVisible(true);
                rbtType7.setText("Boots");
                rbtType7.setVisible(true);
                rbtType8.setVisible(false);
                rbtType9.setVisible(false);
                rbtType10.setVisible(false);
                break;
            case "sheltom":
            case "ring":
            case "necklace":
                rbtWeapon.setEnabled(false);
                rbtWeapon.setVisible(false);
                rbtDefense.setEnabled(false);
                rbtDefense.setVisible(false);
                rbtAcessory.setEnabled(false);
                rbtAcessory.setVisible(true);
                rbtAcessory.setSelected(true);
                rbtType1.setText("Amulet");
                rbtType2.setText("Ring");
                rbtType3.setText("Sheltom");
                rbtType4.setVisible(false);
                rbtType5.setVisible(false);
                rbtType6.setVisible(false);
                rbtType7.setVisible(false);
                rbtType8.setVisible(false);
                rbtType9.setVisible(false);
                rbtType10.setVisible(false);
                break;
            default:
                rbtWeapon.setEnabled(false);
                rbtWeapon.setVisible(true);
                rbtDefense.setEnabled(false);
                rbtDefense.setVisible(false);
                rbtAcessory.setEnabled(false);
                rbtAcessory.setVisible(false);
                rbtWeapon.setSelected(true);
                rbtType1.setText("Sword");
                rbtType2.setText("Axe");
                rbtType3.setText("Hammer");
                rbtType4.setText("Claw");
                rbtType4.setVisible(true);
                rbtType5.setText("Scythe");
                rbtType5.setVisible(true);
                rbtType6.setText("Dagger");
                rbtType6.setVisible(true);
                rbtType7.setText("Bow");
                rbtType7.setVisible(true);
                rbtType8.setText("Javelin");
                rbtType8.setVisible(true);
                rbtType9.setText("Wand");
                rbtType9.setVisible(true);
                rbtType10.setText("Phantom");
                rbtType10.setVisible(true);
                break;

        }

    }

    private void definirBotoesCategoriaOnClickTipo(String tipo) {
        switch (tipo) {
            case "defense":
                rbtType1.setText("Armor");
                rbtType1.setSelected(true);
                rbtType2.setText("Robe");
                rbtType3.setText("Shield");
                rbtType4.setText("Orb");
                rbtType4.setVisible(true);
                rbtType5.setText("Bracelet");
                rbtType5.setVisible(true);
                rbtType6.setText("Gauntlet");
                rbtType6.setVisible(true);
                rbtType7.setText("Boots");
                rbtType7.setVisible(true);
                rbtType8.setVisible(false);
                rbtType9.setVisible(false);
                rbtType10.setVisible(false);
                break;
            case "acessory":
                rbtType1.setText("Amulet");
                rbtType1.setSelected(true);
                rbtType2.setText("Ring");
                rbtType3.setText("Sheltom");
                rbtType4.setVisible(false);
                rbtType5.setVisible(false);
                rbtType6.setVisible(false);
                rbtType7.setVisible(false);
                rbtType8.setVisible(false);
                rbtType9.setVisible(false);
                rbtType10.setVisible(false);
                break;
            default:
                rbtType1.setText("Sword");
                rbtType1.setSelected(true);
                rbtType2.setText("Axe");
                rbtType3.setText("Hammer");
                rbtType4.setText("Claw");
                rbtType4.setVisible(true);
                rbtType5.setText("Scythe");
                rbtType5.setVisible(true);
                rbtType6.setText("Dagger");
                rbtType6.setVisible(true);
                rbtType7.setText("Bow");
                rbtType7.setVisible(true);
                rbtType8.setText("Javelin");
                rbtType8.setVisible(true);
                rbtType9.setText("Wand");
                rbtType9.setVisible(true);
                rbtType10.setText("Phantom");
                rbtType10.setVisible(true);
                break;
        }
    }

    private void btnEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipActionPerformed
        checkReqStats(true);
    }//GEN-LAST:event_btnEquipActionPerformed

    private void rbtAcessoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtAcessoryActionPerformed
        exibirAcessories();
    }//GEN-LAST:event_rbtAcessoryActionPerformed

    private void rbtWeaponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtWeaponActionPerformed
        exibirWeapons();
    }//GEN-LAST:event_rbtWeaponActionPerformed

    private void rbtDefenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtDefenseActionPerformed
        exibirDefenses();
    }//GEN-LAST:event_rbtDefenseActionPerformed

    private void rbtType10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtType10ActionPerformed
        atualizarLista();
    }//GEN-LAST:event_rbtType10ActionPerformed

    private void rbtType1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtType1ActionPerformed
        atualizarLista();
    }//GEN-LAST:event_rbtType1ActionPerformed

    private void rbtType2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtType2ActionPerformed
        atualizarLista();
    }//GEN-LAST:event_rbtType2ActionPerformed

    private void rbtType3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtType3ActionPerformed
        atualizarLista();
    }//GEN-LAST:event_rbtType3ActionPerformed

    private void rbtType4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtType4ActionPerformed
        atualizarLista();
    }//GEN-LAST:event_rbtType4ActionPerformed

    private void rbtType5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtType5ActionPerformed
        atualizarLista();
    }//GEN-LAST:event_rbtType5ActionPerformed

    private void rbtType6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtType6ActionPerformed
        atualizarLista();
    }//GEN-LAST:event_rbtType6ActionPerformed

    private void rbtType7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtType7ActionPerformed
        atualizarLista();
    }//GEN-LAST:event_rbtType7ActionPerformed

    private void rbtType8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtType8ActionPerformed
        atualizarLista();
    }//GEN-LAST:event_rbtType8ActionPerformed

    private void rbtType9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtType9ActionPerformed
        atualizarLista();
    }//GEN-LAST:event_rbtType9ActionPerformed

    private void cmbAgingLevelCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAgingLevelCActionPerformed
        adicionarAging(cmbAgingLevelC, COMPARINGITEM);
    }//GEN-LAST:event_cmbAgingLevelCActionPerformed

    private void cmbSpecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSpecActionPerformed
        selectingItem.setSelectedSpec(String.valueOf(cmbSpec.getSelectedItem()));

        lblGearDesc.setText(selectingItem.getItemViewDesc());
    }//GEN-LAST:event_cmbSpecActionPerformed

    private void cmbSpecCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSpecCActionPerformed
        comparingItem.setSelectedSpec(String.valueOf(cmbSpecC.getSelectedItem()));

        lblGearDescC.setText(comparingItem.getItemViewDesc());
    }//GEN-LAST:event_cmbSpecCActionPerformed

    private void cmbMixCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMixCActionPerformed
        adicionarMix(cmbMixC, COMPARINGITEM);
    }//GEN-LAST:event_cmbMixCActionPerformed

    private void btnCleanItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanItemActionPerformed
        limparMixAgeItem(EQUIPANDO);
    }//GEN-LAST:event_btnCleanItemActionPerformed

    private void btnCleanItemCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanItemCActionPerformed
        limparMixAgeItem(COMPARANDO);
    }//GEN-LAST:event_btnCleanItemCActionPerformed

    private void cmbAgingLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAgingLevelActionPerformed
        adicionarAging(cmbAgingLevel, SELECTINGITEM);
    }//GEN-LAST:event_cmbAgingLevelActionPerformed

    private void cmbMixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMixActionPerformed
        adicionarMix(cmbMix, SELECTINGITEM);
    }//GEN-LAST:event_cmbMixActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        allowEquip = false;
        animGear.open(this.getPanelGear(), CLOSE, this);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void jlistItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlistItemMouseClicked
        if(jlistItem.getSelectedIndex()>-1){
            gsControl.setSelectedItem(this, evt);
        }
    }//GEN-LAST:event_jlistItemMouseClicked

    private void jlistItemValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlistItemValueChanged
        if(jlistItem.getSelectedIndex()>-1){
           gsControl.selectItem(this); 
        }
    }//GEN-LAST:event_jlistItemValueChanged

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
            java.util.logging.Logger.getLogger(JdiGearSelector.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdiGearSelector.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdiGearSelector.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdiGearSelector.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdiGearSelector dialog = new JdiGearSelector(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCleanItem;
    private javax.swing.JButton btnCleanItemC;
    private javax.swing.JButton btnEquip;
    private javax.swing.JComboBox<String> cmbAgingLevel;
    private javax.swing.JComboBox<String> cmbAgingLevelC;
    private javax.swing.JComboBox<String> cmbMix;
    private javax.swing.JComboBox<String> cmbMixC;
    private javax.swing.JComboBox<String> cmbSpec;
    private javax.swing.JComboBox<String> cmbSpecC;
    private javax.swing.ButtonGroup gearSection;
    private javax.swing.ButtonGroup gearType;
    private javax.swing.JPanel itemSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2C;
    private javax.swing.JScrollPane jScrollPaneListaItem;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> jlistItem;
    private javax.swing.JLabel lblAging;
    private javax.swing.JLabel lblAgingC;
    private javax.swing.JLabel lblArrowCompare;
    private javax.swing.JLabel lblBackGround;
    private javax.swing.JLabel lblBellum;
    private javax.swing.JLabel lblBellumC;
    private javax.swing.JLabel lblCelesto;
    private javax.swing.JLabel lblCelestoC;
    private javax.swing.JLabel lblClassSpec;
    private javax.swing.JLabel lblClassSpecC;
    private javax.swing.JLabel lblDevine;
    private javax.swing.JLabel lblDevineC;
    private javax.swing.JLabel lblEnigma;
    private javax.swing.JLabel lblEnigmaC;
    private javax.swing.JLabel lblFadeo;
    private javax.swing.JLabel lblFadeoC;
    private javax.swing.JLabel lblGearDesc;
    private javax.swing.JLabel lblGearDescC;
    private javax.swing.JLabel lblGearDescFrame;
    private javax.swing.JLabel lblGearDescFrameC;
    private javax.swing.JLabel lblGearImage;
    private javax.swing.JLabel lblGearImageBG;
    private javax.swing.JLabel lblGearImageBGC;
    private javax.swing.JLabel lblGearImageC;
    private javax.swing.JLabel lblImgBellum;
    private javax.swing.JLabel lblImgBellumC;
    private javax.swing.JLabel lblImgCelesto;
    private javax.swing.JLabel lblImgCelestoC;
    private javax.swing.JLabel lblImgDevine;
    private javax.swing.JLabel lblImgDevineC;
    private javax.swing.JLabel lblImgEnigma;
    private javax.swing.JLabel lblImgEnigmaC;
    private javax.swing.JLabel lblImgFadeo;
    private javax.swing.JLabel lblImgFadeoC;
    private javax.swing.JLabel lblImgInferna;
    private javax.swing.JLabel lblImgInfernaC;
    private javax.swing.JLabel lblImgLucidy;
    private javax.swing.JLabel lblImgLucidyC;
    private javax.swing.JLabel lblImgMirage;
    private javax.swing.JLabel lblImgMirageC;
    private javax.swing.JLabel lblImgMurky;
    private javax.swing.JLabel lblImgMurkyC;
    private javax.swing.JLabel lblImgOredo;
    private javax.swing.JLabel lblImgOredoC;
    private javax.swing.JLabel lblImgRaident;
    private javax.swing.JLabel lblImgRaidentC;
    private javax.swing.JLabel lblImgSapphire;
    private javax.swing.JLabel lblImgSapphireC;
    private javax.swing.JLabel lblImgSereneo;
    private javax.swing.JLabel lblImgSereneoC;
    private javax.swing.JLabel lblImgSol;
    private javax.swing.JLabel lblImgSolC;
    private javax.swing.JLabel lblImgSparky;
    private javax.swing.JLabel lblImgSparkyC;
    private javax.swing.JLabel lblImgTransparo;
    private javax.swing.JLabel lblImgTransparoC;
    private javax.swing.JLabel lblInferna;
    private javax.swing.JLabel lblInfernaC;
    private javax.swing.JLabel lblLucidy;
    private javax.swing.JLabel lblLucidyC;
    private javax.swing.JLabel lblMirage;
    private javax.swing.JLabel lblMirageC;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblMurky;
    private javax.swing.JLabel lblMurkyC;
    private javax.swing.JLabel lblOredo;
    private javax.swing.JLabel lblOredoC;
    private javax.swing.JLabel lblRaident;
    private javax.swing.JLabel lblRaidentC;
    private javax.swing.JLabel lblSapphire;
    private javax.swing.JLabel lblSapphireC;
    private javax.swing.JLabel lblSereneo;
    private javax.swing.JLabel lblSereneoC;
    private javax.swing.JLabel lblSol;
    private javax.swing.JLabel lblSolC;
    private javax.swing.JLabel lblSparky;
    private javax.swing.JLabel lblSparkyC;
    private javax.swing.JLabel lblTotalSheltom;
    private javax.swing.JLabel lblTotalSheltomC;
    private javax.swing.JLabel lblTransparo;
    private javax.swing.JLabel lblTransparoC;
    private javax.swing.JPanel panCompareItem;
    private javax.swing.JPanel panGearSelect;
    private javax.swing.JPanel panItem;
    private javax.swing.JPanel panSheltomUsado;
    private javax.swing.JPanel panSheltomUsadoC;
    private javax.swing.JRadioButton rbtAcessory;
    private javax.swing.JRadioButton rbtDefense;
    private javax.swing.JRadioButton rbtType1;
    private javax.swing.JRadioButton rbtType10;
    private javax.swing.JRadioButton rbtType2;
    private javax.swing.JRadioButton rbtType3;
    private javax.swing.JRadioButton rbtType4;
    private javax.swing.JRadioButton rbtType5;
    private javax.swing.JRadioButton rbtType6;
    private javax.swing.JRadioButton rbtType7;
    private javax.swing.JRadioButton rbtType8;
    private javax.swing.JRadioButton rbtType9;
    private javax.swing.JRadioButton rbtWeapon;
    // End of variables declaration//GEN-END:variables

    private void atualizarLista() {
        if (rbtWeapon.isSelected()) {
            if (rbtType1.isSelected()) {
                jlistItem.setModel(itemList.gerarLista(callType + ",sword"));
            } else if (rbtType2.isSelected()) {
                jlistItem.setModel(itemList.gerarLista(callType + ",axe"));
            } else if (rbtType3.isSelected()) {
                jlistItem.setModel(itemList.gerarLista(callType + ",hammer"));
            } else if (rbtType4.isSelected()) {
                jlistItem.setModel(itemList.gerarLista(callType + ",claw"));
            } else if (rbtType5.isSelected()) {
                jlistItem.setModel(itemList.gerarLista(callType + ",scythe"));
            } else if (rbtType6.isSelected()) {
                jlistItem.setModel(itemList.gerarLista(callType + ",dagger"));
            } else if (rbtType7.isSelected()) {
                jlistItem.setModel(itemList.gerarLista(callType + ",bow"));
            } else if (rbtType8.isSelected()) {
                jlistItem.setModel(itemList.gerarLista(callType + ",javelin"));
            } else if (rbtType9.isSelected()) {
                jlistItem.setModel(itemList.gerarLista(callType + ",wand"));
            } else if (rbtType10.isSelected()) {
                jlistItem.setModel(itemList.gerarLista(callType + ",phantom"));
            }
        } else if (rbtDefense.isSelected()) {
            if (rbtType1.isSelected()) {
                jlistItem.setModel(itemList.gerarLista("armor"));
            } else if (rbtType2.isSelected()) {
                jlistItem.setModel(itemList.gerarLista("robe"));
            } else if (rbtType3.isSelected()) {
                jlistItem.setModel(itemList.gerarLista("shield"));
            } else if (rbtType4.isSelected()) {
                jlistItem.setModel(itemList.gerarLista("orb"));
            } else if (rbtType5.isSelected()) {
                jlistItem.setModel(itemList.gerarLista("bracelet"));
            } else if (rbtType6.isSelected()) {
                jlistItem.setModel(itemList.gerarLista("gauntlet"));
            } else if (rbtType7.isSelected()) {
                jlistItem.setModel(itemList.gerarLista("boots"));
            }
        } else if (rbtAcessory.isSelected()) {
            if (rbtType1.isSelected()) {
                jlistItem.setModel(itemList.gerarLista("necklace"));
            } else if (rbtType2.isSelected()) {
                jlistItem.setModel(itemList.gerarLista("ring"));
            } else if (rbtType3.isSelected()) {
                jlistItem.setModel(itemList.gerarLista("sheltom"));
            }
        }
        atualizarListaMix(cmbMixC);
        atualizarListaMix(cmbMix);
        cmbAgingLevel.setSelectedIndex(0);
    }

    public void atualizarListaMix(JComboBox cmb) {
        cmb.removeAllItems();
        ItemMix mix = new ItemMix();
        if (rbtWeapon.isSelected()) {
            mix.gerarListaMix(rbtWeapon.getText());
        } else if (rbtDefense.isSelected()) {
            mix.gerarListaMix(getSelectedButtonText(gearType));
        } else if (rbtAcessory.isSelected()) {
            mix.gerarListaMix(getSelectedButtonText(gearType));
        }
        cmb.addItem("No mix");

        for (int i = 0; i < mix.getListaMix().length; i++) {
            cmb.addItem(mix.getListaMix()[i] + "-" + mix.getEfeito()[i]);
        }

    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    public JPanel getPanelGear() {
        return this.panGearSelect;
    }

    public void clearSelectingItem() {
        try {
            lblGearImage.setIcon(null);
            lblGearDesc.setText(null);
            cmbMix.setSelectedIndex(0);
            cmbMix.setEnabled(false);
            lblGearImage.validate();
            lblGearDesc.validate();
        } catch (Throwable ex) {
            Logger.getLogger(JdiGearSelector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizarSheltomsUsados() {
        lblLucidy.setText(String.valueOf(selectingItem.getLucidy()));
        lblSereneo.setText(String.valueOf(selectingItem.getSereneo()));
        lblFadeo.setText(String.valueOf(selectingItem.getFadeo()));
        lblSparky.setText(String.valueOf(selectingItem.getSparky()));
        lblRaident.setText(String.valueOf(selectingItem.getRaident()));
        lblTransparo.setText(String.valueOf(selectingItem.getTransparo()));
        lblMurky.setText(String.valueOf(selectingItem.getMurky()));
        lblDevine.setText(String.valueOf(selectingItem.getDevine()));
        lblCelesto.setText(String.valueOf(selectingItem.getCelesto()));
        lblMirage.setText(String.valueOf(selectingItem.getMirage()));
        lblInferna.setText(String.valueOf(selectingItem.getInferna()));
        lblEnigma.setText(String.valueOf(selectingItem.getEnigma()));
        lblBellum.setText(String.valueOf(selectingItem.getBellum()));
        lblOredo.setText(String.valueOf(selectingItem.getOredo()));
        lblSapphire.setText(String.valueOf(selectingItem.getSapphire()));
        lblSol.setText(String.valueOf(selectingItem.getSol()));
        lblTotalSheltom.setText(String.valueOf(selectingItem.getTotalSheltomUsado()));
    }

    public void atualizarSheltomsUsadosC() {
        lblLucidyC.setText(String.valueOf(comparingItem.getLucidy()));
        lblSereneoC.setText(String.valueOf(comparingItem.getSereneo()));
        lblFadeoC.setText(String.valueOf(comparingItem.getFadeo()));
        lblSparkyC.setText(String.valueOf(comparingItem.getSparky()));
        lblRaidentC.setText(String.valueOf(comparingItem.getRaident()));
        lblTransparoC.setText(String.valueOf(comparingItem.getTransparo()));
        lblMurkyC.setText(String.valueOf(comparingItem.getMurky()));
        lblDevineC.setText(String.valueOf(comparingItem.getDevine()));
        lblCelestoC.setText(String.valueOf(comparingItem.getCelesto()));
        lblMirageC.setText(String.valueOf(comparingItem.getMirage()));
        lblInfernaC.setText(String.valueOf(comparingItem.getInferna()));
        lblEnigmaC.setText(String.valueOf(comparingItem.getEnigma()));
        lblBellumC.setText(String.valueOf(comparingItem.getBellum()));
        lblOredoC.setText(String.valueOf(comparingItem.getOredo()));
        lblSapphireC.setText(String.valueOf(comparingItem.getSapphire()));
        lblSolC.setText(String.valueOf(comparingItem.getSol()));
        lblTotalSheltomC.setText(String.valueOf(comparingItem.getTotalSheltomUsado()));
    }

    private void adicionarMix(JComboBox cmb, boolean selectingOrComparing) {
//        if (mixState == INACTIVE) {
//            return;
//        }
        String[] nomeMix = String.valueOf(cmb.getSelectedItem()).split("-");

        if (selectingOrComparing) {
            if (rbtWeapon.isSelected()) {

                selectingItem.addMix(rbtWeapon.getText(), nomeMix[0]);
                lblGearDesc.setText(selectingItem.getItemViewDesc());
            } else {

                selectingItem.addMix(getSelectedButtonText(gearType), nomeMix[0]);
                lblGearDesc.setText(selectingItem.getItemViewDesc());
            }
            if (cmb.getSelectedIndex() == 0) {
                lastSelectedMixOrAge = NONE;
            } else {
                lastSelectedMixOrAge = MIX;
            }

            atualizarSheltomsUsados();
        } else {
            if (rbtWeapon.isSelected()) {

                comparingItem.addMix(rbtWeapon.getText(), nomeMix[0]);
                lblGearDescC.setText(comparingItem.getItemViewDesc());
            } else {

                comparingItem.addMix(getSelectedButtonText(gearType), nomeMix[0]);
                lblGearDescC.setText(comparingItem.getItemViewDesc());
            }
            if (cmb.getSelectedIndex() == 0) {
                lastSelectedMixOrAgeC = NONE;
            } else {
                lastSelectedMixOrAgeC = MIX;
            }

            atualizarSheltomsUsadosC();
        }
    }

    private void adicionarAging(JComboBox<String> cmb, boolean selectingOrComparing) {

        if (selectingOrComparing) {
            if (selectingItem.getCanAge()) {

                selectingItem.addAging(cmb.getSelectedIndex());
                atualizarSheltomsUsados();
                lblGearDesc.setText(selectingItem.getItemViewDesc());
                if (cmb.getSelectedIndex() == 0) {
                    lastSelectedMixOrAge = NONE;
                } else {
                    lastSelectedMixOrAge = AGING;
                }
            }
        } else {
            if (comparingItem.getCanAge()) {

                comparingItem.addAging(cmb.getSelectedIndex());
                atualizarSheltomsUsadosC();
                lblGearDescC.setText(comparingItem.getItemViewDesc());
                if (cmb.getSelectedIndex() == 0) {
                    lastSelectedMixOrAgeC = NONE;
                } else {
                    lastSelectedMixOrAgeC = AGING;
                }
            }
        }
    }

    private void equiparItem() {
        if (selectingItem != null) {
            switch (slotToEquip) {
                case "1h":
                    character.setItemWeaponOneHand(selectingItem);
                    lblCover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverLarge.png")));
                    break;

                case "2h":
                    character.setItemWeaponTwoHand(selectingItem);
                    lblCover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverLarge.png")));
                    break;

                case "armor":
                    character.setItemArmor(selectingItem);
                    lblCover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverLarge.png")));
                    break;

                case "shield":
                    character.setItemShield(selectingItem);
                    lblCover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverLarge.png")));
                    break;

                case "bracelet":
                    character.setItemBracelet(selectingItem);
                    lblCover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverMiddle.png")));
                    break;

                case "gauntlet":
                    character.setItemGauntlet(selectingItem);
                    lblCover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverMiddle.png")));
                    break;

                case "boots":
                    character.setItemBoots(selectingItem);
                    lblCover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverMiddle.png")));
                    break;

                case "amulet":
                    character.setItemAmulet(selectingItem);
                    lblCover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverSmall.png")));
                    break;

                case "ring1":
                    character.setItemRing1(selectingItem);
                    lblCover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverSmall.png")));
                    break;

                case "ring2":
                    character.setItemRing2(selectingItem);
                    lblCover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverSmall.png")));
                    break;

                case "sheltom":
                    character.setItemSheltom(selectingItem);
                    lblCover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/coverSmall.png")));
                    break;
            }
            

            btnSlotToEquip.setIcon(textureWork.addTranspBMP(selectingItem.getItemImgDir()));
            btnSlotToEquip.setToolTipText(selectingItem.getItemDesc());
            main.sfx.playSound(assetsController.ITEMSFX_DIR + selectingItem.getItemType() + ".wav");
            animGear.open(this.getPanelGear(), CLOSE, this);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Item - It isn't added to the database yet.", "Error - Null Item", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adicionarTranspSheltomUsado() {
        lblImgLucidy.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/lucidy.png"));
        lblImgLucidyC.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/lucidy.png"));
        lblImgSereneo.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/sereneo.png"));
        lblImgSereneoC.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/sereneo.png"));
        lblImgFadeo.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/fadeo.png"));
        lblImgFadeoC.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/fadeo.png"));
        lblImgSparky.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/sparky.png"));
        lblImgSparkyC.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/sparky.png"));
        lblImgRaident.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/raident.png"));
        lblImgRaidentC.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/raident.png"));
        lblImgTransparo.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/transparo.png"));
        lblImgTransparoC.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/transparo.png"));
        lblImgMurky.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/murky.png"));
        lblImgMurkyC.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/murky.png"));
        lblImgDevine.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/devine.png"));
        lblImgDevineC.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/devine.png"));
        lblImgCelesto.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/celesto.png"));
        lblImgCelestoC.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/celesto.png"));
        lblImgMirage.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/mirage.png"));
        lblImgMirageC.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/mirage.png"));
        lblImgInferna.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/inferna.png"));
        lblImgInfernaC.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/inferna.png"));
        lblImgEnigma.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/enigma.png"));
        lblImgEnigmaC.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/enigma.png"));
        lblImgBellum.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/bellum.png"));
        lblImgBellumC.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/bellum.png"));
        lblImgOredo.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/oredo.png"));
        lblImgOredoC.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/oredo.png"));
        lblImgSapphire.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/sapphire.png"));
        lblImgSapphireC.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/sapphire.png"));
        lblImgSol.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/sol.png"));
        lblImgSolC.setIcon(textureWork.addTranspBMP("/assets/item/sheltom/sol.png"));

    }

    /**
     * Muda o level e os status alocados atualmente para atender as necessidades
     * do item a ser equipado.
     *
     * @param statsInsuficientes - Matriz de String que armazena: [índice][Nome
     * do atributo, Valor da diferença]
     */
    private void autoFitStats(String[][] statsInsuficientes) {
        int highest = Integer.MIN_VALUE;    //Armazena o status com maior valor alocado
        int indexHighest = 99;              //Armazena o índice do stats com maior valor alocado, para saber se é Str, spi, etc
        int statsNecessarios = 0;           //Armazena quanto de stats totais é necessário para equipar o item
        //Armazena os status atuais do personagem
        int[] stats = new int[]{character.getStrenght(), character.getSpirit(), character.getTalent(), character.getAgility(), character.getHealth()};

        /*Percorre o array gerado de status insuficientes. Se existir level insuficiente, muda o level do personagem para o do item.
        Adiciona na variavel statsNecessarios os stats restantes de str, spi, etc, para ter um total de quanto é preciso ser re-alocado.
         */
        for (int i = 0; i < statsInsuficientes.length; i++) {
            if (statsInsuficientes[i][0].equals("Level") && !statsInsuficientes[i][1].equals("0")) {
                character.setLevel(character.getLevel() + Integer.parseInt(statsInsuficientes[i][1]));
                System.out.println("Level do personagem mudou para: " + character.getLevel());
            } else if (!statsInsuficientes[i][0].equals("Level") && !statsInsuficientes[i][1].equals("0")) {
                statsNecessarios += Integer.parseInt(statsInsuficientes[i][1]);
            }
        }

        /*
        Primeiro verifica se há status ainda não alocados sobrando para equipar o item
         */
        if (character.getRemainStats() >= statsNecessarios) {
            /*
            Percorre cada tipo de status insuficiente, verifica se o nome do status condiz
            e também verifica se o mesmo é diferente de zero. Atingindo a condição, 
            adiciona ao tipo do status o valor que falta, onde o metodo setStrenght, setSpirit, etc]
            já atualiza os status de sobra (remainStats).
            Após a adição, subtrai do total de status insuficientes ainda a serem alocados.
             */
            for (int i = 0; i < statsInsuficientes.length; i++) {
                if (statsInsuficientes[i][0].equals("Strenght") && !statsInsuficientes[i][1].equals("0")) {
                    if (character.getRemainStats() >= statsNecessarios) {
                        character.setStrenght(character.getStrenght() + Integer.parseInt(statsInsuficientes[i][1]));
                        statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                    }
                } else if (statsInsuficientes[i][0].equals("Spirit") && !statsInsuficientes[i][1].equals("0")) {
                    if (character.getRemainStats() >= statsNecessarios) {
                        character.setSpirit(character.getSpirit() + Integer.parseInt(statsInsuficientes[i][1]));
                        statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                    }
                } else if (statsInsuficientes[i][0].equals("Talent") && !statsInsuficientes[i][1].equals("0")) {
                    if (character.getRemainStats() >= statsNecessarios) {
                        character.setTalent(character.getTalent() + Integer.parseInt(statsInsuficientes[i][1]));
                        statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                    }
                } else if (statsInsuficientes[i][0].equals("Agility") && !statsInsuficientes[i][1].equals("0")) {
                    if (character.getRemainStats() >= statsNecessarios) {
                        character.setAgility(character.getAgility() + Integer.parseInt(statsInsuficientes[i][1]));
                        statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                    }
                } else if (statsInsuficientes[i][0].equals("Health") && !statsInsuficientes[i][1].equals("0")) {
                    if (character.getRemainStats() >= statsNecessarios) {
                        character.setHealth(character.getHealth() + Integer.parseInt(statsInsuficientes[i][1]));
                        statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                    }
                }

                System.out.println("Tirando do Remain - statsNecessarios: " + statsNecessarios);
            }
        }

        //Faça - enquanto o valor de status necessário for diferente de 0
        do {
            /*
            For para detectar qual o maior status alocado, atribuindo o índice do maior status.
            Possíveis valores atribuidos ao indexHighest
            0 - Strenght
            1 - Spirit
            2 - Talent
            3 - Agility
            4 - Health
             */
            for (int i = 0; i < 5; i++) {
                if (stats[i] > highest) {
                    highest = stats[i];
                    indexHighest = i;
                }
            }
            /*
            Após ter o índice definido, percorre a matriz com os status insuficiente, verificando qual possui valor diferente de 0.
            Caso possua, significa que ainda há algum status insuficiente para equipar o item.
            De acordo com o maior status alocado, verifica se o maior status alocado, menos o valor base dele, menos o total
            de status insuficiente, é maior que o status necessário para equipar o item.
            Caso for maior, remove do status maior o valor que precisa ser atribuído para o outro necessário, e incrementa
            O valor atual do outro status, que é o necessário para equipar o item.
            Após, deduz do contador de status necessários totais.
             */
            if (statsNecessarios != 0) {
                if (indexHighest == 0) { //STR é o maior
                    for (int i = 0; i < statsInsuficientes.length; i++) {
                        if (statsInsuficientes[i][0].equals("Spirit") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getStrenght() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setStrenght(character.getStrenght() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setSpirit(character.getSpirit() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        } else if (statsInsuficientes[i][0].equals("Talent") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getStrenght() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setStrenght(character.getStrenght() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setTalent(character.getTalent() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        } else if (statsInsuficientes[i][0].equals("Agility") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getStrenght() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setStrenght(character.getStrenght() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setAgility(character.getAgility() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        } else if (statsInsuficientes[i][0].equals("Health") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getStrenght() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setStrenght(character.getStrenght() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setHealth(character.getHealth() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        }

                        System.out.println("Tirando de Strenght - statsNecessarios: " + statsNecessarios);
                    }
                } else if (indexHighest == 1) { //Spirit é o maior
                    for (int i = 0; i < statsInsuficientes.length; i++) {
                        if (statsInsuficientes[i][0].equals("Strenght") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getStrenght() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setSpirit(character.getSpirit() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setStrenght(character.getStrenght() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        } else if (statsInsuficientes[i][0].equals("Talent") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getSpirit() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setSpirit(character.getSpirit() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setTalent(character.getTalent() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        } else if (statsInsuficientes[i][0].equals("Agility") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getSpirit() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setSpirit(character.getSpirit() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setAgility(character.getAgility() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        } else if (statsInsuficientes[i][0].equals("Health") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getStrenght() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setStrenght(character.getStrenght() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setHealth(character.getHealth() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        }

                        System.out.println("Tirando de Spirit - statsNecessarios: " + statsNecessarios);
                    }
                } else if (indexHighest == 2) { //Talent é o maior
                    for (int i = 0; i < statsInsuficientes.length; i++) {
                        if (statsInsuficientes[i][0].equals("Strenght") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getStrenght() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setTalent(character.getTalent() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setStrenght(character.getStrenght() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        } else if (statsInsuficientes[i][0].equals("Spirit") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getTalent() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setTalent(character.getTalent() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setSpirit(character.getSpirit() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        } else if (statsInsuficientes[i][0].equals("Agility") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getTalent() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setTalent(character.getTalent() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setAgility(character.getAgility() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        } else if (statsInsuficientes[i][0].equals("Health") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getStrenght() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setStrenght(character.getStrenght() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setHealth(character.getHealth() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        }

                        System.out.println("Tirando de Talent - statsNecessarios: " + statsNecessarios);
                    }
                } else if (indexHighest == 3) { //Agility é o maior
                    for (int i = 0; i < statsInsuficientes.length; i++) {
                        if (statsInsuficientes[i][0].equals("Strenght") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getStrenght() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setAgility(character.getAgility() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setStrenght(character.getStrenght() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        } else if (statsInsuficientes[i][0].equals("Spirit") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getAgility() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setAgility(character.getAgility() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setSpirit(character.getSpirit() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        } else if (statsInsuficientes[i][0].equals("Talent") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getAgility() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setAgility(character.getAgility() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setTalent(character.getTalent() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        } else if (statsInsuficientes[i][0].equals("Health") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getStrenght() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setStrenght(character.getStrenght() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setHealth(character.getHealth() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        }

                        System.out.println("Tirando de Agility - statsNecessarios: " + statsNecessarios);
                    }
                } else if (indexHighest == 4) { //Health é o maior
                    for (int i = 0; i < statsInsuficientes.length; i++) {
                        if (statsInsuficientes[i][0].equals("Strenght") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getStrenght() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setHealth(character.getHealth() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setStrenght(character.getStrenght() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        } else if (statsInsuficientes[i][0].equals("Spirit") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getHealth() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setHealth(character.getHealth() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setSpirit(character.getSpirit() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        } else if (statsInsuficientes[i][0].equals("Talent") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getHealth() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setHealth(character.getHealth() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setTalent(character.getTalent() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        } else if (statsInsuficientes[i][0].equals("Agility") && !statsInsuficientes[i][1].equals("0")) {
                            if (((character.getHealth() - character.getBaseStr()) - statsNecessarios) >= statsNecessarios) {
                                character.setHealth(character.getHealth() - Integer.valueOf(statsInsuficientes[i][1]));
                                character.setAgility(character.getAgility() + Integer.parseInt(statsInsuficientes[i][1]));
                                statsNecessarios -= Integer.parseInt(statsInsuficientes[i][1]);
                            }
                        }

                        System.out.println("Tirando de Health - statsNecessarios: " + statsNecessarios);
                    }
                }
            }

        } while (statsNecessarios != 0);

        checkReqStats(false);
    }

    /**
     * Verifica se o personagem possui os status necessários para equipar o item
     * selecionado.
     *
     * @param showConfirmWindow - Booleana que determina se o método será
     * executado exibindo a janela com os status necessários. Existe essa opção
     * pois esse método é chamado recursivamente, caso após uma tentativa de
     * redistribuir os stats automaticamente ainda não exista status suficientes
     * para equipar o item.
     */
    public void checkReqStats(boolean showStatDiffWindow) {
        //Se a flag allowEquip estiver verdadeiro, procede com o método
        if (allowEquip) {
            /*Declara uma matriz que será populada pelo retorno do método checkStatusReq da classe
            Item. O item a ser verificado é o item atualmente selecionado na lista.
             */
            String[][] statusInsuficientes = selectingItem.checkStatusReq();
            //String que armazenará o nome do atributo e o valor da diferença de status necessário
            String msg = "";
            //Int que armazena o retorno do JOPtionPane, quando clicado nos botões (Yes = 0, No =1)
            int opcao = 0;

            //Percorre o array de stats insuficientes e verifica se há um valor diferente de zero.
            //Caso exista, é porquê algum status do personagem não é suficiente para equipar o item
            for (int i = 0; i < statusInsuficientes.length; i++) {
                if (statusInsuficientes[i][1] != "0") {
                    //Popula a String com o nome do atributo e o valor, pulando linha em seguida.
                    msg += statusInsuficientes[i][0] + ": -" + statusInsuficientes[i][1] + "\n";
                }
            }
            /*Caso há algum conteúdo na string de mensagem, chama a janela para perguntar
            Se deseja re-distribuir o level e os status automaticamente.
             */
            if (msg != "" && showStatDiffWindow) {
                opcao = JOptionPane.showConfirmDialog(this, selectingItem.getItemName() + " can't be equiped."
                        + "\nYour character doesn't have the following requirements:\n\n" + msg + "\n\n"
                        + "Do you want to automatically set the required status? It will reduce status"
                        + "\nfrom the status with most allocated points.\n", "Insuficient Status or Level!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                //Se clicar em YES, chama o método que fará o re-alocamento automaticamente.
                if (opcao == JOptionPane.YES_OPTION) {
                    autoFitStats(statusInsuficientes);
                } else {

                }
            } //Caso a string de mensagem esteja vazia, significa que o personagem possui todos os requerimentos, e equipa o item selecionado
            else {
                equiparItem();
                allowEquip = false;
            }

        }
    }

    private void exibirWeapons() {

        definirBotoesCategoriaOnClickTipo("weapon");
        atualizarLista();
    }

    private void exibirDefenses() {

        definirBotoesCategoriaOnClickTipo("defense");
        atualizarLista();
    }

    private void exibirAcessories() {
        definirBotoesCategoriaOnClickTipo("acessory");
        atualizarLista();
    }

    public Item getSelectingItem() {
        return selectingItem;
    }

    public void setSelectingItem(Item selectingItem) {
        this.selectingItem = selectingItem;
    }

    public Item getComparingItem() {
        return comparingItem;
    }

    public void setComparingItem(Item comparingItem) {
        this.comparingItem = comparingItem;
    }

    public javax.swing.JComboBox<String> getCmbAgingLevel() {
        return cmbAgingLevel;
    }

    public void setCmbAgingLevel(javax.swing.JComboBox<String> cmbAgingLevel) {
        this.cmbAgingLevel = cmbAgingLevel;
    }

    public javax.swing.JComboBox<String> getCmbAgingLevelC() {
        return cmbAgingLevelC;
    }

    public void setCmbAgingLevelC(javax.swing.JComboBox<String> cmbAgingLevelC) {
        this.cmbAgingLevelC = cmbAgingLevelC;
    }

    public javax.swing.JComboBox<String> getCmbMix() {
        return cmbMix;
    }

    public void setCmbMix(javax.swing.JComboBox<String> cmbMix) {
        this.cmbMix = cmbMix;
    }

    public javax.swing.JComboBox<String> getCmbMixC() {
        return cmbMixC;
    }

    public void setCmbMixC(javax.swing.JComboBox<String> cmbMixC) {
        this.cmbMixC = cmbMixC;
    }

    public javax.swing.JComboBox<String> getCmbSpec() {
        return cmbSpec;
    }

    public void setCmbSpec(javax.swing.JComboBox<String> cmbSpec) {
        this.cmbSpec = cmbSpec;
    }

    public javax.swing.JComboBox<String> getCmbSpecC() {
        return cmbSpecC;
    }

    public void setCmbSpecC(javax.swing.JComboBox<String> cmbSpecC) {
        this.cmbSpecC = cmbSpecC;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public javax.swing.JRadioButton getRbtWeapon() {
        return rbtWeapon;
    }

    public void setRbtWeapon(javax.swing.JRadioButton rbtWeapon) {
        this.rbtWeapon = rbtWeapon;
    }

    public javax.swing.JLabel getLblGearDesc() {
        return lblGearDesc;
    }

    public void setLblGearDesc(javax.swing.JLabel lblGearDesc) {
        this.lblGearDesc = lblGearDesc;
    }

    public javax.swing.JLabel getLblGearImageC() {
        return lblGearImageC;
    }

    public void setLblGearImageC(javax.swing.JLabel lblGearImageC) {
        this.lblGearImageC = lblGearImageC;
    }

    public javax.swing.JLabel getLblGearDescC() {
        return lblGearDescC;
    }

    public void setLblGearDescC(javax.swing.JLabel lblGearDescC) {
        this.lblGearDescC = lblGearDescC;
    }

    public class TransparentListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            setOpaque(isSelected);
            return this;
        }

    }

    private void limparMixAgeItem(byte acao) {

        switch (acao) {
            case EQUIPANDO:
                main.sfx.playSound(assetsController.ITEMSFX_DIR + "drink2.wav");
                selectingItem.zerarValoresModificados();
                atualizarSheltomsUsados();
                lblGearDesc.setText(selectingItem.getItemViewDesc());
                break;
            case COMPARANDO:
                main.sfx.playSound(assetsController.ITEMSFX_DIR + "drink2.wav");
                comparingItem.zerarValoresModificados();
                atualizarSheltomsUsadosC();
                lblGearDescC.setText(comparingItem.getItemViewDesc());
                break;
            default:
                System.out.println("Erro ao tentar limpar item");
        }

    }

}
