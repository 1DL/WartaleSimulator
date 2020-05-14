/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.game.formula.morion;

import controller.game.formula.Formulas;
import controller.game.skill.Skill;
import controller.game.skill.SkillATS;

/**
 *
 * @author Luiz
 */
public class Atalanta extends Formulas {
    private final int baseStr = 23;
    private final int baseSpi = 15;
    private final int baseTal = 19;
    private final int baseAgi = 19;
    private final int baseHp = 23;

    public int getBaseStr() {
        return baseStr;
    }

    public int getBaseSpi() {
        return baseSpi;
    }

    public int getBaseTal() {
        return baseTal;
    }

    public int getBaseAgi() {
        return baseAgi;
    }

    public int getBaseHp() {
        return baseHp;
    }

    public Atalanta() {
        
        super.setClasse("Atalanta");
        //Every 150 strength (add 150 extra strength) = 100% weapon damage boost (Mechanician/Atalanta wearing melee weapons)
        super.meleeWepModifier = 150;
        //Every 130 agility (add 130 extra agility) = 100% weapon damage boost (Archer/Atalanta wearing Bow/Javelin)
        super.rangedWepModifier = 130;
        /*
        If other class and not wearing a weapon:
            +1 damage
            every 200 str = +1 damage
            every 50 of (talent+agility) = +1 min damage
            every 45 of (talent+agility) = +1 max damage
         */
        super.noWeaponStrModifier = 200;        
        super.noWeaponAgiTalModifierMin = 50;
        super.noWeaponAgiTalModifierMax = 45;
        /*
        If Mechanician/Atalanta and wearing melee weapon:
            every 45 (talent+agility) = +1 damage
         */
        super.meleeWeaponTalAgiModifier = 45;
        
        /*
        If Archer/Atalanta and wearing range weapon (Bow/Javalin):
            every 40 (talent+strength) = +1 damage
        */
        super.rangedWeaponTalStrModifier = 40;
        
        
        
        setBaseStats();
        
        for (int tier = 0; tier <= 4; tier++) {
            for (int skill = 0; skill <= 3; skill++) {
                Skill skillChar = new SkillATS(this, tier, skill);
                super.setSkill(skillChar, tier, skill);
            }
        }
    }
    
    
    
    private void setBaseStats(){
        super.setBaseStr(baseStr);
        super.setBaseSpi(baseSpi);
        super.setBaseTal(baseTal);
        super.setBaseAgi(baseAgi);
        super.setBaseVit(baseHp);
        classWeaponMatch();
    }
    
    private void classWeaponMatch(){
        try {
            if (weaponType.equals("Javelin")) {
            super.classWeaponMatch = true;
        }
        } catch (NullPointerException npe) {
            super.classWeaponMatch = false;
        }
    }

}
