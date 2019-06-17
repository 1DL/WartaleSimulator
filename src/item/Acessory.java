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
public class Acessory extends ItemStats {
    Acessory (String name) {
        switch (name) {
            //Amulet
            
            case "80-Kelvezu Amulet":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Kelvezu Amulet";
            super.itemImgDir = "/assets/item/necklace/sb1.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 80;
            super.rSpi = 80;
            //Status Base            
            super.MINmpReg = 2.5f;
            super.MAXmpReg = 3.9f;
            super.MINhpReg = 3.2f;
            super.MAXhpReg = 3.9f;
            super.MINstmReg = 2.3f;
            super.MAXstmReg = 3.9f;
            super.MINmp = 55;
            super.MAXmp = 55;
            super.MINhp = 55;
            super.MAXhp = 55;
            super.MINstm = 55;
            super.MAXstm = 55;
            //Status Spec
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Atalanta";
            super.classSpec[2] = "Magician";
            super.classSpec[3] = "Priestess";
            super.classSpec[4] = "Shaman";
            super.classSpec[5] = "Archer";
            super.classSpec[6] = "Mechanician";
            super.classSpec[7] = "Fighter";
            super.classSpec[8] = "Pikeman";
            super.classSpec[9] = "Assassin";
            super.classSpec[10] = "No Spec";
            super.sMINmpReg = 1.5f;
            super.sMAXmpReg = 1.9f;
            super.sHpReg = 1.4f;
            //Misc
            super.weight = 5;
            super.price = 100000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            case "100-Tulla Amulet":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Tulla Amulet";
            super.itemImgDir = "/assets/item/necklace/sb2.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 100;
            super.rSpi = 90;
            //Status Base            
            super.MINmpReg = 3f;
            super.MAXmpReg = 4.4f;
            super.MINhpReg = 3.7f;
            super.MAXhpReg = 4.4f;
            super.MINstmReg = 2.8f;
            super.MAXstmReg = 4.4f;
            super.MINmp = 60;
            super.MAXmp = 60;
            super.MINhp = 60;
            super.MAXhp = 60;
            super.MINstm = 60;
            super.MAXstm = 60;
            //Status Spec
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Atalanta";
            super.classSpec[2] = "Magician";
            super.classSpec[3] = "Priestess";
            super.classSpec[4] = "Shaman";
            super.classSpec[5] = "Archer";
            super.classSpec[6] = "Mechanician";
            super.classSpec[7] = "Fighter";
            super.classSpec[8] = "Pikeman";
            super.classSpec[9] = "Assassin";
            super.classSpec[10] = "No Spec";
            super.sMINmpReg = 1.8f;
            super.sMAXmpReg = 2.2f;
            super.sHpReg = 1.6f;
            //Misc
            super.weight = 5;
            super.price = 400000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            case "120-Throne Amulet":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Throne Amulet";
            super.itemImgDir = "/assets/item/necklace/sb3.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 120;
            super.rSpi = 100;
            //Status Base            
            super.MINmpReg = 3.8f;
            super.MAXmpReg = 5.2f;
            super.MINhpReg = 4.5f;
            super.MAXhpReg = 5.2f;
            super.MINstmReg = 3.6f;
            super.MAXstmReg = 5.2f;
            super.MINmp = 70;
            super.MAXmp = 70;
            super.MINhp = 70;
            super.MAXhp = 70;
            super.MINstm = 70;
            super.MAXstm = 70;
            //Status Spec
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Atalanta";
            super.classSpec[2] = "Magician";
            super.classSpec[3] = "Priestess";
            super.classSpec[4] = "Shaman";
            super.classSpec[5] = "Archer";
            super.classSpec[6] = "Mechanician";
            super.classSpec[7] = "Fighter";
            super.classSpec[8] = "Pikeman";
            super.classSpec[9] = "Assassin";
            super.classSpec[10] = "No Spec";
            super.sMINmpReg = 2.1f;
            super.sMAXmpReg = 2.5f;
            super.sHpReg = 1.8f;
            //Misc
            super.weight = 5;
            super.price = 400000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            case "130-Guide Amulet":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Guide Amulet";
            super.itemImgDir = "/assets/item/necklace/130.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 130;
            super.rSpi = 80;
            //Status Base            
            super.MINmpReg = 0f;
            super.MAXmpReg = 0f;
            super.MINhpReg = 0f;
            super.MAXhpReg = 0f;
            super.MINmp = 105;
            super.MAXmp = 118;
            super.MINhp = 66;
            super.MAXhp = 82;
            super.MINstm = 66;
            super.MAXstm = 72;
            //Status Spec
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Atalanta";
            super.classSpec[2] = "Magician";
            super.classSpec[3] = "Priestess";
            super.classSpec[4] = "Shaman";
            super.classSpec[5] = "Archer";
            super.classSpec[6] = "Mechanician";
            super.classSpec[7] = "Fighter";
            super.classSpec[8] = "Pikeman";
            super.classSpec[9] = "Assassin";
            super.classSpec[10] = "No Spec";
            super.sMINmpReg = 1.5f;
            super.sMAXmpReg = 2f;
            //Misc
            super.weight = 6;
            super.price = 280000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            //Ring
            
            case "80-Valento Ring":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Ring";
            super.itemName = "Valento Ring";
            super.itemImgDir = "/assets/item/ring/sb1.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 80;
            super.rSpi = 80;
            //Status Base  
            super.MINatkRtg = 42; 
            super.MAXatkRtg =  56;
            super.MINabs = 1.6f;
            super.MAXabs = 2.9f;
            super.MINdefense = 32;
            super.MAXdefense = 39;
            super.MINmpReg = 1.6f;
            super.MAXmpReg = 2.3f;
            super.MINhpReg = 2.1f;
            super.MAXhpReg = 2.6f;
            super.MINmp = 42;
            super.MAXmp = 46;
            super.MINhp = 40;
            super.MAXhp = 46;
            super.MINstm = 34;
            super.MAXstm = 38;
            //Status Spec
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Atalanta";
            super.classSpec[2] = "Magician";
            super.classSpec[3] = "Priestess";
            super.classSpec[4] = "Shaman";
            super.classSpec[5] = "Archer";
            super.classSpec[6] = "Mechanician";
            super.classSpec[7] = "Fighter";
            super.classSpec[8] = "Pikeman";
            super.classSpec[9] = "Assassin";
            super.classSpec[10] = "No Spec";
            super.sHpReg = 1.4f;
            //Misc
            super.weight = 5;
            super.price = 100000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            case "100-Lucifer Ring":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Ring";
            super.itemName = "Lucifer Ring";
            super.itemImgDir = "/assets/item/ring/sb2.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 100;
            super.rSpi = 90;
            //Status Base  
            super.MINatkRtg = 48; 
            super.MAXatkRtg =  62;
            super.MINabs = 2f;
            super.MAXabs = 3.3f;
            super.MINdefense = 36;
            super.MAXdefense = 43;
            super.MINmpReg = 2.1f;
            super.MAXmpReg = 2.8f;
            super.MINhpReg = 2.4f;
            super.MAXhpReg = 2.9f;
            super.MINmp = 46;
            super.MAXmp = 50;
            super.MINhp = 44;
            super.MAXhp = 50;
            super.MINstm = 38;
            super.MAXstm = 42;
            //Status Spec
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Atalanta";
            super.classSpec[2] = "Magician";
            super.classSpec[3] = "Priestess";
            super.classSpec[4] = "Shaman";
            super.classSpec[5] = "Archer";
            super.classSpec[6] = "Mechanician";
            super.classSpec[7] = "Fighter";
            super.classSpec[8] = "Pikeman";
            super.classSpec[9] = "Assassin";
            super.classSpec[10] = "No Spec";
            super.sHpReg = 1.6f;
            //Misc
            super.weight = 5;
            super.price = 200000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            case "120-Throne Ring":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Ring";
            super.itemName = "Throne Amulet";
            super.itemImgDir = "/assets/item/ring/sb3.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 120;
            super.rSpi = 100;
            //Status Base  
            super.MINatkRtg = 60; 
            super.MAXatkRtg =  74;
            super.MINabs = 2.7f;
            super.MAXabs = 4f;
            super.MINdefense = 45;
            super.MAXdefense = 52;
            super.MINmpReg = 2.8f;
            super.MAXmpReg = 3.5f;
            super.MINhpReg = 2.9f;
            super.MAXhpReg = 3.4f;
            super.MINmp = 54;
            super.MAXmp = 58;
            super.MINhp = 52;
            super.MAXhp = 58;
            super.MINstm = 46;
            super.MAXstm = 50;
            //Status Spec
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Atalanta";
            super.classSpec[2] = "Magician";
            super.classSpec[3] = "Priestess";
            super.classSpec[4] = "Shaman";
            super.classSpec[5] = "Archer";
            super.classSpec[6] = "Mechanician";
            super.classSpec[7] = "Fighter";
            super.classSpec[8] = "Pikeman";
            super.classSpec[9] = "Assassin";
            super.classSpec[10] = "No Spec";
            super.sHpReg = 1.8f;
            //Misc
            super.weight = 5;
            super.price = 400000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            case "130-Guide Ring":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Ring";
            super.itemName = "Guide Amulet";
            super.itemImgDir = "/assets/item/ring/130.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 130;
            super.rSpi = 90;
            //Status Base  
            super.MINhp = 60;
            super.MAXhp = 64;
            super.MINstm = 120;
            super.MAXstm = 142;
            //Status Spec
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Atalanta";
            super.classSpec[2] = "Magician";
            super.classSpec[3] = "Priestess";
            super.classSpec[4] = "Shaman";
            super.classSpec[5] = "Archer";
            super.classSpec[6] = "Mechanician";
            super.classSpec[7] = "Fighter";
            super.classSpec[8] = "Pikeman";
            super.classSpec[9] = "Assassin";
            super.classSpec[10] = "No Spec";
            super.sHpReg = 1.3f;
            //Misc
            super.weight = 6;
            super.price = 280000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            //Sheltom
            
            case "80-Dark Guardian Sheltom":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Sheltom";
            super.itemName = "Dark Guardian Sheltom";
            super.itemImgDir = "/assets/item/sheltom/sb1.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 80;
            super.rSpi = 80;
            //Status Base            
            super.MINmpReg = 2.4f;
            super.MAXmpReg = 2.9f;
            super.MINhpReg = 1.6f;
            super.MAXhpReg = 2.3f;
            super.MINmp = 10;
            super.MAXmp = 20;
            super.MINhp = 10;
            super.MAXhp = 20;
            //Status Spec
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Atalanta";
            super.classSpec[2] = "Magician";
            super.classSpec[3] = "Priestess";
            super.classSpec[4] = "Shaman";
            super.classSpec[5] = "Archer";
            super.classSpec[6] = "Mechanician";
            super.classSpec[7] = "Fighter";
            super.classSpec[8] = "Pikeman";
            super.classSpec[9] = "Assassin";
            super.classSpec[10] = "No Spec";
            super.sDivMp = 10;
            super.sDivHp = 10;
            super.sMINmpReg = 1.1f;
            super.sMAXmpReg = 1.5f;
            super.sHpReg = 0.9f;
            //Misc
            super.weight = 5;
            super.price = 100000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            case "100-Fury Sheltom":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Sheltom";
            super.itemName = "Fury Sheltom";
            super.itemImgDir = "/assets/item/sheltom/sb2.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 100;
            super.rSpi = 90;
            //Status Base            
            super.MINmpReg = 2.7f;
            super.MAXmpReg = 3.2f;
            super.MINhpReg = 1.9f;
            super.MAXhpReg = 2.6f;
            super.MINmp = 15;
            super.MAXmp = 25;
            super.MINhp = 15;
            super.MAXhp = 25;
            //Status Spec
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Atalanta";
            super.classSpec[2] = "Magician";
            super.classSpec[3] = "Priestess";
            super.classSpec[4] = "Shaman";
            super.classSpec[5] = "Archer";
            super.classSpec[6] = "Mechanician";
            super.classSpec[7] = "Fighter";
            super.classSpec[8] = "Pikeman";
            super.classSpec[9] = "Assassin";
            super.classSpec[10] = "No Spec";
            super.sDivMp = 10;
            super.sDivHp = 10;
            super.sMINmpReg = 1.3f;
            super.sMAXmpReg = 1.7f;
            super.sHpReg = 1.1f;
            //Misc
            super.weight = 5;
            super.price = 200000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            case "120-Throne Sheltom":
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
            super.MINmpReg = 3.2f;
            super.MAXmpReg = 3.7f;
            super.MINhpReg = 2.4f;
            super.MAXhpReg = 3.1f;
            super.MINmp = 25;
            super.MAXmp = 35;
            super.MINhp = 25;
            super.MAXhp = 35;
            //Status Spec
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Atalanta";
            super.classSpec[2] = "Magician";
            super.classSpec[3] = "Priestess";
            super.classSpec[4] = "Shaman";
            super.classSpec[5] = "Archer";
            super.classSpec[6] = "Mechanician";
            super.classSpec[7] = "Fighter";
            super.classSpec[8] = "Pikeman";
            super.classSpec[9] = "Assassin";
            super.classSpec[10] = "No Spec";
            super.sDivMp = 8;
            super.sDivHp = 8;
            super.sMINmpReg = 1.5f;
            super.sMAXmpReg = 1.9f;
            super.sHpReg = 1.3f;
            //Misc
            super.weight = 5;
            super.price = 200000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            case "120-Sol":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Sheltom";
            super.itemName = "Sol";
            super.itemImgDir = "/assets/item/sheltom/120.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 120;
            super.rSpi = 160;
            //Status Base            
            super.MINmpReg = 3f;
            super.MAXmpReg = 3.4f;
            super.MINhpReg = 3.4f;
            super.MAXhpReg = 4f;
            //Status Spec
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Atalanta";
            super.classSpec[2] = "Magician";
            super.classSpec[3] = "Priestess";
            super.classSpec[4] = "Shaman";
            super.classSpec[5] = "Archer";
            super.classSpec[6] = "Mechanician";
            super.classSpec[7] = "Fighter";
            super.classSpec[8] = "Pikeman";
            super.classSpec[9] = "Assassin";
            super.classSpec[10] = "No Spec";
            super.sMINmpReg = 1.9f;
            super.sMAXmpReg = 2.9f;
            super.sHpReg = 1.9f;
            //Misc
            super.weight = 2;
            super.price = 500000;
            super.itemLore = "";

            createItemDesc();
            break;
                        
        }
    }
}
