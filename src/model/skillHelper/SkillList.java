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
    public final String[][][][] SKILL_STR = 
        {//Knight
            {//Tier 1
                {//Skills
                    {"Sword Blast", "Throws a devastating sword to targeted enemy.", s.ES_AOE},
                    {"Holy Body"},
                    {"Phystical Training"},
                    {"Double Crash"}
                }
            },
            {
                {
                    {"Holy Valor"},
                    {"Brandish"},
                    {"Piercing"},
                    {"Drastic Spirit"}
                }
            },
            {
                {
                    {"Sword Mastery"},
                    {"Divine Shield"},
                    {"Holy Incantation"},
                    {"Grand Cross"}
                }
            },
            {
                {
                    {"Sword of Justice"},
                    {"Godly Shield"},
                    {"God Bless"},
                    {"Divine Piercing"}
                }
            },
            {
                {
                    {"Lightning Sword"},
                    {"Undead Bane"},
                    {"Holy Justice"},
                    {"Holy Aura"}
                    
                }
            }
        };
    
        
}
