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
public class SkillCost {
    public final int SKILL_COST[][][] = {
        {//Tier 1
            {500, 1000,1500,2000,2500,3000,3500,4000,4500,5000},
            {1000,1600,2200,2800,3400,4000,4600,5200,5800,6400},
            {1500,2200,2900,3600,4300,5000,5700,6400,7100,7800},
            {2000,2800,3600,4400,5200,6000,6800,7600,8400,9200},
        },
        {//Tier 2
            {3000,      4000,5000,6000,7000,8000,9000,10000,11000,12000},
            {5000,    6200,7400,8600,9800,11000,12200,13400,14600,15800},
            {7000,  8400,9800,11200,12600,14000,15400,16800,18200,19600},
            {9000,10600,12200,13800,15400,17000,18600,20200,21800,23400},
        },
        {//Tier 3
            {10000,12000,14000,16000,18000,20000,22000,24000,26000,28000},
            {12000,14500,17000,19500,22000,24500,27000,29500,32000,34500},
            {15000,18000,21000,24000,27000,30000,33000,36000,39000,42000},
            {20000,24000,28000,32000,36000,40000,44000,48000,52000,56000},
        },
        {//Tier 4
            {25000,   30000,35000,40000,45000,50000,55000,60000,65000,70000},
            {30000,   36000,42000,48000,54000,60000,66000,72000,78000,84000},
            {35000,   42000,49000,56000,63000,70000,77000,84000,91000,98000},
            {40000,48000,56000,74000,82000,90000,98000,106000,114000,122000},
        },
        {//Tier 5
            {45000,   54000,63000,72000,81000,90000,99000,108000,117000,126000},
            {50000, 60000,70000,80000,90000,100000,110000,120000,130000,140000},
            {55000, 66000,77000,88000,99000,110000,121000,132000,143000,154000},
            {60000,72000,84000,96000,108000,120000,132000,144000,156000,168000},
        },
    };
}