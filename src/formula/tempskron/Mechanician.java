/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula.tempskron;

import formula.morion.*;
import formula.Formulas;

/**
 *
 * @author Luiz
 */
public class Mechanician extends Formulas {
    private final int baseStr = 24;
    private final int baseSpi = 8;
    private final int baseTal = 25;
    private final int baseAgi = 18;
    private final int baseHp = 24;
    
    private String weaponSpec = "No Spec";

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

    public Mechanician() {
        
        this.weaponSpec = weaponSpec;
        
        super.setClasse("Mechanician");
        //Every 150 strength (add 150 extra strength) = 100% weapon damage boost (Mechanician/Atalanta wearing melee weapons)
        super.meleeWepModifier = 150;
        //Every 190 agility (add 190 extra agility) = 100% weapons damage boost (other classes wearing range weapons)
        super.rangedWepModifier = 190;
        
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
        If other class and wearing range weapon (Bow/Javelin):
            every 50 (talent+strength) = +1 damage
        */
        super.rangedWeaponTalStrModifier = 50;

        
        
        setBaseStats();
    }
    
    private void setBaseStats(){
        setStrenght(baseStr);
        setSpirit(baseSpi);
        setTalent(baseTal);
        setAgility(baseAgi);
        setHealth(baseHp);
        classWeaponMatch();
    }
    
    private void classWeaponMatch(){
        try {
            if (weaponSpec.equals("Mechanician")) {
            super.classWeaponMatch = true;
        }
        } catch (NullPointerException npe) {
            super.classWeaponMatch = false;
        }
    }
}
