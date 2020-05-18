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
public class SkillMGS extends Skill {
    
    private static final int CLASSE = MGS;

    public SkillMGS(CharacterStats c, int tier, int skill) {
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
                    //Enchant Weapon
                    case 2:
                        //Skill properties
                        reqItem = new String[]{WS_WAND};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1),
                            };
                        halfPartyCast = false;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{30, 32, 34, 37, 40, 44, 48, 53, 58, 64};
                        useSP = new int[]{28, 29, 30, 31, 32, 33, 34, 35, 36, 37};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{1500, 2000, 2500, 3000, 3500, 4000, 4500, 5000, 5500, 6000};
                        duration = new int[]{300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[0];
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_ADD_FIRE_MIN_DMG, AS_ADD_FIRE_MAX_DMG, AS_BURN_DUR, AS_BURN_STR, AS_ADD_LIGHT_MIN_DMG, AS_ADD_LIGHT_MAX_DMG, AS_AOE_LIGHT_RANGE, 
                            AS_ADD_ICE_MIN_DMG, AS_ADD_ICE_MAX_DMG, AS_ICE_SLOW_DUR, AS_ICE_SLOW_STR
                        };
                        //Effects Value
                        value = new float[][]
                        {
                            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, //fire min dmg
                            {2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, //fire max dmg
                            {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000}, //fire burn duration
                            {100, 100, 100, 100, 100, 100, 100, 100, 100, 100}, //fire burn strenght
                            {2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, //light min dmg
                            {3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, //light max dmg
                            {33, 36, 39, 42, 45, 48, 51, 54, 57, 60}, //light default atk aoe
                            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, //ice min dmg
                            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, //ice max dmg
                            {1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000}, //ice slow duration
                            {25, 25, 25, 25, 25, 25, 25, 25, 25, 25} //ice slow strenght
                                
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                    
                    case 3:
                        
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
                    
                    case 2:
                        
                    break;
                    
                    case 3:
                        
                    break;
                }
            break;
            
            case 4:
                switch (skill) {
                    //Magic Source
                    case 0:
                        //Skill properties
                        reqItem = new String[]{WS_WAND};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1),
                            };
                        halfPartyCast = false;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{70, 74, 78, 82, 86, 90, 94, 98, 102, 106};
                        useSP = new int[]{44, 47, 50, 53, 56, 59, 62, 65, 68, 71};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{10000, 9000, 8000, 7000, 6000, 5000, 4000, 3000, 2000, 1000};
                        duration = new int[]{300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[0];
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_MP_BOOST, AS_SP_BOOST, AS_CAST_RANGE};
                        //Effects Value
                        value = new float[][]
                        {
                            {5, 10, 15, 20, 25, 30, 35, 40, 45, 50}, //add mp %
                            {2, 10, 18, 26, 34, 42, 50, 58, 66, 74}, //add sp %
                            {140, 140, 140, 140, 140, 140, 140, 140, 140, 140} //cast range
                                
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
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
