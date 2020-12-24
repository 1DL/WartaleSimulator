/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.game.formula;

import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Formulas extends CharacterStats {
    
    

    public int getBaseWithoutWeaponMin() {
        return baseWithoutWeaponMin;
    }

    public int getBaseWithoutWeaponMax() {
        return baseWithoutWeaponMax;
    }

    public int getBaseWithWeaponMin() {
        return baseWithWeaponMin;
    }

    public int getBaseWithWeaponMax() {
        return baseWithWeaponMax;
    }

    public int getRangedWeapon() {
        return rangedWeapon;
    }

    public int getMeleeWeapon() {
        return meleeWeapon;
    }

    public int getMagicWeapon() {
        return magicWeapon;
    }

    public int getBareHandedFlat() {
        return bareHandedFlat;
    }

    public int getBareHandedStr() {
        return bareHandedStr;
    }

    public int getBareHandedTalAgiMin() {
        return bareHandedTalAgiMin;
    }

    public int getBareHandedTalAgiMax() {
        return bareHandedTalAgiMax;
    }

    public int getMeleeTalAgi() {
        return meleeTalAgi;
    }

    public int getRangedStrTal() {
        return rangedStrTal;
    }

    public int getMagicTal() {
        return magicTal;
    }

    public int getAdditionalMin() {
        return additionalMin;
    }

    public int getAdditionalMax() {
        return additionalMax;
    }

    public float getBaseCriticalDamage() {
        return baseCriticalDamage;
    }

    public float getAbsDef() {
        return absDef;
    }

    public float getAbsLvl() {
        return absLvl;
    }

    public float getAbsStr() {
        return absStr;
    }

    public float getAbsSpi() {
        return absSpi;
    }

    public float getAbsTal() {
        return absTal;
    }

    public float getAbsAgi() {
        return absAgi;
    }

    public float getAbsVit() {
        return absVit;
    }

    public float getAbsPointExtra() {
        return absPointExtra;
    }

    public float getAtrLvl() {
        return atrLvl;
    }

    public float getAtrStr() {
        return atrStr;
    }

    public float getAtrSpi() {
        return atrSpi;
    }

    public float getAtrTal() {
        return atrTal;
    }

    public float getAtrAgi() {
        return atrAgi;
    }

    public float getAtrVit() {
        return atrVit;
    }

    public float getDefLvl() {
        return defLvl;
    }

    public float getDefStr() {
        return defStr;
    }

    public float getDefSpi() {
        return defSpi;
    }

    public float getDefTal() {
        return defTal;
    }

    public float getDefAgi() {
        return defAgi;
    }

    public float getDefVit() {
        return defVit;
    }

    public float getHpLvl() {
        return hpLvl;
    }

    public float getHpStr() {
        return hpStr;
    }

    public float getHpSpi() {
        return hpSpi;
    }

    public float getHpTal() {
        return hpTal;
    }

    public float getHpAgi() {
        return hpAgi;
    }

    public float getHpVit() {
        return hpVit;
    }

    public float getHpFlat() {
        return hpFlat;
    }

    public float getMpLvl() {
        return mpLvl;
    }

    public float getMpStr() {
        return mpStr;
    }

    public float getMpSpi() {
        return mpSpi;
    }

    public float getMpTal() {
        return mpTal;
    }

    public float getMpAgi() {
        return mpAgi;
    }

    public float getMpVit() {
        return mpVit;
    }

    public float getMpFlat() {
        return mpFlat;
    }

    public float getSpLvl() {
        return spLvl;
    }

    public float getSpStr() {
        return spStr;
    }

    public float getSpSpi() {
        return spSpi;
    }

    public float getSpTal() {
        return spTal;
    }

    public float getSpAgi() {
        return spAgi;
    }

    public float getSpVit() {
        return spVit;
    }

    public float getSpFlat() {
        return spFlat;
    }

    public float getWeightLvl() {
        return weightLvl;
    }

    public float getWeightStr() {
        return weightStr;
    }

    public float getWeightSpi() {
        return weightSpi;
    }

    public float getWeightTal() {
        return weightTal;
    }

    public float getWeightAgi() {
        return weightAgi;
    }

    public float getWeightVit() {
        return weightVit;
    }

    public float getWeightFlat() {
        return weightFlat;
    }

    public float getRunBase() {
        return runBase;
    }

    public float getRunLvl() {
        return runLvl;
    }

    public float getRunStr() {
        return runStr;
    }

    public float getRunSpi() {
        return runSpi;
    }

    public float getRunTal() {
        return runTal;
    }

    public float getRunAgi() {
        return runAgi;
    }

    public float getRunVit() {
        return runVit;
    }

    public float getRunFlat() {
        return runFlat;
    }

    public int getBaseDmgNoWeaponMin() {
        return baseDmgNoWeaponMin;
    }

    public int getBaseDmgNoWeaponMax() {
        return baseDmgNoWeaponMax;
    }

    public int getBaseDmgWithWeaponMin() {
        return baseDmgWithWeaponMin;
    }

    public int getBaseDmgWithWeaponMax() {
        return baseDmgWithWeaponMax;
    }

    public int getBaseDmgMin() {
        return baseDmgMin;
    }

    public int getBaseDmgMax() {
        return baseDmgMax;
    }

    public int getMeleeWepModifier() {
        return meleeWepModifier;
    }

    public int getRangedWepModifier() {
        return rangedWepModifier;
    }

    public int getMagicWepModifier() {
        return magicWepModifier;
    }

    public int getMainStatDmgMin() {
        return mainStatDmgMin;
    }

    public int getMainStatDmgMax() {
        return mainStatDmgMax;
    }

    public int getNoWeaponExtraDmgMin() {
        return noWeaponExtraDmgMin;
    }

    public int getNoWeaponExtraDmgMax() {
        return noWeaponExtraDmgMax;
    }

    public int getNoWeaponStrModifier() {
        return noWeaponStrModifier;
    }

    public int getNoWeaponAgiTalModifierMin() {
        return noWeaponAgiTalModifierMin;
    }

    public int getNoWeaponAgiTalModifierMax() {
        return noWeaponAgiTalModifierMax;
    }

    public int getSecondStatDmgMin() {
        return secondStatDmgMin;
    }

    public int getSecondStatDmgMax() {
        return secondStatDmgMax;
    }

    public int getMeleeWeaponTalAgiModifier() {
        return meleeWeaponTalAgiModifier;
    }

    public int getRangedWeaponTalStrModifier() {
        return rangedWeaponTalStrModifier;
    }

    public int getMagicWeaponTalModifier() {
        return magicWeaponTalModifier;
    }

    public boolean isClassWeaponMatch() {
        return classWeaponMatch;
    }

    public int getClassWeaponDmgMin() {
        return classWeaponDmgMin;
    }

    public int getClassWeaponDmgMax() {
        return classWeaponDmgMax;
    }

    public int getWeaponSpecDmgMin() {
        return weaponSpecDmgMin;
    }

    public int getWeaponSpecDmgMax() {
        return weaponSpecDmgMax;
    }

    public int getExtraDmgMin() {
        return extraDmgMin;
    }

    public int getExtraDmgMax() {
        return extraDmgMax;
    }

    public int getAdditionalDmgMin() {
        return additionalDmgMin;
    }

    public int getAdditionalDmgMax() {
        return additionalDmgMax;
    }

    public float getSkillPassiveMultiplier() {
        return skillPassiveMultiplier;
    }

    public int getSkillPassiveDmgMin() {
        return skillPassiveDmgMin;
    }

    public int getSkillPassiveDmgMax() {
        return skillPassiveDmgMax;
    }

    public int getForceFlatDamageBoost() {
        return forceFlatDamageBoost;
    }

    public float getForcePercentDamageBoost() {
        return forcePercentDamageBoost;
    }

    public int getForceOrbDmgMin() {
        return forceOrbDmgMin;
    }

    public int getForceOrbDmgMax() {
        return forceOrbDmgMax;
    }

    public float getSiegeCrownModifier() {
        return siegeCrownModifier;
    }

    public int getSiegeWarCrownDmgMin() {
        return siegeWarCrownDmgMin;
    }

    public int getSiegeWarCrownDmgMax() {
        return siegeWarCrownDmgMax;
    }

    public int getGauntSpecDmgMin() {
        return gauntSpecDmgMin;
    }

    public int getGauntSpecDmgMax() {
        return gauntSpecDmgMax;
    }
    protected float runSpi;
    protected float runTal;
    protected float runAgi;
    protected float runVit;
    protected float runFlat;

    public Formulas(String classe, int level, int strenght, int spirit, int talent,
            int agility, int health, String weaponType, int weaponMinAtk,
            int weaponMaxAtk, int weaponSpecDamage, int weaponSpecAttackRating,
            int skillPassiveMultiplier, String forceOrb, String siegeWarCrown,
            int gauntletSpecDamage, int sheltomMinAtk, int sheltomMaxAtk) {
        super(classe, level, strenght, spirit, talent, agility, health, weaponType,
                weaponMinAtk, weaponMaxAtk, weaponSpecDamage, weaponSpecAttackRating,
                forceOrb, siegeWarCrown, gauntletSpecDamage, sheltomMinAtk, sheltomMaxAtk);
        this.skillPassiveMultiplier = skillPassiveMultiplier;
    }
    
    public Formulas(){
        
    }
    //*****Base Damage***********//
    /*
    Base Damage without weapon = 1-2
    Base Damage with weapon = 1-3
     */
    protected int baseDmgNoWeaponMin = 1;
    protected int baseDmgNoWeaponMax = 2;
    protected int baseDmgWithWeaponMin = 1;
    protected int baseDmgWithWeaponMax = 3;
    protected int baseDmgMin;
    protected int baseDmgMax;

    /*
    Every 130 agility (add 130 extra agility) = 100% weapon damage boost (Archer/Atalanta wearing Bow/Javelin)
    Every 190 agility (add 190 extra agility) = 100% weapons damage boost (other classes wearing range weapons)
    Every 130 strength (add 130 extra strength) = 100% weapon damage boost (Fighter/Pikeman/Assassin/Knight wearing melee weapons )
    Every 150 strength (add 150 extra strength) = 100% weapon damage boost (Mechanician/Atalanta wearing melee weapons)
    Every 190 strength (add 190 extra strength) = 100% weapon damage boost (Archer/Priestess/Magician/Shaman wearing melee weapons)
    Every 150 spirit (add 150 extra spirit) = 100% weapon damage boost (Magician/Shaman wearing Staff/Wand)
    Every 170 spirit (add 170 extra spirit) = 100% weapon damage boost (Priestess wearing Staff/Wand)
     */
    protected int meleeWepModifier;
    protected int rangedWepModifier;
    protected int magicWepModifier;
    protected int mainStatDmgMin;
    protected int mainStatDmgMax;

    /*
    If Fighter/Pikeman/Assassin/Knight and not wearing a weapon:
        +1 damage
        every 130 str = +1 damage
        every 40 of (talent+agility) = +1 min damage
        every 35 of (talent+agility) = +1 max damage
    If other class and not wearing a weapon:
        +1 damage
        every 200 str = +1 damage
        every 50 of (talent+agility) = +1 min damage
        every 45 of (talent+agility) = +1 max damage
     */
    protected int noWeaponExtraDmgMin = 1;
    protected int noWeaponExtraDmgMax = 1;
    protected int noWeaponStrModifier;
    protected int noWeaponAgiTalModifierMin;
    protected int noWeaponAgiTalModifierMax;

    /*
    If Fighter/Pikeman/Assassin/Knight and wearing melee weapon:
        every 40 (talent+agility) = +1 damage
    If Mechanician/Atalanta and wearing melee weapon:
        every 45 (talent+agility) = +1 damage
    If Archer/Priestess/Magician/Shaman and wearing melee weapon:
        every 50 (talent+agility) = +1 damage
    If Archer/Atalanta and wearing range weapon (Bow/Javalin):
        every 40 (talent+strength) = +1 damage
    If other class and wearing range weapon (Bow/Javelin):
        every 50 (talent+strength) = +1 damage
    If Magician/Shaman/Priestess and wearing Staff/Wand:
        every 30 talent = +1 damage
     */
    protected int secondStatDmgMin;
    protected int secondStatDmgMax;
    protected int meleeWeaponTalAgiModifier;
    protected int rangedWeaponTalStrModifier;
    protected int magicWeaponTalModifier;

    /*
    WEAPON = 100% of damage of weapon

    Bonus. (attack power displayed in yellow) = 
        (if : Mechanician uses a Mechanicion-specced Weapon - Atalanta uses a Javelin - 
        Knight use a Sword - Pikeman use a Scythe - Fighter uses an Axe - 
        Priestess or Magician uses a Wand/Staff - Archer uses a Bow - 
        Assassin uses two Daggers - Shaman uses a Phantom) => (then : add lvl/6 damage to min&max)
     */
    protected boolean classWeaponMatch;
    protected int classWeaponDmgMin = 0;
    protected int classWeaponDmgMax = 0;

    /*
    Spec. weapon lvl/x => +0min +(lvl/x) max
     */
    protected int weaponSpecDmgMin = 0;
    protected int weaponSpecDmgMax = 0;

    /*
    (min weapon + max weapon)/16 => add to your min damage
     */
    protected int extraDmgMin = 0;
    protected int extraDmgMax = 0;

    /*
    Additional Damage = 1-1
     */
    protected int additionalDmgMin = 1;
    protected int additionalDmgMax = 1;

    //*****Skill Passive, Force Orb, Siege War Crown , Gaunt and Sheltom******//
    /*
    Skill Passive
     */
    protected float skillPassiveMultiplier = 0.0f;
    protected int skillPassiveDmgMin = 0;
    protected int skillPassiveDmgMax = 0;

    /*
    Force Orb
     */
    protected int forceFlatDamageBoost = 0;
    protected float forcePercentDamageBoost = 0.0f;
    protected int forceOrbDmgMin = 0;
    protected int forceOrbDmgMax = 0;

    /*
    Siege War Crown
     */
    protected float siegeCrownModifier = 0.0f;
    protected int siegeWarCrownDmgMin = 0;
    protected int siegeWarCrownDmgMax = 0;

    /*
    Gaunt spec dmg
     */
    protected int gauntSpecDmgMin = 0;
    protected int gauntSpecDmgMax = 0;

    public void calcularDanoBase() {

        /*
        Base Damage without weapon = 1-2
        Base Damage with weapon = 1-3
         */
        //Definindo dano base, se tem ou não arma equipada
        if (weaponClass.equals("No Weapon")) {
            baseDmgMin = baseDmgNoWeaponMin;
            baseDmgMax = baseDmgNoWeaponMax;
        } else {
            baseDmgMin = baseDmgWithWeaponMin;
            baseDmgMax = baseDmgWithWeaponMax;
        }

        /*
        Every 130 agility (add 130 extra agility) = 100% weapon damage boost (Archer/Atalanta wearing Bow/Javelin)
        Every 190 agility (add 190 extra agility) = 100% weapons damage boost (other classes wearing range weapons)
        Every 130 strength (add 130 extra strength) = 100% weapon damage boost (Fighter/Pikeman/Assassin/Knight wearing melee weapons )
        Every 150 strength (add 150 extra strength) = 100% weapon damage boost (Mechanician/Atalanta wearing melee weapons)
        Every 190 strength (add 190 extra strength) = 100% weapon damage boost (Archer/Priestess/Magician/Shaman wearing melee weapons)
        Every 150 spirit (add 150 extra spirit) = 100% weapon damage boost (Magician/Shaman wearing Staff/Wand)
        Every 170 spirit (add 170 extra spirit) = 100% weapon damage boost (Priestess wearing Staff/Wand)
         */
        //Definindo dano de acordo com o status principal investido
        switch (weaponClass) {
            case "Melee":
                // (sCharacterStats.sDamage.iMin * (m->iStrength + 130) / 130)
                mainStatDmgMin = (super.weaponMinAtk + super.sheltomMinAtk) * (super.getStrenght() + meleeWepModifier) / meleeWepModifier;
                mainStatDmgMax = (super.weaponMaxAtk + super.sheltomMaxAtk) * (super.getStrenght() + meleeWepModifier) / meleeWepModifier;
                break;
            case "Ranged":
                mainStatDmgMin = (super.weaponMinAtk + super.sheltomMinAtk) * (super.getAgility() + rangedWepModifier) / rangedWepModifier;
                mainStatDmgMax = (super.weaponMaxAtk + super.sheltomMaxAtk) * (super.getAgility() + rangedWepModifier) / rangedWepModifier;
                break;
            case "Magic":
                mainStatDmgMin = (super.weaponMinAtk + super.sheltomMinAtk) * (super.getSpirit() + magicWepModifier) / magicWepModifier;
                mainStatDmgMax = (super.weaponMaxAtk + super.sheltomMaxAtk) * (super.getSpirit() + magicWepModifier) / magicWepModifier;
                break;

            /*
            If Fighter/Pikeman/Assassin/Knight and not wearing a weapon:
                +1 damage
                every 130 str = +1 damage
                every 40 of (talent+agility) = +1 min damage
                every 35 of (talent+agility) = +1 max damage
            If other class and not wearing a weapon:
                +1 damage
                every 200 str = +1 damage
                every 50 of (talent+agility) = +1 min damage
                every 45 of (talent+agility) = +1 max damage
             */
            //Definindo status principal e secundário sem arma
            case "No Weapon":
                mainStatDmgMin = (super.getStrenght() + noWeaponStrModifier) / noWeaponStrModifier;
                //mainStatDmgMin += noWeaponExtraDmgMin;
                mainStatDmgMax = (super.getStrenght() + noWeaponStrModifier) / noWeaponStrModifier;
                mainStatDmgMax += noWeaponExtraDmgMax;

                secondStatDmgMin = (super.getTalent() + super.getAgility()) / noWeaponAgiTalModifierMin;
                secondStatDmgMax = (super.getTalent() + super.getAgility()) / noWeaponAgiTalModifierMax;
                break;
            default:
                JOptionPane.showConfirmDialog(null, "Tipo de arma não cadastrado no sistema",
                        "Erro - Tipo de arma inválido", 0);
                break;
        }

        /*
        If Fighter/Pikeman/Assassin/Knight and wearing melee weapon:
            every 40 (talent+agility) = +1 damage
        If Mechanician/Atalanta and wearing melee weapon:
            every 45 (talent+agility) = +1 damage
        If Archer/Priestess/Magician/Shaman and wearing melee weapon:
            every 50 (talent+agility) = +1 damage
        If Archer/Atalanta and wearing range weapon (Bow/Javalin):
            every 40 (talent+strength) = +1 damage
        If other class and wearing range weapon (Bow/Javelin):
            every 50 (talent+strength) = +1 damage
        If Magician/Shaman/Priestess and wearing Staff/Wand:
            every 30 talent = +1 damage
         */
        //Definindo status secundário usando arma
        
        switch (weaponClass) {
            case "Magic":
                secondStatDmgMin = super.getTalent() / magicWeaponTalModifier;
                secondStatDmgMax = super.getTalent() / magicWeaponTalModifier;
                break;
            case "Ranged":
                secondStatDmgMin = super.getTalent() + super.getStrenght() / rangedWeaponTalStrModifier;
                secondStatDmgMax = super.getTalent() + super.getStrenght() / rangedWeaponTalStrModifier;
                break;
            case "Melee":
                secondStatDmgMin = super.getTalent() + super.getAgility() / meleeWeaponTalAgiModifier;
                secondStatDmgMax = super.getTalent() + super.getAgility() / meleeWeaponTalAgiModifier;
                break;                
        }
        
        //********external items calculations********//
        /*
        Gaunt spec damage
         */
        //Definindo dano adicional do spec da luva
        gauntSpecDmgMin = 0;
        if (super.gauntletSpecDamage == 0) {
            gauntSpecDmgMax = 0;
        } else {
            gauntSpecDmgMax = super.level / super.gauntletSpecDamage;
        }
        

        //************Weapon based calculations***********
        
        
        if (!weaponClass.equals("No Weapon")){
            
            /*
            Bonus. (attack power displayed in yellow) = 
            (if : Mechanician uses a Mechanicion-specced Weapon - Atalanta uses a Javelin - 
            Knight use a Sword - Pikeman use a Scythe - Fighter uses an Axe - 
            Priestess or Magician uses a Wand/Staff - Archer uses a Bow - 
            Assassin uses two Daggers - Shaman uses a Phantom) => (then : add lvl/6 damage to min&max)
            */
            //Definindo dano se a classe usa o tipo certo de arma
            if (classWeaponMatch) {
                classWeaponDmgMin = super.level / 6;
                classWeaponDmgMax = super.level / 6;
            }
            
            /*
            Spec. weapon lvl/x => +0min +(lvl/x) max
            */
            //Definindo dano de acordo com spec da arma
            if (!weaponClass.equals("No Weapon")) {
                weaponSpecDmgMin = 0;
                if (super.weaponSpecDamage == 0) {
                    weaponSpecDmgMax = 0;
                } else {
                    weaponSpecDmgMax = super.level / super.weaponSpecDamage;
                }
            }
            
            /*
            (min weapon + max weapon)/16 => add to your min damage
             */
            //Definindo dano extra minimo
            extraDmgMax = 0;
            extraDmgMin = ((super.weaponMinAtk + super.sheltomMinAtk) + (super.weaponMaxAtk + super.sheltomMaxAtk)) / 16;
            
            /*
            Skill passive
             */
            //Definindo dano adicional das passivas de arma
            skillPassiveMultiplier = skillPassiveMultiplier / 100f;
            skillPassiveDmgMin = (int) (super.weaponMinAtk * skillPassiveMultiplier);
            skillPassiveDmgMax = (int) (super.weaponMaxAtk * skillPassiveMultiplier);
        }
        
        //****Final base damage calculation******//

        /*
        Additional Damage = 1-1
         */
        //Definindo dano base minimo e máximo final
        super.attackDamageMin = (baseDmgMin + mainStatDmgMin + secondStatDmgMin
                + classWeaponDmgMin + weaponSpecDmgMin + extraDmgMin + additionalDmgMin + skillPassiveDmgMin + gauntSpecDmgMin);

        super.attackDamageMax = (baseDmgMax + mainStatDmgMax + secondStatDmgMax
                + classWeaponDmgMax + weaponSpecDmgMax + extraDmgMax + additionalDmgMax + skillPassiveDmgMax + gauntSpecDmgMax);

        //******Calcular forceOrb e coroa sw********//
        /*
        Force Orb
         */
        switch (super.forceOrb) {
            case "Sol":
                forceFlatDamageBoost = 220;
                forcePercentDamageBoost = 0.10f;
                forceOrbDmgMin = ((int) (super.attackDamageMin * forcePercentDamageBoost) + forceFlatDamageBoost);
                forceOrbDmgMax = ((int) (super.attackDamageMax * forcePercentDamageBoost) + forceFlatDamageBoost);
                break;
            case "Sapphire":
                break;

            case "None":
                forceFlatDamageBoost = 0;
                forcePercentDamageBoost = 0;
                forceOrbDmgMin = 0;
                forceOrbDmgMax = 0;
                break;
        }

        /*
        Siege War Crown
         */
        switch (super.siegeWarCrown) {
            case "Gold":
                siegeCrownModifier = 0.10f;
                siegeWarCrownDmgMin = (int) (super.attackDamageMin * siegeCrownModifier);
                siegeWarCrownDmgMax = (int) (super.attackDamageMax * siegeCrownModifier);
                break;
            case "None":
                siegeCrownModifier = 0;
                siegeWarCrownDmgMin = (int) (super.attackDamageMin * siegeCrownModifier);
                siegeWarCrownDmgMax = (int) (super.attackDamageMax * siegeCrownModifier);
                break;
                
        }
        //****Final base damage after Force Orb and Siege Crown****///
        //Calculando dano base 
        super.attackDamageMin += (forceOrbDmgMin + siegeWarCrownDmgMin);

        super.attackDamageMax += (forceOrbDmgMax + siegeWarCrownDmgMax);

    }

    public boolean getArmaClasse() {
        return classWeaponMatch;
    }
}
