/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.skillHelper;

import skill.Skill;

/**
 *
 * @author Luiz
 */
public class SkillList {

    Skill s;
    /*
    array indexes:
    [class][tier][skill][skill data]
     */
    public final String[][][][] SKILL_STR;
    public SkillList() {
        this.SKILL_STR = new String[][][][] {
        {//Mechanician
            {//Tier 1
                {
                    "Extreme Shield",
                    "Temporarily increases block rating of your shield.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    ""
                },
                {
                    "Mechanic Bomb",
                    "Throws a bomb that causes an explosion damaging enemies in that area.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_BOTH, 
                    "Mechanic Bomb does an additional +500%damage against mutant monsters and mechanic monsterSkill."
                },
                {
                    "Poison Attribute",
                    "Permanently increases resistance to all poison property attackSkill.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE, 
                    "Poison Resistance also lowers the poisoned duration of enemies' poison attackSkill."
                },
                {
                    "Physical Absorption",
                    "Increases Absorb Rating.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT, 
                    "Cannot be used simultaneosly with Maximize, Metal Armor or Automation."
                }
            },
            {//Tier 2
                {
                    "Great Smash",
                    "Delivers a powerful blow to the targeted enemy.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1_AND_AOE,
                    Skill.CS_BOTH,
                    "Area damage is 50% of the skill damage."
                },
                {
                    "Maximize",
                    "Optimizes weapon for increased max attack power.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT, 
                    "Cannot be used simultaneously with Physical Absorbtion, or Automation."
                },
                {
                    "Automation",
                    "Automates projectile weapons to raise attack power and attack speed.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT, 
                    "Cannot be used simultaneously with Physical Absorbtion, Metal Armor, or Maximize."
                },
                {
                    "Spark",
                    "Delivers a powerful lightning bolt towards the targeted enemy.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_BOTH, 
                    "Spark does an additional +50% damage against mechanic monsters."
                }
            },
            {//Tier 3
                {
                    "Metal Armor",
                    "Temporarily increases defense rating of your armor if it's mechanician spec.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT, 
                    "Metal Armor gains 200% of Physical Absorption's current Absorption, "
                    +"so you can raise Physical Absorbtion, but you don't need to use it. " 
                    +"Cannot be used simultaneously with Maximize or Automation."
                },
                {
                    "Grand Smash",
                    "Unleashes two devastating blows to a single target with increased attack power and attack rating.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH, 
                    ""
                },
                {
                    "Mechanic Weapon Mastery",
                    "Optimizes weapons with mechanic spec.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE, 
                    ""
                },
                {
                    "Spark Shield",
                    "Optimizes your shield with increased defense rating and reflection damage with double damage against mechanic enemies.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    "It has a +50% damage bonus on mechanic monsters. "
                    +"Spark Shield also increases the defense rating of your shield. "
                    +"Can't be used simultaneously with Extreme Shield (tier 1)."
                }
            },
            {//Tier 4
                {
                    "Impulsion",
                    "Delivers several powerfull electric blows towards the targeted enemy.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_BOTH,
                    "Impulsion does an additional +50% damage against mechanic monsters."
                },
                {
                    "Compulsion",
                    "Creates a magnetic field that pulls enemies towards you and increases absorb rating.",
                    Skill.TS_BUFF,
                    Skill.ES_ALLY_AREA_BUFF,
                    Skill.CS_RIGHT, 
                    ""
                },
                {
                    "Magnetic Sphere",
                    "Generates three magnetic spheres that attack nearby enemies.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT, 
                    "Magnetic Sphere does +50% damage bonus against Mechanic Monsters."
                },
                {
                    "Metal Golem",
                    "Summons a huge metallic golem to aid you in battle attacking nearby enemies.",
                    Skill.TS_BUFF,
                    Skill.ES_SUMMON,
                    Skill.CS_RIGHT, 
                    ""
                }
            },
            {//Tier 5
                {
                    "Precision",
                    "Increases the ability to use Bows and Javelins with a specialty against Mechanic typed monsters.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    "100% chain with Automation." +
                    "Projectile Speed means the speed of the arrow/javelin." +
                    "Precision has an additional +50% Final Damage Boost on monsters only." +
                    "Precision does not stack with Metal Armor, Physical Absorption and Maximize." +
                    "Precision does +50% damage bonus against Mechanic Monsters."
                },
                {
                    "Trine Shield",
                    "Greatly increases the defensive power of your Shield.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT, 
                    "When activated, will decrease Grand Smash damage by 50%."
                },
                {
                    "Gravitation",
                    "A portion of the damage inflicted on nearby party members is pulled to you.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_AURA,
                    Skill.CS_RIGHT, 
                    ""
                },
                {
                    "Obliterate",
                    "Increases Absorb Rating.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1_AND_AOE,
                    Skill.CS_BOTH, 
                    "This skill has not yet been released."
                }
            },
        }, 
        {//Fighter
            {//Tier 1
                {
                    "Melee Mastery", 
                    "Permanently increases attack power when using melee weapons.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    ""
                },
                {
                    "Fire Attribute", 
                    "Permanently increases resistance to fire property attacks.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    ""
                },
                {
                    "Raving", 
                    "Goes berserk for a short period of time, increases attack power but decreases HP.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    ""
                },
                {
                    "Impact", 
                    "Delivers two powerful swings on a single target.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "Impact either successes or misses both attacks."
                },
            },
            {//Tier 2
                {
                    "Triple Impact", 
                    "Delivers devastating attack combos inflicting huge damage to the target.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "Triple Impact either successes or misses all attacks."
                },
                {
                    "Brutal Swing", 
                    "Unleashes a massive attack inflicting huge damage to the target.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "Adds 50% extra damage VS Demon."
                },
                {
                    "Roar", 
                    "Shouts a deafening roar to momentarily stun enemies.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_RIGHT,
                    "Also works on enemy players in PVP areas."
                },
                {
                    "Rage of Zecram", 
                    "Uses the power of the legendary hero Zecram to unleash a powerful eruption of fire.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1_AND_AOE,
                    Skill.CS_BOTH,
                    ""
                },
            },
            {//Tier 3
                {
                    "Concentration", 
                    "Increases attack rating with intense concentration.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    "Concentration cannot be used simultaneously with Swift Axe."
                },
                {
                    "Avenging Crash", 
                    "Inflicts great damage with the use of two deadly uppercuts.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "Avenging Crash gains 50% of Brutal Swing's current Critical rating. Avenging Crash gains a percentage (%) of your weapon's Attack rating"
                },
                {
                    "Swiftness", 
                    "Increases attack speed.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    "Swiftness cannot be used simultaneously with Concentration."
                },
                {
                    "Bone Crash", 
                    "Jumps into the air and delivers a smashing blow on the target.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    ""
                },
            },
            {//Tier 4
                {
                    "Destroyer", 
                    "Delivers a powerful combo with massive damage and increased critical.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "Destroyer does an additional +50% damage against demon monsters."
                },
                {
                    "Berserker", 
                    "Decreases absorb rating for an increased attack power.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    ""
                },
                {
                    "Cyclone Strike", 
                    "Rotates creating a huge cyclone damaging surrounding targets.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1_AND_AOE,
                    Skill.CS_BOTH,
                    "Cyclone Strike damages the targeted enemy twice. Does not critical on main target. Only deals 50% damage in PvP."
                },
                {
                    "Boost Health", 
                    "Increases HP permanently.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    ""
                },
            },
            {//Tier 5
                {
                    "Charge", 
                    "Charges towards the enemy with increased after damage.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_RIGHT,
                    "This skill has not yet been released."
                },
                {
                    "Inner Soul", 
                    "Adds Attack Rating at the cost of Critical.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    "100% chain Concentration. Swift Axe can be used simultaneously. Inner Soul adds a 60% Attack Rating bonus to Bone Crash."
                },
                {
                    "Hellion", 
                    "Summon mischievous creatures from the underworld to loot gold or fight for you.",
                    Skill.TS_BUFF,
                    Skill.ES_SUMMON,
                    Skill.CS_RIGHT,
                    "Hellion's keep 5% of all gold looted. Hellion's only loot in maps with a maximum level difference of 30 levels & you are actively attack monsters. "
                },
                {
                    "Fire Weapon", 
                    "Temporarily adds Fire element to the weapon for extra damage.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    "This skill has not yet been released."
                },

            }
        },
        {//Pikeman
            {//Tier1
                {
                    "Pike Wind", 
                    "Forms a whirlwind to push back and slightly damage surrounding enemies.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_RIGHT,
                    "Pike Wind will always hit its targets."
                },
                {
                    "Ice Attribute", 
                    "Permanently increase resistance against frost property attacks.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    "Ice Attribute also lowers the freezing duration of enemies' ice attacks."
                },
                {
                    "Critical Hit", 
                    "Aims for the weak point of the targeted enemy to raise the probability of a critical strike.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "Critical Hit has a +2 attack speed bonus."
                },
                {
                    "Jumping Crash", 
                    "Leaps up into the air to strikedown inflicting huge damage.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "Jumping Crash does an additional +100% damage against demon monsters."
                },
            },
            {//Tier 2
                {
                    "Ground Pike", 
                    "Freezes all enemies in range.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_RIGHT,
                    "Reduces enemies' movement and attack speed by -50%. Has a +30% Freeze Duration bonus against undead monsters and demon monsters. Effect can be used simultaneously with Venom Spear."
                },
                {
                    "Tornado", 
                    "Summons a tornado to attack surrounding enemies.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_BOTH,
                    "Tornado will always hit its targets."
                },
                {
                    "Weapon Defense Mastery", 
                    "Passively increases block rating when wearing a weapon without a shield.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    ""
                },
                {
                    "Expansion", 
                    "Unleashes a devastating attack to strike the enemy.",
                    Skill.TS_OFFENSE,
                    Skill.ES_LINEAR,
                    Skill.CS_BOTH,
                    "Expansion will always hit its target. Expansion also does linear area damage. Bonus 50% damage Vs. Mutant Monster",
                },
            },
            {//Tier 3
                {
                    "Venom Spear", 
                    "Poisons surrounding enemies with HP drain attack.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_RIGHT,
                    "Venom Spear will always hit its targets. Venom Spear's effect can be used simultaneously with Ground Pike."
                },
                {
                    "Vanish", 
                    "Vanishes into thin air to reduce the sight range of enemies.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    "Boots the damage of the first hit made with vanish, but hitting something will make the player visible again."
                },
                {
                    "Critical Mastery", 
                    "Permanently increases critical.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    ""
                },
                {
                    "Chain Lance", 
                    "Jumps into the air slashing a single opponent with a fast and devastating combo.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "Vanish's effect will apply on the first hit."
                },
            },
            {//Tier 4
                {
                    "Assassin's Eye", 
                    "Curses the enemy by exposing their weak spot.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "It increases the damage only if a Critical hit is landed on the target. The increased damage boost is based on the original damage. Assassin's Eye can also be cast on other players in PvP. Assassin's Eye also increases the Critical chance against Monsters for anyone attacking the marked Monster."
                },
                {
                    "Charging Strike", 
                    "Charges at an enemy delivering three powerful blows on a single target.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_RIGHT,
                    "Charging Strike must be completely charged in order to acquire the Fully Charged Damage Boost. Vanish's effect will apply on the first hit."
                },
                {
                    "Vague", 
                    "Increases evasion rate when using spears.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    "Vague can be used simultaneously with Vanish."
                },
                {
                    "Shadow Master", 
                    "Strikes a single target with a barrage of five powerful blows.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "Number of hits depends on the level."
                },
            },
            {//Tier 5
                {
                    "Attack Rating Mastery", 
                    "Permanently boosts Attack Rating based on wielded Weapon.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    ""
                },
                {
                    "Lethal Strike", 
                    "Throws a shuriken to a fleeing enemy.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    ""
                },
                {
                    "Dodge", 
                    "Evade enemy damage by predicting the hit.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_ACTIVEKEY,
                    "Full evasion works untill aumont of hits are evaded or duration ends."
                },
                {
                    "Shadow Clone", 
                    "Summons a Shadow Clone.",
                    Skill.TS_BUFF,
                    Skill.ES_SUMMON,
                    Skill.CS_RIGHT,
                    "Skill has yet to be released"
                },
            }
        },
        {//Archer
            {//Tier 1
                {
                    "Scout Hawk", 
                    "Summons a hawk to scout the surrounding area, increases attack rating on all surrounding enemies.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_AURA,
                    Skill.CS_RIGHT,
                    "Attack rating boost applies only to enemies within visible range. (They will glow blue if within range) Scout Hawk adds a percentage (%) of your total Attack rating. Scout Hawk cannot be used simultaneously with Falcon or Golden Falcon"
                },
                {
                    "Shooting Mastery", 
                    "Permanently increases attack power with bows and crossbows.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    ""
                },
                {
                    "Wind Arrow", 
                    "Imbues an arrow with wind properties to increase attack power.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_BOTH,
                    "Wind Arrow will always hit its target. Wind Arrow does an additional +50% damage against normal monsters."
                },
                {
                    "Perfect Aim", 
                    "Creates a well aimed shot with increased attack power and attack rating.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "Perfect Aim adds 100% Vs. Demon"
                },
            },
            {//Tier 2
                {
                    "Dion's Eye", 
                    "Uses the Eye Sight of the Legendary Archer 'Dion' to permanently increase Attack Rating based on your Weapon.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    ""
                },
                {
                    "Falcon", 
                    "Summons a fierce falcon to attack targeted enemies.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_AURA,
                    Skill.CS_RIGHT,
                    "Falcon will always hit its target. Falcon cannot be used simultaneously with Scout Hawk or Golden Falcon"
                },
                {
                    "Arrow of Rage", 
                    "Shoots an arrow over a desired area which explodes in the air and rains a down fire of arrows on targeted enemies.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_BOTH,
                    "Arrow of Rage will always hit its targets."
                },
                {
                    "Avalanche", 
                    "Unleashes a barrage of piercing arrows on a single target.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    ""
                },
            },
            {//Tier 3
                {
                    "Elemental Shot", 
                    "Shoots several elemental attacks on targeted enemy.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1_AND_AOE,
                    Skill.CS_BOTH,
                    "Elemental Shot has a +3 firing speed bonus. Elemental Shot randomly selects the elemental property. Elemental Shot will always hit its target"
                },
                {
                    "Golden Falcon", 
                    "Summons a falcon to attack targeted enemies.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    "Golden Falcon will only attack the currently targeted enemy. Golden Falcon will always hit its target. Golden Falcon cannot be used simultaneously with Scout Hawk or Falcon. Chains 50% to Level 10 Scout Hawk"
                },
                {
                    "Bomb Shot", 
                    "Fires two explosive arrows causing splash damage within the blast radius.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1_AND_AOE,
                    Skill.CS_BOTH,
                    "Bomb Shot will always hit its targets. Bomb Shot's initial Firing speed is 6 regardless of your bow's Firing speed. Bomb Shot does double damage on the main target. Surrounding enemies get half of the Damage Boost, but get additional Splash Damage. Demon Bonus applies to AoE damage only."
                },
                {
                    "Perforation", 
                    "Accurate attack that perforates opponents.",
                    Skill.TS_OFFENSE,
                    Skill.ES_LINEAR,
                    Skill.CS_BOTH,
                    "Perforation will always hit its targets. Phoenix Speed disables the chance of critical hits."
                },
            },
            {//Tier 4
                {
                    "Wolverine", 
                    "Summons Wolverine to support you in battle.",
                    Skill.TS_BUFF,
                    Skill.ES_SUMMON,
                    Skill.CS_RIGHT,
                    ""
                },
                {
                    "Evasion Mastery", 
                    "Avoids attacks effectively.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    ""
                },
                {
                    "Phoenix Shot", 
                    "Increases your attack power using the Power of Phoenix.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1_AND_AOE,
                    Skill.CS_RIGHT,
                    "Phoenix Shot must be fully charged in order to inflict Linear Area damage."
                },
                {
                    "Force of Nature", 
                    "Improves your ability by natural assimilation perfectly.",
                    Skill.TS_BUFF,
                    Skill.ES_ALLY_AREA_BUFF,
                    Skill.CS_RIGHT,
                    "Force of Nature can be cast on other Party members."
                },
            },
            {//Tier 5
                {
                    "Stun Arrow", 
                    "Shoots 1 stun arrow towards the targeted enemy, stunning it for a short moment.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    ""
                },
                {
                    "Increases the Walking Speed and Evasion.",
                    "",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    "Decreases Attack Rating. Doubles stamina skill usage."
                },
                {
                    "Long Shot", 
                    "Shoots a Long Range arrow, with increased attack power, but can only be used with a two handed Bow.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "This skill has not yet been released."
                },
                {
                    "Phoenix Blessing", 
                    "Summons multiple healing Phoenixes.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_AURA,
                    Skill.CS_RIGHT,
                    "Each Blessing Phoenix will heal an ally of the Archer within the Area. A Blessing Phoenix heals only one at a time. This skill has not yet been released."
                },
            },
        },
        {//Assassin
            {//Tier 1
                {
                    "Stinger", 
                    "Runs straight towards the enemy and hits the enemy with two quick attacks.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "Adds 50% damage against Normal and Mutant monsters."
                },
                {
                    "Double Blow", 
                    "Deals continuous damage to the enemy while spinning.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    ""
                },
                {
                    "Dual Wield Mastery", 
                    "Increases your Attack Power permanently when using daggers.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    ""
                },
                {
                    "Wisp", 
                    "Reduces enemies Attack Power for a period of time.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    ""
                },
            },
            {//Tier 2
                {
                    "Venom Thorn", 
                    "Attacks the enemy twice rapidly with poisoned daggers.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    ""
                },
                {
                    "Alas", 
                    "Distributes dexterity of an Assassin and increases Evasion of all party members.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_AURA,
                    Skill.CS_RIGHT,
                    ""
                },
                {
                    "Soul Shock", 
                    "Performs a hard hit to the ground and stun all enemies around.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_BOTH,
                    "Works also on PvP."
                },
                {
                    "Blade Mastery", 
                    "Increases your Attack Power and Evasion permanently when using daggers.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    ""
                },
            },
            {//Tier 3
                {
                    "Finishing Blow", 
                    "Deals repeated damage to the enemy.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    ""
                },
                {
                    "Gust Slash", 
                    "Jumps towards the enemy and attacks repeatedly to deal massive damage to the enemy and anyone nearby.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_BOTH,
                    "50% damage boost Vs. Mechanic Monster"
                },
                {
                    "Inpes", 
                    "Increases your Attack Speed temporarily.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    ""
                },
                {
                    "Deception", 
                    "Hides into your own shadow which turn you invisible to enemies eyes for a short duration until you attack.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    "The bonus damage and attack rating is applied to all hits of the first attack after casting, after which the buff disappears."
                },
            },
            {//Tier 4
                {
                    "Frost Wind", 
                    "Moves quickly to deal repeated fatal damage to the enemy.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    ""
                },
                {
                    "Fatal Mastery", 
                    "Increases your Critical chance when permanently when using daggers.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    ""
                },
                {
                    "Pollute", 
                    "Poisons all nearby enemies and decreases their health for a duration.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_RIGHT,
                    "The Pollute effect can be used simultaneously with the ice and burn effect."
                },
                {
                    "Ninja Shadow", 
                    "Moves fast to deal continuous damage to the enemy with shadows.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    ""
                },
            },
            {//Tier 5
                {
                    "Shadow Bomb", 
                    "Hides in the shadow and deals damage in an area by throwing a fire bomb on the ground.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_BOTH,
                    "Shadow Bomb does 50% extra damage against Normal monsters. Burn effect stacks with poison and ice."
                },
                {
                    "Rising Slash", 
                    "Jumps on the spot and uses gravitational energy to perform a big slash to the enemy.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1_AND_AOE,
                    Skill.CS_BOTH,
                    "Rising Slash does 100% extra damage against Mechanic monsters."
                },
                {
                    "Violent Stub", 
                    "Deals damage by repeatedly kicking the enemy.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    ""
                },
                {
                    "Shadow Storm", 
                    "Summons a storm to deal massive damage.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1_AND_AOE,
                    Skill.CS_BOTH,
                    ""
                },
            },
        },
        {//Knight
            {//Tier 1
                {
                    "Sword Blast", 
                    "Throws a devastating sword to targeted enemy.",
                    Skill.TS_OFFENSE,
                    Skill.ES_LINEAR,
                    Skill.CS_BOTH,
                    "Sword Blast does an additional +50% Damage Boost against normal monsters and mutant monsters. Sword Blast does linear area damage to enemies in front of the player."
                },
                {
                    "Holy Body", 
                    "Become holy for a period of time to increase absorb rating against undead enemies.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    "Can not be used simultaneously with Holy Valor or Drastic Spirit."
                },
                {
                    "Physical Training", 
                    "Physical Training increases stamina permanently.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    ""
                },
                {
                    "Double Crash", 
                    "Strikes twice with a consecutive attack.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "Holy Aura adds 40% Attack Rating to Double Crash."
                },
            },
            {//Tier 2
                {
                    "Holy Valor", 
                    "Increases attack power of the party against the Undead.",
                    Skill.TS_BUFF,
                    Skill.ES_ALLY_AREA_BUFF,
                    Skill.CS_RIGHT,
                    "Can't be used simultaneously with Holy Body or Drastic Spirit. Damage Boost does not apply to AoE damage."
                },
                {
                    "Brandish", 
                    "Damaging all enemies within the splash range.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_BOTH,
                    "Only deals 50% damage in PvP."
                },
                {
                    "Piercing", 
                    "Pierces a sword through the targeted enemy with a powerful attack.",
                    Skill.TS_OFFENSE,
                    Skill.ES_LINEAR,
                    Skill.CS_BOTH,
                    "Piercing gives and additional +100% Damage Boost against mutant monsters. Piercing does linear area damage to enemies in front of the player."
                },
                {
                    "Drastic Spirit", 
                    "Increases defense rating.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    "Can't be used in conjunction with Holy Body or Holy Valor."
                },
            },
            {//Tier 3
                {
                    "Sword Mastery", 
                    "Increases attack power on swords permanently.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    ""
                },
                {
                    "Divine Shield", 
                    "Increases block and converts blocked undead damage into HP.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    "Divine Shield changes the appearance of your shield."
                },
                {
                    "Holy Incantation", 
                    "Transforms the targeted monster into a pet that will fight for you in battle for a period of time.",
                    Skill.TS_BUFF,
                    Skill.ES_SUMMON,
                    Skill.CS_RIGHT,
                    "You can only have one undead as your pet."
                },
                {
                    "Grand Cross", 
                    "Attacks the enemy with a deadly cross.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    ""
                },
            },
            {//Tier 4
                {
                    "Sword of Justice", 
                    "Attacks the enemy with the help of God's power to unleash a devastating strike.",
                    Skill.TS_OFFENSE,
                    Skill.ES_LINEAR,
                    Skill.CS_BOTH,
                    ""
                },
                {
                    "Godly Shield", 
                    "Forms a Holy Shield blessed by God.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    "Godly Shield automatically activates block of Divine Shield. Changes the appearance of your shield."
                },
                {
                    "God Bless", 
                    "Increases your attack power by the name of God.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    ""
                },
                {
                    "Divine Piercing", 
                    "Strikes the enemy with several powerful hits.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "Number of hits depends on skill level."
                },
            },
            {//Tier 5
                {
                    "Lightning Sword", 
                    "Use the Sword's magical power to subtract electricity from the air and stun enemies with it.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_RIGHT,
                    "Does no damage in PvP, but always stuns in PvP."
                },
                {
                    "Undead Bane", 
                    "Permanently boosts final damage on undead enemies.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    "Affects the final damage inflicted on a target, after all modifiers."
                },
                {
                    "Holy Justice", 
                    "One powerful attack inflicting severe damage on the target.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1_AND_AOE,
                    Skill.CS_BOTH,
                    "This skill has not yet been released"
                },
                {
                    "Holy Aura", 
                    "A powerful aura that sucks the trapped life out of nearby undead monsters.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    "Holy Aura adds an Attack Rating bonus of 40% to Double Crash and Divine Piercing. Holy Aura gives an one time 1 on 1 Final Damage bonus after being charged."
                },
            },
        },
        {//Atalanta
            {//Tier 1
                {
                    "Shield Strike", 
                    "Stuns and confuses the enemy by throwing your shield.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    ""
                },
                {
                    "Farina", 
                    "Throws a spear that creates illusions.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "50% additional dmg vs normal monsters."
                },
                {
                    "Throwing Mastery", 
                    "Trains Javelin attacks to increase damage permanently using Javelins.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    ""
                },
                {
                    "Bigger Spear", 
                    "Attacks the targeted enemy with a holy Javelin.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "50% additional dmg vs mechanic monsters."
                },
            },
            {//Tier 2
                {
                    "Windy", 
                    "Increases attack rating of Javelins.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    ""
                },
                {
                    "Twist Javelin", 
                    "Increase attack rating and attack power with using a twisting tactic.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "Additional 100% damage against demon monsters."
                },
                {
                    "Soul Sucker", 
                    "Absorbs the HP of enemies within attack range that have more than 50 percent HP.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    ""
                },
                {
                    "Fire Javelin", 
                    "Attacks the enemy with power of fire.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "Additional 100% damage against the mutants."
                },
            },
            {//Tier 3
                {
                    "Split Javelin", 
                    "Attacks the enemy with several powerful strikes at very fast speed.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    ""
                },
                {
                    "Triumph of Valhalla", 
                    "Increases attack power of all party members.",
                    Skill.TS_BUFF,
                    Skill.ES_ALLY_BUFF,
                    Skill.CS_RIGHT,
                    "Triumph of Valhalla cast onto other players give 50% of the added Max Attack Power based on the caster's level."
                },
                {
                    "Lightning Javelin", 
                    "Increases the lightning attribute of the Javelin.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_BOTH,
                    "Lightning Javelin gives an additional +50% Damage Boost Vs. mechanic monsters."
                },
                {
                    "Storm Javelin", 
                    "Attacks the enemy with a strong tornado tactic.",
                    Skill.TS_OFFENSE,
                    Skill.ES_LINEAR,
                    Skill.CS_BOTH,
                    "Storm Javelin does linear area damage to enemies in front of the player."
                },
            },
            {//Tier 4
                {
                    "Hall of Valhalla", 
                    "Creates a space to unleash the Power of Valhalla.",
                    Skill.TS_BUFF,
                    Skill.ES_ALLY_AREA_BUFF,
                    Skill.CS_RIGHT,
                    "50% chain Triumph of Valhalla. 50% of its benefits onto other player."
                },
                {
                    "Extreme Rage", 
                    "Attacks the enemy with Power of Anger.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_BOTH,
                    ""
                },
                {
                    "Frost Javelin", 
                    "Increases ice attribute for a period of time, reducing enemy speed when hit.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    ""
                },
                {
                    "Vengeance", 
                    "Attacks the enemy with several fast and powerful attacks.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    ""
                },
            },
            {//Tier 5
                {
                    "Chimera of Light", 
                    "Summons a Chimera of Light.",
                    Skill.TS_BUFF,
                    Skill.ES_SUMMON,
                    Skill.CS_RIGHT,
                    "The Chimera of Light buff is also applied to Party and Clan Members who are nearby the Chimera."
                },
                {
                    "Poison Javelin", 
                    "Hits the target with a fierce Poison Javelin.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_BOTH,
                    ""
                },
                {
                    "Amazon Rage", 
                    "Use Amazon's Power for increased attack speed, move speed.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    "Doubles Mana skill usage."
                },
                {
                    "Javelin Mastery", 
                    "Permanently increases critical when using Javelins.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    ""
                },
            },
        },
        {//Priestess
            {//Tier 1
                {
                    "Healing", 
                    "Heals life with holy magic.",
                    Skill.TS_BUFF,
                    Skill.ES_ALLY_BUFF,
                    Skill.CS_BOTH,
                    ""
                },
                {
                    "Holy Bolt", 
                    "Attacks the enemy with a holy bolt.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "Holy Bolt gets an additional +100% Damage Boost Vs. Undead monsters."
                },
                {
                    "Multi Spark", 
                    "Releases magical sparks towards the enemy that stack into one powerful hit.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "Damage and number of sparks depend on level. Add 50% damage boost bonus Vs. Mechanic."
                },
                {
                    "Holy Mind", 
                    "Weakens the enemy attack power for a small period of time.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_RIGHT ,
                    "Can only be used on monsters."
                },
            },
            {//Tier 2
                {
                    "Meditation", 
                    "Increases MP Recovery permanently.",
                    Skill.TS_PASSIVE,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_NONE,
                    ""
                },
                {
                    "Divine Lightning", 
                    "Attacks the enemy with a holy lightning.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_RIGHT,
                    "Divine Lightning gets an additional +50% Damage Boost Vs. undead monsters."
                },
                {
                    "Holy Reflection", 
                    "Reflects attacks from Undead enemies.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    ""
                },
                {
                    "Grand Healing", 
                    "Heals life of party members.",
                    Skill.TS_BUFF,
                    Skill.ES_ALLY_AREA_BUFF,
                    Skill.CS_RIGHT,
                    ""
                },
            },
            {//Tier 3
                {
                    "Vigor Ball", 
                    "Fires two Vigor Balls towards the enemy.",
                    Skill.TS_OFFENSE,
                    Skill.ES_1V1,
                    Skill.CS_BOTH,
                    "Vigor Ball does an additional +50% Damage Boost Vs. Undead monsters."
                },
                {
                    "Resurrection", 
                    "Revives dead players within range.",
                    Skill.TS_BUFF,
                    Skill.ES_ALLY_AREA_BUFF,
                    Skill.CS_RIGHT,
                    "Resurrection does not prevent loss of EXP and Gold."
                },
                {
                    "Extinction", 
                    "Lethal incantation to undead monsters.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_RIGHT,
                    ""
                },
                {
                    "Virtual Life", 
                    "Increases the HP of the targeted friend for a period of time, and a 10% abs buff against monsters.",
                    Skill.TS_BUFF,
                    Skill.ES_ALLY_BUFF,
                    Skill.CS_BOTH,
                    ""
                },
            },
            {//Tier 4
                {
                    "Glacial Spike", 
                    "Releases a huge ice block towards the enemy freezing all enemies in range.",
                    Skill.TS_OFFENSE,
                    Skill.ES_CONE,
                    Skill.CS_BOTH,
                    ""
                },
                {
                    "Regeneration Field", 
                    "Creates a Regeneration field for a period of time.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_AURA,
                    Skill.CS_RIGHT,
                    "Regeneration Field leaves the player in a vulnerable state when used. Other players within Regeneration Field area will receive 50% of the benefits."
                },
                {
                    "Chain Lightning", 
                    "Releases a devastating Divine Lightning which also chain damages monsters in range.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_BOTH,
                    "Add 50% damage boost Vs.Normal Monster."
                },
                {
                    "Summon Muspell", 
                    "Summons a Muspell which absorbs attack power of Undead enemies.",
                    Skill.TS_BUFF,
                    Skill.ES_SELF_BUFF,
                    Skill.CS_RIGHT,
                    "Muspell's damage is equal to your own character."
                },
            },
            {//Tier 5
                {
                    "Divine Force", 
                    "Increases the 1 on 1 final damage of all party members.",
                    Skill.TS_BUFF,
                    Skill.ES_ALLY_AREA_BUFF,
                    Skill.CS_RIGHT,
                    "Final damage boost bonus x2 Vs. Undead."
                },
                {
                    "Ice Meteorite", 
                    "Calls in an ice cold meteorite storm which will damage and freeze opponents near the strike area of each meteorite.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_BOTH,
                    "The freezing time is stacked on existing freeze time of the opponent."
                },
                {
                    "Thunderstorm", 
                    "Create a devastating thunderstorm.",
                    Skill.TS_OFFENSE,
                    Skill.ES_AOE,
                    Skill.CS_RIGHT,
                    "This skill has not yet been released."
                },
                {
                    "Divine Cleansing", 
                    "Cleanse the targeted friend from debuffs and grants a short invulnerability.",
                    Skill.TS_BUFF,
                    Skill.ES_ALLY_BUFF,
                    Skill.CS_RIGHT,
                    ""
                },
            },
        },
        {//Magician
            {//Tier 1
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
            },
            {//Tier 2
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
            },
            {//Tier 3
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
            },
            {//Tier 4
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
            },
            {//Tier 5
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
            },
        },
        {//Shaman
            {//Tier 1
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
            },
            {//Tier 2
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
            },
            {//Tier 3
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
            },
            {//Tier 4
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
            },
            {//Tier 5
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
                {
                    "", 
                    "",
                    Skill.TS_,
                    Skill.ES_,
                    Skill.CS_,
                    ""
                },
            },
        }
        };
    }
    
}

/*
{
    "", 
    "",
    Skill.TS_,
    Skill.ES_,
    Skill.CS_,
    ""
},

*/