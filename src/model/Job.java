/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Luiz
 */
public class Job {
    private int id;
    private String name;
    private String[] jobTitle;
    private String currentJobTitle;
    private int currentJobTitleId;
    private String spec;
    
    private int baseStr;
    private int baseSpi;
    private int baseTal;
    private int baseAgi;
    private int baseVit;
    
    private int meleeWepModifier;
    private int rangedWepModifier;
    private int noWeaponStrModifier;
    private int noWeaponAgiTalModifierMin;
    private int noWeaponAgiTalModifierMax;
    private int meleeWeaponTalAgiModifier;
    private int rangedWeaponTalStrModifier;
    
    private String classWeaponMatch; 
    
}
