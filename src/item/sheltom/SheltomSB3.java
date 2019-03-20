/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.sheltom;

import item.ItemStats;

/**
 *
 * @author Administrator
 */
public class SheltomSB3 extends ItemStats {

    public SheltomSB3() {
        //Identificaçao item
        super.itemClass = "Acessory";
        super.itemType = "Sheltom";
        super.itemName = "Throne Sheltom";
        super.itemImgDir = "/assets/item/sheltom/sb3.png";
        super.itemIconDir = "";
        //Requerimentos
        super.rLvl = 120;
        super.rSpi = 100;
        //Status Base
        super.mpReg = 3.7f;
        super.hpReg = 3.1f;
        super.mp = 35;
        super.hp = 35;
               
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
        
        super.sDivMp = 8;
        super.sDivHp = 8;
        super.sMpReg = 1.9f;
        super.sHpReg = 1.3f;
        //Misc
        super.weight = 5;
        super.price = 400000;
        
        createItemDesc();
    }
}
