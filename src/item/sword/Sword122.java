/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.sword;

import item.ItemStats;
import javax.swing.JComboBox;

/**
 *
 * @author Administrator
 */
public class Sword122 extends ItemStats {

    public Sword122() {
        //Identificaçao item
        super.itemClass = "Melee";
        super.itemType = "Sword";
        super.itemName = "Relic Sword";
        super.itemImgDir = "/assets/item/weapon/sword/122.png";
        super.itemIconDir = "";
        super.oneOrTwoHanded = false;
        //Requerimentos
        super.rLvl = 122;
        super.rStr = 258;
        super.rSpi = 40;
        super.rTal = 90;
        //Status Base
        super.integrity = 197;
        super.atkMin = 75;
        super.atkMax = 94;
        super.atkSpd = 8;
        super.atkRtg = 285;
        super.critChance = 16;
        //Status Spec
        super.primarySpec = "Knight";
        super.selectedSpec = super.primarySpec;
        super.secondarySpec[0] = "Mechanician";
        super.secondarySpec[1] = "Fighter";
        super.secondarySpec[2] = "Pikeman";
        super.secondarySpec[3] = "Atalanta";
        super.sCritChance = 6;
        super.sDivAtkPow = 6;
        super.sDivAtkRtg = 1;
        //Misc
        super.weight = 72;
        super.price = 2100000;
        
        createItemDesc();
    }
}
