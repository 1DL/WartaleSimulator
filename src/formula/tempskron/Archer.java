/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula.tempskron;

import formula.Formulas;
import skill.Skill;
import skill.SkillAS;

/**
 *
 * @author Luiz
 */
public class Archer extends Formulas {
    private final int baseStr = 17;
    private final int baseSpi = 11;
    private final int baseTal = 21;
    private final int baseAgi = 27;
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

    public Archer() {
        
        super.setClasse("Archer");
        //Every 190 strength (add 190 extra strength) = 100% weapon damage boost (Archer/Priestess/Magician/Shaman wearing melee weapons)
        super.meleeWepModifier = 190;
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
        If Archer/Priestess/Magician/Shaman and wearing melee weapon:
            every 50 (talent+agility) = +1 damage
         */
        super.meleeWeaponTalAgiModifier = 50;
        
        /*
        If Archer/Atalanta and wearing range weapon (Bow/Javalin):
            every 40 (talent+strength) = +1 damage
        */
        super.rangedWeaponTalStrModifier = 40;

        
        setBaseStats();
        
        for (int tier = 0; tier <= 4; tier++) {
            for (int skill = 0; skill <= 3; skill++) {
                Skill skillChar = new SkillAS(this, tier, skill);
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
            if (weaponType.equals("Bow")) {
            super.classWeaponMatch = true;
        }
        } catch (NullPointerException npe) {
            super.classWeaponMatch = false;
        }
    }

}
