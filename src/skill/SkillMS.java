/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skill;

import formula.CharacterStats;
import java.util.Arrays;
import model.skillHelper.SkillCost;
import model.skillHelper.SkillList;
import model.skillHelper.SkillReqLevel;

/**
 *
 * @author Luiz
 */
public class SkillMS extends Skill {
    
    private static final int CLASSE = MS;

    public SkillMS(CharacterStats c, int tier, int skill) {
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
            srl.SKILL_REQLVL[tier][skill][9]
        };
        super.charClass = c.getClasse();
        super.name = sl.SKILL_STR[CLASSE][tier][skill][SKILL_NAME];
        super.desc = sl.SKILL_STR[CLASSE][tier][skill][SKILL_DESC];
        super.type = sl.SKILL_STR[CLASSE][tier][skill][SKILL_TYPE];
        super.effect = sl.SKILL_STR[CLASSE][tier][skill][SKILL_EFFECT];
        super.castMethod = sl.SKILL_STR[CLASSE][tier][skill][SKILL_CLICK];
        super.lore = sl.SKILL_STR[CLASSE][tier][skill][SKILL_LORE];
        super.skillImg = "/assets/images/skills/"+charClass+"/Button/"+(tier+1)+(skill+1)+".bmp";
        super.timerImg = "";
        super.elementImg = "";

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
                        //Valores
                        super.reqItem = new String[]{WS_SHIELD};
                        super.hits = new int[]{1,1,1,1,1,1,1,1,1,1};
                        super.hitsInterval = new int[0];
                        super.element = E_NORMAL;
                        super.canCrit = new boolean[]{false};
                        super.soundSFX = new String[]{
                                "/assets/sfx/skill/" + c.getClasse() + "/" + super.name + "1.wav",
                            };
                        //Gasto de recursos
                        super.useHP = new int[]{0,0,0,0,0,0,0,0,0,0};
                        super.useMP = new int[]{12, 14, 17, 20, 23, 26, 30, 34, 39, 44};
                        super.useSP = new int[]{34, 36, 38, 40, 42, 44, 46, 48, 50, 52};
                        //Cooldown e duração do efeito
                        super.cooldown = new int[]{500, 500, 500, 500, 500, 500, 500, 500, 500, 500};
                        super.duration = new int[]{};
                        
                        //Tipo do efeito da skill
                        super.attribute = new String[]{AS_ADD_BLOCK};
                        //Valor do efeito
                        super.value = new float[][]
                        {
                            {4, 5, 6, 7, 8, 9, 10, 11, 13, 15},
                        };
                        //Adicional contra monstro
                        super.monsterBonus = new String[]{};
                        super.monsterValue = 0;
                    break;
                    
                    case 1:
                        //Valores
                        super.reqItem = new String[]{WS_ANY};
                        super.hits = new int[]{1,1,1,1,1,1,1,1,1,1};
                        super.hitsInterval = new int[0];
                        
                        super.element = E_NORMAL;
                        
                        super.canCrit = new boolean[]{false};
                        
                        super.soundSFX = new String[]{
                                "/assets/sfx/skill/" + c.getClasse() + "/" + super.name + "1.wav",
                            };
                        
                        super.useHP = new int[]{0,0,0,0,0,0,0,0,0,0};
                        super.useMP = new int[]{12, 14, 17, 20, 23, 26, 30, 34, 39, 44};
                        super.useSP = new int[]{34, 36, 38, 40, 42, 44, 46, 48, 50, 52};

                        super.cooldown = new int[]{500, 500, 500, 500, 500, 500, 500, 500, 500, 500};
                        super.duration = new int[]{};
                        
                        //Tipo do efeito da skill
                        super.attribute = new String[]{AS_ADD_BLOCK};
                        //Valor do efeito
                        super.value = new float[][]
                        {
                            {4, 5, 6, 7, 8, 9, 10, 11, 13, 15},
                        };
                        //Adicional contra monstro
                        super.monsterBonus = new String[]{};
                        super.monsterValue = 0;
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
