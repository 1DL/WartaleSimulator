/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import formula.CharacterStats;
import java.text.DecimalFormat;
import view.JdiGearSelector;

/**
 *
 * @author Administrator
 */
public class Item {

    //constantes
    public static final boolean ONE_HANDED = false;
    public static final boolean TWO_HANDED = true;

    //Class Spec
    public static final String MS = "Mechanician";
    public static final String FS = "Fighter";
    public static final String PS = "Pikeman";
    public static final String AS = "Archer";
    public static final String ASS = "Assassin";
    public static final String KS = "Knight";
    public static final String ATS = "Atalanta";
    public static final String PRS = "Priestess";
    public static final String MGS = "Magician";
    public static final String SS = "Shaman";
    public static final String NS = "No Spec";

    //diretório ícones
    //acessory
    public static final String ICON_AMULET = "";
    public static final String ICON_RING = "";
    public static final String ICON_SHELTOM = "";

    public static final String ACESSORY_IMG_PATH = "/assets/item/acessory/";

    //defense
    public static final String ICON_ARMOR = "";
    public static final String ICON_ROBE = "";
    public static final String ICON_SHIELD = "";
    public static final String ICON_ORB = "";
    public static final String ICON_BRACELET = "";
    public static final String ICON_GAUNTLET = "";
    public static final String ICON_BOOT = "";

    public static final String DEFENSE_IMG_PATH = "/assets/item/defense/";

    //weapons
    public static final String ICON_ONE_HANDED_AXE = "";
    public static final String ICON_TWO_HANDED_AXE = "";
    public static final String ICON_ONE_HANDED_BOW = "";
    public static final String ICON_TWO_HANDED_BOW = "";
    public static final String ICON_ONE_HANDED_CLAW = "";
    public static final String ICON_TWO_HANDED_CLAW = "";
    public static final String ICON_ONE_HANDED_DAGGER = "";
    public static final String ICON_TWO_HANDED_DAGGER = "";
    public static final String ICON_ONE_HANDED_HAMMER = "";
    public static final String ICON_TWO_HANDED_HAMMER = "";
    public static final String ICON_ONE_HANDED_JAVELIN = "";
    public static final String ICON_TWO_HANDED_JAVELIN = "";
    public static final String ICON_ONE_HANDED_PHANTOM = "";
    public static final String ICON_TWO_HANDED_PHANTOM = "";
    public static final String ICON_ONE_HANDED_SCYTHE = "";
    public static final String ICON_TWO_HANDED_SCYTHE = "";
    public static final String ICON_ONE_HANDED_SWORD = "";
    public static final String ICON_TWO_HANDED_SWORD = "";
    public static final String ICON_ONE_HANDED_WAND = "";
    public static final String ICON_TWO_HANDED_WAND = "";

    public static final String WEAPON_IMG_PATH = "/assets/item/weapon/";

    protected CharacterStats c;
    protected String itemClass = "";
    protected String itemType = "";
    protected String itemName = "";
    protected String itemCode = "";
    protected boolean itemAged = false;
    protected boolean itemCanAge = false;
    protected String ageType = "";
    protected int agingLevel = 0;
    protected String itemMix = "";
    protected String itemImgDir = null;
    protected String itemIconDir = "";
    protected String itemSoundDir = "";
    protected String itemDesc = "";
    protected String itemDescSpec = "";
    protected String itemDescMisc = "";
    protected String selectedSpec = "No Spec";
    protected boolean oneOrTwoHanded = false;
    protected String itemLore = "";
    protected boolean requirementsMatch = true;
    protected boolean reqLvlMatch = true;
    protected boolean reqStrMatch = true;
    protected boolean reqSpiMatch = true;
    protected boolean reqTalMatch = true;
    protected boolean reqAgiMatch = true;
    //sheltoms usados
    protected int lucidy = 0;
    protected int sereneo = 0;
    protected int fadeo = 0;
    protected int sparky = 0;
    protected int raident = 0;
    protected int transparo = 0;
    protected int murky = 0;
    protected int devine = 0;
    protected int celesto = 0;
    protected int mirage = 0;
    protected int inferna = 0;
    protected int enigma = 0;
    protected int bellum = 0;
    protected int oredo = 0;
    protected int sapphire = 0;
    protected int sol = 0;

    //Requerimentos - r = base = m modificado por spec
    protected int rLvl = 0;
    protected int mLvl = 0;
    protected int rStr = 0;
    protected int mMINstr = 0;
    protected int mMAXstr = 0;
    protected int rSpi = 0;
    protected int mMINspi = 0;
    protected int mMAXspi = 0;
    protected int rTal = 0;
    protected int mMINtal = 0;
    protected int mMAXtal = 0;
    protected int rAgi = 0;
    protected int mMINagi = 0;
    protected int mMAXagi = 0;
    protected int rVit = 0;
    protected int mVit = 0;
    //Status base
    protected int MAXintegrity = 0;
    protected int MINintegrity = 0;
    //Ofensivos
    protected int MINatkMin = 0;
    protected int MAXatkMin = 0;
    protected int mMINAtkMin = 0;
    protected int mMAXAtkMin = 0;
    protected int MINatkMax = 0;
    protected int MAXatkMax = 0;
    protected int mAtkMax = 0;
    protected int mMINAtkMax = 0;
    protected int mMAXAtkMax = 0;
    protected int MINatkRtg = 0;
    protected int MAXatkRtg = 0;
    protected int mAtkRtg = 0;
    protected int mMINAtkRtg = 0;
    protected int mMAXAtkRtg = 0;
    protected int atkSpd = 0;
    protected int mAtkSpd = 0;
    protected float critChance = 0;
    protected float mCritChance = 0;
    protected float MINCritDamage = 0;
    protected float MAXCritDamage = 0;
    protected float mMINCritDamage = 0;
    protected float mMAXCritDamage = 0;
    //Defensivos
    protected float MINdefense = 0;
    protected float MAXdefense = 0;
    protected float mMINdefense = 0;
    protected float mMAXdefense = 0;
    protected float MINblock = 0;
    protected float MAXblock = 0;
    protected float mMINblock = 0;
    protected float mMAXblock = 0;
    protected int MINevasion = 0;
    protected int MAXevasion = 0;
    protected float MINabs = 0;
    protected float MAXabs = 0;
    protected float mMINabs = 0;
    protected float mMAXabs = 0;
    protected int MINhp = 0;
    protected int MAXhp = 0;
    protected int mMINhp = 0;
    protected int mMAXhp = 0;
    protected float MINhpReg = 0;
    protected float MAXhpReg = 0;
    protected float mMINhpReg = 0;
    protected float mMAXhpReg = 0;
    protected int MINorganicResist = 0;
    protected int MINpoisonResist = 0;
    protected int MINiceResist = 0;
    protected int MINfireResist = 0;
    protected int MINlightningResist = 0;
    protected int MINearthResist = 0;
    protected int MINwaterResist = 0;
    protected int MINwindResist = 0;
    protected int MAXorganicResist = 0;
    protected int MAXpoisonResist = 0;
    protected int MAXiceResist = 0;
    protected int MAXfireResist = 0;
    protected int MAXlightningResist = 0;
    protected int MAXearthResist = 0;
    protected int MAXwaterResist = 0;
    protected int MAXwindResist = 0;
    protected int mMINorganicResist = 0;
    protected int mMINpoisonResist = 0;
    protected int mMINiceResist = 0;
    protected int mMINfireResist = 0;
    protected int mMINlightningResist = 0;
    protected int mMINearthResist = 0;
    protected int mMINwaterResist = 0;
    protected int mMINwindResist = 0;
    protected int mMAXorganicResist = 0;
    protected int mMAXpoisonResist = 0;
    protected int mMAXiceResist = 0;
    protected int mMAXfireResist = 0;
    protected int mMAXlightningResist = 0;
    protected int mMAXearthResist = 0;
    protected int mMAXwaterResist = 0;
    protected int mMAXwindResist = 0;

    //gerais
    protected int range = 0;
    protected int MINmp = 0;
    protected int MAXmp = 0;
    protected int mMINmp = 0;
    protected int mMAXmp = 0;
    protected float MINmpReg = 0;
    protected float MAXmpReg = 0;
    protected int MINstm = 0;
    protected int MAXstm = 0;
    protected int mMINstm = 0;
    protected int mMAXstm = 0;
    protected float MINstmReg = 0;
    protected float MAXstmReg = 0;
    protected float mMINmpReg = 0;
    protected float mMAXmpReg = 0;
    protected float mMINstmReg = 0;
    protected float mMAXstmReg = 0;
    protected float MINmoveSpeed = 0;
    protected float MAXmoveSpeed = 0;
    protected float mMINmoveSpeed = 0;
    protected float mMAXmoveSpeed = 0;
    protected int potCount = 0;
    protected int magicAPT = 0;
    //misc
    protected String[] classSpec = {NS};
    protected int weight = 0;
    protected double price = 0;
    protected double specPrice = 0;
    protected double agingCost = 0;
    protected double totalAgingCost = 0;
    protected double mixCost = 0;
    protected int MPRecoveryMin = 0;
    protected int MPRecoveryMax = 0;
    protected int HPRecoveryMin = 0;
    protected int HPRecoveryMax = 0;
    protected int SPRecoveryMin = 0;
    protected int SPRecoveryMax = 0;
    protected int Duration = 0;
    protected int Display = 0;
    //spec ofensivo
    protected int sDivAtkPow = 0;
    protected int sMINDivAtkRtg = 0;
    protected int sMAXDivAtkRtg = 0;
    protected int sAtkSpd = 0;
    protected int sCritChance = 0;
    //spec defensivo
    protected int sMINdefense = 0;
    protected int sMAXdefense = 0;
    protected float sBlock = 0;
    protected float sMINabs = 0;
    protected float sMAXabs = 0;
    protected int sDivHp = 0;
    protected float sHpReg = 0;
    //spec gerais
    protected int sDivMp = 0;
    protected float sMINmpReg = 0;
    protected float sMAXmpReg = 0;
    protected float sStmReg = 0;
    protected int sRange = 0;
    protected int sMINmagicAPT = 0;
    protected int sMAXmagicAPT = 0;
    protected float sMINmoveSpeed = 0;
    protected float sMAXmoveSpeed = 0;

    public Item() {

    }

    public Item(String noGear) {
        switch (noGear) {
            case "No Gear Weapon":
                itemClass = "Melee";
                itemType = "No Gear";
                itemImgDir = null;
                createItemDesc();
                break;
            default:
                itemType = "No Gear";
                itemImgDir = null;
                createItemDesc();
                break;
                
        }
    }

    public CharacterStats getOwnerCharacter() {
        return c;
    }

    public void setOwnerCharacter(CharacterStats c) {
        this.c = c;
    }

    public void setSpecRequirement(String spec) {
        mMINstr = rStr;
        mMAXstr = rStr;
        mMINspi = rSpi;
        mMAXspi = rSpi;
        mMINtal = rTal;
        mMAXtal = rTal;
        mMINagi = rAgi;
        mMAXagi = rAgi;

        switch (spec) {
            case "No Spec":
                break;
            case "Fighter":
                //Strenght
                mMINstr = (int) (float) Math.floor((rStr * (1f + 0.10f)));
                mMAXstr = (int) (float) Math.floor((rStr * (1f + 0.15f)));
                //Spirit
                mMAXspi = (int) (float) Math.ceil((rSpi * (1f - 0.15f)));
                mMINspi = (int) (float) Math.ceil((rSpi * (1f - 0.20f)));
                //Talent
                mMINtal = rTal;
                mMAXtal = rTal;
                //Agility
                mMAXagi = (int) (float) Math.ceil((rAgi * (1f - 0.15f)));
                mMINagi = (int) (float) Math.ceil((rAgi * (1f - 0.20f)));
                break;
            case "Mechanician":
                //Strenght
                mMINstr = (int) (float) Math.floor((rStr * (1f + 0.05f)));
                mMAXstr = (int) (float) Math.floor((rStr * (1f + 0.15f)));
                //Spirit
                mMAXspi = (int) (float) Math.ceil((rSpi * (1f - 0.10f)));
                mMINspi = (int) (float) Math.ceil((rSpi * (1f - 0.20f)));
                //Talent
                mMINtal = rTal;
                mMAXtal = rTal;
                //Agility
                mMAXagi = (int) (float) Math.ceil((rAgi * (1f - 0.15f)));
                mMINagi = (int) (float) Math.ceil((rAgi * (1f - 0.25f)));
                break;
            case "Archer":
                //Strenght
                mMAXstr = (int) (float) Math.ceil((rStr * (1f - 0.15f)));
                mMINstr = (int) (float) Math.ceil((rStr * (1f - 0.25f)));
                //Spirit
                mMAXspi = (int) (float) Math.ceil((rSpi * (1f - 0.10f)));
                mMINspi = (int) (float) Math.ceil((rSpi * (1f - 0.20f)));
                //Talent
                mMINtal = rTal;
                mMAXtal = rTal;
                //Agility
                mMINagi = (int) (float) Math.floor((rAgi * (1f + 0.15f)));
                mMAXagi = (int) (float) Math.floor((rAgi * (1f + 0.25f)));
                break;
            case "Pikeman":
                //Strenght
                mMINstr = (int) (float) Math.floor((rStr * (1f + 0.10f)));
                mMAXstr = (int) (float) Math.floor((rStr * (1f + 0.15f)));
                //Spirit
                mMAXspi = (int) (float) Math.ceil((rSpi * (1f - 0.15f)));
                mMINspi = (int) (float) Math.ceil((rSpi * (1f - 0.20f)));
                //Talent
                mMINtal = rTal;
                mMAXtal = rTal;
                //Agility
                mMAXagi = (int) (float) Math.ceil((rAgi * (1f - 0.15f)));
                mMINagi = (int) (float) Math.ceil((rAgi * (1f - 0.25f)));
                break;
            case "Atalanta":
                //Strenght
                mMAXstr = (int) (float) Math.ceil((rStr * (1f - 0.15f)));
                mMINstr = (int) (float) Math.ceil((rStr * (1f - 0.20f)));
                //Spirit
                mMAXspi = (int) (float) Math.ceil((rSpi * (1f - 0.10f)));
                mMINspi = (int) (float) Math.ceil((rSpi * (1f - 0.20f)));
                //Talent
                mMINtal = rTal;
                mMAXtal = rTal;
                //Agility
                mMINagi = (int) (float) Math.floor((rAgi * (1f + 0.15f)));
                mMAXagi = (int) (float) Math.floor((rAgi * (1f + 0.25f)));
                break;
            case "Knight":
                //Strenght
                mMINstr = (int) (float) Math.floor((rStr * (1f + 0.05f)));
                mMAXstr = (int) (float) Math.floor((rStr * (1f + 0.15f)));
                //Spirit
                mMAXspi = (int) (float) Math.ceil((rSpi * (1f - 0.10f)));
                mMINspi = (int) (float) Math.ceil((rSpi * (1f - 0.15f)));
                //Talent
                mMINtal = (int) (float) Math.floor((rTal * (1f + 0.05f)));
                mMAXtal = (int) (float) Math.floor((rTal * (1f + 0.10f)));
                //Agility
                mMAXagi = (int) (float) Math.ceil((rAgi * (1f - 0.15f)));
                mMINagi = (int) (float) Math.ceil((rAgi * (1f - 0.25f)));
                break;
            case "Magician":
                //Strenght
                mMAXstr = (int) (float) Math.ceil((rStr * (1f - 0.20f)));
                mMINstr = (int) (float) Math.ceil((rStr * (1f - 0.25f)));
                //Spirit
                mMINspi = (int) (float) Math.floor((rSpi * (1f + 0.15f)));
                mMAXspi = (int) (float) Math.floor((rSpi * (1f + 0.25f)));
                //Talent
                mMAXtal = (int) (float) Math.ceil((rTal * (1f - 0.10f)));
                mMINtal = (int) (float) Math.ceil((rTal * (1f - 0.15f)));
                //Agility
                mMAXagi = (int) (float) Math.ceil((rAgi * (1f - 0.15f)));
                mMINagi = (int) (float) Math.ceil((rAgi * (1f - 0.20f)));
                break;
            case "Priestess":
                //Strenght
                mMAXstr = (int) (float) Math.ceil((rStr * (1f - 0.20f)));
                mMINstr = (int) (float) Math.ceil((rStr * (1f - 0.25f)));
                //Spirit
                mMINspi = (int) (float) Math.floor((rSpi * (1f + 0.15f)));
                mMAXspi = (int) (float) Math.floor((rSpi * (1f + 0.20f)));
                //Talent
                mMAXtal = (int) (float) Math.ceil((rTal * (1f - 0.10f)));
                mMINtal = (int) (float) Math.ceil((rTal * (1f - 0.15f)));
                //Agility
                mMAXagi = (int) (float) Math.ceil((rAgi * (1f - 0.15f)));
                mMINagi = (int) (float) Math.ceil((rAgi * (1f - 0.20f)));
                break;
            case "Assassin":
                //Strenght
                mMINstr = (int) (float) Math.floor((rStr * (1f + 0.10f)));
                mMAXstr = (int) (float) Math.floor((rStr * (1f + 0.15f)));
                //Spirit
                mMAXspi = (int) (float) Math.ceil((rSpi * (1f - 0.10f)));
                mMINspi = (int) (float) Math.ceil((rSpi * (1f - 0.20f)));
                //Talent
                mMINtal = rTal;
                mMAXtal = rTal;
                //Agility
                mMINagi = (int) (float) Math.floor((rAgi * (1f + 0.15f)));
                mMAXagi = (int) (float) Math.floor((rAgi * (1f + 0.25f)));
                break;
            case "Shaman":
                //Strenght
                mMAXstr = (int) (float) Math.ceil((rStr * (1f - 0.20f)));
                mMINstr = (int) (float) Math.ceil((rStr * (1f - 0.25f)));
                //Spirit
                mMINspi = (int) (float) Math.floor((rSpi * (1f + 0.15f)));
                mMAXspi = (int) (float) Math.floor((rSpi * (1f + 0.25f)));
                //Talent
                mMAXtal = (int) (float) Math.ceil((rTal * (1f - 0.10f)));
                mMINtal = (int) (float) Math.ceil((rTal * (1f - 0.15f)));
                //Agility
                mMAXagi = (int) (float) Math.ceil((rAgi * (1f - 0.15f)));
                mMINagi = (int) (float) Math.ceil((rAgi * (1f - 0.20f)));
                break;
        }

        checkStatusReq();

    }

    public void zerarValoresModificados() {
        agingLevel = 0;
        itemAged = false;
        itemMix = "";
        mLvl = 0;
        mAtkSpd = 0;
        mMINAtkMin = 0;
        mMAXAtkMin = 0;
        mAtkMax = 0;
        mMINAtkMax = 0;
        mMAXAtkMax = 0;
        mAtkRtg = 0;
        mMINAtkRtg = 0;
        mMAXAtkRtg = 0;
        mCritChance = 0;
        mMINdefense = 0;
        mMAXdefense = 0;
        mMINblock = 0;
        mMAXblock = 0;
        mMINabs = 0;
        mMAXabs = 0;
        mMINhp = 0;
        mMAXhp = 0;
        mMINhpReg = 0;
        mMAXhpReg = 0;
        mMINmp = 0;
        mMAXmp = 0;
        mMINstm = 0;
        mMAXstm = 0;
        mMINmoveSpeed = 0;
        mMAXmoveSpeed = 0;
        mMINmpReg = 0;
        mMAXmpReg = 0;
        mMINstmReg = 0f;
        mMAXstmReg = 0f;
        mMINorganicResist = 0;
        mMAXorganicResist = 0;
        mMINfireResist = 0;
        mMAXfireResist = 0;
        mMINiceResist = 0;
        mMAXiceResist = 0;
        mMINlightningResist = 0;
        mMAXlightningResist = 0;
        mMINpoisonResist = 0;
        mMAXpoisonResist = 0;
        mixCost = 0;
        agingCost = 0;

        lucidy = 0;
        sereneo = 0;
        fadeo = 0;
        sparky = 0;
        raident = 0;
        transparo = 0;
        murky = 0;
        devine = 0;
        celesto = 0;
        mirage = 0;
        inferna = 0;
        enigma = 0;
        bellum = 0;
        oredo = 0;
        sapphire = 0;
        sol = 0;
    }

    public void addAging(int agingLevel) {
        zerarValoresModificados();
        this.agingLevel = agingLevel;

        switch (itemType) {
            case "Sword":
            case "Scythe":
            case "Claw":
            case "Dagger":
                for (int i = 1; i <= agingLevel; i++) {
                    calcularPrecoAging(i);
                    if (i <= 9) {
                        mMINAtkMin += 1;
                        mMAXAtkMin += 1;
                        mMINAtkMax += 1;
                        mMAXAtkMax += 1;
                        mCritChance += 0.5f;
                        mMINAtkRtg += 5;
                        mMAXAtkRtg += 5;
                    } else if (i > 9 && i <= 19) {
                        mMINAtkMin += 2;
                        mMAXAtkMin += 2;
                        mMINAtkMax += 2;
                        mMAXAtkMax += 2;
                        mCritChance += 0.5f;
                        mMINAtkRtg += 5;
                        mMAXAtkRtg += 5;
                    } else if (i >= 20) {
                        mMINAtkMin += 3;
                        mMAXAtkMin += 3;
                        mMINAtkMax += 3;
                        mMAXAtkMax += 3;
                        mCritChance += 0.5f;
                        mMINAtkRtg += 5;
                        mMAXAtkRtg += 5;
                    }

                }
                mCritChance = (float) Math.floor(mCritChance);
                break;
            case "Axe":
                for (int i = 1; i <= agingLevel; i++) {
                    calcularPrecoAging(i);
                    if (i <= 9) {
                        mMINAtkMin += 1;
                        mMAXAtkMin += 1;
                        mMINAtkMax += 1;
                        mMAXAtkMax += 1;
                        mMINAtkRtg += 10;
                        mMAXAtkRtg += 10;
                    } else if (i > 9 && i <= 19) {
                        mMINAtkMin += 2;
                        mMAXAtkMin += 2;
                        mMINAtkMax += 2;
                        mMAXAtkMax += 2;
                        mMINAtkRtg += 10;
                        mMAXAtkRtg += 10;
                    } else if (i >= 20) {
                        mMINAtkMin += 3;
                        mMAXAtkMin += 3;
                        mMINAtkMax += 3;
                        mMAXAtkMax += 3;
                        mMINAtkRtg += 10;
                        mMAXAtkRtg += 10;
                    }

                }
                break;
            case "Hammer":
                for (int i = 1; i <= agingLevel; i++) {
                    calcularPrecoAging(i);
                    if (i <= 9) {
                        mMINAtkMin += 1;
                        mMAXAtkMin += 1;
                        mMINAtkMax += 1;
                        mMAXAtkMax += 1;
                        mCritChance += 0.3f;
                        mMINAtkRtg += 8;
                        mMAXAtkRtg += 8;
                    } else if (i > 9 && i <= 19) {
                        mMINAtkMin += 2;
                        mMAXAtkMin += 2;
                        mMINAtkMax += 2;
                        mMAXAtkMax += 2;
                        mCritChance += 0.3f;
                        mMINAtkRtg += 8;
                        mMAXAtkRtg += 8;
                    } else if (i >= 20) {
                        mMINAtkMin += 3;
                        mMAXAtkMin += 3;
                        mMINAtkMax += 3;
                        mMAXAtkMax += 3;
                        mCritChance += 0.3f;
                        mMINAtkRtg += 8;
                        mMAXAtkRtg += 8;
                    }

                }
                mCritChance = (float) Math.floor(mCritChance);
                break;
            case "Bow":
            case "Javelin":
                for (int i = 1; i <= agingLevel; i++) {
                    calcularPrecoAging(i);
                    if (i <= 9) {
                        mMINAtkMin += 1;
                        mMAXAtkMin += 1;
                        mMINAtkMax += 1;
                        mMAXAtkMax += 1;
                        mCritChance += 0.5f;
                    } else if (i > 9 && i <= 19) {
                        mMINAtkMin += 2;
                        mMAXAtkMin += 2;
                        mMINAtkMax += 2;
                        mMAXAtkMax += 2;
                        mCritChance += 0.5f;
                    } else if (i >= 20) {
                        mMINAtkMin += 3;
                        mMAXAtkMin += 3;
                        mMINAtkMax += 3;
                        mMAXAtkMax += 3;
                        mCritChance += 0.5f;
                    }

                }
                mCritChance = (float) Math.floor(mCritChance);
                break;
            case "Wand":
            case "Staff":
            case "Phantom":
                for (int i = 1; i <= agingLevel; i++) {
                    calcularPrecoAging(i);
                    if (i <= 9) {
                        mMINAtkMin += 1;
                        mMAXAtkMin += 1;
                        mMINAtkMax += 1;
                        mMAXAtkMax += 1;
                        mCritChance += 0.3f;
                        mMINAtkRtg += 10;
                        mMAXAtkRtg += 10;
                        mMINmp += 10;
                        mMAXmp += 10;
                    } else if (i > 9 && i <= 19) {
                        mMINAtkMin += 2;
                        mMAXAtkMin += 2;
                        mMINAtkMax += 2;
                        mMAXAtkMax += 2;
                        mCritChance += 0.3f;
                        mMINAtkRtg += 10;
                        mMAXAtkRtg += 10;
                        mMINmp += 10;
                        mMAXmp += 10;
                    } else if (i >= 20) {
                        mMINAtkMin += 3;
                        mMAXAtkMin += 3;
                        mMINAtkMax += 3;
                        mMAXAtkMax += 3;
                        mCritChance += 0.3f;
                        mMINAtkRtg += 10;
                        mMAXAtkRtg += 10;
                        mMINmp += 10;
                        mMAXmp += 10;
                    }

                }
                mCritChance = (float) Math.floor(mCritChance);
                break;
            case "Armor":
            case "Robe":
                for (int i = 1; i <= agingLevel; i++) {
                    calcularPrecoAging(i);
                    if (i <= 9) {
                        mMINdefense += (MINdefense + mMINdefense) * 0.05f;
                        mMAXdefense += (MAXdefense + mMAXdefense) * 0.05f;
                        mMINabs += 0.5f;
                        mMAXabs += 0.5f;
                    } else if (i > 9 && i <= 19) {
                        mMINdefense += (MINdefense + mMINdefense) * 0.05f;
                        mMAXdefense += (MAXdefense + mMAXdefense) * 0.05f;
                        mMINabs += 1f;
                        mMAXabs += 1f;
                    } else if (i >= 20) {
                        mMINdefense += (MINdefense + mMINdefense) * 0.05f;
                        mMAXdefense += (MAXdefense + mMAXdefense) * 0.05f;
                        mMINabs += 1.5f;
                        mMAXabs += 1.5f;
                    }

                    mMINdefense = (float) Math.floor(mMINdefense);
                    mMAXdefense = (float) Math.floor(mMAXdefense);
                }
                break;
            case "Shield":
                for (int i = 1; i <= agingLevel; i++) {
                    calcularPrecoAging(i);
                    if (i <= 9) {
                        mMINdefense += 10;
                        mMAXdefense += 10;
                        mMINblock += 0.5f;
                        mMAXblock += 0.5f;
                        mMINabs += 0.4f;
                        mMAXabs += 0.4f;
                    } else if (i > 9 && i <= 19) {
                        mMINdefense += 20;
                        mMAXdefense += 20;
                        mMINblock += 0.5f;
                        mMAXblock += 0.5f;
                        mMINabs += 0.8f;
                        mMAXabs += 0.8f;
                    } else if (i >= 20) {
                        mMINdefense += 30;
                        mMAXdefense += 30;
                        mMINblock += 0.5f;
                        mMAXblock += 0.5f;
                        mMINabs += 1.2f;
                        mMAXabs += 1.2f;
                    }

                }
                break;
            case "Orb":
                for (int i = 1; i <= agingLevel; i++) {
                    calcularPrecoAging(i);
                    if (i <= 9) {
                        mMINdefense += (MINdefense + mMINdefense) * 0.1f;
                        mMAXdefense += (MAXdefense + mMAXdefense) * 0.1f;
                        mMINabs += 0.5f;
                        mMAXabs += 0.5f;
                    } else if (i > 9 && i <= 19) {
                        mMINdefense += (MINdefense + mMINdefense) * 0.1f;
                        mMAXdefense += (MAXdefense + mMAXdefense) * 0.1f;
                        mMINabs += 1f;
                        mMAXabs += 1f;
                    } else if (i >= 20) {
                        mMINdefense += (MINdefense + mMINdefense) * 0.1f;
                        mMAXdefense += (MAXdefense + mMAXdefense) * 0.1f;
                        mMINabs += 1.5f;
                        mMAXabs += 1.5f;
                    }

                    mMINdefense = (float) Math.floor(mMINdefense);
                    mMAXdefense = (float) Math.floor(mMAXdefense);
                }
                break;
            default:
                break;
        }

        if (agingLevel > 0) {
            itemAged = true;
        } else {
            itemAged = false;
        }
        for (int i = 0; i <= agingLevel; i++) {
            switch (i) {
                case 0:
                    break;
                case 1:
                    lucidy += 2;
                    sereneo += 2;
                    fadeo += 2;
                    sparky += 2;
                    raident += 1;
                    break;
                case 2:
                    lucidy += 2;
                    sereneo += 2;
                    fadeo += 2;
                    sparky += 2;
                    raident += 2;
                    break;
                case 3:
                    mLvl = 1;
                    lucidy += 2;
                    sereneo += 2;
                    fadeo += 2;
                    sparky += 2;
                    raident += 2;
                    transparo += 1;
                    break;
                case 4:
                    mLvl = 1;
                    lucidy += 2;
                    sereneo += 2;
                    fadeo += 2;
                    sparky += 2;
                    raident += 2;
                    transparo += 2;
                    break;
                case 5:
                    mLvl = 1;
                    lucidy += 2;
                    sereneo += 2;
                    fadeo += 2;
                    sparky += 2;
                    raident += 2;
                    transparo += 2;
                    murky += 1;
                    break;
                case 6:
                    mLvl = 2;
                    lucidy += 2;
                    sereneo += 2;
                    fadeo += 2;
                    sparky += 2;
                    raident += 2;
                    transparo += 2;
                    murky += 2;
                    break;
                case 7:
                    mLvl = 2;
                    lucidy += 2;
                    sereneo += 2;
                    fadeo += 2;
                    sparky += 2;
                    raident += 2;
                    transparo += 2;
                    murky += 2;
                    devine += 1;
                    break;
                case 8:
                    mLvl = 2;
                    lucidy += 2;
                    sereneo += 2;
                    fadeo += 2;
                    sparky += 2;
                    raident += 2;
                    transparo += 2;
                    murky += 2;
                    devine += 2;
                    break;
                case 9:
                    mLvl = 3;
                    sereneo += 2;
                    fadeo += 2;
                    sparky += 2;
                    raident += 2;
                    transparo += 2;
                    murky += 2;
                    devine += 2;
                    celesto += 1;
                    break;
                case 10:
                    mLvl = 3;
                    sereneo += 2;
                    fadeo += 2;
                    sparky += 2;
                    raident += 2;
                    transparo += 2;
                    murky += 2;
                    devine += 2;
                    celesto += 2;
                    break;
                case 11:
                    mLvl = 3;
                    fadeo += 2;
                    sparky += 2;
                    raident += 2;
                    transparo += 2;
                    murky += 2;
                    devine += 2;
                    celesto += 2;
                    mirage += 1;
                    break;
                case 12:
                    mLvl = 4;
                    fadeo += 2;
                    sparky += 2;
                    raident += 2;
                    transparo += 2;
                    murky += 2;
                    devine += 2;
                    celesto += 2;
                    mirage += 2;
                    break;
                case 13:
                    mLvl = 4;
                    sparky += 2;
                    raident += 2;
                    transparo += 2;
                    murky += 2;
                    devine += 2;
                    celesto += 2;
                    mirage += 2;
                    inferna += 1;
                    break;
                case 14:
                    mLvl = 4;
                    sparky += 2;
                    raident += 2;
                    transparo += 2;
                    murky += 2;
                    devine += 2;
                    celesto += 2;
                    mirage += 2;
                    inferna += 2;
                    break;
                case 15:
                    mLvl = 5;
                    raident += 2;
                    transparo += 2;
                    murky += 2;
                    devine += 2;
                    celesto += 2;
                    mirage += 2;
                    inferna += 2;
                    enigma += 1;
                    break;
                case 16:
                    mLvl = 5;
                    raident += 2;
                    transparo += 2;
                    murky += 2;
                    devine += 2;
                    celesto += 2;
                    mirage += 2;
                    inferna += 2;
                    enigma += 2;
                    break;
                case 17:
                    mLvl = 5;
                    transparo += 2;
                    murky += 2;
                    devine += 2;
                    celesto += 2;
                    mirage += 2;
                    inferna += 2;
                    enigma += 2;
                    bellum += 1;
                    break;
                case 18:
                    mLvl = 6;
                    transparo += 2;
                    murky += 2;
                    devine += 2;
                    celesto += 2;
                    mirage += 2;
                    inferna += 2;
                    enigma += 2;
                    bellum += 2;
                    break;
                case 19:
                    mLvl = 6;
                    murky += 2;
                    devine += 2;
                    celesto += 2;
                    mirage += 2;
                    inferna += 2;
                    enigma += 2;
                    bellum += 2;
                    oredo += 1;
                    break;
                case 20:
                    mLvl = 6;
                    murky += 2;
                    devine += 2;
                    celesto += 2;
                    mirage += 2;
                    inferna += 2;
                    enigma += 2;
                    bellum += 2;
                    oredo += 2;
                    break;
                case 21:
                    mLvl = 7;
                    devine += 2;
                    celesto += 2;
                    mirage += 2;
                    inferna += 2;
                    enigma += 2;
                    bellum += 2;
                    oredo += 2;
                    sapphire += 1;
                    break;
                case 22:
                    mLvl = 7;
                    devine += 2;
                    celesto += 2;
                    mirage += 2;
                    inferna += 2;
                    enigma += 2;
                    bellum += 2;
                    oredo += 2;
                    sapphire += 2;
                    break;
                case 23:
                    mLvl = 7;
                    celesto += 2;
                    mirage += 2;
                    inferna += 2;
                    enigma += 2;
                    bellum += 2;
                    oredo += 2;
                    sapphire += 2;
                    sol += 1;
                    break;
                case 24:
                    mLvl = 8;
                    celesto += 2;
                    mirage += 2;
                    inferna += 2;
                    enigma += 2;
                    bellum += 2;
                    oredo += 2;
                    sapphire += 2;
                    sol += 2;
                    break;
            }
        }
        calcularPrecoTotalAging();
    }

    private void calcularPrecoTotalAging() {
        totalAgingCost = 0;
        for (int i = 0; i <= agingLevel; i++) {
            totalAgingCost += calcularPrecoAging(i);
        }
    }

    private double calcularPrecoAging(int nvlAge) {
        double auxPrice = 0;
        agingCost = 0;
        if (selectedSpec == "No Spec") {
            auxPrice = price;
        } else {
            specPrice = price * 1.10;
            auxPrice = specPrice;
        }
        float priceMultiplier = 0.5f * nvlAge;
        if (nvlAge >= 1 && nvlAge <= 4) {
            agingCost = (auxPrice * priceMultiplier);
        } else if (nvlAge >= 5 && nvlAge <= 9) {
            agingCost = (auxPrice * priceMultiplier) * 2;
        } else if (nvlAge >= 10 && nvlAge <= 14) {
            agingCost = (auxPrice * priceMultiplier) * 3;
        } else if (nvlAge >= 15 && nvlAge <= 19) {
            agingCost = (auxPrice * priceMultiplier) * 4;
        } else if (nvlAge >= 20 && nvlAge <= 24) {
            agingCost = (auxPrice * priceMultiplier) * 5;
        } else if (nvlAge >= 25 && nvlAge <= 29) {
            agingCost = (auxPrice * priceMultiplier) * 6;
        } else if (nvlAge >= 30 && nvlAge <= 34) {
            agingCost = (auxPrice * priceMultiplier) * 7;
        } else if (nvlAge >= 35 && nvlAge <= 39) {
            agingCost = (auxPrice * priceMultiplier) * 8;
        } else if (nvlAge >= 40 && nvlAge <= 44) {
            agingCost = (auxPrice * priceMultiplier) * 9;
        } else if (nvlAge >= 45 && nvlAge <= 49) {
            agingCost = (auxPrice * priceMultiplier) * 10;
        } else if (nvlAge >= 50 && nvlAge <= 59) {
            agingCost = (auxPrice * priceMultiplier) * 11;
        } else if (nvlAge >= 60 && nvlAge <= 64) {
            agingCost = (auxPrice * priceMultiplier) * 12;
        } else if (nvlAge >= 65 && nvlAge <= 69) {
            agingCost = (auxPrice * priceMultiplier) * 13;
        } else if (nvlAge >= 70 && nvlAge <= 74) {
            agingCost = (auxPrice * priceMultiplier) * 14;
        } else if (nvlAge >= 75 && nvlAge <= 79) {
            agingCost = (auxPrice * priceMultiplier) * 15;
        } else if (nvlAge >= 80 && nvlAge <= 84) {
            agingCost = (auxPrice * priceMultiplier) * 16;
        } else if (nvlAge >= 85 && nvlAge <= 89) {
            agingCost = (auxPrice * priceMultiplier) * 17;
        } else if (nvlAge >= 90 && nvlAge <= 94) {
            agingCost = (auxPrice * priceMultiplier) * 18;
        } else if (nvlAge >= 95 && nvlAge <= 99) {
            agingCost = (auxPrice * priceMultiplier) * 19;
        } else if (nvlAge >= 100 && nvlAge <= 104) {
            agingCost = (auxPrice * priceMultiplier) * 20;
        }
        return agingCost;
    }

    public void addMix(String item, String mixName) {
        zerarValoresModificados();
        if (mixName == "No mix") {

        } else {
            itemMix = mixName;
            switch (item) {
                case "Weapon":
                    switch (mixName) {
                        case "Transparo Critical Mix":

                            mMINAtkMin = 3;
                            mMAXAtkMin = 3;

                            mMINAtkMax = 4;
                            mMAXAtkMax = 4;

                            mCritChance = 1;

                            fadeo = 1;
                            raident = 3;
                            transparo = 5;
                            break;
                        case "Murky Dexterity Mix":

                            mMINAtkMax = 6;
                            mMAXAtkMax = 6;

                            mMINAtkRtg = 45;
                            mMAXAtkRtg = 45;

                            mMINhp = 10;
                            mMAXhp = 10;

                            fadeo = 1;
                            sparky = 1;
                            transparo = 3;
                            murky = 4;
                            break;

                        case "Murky Critical Mix":

                            mMINAtkMin = 4;
                            mMAXAtkMin = 4;

                            mMINAtkMax = 5;
                            mMAXAtkMax = 5;

                            mCritChance = 2;

                            sparky = 2;
                            transparo = 2;
                            murky = 5;
                            break;

                        case "Devine Dexterity Mix":
                            mMINAtkMin = 4;
                            mMAXAtkMin = 4;

                            mMINAtkMax = 7;
                            mMAXAtkMax = 7;

                            mMINAtkRtg = 55;
                            mMAXAtkRtg = 55;

                            mMINhp = 15;
                            mMAXhp = 15;

                            transparo = 1;
                            murky = 4;
                            devine = 3;
                            break;

                        case "Devine Critical Mix":

                            mMINAtkMin = 5;
                            mMAXAtkMin = 5;
                            mMINAtkMax = 6;
                            mMAXAtkMax = 6;
                            mCritChance = 2;

                            transparo = 1;
                            murky = 3;
                            devine = 4;
                            break;

                        case "Celesto Dexterity Mix":
                            mMINAtkMin = 5;
                            mMAXAtkMin = 5;

                            mMINAtkMax = 9;
                            mMAXAtkMax = 9;

                            mMINAtkRtg = 75;
                            mMAXAtkRtg = 75;

                            mMINhp = 20;
                            mMAXhp = 20;

                            raident = 1;
                            transparo = 1;
                            murky = 2;
                            celesto = 2;
                            break;

                        case "Celesto Critical Mix #1":

                            mMINAtkMin = 8;
                            mMAXAtkMin = 8;

                            mMINAtkMax = 8;
                            mMAXAtkMax = 8;

                            mCritChance = 3;

                            mMINmp = 20;
                            mMAXmp = 20;

                            murky = 4;
                            devine = 1;
                            celesto = 3;
                            break;

                        case "Celesto Critical Mix #2":

                            mMINAtkMin = 8;
                            mMAXAtkMin = 8;

                            mMINAtkMax = 8;
                            mMAXAtkMax = 8;

                            mCritChance = 2;

                            mMINhp = 20;
                            mMAXhp = 20;

                            murky = 4;
                            devine = 2;
                            celesto = 4;
                            break;

                        case "Mirage Dexterity Mix":
                            mMINAtkMin = 6;
                            mMAXAtkMin = 6;

                            mMINAtkMax = 11;
                            mMAXAtkMax = 11;

                            mMINAtkRtg = 90;
                            mMAXAtkRtg = 90;

                            mMINhp = 20;
                            mMAXhp = 20;

                            raident = 2;
                            murky = 3;
                            devine = 1;
                            celesto = 1;
                            mirage = 2;
                            break;

                        case "Mirage Critical Mix #1":

                            mMINAtkMin = 8;
                            mMAXAtkMin = 8;

                            mMINAtkMax = 10;
                            mMAXAtkMax = 10;

                            mCritChance = 3;

                            mMINmp = 25;
                            mMAXmp = 25;

                            transparo = 3;
                            devine = 2;
                            celesto = 2;
                            mirage = 4;
                            break;

                        case "Mirage Critical Mix #2":

                            mMINAtkMin = 8;
                            mMAXAtkMin = 8;

                            mMINAtkMax = 10;
                            mMAXAtkMax = 10;

                            mCritChance = 2;

                            mMINhp = 20;
                            mMAXhp = 20;

                            murky = 1;
                            devine = 1;
                            celesto = 3;
                            mirage = 5;
                            break;

                        case "Inferna Dexterity Mix":
                            mMINAtkMin = 8;
                            mMAXAtkMin = 8;

                            mMINAtkMax = 13;
                            mMAXAtkMax = 13;

                            mMINAtkRtg = 100;
                            mMAXAtkRtg = 100;

                            mMINhp = 25;
                            mMAXhp = 25;

                            devine = 1;
                            celesto = 1;
                            mirage = 4;
                            inferna = 3;
                            break;

                        case "Inferna Critical Mix #1":

                            mMINAtkMin = 10;
                            mMAXAtkMin = 10;

                            mMINAtkMax = 12;
                            mMAXAtkMax = 12;

                            mCritChance = 4;

                            mMINmp = 25;
                            mMAXmp = 25;

                            murky = 2;
                            devine = 1;
                            mirage = 2;
                            inferna = 4;
                            break;

                        case "Inferna Critical Mix #2":

                            mMINAtkMin = 10;
                            mMAXAtkMin = 10;

                            mMINAtkMax = 12;
                            mMAXAtkMax = 12;

                            mCritChance = 3;

                            mMINhp = 25;
                            mMAXhp = 25;

                            murky = 2;
                            celesto = 1;
                            mirage = 2;
                            inferna = 5;
                            break;

                        case "Enigma Dexterity Mix":
                            mMINAtkMin = 10;
                            mMAXAtkMin = 10;

                            mMINAtkMax = 15;
                            mMAXAtkMax = 15;

                            mMINAtkRtg = 115;
                            mMAXAtkRtg = 115;

                            mMINhp = 25;
                            mMAXhp = 25;

                            devine = 1;
                            celesto = 1;
                            mirage = 1;
                            inferna = 2;
                            enigma = 4;
                            break;

                        case "Enigma Critical Mix #1":

                            mMINAtkMin = 12;
                            mMAXAtkMin = 12;

                            mMINAtkMax = 14;
                            mMAXAtkMax = 14;

                            mCritChance = 4;

                            mMINmp = 30;
                            mMAXmp = 30;

                            raident = 1;
                            transparo = 1;
                            mirage = 3;
                            inferna = 2;
                            enigma = 5;
                            break;

                        case "Enigma Critical Mix #2":

                            mMINAtkMin = 12;
                            mMAXAtkMin = 12;

                            mMINAtkMax = 14;
                            mMAXAtkMax = 14;

                            mCritChance = 3;

                            mMINhp = 25;
                            mMAXhp = 25;

                            devine = 1;
                            mirage = 3;
                            inferna = 3;
                            enigma = 5;
                            break;

                        case "Bellum Dexterity Mix":
                            mMINAtkMin = 12;
                            mMAXAtkMin = 12;

                            mMINAtkMax = 17;
                            mMAXAtkMax = 17;

                            mMINAtkRtg = 130;
                            mMAXAtkRtg = 130;

                            mMINhp = 30;
                            mMAXhp = 30;

                            celesto = 3;
                            mirage = 1;
                            inferna = 2;
                            enigma = 3;
                            bellum = 3;
                            break;

                        case "Bellum Critical Mix #1":

                            mMINAtkMin = 14;
                            mMAXAtkMin = 14;

                            mMINAtkMax = 16;
                            mMAXAtkMax = 16;

                            mCritChance = 5;

                            mMINmp = 30;
                            mMAXmp = 30;

                            mirage = 2;
                            inferna = 2;
                            enigma = 2;
                            bellum = 5;
                            break;

                        case "Bellum Critical Mix #2":

                            mMINAtkMin = 14;
                            mMAXAtkMin = 14;

                            mMINAtkMax = 16;
                            mMAXAtkMax = 16;

                            mCritChance = 4;

                            mMINhp = 30;
                            mMAXhp = 30;

                            mirage = 1;
                            inferna = 2;
                            enigma = 3;
                            bellum = 6;
                            break;

                        case "Oredo Dexterity Mix":
                            mMINAtkMin = 14;
                            mMAXAtkMin = 14;

                            mMINAtkMax = 19;
                            mMAXAtkMax = 19;

                            mMINAtkRtg = 150;
                            mMAXAtkRtg = 150;

                            mMINhp = 30;
                            mMAXhp = 30;

                            inferna = 2;
                            enigma = 2;
                            bellum = 6;
                            celesto = 2;
                            break;

                        case "Oredo Critical Mix #1":

                            mMINAtkMin = 16;
                            mMAXAtkMin = 16;

                            mMINAtkMax = 18;
                            mMAXAtkMax = 18;

                            mCritChance = 5;

                            mMINmp = 40;
                            mMAXmp = 40;

                            mirage = 1;
                            enigma = 2;
                            bellum = 3;
                            oredo = 6;
                            break;

                        case "Oredo Critical Mix #2":

                            mMINAtkMin = 16;
                            mMAXAtkMin = 16;

                            mMINAtkMax = 18;
                            mMAXAtkMax = 18;

                            mCritChance = 4;

                            mMINhp = 35;
                            mMAXhp = 35;

                            inferna = 1;
                            enigma = 1;
                            bellum = 4;
                            oredo = 6;
                            break;

                        case "Sapphire Dexterity Mix":
                            mMINAtkMin = 17;
                            mMAXAtkMin = 17;

                            mMINAtkMax = 22;
                            mMAXAtkMax = 22;

                            mMINAtkRtg = 180;
                            mMAXAtkRtg = 180;

                            mMINhp = 40;
                            mMAXhp = 40;

                            enigma = 2;
                            bellum = 2;
                            oredo = 4;
                            sapphire = 4;
                            break;

                        case "Sapphire Critical Mix #1":
                            mMINAtkMin = 19;
                            mMAXAtkMin = 19;

                            mMINAtkMax = 21;
                            mMAXAtkMax = 21;

                            mCritChance = 7;

                            mMINmp = 50;
                            mMAXmp = 50;

                            enigma = 2;
                            bellum = 1;
                            oredo = 4;
                            sapphire = 5;
                            break;

                        case "Sapphire Critical Mix #2":
                            mMINAtkMin = 19;
                            mMAXAtkMin = 19;

                            mMINAtkMax = 21;
                            mMAXAtkMax = 21;

                            mCritChance = 5;

                            mMINhp = 40;
                            mMAXhp = 40;

                            enigma = 1;
                            bellum = 3;
                            oredo = 2;
                            sapphire = 6;
                            break;

                        case "Sapphire Vigor Mix":
                            mMINAtkMin = 26;
                            mMAXAtkMin = 26;

                            mMINAtkMax = 26;
                            mMAXAtkMax = 26;

                            mMINmp = 25;
                            mMAXmp = 25;

                            bellum = 2;
                            oredo = 2;
                            sapphire = 8;
                            break;

                        case "Sapphire Swiftness Mix":
                            mAtkSpd = 1;

                            mMINAtkRtg = 150;
                            mMAXAtkRtg = 150;

                            mCritChance = 6;

                            mMINmp = 100;
                            mMAXmp = 100;

                            oredo = 3;
                            sapphire = 9;
                            break;

                        case "Sol Dexterity Mix":
                            mMINAtkMin = 20;
                            mMAXAtkMin = 20;

                            mMINAtkMax = 25;
                            mMAXAtkMax = 25;

                            mMINAtkRtg = 210;
                            mMAXAtkRtg = 210;

                            mMINhp = 50;
                            mMAXhp = 50;

                            oredo = 2;
                            sapphire = 4;
                            sol = 6;
                            break;

                        case "Sol Critical Mix #1":
                            mMINAtkMin = 22;
                            mMAXAtkMin = 22;

                            mMINAtkMax = 24;
                            mMAXAtkMax = 24;

                            mCritChance = 9;

                            mMINmp = 60;
                            mMAXmp = 60;

                            oredo = 1;
                            sapphire = 4;
                            sol = 7;
                            break;

                        case "Sol Critical Mix #2":
                            mMINAtkMin = 22;
                            mMAXAtkMin = 22;

                            mMINAtkMax = 24;
                            mMAXAtkMax = 24;

                            mCritChance = 7;

                            mMINhp = 45;
                            mMAXhp = 45;

                            oredo = 2;
                            sapphire = 2;
                            sol = 8;
                            break;

                        case "Sol Vigor Mix":
                            mMINAtkMin = 29;
                            mMAXAtkMin = 29;

                            mMINAtkMax = 29;
                            mMAXAtkMax = 29;

                            mMINmp = 35;
                            mMAXmp = 35;

                            sol = 9;
                            sapphire = 2;
                            oredo = 1;
                            break;

                        case "Sol Swiftness Mix":
                            mAtkSpd = 1;

                            mMINAtkRtg = 170;
                            mMAXAtkRtg = 170;

                            mCritChance = 8;

                            mMINmp = 120;
                            mMAXmp = 120;

                            sapphire = 3;
                            sol = 9;
                            break;
                    }
                    break;

                case "Armor":
                case "Robe":
                    switch (mixName) {
                        case "Transparo Fortitude Mix":
                            mMINmp = 10;
                            mMAXmp = 10;

                            mMINdefense = 50;
                            mMAXdefense = 50;

                            mMINabs = 1;
                            mMAXabs = 1;

                            sparky = 4;
                            raident = 1;
                            transparo = 3;
                            break;

                        case "Transparo Vitality Mix":
                            mMINhp = 8;
                            mMAXhp = 8;

                            mMINdefense = 20;
                            mMAXdefense = 20;

                            mMINabs = 0.6f;
                            mMAXabs = 0.6f;

                            sparky = 4;
                            raident = 2;
                            transparo = 4;
                            break;

                        case "Murky Fortitude Mix":
                            mMINmp = 15;
                            mMAXmp = 15;

                            mMINdefense = 75;
                            mMAXdefense = 75;

                            mMINabs = 2;
                            mMAXabs = 2;

                            raident = 1;
                            transparo = 5;
                            murky = 3;
                            break;

                        case "Murky Vitality Mix":
                            mMINhp = 8;
                            mMAXhp = 8;

                            mMINdefense = 30;
                            mMAXdefense = 30;

                            mMINabs = 1;
                            mMAXabs = 1;

                            raident = 4;
                            transparo = 1;
                            murky = 5;
                            break;

                        case "Devine Fortitude Mix":
                            mMINmp = 20;
                            mMAXmp = 20;

                            mMINdefense = 100;
                            mMAXdefense = 100;

                            mMINabs = 3;
                            mMAXabs = 3;

                            transparo = 1;
                            murky = 4;
                            devine = 3;
                            break;

                        case "Devine Vitality Mix":
                            mMINhp = 25;
                            mMAXhp = 25;

                            mMINdefense = 10;
                            mMAXdefense = 10;

                            murky = 4;
                            devine = 4;
                            break;

                        case "Celesto Fortitude Mix":
                            mMINmp = 30;
                            mMAXmp = 30;

                            mMINdefense = 150;
                            mMAXdefense = 150;

                            mMINabs = 3.5f;
                            mMAXabs = 3.5f;

                            murky = 2;
                            devine = 3;
                            celesto = 3;
                            break;

                        case "Celesto Vitality Mix":
                            mMINhp = 10;
                            mMAXhp = 10;

                            mMINdefense = 50;
                            mMAXdefense = 50;

                            mMINabs = 2;
                            mMAXabs = 2;

                            murky = 1;
                            enigma = 2;
                            celesto = 4;
                            break;

                        case "Mirage Fortitude Mix":
                            mMINmp = 50;
                            mMAXmp = 50;

                            mMINdefense = 200;
                            mMAXdefense = 200;

                            mMINabs = 4;
                            mMAXabs = 4;

                            devine = 2;
                            celesto = 2;
                            mirage = 3;
                            break;

                        case "Mirage Vitality Mix":
                            mMINhp = 15;
                            mMAXhp = 15;

                            mMINdefense = 75;
                            mMAXdefense = 75;

                            mMINabs = 2.5f;
                            mMAXabs = 2.5f;

                            devine = 3;
                            celesto = 2;
                            mirage = 4;
                            break;

                        case "Inferna Fortitude Mix":
                            mMINmp = 70;
                            mMAXmp = 70;

                            mMINdefense = 250;
                            mMAXdefense = 250;

                            mMINabs = 4.5f;
                            mMAXabs = 4.5f;

                            celesto = 2;
                            mirage = 5;
                            inferna = 3;
                            break;

                        case "Inferna Vitality Mix":
                            mMINhp = 25;
                            mMAXhp = 25;

                            mMINdefense = 100;
                            mMAXdefense = 100;

                            mMINabs = 3;
                            mMAXabs = 3;

                            celesto = 1;
                            inferna = 4;
                            mirage = 5;
                            break;

                        case "Enigma Fortitude Mix":
                            mMINmp = 90;
                            mMAXmp = 90;

                            mMINdefense = 300;
                            mMAXdefense = 300;

                            mMINabs = 5;
                            mMAXabs = 5;

                            mirage = 1;
                            inferna = 3;
                            enigma = 4;
                            break;

                        case "Enigma Vitality Mix":
                            mMINhp = 35;
                            mMAXhp = 35;

                            mMINdefense = 125;
                            mMAXdefense = 125;

                            mMINabs = 3.5f;
                            mMAXabs = 3.5f;

                            celesto = 2;
                            mirage = 1;
                            inferna = 3;
                            enigma = 6;
                            break;

                        case "Bellum Fortitude Mix":
                            mMINmp = 110;
                            mMAXmp = 110;

                            mMINdefense = 350;
                            mMAXdefense = 350;

                            mMINabs = 6;
                            mMAXabs = 6;

                            mirage = 1;
                            inferna = 2;
                            enigma = 2;
                            bellum = 4;
                            break;

                        case "Bellum Vitality Mix":
                            mMINhp = 45;
                            mMAXhp = 45;

                            mMINdefense = 150;
                            mMAXdefense = 150;

                            mMINabs = 4;
                            mMAXabs = 4;

                            mirage = 2;
                            inferna = 1;
                            enigma = 3;
                            bellum = 5;
                            break;

                        case "Oredo Fortitude Mix":
                            mMINmp = 130;
                            mMAXmp = 130;

                            mMINdefense = 400;
                            mMAXdefense = 400;

                            mMINabs = 7;
                            mMAXabs = 7;

                            inferna = 1;
                            enigma = 1;
                            bellum = 3;
                            oredo = 5;
                            break;

                        case "Oredo Vitality Mix":
                            mMINhp = 60;
                            mMAXhp = 60;

                            mMINdefense = 200;
                            mMAXdefense = 200;

                            mMINabs = 5;
                            mMAXabs = 5;

                            enigma = 1;
                            bellum = 4;
                            oredo = 7;
                            break;

                        case "Sapphire Fortitude Mix":
                            mMINmp = 150;
                            mMAXmp = 150;

                            mMINdefense = 450;
                            mMAXdefense = 450;

                            mMINabs = 8;
                            mMAXabs = 8;

                            inferna = 2;
                            enigma = 2;
                            oredo = 3;
                            sapphire = 5;
                            break;

                        case "Sapphire Vitality Mix":
                            mMINhp = 75;
                            mMAXhp = 75;

                            mMINdefense = 250;
                            mMAXdefense = 250;

                            mMINabs = 6;
                            mMAXabs = 6;

                            enigma = 1;
                            bellum = 2;
                            oredo = 3;
                            sapphire = 6;
                            break;

                        case "Sapphire Finesse Mix":
                            mMINhp = 80;
                            mMAXhp = 80;

                            mMINabs = 15;
                            mMAXabs = 15;

                            mMINorganicResist = 15;
                            mMINpoisonResist = 15;

                            mMINiceResist = 15;
                            mMINlightningResist = 15;

                            mMAXorganicResist = 15;
                            mMAXpoisonResist = 15;

                            mMAXiceResist = 15;
                            mMAXlightningResist = 15;

                            oredo = 2;
                            sapphire = 10;
                            break;

                        case "Sol Fortitude Mix":
                            mMINmp = 170;
                            mMAXmp = 170;

                            mMINdefense = 500;
                            mMAXdefense = 500;

                            mMINabs = 9f;
                            mMAXabs = 9f;

                            sol = 5;
                            sapphire = 3;
                            bellum = 2;
                            enigma = 2;
                            break;

                        case "Sol Vitality Mix":
                            mMINhp = 90;
                            mMAXhp = 90;

                            mMINdefense = 300;
                            mMAXdefense = 300;

                            mMINabs = 17f;
                            mMAXabs = 17f;

                            sol = 6;
                            sapphire = 3;
                            oredo = 2;
                            bellum = 1;
                            break;

                        case "Sol Finesse Mix":
                            mMINhp = 100;
                            mMAXhp = 100;

                            mMINabs = 17f;
                            mMAXabs = 17f;

                            mMINorganicResist = 17;
                            mMINpoisonResist = 17;

                            mMINiceResist = 17;
                            mMINlightningResist = 17;

                            mMAXorganicResist = 17;
                            mMAXpoisonResist = 17;

                            mMAXiceResist = 17;
                            mMAXlightningResist = 17;

                            sol = 10;
                            sapphire = 2;
                            break;
                    }
                    break;

                case "Shield":
                    switch (mixName) {
                        case "Transparo Vitality Mix":
                            mMINhp = 4;
                            mMAXhp = 4;

                            mMINdefense = 20;
                            mMAXdefense = 20;

                            mMINabs = 0.6f;
                            mMAXabs = 0.6f;

                            mMINblock = 1;
                            mMAXblock = 1;

                            sparky = 1;
                            raident = 1;
                            transparo = 5;
                            break;

                        case "Murky Vitality Mix":
                            mMINhp = 6;
                            mMAXhp = 6;

                            mMINdefense = 25;
                            mMAXdefense = 25;

                            mMINabs = 0.8f;
                            mMAXabs = 0.8f;

                            mMINblock = 1;
                            mMAXblock = 1;

                            transparo = 4;
                            murky = 6;
                            break;

                        case "Devine Vitality Mix":
                            mMINhp = 8;
                            mMAXhp = 8;

                            mMINdefense = 30;
                            mMAXdefense = 30;

                            mMINabs = 1;
                            mMAXabs = 1;

                            mMINblock = 2;
                            mMAXblock = 2;

                            transparo = 1;
                            murky = 2;
                            devine = 6;
                            break;

                        case "Celesto Vitality Mix #1":
                            mMINhp = 10;
                            mMAXhp = 10;

                            mMINdefense = 35;
                            mMAXdefense = 35;

                            mMINabs = 1.2f;
                            mMAXabs = 1.2f;

                            mMINblock = 2;
                            mMAXblock = 2;

                            murky = 1;
                            enigma = 2;
                            celesto = 5;
                            break;

                        case "Celesto Vitality Mix #2":
                            mMINhp = 15;
                            mMAXhp = 15;

                            mMINdefense = 45;
                            mMAXdefense = 45;

                            mMINabs = 1.6f;
                            mMAXabs = 1.6f;

                            mMINblock = 2;
                            mMAXblock = 2;

                            murky = 2;
                            devine = 3;
                            celesto = 6;
                            break;
                        case "Mirage Fortitude Mix":
                            mMINhp = 40;
                            mMAXhp = 40;

                            mMINdefense = 80;
                            mMAXdefense = 80;

                            mMINabs = 1;
                            mMAXabs = 1;

                            celesto = 2;
                            mirage = 3;
                            break;

                        case "Mirage Vitality Mix":
                            mMINhp = 25;
                            mMAXhp = 25;

                            mMINdefense = 50;
                            mMAXdefense = 50;

                            mMINabs = 1.8f;
                            mMAXabs = 1.8f;

                            mMINblock = 4;
                            mMAXblock = 4;

                            devine = 3;
                            celesto = 1;
                            mirage = 4;
                            break;

                        case "Inferna Fortitude Mix":
                            mMINhp = 40;
                            mMAXhp = 40;

                            mMINmp = 80;
                            mMAXmp = 80;

                            devine = 1;
                            celesto = 1;
                            mirage = 2;
                            inferna = 4;
                            break;

                        case "Inferna Vitality Mix":
                            mMINhp = 30;
                            mMAXhp = 30;

                            mMINdefense = 75;
                            mMAXdefense = 75;

                            mMINabs = 2.5f;
                            mMAXabs = 2.5f;

                            mMINblock = 4;
                            mMAXblock = 4;

                            devine = 1;
                            celesto = 1;
                            mirage = 2;
                            inferna = 5;
                            break;

                        case "Enigma Vitality Mix":
                            mMINhp = 30;
                            mMAXhp = 30;

                            mMINdefense = 100;
                            mMAXdefense = 100;

                            mMINabs = 3;
                            mMAXabs = 3;

                            mMINblock = 5;
                            mMAXblock = 5;

                            celesto = 2;
                            mirage = 3;
                            inferna = 2;
                            enigma = 2;
                            break;

                        case "Enigma Fortitude Mix":
                            mMINhp = 35;
                            mMAXhp = 35;

                            mMINmp = 10;
                            mMAXmp = 10;

                            mMINdefense = 100;
                            mMAXdefense = 100;

                            mMINabs = 2.8f;
                            mMAXabs = 2.8f;

                            mMINblock = 5;
                            mMAXblock = 5;

                            celesto = 3;
                            inferna = 2;
                            enigma = 3;
                            break;

                        case "Bellum Fortitude Mix":
                            mMINhp = 40;
                            mMAXhp = 40;

                            mMINmp = 10;
                            mMAXmp = 10;

                            mMINdefense = 120;
                            mMAXdefense = 120;

                            mMINabs = 2.4f;
                            mMAXabs = 2.4f;

                            mMINblock = 5;
                            mMAXblock = 5;

                            celesto = 1;
                            inferna = 3;
                            enigma = 4;
                            bellum = 2;
                            break;

                        case "Bellum Vitality Mix":
                            mMINhp = 45;
                            mMAXhp = 45;

                            mMINdefense = 150;
                            mMAXdefense = 150;

                            mMINabs = 4.6f;
                            mMAXabs = 4.6f;

                            mMINblock = 5;
                            mMAXblock = 5;

                            mirage = 3;
                            inferna = 2;
                            enigma = 2;
                            bellum = 5;
                            break;

                        case "Oredo Vitality Mix #1":
                            mMINhp = 50;
                            mMAXhp = 50;

                            mMINdefense = 175;
                            mMAXdefense = 175;

                            mMINabs = 5;
                            mMAXabs = 5;

                            mMINblock = 6;
                            mMAXblock = 6;

                            celesto = 1;
                            inferna = 1;
                            enigma = 2;
                            bellum = 3;
                            oredo = 3;
                            break;

                        case "Oredo Vitality Mix #2":
                            mMINhp = 60;
                            mMAXhp = 60;

                            mMINdefense = 200;
                            mMAXdefense = 200;

                            mMINabs = 5.4f;
                            mMAXabs = 5.4f;

                            mMINblock = 7;
                            mMAXblock = 7;

                            mirage = 1;
                            enigma = 1;
                            bellum = 4;
                            oredo = 6;
                            break;

                        case "Sapphire Vitality Mix #1":
                            mMINhp = 65;
                            mMAXhp = 65;

                            mMINdefense = 225;
                            mMAXdefense = 225;

                            mMINabs = 6;
                            mMAXabs = 6;

                            mMINblock = 7;
                            mMAXblock = 7;

                            inferna = 3;
                            enigma = 1;
                            bellum = 3;
                            oredo = 2;
                            sapphire = 3;
                            break;

                        case "Sapphire Vitality Mix #2":
                            mMINhp = 70;
                            mMAXhp = 70;

                            mMINdefense = 250;
                            mMAXdefense = 250;

                            mMINabs = 6.5f;
                            mMAXabs = 6.5f;

                            mMINblock = 8;
                            mMAXblock = 8;

                            bellum = 1;
                            oredo = 4;
                            sapphire = 7;
                            break;

                        case "Sapphire Block Mix":
                            mMINhp = 80;
                            mMAXhp = 80;

                            mMINblock = 12;
                            mMAXblock = 12;

                            oredo = 2;
                            sapphire = 10;
                            break;

                        case "Sol Vitality Mix #1":
                            mMINhp = 75;
                            mMAXhp = 75;

                            mMINdefense = 275;
                            mMAXdefense = 275;

                            mMINabs = 6.9f;
                            mMAXabs = 6.9f;

                            mMINblock = 8f;
                            mMAXblock = 8f;

                            sol = 5;
                            sapphire = 3;
                            oredo = 3;
                            bellum = 1;
                            break;

                        case "Sol Vitality Mix #2":
                            mMINhp = 80;
                            mMAXhp = 80;

                            mMINdefense = 300;
                            mMAXdefense = 300;

                            mMINabs = 7.3f;
                            mMAXabs = 7.3f;

                            mMINblock = 9f;
                            mMAXblock = 9f;

                            sol = 7;
                            sapphire = 4;
                            oredo = 1;
                            break;

                        case "Sol Block Mix":
                            mMINhp = 90;
                            mMAXhp = 90;

                            mMINblock = 14f;
                            mMAXblock = 14f;

                            sol = 10;
                            sapphire = 2;
                            break;

                    }
                    break;

                case "Orb":
                    switch (mixName) {
                        case "Transparo Vitality Mix":
                            mMINhp = 4;
                            mMAXhp = 4;

                            mMINdefense = 20;
                            mMAXdefense = 20;

                            mMINabs = 0.6f;
                            mMAXabs = 0.6f;

                            mMINblock = 1;
                            mMAXblock = 1;

                            fadeo = 2;
                            raident = 2;
                            transparo = 6;
                            break;

                        case "Murky Vitality Mix":
                            mMINhp = 6;
                            mMAXhp = 6;

                            mMINdefense = 30;
                            mMAXdefense = 30;

                            mMINabs = 1;
                            mMAXabs = 1;

                            mMINblock = 1;
                            mMAXblock = 1;

                            raident = 1;
                            transparo = 2;
                            murky = 5;
                            break;

                        case "Devine Vitality Mix":
                            mMINhp = 8;
                            mMAXhp = 8;

                            mMINdefense = 40;
                            mMAXdefense = 40;

                            mMINabs = 1.4f;
                            mMAXabs = 1.4f;

                            mMINblock = 1;
                            mMAXblock = 1;

                            transparo = 1;
                            murky = 2;
                            devine = 4;
                            break;

                        case "Celesto Vitality Mix":
                            mMINhp = 15;
                            mMAXhp = 15;

                            mMINdefense = 60;
                            mMAXdefense = 60;

                            mMINabs = 2;
                            mMAXabs = 2;

                            mMINblock = 1;
                            mMAXblock = 1;

                            murky = 2;
                            devine = 2;
                            celesto = 6;
                            break;

                        case "Mirage Vitality Mix":
                            mMINhp = 25;
                            mMAXhp = 25;

                            mMINdefense = 70;
                            mMAXdefense = 70;

                            mMINabs = 2.2f;
                            mMAXabs = 2.2f;

                            mMINblock = 1;
                            mMAXblock = 1;

                            devine = 3;
                            celesto = 2;
                            mirage = 4;
                            break;

                        case "Inferna Vitality Mix":
                            mMINhp = 30;
                            mMAXhp = 30;

                            mMINdefense = 95;
                            mMAXdefense = 95;

                            mMINabs = 2.8f;
                            mMAXabs = 2.8f;

                            mMINblock = 1;
                            mMAXblock = 1;

                            mirage = 5;
                            inferna = 7;
                            break;

                        case "Enigma Vitality Mix":
                            mMINhp = 35;
                            mMAXhp = 35;

                            mMINdefense = 120;
                            mMAXdefense = 120;

                            mMINabs = 3.6f;
                            mMAXabs = 3.6f;

                            mMINblock = 2;
                            mMAXblock = 2;

                            mirage = 1;
                            inferna = 3;
                            enigma = 7;
                            break;

                        case "Bellum Vitality Mix":
                            mMINhp = 45;
                            mMAXhp = 45;

                            mMINdefense = 170;
                            mMAXdefense = 170;

                            mMINabs = 6;
                            mMAXabs = 6;

                            mMINblock = 2;
                            mMAXblock = 2;

                            enigma = 2;
                            bellum = 7;
                            break;

                        case "Oredo Vitality Mix":
                            mMINhp = 60;
                            mMAXhp = 60;

                            mMINdefense = 220;
                            mMAXdefense = 220;

                            mMINabs = 7;
                            mMAXabs = 7;

                            mMINblock = 3;
                            mMAXblock = 3;

                            enigma = 1;
                            bellum = 3;
                            oredo = 7;
                            break;

                        case "Sapphire Fortitude Mix":
                            mMINmp = 200;
                            mMAXmp = 200;

                            mMINdefense = 270;
                            mMAXdefense = 270;

                            mMINabs = 8;
                            mMAXabs = 8;

                            mMINblock = 5;
                            mMAXblock = 5;

                            inferna = 2;
                            enigma = 2;
                            bellum = 3;
                            oredo = 2;
                            sapphire = 3;
                            break;

                        case "Sapphire Vitality Mix":
                            mMINhp = 80;
                            mMAXhp = 80;

                            mMINdefense = 270;
                            mMAXdefense = 270;

                            mMINabs = 8;
                            mMAXabs = 8;

                            mMINblock = 4;
                            mMAXblock = 4;

                            inferna = 2;
                            enigma = 2;
                            bellum = 2;
                            oredo = 3;
                            sapphire = 3;
                            break;

                        case "Sapphire Block Mix":
                            mMINhp = 130;
                            mMAXhp = 130;

                            mMINstm = 60;
                            mMAXstm = 50;

                            mMINblock = 10;
                            mMAXblock = 10;

                            oredo = 2;
                            sapphire = 10;
                            break;

                        case "Sol Fortitude Mix":
                            mMINmp = 250;
                            mMAXmp = 250;

                            mMINdefense = 320;
                            mMAXdefense = 320;

                            mMINabs = 9f;
                            mMAXabs = 9f;

                            mMINblock = 6f;
                            mMAXblock = 6f;

                            sol = 3;
                            sapphire = 2;
                            oredo = 3;
                            bellum = 2;
                            enigma = 2;
                            break;

                        case "Sol Vitality Mix":
                            mMINhp = 100;
                            mMAXhp = 100;

                            mMINdefense = 320;
                            mMAXdefense = 320;

                            mMINabs = 9f;
                            mMAXabs = 9f;

                            mMINblock = 5f;
                            mMAXblock = 5f;

                            sol = 3;
                            sapphire = 3;
                            oredo = 2;
                            bellum = 2;
                            enigma = 2;
                            break;

                        case "Sol Block Mix":
                            mMINhp = 150;
                            mMAXhp = 150;

                            mMINstm = 80;
                            mMAXstm = 80;

                            mMINblock = 12f;
                            mMAXblock = 12f;

                            sol = 10;
                            sapphire = 2;
                            break;
                    }
                    break;

                case "Bracelet":
                    switch (mixName) {
                        case "Devine Dexterity Mix":
                            mMINAtkRtg = 20;
                            mMINAtkRtg = 20;

                            mMINdefense = 20;
                            mMAXdefense = 20;

                            mMINmp = 15;
                            mMAXmp = 15;

                            mMINstm = 12;
                            mMAXstm = 12;

                            transparo = 2;
                            murky = 2;
                            devine = 6;
                            break;

                        case "Devine Vitality Mix":
                            mMINhp = 3;
                            mMAXhp = 3;

                            mMINdefense = 15;
                            mMAXdefense = 15;

                            mMINmp = 10;
                            mMAXmp = 10;

                            mMAXstm = 8;
                            mMAXstm = 8;

                            transparo = 1;
                            murky = 3;
                            devine = 6;
                            break;

                        case "Celesto Dexterity Mix":
                            mMINAtkRtg = 30;
                            mMINAtkRtg = 30;

                            mMINdefense = 25;
                            mMAXdefense = 25;

                            mMINmp = 20;
                            mMAXmp = 20;

                            mMINstm = 15;
                            mMAXstm = 15;

                            transparo = 1;
                            murky = 4;
                            devine = 3;
                            celesto = 4;
                            break;

                        case "Celesto Vitality Mix":
                            mMINhp = 5;
                            mMAXhp = 5;

                            mMINdefense = 20;
                            mMAXdefense = 20;

                            mMINmp = 15;
                            mMAXmp = 15;

                            mMAXstm = 10;
                            mMAXstm = 10;

                            transparo = 2;
                            murky = 2;
                            devine = 4;
                            celesto = 3;
                            break;

                        case "Mirage Dexterity Mix":
                            mMINAtkRtg = 50;
                            mMINAtkRtg = 50;

                            mMINdefense = 40;
                            mMAXdefense = 40;

                            mMINmp = 25;
                            mMAXmp = 25;

                            mMINstm = 25;
                            mMAXstm = 25;

                            devine = 2;
                            celesto = 5;
                            mirage = 5;
                            break;

                        case "Mirage Vitality Mix":
                            mMINhp = 10;
                            mMAXhp = 10;

                            mMINdefense = 30;
                            mMAXdefense = 30;

                            mMINmp = 20;
                            mMAXmp = 20;

                            mMAXstm = 20;
                            mMAXstm = 20;

                            transparo = 3;
                            devine = 1;
                            celesto = 3;
                            mirage = 5;
                            break;

                        case "Inferna Dexterity Mix":
                            mMINAtkRtg = 70;
                            mMINAtkRtg = 70;

                            mMINdefense = 55;
                            mMAXdefense = 55;

                            mMINmp = 30;
                            mMAXmp = 30;

                            mMINstm = 35;
                            mMAXstm = 35;

                            devine = 2;
                            celesto = 1;
                            mirage = 4;
                            inferna = 4;
                            break;

                        case "Inferna Vitality Mix":
                            mMINhp = 15;
                            mMAXhp = 15;

                            mMINdefense = 40;
                            mMAXdefense = 40;

                            mMINmp = 25;
                            mMAXmp = 25;

                            mMAXstm = 30;
                            mMAXstm = 30;

                            devine = 1;
                            celesto = 2;
                            mirage = 5;
                            inferna = 4;
                            break;

                        case "Enigma Dexterity Mix":
                            mMINAtkRtg = 90;
                            mMINAtkRtg = 90;

                            mMINdefense = 70;
                            mMAXdefense = 70;

                            mMINmp = 35;
                            mMAXmp = 35;

                            mMINstm = 45;
                            mMAXstm = 45;

                            celesto = 2;
                            mirage = 4;
                            inferna = 2;
                            enigma = 3;
                            break;

                        case "Enigma Vitality Mix":
                            mMINhp = 20;
                            mMAXhp = 20;

                            mMINdefense = 50;
                            mMAXdefense = 50;

                            mMINmp = 30;
                            mMAXmp = 30;

                            mMAXstm = 40;
                            mMAXstm = 40;

                            mirage = 3;
                            inferna = 5;
                            enigma = 4;
                            break;

                        case "Bellum Dexterity Mix":
                            mMINAtkRtg = 110;
                            mMINAtkRtg = 110;

                            mMINdefense = 95;
                            mMAXdefense = 95;

                            mMINmp = 40;
                            mMAXmp = 40;

                            mMINstm = 55;
                            mMAXstm = 55;

                            mirage = 1;
                            inferna = 2;
                            enigma = 3;
                            bellum = 5;
                            break;

                        case "Bellum Vitality Mix":
                            mMINhp = 25;
                            mMAXhp = 25;

                            mMINdefense = 60;
                            mMAXdefense = 60;

                            mMINmp = 35;
                            mMAXmp = 35;

                            mMAXstm = 50;
                            mMAXstm = 50;

                            inferna = 2;
                            enigma = 4;
                            bellum = 5;
                            break;

                        case "Oredo Dexterity Mix":
                            mMINAtkRtg = 130;
                            mMINAtkRtg = 130;

                            mMINdefense = 110;
                            mMAXdefense = 110;

                            mMINmp = 45;
                            mMAXmp = 45;

                            mMINstm = 65;
                            mMAXstm = 65;

                            enigma = 1;
                            bellum = 6;
                            oredo = 3;
                            break;

                        case "Oredo Vitality Mix":
                            mMINhp = 30;
                            mMAXhp = 30;

                            mMINdefense = 70;
                            mMAXdefense = 70;

                            mMINmp = 40;
                            mMAXmp = 40;

                            mMAXstm = 60;
                            mMAXstm = 60;

                            enigma = 1;
                            bellum = 7;
                            oredo = 3;
                            break;

                        case "Sapphire Dexterity Mix":
                            mMINAtkRtg = 150;
                            mMINAtkRtg = 150;

                            mMINdefense = 130;
                            mMAXdefense = 130;

                            mMINmp = 55;
                            mMAXmp = 55;

                            mMINstm = 75;
                            mMAXstm = 75;

                            enigma = 1;
                            bellum = 4;
                            oredo = 3;
                            sapphire = 4;
                            break;

                        case "Sapphire Vitality Mix":
                            mMINhp = 40;
                            mMAXhp = 40;

                            mMINdefense = 80;
                            mMAXdefense = 80;

                            mMINmp = 50;
                            mMAXmp = 50;

                            mMAXstm = 70;
                            mMAXstm = 70;

                            enigma = 1;
                            bellum = 3;
                            oredo = 4;
                            sapphire = 4;
                            break;

                        case "Sol Dexterity Mix":
                            mMINAtkRtg = 170;
                            mMINAtkRtg = 170;

                            mMINdefense = 150;
                            mMAXdefense = 150;

                            mMINmp = 65;
                            mMAXmp = 65;

                            mMINstm = 85;
                            mMAXstm = 85;

                            sol = 4;
                            sapphire = 3;
                            oredo = 4;
                            bellum = 1;
                            break;

                        case "Sol Vitality Mix":
                            mMINhp = 50;
                            mMAXhp = 50;

                            mMINdefense = 90;
                            mMAXdefense = 90;

                            mMINmp = 60;
                            mMAXmp = 60;

                            mMAXstm = 80;
                            mMAXstm = 80;

                            sol = 4;
                            sapphire = 4;
                            oredo = 3;
                            bellum = 1;
                            break;
                    }
                    break;

                case "Gauntlet":
                    switch (mixName) {
                        case "Devine Fortitude Mix":
                            mMINmp = 25;
                            mMAXmp = 25;

                            mMINstm = 30;
                            mMAXstm = 30;

                            mMINabs = 0.8f;
                            mMAXabs = 0.8f;

                            mMINdefense = 40;
                            mMAXdefense = 40;

                            transparo = 1;
                            murky = 3;
                            devine = 5;
                            break;

                        case "Devine Vitality Mix":
                            mMINhp = 8;
                            mMAXhp = 8;

                            mMINstm = 30;
                            mMAXstm = 30;

                            mMINabs = 0.8f;
                            mMAXabs = 0.8f;

                            mMINdefense = 10;
                            mMAXdefense = 10;

                            transparo = 4;
                            murky = 2;
                            devine = 5;
                            break;

                        case "Celesto Fortitude Mix":
                            mMINmp = 30;
                            mMAXmp = 30;

                            mMINstm = 40;
                            mMAXstm = 40;

                            mMINabs = 1;
                            mMAXabs = 1;

                            mMINdefense = 50;
                            mMAXdefense = 50;

                            raident = 2;
                            transparo = 1;
                            devine = 1;
                            celesto = 4;
                            break;

                        case "Celesto Vitality Mix":
                            mMINhp = 10;
                            mMAXhp = 10;

                            mMINstm = 40;
                            mMAXstm = 40;

                            mMINabs = 1;
                            mMAXabs = 1;

                            mMINdefense = 20;
                            mMAXdefense = 20;

                            raident = 1;
                            murky = 1;
                            devine = 2;
                            celesto = 4;
                            break;
                        case "Mirage Fortitude Mix":
                            mMINmp = 40;
                            mMAXmp = 40;

                            mMINstm = 60;
                            mMAXstm = 60;

                            mMINabs = 2;
                            mMAXabs = 2;

                            mMINdefense = 75;
                            mMAXdefense = 75;

                            raident = 1;
                            murky = 3;
                            sol = 3;
                            mirage = 2;
                            break;

                        case "Mirage Vitality Mix":
                            mMINhp = 15;
                            mMAXhp = 15;

                            mMINstm = 60;
                            mMAXstm = 60;

                            mMINabs = 2;
                            mMAXabs = 2;

                            mMINdefense = 40;
                            mMAXdefense = 40;

                            transparo = 2;
                            devine = 1;
                            celesto = 3;
                            mirage = 3;
                            break;

                        case "Inferna Fortitude Mix":
                            mMINmp = 50;
                            mMAXmp = 50;

                            mMINstm = 80;
                            mMAXstm = 80;

                            mMINabs = 3;
                            mMAXabs = 3;

                            mMINdefense = 100;
                            mMAXdefense = 100;

                            transparo = 1;
                            murky = 2;
                            celesto = 3;
                            inferna = 3;
                            break;

                        case "Inferna Vitality Mix":
                            mMINhp = 20;
                            mMAXhp = 20;

                            mMINstm = 80;
                            mMAXstm = 80;

                            mMINabs = 3;
                            mMAXabs = 3;

                            mMINdefense = 60;
                            mMAXdefense = 60;

                            murky = 4;
                            celesto = 1;
                            mirage = 1;
                            inferna = 3;
                            break;
                        case "Enigma Fortitude Mix":
                            mMINmp = 60;
                            mMAXmp = 60;

                            mMINstm = 100;
                            mMAXstm = 100;

                            mMINabs = 4;
                            mMAXabs = 4;

                            mMINdefense = 125;
                            mMAXdefense = 125;

                            devine = 1;
                            celesto = 3;
                            inferna = 1;
                            enigma = 4;
                            break;

                        case "Enigma Vitality Mix":
                            mMINhp = 25;
                            mMAXhp = 25;

                            mMINstm = 100;
                            mMAXstm = 100;

                            mMINabs = 4;
                            mMAXabs = 4;

                            mMINdefense = 80;
                            mMAXdefense = 80;

                            celesto = 2;
                            mirage = 1;
                            inferna = 2;
                            enigma = 4;
                            break;
                        case "Bellum Fortitude Mix":
                            mMINmp = 70;
                            mMAXmp = 70;

                            mMINstm = 120;
                            mMAXstm = 120;

                            mMINabs = 5;
                            mMAXabs = 5;

                            mMINdefense = 150;
                            mMAXdefense = 150;

                            enigma = 1;
                            inferna = 1;
                            enigma = 4;
                            bellum = 3;
                            break;

                        case "Bellum Vitality Mix":
                            mMINhp = 30;
                            mMAXhp = 30;

                            mMINstm = 120;
                            mMAXstm = 120;

                            mMINabs = 5;
                            mMAXabs = 5;

                            mMINdefense = 100;
                            mMAXdefense = 100;

                            celesto = 1;
                            mirage = 3;
                            enigma = 1;
                            bellum = 4;
                            break;
                        case "Oredo Fortitude Mix":
                            mMINmp = 80;
                            mMAXmp = 80;

                            mMINstm = 140;
                            mMAXstm = 140;

                            mMINabs = 6;
                            mMAXabs = 6;

                            mMINdefense = 175;
                            mMAXdefense = 175;

                            mirage = 1;
                            inferna = 2;
                            enigma = 3;
                            oredo = 3;
                            break;

                        case "Oredo Vitality Mix":
                            mMINhp = 35;
                            mMAXhp = 35;

                            mMINstm = 140;
                            mMAXstm = 140;

                            mMINabs = 6;
                            mMAXabs = 6;

                            mMINdefense = 120;
                            mMAXdefense = 120;

                            mirage = 1;
                            inferna = 2;
                            enigma = 2;
                            bellum = 1;
                            oredo = 3;
                            break;

                        case "Sapphire Fortitude Mix":
                            mMINmp = 90;
                            mMAXmp = 90;

                            mMINstm = 160;
                            mMAXstm = 160;

                            mMINabs = 7;
                            mMAXabs = 7;

                            mMINdefense = 200;
                            mMAXdefense = 200;

                            inferna = 1;
                            enigma = 2;
                            bellum = 3;
                            oredo = 2;
                            sapphire = 4;
                            break;

                        case "Sapphire Vitality Mix":
                            mMINhp = 40;
                            mMAXhp = 40;

                            mMINstm = 160;
                            mMAXstm = 160;

                            mMINabs = 7;
                            mMAXabs = 7;

                            mMINdefense = 140;
                            mMAXdefense = 140;

                            bellum = 5;
                            oredo = 3;
                            sapphire = 4;
                            break;

                        case "Sol Fortitude Mix":
                            mMINmp = 100;
                            mMAXmp = 100;

                            mMINstm = 180;
                            mMAXstm = 180;

                            mMINabs = 8f;
                            mMAXabs = 8f;

                            mMINdefense = 225;
                            mMAXdefense = 225;

                            enigma = 1;
                            bellum = 2;
                            oredo = 3;
                            sapphire = 2;
                            sol = 4;
                            break;

                        case "Sol Vitality Mix":
                            mMINhp = 45;
                            mMAXhp = 45;

                            mMINstm = 180;
                            mMAXstm = 180;

                            mMINabs = 8f;
                            mMAXabs = 8f;

                            mMINdefense = 160;
                            mMAXdefense = 160;

                            oredo = 5;
                            sapphire = 3;
                            sol = 4;
                            break;
                    }
                    break;

                case "Boots":
                    switch (mixName) {
                        case "Devine Fortitude Mix":
                            mMINhp = 15;
                            mMAXhp = 15;

                            mMINmp = 8;
                            mMAXmp = 8;

                            mMINmoveSpeed = 0.4f;
                            mMAXmoveSpeed = 0.4f;

                            transparo = 2;
                            murky = 1;
                            devine = 5;
                            break;

                        case "Devine Velocity Mix":
                            mMINhp = 8;
                            mMAXhp = 8;

                            mMINabs = 1.2f;
                            mMAXabs = 1.2f;

                            mMINmoveSpeed = 0.6f;
                            mMAXmoveSpeed = 0.6f;

                            transparo = 2;
                            murky = 2;
                            devine = 4;
                            break;

                        case "Celesto Fortitude Mix":
                            mMINhp = 20;
                            mMAXhp = 20;

                            mMINmp = 10;
                            mMAXmp = 10;

                            mMINmoveSpeed = 0.6f;
                            mMAXmoveSpeed = 0.6f;

                            murky = 1;
                            devine = 3;
                            celesto = 4;
                            break;

                        case "Celesto Velocity Mix":
                            mMINhp = 10;
                            mMAXhp = 10;

                            mMINabs = 1.8f;
                            mMAXabs = 1.8f;

                            mMINmoveSpeed = 1;
                            mMAXmoveSpeed = 1;

                            murky = 2;
                            devine = 3;
                            celesto = 5;
                            break;

                        case "Mirage Fortitude Mix":
                            mMINhp = 25;
                            mMAXhp = 25;

                            mMINmp = 20;
                            mMAXmp = 20;

                            mMINmoveSpeed = 1f;
                            mMAXmoveSpeed = 1f;

                            transparo = 1;
                            enigma = 3;
                            celesto = 2;
                            mirage = 4;
                            break;

                        case "Mirage Velocity Mix":
                            mMINhp = 10;
                            mMAXhp = 10;

                            mMINabs = 2.4f;
                            mMAXabs = 2.4f;

                            mMINmoveSpeed = 1.6f;
                            mMAXmoveSpeed = 1.6f;

                            celesto = 5;
                            mirage = 5;
                            break;

                        case "Inferna Fortitude Mix":
                            mMINhp = 30;
                            mMAXhp = 30;

                            mMINmp = 30;
                            mMAXmp = 30;

                            mMINmoveSpeed = 1.4f;
                            mMAXmoveSpeed = 1.4f;

                            celesto = 1;
                            mirage = 2;
                            inferna = 5;
                            break;

                        case "Inferna Velocity Mix":
                            mMINhp = 15;
                            mMAXhp = 15;

                            mMINabs = 3;
                            mMAXabs = 3;

                            mMINmoveSpeed = 2.2f;
                            mMAXmoveSpeed = 2.2f;

                            celesto = 2;
                            mirage = 3;
                            inferna = 5;
                            break;

                        case "Enigma Fortitude Mix":
                            mMINhp = 35;
                            mMAXhp = 35;

                            mMINmp = 40;
                            mMAXmp = 40;

                            mMINmoveSpeed = 1.8f;
                            mMAXmoveSpeed = 1.8f;

                            mirage = 4;
                            inferna = 2;
                            enigma = 4;
                            break;

                        case "Enigma Velocity Mix":
                            mMINhp = 20;
                            mMAXhp = 20;

                            mMINabs = 3.6f;
                            mMAXabs = 3.6f;

                            mMINmoveSpeed = 3;
                            mMAXmoveSpeed = 3;

                            mirage = 6;
                            inferna = 2;
                            enigma = 4;
                            break;

                        case "Bellum Fortitude Mix":
                            mMINhp = 40;
                            mMAXhp = 40;

                            mMINmp = 50;
                            mMAXmp = 50;

                            mMINmoveSpeed = 2.2f;
                            mMAXmoveSpeed = 2.2f;

                            inferna = 2;
                            enigma = 2;
                            bellum = 6;
                            break;

                        case "Bellum Velocity Mix":
                            mMINhp = 25;
                            mMAXhp = 25;

                            mMINabs = 4.2f;
                            mMAXabs = 4.2f;

                            mMINmoveSpeed = 3.8f;
                            mMAXmoveSpeed = 3.8f;

                            inferna = 2;
                            enigma = 3;
                            bellum = 7;
                            break;

                        case "Oredo Fortitude Mix":
                            mMINhp = 45;
                            mMAXhp = 45;

                            mMINmp = 60;
                            mMAXmp = 60;

                            mMINmoveSpeed = 2.6f;
                            mMAXmoveSpeed = 2.6f;

                            inferna = 1;
                            enigma = 1;
                            bellum = 3;
                            oredo = 6;
                            break;

                        case "Oredo Velocity Mix":
                            mMINhp = 30;
                            mMAXhp = 30;

                            mMINabs = 4.8f;
                            mMAXabs = 4.8f;

                            mMINmoveSpeed = 4.6f;
                            mMAXmoveSpeed = 4.6f;

                            bellum = 3;
                            sapphire = 9;
                            break;

                        case "Sapphire Fortitude Mix":
                            mMINhp = 60;
                            mMAXhp = 60;

                            mMINmp = 70;
                            mMAXmp = 70;

                            mMINmoveSpeed = 3;
                            mMAXmoveSpeed = 3;

                            enigma = 1;
                            bellum = 2;
                            oredo = 3;
                            sapphire = 6;
                            break;

                        case "Sapphire Velocity Mix":
                            mMINhp = 35;
                            mMAXhp = 35;

                            mMINabs = 5.5f;
                            mMAXabs = 5.5f;

                            mMINmoveSpeed = 5.4f;
                            mMAXmoveSpeed = 5.4f;

                            oredo = 3;
                            sapphire = 9;
                            break;

                        case "Sol Fortitude Mix":
                            mMINhp = 70;
                            mMAXhp = 70;

                            mMINmp = 80;
                            mMAXmp = 80;

                            mMINmoveSpeed = 3.4f;
                            mMAXmoveSpeed = 3.4f;

                            bellum = 1;
                            oredo = 2;
                            sapphire = 3;
                            sol = 6;
                            break;

                        case "Sol Velocity Mix":
                            mMINhp = 40;
                            mMAXhp = 40;

                            mMINabs = 6.2f;
                            mMAXabs = 6.2f;

                            mMINmoveSpeed = 6;
                            mMAXmoveSpeed = 6;

                            sapphire = 3;
                            sol = 9;
                            break;

                        case "Sol Endurance Mix":
                            mMINstm = 1000;
                            mMAXstm = 1000;

                            mMINmoveSpeed = 9f;
                            mMAXmoveSpeed = 9f;

                            oredo = 1;
                            sapphire = 1;
                            sol = 10;
                            break;
                    }
                    break;

                case "Amulet":
                    switch (mixName) {
                        case "Transparo Efficiency Mix":
                            mMINmp = 3;
                            mMAXmp = 3;

                            mMINmpReg = 0.1f;
                            mMAXmpReg = 0.1f;

                            sparky = 1;
                            raident = 4;
                            transparo = 2;
                            break;

                        case "Murky Efficiency Mix":
                            mMINmp = 3;
                            mMAXmp = 3;

                            mMINmpReg = 0.2f;
                            mMAXmpReg = 0.2f;

                            raident = 1;
                            bellum = 2;
                            murky = 4;
                            break;

                        case "Devine Efficiency Mix":
                            mMINmp = 5;
                            mMAXmp = 5;

                            mMINhpReg = 0.2f;
                            mMAXhpReg = 0.2f;

                            mMINmpReg = 0.2f;
                            mMAXmpReg = 0.2f;

                            transparo = 3;
                            murky = 2;
                            devine = 5;
                            break;

                        case "Celesto Efficiency Mix #1":
                            mMINmp = 6;
                            mMAXmp = 6;

                            mMINhpReg = 0.4f;
                            mMAXhpReg = 0.4f;

                            mMINmpReg = 0.3f;
                            mMAXmpReg = 0.3f;

                            transparo = 1;
                            devine = 3;
                            celesto = 4;
                            break;

                        case "Celesto Efficiency Mix #2":
                            mMINmp = 8;
                            mMAXmp = 8;

                            mMINhpReg = 0.8f;
                            mMAXhpReg = 0.8f;

                            mMINmpReg = 0.6f;
                            mMAXmpReg = 0.6f;

                            murky = 1;
                            devine = 4;
                            celesto = 5;
                            break;

                        case "Mirage Efficiency Mix #1":
                            mMINmp = 10;
                            mMAXmp = 10;

                            mMINhpReg = 1.2f;
                            mMAXhpReg = 1.2f;

                            mMINmpReg = 0.9f;
                            mMAXmpReg = 0.9f;

                            devine = 1;
                            celesto = 2;
                            mirage = 2;
                            break;

                        case "Mirage Efficiency Mix #2":
                            mMINmp = 12;
                            mMAXmp = 12;

                            mMINhpReg = 1.6f;
                            mMAXhpReg = 1.6f;

                            mMINmpReg = 1.2f;
                            mMAXmpReg = 1.2f;

                            celesto = 3;
                            mirage = 6;
                            break;

                        case "Inferna Efficiency Mix #1":
                            mMINmp = 14;
                            mMAXmp = 14;

                            mMINhpReg = 2;
                            mMAXhpReg = 2;

                            mMINmpReg = 1.5f;
                            mMAXmpReg = 1.5f;

                            mirage = 4;
                            inferna = 3;
                            break;

                        case "Inferna Efficiency Mix #2":
                            mMINmp = 16;
                            mMAXmp = 16;

                            mMINhpReg = 2.4f;
                            mMAXhpReg = 2.4f;

                            mMINmpReg = 1.8f;
                            mMAXmpReg = 1.8f;

                            celesto = 1;
                            mirage = 2;
                            inferna = 5;
                            break;

                        case "Enigma Efficiency Mix #1":
                            mMINmp = 18;
                            mMAXmp = 18;

                            mMINhpReg = 2.8f;
                            mMAXhpReg = 2.8f;

                            mMINmpReg = 2.1f;
                            mMAXmpReg = 2.1f;

                            inferna = 4;
                            enigma = 3;
                            break;

                        case "Enigma Efficiency Mix #2":
                            mMINmp = 20;
                            mMAXmp = 20;

                            mMINhpReg = 3.2f;
                            mMAXhpReg = 3.2f;

                            mMINmpReg = 2.4f;
                            mMAXmpReg = 2.4f;

                            bellum = 2;
                            sapphire = 3;
                            sol = 7;
                            break;

                        case "Bellum Efficiency Mix #1":
                            mMINmp = 22;
                            mMAXmp = 22;

                            mMINhpReg = 3.6f;
                            mMAXhpReg = 3.6f;

                            mMINmpReg = 2.7f;
                            mMAXmpReg = 2.7f;

                            inferna = 1;
                            enigma = 3;
                            bellum = 4;
                            break;

                        case "Bellum Efficiency Mix #2":
                            mMINmp = 24;
                            mMAXmp = 24;

                            mMINhpReg = 4;
                            mMAXhpReg = 4;

                            mMINmpReg = 3;
                            mMAXmpReg = 3;

                            inferna = 2;
                            enigma = 3;
                            bellum = 6;
                            break;

                        case "Oredo Efficiency Mix #1":
                            mMINmp = 26;
                            mMAXmp = 26;

                            mMINhpReg = 4.4f;
                            mMAXhpReg = 4.4f;

                            mMINmpReg = 3.3f;
                            mMAXmpReg = 3.3f;

                            inferna = 1;
                            bellum = 4;
                            oredo = 4;
                            break;

                        case "Oredo Efficiency Mix #2":
                            mMINmp = 28;
                            mMAXmp = 28;

                            mMINhpReg = 4.6f;
                            mMAXhpReg = 4.6f;

                            mMINmpReg = 3.6f;
                            mMAXmpReg = 3.6f;

                            enigma = 1;
                            bellum = 2;
                            oredo = 6;
                            break;

                        case "Sapphire Efficiency Mix #1":
                            mMINmp = 30;
                            mMAXmp = 30;

                            mMINhpReg = 5.2f;
                            mMAXhpReg = 5.2f;

                            mMINmpReg = 3.9f;
                            mMAXmpReg = 3.9f;

                            inferna = 2;
                            enigma = 3;
                            oredo = 2;
                            sapphire = 5;
                            break;

                        case "Sapphire Efficiency Mix #2":
                            mMINmp = 32;
                            mMAXmp = 32;

                            mMINhpReg = 5.4f;
                            mMAXhpReg = 5.4f;

                            mMINmpReg = 4.2f;
                            mMAXmpReg = 4.2f;

                            bellum = 2;
                            oredo = 3;
                            sapphire = 7;
                            break;

                        case "Sol Efficiency Mix #1":
                            mMINmp = 34;
                            mMAXmp = 34;

                            mMINhpReg = 6f;
                            mMAXhpReg = 6f;

                            mMINmpReg = 4.5f;
                            mMAXmpReg = 4.5f;

                            enigma = 2;
                            bellum = 3;
                            sapphire = 2;
                            sol = 5;
                            break;

                        case "Sol Efficiency Mix #2":
                            mMINmp = 36;
                            mMAXmp = 36;

                            mMINhpReg = 6.2f;
                            mMAXhpReg = 6.2f;

                            mMINmpReg = 4.8f;
                            mMAXmpReg = 4.8f;

                            bellum = 2;
                            sapphire = 3;
                            sol = 7;
                            break;
                    }
                    break;
                case "Ring":
                    switch (mixName) {
                        case "Transparo Efficiency Mix":
                            mMINstm = 3;
                            mMAXstm = 3;

                            mMINstmReg = 0.6f;
                            mMAXstmReg = 0.6f;

                            sparky = 2;
                            raident = 2;
                            transparo = 5;
                            break;

                        case "Murky Efficiency Mix":
                            mMINstm = 4;
                            mMAXstm = 4;

                            mMINstmReg = 0.8f;
                            mMAXstmReg = 0.8f;

                            raident = 3;
                            transparo = 2;
                            murky = 4;
                            break;

                        case "Devine Efficiency Mix":
                            mMINstm = 5;
                            mMAXstm = 5;

                            mMINstmReg = 1;
                            mMAXstmReg = 1;

                            transparo = 1;
                            murky = 3;
                            devine = 4;
                            break;

                        case "Celesto Efficiency Mix #1":
                            mMINstm = 6;
                            mMAXstm = 6;

                            mMINstmReg = 1.2f;
                            mMAXstmReg = 1.2f;

                            murky = 1;
                            devine = 3;
                            celesto = 4;
                            break;

                        case "Celesto Efficiency Mix #2":
                            mMINstm = 8;
                            mMAXstm = 8;

                            mMINstmReg = 1.6f;
                            mMAXstmReg = 1.6f;

                            murky = 2;
                            devine = 3;
                            celesto = 5;
                            break;

                        case "Mirage Efficiency Mix #1":
                            mMINhp = 2;
                            mMAXhp = 2;

                            mMINstm = 10;
                            mMAXstm = 10;

                            mMINmp = 6;
                            mMAXmp = 6;

                            mMINstmReg = 1f;
                            mMAXstmReg = 1f;

                            devine = 1;
                            celesto = 4;
                            mirage = 4;
                            break;

                        case "Mirage Efficiency Mix #2":
                            mMINhp = 4;
                            mMAXhp = 4;

                            mMINstm = 12;
                            mMAXstm = 12;

                            mMINmp = 8;
                            mMAXmp = 8;

                            mMINstmReg = 1.4f;
                            mMAXstmReg = 1.4f;

                            celesto = 2;
                            mirage = 6;
                            break;

                        case "Inferna Efficiency Mix #1":
                            mMINhp = 6;
                            mMAXhp = 6;

                            mMINstm = 14;
                            mMAXstm = 14;

                            mMINmp = 10;
                            mMAXmp = 10;

                            mMINstmReg = 1.8f;
                            mMAXstmReg = 1.8f;

                            mirage = 3;
                            inferna = 4;
                            break;

                        case "Inferna Efficiency Mix #2":
                            mMINhp = 8;
                            mMAXhp = 8;

                            mMINstm = 16;
                            mMAXstm = 16;

                            mMINmp = 12;
                            mMAXmp = 12;

                            mMINstmReg = 2.2f;
                            mMAXstmReg = 2.2f;

                            mirage = 5;
                            inferna = 5;
                            break;

                        case "Enigma Efficiency Mix #1":
                            mMINhp = 10;
                            mMAXhp = 10;

                            mMINstm = 18;
                            mMAXstm = 18;

                            mMINmp = 14;
                            mMAXmp = 14;

                            mMINstmReg = 2.6f;
                            mMAXstmReg = 2.6f;

                            mirage = 1;
                            inferna = 3;
                            enigma = 2;
                            break;

                        case "Enigma Efficiency Mix #2":
                            mMINhp = 12;
                            mMAXhp = 12;

                            mMINstm = 20;
                            mMAXstm = 20;

                            mMINmp = 16;
                            mMAXmp = 16;

                            mMINstmReg = 3;
                            mMAXstmReg = 3;

                            inferna = 4;
                            enigma = 3;
                            break;

                        case "Bellum Efficiency Mix #1":
                            mMINhp = 14;
                            mMAXhp = 14;

                            mMINstm = 22;
                            mMAXstm = 22;

                            mMINmp = 18;
                            mMAXmp = 18;

                            mMINstmReg = 3.4f;
                            mMAXstmReg = 3.4f;

                            mirage = 2;
                            enigma = 2;
                            bellum = 2;
                            break;

                        case "Bellum Efficiency Mix #2":
                            mMINhp = 16;
                            mMAXhp = 16;

                            mMINstm = 24;
                            mMAXstm = 24;

                            mMINmp = 20;
                            mMAXmp = 20;

                            mMINstmReg = 3.8f;
                            mMAXstmReg = 3.8f;

                            inferna = 2;
                            enigma = 2;
                            bellum = 4;
                            break;

                        case "Oredo Efficiency Mix #1":
                            mMINhp = 18;
                            mMAXhp = 18;

                            mMINstm = 26;
                            mMAXstm = 26;

                            mMINmp = 22;
                            mMAXmp = 22;

                            mMINstmReg = 4.2f;
                            mMAXstmReg = 4.2f;

                            enigma = 1;
                            bellum = 3;
                            oredo = 3;
                            break;

                        case "Oredo Efficiency Mix #2":
                            mMINhp = 20;
                            mMAXhp = 20;

                            mMINstm = 28;
                            mMAXstm = 28;

                            mMINmp = 24;
                            mMAXmp = 24;

                            mMINstmReg = 4.6f;
                            mMAXstmReg = 4.6f;

                            enigma = 2;
                            bellum = 3;
                            oredo = 4;
                            break;

                        case "Sapphire Efficiency Mix #1":
                            mMINhp = 22;
                            mMAXhp = 22;

                            mMINstm = 30;
                            mMAXstm = 30;

                            mMINmp = 26;
                            mMAXmp = 26;

                            mMINstmReg = 5;
                            mMAXstmReg = 5;

                            enigma = 4;
                            bellum = 3;
                            oredo = 2;
                            sapphire = 3;
                            break;

                        case "Sapphire Efficiency Mix #2":
                            mMINhp = 24;
                            mMAXhp = 24;

                            mMINstm = 32;
                            mMAXstm = 32;

                            mMINmp = 28;
                            mMAXmp = 28;

                            mMINstmReg = 5.4f;
                            mMAXstmReg = 5.4f;

                            enigma = 3;
                            bellum = 2;
                            oredo = 3;
                            sapphire = 4;
                            break;

                        case "Sol Efficiency Mix #1":
                            mMINhp = 26;
                            mMAXhp = 26;

                            mMINstm = 34;
                            mMAXstm = 34;

                            mMINmp = 30;
                            mMAXmp = 30;

                            mMINstmReg = 5.8f;
                            mMAXstmReg = 5.8f;

                            sol = 3;
                            sapphire = 2;
                            oredo = 3;
                            bellum = 4;
                            break;

                        case "Sol Efficiency Mix #2":
                            mMINhp = 28;
                            mMAXhp = 28;

                            mMINstm = 36;
                            mMAXstm = 36;

                            mMINmp = 32;
                            mMAXmp = 32;

                            mMINstmReg = 6.2f;
                            mMAXstmReg = 6.2f;

                            sol = 4;
                            sapphire = 3;
                            oredo = 2;
                            bellum = 3;
                            break;
                    }
                    break;

                case "Sheltom":
                    switch (mixName) {
                        case "Celesto Aegis Mix":
                            mMINdefense = 25;
                            mMAXdefense = 25;

                            transparo = 2;
                            murky = 1;
                            celesto = 6;
                            break;

                        case "Celesto Vigor Mix":
                            mMINAtkMax = 1;
                            mMAXAtkMax = 1;

                            raident = 2;
                            devine = 1;
                            celesto = 6;
                            break;

                        case "Mirage Aegis Mix":
                            mMINdefense = 60;
                            mMAXdefense = 60;

                            murky = 2;
                            devine = 1;
                            mirage = 6;
                            break;

                        case "Mirage Vigor Mix":
                            mMINAtkMin = 1;
                            mMAXAtkMin = 1;

                            mMINAtkMax = 1;
                            mMAXAtkMax = 1;

                            transparo = 2;
                            celesto = 1;
                            mirage = 6;
                            break;

                        case "Inferna Aegis Mix":
                            mMINdefense = 95;
                            mMAXdefense = 95;

                            devine = 2;
                            celesto = 1;
                            inferna = 6;
                            break;

                        case "Inferna Vigor Mix":
                            mMINAtkMin = 1;
                            mMAXAtkMin = 1;

                            mMINAtkMax = 2;
                            mMAXAtkMax = 2;

                            murky = 2;
                            mirage = 1;
                            inferna = 6;
                            break;

                        case "Enigma Aegis Mix":
                            mMINdefense = 130;
                            mMAXdefense = 130;

                            celesto = 2;
                            mirage = 1;
                            enigma = 6;
                            break;

                        case "Enigma Vigor Mix":
                            mMINAtkMin = 2;
                            mMAXAtkMin = 2;

                            mMINAtkMax = 2;
                            mMAXAtkMax = 2;

                            devine = 2;
                            inferna = 1;
                            enigma = 6;
                            break;

                        case "Bellum Aegis Mix":
                            mMINdefense = 165;
                            mMAXdefense = 165;

                            mirage = 2;
                            inferna = 1;
                            bellum = 6;
                            break;

                        case "Bellum Vigor Mix":
                            mMINAtkMin = 2;
                            mMAXAtkMin = 2;

                            mMINAtkMax = 3;
                            mMAXAtkMax = 3;

                            celesto = 2;
                            enigma = 1;
                            bellum = 6;
                            break;

                        case "Oredo Aegis Mix":
                            mMINdefense = 200;
                            mMAXdefense = 200;

                            inferna = 2;
                            enigma = 1;
                            oredo = 6;
                            break;

                        case "Oredo Vigor Mix":
                            mMINAtkMin = 3;
                            mMAXAtkMin = 3;

                            mMINAtkMax = 3;
                            mMAXAtkMax = 3;

                            inferna = 2;
                            bellum = 1;
                            oredo = 6;
                            break;

                        case "Sapphire Aegis Mix":
                            mMINdefense = 250;
                            mMAXdefense = 250;

                            bellum = 2;
                            oredo = 2;
                            sapphire = 6;
                            break;

                        case "Sapphire Vigor Mix":
                            mMINAtkMin = 3;
                            mMAXAtkMin = 3;

                            mMINAtkMax = 4;
                            mMAXAtkMax = 4;

                            bellum = 1;
                            oredo = 3;
                            sapphire = 6;
                            break;

                        case "Sol Aegis Mix":
                            mMINdefense = 300;
                            mMAXdefense = 300;

                            sol = 6;
                            sapphire = 2;
                            oredo = 2;
                            bellum = 2;
                            break;

                        case "Sol Vigor Mix":
                            mMINAtkMin = 4;
                            mMAXAtkMin = 4;

                            mMINAtkMax = 4;
                            mMAXAtkMax = 4;

                            sol = 6;
                            sapphire = 3;
                            oredo = 2;
                            bellum = 1;
                            break;

                    }

                    break;
            }
        }

    }

    public void setSelectedSpec(String classe) {
        try {
            this.selectedSpec = classe;
            setSpecRequirement(this.selectedSpec);
        } catch (Exception ex) {

        }

    }

    public String getItemImgDir() {
        return itemImgDir;
    }

    public String getItemDesc() {
        createItemDesc();
        return itemDesc;
    }

    public String getCurrentItemDesc() {
        return itemDesc;
    }

    private void atualizarSpecPrice() {
        specPrice = price * 1.10;
    }

    public void createItemDesc() {
        if (JdiGearSelector.VIEW_MODE == JdiGearSelector.EQUIP_MODE) {
            checkStatusReq();
        }
        if (itemType.equals("No Gear")) {
            itemDesc = "<html><div style='max-width: 200px'><div style='text-align: center;'>"
                    + "<font color='white'><b>No gear equipped.<br><br>Left click and select a gear to equip.</div>";
            return;
        }
        specPrice = price * 1.10;
        itemDesc = "";
        itemDescSpec = "";
        itemDescMisc = "";
        //Definição cabeçalho
        itemDesc = "<html><div style='max-width: 200px'><div style='text-align: center;'>";
        if (!this.itemMix.isEmpty()) {
            itemDesc += "<font color='aqua'><b>" + this.itemName + "</b></font><br><font color='blue'>" + this.itemMix + "</font><br><br>";
        } else if (itemAged) {
            itemDesc += "<font color='yellow'><b>" + this.itemName + "</b></font><br><font color='white'>+" + this.agingLevel + "</font><br><br>";
        } else {
            itemDesc += "<font color='white'><b>" + this.itemName + "</b></font><br><br>";
        }

        if (!itemLore.isEmpty()) {
            itemDesc += "<font color='purple'> " + itemDesc + "</font><br><br>";
        }
        //Status base
        /*
        stats aging
        mAtkMin = 0;
        mAtkMax = 0;
        mCritChance = 0;
        mAtkRtg = 0;
        mLvl = 0;
        mDefense = 0;
        mAbs = 0;
        mBlock = 0;
        mMp = 0;

         */
        itemDesc += "</div><font color='white'>";
        if ((MINatkMin != 0 && MAXatkMin != 0 && MINatkMax != 0 && MAXatkMax != 0) || (mMINAtkMin != 0 || mMAXAtkMin != 0 || mMINAtkMax != 0 || mMAXAtkMax != 0)) {
            itemDesc += ac(String.valueOf(mMINAtkMin + mMINAtkMax)) + "Attack Power: <b>" + (MINatkMin + mMINAtkMin) + "/" + (MAXatkMin + mMAXAtkMin) + " - " + (MINatkMax + mMINAtkMax) + "/" + (MAXatkMax + mMAXAtkMax) + ec(String.valueOf(mMINAtkMax)) + "</b><br>";
        }
        if (atkSpd != 0 || mAtkSpd != 0) {
            itemDesc += ac(String.valueOf(mAtkSpd)) + "Attack Speed: <b>" + (atkSpd + mAtkSpd) + ec(String.valueOf(mAtkSpd)) + "</b><br>";
        }
        if (critChance != 0 || mCritChance != 0) {
            itemDesc += ac(String.valueOf(mCritChance)) + "Critical: <b>" + (int) (critChance + mCritChance) + ec(String.valueOf(mCritChance)) + "</b><br>";
        }
        if ((MINatkRtg != 0 && MAXatkRtg != 0) || (mMINAtkRtg != 0 && mMAXAtkRtg != 0)) {
            itemDesc += ac(String.valueOf(mMINAtkRtg)) + "Attack Rating: <b>" + (MINatkRtg + mMINAtkRtg) + "/" + (MAXatkRtg + mMAXAtkRtg) + ec(String.valueOf(mMAXAtkRtg)) + "</b><br>";
        }
        if ((MINCritDamage != 0 && MAXCritDamage != 0) || (mMINCritDamage != 0 && mMAXCritDamage != 0)) {
            itemDesc += ac(String.valueOf(mMINCritDamage)) + "Critical Damage: <b>" + (MINCritDamage + mMINCritDamage) + "/" + (MAXCritDamage + mMAXCritDamage) + ec(String.valueOf(mMAXCritDamage)) + "</b><br>";
        }
        if (range != 0) {
            itemDesc += "Range: <b>" + range + "</b><br>";
        }
        if ((MINdefense != 0 && MAXdefense != 0) || (mMINdefense != 0 && mMAXdefense != 0)) {
            itemDesc += ac(String.valueOf(mMINdefense)) + "Defense: <b>" + (int) (MINdefense + mMINdefense) + "/" + (int) (MAXdefense + mMAXdefense) + ec(String.valueOf(mMAXdefense)) + "</b><br>";
        }
        if ((MINabs != 0 && MAXabs != 0) || (mMINabs != 0 && mMAXabs != 0)) {
            itemDesc += ac(String.valueOf(mMINabs)) + "Absorb: <b>" + new DecimalFormat("##.0").format((MINabs + mMINabs)) + "/" + new DecimalFormat("##.0").format((MAXabs + mMAXabs)) + ec(String.valueOf(mMAXabs)) + "</b><br>";
        }
        if ((MINblock != 0 && MAXblock != 0) || (mMINblock != 0 && mMAXblock != 0)) {
            itemDesc += ac(String.valueOf(mMINblock)) + "Block: <b>" + (MINblock + mMINblock) + "/" + (MAXblock + mMAXblock) + ec(String.valueOf(mMAXblock)) + "</b><br>";
        }
        if (MINevasion != 0 && MAXevasion != 0) {
            itemDesc += "Evasion: <b>" + MINevasion + "/" + MAXevasion + "</b><br>";
        }
        if ((MINmoveSpeed != 0 && MAXmoveSpeed != 0) || (mMINmoveSpeed != 0 && mMAXmoveSpeed != 0)) {
            itemDesc += ac(String.valueOf(mMINmoveSpeed)) + "Speed: <b>" + (MINmoveSpeed + mMINmoveSpeed) + "/" + (MAXmoveSpeed + mMAXmoveSpeed) + ec(String.valueOf(mMAXmoveSpeed)) + "</b><br>";
        }
        if (MINintegrity != 0 && MAXintegrity != 0) {
            itemDesc += "Integrity: <b>" + MINintegrity + "/" + MAXintegrity + "</b><br>";
        }
        if ((MINorganicResist != 0 && MAXorganicResist != 0) || (mMINorganicResist != 0 && mMAXorganicResist != 0)) {
            itemDesc += ac(String.valueOf(mMINorganicResist)) + "Organic: <b>" + (MINorganicResist + mMINorganicResist) + "/" + (MAXorganicResist + mMAXorganicResist) + ec(String.valueOf(mMAXorganicResist)) + "</b><br>";
        }
        if ((MINfireResist != 0 && MAXfireResist != 0) || (mMINfireResist != 0 && mMAXfireResist != 0)) {
            itemDesc += ac(String.valueOf(mMINfireResist)) + "Fire: <b>" + (MINfireResist + mMINfireResist) + "/" + (MAXfireResist + mMAXfireResist) + ec(String.valueOf(mMAXfireResist)) + "</b><br>";
        }
        if ((MINiceResist != 0 && MAXiceResist != 0) || (mMINiceResist != 0 && mMAXiceResist != 0)) {
            itemDesc += ac(String.valueOf(mMINiceResist)) + "Frost: <b>" + (MINiceResist + mMINiceResist) + "/" + (MAXiceResist + mMAXiceResist) + ec(String.valueOf(mMAXiceResist)) + "</b><br>";
        }
        if ((MINlightningResist != 0 && MAXlightningResist != 0) || (mMINlightningResist != 0 && mMAXlightningResist != 0)) {
            itemDesc += ac(String.valueOf(mMINlightningResist)) + "Lightning: <b>" + (MINlightningResist + mMINlightningResist) + "/" + (MAXlightningResist + mMAXlightningResist) + ec(String.valueOf(mMAXlightningResist)) + "</b><br>";
        }
        if ((MINpoisonResist != 0 && MAXpoisonResist != 0) || (mMINpoisonResist != 0 && mMAXpoisonResist != 0)) {
            itemDesc += ac(String.valueOf(mMINpoisonResist)) + "Poison: <b>" + (MINpoisonResist + mMINpoisonResist) + "/" + (MAXpoisonResist + mMAXpoisonResist) + ec(String.valueOf(mMAXpoisonResist)) + "</b><br>";
        }
        if ((MINhpReg != 0 && MAXhpReg != 0) || (mMINhpReg != 0 && mMAXhpReg != 0)) {
            itemDesc += ac(String.valueOf(mMINhpReg)) + "HP Regen: <b>" + (MINhpReg + mMINhpReg) + "/" + (MAXhpReg + mMAXhpReg) + ec(String.valueOf(mMAXhpReg)) + "</b><br>";
        }
        if ((MINmpReg != 0 && MAXmpReg != 0) || (mMINmpReg != 0 && mMAXmpReg != 0)) {
            itemDesc += ac(String.valueOf(mMINmpReg)) + "MP Regen: <b>" + (MINmpReg + mMINmpReg) + "/" + (MAXmpReg + mMAXmpReg) + ec(String.valueOf(mMAXmpReg)) + "</b><br>";
        }
        if ((MINstmReg != 0 && MAXstmReg != 0) || (mMINstmReg != 0 && mMAXstmReg != 0)) {
            itemDesc += ac(String.valueOf(mMINstmReg)) + "STM Regen: <b>" + (MINstmReg + mMINstmReg) + "/" + (MAXstmReg + mMAXstmReg) + ec(String.valueOf(mMAXstmReg)) + "</b><br>";
        }
        if ((MINhp != 0 && MAXhp != 0) || (mMINhp != 0 && mMAXhp != 0)) {
            itemDesc += ac(String.valueOf(mMINhp)) + "Add HP: <b>" + (MINhp + mMINhp) + "/" + (MAXhp + mMAXhp) + ec(String.valueOf(mMAXhp)) + "</b><br>";
        }
        if ((MINmp != 0 && MAXmp != 0) || (mMINmp != 0 && mMAXmp != 0)) {
            itemDesc += ac(String.valueOf(mMINmp)) + "Add MP: <b>" + (MINmp + mMINmp) + "/" + (MAXmp + mMAXmp) + ec(String.valueOf(mMAXmp)) + "</b><br>";
        }
        if ((MINstm != 0 && MAXstm != 0) || (mMINstm != 0 && mMAXstm != 0)) {
            itemDesc += ac(String.valueOf(mMINstm)) + "Add SP: <b>" + (MINstm + mMINstm) + "/" + (MAXstm + mMAXstm) + ec(String.valueOf(mMAXstm)) + "</b><br>";
        }
        if (potCount != 0) {
            itemDesc += "Pot Count: <b>" + potCount + "</b><br>";
        }
        itemDesc += "</font>";

        //Requerimentos
        itemDesc += "<font color='orange'>";
        if (rLvl != 0) {
            itemDesc += arlvl() + "Req. Level: <b>" + al(String.valueOf(rLvl), String.valueOf(rLvl + mLvl)) + erlvl() + "</b><br>";
        }
        if (rStr != 0) {
            itemDesc += arstr() + "Req. Strenght: <b>" + ar(String.valueOf(rStr), String.valueOf(mMINstr), String.valueOf(mMAXstr)) + erstr() + "</b><br>";
        }
        if (rSpi != 0) {
            itemDesc += arspi() + "Req. Spirit: <b>" + ar(String.valueOf(rSpi), String.valueOf(mMINspi), String.valueOf(mMAXspi)) + erspi() + "</b><br>";
        }
        if (rTal != 0) {
            itemDesc += artal() + "Req. Talent: <b>" + ar(String.valueOf(rTal), String.valueOf(mMINtal), String.valueOf(mMAXtal)) + ertal() + "</b><br>";
        }
        if (rAgi != 0) {
            itemDesc += aragi() + "Req. Agility: <b>" + ar(String.valueOf(rAgi), String.valueOf(mMINagi), String.valueOf(mMAXagi)) + eragi() + "</b><br>";
        }
        if (rVit != 0) {
            itemDesc += "Req. Health: <b>" + rVit + "</b><br>";
        }
        itemDesc += "</font>";

        //Spec
        itemDescSpec += "<div style='text-align: center;'><font color='yellow'>    " + selectedSpec + " Spec</font></div>";
        itemDescSpec += "<font color='green'>";
        if (sMINdefense != 0 && sMAXdefense != 0) {
            itemDescSpec += "Spec Defense: <b>" + sMINdefense + "/" + sMAXdefense + "</b><br>";
        }
        if (sMINabs != 0 && sMAXabs != 0) {
            itemDescSpec += "Spec Absorb: <b>" + sMINabs + "/" + sMAXabs + "</b><br>";
        }
        if (sCritChance != 0) {
            itemDescSpec += "Spec Critical: <b>" + sCritChance + "</b><br>";
        }
        if (sDivAtkPow != 0) {
            itemDescSpec += "Spec ATK Pwr: <b>LV/" + sDivAtkPow + "</b><br>";
        }
        if (sMINDivAtkRtg != 0 && sMAXDivAtkRtg != 0) {
            itemDescSpec += "Spec ATK Rtg: <b>LV/" + sMINDivAtkRtg + "-" + sMAXDivAtkRtg + "</b><br>";
        }
        if (sRange != 0) {
            itemDescSpec += "Spec Range: <b>" + sRange + "</b><br>";
        }
        if (sMINmagicAPT != 0 && sMAXmagicAPT != 0) {
            itemDescSpec += "Magic APT: <b>" + sMINmagicAPT + "/" + sMAXmagicAPT + "</b><br>";
        }
        if (sBlock != 0) {
            itemDescSpec += "Spec Block: <b>" + sBlock + "</b><br>";
        }
        if (sMINmoveSpeed != 0 && sMAXmoveSpeed != 0) {
            itemDescSpec += "Spec Speed: <b>" + sMINmoveSpeed + "/" + sMAXmoveSpeed + "</b><br>";
        }
        if (sDivHp != 0) {
            itemDescSpec += "Max HP Boost: <b>LV/" + sDivHp + "</b><br>";
        }
        if (sDivHp != 0) {
            itemDescSpec += "Max HP Boost: <b>LV/" + sDivHp + "</b><br>";
        }
        if (sDivMp != 0) {
            itemDescSpec += "Max MP Boost: <b>LV/" + sDivMp + "</b><br>";
        }
        if (sHpReg != 0) {
            itemDescSpec += "Spec HP Regen: <b>" + sHpReg + "</b><br>";
        }
        if (sMINmpReg != 0 && sMAXmpReg != 0) {
            itemDescSpec += "Spec MP Regen: <b>" + sMINmpReg + "/" + sMAXmpReg + "</b><br>";
        }
        if (sStmReg != 0) {
            itemDescSpec += "Spec STM Regen: <b>" + sStmReg + "</b><br>";
        }
        itemDescSpec += "</font>";

        //Misc
        itemDescMisc = "<font color='silver'><br>";
        if (price != 0) {
            itemDescMisc += "No Spec Price: <b>" + new DecimalFormat("###,###,###,###").format((int) price) + "</b><br>";
        }
        if (specPrice != 0) {
            itemDescMisc += "Spec Price: <b>" + new DecimalFormat("###,###,###,###").format((int) specPrice) + "</b><br>";
        }
        if (itemAged) {
            itemDescMisc += "Aging Price: <b>" + new DecimalFormat("###,###,###,###").format((int) agingCost) + "</b><br>";
        }
        if (itemAged) {
            itemDescMisc += "Total Aging Cost: <b>" + new DecimalFormat("###,###,###,###").format((int) totalAgingCost) + "</b><br>";
        }
        if (!itemMix.isEmpty()) {
            itemDescMisc += "Mix Price: <b>" + new DecimalFormat("###,###,###,###").format((int) mixCost) + "</b><br>";
        }
        if (weight != 0) {
            itemDescMisc += "Weight: <b>" + weight + "</b><br>";
        }

        itemDescMisc += getListaSpec();

        itemDescMisc += "</font>";

        if (!selectedSpec.equals("No Spec")) {
            itemDesc += itemDescSpec + itemDescMisc;
        } else {
            itemDesc += itemDescMisc;
        }

        itemDesc += "</div>";
    }

    /*Método que verifica se um valor adicional modificado é maior que zero.
    Caso seja, adiciona a tag de cor azul, para indicar que foi alterado por 
    efeito de Aging ou Mix.
    É chamado no começo da linha que adiciona o valor do status em questão
    no texto de descrição do item.
     */
    public String ac(String modValue) {
        if (modValue.equals("0") || modValue.equals("0.0")) {
            return "";
        } else {
            return "<font color='blue'>";
        }
    }

    /*Método que verifica se um valor adicional modificado é maior que zero.
    Caso seja, adiciona a tag de encerramento de cor, para indicar que foi alterado por 
    efeito de Aging ou Mix.
    É chamado no fim da linha que adiciona o valor do status em questão
    no texto de descrição do item.
     */
    public String ec(String modValue) {
        if (modValue.equals("0") || modValue.equals("0.0")) {
            return "";
        } else {
            return "</font>";
        }
    }

    /*Método que verifica se o requerimento de status foi alterado
    devido a efeitos de troca de Spec. Caso sim,
    adiciona uma seta e exibe os valores alterados.
     */
    public String ar(String origValue, String modMINValue, String modMAXValue) {
        if (origValue.equals(modMINValue) && origValue.equals(modMAXValue)) {
            return origValue;
        } else {
            return origValue + "->" + modMINValue + "/" + modMAXValue;
        }
    }

    /*
    Métodos que verifica se os level/status do personagem dono do item batem com 
    os requerimentos do item. Caso não, renderiza a linha em negrito e vermelho.
     */
    public String arlvl() {
        if (reqLvlMatch) {
            return "";
        } else {
            return "<font color='red'><b>";
        }
    }

    public String erlvl() {
        if (reqLvlMatch) {
            return "";
        } else {
            return "</b></font>";
        }
    }

    public String arstr() {
        if (reqStrMatch) {
            return "";
        } else {
            return "<font color='red'><b>";
        }
    }

    public String erstr() {
        if (reqStrMatch) {
            return "";
        } else {
            return "</b></font>";
        }
    }

    public String arspi() {
        if (reqSpiMatch) {
            return "";
        } else {
            return "<font color='red'><b>";
        }
    }

    public String erspi() {
        if (reqSpiMatch) {
            return "";
        } else {
            return "</b></font>";
        }
    }

    public String artal() {
        if (reqTalMatch) {
            return "";
        } else {
            return "<font color='red'><b>";
        }
    }

    public String ertal() {
        if (reqStrMatch) {
            return "";
        } else {
            return "</b></font>";
        }
    }

    public String aragi() {
        if (reqAgiMatch) {
            return "";
        } else {
            return "<font color='red'><b>";
        }
    }

    public String eragi() {
        if (reqAgiMatch) {
            return "";
        } else {
            return "</b></font>";
        }
    }

    /*Método que verifica se o requerimento de level foi alterado
    devido a efeitos de Aging. Caso sim,
    adiciona uma seta e exibe os valores alterados.
     */
    public String al(String origValue, String modValue) {
        if (mLvl != 0) {
            return origValue + "->" + modValue;
        } else {
            return origValue;
        }
    }

    public String getListaSpec() {

        String specHtml = "";
        int i = 0;
        if (classSpec.length == 1) {
            return "";
        }
        for (String spec : classSpec) {
            if (spec.equals("No Spec")) {
                return specHtml;
            } else {
                switch (i) {
                    case 0:
                        specHtml = "<br>Primary Spec: ";
                        specHtml += spec;
                        break;
                    case 1:
                        specHtml += "<br>Secondary Spec: ";
                        specHtml += spec;
                        break;
                    default:
                        specHtml += ", " + spec;
                        break;
                }
            }
            i++;
        }
        return specHtml;
    }

    public String[] getClassSpec() {
        return classSpec;
    }

    public boolean getCanAge() {
        return this.itemCanAge;
    }

    public String[][] checkStatusReq() {
        String[][] statusInsuficientes = new String[5][2];
        requirementsMatch = true;
        reqLvlMatch = true;
        reqStrMatch = true;
        reqSpiMatch = true;
        reqTalMatch = true;
        reqAgiMatch = true;
        if (c.getLevel() < (rLvl + mLvl)) {
            statusInsuficientes[0][0] = "Level";
            statusInsuficientes[0][1] = "" + ((rLvl + mLvl) - c.getLevel());
            requirementsMatch = false;
            reqLvlMatch = false;
        } else {
            statusInsuficientes[0][0] = "Level";
            statusInsuficientes[0][1] = "0";
        }

        if (c.getStrenght() < this.mMINstr) {
            statusInsuficientes[1][0] = "Strenght";
            statusInsuficientes[1][1] = "" + (mMINstr - c.getStrenght());
            requirementsMatch = false;
            reqStrMatch = false;
        } else {
            statusInsuficientes[1][0] = "Strenght";
            statusInsuficientes[1][1] = "0";
        }

        if (c.getSpirit() < this.mMINspi) {
            statusInsuficientes[2][0] = "Spirit";
            statusInsuficientes[2][1] = "" + (mMINspi - c.getSpirit());
            requirementsMatch = false;
            reqSpiMatch = false;
        } else {
            statusInsuficientes[2][0] = "Spirit";
            statusInsuficientes[2][1] = "0";
        }

        if (c.getTalent() < this.mMINtal) {
            statusInsuficientes[3][0] = "Talent";
            statusInsuficientes[3][1] = "" + (mMINtal - c.getTalent());
            requirementsMatch = false;
            reqTalMatch = false;
        } else {
            statusInsuficientes[3][0] = "Talent";
            statusInsuficientes[3][1] = "0";
        }

        if (c.getAgility() < this.mMINagi) {
            statusInsuficientes[4][0] = "Agility";
            statusInsuficientes[4][1] = "" + (mMINagi - c.getAgility());
            requirementsMatch = false;
            reqAgiMatch = false;
        } else {
            statusInsuficientes[4][0] = "Agility";
            statusInsuficientes[4][1] = "0";
        }

        return statusInsuficientes;
    }

    public boolean isRequirementsMatch() {
        return requirementsMatch;
    }

    public void setRequirementsMatch(boolean requirementsMatch) {
        this.requirementsMatch = requirementsMatch;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public void finalize() throws Throwable {
        super.finalize();
    }

    public int getLucidy() {
        return lucidy;
    }

    public int getSereneo() {
        return sereneo;
    }

    public int getFadeo() {
        return fadeo;
    }

    public int getSparky() {
        return sparky;
    }

    public int getRaident() {
        return raident;
    }

    public int getTransparo() {
        return transparo;
    }

    public int getMurky() {
        return murky;
    }

    public int getDevine() {
        return devine;
    }

    public int getCelesto() {
        return celesto;
    }

    public int getMirage() {
        return mirage;
    }

    public int getInferna() {
        return inferna;
    }

    public int getEnigma() {
        return enigma;
    }

    public int getBellum() {
        return bellum;
    }

    public int getOredo() {
        return oredo;
    }

    public int getSapphire() {
        return sapphire;
    }

    public int getSol() {
        return sol;
    }

    public int getTotalSheltomUsado() {
        return (lucidy + sereneo + fadeo + sparky + raident + transparo + murky + devine + celesto + mirage + inferna + enigma + bellum + oredo + sapphire + sol);
    }

    public boolean isOneOrTwoHanded() {
        return oneOrTwoHanded;
    }

    public String getItemType() {
        return itemType;
    }

    public boolean isItemAgeable() {
        return itemCanAge;
    }

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass;
    }

    public String getItemSoundDir() {
        return itemSoundDir;
    }

    public void setItemSoundDir(String itemSoundDir) {
        this.itemSoundDir = itemSoundDir;
    }

}
