/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.game.skill;

import controller.game.formula.CharacterStats;
import model.skillHelper.SkillCost;
import model.skillHelper.SkillList;
import model.skillHelper.SkillReqLevel;

/**
 *
 * @author Luiz
 */
public class SkillSS extends Skill {
    
    private static final int CLASSE = SS;

    public SkillSS(CharacterStats c, int tier, int skill) {
        SkillList sl = new SkillList();
        SkillCost sc = new SkillCost();
        SkillReqLevel srl = new SkillReqLevel();
        
        super.c = c;
        super.tier = tier;
        super.skill = skill;
        super.reqLvl = new int[]{
            srl.SKILL_REQLVL[tier][skill][0],
            srl.SKILL_REQLVL[tier][skill][1],
            srl.SKILL_REQLVL[tier][skill][2],
            srl.SKILL_REQLVL[tier][skill][3],
            srl.SKILL_REQLVL[tier][skill][4],
            srl.SKILL_REQLVL[tier][skill][5],
            srl.SKILL_REQLVL[tier][skill][6],
            srl.SKILL_REQLVL[tier][skill][7],
            srl.SKILL_REQLVL[tier][skill][8],
            srl.SKILL_REQLVL[tier][skill][9],
        };
        super.charClass = c.getClasse();
        super.name = sl.SKILL_STR[CLASSE][tier][skill][SKILL_NAME];
        super.desc = sl.SKILL_STR[CLASSE][tier][skill][SKILL_DESC];
        super.type = sl.SKILL_STR[CLASSE][tier][skill][SKILL_TYPE];
        super.effect = sl.SKILL_STR[CLASSE][tier][skill][SKILL_EFFECT];
        super.castMethod = sl.SKILL_STR[CLASSE][tier][skill][SKILL_CLICK];
        super.lore = sl.SKILL_STR[CLASSE][tier][skill][SKILL_LORE];
        super.skillImg = getSkillIcon(name, tier, skill);
        super.timerImg = "";

        super.skillCost = new int[] {
            sc.SKILL_COST[tier][skill][0],
            sc.SKILL_COST[tier][skill][1],
            sc.SKILL_COST[tier][skill][2],
            sc.SKILL_COST[tier][skill][3],
            sc.SKILL_COST[tier][skill][4],
            sc.SKILL_COST[tier][skill][5],
            sc.SKILL_COST[tier][skill][6],
            sc.SKILL_COST[tier][skill][7],
            sc.SKILL_COST[tier][skill][8],
            sc.SKILL_COST[tier][skill][9],
        };

        switch (tier) {
            case 0:
                switch (skill) {
                    case 0:
                        
                    break;
                    
                    case 1:
                        
                    break;
                    
                    case 2:
                        
                    break;
                    
                    case 3:
                        
                    break;
                }
            break;
            
            case 1:
                switch (skill) {
                    case 0:
                        
                    break;
                    
                    case 1:
                        
                    break;
                    
                    case 2:
                        
                    break;
                    //Advent Migal
                    case 3:
                        //Skill properties
                        reqItem = new String[]{WS_PHANTOM};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1),
                                getSkillSfx(2),
                            };
                        halfPartyCast = false;
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{30, 32, 34, 36, 38, 40, 42, 44, 46, 48};
                        useSP = new int[]{28, 29, 30, 31, 32, 33, 34, 35, 36, 37};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{25000, 25000, 25000, 25000, 25000, 25000, 25000, 25000, 25000, 25000};
                        duration = new int[]{300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[0];
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_ADD_FLAT_ATK_POW, AS_AURA_AOE_RANGE};
                        //Effects Value
                        value = new float[][]
                        {
                            {30, 33, 36, 39, 42, 45, 48, 51, 54, 57},
                            {220, 220, 220, 220, 220, 220, 220, 220, 220, 220}
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                }
            break;
            
            case 2:
                switch (skill) {
                    case 0:
                        
                    break;
                    
                    case 1:
                        
                    break;
                    
                    case 2:
                        
                    break;
                    
                    case 3:
                        
                    break;
                }
            break;
            
            case 3:
                switch (skill) {
                    case 0:
                        
                    break;
                    
                    case 1:
                        
                    break;
                    //Advent Midranda
                    case 2:
                        //Skill properties
                        reqItem = new String[]{WS_PHANTOM};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1),
                                getSkillSfx(2),
                            };
                        halfPartyCast = false;
                        skillChain = true;
                        tierSkillChained = new int[]{1,3};
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{100, 104, 108, 112, 116, 120, 124, 128, 132, 136};
                        useSP = new int[]{39, 40, 41, 42, 43, 44, 45, 46, 47, 48};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{25000, 25000, 25000, 25000, 25000, 25000, 25000, 25000, 25000, 25000};
                        duration = new int[]{300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[0];
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_ADD_ATK_SPD, AS_AURA_AOE_RANGE};
                        //Effects Value
                        value = new float[][]
                        {
                            {2, 4, 6, 8, 10, 11, 12, 13, 14, 15},
                            {220, 220, 220, 220, 220, 220, 220, 220, 220, 220}
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                    
                    case 3:
                        
                    break;
                }
            break;
            
            case 4:
                switch (skill) {
                    case 0:
                        
                    break;
                    
                    case 1:
                        
                    break;
                    
                    case 2:
                        
                    break;
                    
                    case 3:
                        
                    break;
                }
            break;
        }
        

    }

}
