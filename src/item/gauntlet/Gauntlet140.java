/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.gauntlet;

import item.ItemStats;

/**
 *
 * @author Administrator
 */
public class Gauntlet140 extends ItemStats {

    public Gauntlet140() {
        //Identificaçao item
        super.itemClass = "Defense";
        super.itemType = "Gauntlet";
        super.itemName = "Mercurial Gauntlets";
        super.itemImgDir = "/assets/item/gauntlet/140.png";
        super.itemIconDir = "";
        //Requerimentos
        super.rLvl = 140;
        super.rStr = 110;
        super.rSpi = 40;
        super.rTal = 90;
        super.rAgi = 82;
        //Status Base
        super.integrity = 255;
        super.defense = 352;
        super.abs = 22.2f;
        super.organicResist = 11;
        super.fireResist = 11;
        super.iceResist = 11;
        super.lightningResist = 11;
        super.poisonResist = 11;
        
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
        super.sAbs = 2f;
        super.sDefense = 111;
        //Misc
        super.weight = 92;
        super.price = 1520000;
        
        createItemDesc();
    }
}
