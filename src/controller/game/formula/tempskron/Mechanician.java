/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.game.formula.tempskron;

import controller.game.formula.Formulas;
import controller.game.skill.Skill;
import controller.game.skill.SkillMS;

/**
 *
 * @author Luiz
 */
public class Mechanician extends Formulas {
    
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
        return baseVit;
    }

    public Mechanician() {
        
        jobId = 2;
        
        baseStr = 24;
        baseSpi = 8;
        baseTal = 25;
        baseAgi = 18;
        baseVit  = 24;
        
        jobTitle = new String[]{
            "Mechanician",
            "Mechanic Master",
            "Metal Leader",
            "Heavy Metal",
            "Titanium Chief"
        };

        jobName = this.jobTitle[0];
        spec = "MS";
        weaponMatch = null;

        //Base Damage formula

        //base without weapon
        baseWithoutWeaponMin = 1;
        baseWithoutWeaponMax = 2;

        //base with weapon
        baseWithWeaponMin   = 1;
        baseWithWeaponMax   = 3;

        //ranged = agi modifier, melee = str modifier, magic = spi modifier
        rangedWeapon        = 190;
        meleeWeapon         = 150;
        magicWeapon         = 0;

        //Not wearing weapon modifier
        bareHandedFlat      = 1;
        bareHandedStr       = 200;

        bareHandedTalAgiMin = 50;

        bareHandedTalAgiMax = 45;

        //Wearing Melee Weapon
        meleeTalAgi         = 45;

        //Wearing Ranged Weapon
        rangedStrTal        = 50;

        //Wearing Magic Weapon
        magicTal            = 0;

        //Additional Damage
        additionalMin       = 1;
        additionalMax       = 1;



        //critical damage
        baseCriticalDamage  = 70f;

        //abs
        absDef          = 1;
        absLvl          = 0f;
        absStr          = 1f;
        absSpi          = 1f;
        absTal          = 1f;
        absAgi          = 0f;
        absVit          = 1f;
        absPointExtra   = 1f;

        //atr
        atrLvl          = 1.9f;
        atrStr          = 0f;
        atrSpi          = 0f;
        atrTal          = 1.5f;
        atrAgi          = 3.1f;
        atrVit          = 0f;

        //def
        defLvl          = 1.4f;
        defStr          = 0f;
        defSpi          = 0f;
        defTal          = 0.25f;
        defAgi          = 1f;
        defVit          = 0f;

        //hp
        hpLvl           = 2.1f;
        hpStr           = 0.8f;
        hpSpi           = 0f;
        hpTal           = 0f;
        hpAgi           = 0f;
        hpVit           = 2.4f;
        hpFlat          = 0f;

        //mp
        mpLvl           = 0.9f;
        mpStr           = 0f;
        mpSpi           = 2.7f;
        mpTal           = 0f;
        mpAgi           = 0f;
        mpVit           = 0f;
        mpFlat          = 0f;

        //sp
        spLvl           = 2.3f;
        spStr           = 0.5f;
        spSpi           = 1.0f;
        spTal           = 0.5f;
        spAgi           = 0f;
        spVit           = 1.4f;
        spFlat          = 80f;

        //max weight
        weightLvl       = 3f;
        weightStr       = 2f;
        weightSpi       = 1f;
        weightTal       = 0f;
        weightAgi       = 1f;
        weightVit       = 1.5f;
        weightFlat      = 60f;

        //running speed/walk speed
        runBase         = 1.4f;
        runLvl          = 150f;
        runStr          = 0f;
        runSpi          = 0f;
        runTal          = 150f;
        runAgi          = 0f;
        runVit          = 150f;
        runFlat         = 60f;
        
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
        
        for (int tier = 0; tier <= 4; tier++) {
            for (int skill = 0; skill <= 3; skill++) {
                Skill skillChar = new SkillMS(this, tier, skill);
                super.setSkill(skillChar, tier, skill);
            }
        }
    }
    
    private void setBaseStats(){
        super.setBaseStr(baseStr);
        super.setBaseSpi(baseSpi);
        super.setBaseTal(baseTal);
        super.setBaseAgi(baseAgi);
        super.setBaseVit(baseVit);
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
