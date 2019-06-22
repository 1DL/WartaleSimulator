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
public class ItemWeapon extends Item {
    public ItemWeapon(String name) {
        super.zerarValoresModificados();
        super.itemCanAge = true;
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

            
            break;
            
            //Axe
            
            case "142-Havoc Axe":
            //Identificaçao item
            super.itemClass = "Melee";
            super.itemType = "Axe";
            super.itemName = "Havoc Axe";
            super.itemImgDir = "/assets/item/weapon/axe/142.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 142;
            super.rStr = 340;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 310;
            super.MAXintegrity = 330;
            super.MINatkMin = 115;
            super.MAXatkMin = 123;
            super.MINatkMax = 135;
            super.MAXatkMax = 140;
            super.atkSpd = 8;
            super.MINatkRtg = 327;
            super.MAXatkRtg = 349;
            super.critChance = 15;
            super.MINblock = 0;
            super.MAXblock = 0;
            //Status Spec
            super.sCritChance = 4;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;            
            super.sDivAtkPow = 7;
            super.classSpec[0] = "Fighter";
            super.classSpec[1] = "Mechanician";
            super.classSpec[2] = "Pikeman";
            super.classSpec[3] = "No Spec";
            //Misc
            super.weight = 136;
            super.price = 3410000;
            super.itemLore = "";

            
            break;
            
            case "138-Zealous Axe":
            //Identificaçao item
            super.itemClass = "Melee";
            super.itemType = "Axe";
            super.itemName = "Zealous Axe";
            super.itemImgDir = "/assets/item/weapon/axe/138.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = TWOHANDED;
            //Requerimentos
            super.rLvl = 138;
            super.rStr = 320;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 295;
            super.MAXintegrity = 315;
            super.MINatkMin = 132;
            super.MAXatkMin = 138;
            super.MINatkMax = 147;
            super.MAXatkMax = 150;
            super.atkSpd = 8;
            super.MINatkRtg = 314;
            super.MAXatkRtg = 327;
            super.critChance = 22;
            super.MINblock = 12;
            super.MAXblock = 12;
            //Status Spec
            super.sCritChance = 4;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;            
            super.sDivAtkPow = 7;
            super.classSpec[0] = "Fighter";
            super.classSpec[1] = "Mechanician";
            super.classSpec[2] = "Pikeman";
            super.classSpec[3] = "No Spec";
            //Misc
            super.weight = 130;
            super.price = 3030000;
            super.itemLore = "";

            
            break;
            
            case "122-Gladiator Axe":
            //Identificaçao item
            super.itemClass = "Melee";
            super.itemType = "Axe";
            super.itemName = "Gladiator Axe";
            super.itemImgDir = "/assets/item/weapon/axe/122.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 122;
            super.rStr = 245;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 230;
            super.MAXintegrity = 250;
            super.MINatkMin = 89;
            super.MAXatkMin = 92;
            super.MINatkMax = 112;
            super.MAXatkMax = 115;
            super.atkSpd = 8;
            super.MINatkRtg = 228;
            super.MAXatkRtg = 241;
            super.critChance = 14;
            super.MINblock = 0;
            super.MAXblock = 0;
            //Status Spec
            super.sCritChance = 4;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;            
            super.sDivAtkPow = 7;
            super.classSpec[0] = "Fighter";
            super.classSpec[1] = "Mechanician";
            super.classSpec[2] = "No Spec";
            //Misc
            super.weight = 92;
            super.price = 2150000;
            super.itemLore = "";

            
            break;
            
            //Hammer
            
            case "142-Headcrusher":
            //Identificaçao item
            super.itemClass = "Melee";
            super.itemType = "Hammer";
            super.itemName = "Headcrusher";
            super.itemImgDir = "/assets/item/weapon/hammer/142.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 142;
            super.rStr = 236;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 250;
            super.MAXintegrity = 260;
            super.MINatkMin = 107;
            super.MAXatkMin = 110;
            super.MINatkMax = 139;
            super.MAXatkMax = 144;
            super.atkSpd = 8;
            super.MINatkRtg = 328;
            super.MAXatkRtg = 369;
            super.critChance = 20;
            super.MINblock = 0;
            super.MAXblock = 0;
            //Status Spec
            super.sCritChance = 0;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;            
            super.sDivAtkPow = 7;
            super.classSpec[0] = "Mechanician";
            super.classSpec[1] = "Fighter";
            super.classSpec[2] = "Pikeman";
            super.classSpec[3] = "Assassin";
            super.classSpec[4] = "Knight";
            super.classSpec[5] = "No Spec";
            //Misc
            super.weight = 150;
            super.price = 2900000;
            super.itemLore = "";

            
            break;
            
            case "138-Taurus":
            //Identificaçao item
            super.itemClass = "Melee";
            super.itemType = "Hammer";
            super.itemName = "Taurus";
            super.itemImgDir = "/assets/item/weapon/hammer/138.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = TWOHANDED;
            //Requerimentos
            super.rLvl = 138;
            super.rStr = 225;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 240;
            super.MAXintegrity = 250;
            super.MINatkMin = 122;
            super.MAXatkMin = 125;
            super.MINatkMax = 151;
            super.MAXatkMax = 157;
            super.atkSpd = 8;
            super.MINatkRtg = 334;
            super.MAXatkRtg = 354;
            super.critChance = 23;
            super.MINblock = 15;
            super.MAXblock = 15;
            //Status Spec
            super.sCritChance = 6;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;            
            super.sDivAtkPow = 7;
            super.classSpec[0] = "Mechanician";
            super.classSpec[1] = "Fighter";
            super.classSpec[2] = "Pikeman";
            super.classSpec[3] = "Assassin";
            super.classSpec[4] = "Knight";
            super.classSpec[5] = "No Spec";
            //Misc
            super.weight = 140;
            super.price = 2380000;
            super.itemLore = "";

            
            break;
            
            //Claw
            
            case "142-Valiant Claw":
            //Identificaçao item
            super.itemClass = "Melee";
            super.itemType = "Claw";
            super.itemName = "Valiant Claw";
            super.itemImgDir = "/assets/item/weapon/claw/142.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 142;
            super.rStr = 280;
            super.rTal = 90;
            super.rAgi = 80;
            //Status Base
            super.MINintegrity = 220;
            super.MAXintegrity = 244;
            super.MINatkMin = 108;
            super.MAXatkMin = 111;
            super.MINatkMax = 137;
            super.MAXatkMax = 142;
            super.atkSpd = 8;
            super.MINatkRtg = 316;
            super.MAXatkRtg = 342;
            super.critChance = 19;
            super.MINdefense = 150;
            super.MAXdefense = 165;
            super.MINblock = 0;
            super.MAXblock = 0;
            //Status Spec
            super.sCritChance = 4;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;            
            super.sDivAtkPow = 7;
            super.classSpec[0] = "Mechanician";
            super.classSpec[1] = "Fighter";
            super.classSpec[2] = "Pikeman";
            super.classSpec[3] = "Atalanta";
            super.classSpec[4] = "No Spec";
            //Misc
            super.weight = 95;
            super.price = 3250000;
            super.itemLore = "";

            
            break;
            
            case "138-Ferocious Claw":
            //Identificaçao item
            super.itemClass = "Melee";
            super.itemType = "Claw";
            super.itemName = "Ferocious Claw";
            super.itemImgDir = "/assets/item/weapon/claw/138.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 138;
            super.rStr = 260;
            super.rTal = 90;
            super.rAgi = 80;
            //Status Base
            super.MINintegrity = 212;
            super.MAXintegrity = 236;
            super.MINatkMin = 104;
            super.MAXatkMin = 107;
            super.MINatkMax = 132;
            super.MAXatkMax = 136;
            super.atkSpd = 8;
            super.MINatkRtg = 288;
            super.MAXatkRtg = 312;
            super.critChance = 19;
            super.MINdefense = 142;
            super.MAXdefense = 155;
            super.MINblock = 0;
            super.MAXblock = 0;
            //Status Spec
            super.sCritChance = 4;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;            
            super.sDivAtkPow = 7;
            super.classSpec[0] = "Mechanician";
            super.classSpec[1] = "Fighter";
            super.classSpec[2] = "Pikeman";
            super.classSpec[3] = "Atalanta";
            super.classSpec[4] = "No Spec";
            //Misc
            super.weight = 90;
            super.price = 2800000;
            super.itemLore = "";

            
            break;
            
            //Scythe

            case "142-Diamond Spear":
            //Identificaçao item
            super.itemClass = "Melee";
            super.itemType = "Scythe";
            super.itemName = "Diamond Spear";
            super.itemImgDir = "/assets/item/weapon/scythe/142.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 142;
            super.rStr = 280;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 264;
            super.MAXintegrity = 282;
            super.MINatkMin = 67;
            super.MAXatkMin = 71;
            super.MINatkMax = 121;
            super.MAXatkMax = 125;
            super.atkSpd = 7;
            super.MINatkRtg = 259;
            super.MAXatkRtg = 279;
            super.critChance = 26;
            super.MINblock = 0;
            super.MAXblock = 0;
            //Status Spec
            super.sAtkSpd = 1;
            super.sDivAtkPow = 6;
            super.classSpec[0] = "Pikeman";
            super.classSpec[1] = "Mechanician";
            super.classSpec[2] = "Fighter";
            super.classSpec[3] = "Shaman";
            super.classSpec[4] = "No Spec";
            //Misc
            super.weight = 140;
            super.price = 3610000;
            super.itemLore = "";

            
            break;
            
            case "138-Tormentor Scythe":
            //Identificaçao item
            super.itemClass = "Melee";
            super.itemType = "Scythe";
            super.itemName = "Tormentor Scythe";
            super.itemImgDir = "/assets/item/weapon/scythe/138.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = TWOHANDED;
            //Requerimentos
            super.rLvl = 138;
            super.rStr = 265;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 225;
            super.MAXintegrity = 270;
            super.MINatkMin = 82;
            super.MAXatkMin = 89;
            super.MINatkMax = 154;
            super.MAXatkMax = 161;
            super.atkSpd = 8;
            super.MINatkRtg = 280;
            super.MAXatkRtg = 299;
            super.critChance = 21;
            super.MINblock = 18;
            super.MAXblock = 18;
            //Status Spec
            super.sCritChance = 4;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;
            super.sDivAtkPow = 6;
            super.classSpec[0] = "Pikeman";
            super.classSpec[1] = "Mechanician";
            super.classSpec[2] = "Fighter";
            super.classSpec[3] = "Shaman";
            super.classSpec[4] = "No Spec";
            //Misc
            super.weight = 130;
            super.price = 3060000;
            super.itemLore = "";

            
            break;
            
            
            case "122-Double Sided Spear":
            //Identificaçao item
            super.itemClass = "Melee";
            super.itemType = "Scythe";
            super.itemName = "Double Sided Spear";
            super.itemImgDir = "/assets/item/weapon/scythe/122.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 122;
            super.rStr = 215;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 198;
            super.MAXintegrity = 220;
            super.MINatkMin = 52;
            super.MAXatkMin = 55;
            super.MINatkMax = 95;
            super.MAXatkMax = 98;
            super.atkSpd = 7;
            super.MINatkRtg = 171;
            super.MAXatkRtg = 189;
            super.critChance = 25;
            super.MINblock = 0;
            super.MAXblock = 0;
            //Status Spec
            super.sAtkSpd = 1;
            super.sDivAtkPow = 6;
            super.classSpec[0] = "Pikeman";
            super.classSpec[1] = "Atalanta";
            super.classSpec[2] = "Fighter";
            super.classSpec[3] = "No Spec";
            //Misc
            super.weight = 82;
            super.price = 2200000;
            super.itemLore = "";

            
            break;
            
            //Dagger
            
            case "142-Nightblade":
            //Identificaçao item
            super.itemClass = "Melee";
            super.itemType = "Dagger";
            super.itemName = "Nightblade";
            super.itemImgDir = "/assets/item/weapon/dagger/142.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 142;
            super.rStr = 344;
            super.rTal = 90;
            super.rAgi = 90;
            //Status Base
            super.MINintegrity = 258;
            super.MAXintegrity = 274;
            super.MINatkMin = 123;
            super.MAXatkMin = 127;
            super.MINatkMax = 131;
            super.MAXatkMax = 135;
            super.atkSpd = 8;
            super.MINatkRtg = 308;
            super.MAXatkRtg = 328;
            super.critChance = 26;
            super.MINblock = 16;
            super.MAXblock = 17;
            //Status Spec
            super.sAtkSpd = 1;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;
            super.sDivAtkPow = 6;
            super.classSpec[0] = "Assassin";
            super.classSpec[1] = "Knight";
            super.classSpec[2] = "Atalanta";
            super.classSpec[3] = "No Spec";
            //Misc
            super.weight = 85;
            super.price = 3250000;
            super.itemLore = "";

            
            break;
            
            case "138-Devious Dagger":
            //Identificaçao item
            super.itemClass = "Melee";
            super.itemType = "Dagger";
            super.itemName = "Devious Dagger";
            super.itemImgDir = "/assets/item/weapon/dagger/138.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 138;
            super.rStr = 328;
            super.rTal = 90;
            super.rAgi = 90;
            //Status Base
            super.MINintegrity = 250;
            super.MAXintegrity = 265;
            super.MINatkMin = 114;
            super.MAXatkMin = 120;
            super.MINatkMax = 124;
            super.MAXatkMax = 128;
            super.atkSpd = 8;
            super.MINatkRtg = 270;
            super.MAXatkRtg = 290;
            super.critChance = 25;
            super.MINblock = 15;
            super.MAXblock = 17;
            //Status Spec
            super.sAtkSpd = 1;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;
            super.sDivAtkPow = 6;
            super.classSpec[0] = "Assassin";
            super.classSpec[1] = "Knight";
            super.classSpec[2] = "Atalanta";
            super.classSpec[3] = "No Spec";
            //Misc
            super.weight = 80;
            super.price = 2800000;
            super.itemLore = "";

            
            break;
            
            //Bow
            
            case "142-Astral Hand Crossbow":
            //Identificaçao item
            super.itemClass = "Ranged";
            super.itemType = "Bow";
            super.itemName = "Astral Hand Crossbow";
            super.itemImgDir = "/assets/item/weapon/bow/142.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 142;
            super.rStr = 80;
            super.rSpi = 40;
            super.rTal = 80;
            super.rAgi = 262;
            //Status Base
            super.MINintegrity = 230;
            super.MAXintegrity = 245;
            super.MINatkMin = 87;
            super.MAXatkMin = 91;
            super.MINatkMax = 108;
            super.MAXatkMax = 112;
            super.range = 280;
            super.atkSpd = 8;
            super.MINatkRtg = 266;
            super.MAXatkRtg = 288;
            super.critChance = 18;
            super.MINblock = 0;
            super.MAXblock = 0;
            //Status Spec
            super.sCritChance = 4;
            super.sRange = 25;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;
            super.sDivAtkPow = 7;
            super.classSpec[0] = "Archer";
            super.classSpec[1] = "Mechanician";
            super.classSpec[2] = "Atalanta";
            super.classSpec[3] = "No Spec";
            //Misc
            super.weight = 95;
            super.price = 3360000;
            super.itemLore = "";

            
            break;
            
            case "138-Lucifer Bow":
            //Identificaçao item
            super.itemClass = "Ranged";
            super.itemType = "Bow";
            super.itemName = "Lucifer Bow";
            super.itemImgDir = "/assets/item/weapon/bow/138.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = TWOHANDED;
            //Requerimentos
            super.rLvl = 138;
            super.rStr = 80;
            super.rSpi = 40;
            super.rTal = 80;
            super.rAgi = 252;
            //Status Base
            super.MINintegrity = 220;
            super.MAXintegrity = 235;
            super.MINatkMin = 107;
            super.MAXatkMin = 112;
            super.MINatkMax = 128;
            super.MAXatkMax = 132;
            super.range = 295;
            super.atkSpd = 8;
            super.MINatkRtg = 234;
            super.MAXatkRtg = 268;
            super.critChance = 21;
            super.MINblock = 8;
            super.MAXblock = 8;
            //Status Spec
            super.sCritChance = 4;
            super.sRange = 30;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;
            super.sDivAtkPow = 7;
            super.classSpec[0] = "Archer";
            super.classSpec[1] = "Mechanician";
            super.classSpec[2] = "Atalanta";
            super.classSpec[3] = "No Spec";
            //Misc
            super.weight = 90;
            super.price = 2780000;
            super.itemLore = "";

            
            break;
            
            case "122-Fatal Hand CrossBow":
            //Identificaçao item
            super.itemClass = "Ranged";
            super.itemType = "Bow";
            super.itemName = "Fatal Hand Crossbow";
            super.itemImgDir = "/assets/item/weapon/bow/122.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 122;
            super.rStr = 80;
            super.rSpi = 40;
            super.rTal = 80;
            super.rAgi = 218;
            //Status Base
            super.MINintegrity = 182;
            super.MAXintegrity = 196;
            super.MINatkMin = 62;
            super.MAXatkMin = 65;
            super.MINatkMax = 85;
            super.MAXatkMax = 88;
            super.range = 280;
            super.atkSpd = 8;
            super.MINatkRtg = 199;
            super.MAXatkRtg = 218;
            super.critChance = 18;
            super.MINblock = 0;
            super.MAXblock = 0;
            //Status Spec
            super.sCritChance = 4;
            super.sRange = 25;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;
            super.sDivAtkPow = 7;
            super.classSpec[0] = "Archer";
            super.classSpec[1] = "Mechanician";
            super.classSpec[2] = "Atalanta";
            super.classSpec[3] = "No Spec";
            //Misc
            super.weight = 68;
            super.price = 1950000;
            super.itemLore = "";

            
            break;
            
            //Javelin
            
            case "142-Strider Javelin":
            //Identificaçao item
            super.itemClass = "Ranged";
            super.itemType = "Javelin";
            super.itemName = "Strider Javelin";
            super.itemImgDir = "/assets/item/weapon/javelin/142.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 142;
            super.rStr = 135;
            super.rTal = 90;
            super.rAgi = 250;
            //Status Base
            super.MINintegrity = 227;
            super.MAXintegrity = 252;
            super.MINatkMin = 98;
            super.MAXatkMin = 102;
            super.MINatkMax = 121;
            super.MAXatkMax = 126;
            super.range = 260;
            super.atkSpd = 8;
            super.MINatkRtg = 302;
            super.MAXatkRtg = 320;
            super.critChance = 18;
            super.MINblock = 0;
            super.MAXblock = 0;
            //Status Spec
            super.sCritChance = 5;
            super.sRange = 20;
            super.sDivAtkPow = 6;
            super.classSpec[0] = "Atalanta";
            super.classSpec[1] = "Mechanician";
            super.classSpec[2] = "Archer";
            super.classSpec[3] = "Assassin";
            super.classSpec[4] = "No Spec";
            //Misc
            super.weight = 68;
            super.price = 2880000;
            super.itemLore = "";

            
            break;
            
            case "138-Ophidian Javelin":
            //Identificaçao item
            super.itemClass = "Ranged";
            super.itemType = "Javelin";
            super.itemName = "Ophidian Javelin";
            super.itemImgDir = "/assets/item/weapon/javelin/138.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 138;
            super.rStr = 130;
            super.rTal = 90;
            super.rAgi = 240;
            //Status Base
            super.MINintegrity = 215;
            super.MAXintegrity = 240;
            super.MINatkMin = 96;
            super.MAXatkMin = 100;
            super.MINatkMax = 116;
            super.MAXatkMax = 120;
            super.range = 250;
            super.atkSpd = 8;
            super.MINatkRtg = 269;
            super.MAXatkRtg = 286;
            super.critChance = 18;
            super.MINblock = 0;
            super.MAXblock = 0;
            //Status Spec
            super.sCritChance = 5;
            super.sRange = 20;
            super.sDivAtkPow = 6;
            super.classSpec[0] = "Atalanta";
            super.classSpec[1] = "Mechanician";
            super.classSpec[2] = "Archer";
            super.classSpec[3] = "Assassin";
            super.classSpec[4] = "No Spec";
            //Misc
            super.weight = 63;
            super.price = 2480000;
            super.itemLore = "";

            
            break;
            
            //Wands
            
            case "142-Rapture Staff":
            //Identificaçao item
            super.itemClass = "Magic";
            super.itemType = "Wand";
            super.itemName = "Rapture Staff";
            super.itemImgDir = "/assets/item/weapon/wand/142.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = TWOHANDED;
            //Requerimentos
            super.rLvl = 142;
            super.rStr = 70;
            super.rSpi = 480;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 240;
            super.MAXintegrity = 240;
            super.MINatkMin = 126;
            super.MAXatkMin = 130;
            super.MINatkMax = 137;
            super.MAXatkMax = 141;
            super.range = 210;
            super.atkSpd = 8;
            super.MINatkRtg = 270;
            super.MAXatkRtg = 290;
            super.critChance = 19;
            super.MINblock = 11;
            super.MAXblock = 11;
            //Status Spec
            super.sMINmagicAPT = 17;
            super.sMAXmagicAPT = 20;
            super.sMINDivAtkRtg = 1;
            super.sMAXDivAtkRtg = 3;
            super.sDivAtkPow = 6;
            super.sMINmpReg = 3.8f;
            super.sMAXmpReg = 4.2f;
            super.classSpec[0] = "Priestess";
            super.classSpec[1] = "Magician";
            super.classSpec[2] = "No Spec";
            //Misc
            super.weight = 90;
            super.price = 2390000;
            super.itemLore = "";

            
            break;
            
            case "138-Eternal Wand":
            //Identificaçao item
            super.itemClass = "Magic";
            super.itemType = "Wand";
            super.itemName = "Eternal Wand";
            super.itemImgDir = "/assets/item/weapon/wand/138.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 138;
            super.rStr = 70;
            super.rSpi = 430;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 225;
            super.MAXintegrity = 230;
            super.MINatkMin = 93;
            super.MAXatkMin = 100;
            super.MINatkMax = 104;
            super.MAXatkMax = 109;
            super.range = 205;
            super.atkSpd = 8;
            super.MINatkRtg = 268;
            super.MAXatkRtg = 291;
            super.critChance = 18;
            super.MINblock = 0;
            super.MAXblock = 0;
            //Status Spec
            super.sMINmagicAPT = 13;
            super.sMAXmagicAPT = 18;
            super.sDivAtkPow = 7;
            super.sMINmpReg = 1.7f;
            super.sMAXmpReg = 2f;
            super.classSpec[0] = "Priestess";
            super.classSpec[1] = "Magician";
            super.classSpec[2] = "No Spec";
            //Misc
            super.weight = 68;
            super.price = 2240000;
            super.itemLore = "";

            
            break;
            
            case "134-Corrupted Staff":
            //Identificaçao item
            super.itemClass = "Magic";
            super.itemType = "Wand";
            super.itemName = "Corrupted Staff";
            super.itemImgDir = "/assets/item/weapon/wand/134.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = TWOHANDED;
            //Requerimentos
            super.rLvl = 134;
            super.rStr = 70;
            super.rSpi = 420;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 220;
            super.MAXintegrity = 230;
            super.MINatkMin = 112;
            super.MAXatkMin = 116;
            super.MINatkMax = 123;
            super.MAXatkMax = 127;
            super.range = 210;
            super.atkSpd = 8;
            super.MINatkRtg = 248;
            super.MAXatkRtg = 266;
            super.critChance = 19;
            super.MINblock = 10;
            super.MAXblock = 10;
            //Status Spec
            super.sMINmagicAPT = 16;
            super.sMAXmagicAPT = 19;
            super.sDivAtkPow = 6;
            super.sMINmpReg = 3.5f;
            super.sMAXmpReg = 3.9f;
            super.classSpec[0] = "Priestess";
            super.classSpec[1] = "Magician";
            super.classSpec[2] = "No Spec";
            //Misc
            super.weight = 80;
            super.price = 1980000;
            super.itemLore = "";

            
            break;
            
            case "122-Crystal Wand":
            //Identificaçao item
            super.itemClass = "Magic";
            super.itemType = "Wand";
            super.itemName = "Crystal Wand";
            super.itemImgDir = "/assets/item/weapon/wand/122.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 122;
            super.rStr = 70;
            super.rSpi = 270;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 190;
            super.MAXintegrity = 200;
            super.MINatkMin = 57;
            super.MAXatkMin = 60;
            super.MINatkMax = 64;
            super.MAXatkMax = 66;
            super.range = 200;
            super.atkSpd = 8;
            super.MINatkRtg = 184;
            super.MAXatkRtg = 194;
            super.critChance = 17;
            super.MINblock = 0;
            super.MAXblock = 0;
            //Status Spec
            super.sMINmagicAPT = 12;
            super.sMAXmagicAPT = 15;
            super.sDivAtkPow = 7;
            super.sMINmpReg = 1.6f;
            super.sMAXmpReg = 1.9f;
            super.classSpec[0] = "Priestess";
            super.classSpec[1] = "Magician";
            super.classSpec[2] = "No Spec";
            //Misc
            super.weight = 49;
            super.price = 1500000;
            super.itemLore = "";

            
            break;
            
            //Phantom
            
            case "142-Ethereal Phantom":
            //Identificaçao item
            super.itemClass = "Magic";
            super.itemType = "Phantom";
            super.itemName = "142-Ethereal Phantom";
            super.itemImgDir = "/assets/item/weapon/phantom/142.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 142;
            super.rStr = 70;
            super.rSpi = 500;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 240;
            super.MAXintegrity = 250;
            super.MINatkMin = 101;
            super.MAXatkMin = 105;
            super.MINatkMax = 112;
            super.MAXatkMax = 116;
            super.range = 220;
            super.atkSpd = 8;
            super.MINatkRtg = 295;
            super.MAXatkRtg = 315;
            super.critChance = 16;
            super.MINhp = 133;
            super.MAXhp = 137;
            //Status Spec
            super.sMINmagicAPT = 18;
            super.sMAXmagicAPT = 21;
            super.sDivAtkPow = 7;
            super.sMINmpReg = 3.9f;
            super.sMAXmpReg = 4.2f;
            super.classSpec[0] = "Shaman";
            super.classSpec[1] = "No Spec";
            //Misc
            super.weight = 111;
            super.price = 2800000;
            super.itemLore = "";

            
            break;
            
            case "138-Psionic Phantom":
            //Identificaçao item
            super.itemClass = "Magic";
            super.itemType = "Phantom";
            super.itemName = "142-Psionic Phantom";
            super.itemImgDir = "/assets/item/weapon/phantom/138.png";
            super.itemIconDir = "";
            super.oneOrTwoHanded = ONEHANDED;
            //Requerimentos
            super.rLvl = 138;
            super.rStr = 70;
            super.rSpi = 460;
            super.rTal = 90;
            //Status Base
            super.MINintegrity = 230;
            super.MAXintegrity = 240;
            super.MINatkMin = 96;
            super.MAXatkMin = 100;
            super.MINatkMax = 106;
            super.MAXatkMax = 111;
            super.range = 220;
            super.atkSpd = 8;
            super.MINatkRtg = 265;
            super.MAXatkRtg = 285;
            super.critChance = 15;
            super.MINhp = 130;
            super.MAXhp = 135;
            //Status Spec
            super.sMINmagicAPT = 18;
            super.sMAXmagicAPT = 20;
            super.sDivAtkPow = 7;
            super.sMINmpReg = 3.7f;
            super.sMAXmpReg = 4.1f;
            super.classSpec[0] = "Shaman";
            super.classSpec[1] = "No Spec";
            //Misc
            super.weight = 97;
            super.price = 2390000;
            super.itemLore = "";

            
            break;
        }
        
    }
}
