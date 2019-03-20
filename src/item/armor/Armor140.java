/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.armor;

import item.ItemStats;

/**
 *
 * @author Administrator
 */
public class Armor140 extends ItemStats {

    public Armor140() {
        //Identificaçao item
        super.itemClass = "Defense";
        super.itemType = "Armor";
        super.itemName = "Quantum Armor";
        super.itemImgDir = "/assets/item/armor/140.png";
        super.itemIconDir = "";
        //Requerimentos
        super.rLvl = 140;
        super.rStr = 308;
        super.rTal = 90;
        //Status Base
        super.integrity = 310;
        super.defense = 1020;
        super.abs = 51f;
        super.organicResist = 18;
        super.fireResist = 18;
        super.iceResist = 18;
        super.lightningResist = 18;
        super.poisonResist = 18;
        
        //Status Spec
        super.primarySpec = "Knight";
        super.selectedSpec = super.primarySpec;
        super.secondarySpec[0] = "Mechanician";
        super.secondarySpec[1] = "Fighter";
        super.secondarySpec[2] = "Pikeman";
        super.secondarySpec[3] = "Atalanta";
        super.secondarySpec[4] = "Archer";
        super.secondarySpec[5] = "Assassin";
        super.sAbs = 3.6f;
        super.sDefense = 152;
        //Misc
        super.weight = 200;
        super.price = 3080000;
        
        createItemDesc();
    }
}
