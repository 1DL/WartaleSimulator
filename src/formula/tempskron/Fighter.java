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
public class Fighter extends Formulas {
    private final int baseStr = 28;
    private final int baseSpi = 6;
    private final int baseTal = 21;
    private final int baseAgi = 17;
    private final int baseHp = 27;

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

    public Fighter() {
        
        super.setClasse("Fighter");
        //Every 130 strength (add 130 extra strength) = 100% weapon damage boost (Fighter/Pikeman/Assassin/Knight wearing melee weapons )
        super.meleeWepModifier = 130;
        //Every 190 agility (add 190 extra agility) = 100% weapons damage boost (other classes wearing range weapons)
        super.rangedWepModifier = 190;
        
        /*
        If Fighter/Pikeman/Assassin/Knight and not wearing a weapon:
            +1 damage
            every 130 str = +1 damage
            every 40 of (talent+agility) = +1 min damage
            every 35 of (talent+agility) = +1 max damage
         */
        super.noWeaponStrModifier = 130;
        super.noWeaponAgiTalModifierMin = 40;
        super.noWeaponAgiTalModifierMax = 35;
        
        /*
        If Fighter/Pikeman/Assassin/Knight and wearing melee weapon:
            every 40 (talent+agility) = +1 damage
         */
        super.meleeWeaponTalAgiModifier = 40;
        
        /*
        If other class and wearing range weapon (Bow/Javelin):
            every 50 (talent+strength) = +1 damage    
        */
        super.rangedWeaponTalStrModifier = 50;

        
        
        setBaseStats();
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
            if (weaponType.equals("Axe")) {
            super.classWeaponMatch = true;
        }
        } catch (NullPointerException npe) {
            super.classWeaponMatch = false;
        }
    }

}
