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
        this.SKILL_STR = new String[][][][]{
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
        {//Knight
            {//Tier
                {"Sword Blast", "Throws a devastating sword to targeted enemy.", s.ES_AOE},
                {"Holy Body"},
                {"Phystical Training"},
                {"Double Crash"}
            },
            {
                {"Holy Valor"},
                {"Brandish"},
                {"Piercing"},
                {"Drastic Spirit"}
            },
            {
                {"Sword Mastery"},
                {"Divine Shield"},
                {"Holy Incantation"},
                {"Grand Cross"}
            },
            {
                {"Sword of Justice"},
                {"Godly Shield"},
                {"God Bless"},
                {"Divine Piercing"}
            },
            {
                {"Lightning Sword"},
                {"Undead Bane"},
                {"Holy Justice"},
                {"Holy Aura"}

            }
        }};
    }
    
}
