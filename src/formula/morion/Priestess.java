/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula.morion;

import formula.Formulas;
import skill.Skill;
import skill.SkillPRS;

/**
 *
 * @author Luiz
 */
public class Priestess extends Formulas {
    private final int baseStr = 15;
    private final int baseSpi = 28;
    private final int baseTal = 21;
    private final int baseAgi = 15;
    private final int baseHp = 20;

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

    public Priestess(){
        
        super.setClasse("Priestess");
        //Every 190 strength (add 190 extra strength) = 100% weapon damage boost (Archer/Priestess/Magician/Priestess wearing melee weapons)
        super.meleeWepModifier = 190;
        //Every 190 agility (add 190 extra agility) = 100% weapons damage boost (other classes wearing range weapons)
        super.rangedWepModifier = 190;
        //Every 150 spirit (add 150 extra spirit) = 100% weapon damage boost (Priestess wearing Staff/Wand)
        super.magicWepModifier = 170;
        
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
        If Archer/Priestess/Magician/Priestess and wearing melee weapon:
            every 50 (talent+agility) = +1 damage
         */
        super.meleeWeaponTalAgiModifier = 50;
        
        /*
        If other class and wearing range weapon (Bow/Javelin):
            every 50 (talent+strength) = +1 damage
        */
        super.rangedWeaponTalStrModifier = 50;
        
        /*
        If Magician/Priestess/Shaman and wearing Staff/Wand:
            every 30 talent = +1 damage
        */
        super.magicWeaponTalModifier = 30;

        
        
        setBaseStats();
        
        for (int tier = 0; tier <= 4; tier++) {
            for (int skill = 0; skill <= 3; skill++) {
                Skill skillChar = new SkillPRS(this, tier, skill);
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
            if (weaponType.equals("Wand")) {
            super.classWeaponMatch = true;
        }
        } catch (NullPointerException npe) {
            super.classWeaponMatch = false;
        }
    }

}
