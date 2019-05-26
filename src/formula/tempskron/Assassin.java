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
public class Assassin extends Formulas {
    private final int baseStr = 25;
    private final int baseSpi = 10;
    private final int baseTal = 22;
    private final int baseAgi = 20;
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

    public Assassin(String classe, int level, int strenght, int spirit, int talent, 
            int agility, int health, String weaponType, int weaponMinAtk, 
            int weaponMaxAtk, int weaponSpecDamage, int weaponSpecAttackRating, 
            int skillPassiveMultiplier, String forceOrb, String siegeWarCrown, 
            int gauntletSpecDamage, int sheltomMinAtk, int sheltomMaxAtk) {
        super(classe, level, strenght, spirit, talent, agility, health, weaponType, 
                weaponMinAtk, weaponMaxAtk, weaponSpecDamage, weaponSpecAttackRating, 
            skillPassiveMultiplier, forceOrb, siegeWarCrown, gauntletSpecDamage, 
            sheltomMinAtk, sheltomMaxAtk);
        
        super.classe = "Assassin";
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

        if (weaponType.equals("Dagger")) {
            super.classWeaponMatch = true;
        }
        
        setBaseStats();
    }
    
    public Assassin() {
        setBaseStats();        
    }
    
    private void setBaseStats(){
        setStrenght(baseStr);
        setSpirit(baseSpi);
        setTalent(baseTal);
        setAgility(baseAgi);
        setHealth(baseHp);
    }

}
