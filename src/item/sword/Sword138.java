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
public class Sword138 extends ItemStats {

    public Sword138() {
        //Identificaçao item
        super.itemClass = "Melee";
        super.itemType = "Sword";
        super.itemName = "Hellbringer Sword";
        super.itemImgDir = "/assets/item/weapon/sword/140.png";
        super.itemIconDir = "";
        super.oneOrTwoHanded = true;
        //Requerimentos
        super.rLvl = 138;
        super.rStr = 330;
        super.rSpi = 40;
        super.rTal = 90;
        //Status Base
        super.integrity = 240;
        super.atkMin = 132;
        super.atkMax = 143;
        super.atkSpd = 8;
        super.atkRtg = 360;
        super.critChance = 23;
        super.block = 15;
        //Status Spec
        super.primarySpec = "Knight";
        super.selectedSpec = super.primarySpec;
        super.secondarySpec[0] = "Mechanician";
        super.secondarySpec[1] = "Fighter";
        super.secondarySpec[2] = "Pikeman";
        super.secondarySpec[3] = "Atalanta";
        super.sCritChance = 7;
        super.sDivAtkPow = 6;
        super.sDivAtkRtg = 1;
        //Misc
        super.weight = 98;
        super.price = 2790000;
        
        createItemDesc();
    }
}
