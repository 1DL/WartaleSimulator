/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.game.skill;

import controller.game.formula.CharacterStats;
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
                    //Extreme Shield
                    case 0:
                        //Valores
                        reqItem = new String[]{WS_SHIELD};
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[0];
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        canCrit = new boolean[]{false};
                        soundSFX = new String[]{
                                getSkillSfx(1),
                            };
                        //Gasto de recursos
                        useHP = new int[]{0,0,0,0,0,0,0,0,0,0};
                        useMP = new int[]{12, 14, 17, 20, 23, 26, 30, 34, 39, 44};
                        useSP = new int[]{34, 36, 38, 40, 42, 44, 46, 48, 50, 52};
                        //Cooldown e duração do efeito
                        cooldown = new int[]{3500, 4500, 5500, 6500, 7500, 8500, 9500, 10500, 11500, 12500};
                        duration = new int[]{300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000};
                        
                        //Tipo do efeito da skill
                        attribute = new String[]{AS_ADD_BLOCK};
                        //Valor do efeito
                        value = new float[][]
                        {
                            {4, 5, 6, 7, 8, 9, 10, 11, 13, 15},
                        };
                        //Adicional contra monstro
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                    //Mechanic Bomb
                    case 1:
                        //Skill properties
                        reqItem = new String[]{WS_ANY};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1),
                                getSkillSfx(2),
                            };
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0,0,0,0,0,0,0,0,0,0};
                        useMP = new int[]{8, 10, 12, 14, 17, 20, 23, 26, 29, 33};
                        useSP = new int[]{28, 30, 32, 34, 36, 38, 40, 42, 44, 46};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{500, 500, 500, 500, 500, 500, 500, 500, 500, 500};
                        duration = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[1000];
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_VAR_FLAT_MIN_DMG_BOOST, AS_VAR_FLAT_MAX_DMG_BOOST, AS_AOE_RANGE};
                        //Effects Value
                        value = new float[][]
                        {
                            {5, 10, 15, 20, 25, 30, 35, 40, 45, 50},
                            {10, 20, 30, 40, 50, 60, 70, 80, 90, 100},
                            {64, 68, 72, 76, 80, 84, 88, 92, 96, 100}
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{MB_MUTANT, MB_MECHANIC};
                        monsterValue = 500;
                    break;
                    //Poison Attribute
                    case 2:
                        //Skill properties
                        reqItem = new String[]{WS_ANY};
                        element = E_POISON;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                            };
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useSP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        duration = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        //Active behavior and hits animation duration
                        hits = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        hitsInterval = new int[0];
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_ADD_POISON_RES};
                        //Effects Value
                        value = new float[][]
                        {
                            {5, 10, 15, 20, 25, 30, 35, 40, 45, 50},
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                    //Physical Absorption
                    case 3:
                        //Skill properties
                        reqItem = new String[]{WS_ANY};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1),
                                getSkillSfx(2),
                                getSkillSfx(3),
                            };
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{20, 24, 28, 32, 36, 40, 44, 48, 52, 56};
                        useSP = new int[]{30, 32, 34, 36, 38, 40, 42, 44, 46, 48};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{4000, 5000, 6500, 7500, 9000, 10000, 11500, 12500, 14000, 15000};
                        duration = new int[]{300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[0];
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_ADD_ABS};
                        //Effects Value
                        value = new float[][]
                        {
                            {4, 6, 12, 14, 20, 22, 28, 30, 36, 38},
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
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
