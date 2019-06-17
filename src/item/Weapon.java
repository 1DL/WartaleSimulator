/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

/**
 *
 * @author Luiz
 */
public class Weapon extends ItemStats {
    public Weapon(String name) {
        super.itemAged = true;
        switch (name) {
            
            //Swords
            
            case "142-Valiant Sword":
            //Identificaçao item
            super.itemClass = "Melee";
            super.itemType = "Sword";
            super.itemName = "Valiant Sword";
            super.itemImgDir = "/assets/item/weapon/sword/142.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 142;
            super.rStr = 350;
            super.rSpi = 40;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 240;
            super.MAXintegrity = 250;
            super.MINatkMin = 100;
            super.MAXatkMin = 104;
            super.MINatkMax = 114;
            super.MAXatkMax = 118;
            super.atkSpd = 8;
            super.MINatkRtg = 350;
            super.MAXatkRtg = 383;
            super.critChance = 17;
            super.MINblock = 0;
            super.MAXblock = 0;
            //Status Spec
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Mechanician";
            super.classSpec[2] = "Fighter";
            super.classSpec[3] = "Pikeman";
            super.classSpec[4] = "Atalanta";
            super.classSpec[5] = "No Spec";
            super.sCritChance = 6;
            super.sDivAtkPow = 6;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;
            //Misc
            super.weight = 106;
            super.price = 3220000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            case "138-Hellbringer Sword":
            //Identificaçao item
            super.itemClass = "Melee";
            super.itemType = "Sword";
            super.itemName = "Hellbringer Sword";
            super.itemImgDir = "/assets/item/weapon/sword/138.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = TWOHANDED;
            //Requerimentos
            super.rLvl = 138;
            super.rStr = 330;
            super.rSpi = 40;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 230;
            super.MAXintegrity = 240;
            super.MINatkMin = 129;
            super.MAXatkMin = 132;
            super.MINatkMax = 137;
            super.MAXatkMax = 143;
            super.atkSpd = 8;
            super.MINatkRtg = 328;
            super.MAXatkRtg = 360;
            super.critChance = 23;
            super.MINblock = 15;
            super.MAXblock = 15;
            //Status Spec
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Mechanician";
            super.classSpec[2] = "Fighter";
            super.classSpec[3] = "Pikeman";
            super.classSpec[4] = "Atalanta";
            super.classSpec[5] = "No Spec";
            super.sCritChance = 7;
            super.sDivAtkPow = 6;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;
            //Misc
            super.weight = 98;
            super.price = 2790000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            case "134-Deadly Sword":
            //Identificaçao item
            super.itemClass = "Melee";
            super.itemType = "Sword";
            super.itemName = "Deadly Sword";
            super.itemImgDir = "/assets/item/weapon/sword/134.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = TWOHANDED;
            //Requerimentos
            super.rLvl = 134;
            super.rStr = 310;
            super.rSpi = 40;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 220;
            super.MAXintegrity = 230;
            super.MINatkMin = 120;
            super.MAXatkMin = 123;
            super.MINatkMax = 128;
            super.MAXatkMax = 134;
            super.atkSpd = 8;
            super.MINatkRtg = 300;
            super.MAXatkRtg = 330;
            super.critChance = 23;
            super.MINblock = 15;
            super.MAXblock = 15;
            //Status Spec
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Mechanician";
            super.classSpec[2] = "Fighter";
            super.classSpec[3] = "Pikeman";
            super.classSpec[4] = "Atalanta";
            super.classSpec[5] = "No Spec";
            super.sCritChance = 7;
            super.sDivAtkPow = 6;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;
            //Misc
            super.weight = 90;
            super.price = 2400000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            case "130-Mythology Sword":
            //Identificaçao item
            super.itemClass = "Melee";
            super.itemType = "Sword";
            super.itemName = "Mythology Sword";
            super.itemImgDir = "/assets/item/weapon/sword/130.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = TWOHANDED;
            //Requerimentos
            super.rLvl = 130;
            super.rStr = 290;
            super.rSpi = 40;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 210;
            super.MAXintegrity = 220;
            super.MINatkMin = 111;
            super.MAXatkMin = 114;
            super.MINatkMax = 119;
            super.MAXatkMax = 125;
            super.atkSpd = 8;
            super.MINatkRtg = 280;
            super.MAXatkRtg = 310;
            super.critChance = 22;
            super.MINblock = 15;
            super.MAXblock = 15;
            //Status Spec
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Mechanician";
            super.classSpec[2] = "Fighter";
            super.classSpec[3] = "Pikeman";
            super.classSpec[4] = "Atalanta";
            super.classSpec[5] = "No Spec";
            super.sCritChance = 7;
            super.sDivAtkPow = 6;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;
            //Misc
            super.weight = 90;
            super.price = 2400000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            case "126-Tirbing Sword":
            //Identificaçao item
            super.itemClass = "Melee";
            super.itemType = "Sword";
            super.itemName = "Tirbing Sword";
            super.itemImgDir = "/assets/item/weapon/sword/126.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = TWOHANDED;
            //Requerimentos
            super.rLvl = 126;
            super.rStr = 270;
            super.rSpi = 40;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 200;
            super.MAXintegrity = 210;
            super.MINatkMin = 102;
            super.MAXatkMin = 105;
            super.MINatkMax = 114;
            super.MAXatkMax = 120;
            super.atkSpd = 8;
            super.MINatkRtg = 260;
            super.MAXatkRtg = 290;
            super.critChance = 22;
            super.MINblock = 15;
            super.MAXblock = 15;
            //Status Spec
            super.sCritChance = 7;
            super.sDivAtkPow = 6;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Mechanician";
            super.classSpec[2] = "Fighter";
            super.classSpec[3] = "Pikeman";
            super.classSpec[4] = "Atalanta";
            super.classSpec[5] = "No Spec";
            //Misc
            super.weight = 90;
            super.price = 2400000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            case "122-Relic Sword":
            //Identificaçao item
            super.itemClass = "Melee";
            super.itemType = "Sword";
            super.itemName = "Relic Sword";
            super.itemImgDir = "/assets/item/weapon/sword/122.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 122;
            super.rStr = 258;
            super.rSpi = 40;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 189;
            super.MAXintegrity = 197;
            super.MINatkMin = 72;
            super.MAXatkMin = 75;
            super.MINatkMax = 92;
            super.MAXatkMax = 94;
            super.atkSpd = 8;
            super.MINatkRtg = 255;
            super.MAXatkRtg = 285;
            super.critChance = 16;
            super.MINblock = 0;
            super.MAXblock = 0;
            //Status Spec
            super.sCritChance = 6;
            super.sDivAtkPow = 6;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Mechanician";
            super.classSpec[2] = "Fighter";
            super.classSpec[3] = "Pikeman";
            super.classSpec[4] = "Atalanta";
            super.classSpec[5] = "No Spec";
            //Misc
            super.weight = 90;
            super.price = 2400000;
            super.itemLore = "";

            createItemDesc();
            break;
        }
        
    }
}
