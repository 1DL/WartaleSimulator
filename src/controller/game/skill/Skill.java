/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.game.skill;

import controller.assets.assetsController;
import controller.game.formula.CharacterStats;

/**
 *
 * @author Luiz
 */
public class Skill extends assetsController{

    CharacterStats c;
    //Identificadores e requerimentos
    protected int tier;
    protected int skill;
    protected int[] reqLvl;
    protected String charClass;
    protected float pvpModifier = 1f;
    protected boolean released = true;
    //Descrição
    protected String name;
    protected String desc;
    protected String effect;
    protected String type;
    protected String lore;
    protected String[] reqItem;
    protected String castMethod;
    //Recurso gasto
    protected int[] useHP;
    protected int[] useMP;
    protected int[] useSP;
    protected int[] cooldown;
    protected int[] duration;
    protected int[] skillCost;
    //Arquivos de img e som
    protected String skillImg;
    protected String timerImg;
    protected String elementImg;
    protected String[] soundSFX;
    //misc
    protected String[] attribute;
    protected float[][] value;
    protected String tooltip;
    protected String monsterBonus[];
    protected int monsterValue;
    protected boolean[] canCrit;
    protected boolean halfPartyCast = false;
    protected int[] hits;
    protected int[] hitsInterval;
    protected int castTime = 0;
    protected int castSpeed = 0;
    protected int element = 0;
    protected boolean skillChain = false;
    protected int[] tierSkillChained;
    protected int chainedSkillEffectIndex = 0;
    protected int[][] tierSkillCancelOnCast;
    
    //Skill sound fx type
    
    public static final String SFX_WEAPON = "Weapon";
    
    //Element Icon filename
    
    public static final String ICON_WATER = "";
    public static final String ICON_FIRE = "";
    public static final String ICON_ORGANIC = "";
    public static final String ICON_POISON = "";
    public static final String ICON_LIGHTNING = "";
    public static final String ICON_ICE = "";
    public static final String ICON_WIND = "";
    public static final String ICON_NORMAL = "";
    
    //CS = Cast Skill mouse click
    public static final String CS_NONE = "None";
    public static final String CS_RIGHT = "Right click";
    public static final String CS_LEFT = "Left click";
    public static final String CS_BOTH = "Left/Right click";
    public static final String CS_ACTIVEKEY = "Active Key";
    
    //Skill Effect Type
    
    public static final String ES_AOE = "Area of Effect";
    public static final String ES_LINEAR = "Linear Area";
    public static final String ES_CONE = "Cone shaped Area";
    public static final String ES_1V1 = "Single Target";
    public static final String ES_1V1_AND_AOE = "2 hits - One 1v1 on Target and AoE";
    public static final String ES_SELF_BUFF = "Self Buff";
    public static final String ES_ALLY_BUFF = "Target Ally Buff";
    public static final String ES_SELF_AURA = "Buff Aura";
    public static final String ES_ALLY_AREA_BUFF = "Ally Area Buff";
    public static final String ES_SUMMON = "Summon";
    
    //TS = Type of Skill
    public static final String TS_OFFENSE = "Active Offense";
    public static final String TS_BUFF = "Active Buff";
    public static final String TS_PASSIVE = "Passive";
    public static final String TS_DEBUFF = "Active Debuff";
    public static final String TS_CURSE = "Curse";
    
    //WS = Required Weapon for Skill cast
    
    public static final String WS_ANY = "Any";
    public static final String WS_AXE = "Axe";
    public static final String WS_BOW = "Bow";
    public static final String WS_CLAW = "Claw";
    public static final String WS_DAGGER = "Dagger";
    public static final String WS_HAMMER = "Hammer";
    public static final String WS_JAVELIN = "Javelin";
    public static final String WS_PHANTOM = "Pantom";
    public static final String WS_SCYTHE = "Scythe";
    public static final String WS_SWORD = "Sword";
    public static final String WS_WAND = "Wand";
    public static final String WS_SHIELD = "Shield";
    public static final String WS_ARMOR = "Armor";
    
    
    
    //MB = vs Monster Bonus
   
    public static final String MB_NORMAL = "Normal";
    public static final String MB_MUTANT = "Mutant";
    public static final String MB_DEMON = "Demon";
    public static final String MB_MECHANIC = "Mechanic";
    public static final String MB_UNDEAD = "Undead";
    
    //E = Ofensive Element
    public static final int E_NORMAL = 0;
    public static final int E_ORGANIC = 1;
    public static final int E_POISON = 2;
    public static final int E_ICE = 3;
    public static final int E_LIGHT = 4;
    public static final int E_FIRE = 5;
    public static final int E_WATER = 6;
    public static final int E_WIND = 7;
    
    
    //AS= Attribute of skill 
    //Ofensivos
    public static final String AS_DMG_BOOST = "Damage Boost";
    public static final String AS_UNDEAD_DMG_BOOST = "Undead Damage Boost";
    public static final String AS_VAR_FLAT_MIN_DMG_BOOST = "Variable Flat Dmg";
    public static final String AS_VAR_FLAT_MAX_DMG_BOOST = "Variable Flat Max Dmg";
    public static final String AS_ADD_FLAT_CRIT_CHANCE = "Added Critical Chance";
    public static final String AS_ADD_ATK_RTG_BOOST = "Attack Rating Boost";
    public static final String AS_STUN_DUR = "Stun Duration";
    public static final String AS_STUN_CHANCE = "Stun Chance";
    public static final String AS_ATK_INTERVAL = "Attack Interval";
    public static final String AS_CHARGE_DMG = "1v1 Charged Final Damage Boost";
    
    //Ofensive Buff
    public static final String AS_ADD_FLAT_ATK_POW = "Added Attack Power";
    public static final String AS_ADD_FLAT_LVL_MAX_ATK_POW = "Added Max Attack Power";
    public static final String AS_ADD_LVL_DIV_MAX_ATK_POW = "Added Max Attack Power Lv Divisor";
    public static final String AS_ADD_FLAT_ATK_RTG = "Added Attack Rating";
    public static final String AS_ADD_ATK_SPD = "Added Attack Speed";
    public static final String AS_1V1_UNDEAD_DMG_BOOST = "1v1 Undead Damage Boost";
    public static final String AS_CRIT_DMG_BOOST = "Critical Damage Boost";
    public static final String AS_MON_CRIT_CHANCE_BOOST = "Vs Monster Critical Chance Boost";
    public static final String AS_NEXT_HIT_DMG_BOOST = "Next Hit Damage Boost";
    public static final String AS_NEXT_SKILL_DMG_BOOST = "Next Skill Damage Boost";
    public static final String AS_NEXT_SKILL_ATK_RTG_BOOST = "Next Skill Attack Rating Boost";
     
    //Defensive Buff
    public static final String AS_ADD_ABS = "Added Absorb";
    public static final String AS_ADD_EVASION = "Added Evasion";
    public static final String AS_DMG_RED = "Damage Reduction";
    public static final String AS_MON_DMG_RED = "Monster Damage Reduction";
    public static final String AS_MON_UNDEAD_DMG_RED = "Undead Monster Damage Reduction";
    public static final String AS_ADD_DEF_BOOST = "Defense Boost";
    public static final String AS_ADD_SHIELD_BLOCK = "Added Shield Block Chance";
    public static final String AS_MON_UNDEAD_BLOCK_HP_CONVERT = "Blocked Undead HP Conversion";
    public static final String AS_ADD_HP_REGEN = "Added HP Regen";
    
    //Misc buff
    public static final String AS_VISIBILITY = "Visibility";
    public static final String AS_ADD_MOVESPEED = "Move Speed";
    public static final String AS_UNDEAD_PET_CHANCE = "Undead Pet Sucess Rate";
    public static final String AS_UNDEAD_PET_HP = "Increase Undead Pet HP";
    
    //Debuff
    public static final String AS_ICE_SLOW_DUR = "Freeze Duration";
    public static final String AS_ICE_SLOW_STR = "Freeze Strenght";
    public static final String AS_ADD_FINAL_DMG_BOOST = "Freeze Strenght";
    public static final String AS_ADD_FIRE_MIN_DMG = "Added Fire Damage";
    public static final String AS_ADD_FIRE_MAX_DMG = "Added Fire Damage Max";
    public static final String AS_ADD_LIGHT_MIN_DMG = "Added Lightning Damage";
    public static final String AS_ADD_LIGHT_MAX_DMG = "Added Lightning Damage Max";
    public static final String AS_ADD_ICE_MIN_DMG = "Added Ice Damage";
    public static final String AS_ADD_ICE_MAX_DMG = "Added Ice Damage Max";
    public static final String AS_BURN_DUR = "Burn Duration";
    public static final String AS_BURN_STR = "Burn Strenght";
    
    //Area Related
    public static final String AS_CAST_RANGE = "Cast Range";
    public static final String AS_AOE_RANGE = "Area Range";
    public static final String AS_LINEAR_RANGE = "Linear Range";
    public static final String AS_AURA_AOE_RANGE = "Aura Range";
    public static final String AS_PUSHBACK_RANGE = "Pushback Range";
    public static final String AS_AOE_LIGHT_RANGE = "Lightning Area";
    
    
    //Passivos
    public static final String AS_ADD_POISON_RES = "Added Poison Resistance";
    public static final String AS_ADD_STM_BOOST = "Stamina Boost";
    public static final String AS_ADD_WEAPON_DMG_BOOST = "Weapon Damage Boost";
    public static final String AS_ADD_MON_UNDEAD_1V1_FINAL_DMG = "Undead 1v1 Final Damage Boost";
    
    //Misc
    public static final String AS_HP_BOOST = "HP Boost";
    public static final String AS_MP_BOOST = "MP Boost";
    public static final String AS_SP_BOOST = "SP Boost";
    public static final String AS_NUMBER_ENEMY_SEC = "# of Enemies per sec";
    public static final String AS_UNDEAD_MAX_HP_DRAIN = "HP Drained from nearby Undead Monsters";
    public static final String AS_BONUS_CHARGE_HIT = "Hits required to Charge";
    
    
    //Const para receber dados da model
    
    public static final int MS = 0;
    public static final int FS = 1;
    public static final int PS = 2;
    public static final int AS = 3;
    public static final int ASS = 4;
    public static final int KS = 5;
    public static final int ATS = 6;
    public static final int PRS = 7;
    public static final int MGS = 8;

    public int[] getReqLvl() {
        return reqLvl;
    }

    public String getCharClass() {
        return charClass;
    }

    public float getPvpModifier() {
        return pvpModifier;
    }

    public boolean isReleased() {
        return released;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getEffect() {
        return effect;
    }

    public String getType() {
        return type;
    }

    public String getLore() {
        return lore;
    }

    public String[] getReqItem() {
        return reqItem;
    }

    public String getCastMethod() {
        return castMethod;
    }

    public int[] getUseHP() {
        return useHP;
    }

    public int[] getUseMP() {
        return useMP;
    }

    public int[] getUseSP() {
        return useSP;
    }

    public int[] getCooldown() {
        return cooldown;
    }

    public int[] getDuration() {
        return duration;
    }

    public int[] getSkillCost() {
        return skillCost;
    }

    public String getSkillImg() {
        return skillImg;
    }

    public String getTimerImg() {
        return timerImg;
    }

    public String[] getSoundSFX() {
        return soundSFX;
    }

    public String[] getAttribute() {
        return attribute;
    }

    public float[][] getValue() {
        return value;
    }

    public String getTooltip() {
        return tooltip;
    }

    public String[] getMonsterBonus() {
        return monsterBonus;
    }

    public int getMonsterValue() {
        return monsterValue;
    }

    public boolean[] getCanCrit() {
        return canCrit;
    }

    public boolean isHalfPartyCast() {
        return halfPartyCast;
    }

    public int[] getHits() {
        return hits;
    }

    public int[] getHitsInterval() {
        return hitsInterval;
    }

    public int getCastTime() {
        return castTime;
    }

    public int getCastSpeed() {
        return castSpeed;
    }

    public int getElement() {
        return element;
    }

    public boolean isSkillChain() {
        return skillChain;
    }

    public int[] getTierSkillChained() {
        return tierSkillChained;
    }

    public int getChainedSkillEffectIndex() {
        return chainedSkillEffectIndex;
    }

    public int[][] getTierSkillCancelOnCast() {
        return tierSkillCancelOnCast;
    }
    public static final int SS = 9;
    
    
    //Constantes para ser usados como índices ao retribuir strings do array Skill_STR do SkillList
    public static final int SKILL_NAME = 0;
    public static final int SKILL_DESC = 1;
    public static final int SKILL_TYPE = 2;
    public static final int SKILL_EFFECT = 3;
    public static final int SKILL_CLICK = 4;
    public static final int SKILL_LORE = 5;
    
    //Tipo de exibição da Tooltip
    public static final int TT_SINGLE = 0;
    public static final int TT_NEXT_LV = 1;
    
    public int getTier() {
        return tier;
    }

    public int getSkill() {
        return skill;
    }

    public void buildTooltip(int type) {
        int lvOffset;
        if (c.getSkillLvl()[tier][skill] <= 0) {
            lvOffset = 0;
        } else {
            lvOffset = 1;
        }
         
        switch (type) {
            case TT_SINGLE:
                tooltip = "<html><div style='text-align: center;'>";
                tooltip += "<font color='white'><b>" + name + "</b></font><br>";
                tooltip += "<font color='orange'>(Required Level: " + (reqLvl[c.getSkillLvl()[tier][skill]-lvOffset]) + ")</font><br>";
                tooltip += "<font color='silver'>" + desc + "</font><br>";
                tooltip += "<font color='pink'>" + lore + "</font><br>";
                tooltip += "<font color='green'>Correct Item Group</font><br>";
                tooltip += "<font color='white'>" + areqItem() + "</font><br>";
                tooltip += "<font color='purple'>" + aMonBonus() + "</font></div><br>";
                tooltip += "<font color='orange'>" + aTribValues()+ "</font><br>";
                tooltip += "<font color='silver'>" + aSkillCost()+ "</font>";
                break;
            case TT_NEXT_LV:
                tooltip = "<br><br><font color='ffdc00'>Next Level</font><br>";
                tooltip += "<font color='orange'>" + aTribValues()+ "</font><br>";
                tooltip += "<font color='silver'>" + aSkillCost()+ "</font>";
                break;
            default:
                break;
        }
    }
    /**
     * Gets the filename of skill element icon.
     * @return Checks what is the current set element for the skill, 
     * then returns the fileName of the skill element icon image.
     */
    public String getElementImg() {
        switch (element) {
            case E_NORMAL:
                return ICON_NORMAL;
            case E_FIRE:
                return ICON_FIRE;
            case E_WATER:
                return ICON_WATER;
            case E_WIND:
                return ICON_WIND;
            case E_ICE:
                return ICON_ICE;
            case E_ORGANIC:
                return ICON_ORGANIC;
            case E_LIGHT:
                return ICON_LIGHTNING;
            case E_POISON:
                return ICON_POISON;
            default:
                return "";
        }
    }

    private String areqItem() {
        String msg = "";
        int count = 0;
        if (reqItem == null) {
            return "Any";
        }
        for (String item : reqItem) {
            msg += item + ", ";
            count ++;
            if (count == 3) {
                msg += "<br>";
                count = 0;
            }
        }
        return msg.substring(0, msg.length() - 2);
    }

    private String aMonBonus() {
        String msg = "";
        if (monsterBonus == null) {
            return "";
        }
        switch (monsterBonus.length) {
            case 0:
                return msg;
            case 2:
                msg = "(" + monsterBonus[0] + " and " + monsterBonus[1] + " +" + monsterValue + "%)";
                break;
            default:
                msg = "(" + monsterBonus[0] + " +" + monsterValue + "%)";
                break;
        }
        return msg;
    }

    private String aTribValues() {
        String msg = "";
        if (attribute == null) {
            return "";
        }
        try {
            for (int i = 0; i < attribute.length; i++) {
                msg += attribute[i] + ": <b>" + value[i][c.getSkillLvl()[tier][skill] - 1];
                if (attribute[i].equals("Damage Boost")) {
                    msg += "%</b><br>";
                } else {
                    msg += "</b><br>";
                }
            }
            if (useHP[0] >= 1) {
                msg += "HP: " + useHP[c.getSkillLvl()[tier][skill] - 1] + "</b><br>";
            }
            msg += "MP: <b>" + useMP[c.getSkillLvl()[tier][skill] - 1] + "</b><br>";
            msg += "STM: <b>" + useSP[c.getSkillLvl()[tier][skill] - 1] + "</b><br>";
        } catch (ArrayIndexOutOfBoundsException aioobe) {

        }
        return msg;
    }
    
    private String aSkillCost(){
        return "Skill Cost: <b>" + skillCost[c.getSkillLvl()[tier][skill] - 1]+"</b>";
    }

    public String getTooltip(int type) {
        buildTooltip(type);
        return tooltip;
    }
    
    /**
     * Get the current skill colored image icon.
     * @param className - The character class name.
     * @param tier - The current skill tier.
     * @param skill - The current skill number within its tier.
     * @return The full path to colored skill icon.
     */
    public String getSkillIcon(String className, int tier, int skill){
        return SKILLIMG_DIR + className + "/Button/"+tier+skill+".bmp";
    }
    /**
     * Get the current skill disabled (black/white) image icon.
     * @param className - The character class name.
     * @param tier - The current skill tier.
     * @param skill - The current skill number within its tier.
     * @return The full path to black/white skill icon.
     */
    public String getDisabledSkillIcon(String className, int tier, int skill){
        return SKILLIMG_DIR + className + "/Button/"+tier+skill+"-.bmp";
    }
    
    public String getSkillSfx(int hitId){
        return SKILLSFX_DIR + c.getClasse() + "/" + name + hitId + ".wav";
    }
}
