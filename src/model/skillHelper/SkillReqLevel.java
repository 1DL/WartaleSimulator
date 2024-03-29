/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.skillHelper;

/**
 *
 * @author Luiz
 */
public class SkillReqLevel {
    /*
    indexes:
    [tier][skill][skill level]
    
    ATENÇÃO! ìndice 0 e 1 são iguais para que a visualização de skill level 0
    exiba corretamente o tooltip "Next Level" da skill.
    */
    public final int SKILL_REQLVL[][][] = {
        {//Tier 1
            {10,12,14,16,18,20,22,24,26,28},
            {12,14,16,18,20,22,24,26,28,30},
            {14,16,18,20,22,24,26,28,30,32},
            {17,19,21,23,25,27,29,31,33,35},
        },
        {//Tier 2
            {20,22,24,26,28,30,32,34,36,38},
            {23,25,27,29,31,33,35,37,39,41},
            {26,28,30,32,34,36,38,40,42,44},
            {30,32,34,36,38,40,42,44,46,48},
        },
        {//Tier 3
            {40,42,44,46,48,50,52,54,56,58},
            {43,45,47,49,51,53,55,57,59,61},
            {46,48,50,52,54,56,58,60,62,64},
            {50,52,54,56,58,60,62,64,66,68},
        },
        {//Tier 4
            {60,62,64,66,68,70,72,74,76,78},
            {63,65,67,69,71,73,75,77,79,81},
            {66,68,70,72,74,76,78,80,82,84},
            {70,72,74,76,78,80,82,84,86,88},
        },
        {//Tier 5
            {80,82,84,86,88,90,92,94,96,98},
            {83,85,87,89,91,93,95,97,99,101},
            {86,88,90,92,94,96,98,100,102,104},
            {90,92,94,96,98,100,102,104,106,108},
        },
    };
}
