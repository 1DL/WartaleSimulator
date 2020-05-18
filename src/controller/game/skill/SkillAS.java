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
public class SkillAS extends Skill {
    
    private static final int CLASSE = AS;

    public SkillAS(CharacterStats c, int tier, int skill) {
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
                    //Force of Nature
                    case 3:
                        //Skill properties
                        reqItem = new String[]{WS_BOW};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1),
                            };
                        halfPartyCast = true;
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{51, 54, 57, 60, 63, 66, 69, 72, 75, 78};
                        useSP = new int[]{56, 58, 60, 62, 64, 66, 68, 70, 72, 74};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{17500, 17500, 17500, 17500, 17500, 17500, 17500, 17500, 17500, 17500};
                        duration = new int[]{300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[0];
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_ADD_FLAT_ATK_POW, AS_ADD_FLAT_ATK_RTG};
                        //Effects Value
                        value = new float[][]
                        {
                            {12, 24, 36, 48, 60, 72, 84, 96, 108, 120},
                            {20, 30, 40, 50, 60, 70, 80, 90, 100, 110},
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
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
