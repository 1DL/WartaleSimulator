/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.gauntlet;

import item.boots.*;
import item.shield.*;
import item.sword.*;
import item.ItemStats;
import javax.swing.JComboBox;

/**
 *
 * @author Administrator
 */
public class Gauntlet136 extends ItemStats {

    public Gauntlet136() {
        //Identificaçao item
        super.itemClass = "Defense";
        super.itemType = "Gauntlet";
        super.itemName = "Greedy Gauntlets";
        super.itemImgDir = "/assets/item/gauntlet/136.png";
        super.itemIconDir = "";
        //Requerimentos
        super.rLvl = 136;
        super.rStr = 100;
        super.rSpi = 40;
        super.rTal = 90;
        super.rAgi = 77;
        //Status Base
        super.integrity = 250;
        super.defense = 336;
        super.abs = 20.1f;
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
        super.sDivAtkPow = 10;
        super.sAbs = 1.8f;
        super.sDefense = 106;
        //Misc
        super.weight = 82;
        super.price = 1430000;
        
        createItemDesc();
    }
}
