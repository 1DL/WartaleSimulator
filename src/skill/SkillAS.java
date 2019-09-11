/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skill;

import formula.CharacterStats;

/**
 *
 * @author Luiz
 */
public class SkillAS extends Skill {

    public SkillAS(CharacterStats c, int tier, int skill) {
        super.c = c;

        switch (tier) {
            case 0:
                switch (skill) {
                    case 0:
                        super.tier = 0;
                        super.skill = 0;
                        super.reqLvl = 10;
                        super.name = "Sword Blast";
                        super.type = "AoE";
                        super.desc = "Blasts a Holy Water channeled through your Soul and Sword.";
                        super.descOriginal = "Throws a devastating sword to<br>targeted enemy.";
                        super.charClass = "Knight";
                        super.skillImg = "/assets/images/skills/"+charClass+"/Button/"+(tier+1)+(skill+1)+".bmp";
                        super.timerImg = "";
                        super.reqItem = new String[]{"Sword"};
                        
                        super.useMethod = Skill.ACTIVEBOTH;

                        super.useHP = new int[]{0,0,0,0,0,0,0,0,0,0};
                        super.useMP = new int[]{8, 10, 12, 15, 18, 21, 25, 29, 33, 38};
                        super.useSP = new int[]{22, 24, 26, 28, 30, 32, 34, 36, 38, 40};

                        super.cooldown = new int[]{500, 500, 500, 500, 500, 500, 500, 500, 500, 500};
                        super.duration = new int[]{};
                        super.skillCost = new int[]{500, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500, 5000};

                        super.attribute = new String[]{"Damage Boost", "Pushback Range"};
                        super.value = new int[][]{
                            {87, 94, 101, 108, 115, 122, 129, 136, 143, 150},
                            {70, 75, 80, 85, 90, 95, 100, 105, 110, 120}
                        };

                        super.monsterBonus = new String[]{"Normal", "Mutant"};
                        super.monsterValue = 50;
                    break;
                    
                    case 1:
                        super.tier = 0;
                        super.skill = 1;                        
                        super.reqLvl = 10;
                        super.name = "Holy Body";
                        super.type = "Buff";
                        super.desc = "Become holy for a period of time to increase<br> absorb rating against undead enemies.";
                        super.descOriginal = "Become holy for a period of time to increase<br> absorb rating against undead enemies.";
                        super.charClass = "Knight";
                        super.skillImg = "/assets/images/skills/"+charClass+"/Button/"+(tier+1)+(skill+1)+".bmp";
                        super.timerImg = "";
                        super.reqItem = new String[]{"Any"};

                        super.useMethod = Skill.ACTIVEBOTH;

                        super.useHP = new int[]{0,0,0,0,0,0,0,0,0,0};
                        super.useMP = new int[]{18, 21, 24, 27, 30, 34, 38, 42, 46, 50};
                        super.useSP = new int[]{28, 30, 32, 34, 36, 38, 40, 42, 44, 46};

                        super.cooldown = new int[]{3500, 4000, 5000, 5500, 6500, 7000, 8000, 8500, 9500, 10000};
                        super.duration = new int[]{300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000, 300000};
                        super.skillCost = new int[]{1000, 1600, 2200, 2800, 3400, 4000, 4600, 5200, 5800, 6400};

                        super.attribute = new String[]{"Undead Absorb"};
                        super.value = new int[][]{
                            {8, 12, 16, 19, 22, 25, 27, 29, 31, 33}
                        };

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
