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
public class SkillKS extends Skill {
    
    private static final int CLASSE = KS;

    public SkillKS(CharacterStats c, int tier, int skill) {
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
            //tier 1
            case 0:
                switch (skill) {
                    //Sword Blast
                    case 0:
                        //Skill properties
                        reqItem = new String[]{WS_SWORD};
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
                        useMP = new int[]{8, 10, 12, 15, 18, 21, 25, 29, 33, 38};
                        useSP = new int[]{22, 24, 26, 28, 30, 32, 34, 36, 38, 40};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{500, 500, 500, 500, 500, 500, 500, 500, 500, 500};
                        duration = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[]{0};
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_DMG_BOOST, AS_CAST_RANGE};
                        //Effects Value
                        value = new float[][]
                        {
                            {87, 94, 101, 108, 115, 122, 129, 136, 143, 150}, //dmg boost
                            {70, 75, 80, 85, 90, 95, 100, 105, 110, 120} //cast range                                
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{MB_NORMAL, MB_MUTANT};
                        monsterValue = 50;
                    break;
                        //Holy Body
                    case 1:
                        //Skill properties
                        reqItem = new String[]{WS_ANY};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1)
                            };
                        halfPartyCast = false;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        tierSkillCancelOnCast = new int[][]
                        {
                            {1,0},
                            {1,3}
                        };
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{18, 21, 24, 27, 30, 34, 38, 42, 46, 50};
                        useSP = new int[]{28, 30, 32, 34, 36, 38, 40, 42, 44, 46};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{3500, 4000, 5000, 5500, 6500, 7000, 8000, 8500, 9500, 10000};
                        duration = new int[]{300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[]{0};
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_MON_UNDEAD_DMG_RED};
                        //Effects Value
                        value = new float[][]
                        {
                            {8, 12, 16, 19, 22, 25, 27, 29, 31, 33} //undead dmg reduction                           
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                        //Physical Training
                    case 2:
                        //Skill properties
                        reqItem = new String[]{WS_ANY};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                            };
                        halfPartyCast = false;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useSP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        duration = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        //Active behavior and hits animation duration
                        hits = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        hitsInterval = new int[]{0};
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_ADD_STM_BOOST};
                        //Effects Value
                        value = new float[][]
                        {
                            {5, 10, 15, 20, 25, 30, 35, 40, 45, 50} //passive stamine boost
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                        //Double Crash <3
                    case 3:
                        //Skill properties
                        reqItem = new String[]{WS_SWORD, WS_AXE, WS_CLAW};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                SFX_WEAPON,
                                SFX_WEAPON,
                            };
                        halfPartyCast = false;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{18, 20, 22, 24, 27, 30, 33, 36, 39, 42};
                        useSP = new int[]{35, 37, 39, 41, 43, 45, 47, 49, 51, 53};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{500, 500, 500, 500, 500, 500, 500, 500, 500, 500};
                        duration = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        //Active behavior and hits animation duration
                        hits = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
                        hitsInterval = new int[]{500,200};
                        canCrit = new boolean[]{true, true};
                        //Skill effect type
                        attribute = new String[]{AS_DMG_BOOST, AS_ADD_FLAT_CRIT_CHANCE};
                        //Effects Value
                        value = new float[][]
                        {
                            {9, 18, 27, 36, 45, 54, 63, 72, 81, 90}, //dmg boost
                            {2, 4, 6, 8, 10, 11, 12, 13, 14, 15} //add crit chance                               
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                }
            break;
            //tier 2
            case 1:
                switch (skill) {
                    //Holy Valor
                    case 0:
                        //Skill properties
                        reqItem = new String[]{WS_ANY};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1),
                                getSkillSfx(2),
                            };
                        halfPartyCast = true;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        tierSkillCancelOnCast = new int[][]
                        {
                            {0,1},
                            {1,3}
                        };
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{23, 26, 29, 32, 35, 38, 41, 44, 47, 50};
                        useSP = new int[]{36, 38, 40, 42, 44, 46, 48, 50, 52, 54};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{1000, 1500, 2500, 3000, 4000, 4500, 5500, 6000, 7000, 7500};
                        duration = new int[]{300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[]{0};
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_1V1_UNDEAD_DMG_BOOST, AS_AOE_RANGE};
                        //Effects Value
                        value = new float[][]
                        {
                            {5, 10, 15, 20, 25, 30, 34, 38, 40, 42}, //1v1 undead boost
                            {192, 194, 196, 198, 200, 202, 204, 206, 208, 210} //aoe range                                
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                        //Brandish
                    case 1:
                        //Skill properties
                        reqItem = new String[]{WS_SWORD, WS_SCYTHE};
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
                        useMP = new int[]{22, 24, 26, 28, 30, 33, 36, 39, 42, 45};
                        useSP = new int[]{38, 40, 42, 44, 46, 48, 50, 52, 54, 56};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{500, 500, 500, 500, 500, 500, 500, 500, 500, 500};
                        duration = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[]{500};
                        canCrit = new boolean[]{false};
                        pvpModifier = 0.5f;
                        //Skill effect type
                        attribute = new String[]{AS_DMG_BOOST, AS_AOE_RANGE};
                        //Effects Value
                        value = new float[][]
                        {
                            {70, 75, 81, 88, 96, 104, 113, 122, 131, 140}, //dmg boost
                            {93, 96, 99, 102, 105, 108, 111, 114, 117, 120} //aoe range                                
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                        //Piercing
                    case 2:
                        //Skill properties
                        reqItem = new String[]{WS_SWORD};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1)
                            };
                        halfPartyCast = false;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{24, 26, 28, 30, 32, 34, 36, 38, 40, 42};
                        useSP = new int[]{41, 43, 45, 47, 49, 51, 53, 55, 57, 59};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{500, 500, 500, 500, 500, 500, 500, 500, 500, 500};
                        duration = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[]{300};
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_DMG_BOOST, AS_LINEAR_RANGE, AS_CAST_RANGE};
                        //Effects Value
                        value = new float[][]
                        {
                            {85, 90, 95, 100, 105, 110, 120, 130, 140, 150}, //dmg boost
                            {240, 250, 260, 270, 280, 290, 300, 310, 320, 330}, //linear range                                
                            {120, 125, 130, 135, 140, 145, 150, 155, 160, 165} //cast range                                
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{MB_MUTANT};
                        monsterValue = 100;
                    break;
                        //Drastic Spirit
                    case 3:
                        //Skill properties
                        reqItem = new String[]{WS_ANY};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1),
                                getSkillSfx(2)
                            };
                        halfPartyCast = false;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        tierSkillCancelOnCast = new int[][]
                        {
                            {0,1},
                            {1,0}
                        };
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{25, 27, 29, 32, 35, 38, 41, 45, 49, 54};
                        useSP = new int[]{44, 46, 48, 50, 52, 54, 56, 58, 60, 62};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{500, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500, 5000};
                        duration = new int[]{300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[]{0};
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_ADD_DEF_BOOST};
                        //Effects Value
                        value = new float[][]
                        {
                            {4, 6, 8, 10, 12, 14, 16, 18, 20, 22} //Defense boost
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                }
            break;
            //Tier 3
            case 2:
                switch (skill) {
                    //Sword Mastery
                    case 0:
                        //Skill properties
                        reqItem = new String[]{WS_ANY};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                            };
                        halfPartyCast = false;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useSP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        duration = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        //Active behavior and hits animation duration
                        hits = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        hitsInterval = new int[]{0};
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_ADD_WEAPON_DMG_BOOST};
                        //Effects Value
                        value = new float[][]
                        {
                            {8, 11, 14, 17, 20, 23, 26, 29, 32, 35} //passive weapon dmg boost
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                        //Divine Shield
                    case 1:
                        //Skill properties
                        reqItem = new String[]{WS_SHIELD};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1)
                            };
                        halfPartyCast = false;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        tierSkillCancelOnCast = new int[][]
                        {
                            {3,1}
                        };
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{30, 33, 36, 39, 43, 47, 51, 55, 60, 65};
                        useSP = new int[]{46, 48, 50, 52, 54, 56, 58, 60, 62, 64};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{8000, 8000, 8500, 8500, 9000, 9000, 9500, 9500, 10000, 10000};
                        duration = new int[]{300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[]{0};
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_ADD_SHIELD_BLOCK, AS_MON_UNDEAD_BLOCK_HP_CONVERT};
                        //Effects Value
                        value = new float[][]
                        {
                            {1, 1, 1, 2, 2, 2, 3, 3, 3, 4}, //Extra shield block
                            {9, 18, 27, 36, 45, 54, 63, 72, 81, 90} //Undead blocked dmg hp conversion
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                        //Holy Incantation
                    case 2:
                         //Skill properties
                        reqItem = new String[]{WS_ANY};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1)
                            };
                        halfPartyCast = false;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        tierSkillCancelOnCast = new int[][]
                        {
                            {}
                        };
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{36, 39, 42, 45, 48, 52, 56, 60, 65, 70};
                        useSP = new int[]{50, 52, 54, 56, 58, 60, 62, 64, 66, 68};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{5500, 5500, 6000, 6000, 6500, 6500, 7000, 7000, 7500, 7500};
                        duration = new int[]{300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[]{0};
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_UNDEAD_PET_CHANCE, AS_UNDEAD_PET_HP};
                        //Effects Value
                        value = new float[][]
                        {
                            {45, 54, 62, 69, 75, 80, 84, 88, 92, 96}, //Convert undead into pet chance
                            {100, 120, 140, 160, 180, 200, 220, 240, 260, 280} //Converted undead pet hp increase
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                        //Grand Cross
                    case 3:
                        //Skill properties
                        reqItem = new String[]{WS_SWORD, WS_HAMMER};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1),
                                getSkillSfx(2)
                            };
                        halfPartyCast = false;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{28, 31, 34, 37, 40, 43, 46, 49, 52, 55};
                        useSP = new int[]{45, 47, 49, 51, 53, 55, 57, 59, 61, 63};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{500, 500, 500, 500, 500, 500, 500, 500, 500, 500};
                        duration = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        //Active behavior and hits animation duration
                        hits = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
                        hitsInterval = new int[]{200,300};
                        canCrit = new boolean[]{true, true};
                        //Skill effect type
                        attribute = new String[]{AS_DMG_BOOST, AS_ADD_ATK_RTG_BOOST, AS_UNDEAD_DMG_BOOST};
                        //Effects Value
                        value = new float[][]
                        {
                            {35, 40, 45, 50, 55, 60, 65, 70, 75, 80},//Dmg boost                             
                            {35, 40, 45, 50, 55, 60, 65, 70, 75, 80},//Atk Rating boost                  
                            {35, 40, 45, 50, 55, 60, 65, 70, 75, 80},//Undead dmg boost           
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                }
            break;
                //Tier 4
            case 3:
                switch (skill) {
                        //Sword of Justice
                    case 0:
                        //Skill properties
                        reqItem = new String[]{WS_SWORD};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1)
                            };
                        halfPartyCast = false;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{50, 53, 56, 59, 62, 65, 68, 71, 74, 77};
                        useSP = new int[]{53, 55, 57, 59, 61, 63, 65, 67, 69, 71};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};
                        duration = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[]{500};
                        canCrit = new boolean[]{false};
                        pvpModifier = 0.5f;
                        //Skill effect type
                        attribute = new String[]{AS_DMG_BOOST, AS_LINEAR_RANGE};
                        //Effects Value
                        value = new float[][]
                        {
                            {70, 80, 90, 100, 110, 120, 130, 140, 150, 160}, //dmg boost
                            {100, 110, 120, 130, 140, 160, 180, 200, 220, 240} //linear aoe range                                
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                        //Godly Shield
                    case 1:
                        //Skill properties
                        reqItem = new String[]{WS_SHIELD};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1)
                            };
                        halfPartyCast = false;
                        skillChain = true;
                        tierSkillChained = new int[]{2,1};
                        chainedSkillEffectIndex = 0;
                        tierSkillCancelOnCast = new int[][]
                        {
                            {2, 1}
                        };
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{47, 50, 53, 56, 59, 62, 65, 68, 71, 74};
                        useSP = new int[]{50, 52, 54, 56, 58, 60, 62, 64, 66, 68};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{17500, 17500, 17500, 17500, 17500, 17500, 17500, 17500, 17500, 17500};
                        duration = new int[]{300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[]{0};
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_DMG_RED};
                        //Effects Value
                        value = new float[][]
                        {
                            {2, 4, 6, 8, 10, 12, 15, 18, 21, 25} //Damage reduction
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                        //God Bless
                    case 2:
                        //Skill properties
                        reqItem = new String[]{WS_SWORD, WS_AXE, WS_CLAW, WS_HAMMER, WS_SCYTHE, WS_BOW, WS_JAVELIN};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1)
                            };
                        halfPartyCast = false;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        tierSkillCancelOnCast = new int[][]
                        {
                            {}
                        };
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{57, 60, 63, 66, 69, 72, 75, 78, 81, 84};
                        useSP = new int[]{51, 53, 55, 57, 59, 61, 63, 65, 67, 69};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{17500, 17500, 17500, 17500, 17500, 17500, 17500, 17500, 17500, 17500};
                        duration = new int[]{300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[]{0};
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_ADD_FLAT_ATK_POW};
                        //Effects Value
                        value = new float[][]
                        {
                            {30, 40, 50, 60, 70, 80, 90, 100, 110, 120} //Added flat min-max atk pow
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                        //Devine Piercing
                    case 3:
                        //Skill properties
                        reqItem = new String[]{WS_SWORD};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                SFX_WEAPON,
                                SFX_WEAPON,
                                SFX_WEAPON,
                                SFX_WEAPON,
                                SFX_WEAPON,
                                SFX_WEAPON,
                                getSkillSfx(7)
                            };
                        halfPartyCast = false;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{45, 47, 49, 51, 53, 55, 57, 59, 61, 63};
                        useSP = new int[]{51, 53, 55, 57, 59, 61, 63, 65, 67, 69};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{15000, 15000, 15000, 15000, 15000, 15000, 15000, 15000, 15000, 15000};
                        duration = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        //Active behavior and hits animation duration
                        hits = new int[]{3, 3, 3, 3, 5, 5, 5, 5, 7, 7};
                        hitsInterval = new int[]{200,200,200,200,200,200,200};
                        canCrit = new boolean[]{true, true, true, true, true, true, true};
                        //Skill effect type
                        attribute = new String[]{AS_DMG_BOOST};
                        //Effects Value
                        value = new float[][]
                        {
                            {32, 39, 46, 53, 60, 67, 74, 81, 88, 95}//Dmg boost          
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                }
            break;
                //Tier 5
            case 4:
                switch (skill) {
                    //Lightning Sword
                    case 0:
                        //Skill properties
                        reqItem = new String[]{WS_SWORD};
                        element = E_LIGHT;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1),
                                getSkillSfx(2),
                                getSkillSfx(3),
                                getSkillSfx(4),
                                getSkillSfx(5),
                            };
                        halfPartyCast = false;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{92, 95, 98, 101, 104, 107, 110, 113, 116, 119};
                        useSP = new int[]{100, 104, 108, 112, 116, 120, 124, 128, 132, 136};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{24000, 24000, 24000, 24000, 24000, 24000, 24000, 24000, 24000, 24000};
                        duration = new int[]{8000, 8000, 8000, 8000, 8000, 8000, 8000, 8000, 8000, 8000};
                        //Active behavior and hits animation duration
                        hits = new int[]{7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
                        hitsInterval = new int[]{200,200,200,200,200,200,200};
                        canCrit = new boolean[]{false, false, false, false, false, false, false};
                        pvpModifier = 0f;
                        //Skill effect type
                        attribute = new String[]{AS_STUN_DUR, AS_STUN_CHANCE, AS_AOE_RANGE, AS_DMG_BOOST, AS_CAST_RANGE, AS_ATK_INTERVAL};
                        //Effects Value
                        value = new float[][]
                        {
                            {300, 600, 900, 1200, 1500, 1800, 2100, 2400, 2700, 3000}, //Stun duration
                            {3.2f, 3.4f, 3.6f, 3.8f, 4.0f, 4.2f, 4.4f, 4.6f, 4.8f, 5.0f}, //Stun Chance
                            {62, 64, 66, 68, 70, 72, 74, 76, 78, 80}, //Strike area
                            {97, 104, 111, 118, 125, 132, 139, 146, 153, 160}, //Dmg boost
                            {80, 80, 80, 80, 80, 80, 80, 80, 80, 80}, //Area
                            {190, 180, 170, 160, 150, 140, 130, 120, 110, 100} //interval
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                        //Undead Bane
                    case 1:
                        //Skill properties
                        reqItem = new String[]{WS_ANY};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                            };
                        halfPartyCast = false;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useSP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        duration = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        //Active behavior and hits animation duration
                        hits = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        hitsInterval = new int[]{0};
                        canCrit = new boolean[]{false};
                        //Skill effect type
                        attribute = new String[]{AS_ADD_MON_UNDEAD_1V1_FINAL_DMG};
                        //Effects Value
                        value = new float[][]
                        {
                            {2, 4, 6, 8, 10, 12, 14, 16, 18, 20} //final 1v1 undead dmg boost
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                        //Holy Justice
                    case 2:
                        //Skill properties
                        released = false;
                        reqItem = new String[]{WS_SWORD};
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
                        useMP = new int[]{38, 41, 44, 47, 50, 53, 56, 59, 62, 65};
                        useSP = new int[]{50, 53, 56, 59, 62, 65, 68, 71, 74, 77};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{20000, 18000, 16000, 14000, 12000, 10000, 9000, 8000, 7000, 6000};
                        duration = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[]{800};
                        canCrit = new boolean[]{true};
                        //Skill effect type
                        attribute = new String[]{AS_DMG_BOOST};
                        //Effects Value
                        value = new float[][]
                        {
                            {5, 10, 15, 20, 25, 30, 35, 40, 45, 50}, //dmg boost      
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                        //Holy Aura
                    case 3:
                        //Skill properties
                        reqItem = new String[]{WS_ANY};
                        element = E_NORMAL;
                        elementImg = getElementImg();
                        soundSFX = new String[]{
                                getSkillSfx(1)
                            };
                        halfPartyCast = false;
                        skillChain = false;
                        tierSkillChained = new int[]{};
                        chainedSkillEffectIndex = 0;
                        tierSkillCancelOnCast = new int[][]{
                            {}
                        };
                        //HP MP SP Resource Requirement
                        useHP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        useMP = new int[]{120, 140, 160, 180, 200, 220, 240, 260, 280, 300};
                        useSP = new int[]{160, 170, 180, 190, 200, 210, 220, 230, 240, 250};
                        //Skill cooldown and effect duration
                        cooldown = new int[]{30000, 30000, 30000, 30000, 30000, 30000, 30000, 30000, 30000, 30000};
                        duration = new int[]{480000, 480000, 480000, 480000, 480000, 480000, 480000, 480000, 480000, 480000};
                        //Active behavior and hits animation duration
                        hits = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                        hitsInterval = new int[]{0};
                        canCrit = new boolean[]{false};
                        pvpModifier = 1f;
                        //Skill effect type
                        attribute = new String[]{AS_NUMBER_ENEMY_SEC, AS_UNDEAD_MAX_HP_DRAIN, AS_AURA_AOE_RANGE, AS_ADD_HP_REGEN, AS_BONUS_CHARGE_HIT, AS_CHARGE_DMG};
                        //Effects Value
                        value = new float[][]
                        {
                            {0, 1, 1, 1, 1, 1, 1, 1, 2, 3}, //# enemies sec
                            {0, 8, 11, 14, 17, 20, 23, 26, 29, 32}, //undead hp drain
                            {110, 120, 130, 140, 150, 160, 170, 180, 190, 200}, //aura range
                            {0.5f, 1f, 1.5f, 2f, 2.5f, 3f, 3.5f, 4f, 4,5f, 5f}, //add hp regen
                            {40, 40, 40, 38, 35, 31, 28, 25, 22, 20}, //bonus charge hit ocunt
                            {50, 50, 50, 50, 50, 50, 50, 50, 50, 50} //charged hit 1v1 final damage boost
                        };
                        //Monster Extra Damage
                        monsterBonus = new String[]{};
                        monsterValue = 0;
                    break;
                }
            break;
        }
        

    }

}
