/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.game.formula.CharacterStats;
import controller.game.item.Item;

/**
 *
 * @author Luiz
 */
public class Gear {
    
    static final int ACTIVE = 1;
    static final int INACTIVE = 2;
    static final int MATURING = 3;
    static final int VISUAL = 4;
    
    private int category_id;
    private int type_id;
    private int wield_id;
    private int status_id;
    private GearSlot gearSlot;
    protected Item item;

    public Gear(CharacterStats c, int slotId) {
        switch (slotId) {
            case GearSlot.ARMOR_ID:
                initialize(slotId, c.getItemArmor());
            break;
            case GearSlot.SET1_H_LEFT_ID:
                initialize(slotId, c.getItemWeaponOneHand());
            break;
            case GearSlot.SET1_H_RIGHT_ID:
                initialize(slotId, c.getItemShield());
            break;
            case GearSlot.SET2_H_LEFT_ID:
                initialize(slotId, c.getItemWeaponTwoHand());
            break;
            case GearSlot.SET2_H_RIGHT_ID:
                initialize(slotId, c.getItemWeaponTwoHand());
            break;
            case GearSlot.BRACELET_ID:
                initialize(slotId, c.getItemBracelet());
            break;
            case GearSlot.GAUNTLET_ID:
                initialize(slotId, c.getItemGauntlet());
            break;
            case GearSlot.BOOTS_ID:
                initialize(slotId, c.getItemBoots());
            break;
            case GearSlot.AMULET_ID:
                initialize(slotId, c.getItemAmulet());
            break;
            case GearSlot.RING1_ID:
                initialize(slotId, c.getItemRing1());
            break;
            case GearSlot.RING2_ID:
                initialize(slotId, c.getItemRing2());
            break;
            case GearSlot.SHELTOM_ID:
                initialize(slotId, c.getItemSheltom());
            break;
            case GearSlot.EARRING1_ID:
                initialize(slotId, c.getItemEarRing1());
            break;
            case GearSlot.EARRING2_ID:
                initialize(slotId, c.getItemEarRing2());
            break;
            case GearSlot.BELT_ID:
                initialize(slotId, c.getItemBelt());
            break;
        }
    }
    
    private void initialize(int slotId, Item item) {
        this.gearSlot = new GearSlot(slotId);
        this.item = item;
        this.status_id = ACTIVE;
    }
    
    
}
