/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import formula.CharacterStats;
import java.text.DecimalFormat;

/**
 *
 * @author Administrator
 */
public class Item {

    protected String itemClass = "";
    protected String itemType = "";
    protected String itemName = "";
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

    public static final boolean ONEHANDED = false;
    public static final boolean TWOHANDED = true;

    

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
    protected int MAXorganicResist = 0;
    protected int MAXpoisonResist = 0;
    protected int MAXiceResist = 0;
    protected int MAXfireResist = 0;
    protected int MAXlightningResist = 0;
    protected int mMINorganicResist = 0;
    protected int mMINpoisonResist = 0;
    protected int mMINiceResist = 0;
    protected int mMINfireResist = 0;
    protected int mMINlightningResist = 0;
    protected int mMAXorganicResist = 0;
    protected int mMAXpoisonResist = 0;
    protected int mMAXiceResist = 0;
    protected int mMAXfireResist = 0;
    protected int mMAXlightningResist = 0;

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
    protected float mMINstmReg = 6.2f;
    protected float mMAXstmReg = 6.2f;
    protected float MINmoveSpeed = 0;
    protected float MAXmoveSpeed = 0;
    protected float mMINmoveSpeed = 0;
    protected float mMAXmoveSpeed = 0;
    protected int potCount = 0;
    //misc
    protected String[] classSpec = new String[11];
    protected int weight = 0;
    protected double price = 0;
    protected double specPrice = 0;
    protected double agingCost = 0;
    protected double totalAgingCost = 0;
    protected double mixCost = 0;
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

            switch (item) {
                case "Weapon":
                    switch (mixName) {
                        case "Sol Swiftness Mix":
                            itemMix = mixName;
                            mAtkSpd = 1;
                            mMINAtkRtg = 170;
                            mMAXAtkRtg = 170;
                            mCritChance = 8;
                            mMINmp = 120;
                            mMAXmp = 120;
                            sol = 9;
                            sapphire = 3;
                            break;

                        case "Sol Vigor Mix":
                            itemMix = mixName;
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

                        case "Sol Critical Mix #2":
                            itemMix = mixName;
                            mMINAtkMin = 22;
                            mMAXAtkMin = 22;
                            mMINAtkMax = 24;
                            mMAXAtkMax = 24;
                            mCritChance = 7;
                            mMINhp = 35;
                            mMAXhp = 35;
                            sol = 8;
                            sapphire = 2;
                            oredo = 2;
                            break;

                        case "Sol Critical Mix #1":
                            itemMix = mixName;
                            mMINAtkMin = 22;
                            mMAXAtkMin = 22;
                            mMINAtkMax = 24;
                            mMAXAtkMax = 24;
                            mCritChance = 9;
                            mMINmp = 60;
                            mMAXmp = 60;
                            break;

                        case "Sol Dexterity Mix":
                            itemMix = mixName;
                            mMINAtkMin = 20;
                            mMAXAtkMin = 20;
                            mMINAtkMax = 25;
                            mMAXAtkMax = 25;
                            mMINAtkRtg = 210;
                            mMAXAtkRtg = 210;
                            mMINhp = 50;
                            mMAXhp = 50;
                            break;

                    }
                    break;

                case "Armor":
                case "Robe":
                    switch (mixName) {
                        case "Sol Finesse Mix":
                            itemMix = mixName;
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

                        case "Sol Vitality Mix":
                            itemMix = mixName;
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

                        case "Sol Fortitude Mix":
                            itemMix = mixName;
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
                    }
                    break;

                case "Shield":
                    switch (mixName) {
                        case "Sol Block Mix":
                            itemMix = mixName;
                            mMINhp = 90;
                            mMAXhp = 90;
                            mMINblock = 14f;
                            mMAXblock = 14f;
                            sol = 10;
                            sapphire = 2;
                            break;

                        case "Sol Vitality Mix #2":
                            itemMix = mixName;
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

                        case "Sol Vitality Mix #1":
                            itemMix = mixName;
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
                    }
                    break;

                case "Orb":
                    switch (mixName) {
                        case "Sol Block Mix":
                            itemMix = mixName;
                            mMINhp = 150;
                            mMAXhp = 150;
                            mMINstm = 80;
                            mMAXstm = 80;
                            mMINblock = 12f;
                            mMAXblock = 12f;
                            sol = 10;
                            sapphire = 2;
                            break;

                        case "Sol Vitality Mix":
                            itemMix = mixName;
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

                        case "Sol Fortitude Mix":
                            itemMix = mixName;
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
                    }
                    break;

                case "Bracelet":
                    switch (mixName) {
                        case "Sol Vitality Mix":
                            itemMix = mixName;
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

                        case "Sol Dexterity Mix":
                            itemMix = mixName;
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

                    }
                    break;

                case "Gauntlet":
                    switch (mixName) {
                        case "Sol Vitality Mix":
                            itemMix = mixName;
                            mMINhp = 45;
                            mMAXhp = 45;
                            mMINstm = 180;
                            mMAXstm = 180;
                            mMINabs = 8f;
                            mMAXabs = 8f;
                            mMINdefense = 160;
                            mMAXdefense = 160;
                            sol = 4;
                            sapphire = 3;
                            oredo = 5;
                            break;

                        case "Sol Fortitude Mix":
                            itemMix = mixName;
                            mMINmp = 100;
                            mMAXmp = 100;
                            mMINstm = 180;
                            mMAXstm = 180;
                            mMINabs = 8f;
                            mMAXabs = 8f;
                            mMINdefense = 225;
                            mMAXdefense = 225;
                            sol = 4;
                            sapphire = 2;
                            oredo = 3;
                            bellum = 2;
                            enigma = 1;
                            break;

                    }
                    break;

                case "Boots":
                    switch (mixName) {
                        case "Sol Endurance Mix":
                            itemMix = mixName;
                            mMINstm = 1000;
                            mMAXstm = 1000;
                            mMINmoveSpeed = 9f;
                            mMAXmoveSpeed = 9f;
                            sol = 10;
                            sapphire = 1;
                            oredo = 1;
                            break;

                        case "Sol Velocity Mix":
                            itemMix = mixName;
                            mMINhp = 40;
                            mMAXhp = 40;
                            mMINabs = 6.2f;
                            mMAXabs = 6.2f;
                            mMINmoveSpeed = 6f;
                            mMAXmoveSpeed = 6f;
                            sol = 9;
                            sapphire = 3;
                            break;

                        case "Sol Fortitude Mix":
                            itemMix = mixName;
                            mMINhp = 70;
                            mMAXhp = 70;
                            mMINmp = 80;
                            mMAXmp = 80;
                            mMINmoveSpeed = 3.4f;
                            mMAXmoveSpeed = 3.4f;
                            sol = 6;
                            sapphire = 3;
                            oredo = 2;
                            bellum = 1;
                            break;
                    }
                    break;

                case "Amulet":
                    switch (mixName) {
                        case "Sol Efficiency Mix #2":
                            itemMix = mixName;
                            mMINmp = 36;
                            mMAXmp = 36;
                            mMINhpReg = 6.2f;
                            mMAXhpReg = 6.2f;
                            mMINmpReg = 4.8f;
                            mMAXmpReg = 4.8f;
                            sol = 7;
                            sapphire = 3;
                            bellum = 2;
                            break;

                        case "Sol Efficiency Mix #1":
                            itemMix = mixName;
                            mMINmp = 34;
                            mMAXmp = 34;
                            mMINhpReg = 6f;
                            mMAXhpReg = 6f;
                            mMINmpReg = 4.5f;
                            mMAXmpReg = 4.5f;
                            sol = 5;
                            sapphire = 2;
                            bellum = 3;
                            enigma = 2;
                            break;

                    }
                    break;

                case "Ring":
                    switch (mixName) {
                        case "Sol Efficiency Mix #2":
                            itemMix = mixName;
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

                        case "Sol Efficiency Mix #1":
                            itemMix = mixName;
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
                    }
                    break;

                case "Sheltom":
                    switch (mixName) {
                        case "Sol Vigor Mix":
                            itemMix = mixName;
                            mMINAtkMin = 4;
                            mMAXAtkMin = 4;
                            mMINAtkMax = 4;
                            mMAXAtkMax = 4;
                            sol = 6;
                            sapphire = 3;
                            oredo = 2;
                            bellum = 1;
                            break;

                        case "Sol Aegis Mix":
                            itemMix = mixName;
                            mMINdefense = 300;
                            mMAXdefense = 300;
                            sol = 6;
                            sapphire = 2;
                            oredo = 2;
                            bellum = 2;
                            break;

                    }
                    break;
            }
        }

    }

    public void setSelectedSpec(String classe) {
        this.selectedSpec = classe;
        setSpecRequirement(this.selectedSpec);
    }

    public String getItemImgDir() {
        return itemImgDir;
    }

    public String getItemDesc() {
        createItemDesc();
        return itemDesc;
    }
    
    public String getCurrentItemDesc(){
        return itemDesc;
    }
    
    private void atualizarSpecPrice(){
        specPrice = price * 1.10;
    }

    public void createItemDesc() {
        specPrice = price * 1.10;
        itemDesc = "";
        itemDescSpec = "";
        itemDescMisc = "";
        //Definição cabeçalho
        itemDesc = "<html>";
        if (!this.itemMix.equals("")) {
            itemDesc += "<font color='aqua'>" + this.itemName + "</font><br><font color='blue'>" + this.itemMix + "</font><br><br>";
        } else if (itemAged) {
            itemDesc += "<font color='yellow'>" + this.itemName + "</font><br><font color='white'>+" + this.agingLevel + "</font><br><br>";
        } else {
            itemDesc += "<font color='white'>" + this.itemName + "</font><br><br>";
        }

        if (!itemLore.equals("")) {
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
        itemDesc += "<font color='white'>";
        if ((MINatkMin != 0 && MAXatkMin != 0 && MINatkMax != 0 && MAXatkMax != 0) || (mMINAtkMin != 0 && mMAXAtkMin != 0 && mMINAtkMax != 0 && mMAXAtkMax != 0)) {
            itemDesc += ac(String.valueOf(mMINAtkMin)) + "Attack Power: " + (MINatkMin + mMINAtkMin) + "/" + (MAXatkMin + mMAXAtkMin) + " - " + (MINatkMax + mMINAtkMax) + "/" + (MAXatkMax + mMAXAtkMax) + ec(String.valueOf(mMINAtkMax)) + "<br>";
        }
        if (atkSpd != 0 || mAtkSpd != 0) {
            itemDesc += ac(String.valueOf(mAtkSpd)) + "Attack Speed: " + atkSpd + ec(String.valueOf(mAtkSpd)) + "<br>";
        }
        if (critChance != 0 || mCritChance != 0) {
            itemDesc += ac(String.valueOf(mCritChance)) + "Critical: " + (int) (critChance + mCritChance) + ec(String.valueOf(mCritChance)) + "<br>";
        }
        if ((MINatkRtg != 0 && MAXatkRtg != 0) || (mMINAtkRtg != 0 && mMAXAtkRtg != 0)) {
            itemDesc += ac(String.valueOf(mMINAtkRtg)) + "Attack Rating: " + (MINatkRtg + mMINAtkRtg) + "/" + (MAXatkRtg + mMAXAtkRtg) + ec(String.valueOf(mMAXAtkRtg)) + "<br>";
        }
        if (range != 0) {
            itemDesc += "Range: " + range + "<br>";
        }
        if ((MINdefense != 0 && MAXdefense != 0) || (mMINdefense != 0 && mMAXdefense != 0)) {
            itemDesc += ac(String.valueOf(mMINdefense)) + "Defense: " + (int) (MINdefense + mMINdefense) + "/" + (int) (MAXdefense + mMAXdefense) + ec(String.valueOf(mMAXdefense)) + "<br>";
        }
        if ((MINabs != 0 && MAXabs != 0) || (mMINabs != 0 && mMAXabs != 0)) {
            itemDesc += ac(String.valueOf(mMINabs)) + "Absorb: " + new DecimalFormat("##.0").format((MINabs + mMINabs)) + "/" + new DecimalFormat("##.0").format((MAXabs + mMAXabs)) + ec(String.valueOf(mMAXabs)) + "<br>";
        }
        if ((MINblock != 0 && MAXblock != 0) || (mMINblock != 0 && mMAXblock != 0)) {
            itemDesc += ac(String.valueOf(mMINblock)) + "Block: " + (MINblock + mMINblock) + "/" + (MAXblock + mMAXblock) + ec(String.valueOf(mMAXblock)) + "<br>";
        }
        if (MINevasion != 0 && MAXevasion != 0) {
            itemDesc += "Evasion: " + MINevasion + "/" + MAXevasion + "<br>";
        }
        if ((MINmoveSpeed != 0 && MAXmoveSpeed != 0) || (mMINmoveSpeed != 0 && mMAXmoveSpeed != 0)) {
            itemDesc += ac(String.valueOf(mMINmoveSpeed)) + "Speed: " + (MINmoveSpeed + mMINmoveSpeed) + "/" + (MAXmoveSpeed + mMAXmoveSpeed) + ec(String.valueOf(mMAXmoveSpeed)) + "<br>";
        }
        if (MINintegrity != 0 && MAXintegrity != 0) {
            itemDesc += "Integrity: " + MINintegrity + "/" + MAXintegrity + "<br>";
        }
        if ((MINorganicResist != 0 && MAXorganicResist != 0) || (mMINorganicResist != 0 && mMAXorganicResist != 0)) {
            itemDesc += ac(String.valueOf(mMINorganicResist)) + "Organic: " + (MINorganicResist + mMINorganicResist) + "/" + (MAXorganicResist + mMAXorganicResist) + ec(String.valueOf(mMAXorganicResist)) + "<br>";
        }
        if ((MINfireResist != 0 && MAXfireResist != 0) || (mMINfireResist != 0 && mMAXfireResist != 0)) {
            itemDesc += ac(String.valueOf(mMINfireResist)) + "Fire: " + (MINfireResist + mMINfireResist) + "/" + (MAXfireResist + mMAXfireResist) + ec(String.valueOf(mMAXfireResist)) + "<br>";
        }
        if ((MINiceResist != 0 && MAXiceResist != 0) || (mMINiceResist != 0 && mMAXiceResist != 0)) {
            itemDesc += ac(String.valueOf(mMINiceResist)) + "Frost: " + (MINiceResist + mMINiceResist) + "/" + (MAXiceResist + mMAXiceResist) + ec(String.valueOf(mMAXiceResist)) + "<br>";
        }
        if ((MINlightningResist != 0 && MAXlightningResist != 0) || (mMINlightningResist != 0 && mMAXlightningResist != 0)) {
            itemDesc += ac(String.valueOf(mMINlightningResist)) + "Lightning: " + (MINlightningResist + mMINlightningResist) + "/" + (MAXlightningResist + mMAXlightningResist) + ec(String.valueOf(mMAXlightningResist)) + "<br>";
        }
        if ((MINpoisonResist != 0 && MAXpoisonResist != 0) || (mMINpoisonResist != 0 && mMAXpoisonResist != 0)) {
            itemDesc += ac(String.valueOf(mMINpoisonResist)) + "Poison: " + (MINpoisonResist + mMINpoisonResist) + "/" + (MAXpoisonResist + mMAXpoisonResist) + ec(String.valueOf(mMAXpoisonResist)) + "<br>";
        }
        if ((MINhpReg != 0 && MAXhpReg != 0) || (mMINhpReg != 0 && mMAXhpReg != 0)) {
            itemDesc += ac(String.valueOf(mMINhpReg)) + "HP Regen: " + (MINhpReg + mMINhpReg) + "/" + (MAXhpReg + mMAXhpReg) + ec(String.valueOf(mMAXhpReg)) + "<br>";
        }
        if ((MINmpReg != 0 && MAXmpReg != 0) || (mMINmpReg != 0 && mMAXmpReg != 0)) {
            itemDesc += ac(String.valueOf(mMINmpReg)) + "MP Regen: " + (MINmpReg + mMINmpReg) + "/" + (MAXmpReg + mMAXmpReg) + ec(String.valueOf(mMAXmpReg)) + "<br>";
        }
        if ((MINstmReg != 0 && MAXstmReg != 0) || (mMINstmReg != 0 && mMAXstmReg != 0)) {
            itemDesc += ac(String.valueOf(mMINstmReg)) + "STM Regen: " + (MINstmReg + mMINstmReg) + "/" + (MAXstmReg + mMAXstmReg) + ec(String.valueOf(mMAXstmReg)) + "<br>";
        }
        if ((MINhp != 0 && MAXhp != 0) || (mMINhp != 0 && mMAXhp != 0)) {
            itemDesc += ac(String.valueOf(mMINhp)) + "Add HP: " + (MINhp + mMINhp) + "/" + (MAXhp + mMAXhp) + ec(String.valueOf(mMAXhp)) + "<br>";
        }
        if ((MINmp != 0 && MAXmp != 0) || (mMINmp != 0 && mMAXmp != 0)) {
            itemDesc += ac(String.valueOf(mMINmp)) + "Add MP: " + (MINmp + mMINmp) + "/" + (MAXmp + mMAXmp) + ec(String.valueOf(mMAXmp)) + "<br>";
        }
        if ((MINstm != 0 && MAXstm != 0) || (mMINstm != 0 && mMAXstm != 0)) {
            itemDesc += ac(String.valueOf(mMINstm)) + "Add SP: " + (MINstm + mMINstm) + "/" + (MAXstm + mMAXstm) + ec(String.valueOf(mMAXstm)) + "<br>";
        }
        if (potCount != 0) {
            itemDesc += "Pot Count: " + potCount + "<br>";
        }
        itemDesc += "</font>";

        //Requerimentos
        itemDesc += "<font color='orange'>";
        if (rLvl != 0) {
            itemDesc += "Req. Level: " + al(String.valueOf(rLvl), String.valueOf(rLvl + mLvl)) + "<br>";
        }
        if (rStr != 0) {
            itemDesc += "Req. Strenght: " + ar(String.valueOf(rStr), String.valueOf(mMINstr), String.valueOf(mMAXstr)) + "<br>";
        }
        if (rSpi != 0) {
            itemDesc += "Req. Spirit: " + ar(String.valueOf(rSpi), String.valueOf(mMINspi), String.valueOf(mMAXspi)) + "<br>";
        }
        if (rTal != 0) {
            itemDesc += "Req. Talent: " + ar(String.valueOf(rTal), String.valueOf(mMINtal), String.valueOf(mMAXtal)) + "<br>";
        }
        if (rAgi != 0) {
            itemDesc += "Req. Agility: " + ar(String.valueOf(rAgi), String.valueOf(mMINagi), String.valueOf(mMAXagi)) + "<br>";
        }
        if (rVit != 0) {
            itemDesc += "Req. Health: " + rVit + "<br>";
        }
        itemDesc += "</font>";

        //Spec
        itemDescSpec += "<font color='yellow'>    " + selectedSpec + " Spec</font><br>";
        itemDescSpec += "<font color='green'>";
        if (sMINdefense != 0 && sMAXdefense != 0) {
            itemDescSpec += "Spec Defense: " + sMINdefense + "/" + sMAXdefense + "<br>";
        }
        if (sMINabs != 0 && sMAXabs != 0) {
            itemDescSpec += "Spec Absorb: " + sMINabs + "/" + sMAXabs + "<br>";
        }
        if (sCritChance != 0) {
            itemDescSpec += "Spec Critical: " + sCritChance + "<br>";
        }
        if (sDivAtkPow != 0) {
            itemDescSpec += "Spec ATK Pwr: LV/" + sDivAtkPow + "<br>";
        }
        if (sMINDivAtkRtg != 0 && sMAXDivAtkRtg != 0) {
            itemDescSpec += "Spec ATK Rtg: LV/" + sMINDivAtkRtg + "-" + sMAXDivAtkRtg + "<br>";
        }
        if (sRange != 0) {
            itemDescSpec += "Spec Range: " + sRange + "<br>";
        }
        if (sMINmagicAPT != 0 && sMAXmagicAPT != 0) {
            itemDescSpec += "Magic APT : " + sMINmagicAPT + "/" + sMAXmagicAPT + "<br>";
        }
        if (sBlock != 0) {
            itemDescSpec += "Spec Block: " + sBlock + "<br>";
        }
        if (sMINmoveSpeed != 0 && sMAXmoveSpeed != 0) {
            itemDescSpec += "Spec Speed: " + sMINmoveSpeed + "/" + sMAXmoveSpeed + "<br>";
        }
        if (sDivHp != 0) {
            itemDescSpec += "Max HP Boost: LV/" + sDivHp + "<br>";
        }
        if (sDivHp != 0) {
            itemDescSpec += "Max HP Boost: LV/" + sDivHp + "<br>";
        }
        if (sDivMp != 0) {
            itemDescSpec += "Max MP Boost: LV/" + sDivMp + "<br>";
        }
        if (sHpReg != 0) {
            itemDescSpec += "Spec HP Regen: " + sHpReg + "<br>";
        }
        if (sMINmpReg != 0 && sMAXmpReg != 0) {
            itemDescSpec += "Spec MP Regen: " + sMINmpReg + "/" + sMAXmpReg + "<br>";
        }
        if (sStmReg != 0) {
            itemDescSpec += "Spec STM Regen: " + sStmReg + "<br>";
        }
        itemDescSpec += "</font>";

        //Misc
        itemDescMisc = "<font color='silver'><br>";
        if (price != 0) {
            itemDescMisc += "No Spec Price: " + new DecimalFormat("###,###,###,###").format((int) price) + "<br>";
        }
        if (specPrice != 0) {
            itemDescMisc += "Spec Price: " + new DecimalFormat("###,###,###,###").format((int) specPrice) + "<br>";
        }
        if (itemAged) {
            itemDescMisc += "Aging Price: " + new DecimalFormat("###,###,###,###").format((int) agingCost) + "<br>";
        }
        if (itemAged) {
            itemDescMisc += "Total Aging Cost: " + new DecimalFormat("###,###,###,###").format((int) totalAgingCost) + "<br>";
        }
        if (!itemMix.equals("")) {
            itemDescMisc += "Mix Price: " + new DecimalFormat("###,###,###,###").format((int) mixCost) + "<br>";
        }
        if (weight != 0) {
            itemDescMisc += "Weight: " + weight + "<br>";
        }

        itemDescMisc += "</font>";

        if (!selectedSpec.equals("No Spec")) {
            itemDesc += itemDescSpec + itemDescMisc;
        } else {
            itemDesc += itemDescMisc;
        }
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
            return origValue+"->"+modMINValue+"/"+modMAXValue;
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

    public String[] getClassSpec() {
        return classSpec;
    }

    public boolean getCanAge() {
        return this.itemCanAge;
    }

    public String[][] checkStatusReq(CharacterStats c) {
        String[][] statusInsuficientes = new String[5][2];

        if (c.getLevel() < (rLvl + mLvl)) {
            statusInsuficientes[0][0] = "Level";
            statusInsuficientes[0][1] = "" + ((rLvl + mLvl) - c.getLevel());
        } else {
            statusInsuficientes[0][0] = "Level";
            statusInsuficientes[0][1] = "0";
        }

        if (c.getStrenght() < this.mMINstr) {
            statusInsuficientes[1][0] = "Strenght";
            statusInsuficientes[1][1] = "" + (mMINstr - c.getStrenght());
        } else {
            statusInsuficientes[1][0] = "Strenght";
            statusInsuficientes[1][1] = "0";
        }

        if (c.getStrenght() < this.mMINspi) {
            statusInsuficientes[2][0] = "Spirit";
            statusInsuficientes[2][1] = "" + (mMINspi - c.getSpirit());
        } else {
            statusInsuficientes[2][0] = "Spirit";
            statusInsuficientes[2][1] = "0";
        }

        if (c.getStrenght() < this.mMINtal) {
            statusInsuficientes[3][0] = "Talent";
            statusInsuficientes[3][1] = "" + (mMINtal - c.getTalent());
        } else {
            statusInsuficientes[3][0] = "Talent";
            statusInsuficientes[3][1] = "0";
        }

        if (c.getStrenght() < this.mMINagi) {
            statusInsuficientes[4][0] = "Agility";
            statusInsuficientes[4][1] = "" + (mMINagi - c.getAgility());
        } else {
            statusInsuficientes[4][0] = "Agility";
            statusInsuficientes[4][1] = "0";
        }

        return statusInsuficientes;
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
