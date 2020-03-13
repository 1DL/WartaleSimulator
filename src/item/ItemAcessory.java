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
public class ItemAcessory extends Item {
    
    public ItemAcessory (String name) {
        super.zerarValoresModificados();
        super.itemCanAge = false;
        super.itemAged = false;
        switch (name) {
            
            case "No Gear":
            super.itemType = "No Gear";
            super.itemImgDir = null;
            break;
            //Amulet
            
            case "0-Round Amulet":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Round Amulet";
            super.itemImgDir = "/assets/item/necklace/0a.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            
            //Status Base 
            
            //Status Spec
            super.sMINmpReg = 0.1f;
            super.sMAXmpReg = 0.2f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 1;
            super.price = 100;
            super.itemLore = "";

            
            break;
            
            case "0-Round Amulet +1":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Round Amulet +1";
            super.itemImgDir = "/assets/item/necklace/0b.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            
            //Status Base 
            super.MINmp = 1;
            super.MAXmp = 3;
            //Status Spec
            super.sMINmpReg = 0.1f;
            super.sMAXmpReg = 0.2f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 1;
            super.price = 200;
            super.itemLore = "";

            
            break;
            
            case "0-Round Amulet +2":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Round Amulet +2";
            super.itemImgDir = "/assets/item/necklace/0c.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            
            //Status Base 
            super.MINmp = 2;
            super.MAXmp = 5;
            //Status Spec
            super.sMINmpReg = 0.1f;
            super.sMAXmpReg = 0.2f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 1;
            super.price = 300;
            super.itemLore = "";

            
            break;
            
            case "0-Round Amulet +3":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Round Amulet +3";
            super.itemImgDir = "/assets/item/necklace/0d.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            //Status Base 
            super.MINmp = 3;
            super.MAXmp = 7;
            //Status Spec
            super.sMINmpReg = 0.1f;
            super.sMAXmpReg = 0.2f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 1;
            super.price = 500;
            super.itemLore = "";

            
            break;
            
            case "5-Gem Amulet":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Gem Amulet";
            super.itemImgDir = "/assets/item/necklace/5.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 5;
            super.rSpi = 20;
            //Status Base 
            super.MINmp = 4;
            super.MAXmp = 9;
            //Status Spec
            super.sMINmpReg = 0.1f;
            super.sMAXmpReg = 0.3f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 2;
            super.price = 1000;
            super.itemLore = "";

            
            break;
            
            case "10-Gem Amulet +1":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Gem Amulet +1";
            super.itemImgDir = "/assets/item/necklace/10.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 10;
            super.rSpi = 24;
            //Status Base 
            super.MINmp = 5;
            super.MAXmp = 11;
            //Status Spec
            super.sMINmpReg = 0.1f;
            super.sMAXmpReg = 0.3f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 2;
            super.price = 1800;
            super.itemLore = "";

            
            break;
            
            case "15-Gem Amulet +2":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Gem Amulet +2";
            super.itemImgDir = "/assets/item/necklace/15.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 15;
            super.rSpi = 28;
            //Status Base 
            super.MINmp = 6;
            super.MAXmp = 13;
            //Status Spec
            super.sMINmpReg = 0.1f;
            super.sMAXmpReg = 0.3f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 2;
            super.price = 2400;
            super.itemLore = "";

            
            break;
            
            case "20-Gem Amulet +3":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Gem Amulet +3";
            super.itemImgDir = "/assets/item/necklace/20.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 20;
            super.rSpi = 32;
            //Status Base 
            super.MINmp = 7;
            super.MAXmp = 15;
            //Status Spec
            super.sMINmpReg = 0.1f;
            super.sMAXmpReg = 0.3f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 2;
            super.price = 3000;
            super.itemLore = "";

            
            break;
            
            case "25-Magic Amulet":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Magic Amulet";
            super.itemImgDir = "/assets/item/necklace/25.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 25;
            super.rSpi = 36;
            //Status Base 
            super.MINmp = 8;
            super.MAXmp = 17;
            //Status Spec
            super.sMINmpReg = 0.2f;
            super.sMAXmpReg = 0.4f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 3;
            super.price = 4000;
            super.itemLore = "";

            
            break;
            
            case "30-Magic Amulet +1":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Magic Amulet +1";
            super.itemImgDir = "/assets/item/necklace/30.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 30;
            super.rSpi = 40;
            //Status Base 
            super.MINmp = 9;
            super.MAXmp = 19;
            //Status Spec
            super.sMINmpReg = 0.2f;
            super.sMAXmpReg = 0.4f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 3;
            super.price = 6000;
            super.itemLore = "";

            
            break;
            
            case "35-Magic Amulet +2":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Magic Amulet +2";
            super.itemImgDir = "/assets/item/necklace/35.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 35;
            super.rSpi = 44;
            //Status Base 
            super.MINmp = 10;
            super.MAXmp = 21;
            //Status Spec
            super.sMINmpReg = 0.2f;
            super.sMAXmpReg = 0.4f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 3;
            super.price = 8000;
            super.itemLore = "";

            
            break;
            
            case "40-Magic Amulet +3":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Magic Amulet +3";
            super.itemImgDir = "/assets/item/necklace/40.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 40;
            super.rSpi = 48;
            //Status Base 
            super.MINmp = 11;
            super.MAXmp = 23;
            //Status Spec
            super.sMINmpReg = 0.2f;
            super.sMAXmpReg = 0.4f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 3;
            super.price = 10000;
            super.itemLore = "";

            
            break;
            
            case "45-Rune Amulet":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Rune Amulet";
            super.itemImgDir = "/assets/item/necklace/45.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 45;
            super.rSpi = 52;
            //Status Base 
            super.MINmp = 9;
            super.MAXmp = 15;
            super.MINhp = 2;
            super.MAXhp = 5;
            //Status Spec
            super.sMINmpReg = 0.2f;
            super.sMAXmpReg = 0.5f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 4;
            super.price = 15000;
            super.itemLore = "";

            
            break;
            
            case "50-Rune Amulet +1":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Rune Amulet +1";
            super.itemImgDir = "/assets/item/necklace/50.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 50;
            super.rSpi = 56;
            //Status Base 
            super.MINmp = 11;
            super.MAXmp = 17;
            super.MINhp = 4;
            super.MAXhp = 7;
            //Status Spec
            super.sMINmpReg = 0.2f;
            super.sMAXmpReg = 0.5f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 4;
            super.price = 20000;
            super.itemLore = "";

            
            break;
            
            case "55-Rune Amulet +2":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Rune Amulet +2";
            super.itemImgDir = "/assets/item/necklace/55.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 55;
            super.rSpi = 60;
            //Status Base 
            super.MINmp = 13;
            super.MAXmp = 19;
            super.MINhp = 6;
            super.MAXhp = 9;
            //Status Spec
            super.sMINmpReg = 0.2f;
            super.sMAXmpReg = 0.5f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 4;
            super.price = 25000;
            super.itemLore = "";

            
            break;
            
            case "60-Rune Amulet +3":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Rune Amulet +3";
            super.itemImgDir = "/assets/item/necklace/60.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 60;
            super.rSpi = 65;
            //Status Base 
            super.MINmp = 15;
            super.MAXmp = 21;
            super.MINhp = 8;
            super.MAXhp = 11;
            //Status Spec
            super.sMINmpReg = 0.2f;
            super.sMAXmpReg = 0.5f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 5;
            super.price = 30000;
            super.itemLore = "";

            
            break;
            
            case "65-Sealed Amulet":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Sealed Amulet";
            super.itemImgDir = "/assets/item/necklace/65.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 65;
            super.rSpi = 70;
            //Status Base 
            super.MINmp = 18;
            super.MAXmp = 24;
            super.MINhp = 12;
            super.MAXhp = 15;
            //Status Spec
            super.sMINmpReg = 0.3f;
            super.sMAXmpReg = 0.6f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 5;
            super.price = 35000;
            super.itemLore = "";

            
            break;
            
            case "70-Sealed Amulet +1":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Sealed Amulet +1";
            super.itemImgDir = "/assets/item/necklace/70.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 70;
            super.rSpi = 70;
            //Status Base 
            super.MINmp = 22;
            super.MAXmp = 28;
            super.MINhp = 14;
            super.MAXhp = 18;
            //Status Spec
            super.sMINmpReg = 0.3f;
            super.sMAXmpReg = 0.6f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 5;
            super.price = 40000;
            super.itemLore = "";

            
            break;
            
            case "75-Sealed Amulet +2":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Sealed Amulet +2";
            super.itemImgDir = "/assets/item/necklace/75.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 75;
            super.rSpi = 70;
            //Status Base 
            super.MINmp = 26;
            super.MAXmp = 32;
            super.MINhp = 16;
            super.MAXhp = 21;
            //Status Spec
            super.sMINmpReg = 0.3f;
            super.sMAXmpReg = 0.6f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 5;
            super.price = 42000;
            super.itemLore = "";

            
            break;
            
            case "80-Sealed Amulet +3":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Sealed Amulet +3";
            super.itemImgDir = "/assets/item/necklace/80.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 80;
            super.rSpi = 70;
            //Status Base 
            super.MINmp = 30;
            super.MAXmp = 36;
            super.MINhp = 18;
            super.MAXhp = 24;
            //Status Spec
            super.sMINmpReg = 0.3f;
            super.sMAXmpReg = 0.6f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 5;
            super.price = 50000;
            super.itemLore = "";

            
            break;
            
            case "80-Kelvezu Amulet":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Kelvezu Amulet";
            super.itemImgDir = "/assets/item/necklace/sb1.png";
            super.itemIconDir = ICON_AMULET;
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

            
            break;
            
            case "85-Mystic Amulet":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Mystic Amulet";
            super.itemImgDir = "/assets/item/necklace/85.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 85;
            super.rSpi = 75;
            //Status Base 
            super.MINmp = 34;
            super.MAXmp = 40;
            super.MINhp = 20;
            super.MAXhp = 28;
            //Status Spec
            super.sMINmpReg = 0.4f;
            super.sMAXmpReg = 0.7f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 5;
            super.price = 60000;
            super.itemLore = "";

            
            break;
            
            case "90-Mystic Amulet +1":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Mystic Amulet +1";
            super.itemImgDir = "/assets/item/necklace/90.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 90;
            super.rSpi = 75;
            //Status Base 
            super.MINmp = 38;
            super.MAXmp = 44;
            super.MINhp = 22;
            super.MAXhp = 31;
            //Status Spec
            super.sMINmpReg = 0.5f;
            super.sMAXmpReg = 0.7f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 5;
            super.price = 70000;
            super.itemLore = "";

            
            break;
            
            case "95-Mystic Amulet +2":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Mystic Amulet +2";
            super.itemImgDir = "/assets/item/necklace/95.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 95;
            super.rSpi = 75;
            //Status Base 
            super.MINmp = 42;
            super.MAXmp = 48;
            super.MINhp = 24;
            super.MAXhp = 34;
            //Status Spec
            super.sMINmpReg = 0.6f;
            super.sMAXmpReg = 0.8f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 5;
            super.price = 85000;
            super.itemLore = "";

            
            break;
            
            case "100-Mystic Amulet +3":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Mystic Amulet +3";
            super.itemImgDir = "/assets/item/necklace/100.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 100;
            super.rSpi = 75;
            //Status Base 
            super.MINmp = 46;
            super.MAXmp = 52;
            super.MINhp = 26;
            super.MAXhp = 37;
            //Status Spec
            super.sMINmpReg = 0.6f;
            super.sMAXmpReg = 1f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 5;
            super.price = 100000;
            super.itemLore = "";

            
            break;
            
            case "100-Tulla Amulet":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Tulla Amulet";
            super.itemImgDir = "/assets/item/necklace/sb2.png";
            super.itemIconDir = ICON_AMULET;
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

            
            break;
            
            case "105-Spirit Amulet":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Spirit Amulet";
            super.itemImgDir = "/assets/item/necklace/105.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 105;
            super.rSpi = 80;
            //Status Base 
            super.MINmp = 51;
            super.MAXmp = 57;
            super.MINhp = 29;
            super.MAXhp = 41;
            super.MINstm = 7;
            super.MAXstm = 11;
            //Status Spec
            super.sMINmpReg = 0.7f;
            super.sMAXmpReg = 1.1f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 6;
            super.price = 120000;
            super.itemLore = "";

            
            break;
            
            case "110-Spirit Amulet +1":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Spirit Amulet +1";
            super.itemImgDir = "/assets/item/necklace/110.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 110;
            super.rSpi = 80;
            //Status Base 
            super.MINmp = 56;
            super.MAXmp = 62;
            super.MINhp = 32;
            super.MAXhp = 45;
            super.MINstm = 12;
            super.MAXstm = 16;
            //Status Spec
            super.sMINmpReg = 0.8f;
            super.sMAXmpReg = 1.2f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 6;
            super.price = 140000;
            super.itemLore = "";

            
            break;
            
            case "115-Spirit Amulet +2":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Spirit Amulet +2";
            super.itemImgDir = "/assets/item/necklace/115.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 115;
            super.rSpi = 80;
            //Status Base 
            super.MINmp = 61;
            super.MAXmp = 67;
            super.MINhp = 35;
            super.MAXhp = 49;
            super.MINstm = 17;
            super.MAXstm = 21;
            //Status Spec
            super.sMINmpReg = 0.8f;
            super.sMAXmpReg = 1.3f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 6;
            super.price = 160000;
            super.itemLore = "";

            
            break;
            
            case "120-Spirit Amulet +3":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Spirit Amulet +3";
            super.itemImgDir = "/assets/item/necklace/120.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 120;
            super.rSpi = 80;
            //Status Base 
            super.MINmp = 66;
            super.MAXmp = 72;
            super.MINhp = 38;
            super.MAXhp = 53;
            super.MINstm = 22;
            super.MAXstm = 26;
            //Status Spec
            super.sMINmpReg = 0.9f;
            super.sMAXmpReg = 1.4f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 6;
            super.price = 180000;
            super.itemLore = "";

            
            break;
            
            case "120-Throne Amulet":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Throne Amulet";
            super.itemImgDir = "/assets/item/necklace/sb3.png";
            super.itemIconDir = ICON_AMULET;
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

            
            break;
            
            case "122-Enigma Amulet":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Enigma Amulet";
            super.itemImgDir = "/assets/item/necklace/122.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 122;
            super.rSpi = 80;
            //Status Base 
            super.MINmp = 74;
            super.MAXmp = 80;
            super.MINhp = 43;
            super.MAXhp = 58;
            super.MINstm = 30;
            super.MAXstm = 34;
            //Status Spec
            super.sMINmpReg = 1f;
            super.sMAXmpReg = 1.5f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 6;
            super.price = 200000;
            super.itemLore = "";

            
            break;
            
            case "124-Enigma Amulet +1":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Enigma Amulet +1";
            super.itemImgDir = "/assets/item/necklace/124.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 124;
            super.rSpi = 80;
            //Status Base 
            super.MINmp = 82;
            super.MAXmp = 88;
            super.MINhp = 48;
            super.MAXhp = 63;
            super.MINstm = 38;
            super.MAXstm = 42;
            //Status Spec
            super.sMINmpReg = 1.1f;
            super.sMAXmpReg = 1.6f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 6;
            super.price = 220000;
            super.itemLore = "";

            
            break;
            
            case "126-Enigma Amulet +2":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Enigma Amulet +2";
            super.itemImgDir = "/assets/item/necklace/126.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 126;
            super.rSpi = 80;
            //Status Base 
            super.MINmp = 90;
            super.MAXmp = 96;
            super.MINhp = 53;
            super.MAXhp = 68;
            super.MINstm = 46;
            super.MAXstm = 50;
            //Status Spec
            super.sMINmpReg = 1.2f;
            super.sMAXmpReg = 1.7f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 6;
            super.price = 240000;
            super.itemLore = "";

            
            break;
            
            case "128-Enigma Amulet +3":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Enigma Amulet +3";
            super.itemImgDir = "/assets/item/necklace/128.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 128;
            super.rSpi = 80;
            //Status Base 
            super.MINmp = 98;
            super.MAXmp = 104;
            super.MINhp = 58;
            super.MAXhp = 73;
            super.MINstm = 54;
            super.MAXstm = 38;
            //Status Spec
            super.sMINmpReg = 1.3f;
            super.sMAXmpReg = 1.8f;
            //Misc
            super.classSpec[0] = MS;
            super.classSpec[1] = FS;
            super.classSpec[2] = PS;
            super.classSpec[3] = AS;
            super.classSpec[4] = ASS;
            super.classSpec[5] = KS;
            super.classSpec[6] = ATS;
            super.classSpec[7] = PRS;
            super.classSpec[8] = MGS;
            super.classSpec[9] = SS;
            super.classSpec[10] = NS;
            super.weight = 6;
            super.price = 260000;
            super.itemLore = "";

            
            break;
            
            case "130-Guide Amulet":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Guide Amulet";
            super.itemImgDir = "/assets/item/necklace/130.png";
            super.itemIconDir = ICON_AMULET;
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

            
            break;
            
            case "134-Guide Amulet +1":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Guide Amulet +1";
            super.itemImgDir = "/assets/item/necklace/134.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 130;
            super.rSpi = 85;
            //Status Base            
            super.MINmpReg = 0f;
            super.MAXmpReg = 0f;
            super.MINhpReg = 0f;
            super.MAXhpReg = 0f;
            super.MINmp = 116;
            super.MAXmp = 122;
            super.MINhp = 77;
            super.MAXhp = 87;
            super.MINstm = 69;
            super.MAXstm = 76;
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
            super.sMINmpReg = 1.7f;
            super.sMAXmpReg = 2.2f;
            //Misc
            super.weight = 7;
            super.price = 320000;
            super.itemLore = "";

            
            break;
            
            case "138-Guide Amulet +2":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Guide Amulet +2";
            super.itemImgDir = "/assets/item/necklace/138.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 138;
            super.rSpi = 90;
            //Status Base            
            super.MINmpReg = 0f;
            super.MAXmpReg = 0f;
            super.MINhpReg = 0f;
            super.MAXhpReg = 0f;
            super.MINmp = 120;
            super.MAXmp = 131;
            super.MINhp = 82;
            super.MAXhp = 94;
            super.MINstm = 73;
            super.MAXstm = 85;
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
            super.sMAXmpReg = 2.4f;
            //Misc
            super.weight = 7;
            super.price = 360000;
            super.itemLore = "";

            
            break;
            
            case "142-Guide Amulet +3":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Amulet";
            super.itemName = "Guide Amulet +3";
            super.itemImgDir = "/assets/item/necklace/142.png";
            super.itemIconDir = ICON_AMULET;
            //Requerimentos
            super.rLvl = 142;
            super.rSpi = 95;
            //Status Base            
            super.MINmpReg = 0f;
            super.MAXmpReg = 0f;
            super.MINhpReg = 0f;
            super.MAXhpReg = 0f;
            super.MINmp = 129;
            super.MAXmp = 140;
            super.MINhp = 89;
            super.MAXhp = 101;
            super.MINstm = 82;
            super.MAXstm = 94;
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
            super.sMAXmpReg = 2.6f;
            //Misc
            super.weight = 7;
            super.price = 400000;
            super.itemLore = "";

            
            break;
            
            //Ring
            
            case "80-Valento Ring":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Ring";
            super.itemName = "Valento Ring";
            super.itemImgDir = "/assets/item/ring/sb1.png";
            super.itemIconDir = ICON_RING;
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

            
            break;
            
            case "100-Lucifer Ring":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Ring";
            super.itemName = "Lucifer Ring";
            super.itemImgDir = "/assets/item/ring/sb2.png";
            super.itemIconDir = ICON_RING;
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

            
            break;
            
            case "120-Throne Ring":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Ring";
            super.itemName = "Throne Amulet";
            super.itemImgDir = "/assets/item/ring/sb3.png";
            super.itemIconDir = ICON_RING;
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

            
            break;
            
            case "130-Guide Ring":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Ring";
            super.itemName = "Guide Ring";
            super.itemImgDir = "/assets/item/ring/130.png";
            super.itemIconDir = ICON_RING;
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

            
            break;
            
            case "134-Guide Ring +1":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Ring";
            super.itemName = "Guide Ring +1";
            super.itemImgDir = "/assets/item/ring/134.png";
            super.itemIconDir = ICON_RING;
            //Requerimentos
            super.rLvl = 134;
            super.rSpi = 92;
            //Status Base  
            super.MINhp = 63;
            super.MAXhp = 68;
            super.MINstm = 126;
            super.MAXstm = 144;
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
            super.weight = 7;
            super.price = 320000;
            super.itemLore = "";

            
            break;
            
            case "138-Guide Ring +2":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Ring";
            super.itemName = "Guide Ring +2";
            super.itemImgDir = "/assets/item/ring/138.png";
            super.itemIconDir = ICON_RING;
            //Requerimentos
            super.rLvl = 138;
            super.rSpi = 94;
            //Status Base  
            super.MINhp = 67;
            super.MAXhp = 72;
            super.MINstm = 135;
            super.MAXstm = 149;
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
            super.sHpReg = 1.5f;
            //Misc
            super.weight = 7;
            super.price = 360000;
            super.itemLore = ICON_RING;

            
            break;
            
            case "142-Guide Ring +3":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Ring";
            super.itemName = "Guide Ring +3";
            super.itemImgDir = "/assets/item/ring/142.png";
            super.itemIconDir = ICON_RING;
            //Requerimentos
            super.rLvl = 142;
            super.rSpi = 96;
            //Status Base  
            super.MINhp = 71;
            super.MAXhp = 76;
            super.MINstm = 143;
            super.MAXstm = 154;
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
            super.weight = 7;
            super.price = 400000;
            super.itemLore = "";

            
            break;
            
            //Sheltom
            
            case "80-Dark Guardian Sheltom":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Sheltom";
            super.itemName = "Dark Guardian Sheltom";
            super.itemImgDir = "/assets/item/sheltom/sb1.png";
            super.itemIconDir = ICON_SHELTOM;
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

            
            break;
            
            case "100-Fury Sheltom":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Sheltom";
            super.itemName = "Fury Sheltom";
            super.itemImgDir = "/assets/item/sheltom/sb2.png";
            super.itemIconDir = ICON_SHELTOM;
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

            
            break;
            
            case "120-Throne Sheltom":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Sheltom";
            super.itemName = "Throne Sheltom";
            super.itemImgDir = "/assets/item/sheltom/sb3.png";
            super.itemIconDir = ICON_SHELTOM;
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

            
            break;
            
            case "120-Sol":
            //Identificaçao item
            super.itemClass = "Acessory";
            super.itemType = "Sheltom";
            super.itemName = "Sol";
            super.itemImgDir = "/assets/item/sheltom/sol.png";
            super.itemIconDir = ICON_SHELTOM;
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

            
            break;
            
            default:
                super.itemType = "No Gear";
                super.itemImgDir = null;
            break;
                        
        }
    }
}
