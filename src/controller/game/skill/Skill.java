/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.game.skill;

import controller.game.formula.CharacterStats;

/**
 *
 * @author Luiz
 */
public class Skill {

    CharacterStats c;
    //Identificadores e requerimentos
    protected int tier;
    protected int skill;
    protected int[] reqLvl;
    protected String charClass;
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
    protected int[] hits;
    protected int[] hitsInterval;
    protected int castTime = 0;
    protected int castSpeed = 0;
    protected int element = 0;
    
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
    public static int E_NORMAL = 0;
    public static int E_ORGANIC = 1;
    public static int E_POISON = 2;
    public static int E_ICE = 3;
    public static int E_LIGHT = 4;
    public static int E_FIRE = 5;
    
    
    //AS= Attribute of skill 
    //Ofensivos
    public static final String AS_DMG_BOOST = "Damage Boost";
    
    //Defensivos
    public static final String AS_ADD_BLOCK = "Added Block Chance";
    //Misc
    public static final String AS_PUSHBACK_RANGE = "Pushback Range";
    
    
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

}
