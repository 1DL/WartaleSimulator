/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JLabel;
import item.Item;

/**
 *
 * @author Luiz
 */
public class ItemController {
    public void checkItemRequirement(JLabel lbl, Item item) {
        item.checkStatusReq();
        if (item.isRequirementsMatch()) {
            lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/enabledH.png")));
        } else {
            lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/charbuild/disabledH.png")));
        }
    }
}
