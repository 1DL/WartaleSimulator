/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.bracelet;

import item.ItemStats;

/**
 *
 * @author Administrator
 */
public class Bracelet140 extends ItemStats {

    public Bracelet140() {
        //Identificaçao item
        super.itemClass = "Defense";
        super.itemType = "Bracelet";
        super.itemName = "Mercurial Bracelets";
        super.itemImgDir = "/assets/item/bracelet/140.png";
        super.itemIconDir = "";
        //Requerimentos
        super.rLvl = 140;
        super.rStr = 0;
        super.rAgi = 130;
        //Status Base
        super.integrity = 230;
        super.atkRtg = 320;
        super.defense = 328;
        super.potCount = 170;
               
        //Status Spec
        super.primarySpec = "Knight";
        super.selectedSpec = super.primarySpec;
        super.secondarySpec[0] = "Mechanician";
        super.secondarySpec[1] = "Fighter";
        super.secondarySpec[2] = "Pikeman";
        super.secondarySpec[3] = "Atalanta";
        super.secondarySpec[4] = "Archer";
        super.secondarySpec[5] = "Assassin";
        super.secondarySpec[6] = "Magician";
        super.secondarySpec[7] = "Priestess";
        super.secondarySpec[8] = "Shaman";
        super.sDivAtkRtg = 1;
        //Misc
        super.weight = 67;
        super.price = 1540000;
        
        createItemDesc();
    }
}
