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
public class SkillPS extends Skill {
    
    private static final int CLASSE = PS;

    public SkillPS(CharacterStats c, int tier, int skill) {
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
                    
                    case 3:
                        
                    break;
                }
            break;
            
            case 2:
                switch (skill) {
                    case 0:
                        
                    break;
                    //Vanish
                    case 1:
                        //Skill properties
                        reqItem = new String[]{WS_ANY};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1),
                                getSkillSfx(2),
                            };
                        halfPartyCast = false;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{40, 43, 46, 49, 52, 55, 58, 62, 66, 70};
                        useSP = new int[]{53, 55, 57, 59, 61, 63, 65, 67, 69, 71};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{17500, 17500, 17500, 17500, 17500, 17500, 17500, 17500, 17500, 17500};
                        duration = new int[]{300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[0];
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_NEXT_HIT_DMG_BOOST, AS_VISIBILITY};
                        //Effects Value
                        value = new float[][]
                        {
                            {8, 16, 24, 32, 40, 48, 56, 64, 72, 80}, //Next hit damage boost
                            {-40, -46, -52, -58, -64, -70, -75, -80, -85, -90} //Monster Sight range % decrease                    
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                    
                    case 2:
                        
                    break;
                    
                    case 3:
                        
                    break;
                }
            break;
            
            case 3:
                switch (skill) {
                    //Assassin Eye
                    case 0:
                        //Skill properties
                        reqItem = new String[]{WS_SCYTHE};
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
                        useMP = new int[]{47, 49, 51, 53, 55, 57, 59, 61, 63, 65};
                        useSP = new int[]{61, 63, 65, 67, 69, 71, 73, 75, 77, 79};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{17500, 17500, 17500, 17500, 17500, 17500, 17500, 17500, 17500, 17500};
                        duration = new int[]{12000, 13000, 14000, 15000, 16000, 17000, 18000, 19000, 20000, 21000};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[0];
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_CRIT_DMG_BOOST, AS_MON_CRIT_CHANCE_BOOST};
                        //Effects Value
                        value = new float[][]
                        {
                            {10, 14, 18, 22, 26, 30, 34, 38, 42, 46}, //Critical Damage Boost
                            {4, 5, 6, 7, 8, 9, 10, 11, 12, 13} //Critical Chance boost vs monster                              
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
