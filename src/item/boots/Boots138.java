/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.boots;

import item.shield.*;
import item.sword.*;
import item.ItemStats;
import javax.swing.JComboBox;

/**
 *
 * @author Administrator
 */
public class Boots138 extends ItemStats {

    public Boots138() {
        //Identificaçao item
        super.itemClass = "Defense";
        super.itemType = "Boots";
        super.itemName = "Draxos Boots";
        super.itemImgDir = "/assets/item/boots/138.png";
        super.itemIconDir = "";
        //Requerimentos
        super.rLvl = 138;
        super.rStr = 90;
        super.rSpi = 40;
        super.rTal = 90;
        //Status Base
        super.integrity = 240;
        super.evasion = 15;
        super.defense = 335;
        super.abs = 26f;
        super.moveSpeed = 5.9f;
        super.organicResist = 10;
        super.fireResist = 10;
        super.iceResist = 10;
        super.lightningResist = 10;
        super.poisonResist = 10;
        
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
        super.sAbs = 1.7f;
        super.sMoveSpeed = 2.3f;
        //Misc
        super.weight = 86;
        super.price = 1500000;
        
        createItemDesc();
    }
}
