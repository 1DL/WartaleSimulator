/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.ring;

import item.sheltom.*;
import item.bracelet.*;
import item.gauntlet.*;
import item.boots.*;
import item.shield.*;
import item.sword.*;
import item.ItemStats;
import javax.swing.JComboBox;

/**
 *
 * @author Administrator
 */
public class RingSB3 extends ItemStats {

    public RingSB3() {
        //Identificaçao item
        super.itemClass = "Acessory";
        super.itemType = "Ring";
        super.itemName = "Throne Ring";
        super.itemImgDir = "/assets/item/ring/sb3.png";
        super.itemIconDir = "";
        //Requerimentos
        super.rLvl = 120;
        super.rSpi = 100;
        //Status Base
        super.atkRtg = 74;
        super.abs = 4f;
        super.defense = 52;
        super.mpReg = 3.5f;
        super.hpReg = 3.4f;
        super.mp = 58;
        super.hp = 58;
        super.stm = 50;
               
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
        
        super.sHpReg = 1.8f;
        //Misc
        super.weight = 5;
        super.price = 400000;
        
        createItemDesc();
    }
}
