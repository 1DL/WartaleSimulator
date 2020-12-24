/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.game.formula;

import controller.assets.assetsController;
import controller.game.item.Item;
import javax.swing.JButton;
import javax.swing.JLabel;
import controller.game.skill.Skill;
import controller.game.ItemController;

/**
 *
 * @author Administrator
 */
public class CharacterStats extends assetsController{
    
    //Formula related
    protected int jobId;
    
    protected int baseStr;
    protected int baseSpi;
    protected int baseTal;
    protected int baseAgi;
    protected int baseVit;
    
    protected String[] jobTitle;
    
    protected String jobName;
    protected String spec;
    protected String weaponMatch;
    
    //Base Damage formula
    
    //base without weapon
    protected int baseWithoutWeaponMin;
    protected int baseWithoutWeaponMax;
    
    //base with weapon
    
    protected int baseWithWeaponMin;
    protected int baseWithWeaponMax;
    
    //ranged = agi modifier, melee = str modifier, magic = spi modifier
    protected int rangedWeapon;
    protected int meleeWeapon;
    protected int magicWeapon;
    
    //Not wearing weapon modifier
    protected int bareHandedFlat;
    protected int bareHandedStr;
    
    protected int bareHandedTalAgiMin;
    
    protected int bareHandedTalAgiMax;
    
    //Wearing Melee Weapon
    protected int meleeTalAgi;
    
    //Wearing Ranged Weapon
    protected int rangedStrTal;
    
    //Wearing Magic Weapon
    protected int magicTal;
    
    //Additional Damage
    protected int additionalMin;
    protected int additionalMax;
    
    
    
    //critical damage
    protected float baseCriticalDamage;
    
    //abs
    protected float absDef;
    protected float absLvl;
    protected float absStr;
    protected float absSpi;
    protected float absTal;
    protected float absAgi;
    protected float absVit;
    protected float absPointExtra;
    
    //atr
    protected float atrLvl;
    protected float atrStr;
    protected float atrSpi;
    protected float atrTal;
    protected float atrAgi;
    protected float atrVit;
    
    //def
    protected float defLvl;
    protected float defStr;
    protected float defSpi;
    protected float defTal;
    protected float defAgi;
    protected float defVit;
    
    //hp
    protected float hpLvl;
    protected float hpStr;
    protected float hpSpi;
    protected float hpTal;
    protected float hpAgi;
    protected float hpVit;
    protected float hpFlat;
    
    //mp
    protected float mpLvl;
    protected float mpStr;
    protected float mpSpi;
    protected float mpTal;
    protected float mpAgi;
    protected float mpVit;
    protected float mpFlat;
    
    //sp
    protected float spLvl;
    protected float spStr;
    protected float spSpi;
    protected float spTal;
    protected float spAgi;
    protected float spVit;
    protected float spFlat;
    
    //max weight
    protected float weightLvl;
    protected float weightStr;
    protected float weightSpi;
    protected float weightTal;
    protected float weightAgi;
    protected float weightVit;
    protected float weightFlat;
    
    //running speed/walk speed
    protected float runBase;
    protected float runLvl;
    protected float runStr;
    
    //end formula related

    public static final boolean ALL = true;
    public static final boolean TIER5 = false;
    public static final boolean UP = true;
    public static final boolean DOWN = false;
    
    ItemController iC = new ItemController();

    //Personagem
    private String playerName;
    private String classe;
    private String[] title;
    protected int level;
    protected long exp;

    //Skills Points    
    private int baseSP;
    private int baseEP;
    private int baseRSP;

    private int rSP;
    private int rEP;
    private int rRSP;
    private int iSP;
    private int iEP;
    private int iRSP;

    private int[][][] rSkillLvl;

    //Skills
    private final int[][] skillLvl;
    private Skill[][] skill;

    public JLabel imgSkill[][] = new JLabel[5][4];
    public JButton btnSkill[][] = new JButton[5][4];
    public JLabel lvlSkill[][] = new JLabel[5][4];
    public JLabel classTitleFrame[] = new JLabel[5];
    public JLabel classTitleName[] = new JLabel[5];

    //Items
    //Principais
    protected Item ItemWeaponOneHand;
    protected Item ItemWeaponTwoHand;
    protected Item ItemShield;
    protected Item ItemArmor;
    //Defesas
    protected Item ItemBracelet;
    protected Item ItemGauntlet;
    protected Item ItemBoots;
    //Acessórios
    protected Item ItemAmulet;
    protected Item ItemRing1;
    protected Item ItemRing2;
    protected Item ItemSheltom;
    protected Item ItemEarRing1;
    protected Item ItemEarRing2;
    protected Item ItemBelt;

    //Resistência Elemental
    protected int organic;
    protected int poison;
    protected int fire;
    protected int lightning;
    protected int ice;
    protected int water;
    protected int wind;
    //Default Attack element
    protected int defaultAtkElement = Skill.E_NORMAL;

    //HP, Stamina, Mana e seus regens
    protected float hp;
    protected float stm;
    protected float mp;
    protected float hpReg;
    protected float stmReg;
    protected float mpReg;

    //Pontos de stats
    protected int totalStats;
    private int strenght;
    private int spirit;
    private int talent;
    private int agility;
    private int health;
    private int remainStats = 25;

    //Status normais
    protected float attackRating;
    protected float attackDamageMin;
    protected float attackDamageMax;
    protected float defense;
    protected float abs;
    protected float moveSpeed;

    //Status ocultos
    protected float attackSpeed;
    protected float block;
    protected float critChance;
    protected float critDamage;
    protected float[] evasion;
    protected float damageReduction;

    //Itens equipados
    protected String weaponType;
    protected String weaponClass;
    protected int weaponMinAtk;
    protected int weaponMaxAtk;
    protected int weaponSpecDamage;
    protected int weaponSpecAttackRating;
    protected int gauntletSpecDamage;
    protected int sheltomMinAtk;
    protected int sheltomMaxAtk;

    public int getJobId() {
        return jobId;
    }

    public String[] getJobTitle() {
        return jobTitle;
    }

    public String getJobName() {
        return jobName;
    }

    public String getSpec() {
        return spec;
    }

    public String getWeaponMatch() {
        return weaponMatch;
    }

    public int getBaseWithoutWeaponMin() {
        return baseWithoutWeaponMin;
    }

    public int getBaseWithoutWeaponMax() {
        return baseWithoutWeaponMax;
    }

    public int getBaseWithWeaponMin() {
        return baseWithWeaponMin;
    }

    public int getBaseWithWeaponMax() {
        return baseWithWeaponMax;
    }

    public int getRangedWeapon() {
        return rangedWeapon;
    }

    public int getMeleeWeapon() {
        return meleeWeapon;
    }

    public int getMagicWeapon() {
        return magicWeapon;
    }

    public int getBareHandedFlat() {
        return bareHandedFlat;
    }

    public int getBareHandedStr() {
        return bareHandedStr;
    }

    public int getBareHandedTalAgiMin() {
        return bareHandedTalAgiMin;
    }

    public int getBareHandedTalAgiMax() {
        return bareHandedTalAgiMax;
    }

    public int getMeleeTalAgi() {
        return meleeTalAgi;
    }

    public int getRangedStrTal() {
        return rangedStrTal;
    }

    public int getMagicTal() {
        return magicTal;
    }

    public int getAdditionalMin() {
        return additionalMin;
    }

    public int getAdditionalMax() {
        return additionalMax;
    }

    public float getBaseCriticalDamage() {
        return baseCriticalDamage;
    }

    public float getAbsDef() {
        return absDef;
    }

    public float getAbsLvl() {
        return absLvl;
    }

    public float getAbsStr() {
        return absStr;
    }

    public float getAbsSpi() {
        return absSpi;
    }

    public float getAbsTal() {
        return absTal;
    }

    public float getAbsAgi() {
        return absAgi;
    }

    public float getAbsVit() {
        return absVit;
    }

    public float getAbsPointExtra() {
        return absPointExtra;
    }

    public float getAtrLvl() {
        return atrLvl;
    }

    public float getAtrStr() {
        return atrStr;
    }

    public float getAtrSpi() {
        return atrSpi;
    }

    public float getAtrTal() {
        return atrTal;
    }

    public float getAtrAgi() {
        return atrAgi;
    }

    public float getAtrVit() {
        return atrVit;
    }

    public float getDefLvl() {
        return defLvl;
    }

    public float getDefStr() {
        return defStr;
    }

    public float getDefSpi() {
        return defSpi;
    }

    public float getDefTal() {
        return defTal;
    }

    public float getDefAgi() {
        return defAgi;
    }

    public float getDefVit() {
        return defVit;
    }

    public float getHpLvl() {
        return hpLvl;
    }

    public float getHpStr() {
        return hpStr;
    }

    public float getHpSpi() {
        return hpSpi;
    }

    public float getHpTal() {
        return hpTal;
    }

    public float getHpAgi() {
        return hpAgi;
    }

    public float getHpVit() {
        return hpVit;
    }

    public float getHpFlat() {
        return hpFlat;
    }

    public float getMpLvl() {
        return mpLvl;
    }

    public float getMpStr() {
        return mpStr;
    }

    public float getMpSpi() {
        return mpSpi;
    }

    public float getMpTal() {
        return mpTal;
    }

    public float getMpAgi() {
        return mpAgi;
    }

    public float getMpVit() {
        return mpVit;
    }

    public float getMpFlat() {
        return mpFlat;
    }

    public float getSpLvl() {
        return spLvl;
    }

    public float getSpStr() {
        return spStr;
    }

    public float getSpSpi() {
        return spSpi;
    }

    public float getSpTal() {
        return spTal;
    }

    public float getSpAgi() {
        return spAgi;
    }

    public float getSpVit() {
        return spVit;
    }

    public float getSpFlat() {
        return spFlat;
    }

    public float getWeightLvl() {
        return weightLvl;
    }

    public float getWeightStr() {
        return weightStr;
    }

    public float getWeightSpi() {
        return weightSpi;
    }

    public float getWeightTal() {
        return weightTal;
    }

    public float getWeightAgi() {
        return weightAgi;
    }

    public float getWeightVit() {
        return weightVit;
    }

    public float getWeightFlat() {
        return weightFlat;
    }

    public float getRunBase() {
        return runBase;
    }

    public float getRunLvl() {
        return runLvl;
    }

    public float getRunStr() {
        return runStr;
    }

    public static boolean isALL() {
        return ALL;
    }

    public static boolean isTIER5() {
        return TIER5;
    }

    public static boolean isUP() {
        return UP;
    }

    public static boolean isDOWN() {
        return DOWN;
    }

    public ItemController getiC() {
        return iC;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String[] getTitle() {
        return title;
    }

    public long getExp() {
        return exp;
    }

    public int getiSP() {
        return iSP;
    }

    public int getiEP() {
        return iEP;
    }

    public int getiRSP() {
        return iRSP;
    }

    public int[][][] getrSkillLvl() {
        return rSkillLvl;
    }

    public Skill[][] getSkill() {
        return skill;
    }

    public JLabel[][] getImgSkill() {
        return imgSkill;
    }

    public JButton[][] getBtnSkill() {
        return btnSkill;
    }

    public JLabel[][] getLvlSkill() {
        return lvlSkill;
    }

    public JLabel[] getClassTitleFrame() {
        return classTitleFrame;
    }

    public JLabel[] getClassTitleName() {
        return classTitleName;
    }

    public int getOrganic() {
        return organic;
    }

    public int getPoison() {
        return poison;
    }

    public int getFire() {
        return fire;
    }

    public int getLightning() {
        return lightning;
    }

    public int getIce() {
        return ice;
    }

    public int getWater() {
        return water;
    }

    public int getWind() {
        return wind;
    }

    public int getDefaultAtkElement() {
        return defaultAtkElement;
    }

    public float getHp() {
        return hp;
    }

    public float getStm() {
        return stm;
    }

    public float getMp() {
        return mp;
    }

    public float getHpReg() {
        return hpReg;
    }

    public float getStmReg() {
        return stmReg;
    }

    public float getMpReg() {
        return mpReg;
    }

    public int getTotalStats() {
        return totalStats;
    }

    public float getAttackRating() {
        return attackRating;
    }

    public float getDefense() {
        return defense;
    }

    public float getAbs() {
        return abs;
    }

    public float getMoveSpeed() {
        return moveSpeed;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }

    public float getBlock() {
        return block;
    }

    public float getCritChance() {
        return critChance;
    }

    public float getCritDamage() {
        return critDamage;
    }

    public float[] getEvasion() {
        return evasion;
    }

    public float getDamageReduction() {
        return damageReduction;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public String getWeaponClass() {
        return weaponClass;
    }

    public int getWeaponMinAtk() {
        return weaponMinAtk;
    }

    public int getWeaponMaxAtk() {
        return weaponMaxAtk;
    }

    public int getWeaponSpecDamage() {
        return weaponSpecDamage;
    }

    public int getWeaponSpecAttackRating() {
        return weaponSpecAttackRating;
    }

    public int getGauntletSpecDamage() {
        return gauntletSpecDamage;
    }

    public int getSheltomMinAtk() {
        return sheltomMinAtk;
    }

    public int getSheltomMaxAtk() {
        return sheltomMaxAtk;
    }

    public String getForceOrb() {
        return forceOrb;
    }

    public String getSiegeWarCrown() {
        return siegeWarCrown;
    }

    //Buffs e Coroas
    protected String forceOrb;
    protected String siegeWarCrown;

    public CharacterStats(String classe, int level, int strenght, int spirit,
            int talent, int agility, int health, String weaponType,
            int weaponMinAtk, int weaponMaxAtk, int weaponSpecDamage, int weaponSpecAttackRating,
            String forceOrb, String siegeWarCrown, int gauntletSpecDamage,
            int sheltomMinAtk, int sheltomMaxAtk) {
        this.skillLvl = new int[5][4];
        this.rSkillLvl = new int[5][4][10];
        this.skill = new Skill[5][4];
        gerarLevelReqSkill();
        this.classe = classe;
        this.level = level;
        this.strenght = strenght;
        this.spirit = spirit;
        this.talent = talent;
        this.agility = agility;
        this.health = health;
        this.weaponType = weaponType;
        if (weaponType.equals("Bow") || weaponType.equals("Javelin")) {
            this.weaponClass = "Ranged";
        } else if (weaponType.equals("Wand") || weaponType.equals("Phantom")) {
            this.weaponClass = "Magic";
        } else if (weaponType.equals("No Weapon")) {
            this.weaponClass = "No Weapon";
        } else {
            this.weaponClass = "Melee";
        }
        this.weaponMinAtk = weaponMinAtk;
        this.weaponMaxAtk = weaponMaxAtk;
        this.weaponSpecDamage = weaponSpecDamage;
        this.weaponSpecAttackRating = weaponSpecAttackRating;
        this.forceOrb = forceOrb;
        this.siegeWarCrown = siegeWarCrown;
        this.gauntletSpecDamage = gauntletSpecDamage;
        this.sheltomMinAtk = sheltomMinAtk;
        this.sheltomMaxAtk = sheltomMaxAtk;

    }

    public CharacterStats() {
        this.skillLvl = new int[5][4];
        this.rSkillLvl = new int[5][4][10];
        this.skill = new Skill[5][4];
        gerarLevelReqSkill();

        //Principais
        ItemWeaponOneHand = new Item("No Gear Weapon");
        ItemWeaponTwoHand = new Item("No Gear Weapon");
        ItemShield = new Item("No Gear");
        ItemArmor = new Item("No Gear");
        //Defesas
        ItemBracelet = new Item("No Gear");
        ItemGauntlet = new Item("No Gear");
        ItemBoots = new Item("No Gear");
        //Acessórios
        ItemAmulet = new Item("No Gear");
        ItemRing1 = new Item("No Gear");
        ItemRing2 = new Item("No Gear");
        ItemSheltom = new Item("No Gear");

    }

    public float getAttackDamageMin() {
        return attackDamageMin;
    }

    public void setAttackDamageMin(float attackDamageMin) {
        this.attackDamageMin = attackDamageMin;
    }

    public float getAttackDamageMax() {
        return attackDamageMax;
    }

    public void setAttackDamageMax(float attackDamageMax) {
        this.attackDamageMax = attackDamageMax;
    }
    
    public void updateRemainStats() {
        this.remainStats = 25;
        for (int i = 2; i <= this.level; i++) {
            if (i <= 79) {
                this.remainStats += 5;
            } else if (i > 79 && i <= 89) {
                this.remainStats += 7;
            } else {
                this.remainStats += 10;
            }
        }
        this.totalStats = remainStats;
        if ((remainStats + 99) < (strenght + spirit + talent + agility + health)) {
            this.strenght = this.baseStr;
            this.spirit = this.baseSpi;
            this.talent = this.baseTal;
            this.agility = this.baseAgi;
            this.health = this.baseVit;
        }
        this.remainStats = remainStats + 99 - (strenght + spirit + talent + agility + health);

    }

    public int getRemainStats() {
        return this.remainStats;
    }

    public void setStatus(boolean subirStatus10, String tipoStat) {
        if (remainStats != 0) {
            if (remainStats > 9 && subirStatus10) {
                switch (tipoStat) {
                    case "str":
                        strenght += 10;
                        remainStats -= 10;
                        break;
                    case "spi":
                        spirit += 10;
                        remainStats -= 10;
                        break;
                    case "tal":
                        talent += 10;
                        remainStats -= 10;
                        break;
                    case "agi":
                        agility += 10;
                        remainStats -= 10;
                        break;
                    case "hp":
                        health += 10;
                        remainStats -= 10;
                        break;
                }
            } else {
                switch (tipoStat) {
                    case "str":
                        strenght += 1;
                        remainStats -= 1;
                        break;
                    case "spi":
                        spirit += 1;
                        remainStats -= 1;
                        break;
                    case "tal":
                        talent += 1;
                        remainStats -= 1;
                        break;
                    case "agi":
                        agility += 1;
                        remainStats -= 1;
                        break;
                    case "hp":
                        health += 1;
                        remainStats -= 1;
                        break;
                }
            }
        }
    }

    public void resetStats() {
        strenght = baseStr;
        spirit = baseSpi;
        talent = baseTal;
        agility = baseAgi;
        health = baseVit;
        updateRemainStats();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        updateRemainStats();
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
        updateRemainStats();
    }

    public int getSpirit() {
        return spirit;
    }

    public void setSpirit(int spirit) {
        this.spirit = spirit;
        updateRemainStats();
    }

    public int getTalent() {
        return talent;
    }

    public void setTalent(int talent) {
        this.talent = talent;
        updateRemainStats();
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
        updateRemainStats();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        updateRemainStats();
    }

    public int getBaseStr() {
        return baseStr;
    }

    public void setBaseStr(int baseStr) {
        this.baseStr = baseStr;
        this.strenght = this.baseStr;
    }

    public int getBaseSpi() {
        return baseSpi;
    }

    public void setBaseSpi(int baseSpi) {
        this.baseSpi = baseSpi;
        this.spirit = this.baseSpi;
    }

    public int getBaseTal() {
        return baseTal;
    }

    public void setBaseTal(int baseTal) {
        this.baseTal = baseTal;
        this.talent = this.baseTal;
    }

    public int getBaseAgi() {
        return baseAgi;
    }

    public void setBaseAgi(int baseAgi) {
        this.baseAgi = baseAgi;
        this.agility = this.baseAgi;
    }

    public int getBaseVit() {
        return baseVit;
    }

    public void setBaseVit(int baseVit) {
        this.baseVit = baseVit;
        this.health = this.baseVit;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setItemWeaponOneHand(Item ItemWeaponOneHand) {
        this.ItemWeaponOneHand = ItemWeaponOneHand;
    }

    public void setItemWeaponTwoHand(Item ItemWeaponTwoHand) {
        this.ItemWeaponTwoHand = ItemWeaponTwoHand;
    }

    public void setItemShield(Item ItemShield) {
        this.ItemShield = ItemShield;
    }

    public void setItemArmor(Item ItemArmor) {
        this.ItemArmor = ItemArmor;
    }

    public void setItemBracelet(Item ItemBracelet) {
        this.ItemBracelet = ItemBracelet;
    }

    public void setItemGauntlet(Item ItemGauntlet) {
        this.ItemGauntlet = ItemGauntlet;
    }

    public void setItemBoots(Item ItemBoots) {
        this.ItemBoots = ItemBoots;
    }

    public void setItemAmulet(Item ItemAmulet) {
        this.ItemAmulet = ItemAmulet;
    }

    public void setItemRing1(Item ItemRing1) {
        this.ItemRing1 = ItemRing1;
    }

    public void setItemRing2(Item ItemRing2) {
        this.ItemRing2 = ItemRing2;
    }

    public void setItemSheltom(Item ItemSheltom) {
        this.ItemSheltom = ItemSheltom;
    }

    public Item getItemWeaponOneHand() {
        return ItemWeaponOneHand;
    }

    public Item getItemWeaponTwoHand() {
        return ItemWeaponTwoHand;
    }

    public Item getItemShield() {
        return ItemShield;
    }

    public Item getItemArmor() {
        return ItemArmor;
    }

    public Item getItemBracelet() {
        return ItemBracelet;
    }

    public Item getItemGauntlet() {
        return ItemGauntlet;
    }

    public Item getItemBoots() {
        return ItemBoots;
    }

    public Item getItemAmulet() {
        return ItemAmulet;
    }

    public Item getItemRing1() {
        return ItemRing1;
    }

    public Item getItemRing2() {
        return ItemRing2;
    }

    public Item getItemSheltom() {
        return ItemSheltom;
    }
    
    public Item getItemEarRing1() {
        return ItemEarRing1;
    }
    
    public Item getItemEarRing2() {
        return ItemEarRing2;
    }
    
    public Item getItemBelt() {
        return ItemBelt;
    }

    

    public String setBaseSkillPoints() {
        int questSP = 4;
        int questEP = 0;
        int questRSP = 0;

        baseSP = questSP;
        baseEP = questEP;
        baseRSP = questRSP;

        for (int i = 10; i <= level; i += 2) {
            baseSP++;
        }

        for (int i = 60; i <= level; i += 2) {
            baseEP++;
        }

        for (int i = 80; i <= level; i += 2) {
            baseRSP++;
        }

        if (iSP > baseSP) {
            resetSkillPoints(ALL);
            return "resetall";
        } else {
            rSP = baseSP - iSP;
        }
        if (iEP > baseEP) {
            resetSkillPoints(ALL);
            return "resetall";
        } else {
            rEP = baseEP - iEP;
        }
        if (iRSP > baseRSP) {
            resetSkillPoints(TIER5);
            return "resettier5";
        } else {
            rRSP = baseRSP - iRSP;
        }

        for (int tier = 0; tier <= 4; tier++) {
            for (int skill = 0; skill <= 3; skill++) {
                try {
                    if (level < rSkillLvl[tier][skill][skillLvl[tier][skill] - 1]) {
                        resetSkillPoints(ALL);
                        return "resetall";
                    }
                } catch (ArrayIndexOutOfBoundsException aioobe) {

                }

            }
        }

        return "";
    }

    public void setInitialSkillPoints() {
        rSP = baseSP;
        rEP = baseEP;
        rRSP = baseRSP;
    }

    public void resetSkillPoints(boolean allOrTier5) {
        if (allOrTier5 == ALL) {
            rSP = baseSP;
            rEP = baseEP;
            rRSP = baseRSP;
            iSP = 0;
            iEP = 0;
            iRSP = 0;
            resetSkills(ALL);
        } else {
            rRSP = baseRSP;
            iRSP = 0;
            resetSkills(TIER5);
        }
    }

    private void resetSkills(boolean allOrTier5) {
        final int ALLTIER = 0;
        final int TIER5 = 4;
        int tier;
        if (allOrTier5 == ALL) {
            tier = ALLTIER;
        } else {
            tier = TIER5;
        }

        for (int x = tier; x <= 4; x++) {
            for (int y = 0; y <= 3; y++) {
                skillLvl[x][y] = 0;
            }
        }
    }

    public void raiseSkillLevel(int tier, int skill, boolean upOrDown) {
        if (upOrDown == UP) {
            if (tier >= 0 && tier <= 2) {
                if (rSP != 0 && skillLvl[tier][skill] < 10 && level >= rSkillLvl[tier][skill][skillLvl[tier][skill]]) {
                    skillLvl[tier][skill]++;
                    rSP--;
                    iSP++;
                }
            } else if (tier == 3) {
                if (rEP != 0 && skillLvl[tier][skill] < 10 && level >= rSkillLvl[tier][skill][skillLvl[tier][skill]]) {
                    skillLvl[tier][skill]++;
                    rEP--;
                    iEP++;
                }
            } else if (tier == 4) {
                if (rRSP != 0 && skillLvl[tier][skill] < 10 && level >= rSkillLvl[tier][skill][skillLvl[tier][skill]]) {
                    skillLvl[tier][skill]++;
                    rRSP--;
                    iRSP++;
                }
            }
        } else {
            if (tier >= 0 && tier <= 2) {
                if (skillLvl[tier][skill] > 1) {
                    skillLvl[tier][skill]--;
                    rSP++;
                    iSP--;
                }
            } else if (tier == 3) {
                if (skillLvl[tier][skill] > 1) {
                    skillLvl[tier][skill]--;
                    rEP++;
                    iEP--;
                }
            } else if (tier == 4) {
                if (skillLvl[tier][skill] > 1) {
                    skillLvl[tier][skill]--;
                    rRSP++;
                    iRSP--;
                }
            }
        }
    }

    private void gerarLevelReqSkill() {
        rSkillLvl[0][0][0] = 10;
        rSkillLvl[0][1][0] = 12;
        rSkillLvl[0][2][0] = 14;
        rSkillLvl[0][3][0] = 17;
        rSkillLvl[1][0][0] = 20;
        rSkillLvl[1][1][0] = 23;
        rSkillLvl[1][2][0] = 26;
        rSkillLvl[1][3][0] = 30;
        rSkillLvl[2][0][0] = 40;
        rSkillLvl[2][1][0] = 43;
        rSkillLvl[2][2][0] = 46;
        rSkillLvl[2][3][0] = 50;
        rSkillLvl[3][0][0] = 60;
        rSkillLvl[3][1][0] = 63;
        rSkillLvl[3][2][0] = 66;
        rSkillLvl[3][3][0] = 70;
        rSkillLvl[4][0][0] = 82;
        rSkillLvl[4][1][0] = 85;
        rSkillLvl[4][2][0] = 88;
        rSkillLvl[4][3][0] = 92;

        for (int tier = 0; tier <= 4; tier++) {
            for (int skill = 0; skill <= 3; skill++) {
                for (int lvl = 0; lvl <= 9; lvl++) {
                    rSkillLvl[tier][skill][lvl] = rSkillLvl[tier][skill][0] + (2 * lvl);
                    //System.out.println("Tier: " + (tier + 1) + " Skill: " + (skill + 1) + " Req Lvl:" + rSkillLvl[tier][skill][lvl]);
                }
            }
        }

    }

    public int getrSP() {
        return rSP;
    }

    public int getrEP() {
        return rEP;
    }

    public int getrRSP() {
        return rRSP;
    }

    public int getBaseSP() {
        return baseSP;
    }

    public int getBaseEP() {
        return baseEP;
    }

    public int getBaseRSP() {
        return baseRSP;
    }

    public int[][] getSkillLvl() {
        return skillLvl;
    }

    public boolean isSkillLvlMatch(int tier, int skill) {
        if (level >= rSkillLvl[tier][skill][skillLvl[tier][skill]]) {
            return true;
        } else {
            return false;
        }
    }

    public Skill getSkill(int tier, int skill) {
        return this.skill[tier][skill];
    }

    public void setSkill(Skill skillc, int tier, int skill) {
        this.skill[tier][skill] = skillc;
    }
    
    public String setSkillTooltip(int tier, int skill) {
        String tooltip;
        int skillLevel = this.skillLvl[tier][skill]; 
        switch (skillLevel) {
            case 0:
                raiseSkillLevel(tier, skill, UP);
                tooltip = this.skill[tier][skill].getTooltip(Skill.TT_SINGLE);
                skillLvl[tier][skill] = 0;
                break;
            case 10:
                tooltip = this.skill[tier][skill].getTooltip(Skill.TT_SINGLE);
                break;
            default:
                tooltip = this.skill[tier][skill].getTooltip(Skill.TT_SINGLE);
                raiseSkillLevel(tier, skill, UP);
                tooltip += this.skill[tier][skill].getTooltip(Skill.TT_NEXT_LV);
                raiseSkillLevel(tier, skill, DOWN);
                break;
        }
        return tooltip;
    }
    
    

}
