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
    protected String descOriginal;
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

    public static final byte NONE = 0;
    public static final byte ACTIVERIGHT = 1;
    public static final byte ACTIVELEFT = 2;
    public static final byte ACTIVEBOTH = 3;
    public static final byte PASSIVE = 4;
    public static final byte ACTIVEKEY = 5;

    public int getTier() {
        return tier;
    }

    public int getSkill() {
        return skill;
    }

    public void buildTooltip() {
        tooltip = "<html>";
        tooltip += "<font color='white'><b>" + name + "</b></font><br>";
        tooltip += "<font color='orange'>(Required Level: " + (reqLvl + (2 * c.getSkillLvl()[tier][skill])) + ")</font><br>";
        tooltip += "<font color='silver'>" + descOriginal + "</font><br><br>";
        tooltip += "<font color='green'>Correct Item Group</font><br>";
        tooltip += "<font color='white'>" + areqItem() + "</font><br>";
        tooltip += "<font color='purple'>" + aMonBonus() + "</font><br>";
        tooltip += "<font color='orange'>" + aTribValues()+ "</font><br>";
        tooltip += "<font color='silver'>" + aSkillCost()+ "</font>";
    }

    private String areqItem() {
        String msg = "";
        for (String item : reqItem) {
            msg += item + ", ";
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
            if (useHP.length >= 1) {
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
        return tooltip;
    }

}
