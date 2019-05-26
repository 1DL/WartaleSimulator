/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula.morion;

import formula.Formulas;

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

    public Shaman(String classe, int level, int strenght, int spirit, int talent, 
            int agility, int health, String weaponType, int weaponMinAtk, 
            int weaponMaxAtk, int weaponSpecDamage, int weaponSpecAttackRating, 
            int skillPassiveMultiplier, String forceOrb, String siegeWarCrown, 
            int gauntletSpecDamage, int sheltomMinAtk, int sheltomMaxAtk) {
        super(classe, level, strenght, spirit, talent, agility, health, weaponType, 
                weaponMinAtk, weaponMaxAtk, weaponSpecDamage, weaponSpecAttackRating, 
            skillPassiveMultiplier, forceOrb, siegeWarCrown, gauntletSpecDamage, 
            sheltomMinAtk, sheltomMaxAtk);
        
        super.classe = "Shaman";
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

        if (weaponType.equals("Phantom")) {
            super.classWeaponMatch = true;
        }
        
        setBaseStats();
    }
    
    public Shaman() {
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
