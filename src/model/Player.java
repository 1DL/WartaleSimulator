/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.game.formula.CharacterStats;

/**
 *
 * @author Luiz
 */
public class Player {
    static final int PLAYER = 1;
    static final int ENEMY = 2;
    
    private int activeGearSet = 1;
    
    private int side = PLAYER;
    //Character
    private String name = "DarkLink64";
    private String job = "Knight";
    private String jobTitle = "Crusader";
    private int jobId = 7;
    protected int level = 155;
    protected long exp = 1;
    
    //elemental
    private int organic = 0;
    private int poison = 0;
    private int fire = 0;
    private int lightning = 0;
    private int ice = 0;
    private int water = 0;
    private int wind = 0;
    
    //resources
    private int hp = 100;
    private int mp = 100;
    private int sp = 100;
    private float hpRegen = 0f;
    private float mpRegen = 0f;
    private float spRegen = 0f;
    
    //attributes
    private int str = 1;
    private int spi = 1;
    private int tal = 1;
    private int agi = 1;
    private int vit = 1;
    private int remain = 1;
    
    private int baseStr = 1;
    private int baseSpi = 1;
    private int baseTal = 1;
    private int baseAgi = 1;
    private int baseVit = 1;
    
    //offense
    private int minAtkPow = 1;
    private int maxAtkPow = 2;
    private int atkRtg = 1;
    private float atkSpd = 0;
    private float criticalChance = 0f;
    private float criticalDamage = 70f;
    //defense
    private int defense = 1;
    private int abs = 1;
    private int block = 0;
    private int[] evasion = {0,0,0,0,0,0,0,0,0,0,0,0};
    /*
    evasion ids:
    0 = gear evasion
    1 = passive evasion 1
    2 = passive evasion 2
    3 = passive evasion 3
    4 = active evasion 1
    5 = active evasion 2
    6 = active evasion 3
    7 = valhalla evasion
    8 = assassin aura evasion
    9 = pvp/pve scroll evasion
    10 = big head evasion
    11 = siege war evasion
    */
    private int moveSpeed = 0;
    
    private Gear gears[];
    private SkillModel skills[];
    
    //Base Damage formula
    
    //base without weapon
    protected int baseWithoutWeaponMin;
    protected int baseWithoutWeaponMax;
    
    //base with weapon
    
    protected int baseWithWeaponMin;
    protected int baseWithWeaponMax;
    
    //ranged = agi modifier, melee = str modifier, magic = spi modifier
    protected int rangedWeaponAgi;
    protected int meleeWeaponStr;
    protected int magicWeaponSpi;
    
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

    public Player(CharacterStats character, int side) {
        initialize(character, side);
    }
    
    public void initialize(CharacterStats c, int side) {
        
        this.side = side;
        this.name = c.getPlayerName();
        this.job = c.getJobName();
        this.jobTitle = c.getJobTitle()[4];
        this.jobId = c.getJobId();
        this.level = c.getLevel();
        this.exp = c.getExp();
        this.activeGearSet = 1;
        
        this.str = c.getStrenght();
        this.spi = c.getSpirit();
        this.agi = c.getAgility();
        this.tal = c.getTalent();
        this.vit = c.getHealth();
        this.remain = c.getRemainStats();
        
        this.baseStr = c.getBaseStr();
        this.baseSpi = c.getBaseSpi();
        this.baseAgi = c.getBaseAgi();
        this.baseTal = c.getBaseTal();
        this.baseVit = c.getBaseVit();
        
        this.baseWithWeaponMin = c.getBaseWithWeaponMin();
        this.baseWithWeaponMax = c.getBaseWithWeaponMax();
        this.rangedWeaponAgi = c.getRangedWeapon();
        this.meleeWeaponStr = c.getMeleeWeapon();
        this.magicWeaponSpi = c.getMagicWeapon();
        
        this.bareHandedFlat = c.getBareHandedFlat();
        this.bareHandedStr = c.getBareHandedStr();
        this.bareHandedTalAgiMin = c.getBareHandedTalAgiMin();
        this.bareHandedTalAgiMax = c.getBareHandedTalAgiMax();
        
        this.meleeTalAgi = c.getMeleeTalAgi();
        this.rangedStrTal = c.getRangedStrTal();
        this.magicTal = c.getMagicTal();
        
        this.additionalMin = c.getAdditionalMin();
        this.additionalMax = c.getAdditionalMax();
        
        this.baseCriticalDamage = c.getBaseCriticalDamage();
        
         this.absDef = c.getAbsDef();
         this.absLvl = c.getAbsLvl();
         this.absStr = c.getAbsStr();
         this.absSpi = c.getAbsSpi();
         this.absTal = c.getAbsTal();
         this.absAgi = c.getAbsAgi();
         this.absVit = c.getAbsVit();
         this.absPointExtra = c.getAbsPointExtra();
         
        this.atrLvl = c.getAtrLvl();
        this.atrStr = c.getAtrStr();
        this.atrSpi = c.getAtrSpi();
        this.atrTal = c.getAtrTal();
        this.atrAgi = c.getAtrAgi();
        this.atrVit = c.getAtrVit();

        //def
        this.defLvl = c.getDefLvl();
        this.defStr = c.getDefStr();
        this.defSpi = c.getDefSpi();
        this.defTal = c.getDefTal();
        this.defAgi = c.getDefAgi();
        this.defVit = c.getDefVit();

        //hp
        this.hpLvl =  c.getHpLvl();
        this.hpStr =  c.getHpStr();
        this.hpSpi =  c.getHpSpi();
        this.hpTal =  c.getHpTal();
        this.hpAgi =  c.getHpAgi();
        this.hpVit =  c.getHpVit();
        this.hpFlat = c.getHpFlat();

        //mp
        this.mpLvl =  c.getMpLvl();
        this.mpStr =  c.getMpStr();
        this.mpSpi =  c.getMpSpi();
        this.mpTal =  c.getMpTal();
        this.mpAgi =  c.getMpAgi();
        this.mpVit =  c.getMpVit();
        this.mpFlat = c.getMpFlat(); 

        //sp
        this.spLvl = c.getSpLvl();
        this.spStr = c.getSpStr();
        this.spSpi = c.getSpSpi();
        this.spTal = c.getSpTal();
        this.spAgi = c.getSpAgi();
        this.spVit = c.getSpVit();
        this.spFlat = c.getSpFlat();

        //max weight
        this.weightLvl = c.getWeightLvl();
        this.weightStr = c.getWeightStr();
        this.weightSpi = c.getWeightSpi();
        this.weightTal = c.getWeightTal();
        this.weightAgi = c.getWeightAgi();
        this.weightVit = c.getWeightVit();
        this.weightFlat = c.getWeightFlat();

        //running speed/walk speed
        this.runBase = c.getRunBase();
        this.runLvl = c.getRunLvl();
        this.runStr = c.getRunStr();
        
        this.gears = new Gear[21];
        //main
        this.gears[GearSlot.ARMOR_ID] = new Gear(c, GearSlot.ARMOR_ID);
        this.gears[GearSlot.SET1_H_LEFT_ID] = new Gear(c, GearSlot.SET1_H_LEFT_ID);
        this.gears[GearSlot.SET1_H_RIGHT_ID] = new Gear(c, GearSlot.SET1_H_RIGHT_ID);
        this.gears[GearSlot.SET2_H_LEFT_ID] = new Gear(c, GearSlot.SET2_H_LEFT_ID);
        this.gears[GearSlot.SET2_H_RIGHT_ID] = new Gear(c, GearSlot.SET2_H_RIGHT_ID);
        //defense
        this.gears[GearSlot.BRACELET_ID] = new Gear(c, GearSlot.BRACELET_ID);
        this.gears[GearSlot.GAUNTLET_ID] = new Gear(c, GearSlot.GAUNTLET_ID);
        this.gears[GearSlot.BOOTS_ID] = new Gear(c, GearSlot.BOOTS_ID);
        //acessory
        this.gears[GearSlot.AMULET_ID] = new Gear(c, GearSlot.AMULET_ID);
        this.gears[GearSlot.RING1_ID] = new Gear(c, GearSlot.RING1_ID);
        this.gears[GearSlot.RING2_ID] = new Gear(c, GearSlot.RING2_ID);
        this.gears[GearSlot.SHELTOM_ID] = new Gear(c, GearSlot.SHELTOM_ID);
        this.gears[GearSlot.EARRING1_ID] = new Gear(c, GearSlot.EARRING1_ID);
        this.gears[GearSlot.EARRING2_ID] = new Gear(c, GearSlot.EARRING2_ID);
        this.gears[GearSlot.BELT_ID] = new Gear(c, GearSlot.BELT_ID);
        //visual
        this.gears[GearSlot.V_ARMOR_ID] = new Gear(c, GearSlot.V_ARMOR_ID);
        this.gears[GearSlot.V_SET1_H_LEFT] = new Gear(c, GearSlot.V_SET1_H_LEFT);
        this.gears[GearSlot.V_SET1_H_RIGHT] = new Gear(c, GearSlot.V_SET1_H_RIGHT);
        this.gears[GearSlot.V_SET2_H_LEFT] = new Gear(c, GearSlot.V_SET2_H_LEFT);
        this.gears[GearSlot.V_SET2_H_RIGHT] = new Gear(c, GearSlot.V_SET2_H_RIGHT);
        
        this.skills = new SkillModel[21];
        
        int skillCount = 0;
        
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 4; j++) {
                this.skills[skillCount] = new SkillModel(this.jobId, c.getSkill(i, j), c.getSkillLvl()[i][j]);
                skillCount++;
            }
        } 
    }   
}
