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
public class Defense extends ItemStats {
    public Defense(String name) {
        switch(name) {
            
            //Armors
            
            case "140-Quantum Armor":
            //Identificaçao item
            super.itemClass = "Armor";
            super.itemType = "Armor";
            super.itemName = "Quantum Armor";
            super.itemImgDir = "/assets/item/armor/140.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 140;
            super.rStr = 308;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 275;
            super.MAXintegrity = 310;
            super.MINorganicResist = 14;
            super.MAXorganicResist = 18;
            super.MINfireResist = 14;
            super.MAXfireResist = 18;
            super.MINiceResist = 14;
            super.MAXiceResist = 18;
            super.MINlightningResist = 14;
            super.MAXlightningResist = 18;
            super.MINpoisonResist = 14;
            super.MAXpoisonResist = 18;
            super.MINabs = 50f;
            super.MAXabs = 51f;
            super.MINdefense = 975;
            super.MAXdefense = 1020;
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
            super.sMINabs = 3.2f;
            super.sMAXabs = 3.6f;
            super.sMINdefense = 136;
            super.sMAXdefense = 152;
            //Misc
            super.weight = 200;
            super.price = 3080000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            //Robes
            
            case "140-Warlock Robe":
            //Identificaçao item
            super.itemClass = "Armor";
            super.itemType = "Robe";
            super.itemName = "Warlock Robe";
            super.itemImgDir = "/assets/item/robe/140.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 140;
            super.rSpi = 370;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 240;
            super.MAXintegrity = 260;
            super.MINorganicResist = 15;
            super.MAXorganicResist = 19;
            super.MINfireResist = 15;
            super.MAXfireResist = 19;
            super.MINiceResist = 15;
            super.MAXiceResist = 19;
            super.MINlightningResist = 15;
            super.MAXlightningResist = 19;
            super.MINpoisonResist = 15;
            super.MAXpoisonResist = 19;
            super.MINabs = 40.5f;
            super.MAXabs = 42.1f;
            super.MINdefense = 935;
            super.MAXdefense = 1000;
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
            super.sMINabs = 3.2f;
            super.sMAXabs = 3.6f;
            super.sMINdefense = 136;
            super.sMAXdefense = 152;
            //Misc
            super.weight = 200;
            super.price = 3080000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            //Shields
            
            case "140-Imperial Shield":
            //Identificaçao item
            super.itemClass = "Shield";
            super.itemType = "Shield";
            super.itemName = "Imperial Shield";
            super.itemImgDir = "/assets/item/shield/140.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 140;
            super.rStr = 180;
            super.rTal = 75;
            //Status Base
            super.MINintegrity = 280;
            super.MAXintegrity = 330;
            super.MINorganicResist = 10;
            super.MAXorganicResist = 12;
            super.MINfireResist = 10;
            super.MAXfireResist = 12;
            super.MINiceResist = 10;
            super.MAXiceResist = 12;
            super.MINlightningResist = 10;
            super.MAXlightningResist = 12;
            super.MINpoisonResist = 10;
            super.MAXpoisonResist = 12;
            super.MINabs = 26.3f;
            super.MAXabs = 27.2f;
            super.MINdefense = 472;
            super.MAXdefense = 500;
            super.MINblock = 21f;
            super.MAXblock = 23f;
            //Status Spec
            super.classSpec[0] = "Knight";
            super.classSpec[1] = "Atalanta";
            super.classSpec[2] = "Archer";
            super.classSpec[3] = "Mechanician";
            super.classSpec[4] = "Fighter";
            super.classSpec[5] = "Pikeman";
            super.classSpec[6] = "No Spec";
            super.sMINabs = 2.5f;
            super.sMAXabs = 2.7f;
            super.sMINdefense = 77;
            super.sMAXdefense = 83;
            super.sBlock = 6;
            //Misc
            super.weight = 159;
            super.price = 3540000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            //Orbs
            
            case "140-Sentinel":
            //Identificaçao item
            super.itemClass = "Shield";
            super.itemType = "Orb";
            super.itemName = "Sentinel";
            super.itemImgDir = "/assets/item/orb/140.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 140;
            super.rSpi = 325;
            //Status Base
            super.MINintegrity = 230;
            super.MAXintegrity = 250;
            super.MINorganicResist = 10;
            super.MAXorganicResist = 12;
            super.MINfireResist = 10;
            super.MAXfireResist = 12;
            super.MINiceResist = 10;
            super.MAXiceResist = 12;
            super.MINlightningResist = 10;
            super.MAXlightningResist = 12;
            super.MINpoisonResist = 10;
            super.MAXpoisonResist = 12;
            super.MINabs = 21.6f;
            super.MAXabs = 23.4f;
            super.MINdefense = 309;
            super.MAXdefense = 352;
            super.MINblock = 14f;
            super.MAXblock = 18f;
            super.MINmp = 374;
            super.MAXmp = 398;
            super.MINhp = 200;
            super.MAXhp = 212;
            //Status Spec
            super.classSpec[0] = "Priestess";
            super.classSpec[1] = "Magician";
            super.classSpec[2] = "Shaman";
            super.classSpec[3] = "No Spec";
            super.sMINabs = 3.5f;
            super.sMAXabs = 4f;
            super.sMINdefense = 58;
            super.sMAXdefense = 70;
            super.sBlock = 9;
            super.sMINmpReg = 6.3f;
            super.sMAXmpReg = 7.1f;
            super.sHpReg = 6.3f;
            //Misc
            super.weight = 88;
            super.price = 1720000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            //Bracelets
            
            case "140-Mercurial Bracelets":
            //Identificaçao item
            super.itemClass = "Bracelet";
            super.itemType = "Bracelet";
            super.itemName = "Mercurial Bracelet";
            super.itemImgDir = "/assets/item/bracelet/140.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 140;
            super.rStr = 90;
            super.rAgi = 130;
            //Status Base
            super.MINintegrity = 220;
            super.MAXintegrity = 230;
            super.MINatkRtg = 306;
            super.MAXatkRtg = 320;
            super.MINdefense = 312;
            super.MAXdefense = 328;
            super.potCount = 170;
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
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;
            //Misc
            super.weight = 67;
            super.price = 1540000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            //Gauntlets
            
            case "140-Gauntlets":
            //Identificaçao item
            super.itemClass = "Gauntlets";
            super.itemType = "Gauntlets";
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
            super.MINintegrity = 245;
            super.MAXintegrity = 255;
            super.MINorganicResist = 10;
            super.MAXorganicResist = 11;
            super.MINfireResist = 10;
            super.MAXfireResist = 11;
            super.MINiceResist = 10;
            super.MAXiceResist = 11;
            super.MINlightningResist = 10;
            super.MAXlightningResist = 11;
            super.MINpoisonResist = 10;
            super.MAXpoisonResist = 11;
            super.MINabs = 21.2f;
            super.MAXabs = 22.2f;
            super.MINdefense = 322;
            super.MAXdefense = 352;
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
            super.sMINabs = 1.7f;
            super.sMAXabs = 2f;
            super.sMINdefense = 104;
            super.sMAXdefense = 111;
            //Misc
            super.weight = 92;
            super.price = 1520000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            case "136-Greedy Gauntlets":
            //Identificaçao item
            super.itemClass = "Gauntlets";
            super.itemType = "Gauntlets";
            super.itemName = "Greedy Gauntlets";
            super.itemImgDir = "/assets/item/gauntlet/136b.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 136;
            super.rStr = 100;
            super.rSpi = 40;
            super.rTal = 90;
            super.rAgi = 77;
            //Status Base
            super.MINintegrity = 245;
            super.MAXintegrity = 250;
            super.MINorganicResist = 10;
            super.MAXorganicResist = 11;
            super.MINfireResist = 10;
            super.MAXfireResist = 11;
            super.MINiceResist = 10;
            super.MAXiceResist = 11;
            super.MINlightningResist = 10;
            super.MAXlightningResist = 11;
            super.MINpoisonResist = 10;
            super.MAXpoisonResist = 11;
            super.MINabs = 19.5f;
            super.MAXabs = 20.1f;
            super.MINdefense = 320;
            super.MAXdefense = 336;
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
            super.sMINabs = 1.7f;
            super.sMAXabs = 1.8f;
            super.sMINdefense = 102;
            super.sMAXdefense = 106;
            super.sDivAtkPow = 10;
            //Misc
            super.weight = 82;
            super.price = 1430000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            //Boots
            
            case "140-Mercurial Boots":
            //Identificaçao item
            super.itemClass = "Boots";
            super.itemType = "Boots";
            super.itemName = "Mercurial Boots";
            super.itemImgDir = "/assets/item/boots/140.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 140;
            super.rStr = 100;
            super.rSpi = 40;
            super.rAgi = 90;
            //Status Base
            super.MINintegrity = 235;
            super.MAXintegrity = 245;
            super.MINorganicResist = 9;
            super.MAXorganicResist = 10;
            super.MINfireResist = 9;
            super.MAXfireResist = 10;
            super.MINiceResist = 9;
            super.MAXiceResist = 10;
            super.MINlightningResist = 9;
            super.MAXlightningResist = 10;
            super.MINpoisonResist = 9;
            super.MAXpoisonResist = 10;
            super.MINabs = 26.7f;
            super.MAXabs = 27.3f;
            super.MINdefense = 335;
            super.MAXdefense = 345;
            super.MINmoveSpeed = 5.7f;
            super.MAXmoveSpeed = 6f;
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
            super.sMINabs = 1.5f;
            super.sMAXabs = 1.8f;
            super.sMINmoveSpeed = 1.8f;
            super.sMAXmoveSpeed = 2.4f;
            //Misc
            super.weight = 92;
            super.price = 1620000;
            super.itemLore = "";

            createItemDesc();
            break;
            
            case "138-Draxos Boots":
            //Identificaçao item
            super.itemClass = "Boots";
            super.itemType = "Boots";
            super.itemName = "Draxos Boots";
            super.itemImgDir = "/assets/item/boots/138.png";
            super.itemIconDir = "";
            //Requerimentos
            super.rLvl = 138;
            super.rStr = 90;
            super.rSpi = 40;
            super.rAgi = 90;
            //Status Base
            super.MINintegrity = 230;
            super.MAXintegrity = 240;
            super.MINorganicResist = 9;
            super.MAXorganicResist = 10;
            super.MINfireResist = 9;
            super.MAXfireResist = 10;
            super.MINiceResist = 9;
            super.MAXiceResist = 10;
            super.MINlightningResist = 9;
            super.MAXlightningResist = 10;
            super.MINpoisonResist = 9;
            super.MAXpoisonResist = 10;
            super.MINabs = 25.1f;
            super.MAXabs = 26f;
            super.MINevasion = 10;
            super.MAXevasion = 15;
            super.MINdefense = 320;
            super.MAXdefense = 335;
            super.MINmoveSpeed = 5.7f;
            super.MAXmoveSpeed = 5.9f;
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
            super.sMINabs = 1.5f;
            super.sMAXabs = 1.7f;
            super.sMINmoveSpeed = 1.8f;
            super.sMAXmoveSpeed = 2.3f;
            //Misc
            super.weight = 86;
            super.price = 1500000;
            super.itemLore = "";

            createItemDesc();
            break;
        }
    }
}
