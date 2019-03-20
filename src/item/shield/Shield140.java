/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.shield;

import item.ItemStats;

/**
 *
 * @author Administrator
 */
public class Shield140 extends ItemStats {

    public Shield140() {
        //Identificaçao item
        super.itemClass = "Defense";
        super.itemType = "Shield";
        super.itemName = "Imperial Shield";
        super.itemImgDir = "/assets/item/shield/140.png";
        super.itemIconDir = "";
        //Requerimentos
        super.rLvl = 140;
        super.rStr = 180;
        super.rTal = 75;
        //Status Base
        super.integrity = 330;
        super.block = 23;
        super.defense = 500;
        super.abs = 27.2f;
        super.organicResist = 12;
        super.fireResist = 12;
        super.iceResist = 12;
        super.lightningResist = 12;
        super.poisonResist = 12;
        
        //Status Spec
        super.primarySpec = "Knight";
        super.selectedSpec = super.primarySpec;
        super.secondarySpec[0] = "Mechanician";
        super.secondarySpec[1] = "Fighter";
        super.secondarySpec[2] = "Pikeman";
        super.secondarySpec[3] = "Atalanta";
        super.secondarySpec[4] = "Archer";
        super.sAbs = 2.7f;
        super.sDefense = 83;
        super.sBlock = 6;
        //Misc
        super.weight = 159;
        super.price = 3540000;
        
        createItemDesc();
    }
}
