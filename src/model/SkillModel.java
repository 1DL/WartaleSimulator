/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.game.skill.Skill;
/**
 *
 * @author Luiz
 */
public class SkillModel {
    private int id;
    private String name;
    private int level;
    Skill skill;

    public SkillModel(int jobId, Skill skill, int skillLevel) {
        this.id = Integer.parseInt("" + jobId + "" + skill.getTier() + "" + skill.getSkill());
        this.name = skill.getName();
        this.level = skillLevel;
    }
    
    
}
