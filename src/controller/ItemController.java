/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import formula.CharacterStats;
import javax.swing.JLabel;
import item.Item;

/**
 *
 * @author Luiz
 */
public class ItemController {
    public void checkItemRequirement(CharacterStats c, JLabel lbl, Item item) {
        item.setOwnerCharacter(c);
        item.checkStatusReq();
        if (item.isRequirementsMatch()) {
            lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/enabledH.png")));
        } else {
            lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/disabledH.png")));
        }
    }
}
