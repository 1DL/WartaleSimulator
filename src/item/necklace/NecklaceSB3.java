/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.necklace;

import item.ItemStats;

/**
 *
 * @author Administrator
 */
public class NecklaceSB3 extends ItemStats {

    public NecklaceSB3() {
        //Identificaçao item
        super.itemClass = "Acessory";
        super.itemType = "Necklace";
        super.itemName = "Throne Amulet";
        super.itemImgDir = "/assets/item/necklace/sb3.png";
        super.itemIconDir = "";
        //Requerimentos
        super.rLvl = 120;
        super.rSpi = 100;
        //Status Base
        
        super.mpReg = 5.2f;
        super.hpReg = 5.2f;
        super.stmReg = 5.2f;
        super.mp = 70;
        super.hp = 70;
        super.stm = 70;
               
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
        
        super.sMpReg = 2.5f;
        super.sHpReg = 1.8f;
        //Misc
        super.weight = 5;
        super.price = 400000;
        
        createItemDesc();
    }
}
