/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skill;

import formula.CharacterStats;

/**
 *
 * @author Luiz
 */
public class Skill {

    CharacterStats c;
    protected String name;
    protected String desc;
    protected String lore;
    protected String charClass;
    protected int tier;
    protected int skill;
    protected int reqLvl;
    protected String[] reqItem;
    protected byte useMethod;
    protected int[] useHP;
    protected int[] useMP;
    protected int[] useSP;
    protected int[] cooldown;
    protected int[] duration;
    protected int[] skillCost;
    protected String skillImg;
    protected String timerImg;
    protected String[] attribute;
    protected int[][] value;
    protected String tooltip;
    protected String type;
    protected String monsterBonus[];
    protected int monsterValue;
    protected boolean canCrit = false;
    protected int hits = 0;
    protected int[] hitsInterval;
    protected int castTime = 0;
    protected int castSpeed = 0;
    

    
    //CS = Cast Skill mouse click
    public static final byte CS_NONE = 0;
    public static final byte CS_RIGHT = 1;
    public static final byte CS_LEFT = 2;
    public static final byte CS_BOTH = 3;
    public static final byte CS_PASSIVE = 4;
    public static final byte CS_ACTIVEKEY = 5;
    
    //Skill Effect Type
    
    public static final String ES_AOE = "Area of Effect";
    public static final String ES_LINEAR = "Linear Area";
    public static final String ES_CONE = "Cone shaped Area";
    public static final String ES_1V1 = "Single Target";
    public static final String ES_SELF_BUFF = "Self Buff";
    public static final String ES_ALLY_BUFF = "Target Ally Buff";
    public static final String ES_SELF_AURA = "Buff Aura";
    public static final String ES_ALLY_AREA_BUFF = "Ally Area Buff";
    
    //TS = Type of Skill
    public static final String TS_OFFENSE = "Active Offense";
    public static final String TS_BUFF = "Active Buff";
    public static final String TS_PASSIVE = "Passive";
    
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
    
    
    //AS= Attribute of skill 
    
    public static final String AS_DMG_BOOST = "Damage Boost";
    public static final String AS_PUSHBACK_RANGE = "Pushback Range";
    
    //Const para receber dados da model
    
    public static final int MS = 99;
    public static final int FS = 99;
    public static final int PS = 99;
    public static final int AS = 99;
    public static final int ASS = 99;
    public static final int KS = 0;
    public static final int ATS = 99;
    public static final int PRS = 99;
    public static final int MGS = 99;
    public static final int SS = 99;
    
    public static final int SKILL_NAME = 0;
    public static final int SKILL_DESC = 1;
    public static final int SKILL_TYPE = 2;
    public static final int SKILL_LORE = 3;
    
    public int getTier() {
        return tier;
    }

    public int getSkill() {
        return skill;
    }

    public void buildTooltip() {
        //<html><div style='text-align: center;'> </div></html>"
        tooltip = "<html><div style='text-align: center;'>";
        tooltip += "<font color='white'><b>" + name + "</b></font><br>";
        tooltip += "<font color='orange'>(Required Level: " + (reqLvl + (2 * c.getSkillLvl()[tier][skill])) + ")</font><br>";
        tooltip += "<font color='silver'>" + descOriginal + "</font><br><br>";
        tooltip += "<font color='green'>Correct Item Group</font><br>";
        tooltip += "<font color='white'>" + areqItem() + "</font><br>";
        tooltip += "<font color='purple'>" + aMonBonus() + "</font></div><br>";
        tooltip += "<font color='orange'>" + aTribValues()+ "</font><br>";
        tooltip += "<font color='silver'>" + aSkillCost()+ "</font></html>";
    }

    private String areqItem() {
        String msg = "";
        int count = 0;
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
        if (monsterBonus.length == 2) {
            msg = "(" + monsterBonus[0] + " and " + monsterBonus[1] + " +" + monsterValue + "%)";
        } else {
            msg = "(" + monsterBonus[0] + " +" + monsterValue + "%)";
        }
        return msg;
    }

    private String aTribValues() {
        String msg = "";
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

    public String getTooltip() {
        buildTooltip();
        return tooltip;
    }

}
