/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.game.item.Item;

/**
 *
 * @author Luiz
 */
public class GearSlot {
    //main
    static final int ARMOR_ID = 1;
    static final int SET1_H_LEFT_ID = 2;
    static final int SET1_H_RIGHT_ID = 3;
    static final int SET2_H_LEFT_ID = 4;
    static final int SET2_H_RIGHT_ID = 5;
    //defense
    static final int BRACELET_ID = 6;
    static final int GAUNTLET_ID = 7;
    static final int BOOTS_ID = 8;
    //Acessory
    static final int AMULET_ID = 9;
    static final int RING1_ID = 10;
    static final int RING2_ID = 11;
    static final int SHELTOM_ID = 12;
    static final int EARRING1_ID = 13;
    static final int EARRING2_ID = 14;
    static final int BELT_ID = 15;
    
    //Visual
    
    static final int V_ARMOR_ID = 16;
    static final int V_SET1_H_LEFT = 17;
    static final int V_SET1_H_RIGHT = 18;
    static final int V_SET2_H_LEFT = 19;
    static final int V_SET2_H_RIGHT = 20;
    
    
    
    private int id;
    private String name;
    private String slotType;
    private boolean active;

    public GearSlot(int slotId) {
        switch (slotId) {
            case GearSlot.ARMOR_ID:
                this.id = slotId;
                this.name = "Armor";
                this.slotType = "Main";
            break;
            case GearSlot.SET1_H_LEFT_ID:
                this.id = slotId;
                this.name = "Left Hand";
                this.slotType = "Main";
            break;
            case GearSlot.SET1_H_RIGHT_ID:
                this.id = slotId;
                this.name = "Right Hand";
                this.slotType = "Main";
            break;
            case GearSlot.SET2_H_LEFT_ID:
                this.id = slotId;
                this.name = "Left Hand";
                this.slotType = "Main";
            break;
            case GearSlot.SET2_H_RIGHT_ID:
                this.id = slotId;
                this.name = "Right Hand";
                this.slotType = "Main";
            break;
            case GearSlot.BRACELET_ID:
                this.id = slotId;
                this.name = "Bracelet";
                this.slotType = "Defense";
            break;
            case GearSlot.GAUNTLET_ID:
                this.id = slotId;
                this.name = "Gauntlets";
                this.slotType = "Defense";
            break;
            case GearSlot.BOOTS_ID:
                this.id = slotId;
                this.name = "Boots";
                this.slotType = "Defense";
            break;
            case GearSlot.AMULET_ID:
                this.id = slotId;
                this.name = "Amulet";
                this.slotType = "Acessory";
            break;
            case GearSlot.RING1_ID:
                this.id = slotId;
                this.name = "Left Ring";
                this.slotType = "Acessory";
            break;
            case GearSlot.RING2_ID:
                this.id = slotId;
                this.name = "Right Ring";
                this.slotType = "Acessory";
            break;
            case GearSlot.SHELTOM_ID:
                this.id = slotId;
                this.name = "Sheltom";
                this.slotType = "Acessory";
            break;
            case GearSlot.EARRING1_ID:
                this.id = slotId;
                this.name = "Left Earring";
                this.slotType = "Acessory";
            break;
            case GearSlot.EARRING2_ID:
                this.id = slotId;
                this.name = "Right Earring";
                this.slotType = "Acessory";
            break;
            case GearSlot.BELT_ID:
                this.id = slotId;
                this.name = "Belt";
                this.slotType = "Acessory";
            break;
            case GearSlot.V_ARMOR_ID:
                this.id = slotId;
                this.name = "Cosmetic Armor";
                this.slotType = "Visual";
            break;
            case GearSlot.V_SET1_H_LEFT:
                this.id = slotId;
                this.name = "Cosmetic Left Hand";
                this.slotType = "Visual";
            break;
            case GearSlot.V_SET1_H_RIGHT:
                this.id = slotId;
                this.name = "Cosmetic Right Hand";
                this.slotType = "Visual";
            break;
            case GearSlot.V_SET2_H_LEFT:
                this.id = slotId;
                this.name = "Cosmetic Left Hand";
                this.slotType = "Visual";
            break;
            case GearSlot.V_SET2_H_RIGHT:
                this.id = slotId;
                this.name = "Cosmetic Left Hand";
                this.slotType = "Visual";
            break;
        }
    }
    
    
}
