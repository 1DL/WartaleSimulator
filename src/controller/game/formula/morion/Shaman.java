/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.game.formula.morion;

import controller.game.formula.Formulas;
import controller.game.skill.Skill;
import controller.game.skill.SkillSS;

/**
 *
 * @author Luiz
 */
public class Shaman extends Formulas {
    private final int baseStr = 15;
    private final int baseSpi = 27;
    private final int baseTal = 20;
    private final int baseAgi = 15;
    private final int baseHp = 22;

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

    public Shaman() {
            
        super.setClasse("Shaman");
        //Every 190 strength (add 190 extra strength) = 100% weapon damage boost (Archer/Priestess/Magician/Shaman wearing melee weapons)
        super.meleeWepModifier = 190;
        //Every 190 agility (add 190 extra agility) = 100% weapons damage boost (other classes wearing range weapons)
        super.rangedWepModifier = 190;
        //Every 150 spirit (add 150 extra spirit) = 100% weapon damage boost (Magician/Shaman wearing Staff/Wand)
        super.magicWepModifier = 150;
        
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
        If Archer/Priestess/Magician/Shaman and wearing melee weapon:
            every 50 (talent+agility) = +1 damage
         */
        super.meleeWeaponTalAgiModifier = 50;
        
        /*
        If other class and wearing range weapon (Bow/Javelin):
            every 50 (talent+strength) = +1 damage
        */
        super.rangedWeaponTalStrModifier = 50;
        
        /*
        If Magician/Shaman/Priestess and wearing Staff/Wand:
            every 30 talent = +1 damage
        */
        super.magicWeaponTalModifier = 30;

        
        
        setBaseStats();
        
        for (int tier = 0; tier <= 4; tier++) {
            for (int skill = 0; skill <= 3; skill++) {
                Skill skillChar = new SkillSS(this, tier, skill);
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
            if (weaponType.equals("Phantom")) {
            super.classWeaponMatch = true;
        }
        } catch (NullPointerException npe) {
            super.classWeaponMatch = false;
        }
    }

}
