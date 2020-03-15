/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.weapon;

import item.Item;

/**
 *
 * @author Luiz
 */
public class ItemWand extends Item {

    public ItemWand(String name) {
        
        super.itemCanAge = true;
        
        switch (name) {
            case "0-Wand":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Wand";
super.itemImgDir = "/assets/item/weapon/ITWM101.BMP";
super.itemIconDir = ICON_ONE_HANDED_WAND;
super.oneOrTwoHanded = ONE_HANDED;
super.MINintegrity = 18;
super.MAXintegrity = 34;
super.MINatkMin = 1;
super.MAXatkMin = 1;
super.MINatkMax = 3;
super.MAXatkMax = 4;
super.range = 140;
super.atkSpd = 7;
super.MINatkRtg = 20;
super.MAXatkRtg = 25;
super.critChance = 2;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 3;
super.sMAXmagicAPT = 4;
super.sDivAtkPow = 7;
super.sMINmpReg = 0.2f;
super.sMAXmpReg = 0.4f;
super.Display = 1;
super.weight = 2;
super.price = 70;
super.itemLore = "";
break;

case "0-Sphere Wand":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Sphere Wand";
super.itemImgDir = "/assets/item/weapon/ITWM102.BMP";
super.itemIconDir = ICON_ONE_HANDED_WAND;
super.oneOrTwoHanded = ONE_HANDED;
super.MINintegrity = 30;
super.MAXintegrity = 48;
super.MINatkMin = 2;
super.MAXatkMin = 2;
super.MINatkMax = 4;
super.MAXatkMax = 5;
super.range = 140;
super.atkSpd = 7;
super.MINatkRtg = 26;
super.MAXatkRtg = 31;
super.critChance = 3;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 2;
super.sMAXmagicAPT = 4;
super.sDivAtkPow = 7;
super.sMINmpReg = 0.2f;
super.sMAXmpReg = 0.4f;
super.Display = 1;
super.weight = 3;
super.price = 480;
super.itemLore = "";
break;

case "0-Obi Wand":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Obi Wand";
super.itemImgDir = "/assets/item/weapon/ITWM103.BMP";
super.itemIconDir = ICON_ONE_HANDED_WAND;
super.oneOrTwoHanded = ONE_HANDED;
super.rSpi = 40;
super.MINintegrity = 27;
super.MAXintegrity = 44;
super.MINatkMin = 3;
super.MAXatkMin = 4;
super.MINatkMax = 6;
super.MAXatkMax = 7;
super.range = 145;
super.atkSpd = 7;
super.MINatkRtg = 30;
super.MAXatkRtg = 36;
super.critChance = 4;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 2;
super.sMAXmagicAPT = 4;
super.sDivAtkPow = 7;
super.sMINmpReg = 0.2f;
super.sMAXmpReg = 0.5f;
super.Display = 1;
super.weight = 3;
super.price = 800;
super.itemLore = "";
break;

case "0-Halloween Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Halloween Staff";
super.itemImgDir = "/assets/item/weapon/ITWM381.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.classSpec = new String[]{NS};
super.sMINmpReg = 0f;
super.sMAXmpReg = 0f;
super.Duration = 120;
super.itemLore = "";
break;

case "0-Halloween Wand":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Halloween Wand";
super.itemImgDir = "/assets/item/weapon/ITWM382.BMP";
super.itemIconDir = ICON_ONE_HANDED_WAND;
super.oneOrTwoHanded = ONE_HANDED;
super.classSpec = new String[]{NS};
super.sMINmpReg = 0f;
super.sMAXmpReg = 0f;
super.Duration = 120;
super.itemLore = "";
break;

case "0-Xmas Wand":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Xmas Wand";
super.itemImgDir = "/assets/item/weapon/ITWM383.BMP";
super.itemIconDir = ICON_ONE_HANDED_WAND;
super.oneOrTwoHanded = ONE_HANDED;
super.classSpec = new String[]{NS};
super.sMINmpReg = 0f;
super.sMAXmpReg = 0f;
super.Duration = 120;
super.itemLore = "";
break;

case "6-Root Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Root Staff";
super.itemImgDir = "/assets/item/weapon/ITWM104.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 7;
super.rSpi = 40;
super.rTal = 27;
super.MINintegrity = 38;
super.MAXintegrity = 55;
super.MINatkMin = 5;
super.MAXatkMin = 6;
super.MINatkMax = 8;
super.MAXatkMax = 9;
super.range = 160;
super.atkSpd = 7;
super.MINatkRtg = 32;
super.MAXatkRtg = 38;
super.critChance = 5;
super.MINblock = 3;
super.MAXblock = 3;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 2;
super.sMAXmagicAPT = 4;
super.sDivAtkPow = 6;
super.sMINmpReg = 0.6f;
super.sMAXmpReg = 0.8f;
super.Display = 1;
super.weight = 5;
super.price = 1500;
super.itemLore = "";
break;

case "11-Poly Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Poly Staff";
super.itemImgDir = "/assets/item/weapon/ITWM105.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 11;
super.rSpi = 53;
super.rTal = 30;
super.MINintegrity = 40;
super.MAXintegrity = 50;
super.MINatkMin = 7;
super.MAXatkMin = 8;
super.MINatkMax = 11;
super.MAXatkMax = 13;
super.range = 160;
super.atkSpd = 7;
super.MINatkRtg = 30;
super.MAXatkRtg = 40;
super.critChance = 5;
super.MINblock = 3;
super.MAXblock = 3;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 3;
super.sMAXmagicAPT = 5;
super.sDivAtkPow = 6;
super.sMINmpReg = 0.7f;
super.sMAXmpReg = 0.9f;
super.Display = 1;
super.weight = 7;
super.price = 3700;
super.itemLore = "";
break;

case "16-Elven Wand":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Elven Wand";
super.itemImgDir = "/assets/item/weapon/ITWM106.BMP";
super.itemIconDir = ICON_ONE_HANDED_WAND;
super.oneOrTwoHanded = ONE_HANDED;
super.rLvl = 16;
super.rSpi = 62;
super.rTal = 36;
super.MINintegrity = 32;
super.MAXintegrity = 44;
super.MINatkMin = 6;
super.MAXatkMin = 7;
super.MINatkMax = 9;
super.MAXatkMax = 11;
super.range = 150;
super.atkSpd = 8;
super.MINatkRtg = 34;
super.MAXatkRtg = 44;
super.critChance = 4;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 3;
super.sMAXmagicAPT = 5;
super.sDivAtkPow = 7;
super.sMINmpReg = 0.3f;
super.sMAXmpReg = 0.6f;
super.Display = 1;
super.weight = 5;
super.price = 7000;
super.itemLore = "";
break;

case "22-Dryad Wand":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Dryad Wand";
super.itemImgDir = "/assets/item/weapon/ITWM107.BMP";
super.itemIconDir = ICON_ONE_HANDED_WAND;
super.oneOrTwoHanded = ONE_HANDED;
super.rLvl = 22;
super.rSpi = 70;
super.rTal = 36;
super.MINintegrity = 38;
super.MAXintegrity = 50;
super.MINatkMin = 7;
super.MAXatkMin = 9;
super.MINatkMax = 10;
super.MAXatkMax = 12;
super.range = 150;
super.atkSpd = 8;
super.MINatkRtg = 38;
super.MAXatkRtg = 50;
super.critChance = 5;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 3;
super.sMAXmagicAPT = 5;
super.sDivAtkPow = 7;
super.sMINmpReg = 0.3f;
super.sMAXmpReg = 0.6f;
super.Display = 1;
super.weight = 5;
super.price = 12000;
super.itemLore = "";
break;

case "30-Meditation Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Meditation Staff";
super.itemImgDir = "/assets/item/weapon/ITWM108.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 30;
super.rStr = 35;
super.rSpi = 65;
super.rTal = 36;
super.MINintegrity = 44;
super.MAXintegrity = 58;
super.MINatkMin = 8;
super.MAXatkMin = 10;
super.MINatkMax = 12;
super.MAXatkMax = 15;
super.range = 165;
super.atkSpd = 8;
super.MINatkRtg = 43;
super.MAXatkRtg = 54;
super.critChance = 6;
super.MINblock = 5;
super.MAXblock = 5;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 4;
super.sMAXmagicAPT = 6;
super.sDivAtkPow = 6;
super.sMINmpReg = 0.8f;
super.sMAXmpReg = 1f;
super.Display = 1;
super.weight = 7;
super.price = 19000;
super.itemLore = "";
break;

case "37-Skull Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Skull Staff";
super.itemImgDir = "/assets/item/weapon/ITWM109.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 37;
super.rStr = 40;
super.rSpi = 70;
super.rTal = 42;
super.MINintegrity = 52;
super.MAXintegrity = 66;
super.MINatkMin = 10;
super.MAXatkMin = 12;
super.MINatkMax = 15;
super.MAXatkMax = 17;
super.range = 165;
super.atkSpd = 8;
super.MINatkRtg = 52;
super.MAXatkRtg = 66;
super.critChance = 6;
super.MINblock = 4;
super.MAXblock = 4;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 4;
super.sMAXmagicAPT = 6;
super.sDivAtkPow = 6;
super.sMINmpReg = 1f;
super.sMAXmpReg = 1.3f;
super.Display = 1;
super.weight = 7;
super.price = 27000;
super.itemLore = "";
break;

case "40-Ghost":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Ghost";
super.itemImgDir = "/assets/item/weapon/ITWM109.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 40;
super.MINintegrity = 100;
super.MAXintegrity = 100;
super.MINatkMin = 16;
super.MAXatkMin = 16;
super.MINatkMax = 22;
super.MAXatkMax = 22;
super.range = 175;
super.atkSpd = 8;
super.MINatkRtg = 100;
super.MAXatkRtg = 100;
super.critChance = 6;
super.MINblock = 4;
super.MAXblock = 4;
super.MINmpReg = 1.5f;
super.MAXmpReg = 1.5f;
super.classSpec = new String[]{NS};
super.sDivAtkPow = 6;
super.sMINmpReg = 0f;
super.sMAXmpReg = 0f;
super.Display = 1;
super.weight = 7;
super.price = 30000;
super.itemLore = "";
break;

case "44-Mage Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Mage Staff";
super.itemImgDir = "/assets/item/weapon/ITWM110.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 44;
super.rStr = 44;
super.rSpi = 75;
super.rTal = 47;
super.MINintegrity = 58;
super.MAXintegrity = 74;
super.MINatkMin = 12;
super.MAXatkMin = 14;
super.MINatkMax = 17;
super.MAXatkMax = 19;
super.range = 170;
super.atkSpd = 8;
super.MINatkRtg = 58;
super.MAXatkRtg = 74;
super.critChance = 7;
super.MINblock = 6;
super.MAXblock = 6;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 3;
super.sMAXmagicAPT = 6;
super.sDivAtkPow = 6;
super.sMINmpReg = 1.1f;
super.sMAXmpReg = 1.4f;
super.Display = 1;
super.weight = 10;
super.price = 39000;
super.itemLore = "";
break;

case "50-Faith Wand":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Faith Wand";
super.itemImgDir = "/assets/item/weapon/ITWM111.BMP";
super.itemIconDir = ICON_ONE_HANDED_WAND;
super.oneOrTwoHanded = ONE_HANDED;
super.rLvl = 50;
super.rSpi = 90;
super.rTal = 60;
super.MINintegrity = 54;
super.MAXintegrity = 72;
super.MINatkMin = 10;
super.MAXatkMin = 12;
super.MINatkMax = 14;
super.MAXatkMax = 16;
super.range = 155;
super.atkSpd = 8;
super.MINatkRtg = 50;
super.MAXatkRtg = 70;
super.critChance = 6;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 4;
super.sMAXmagicAPT = 6;
super.sDivAtkPow = 7;
super.sMINmpReg = 0.4f;
super.sMAXmpReg = 0.8f;
super.Display = 1;
super.weight = 9;
super.price = 46000;
super.itemLore = "";
break;

case "55-Lofty Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Lofty Staff";
super.itemImgDir = "/assets/item/weapon/ITWM112.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 55;
super.rSpi = 100;
super.rTal = 70;
super.MINintegrity = 64;
super.MAXintegrity = 82;
super.MINatkMin = 15;
super.MAXatkMin = 18;
super.MINatkMax = 20;
super.MAXatkMax = 23;
super.range = 170;
super.atkSpd = 8;
super.MINatkRtg = 72;
super.MAXatkRtg = 90;
super.critChance = 8;
super.MINblock = 7;
super.MAXblock = 7;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 4;
super.sMAXmagicAPT = 7;
super.sDivAtkPow = 6;
super.sMINmpReg = 1.2f;
super.sMAXmpReg = 1.5f;
super.Display = 1;
super.weight = 12;
super.price = 54000;
super.itemLore = "";
break;

case "60-Arch Wand":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Arch Wand";
super.itemImgDir = "/assets/item/weapon/ITWM113.BMP";
super.itemIconDir = ICON_ONE_HANDED_WAND;
super.oneOrTwoHanded = ONE_HANDED;
super.rLvl = 60;
super.rSpi = 115;
super.rTal = 80;
super.MINintegrity = 64;
super.MAXintegrity = 82;
super.MINatkMin = 10;
super.MAXatkMin = 13;
super.MINatkMax = 16;
super.MAXatkMax = 19;
super.range = 155;
super.atkSpd = 8;
super.MINatkRtg = 65;
super.MAXatkRtg = 84;
super.critChance = 7;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 3;
super.sMAXmagicAPT = 7;
super.sDivAtkPow = 7;
super.sMINmpReg = 0.5f;
super.sMAXmpReg = 0.8f;
super.Display = 1;
super.weight = 12;
super.price = 63000;
super.itemLore = "";
break;

case "65-Chaos Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Chaos Staff";
super.itemImgDir = "/assets/item/weapon/ITWM114.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 65;
super.rStr = 50;
super.rSpi = 125;
super.rTal = 80;
super.MINintegrity = 55;
super.MAXintegrity = 70;
super.MINatkMin = 16;
super.MAXatkMin = 19;
super.MINatkMax = 24;
super.MAXatkMax = 27;
super.range = 175;
super.atkSpd = 8;
super.MINatkRtg = 78;
super.MAXatkRtg = 98;
super.critChance = 8;
super.MINblock = 6;
super.MAXblock = 6;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 4;
super.sMAXmagicAPT = 7;
super.sDivAtkPow = 6;
super.sMINmpReg = 1.3f;
super.sMAXmpReg = 1.6f;
super.Display = 1;
super.weight = 16;
super.price = 72000;
super.itemLore = "";
break;

case "70-Rune Wand":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Rune Wand";
super.itemImgDir = "/assets/item/weapon/ITWM115.BMP";
super.itemIconDir = ICON_ONE_HANDED_WAND;
super.oneOrTwoHanded = ONE_HANDED;
super.rLvl = 70;
super.rStr = 50;
super.rSpi = 132;
super.rTal = 84;
super.MINintegrity = 72;
super.MAXintegrity = 92;
super.MINatkMin = 12;
super.MAXatkMin = 15;
super.MINatkMax = 17;
super.MAXatkMax = 20;
super.range = 180;
super.atkSpd = 8;
super.MINatkRtg = 100;
super.MAXatkRtg = 125;
super.critChance = 7;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 4;
super.sMAXmagicAPT = 7;
super.sDivAtkPow = 7;
super.sMINmpReg = 0.6f;
super.sMAXmpReg = 0.9f;
super.Display = 1;
super.weight = 14;
super.price = 80000;
super.itemLore = "";
break;

case "75-Rune Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Rune Staff";
super.itemImgDir = "/assets/item/weapon/ITWM116.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 75;
super.rStr = 50;
super.rSpi = 140;
super.rTal = 86;
super.MINintegrity = 80;
super.MAXintegrity = 100;
super.MINatkMin = 22;
super.MAXatkMin = 24;
super.MINatkMax = 28;
super.MAXatkMax = 30;
super.range = 185;
super.atkSpd = 8;
super.MINatkRtg = 110;
super.MAXatkRtg = 130;
super.critChance = 9;
super.MINblock = 7;
super.MAXblock = 7;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 5;
super.sMAXmagicAPT = 8;
super.sDivAtkPow = 6;
super.sMINmpReg = 1.5f;
super.sMAXmpReg = 1.8f;
super.Display = 1;
super.weight = 20;
super.price = 160000;
super.itemLore = "";
break;

case "80-Apostle Wand":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Apostle Wand";
super.itemImgDir = "/assets/item/weapon/ITWM117.BMP";
super.itemIconDir = ICON_ONE_HANDED_WAND;
super.oneOrTwoHanded = ONE_HANDED;
super.rLvl = 80;
super.rStr = 55;
super.rSpi = 146;
super.rTal = 88;
super.MINintegrity = 90;
super.MAXintegrity = 108;
super.MINatkMin = 20;
super.MAXatkMin = 23;
super.MINatkMax = 29;
super.MAXatkMax = 31;
super.range = 165;
super.atkSpd = 8;
super.MINatkRtg = 118;
super.MAXatkRtg = 140;
super.critChance = 8;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 5;
super.sMAXmagicAPT = 8;
super.sDivAtkPow = 7;
super.sMINmpReg = 0.7f;
super.sMAXmpReg = 1f;
super.Display = 1;
super.weight = 20;
super.price = 260000;
super.itemLore = "";
break;

case "84-Relic Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Relic Staff";
super.itemImgDir = "/assets/item/weapon/ITWM118.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 84;
super.rStr = 60;
super.rSpi = 154;
super.rTal = 88;
super.MINintegrity = 98;
super.MAXintegrity = 116;
super.MINatkMin = 28;
super.MAXatkMin = 30;
super.MINatkMax = 35;
super.MAXatkMax = 38;
super.range = 190;
super.atkSpd = 8;
super.MINatkRtg = 130;
super.MAXatkRtg = 148;
super.critChance = 10;
super.MINblock = 8;
super.MAXblock = 8;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 5;
super.sMAXmagicAPT = 9;
super.sDivAtkPow = 6;
super.sMINmpReg = 1.7f;
super.sMAXmpReg = 2.1f;
super.Display = 1;
super.weight = 28;
super.price = 420000;
super.itemLore = "";
break;

case "88-Dragon Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Dragon Staff";
super.itemImgDir = "/assets/item/weapon/ITWM119.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 88;
super.rStr = 65;
super.rSpi = 162;
super.rTal = 90;
super.MINintegrity = 110;
super.MAXintegrity = 125;
super.MINatkMin = 32;
super.MAXatkMin = 35;
super.MINatkMax = 40;
super.MAXatkMax = 42;
super.range = 195;
super.atkSpd = 8;
super.MINatkRtg = 137;
super.MAXatkRtg = 155;
super.critChance = 11;
super.MINblock = 8;
super.MAXblock = 8;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 6;
super.sMAXmagicAPT = 9;
super.sDivAtkPow = 6;
super.sMINmpReg = 1.8f;
super.sMAXmpReg = 2.1f;
super.Display = 1;
super.weight = 32;
super.price = 700000;
super.itemLore = "";
break;

case "92-Wyvern Wand":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Wyvern Wand";
super.itemImgDir = "/assets/item/weapon/ITWM120.BMP";
super.itemIconDir = ICON_ONE_HANDED_WAND;
super.oneOrTwoHanded = ONE_HANDED;
super.rLvl = 92;
super.rStr = 70;
super.rSpi = 170;
super.rTal = 90;
super.MINintegrity = 122;
super.MAXintegrity = 134;
super.MINatkMin = 28;
super.MAXatkMin = 30;
super.MINatkMax = 37;
super.MAXatkMax = 39;
super.range = 180;
super.atkSpd = 8;
super.MINatkRtg = 146;
super.MAXatkRtg = 164;
super.critChance = 10;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 6;
super.sMAXmagicAPT = 9;
super.sDivAtkPow = 7;
super.sMINmpReg = 0.9f;
super.sMAXmpReg = 1.2f;
super.Display = 1;
super.weight = 27;
super.price = 800000;
super.itemLore = "";
break;

case "96-Astral Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Astral Staff";
super.itemImgDir = "/assets/item/weapon/ITWM121.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 96;
super.rStr = 70;
super.rSpi = 190;
super.rTal = 90;
super.MINintegrity = 130;
super.MAXintegrity = 140;
super.MINatkMin = 38;
super.MAXatkMin = 41;
super.MINatkMax = 46;
super.MAXatkMax = 49;
super.range = 200;
super.atkSpd = 8;
super.MINatkRtg = 168;
super.MAXatkRtg = 176;
super.critChance = 12;
super.MINblock = 8;
super.MAXblock = 8;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 9;
super.sMAXmagicAPT = 11;
super.sDivAtkPow = 6;
super.sMINmpReg = 2f;
super.sMAXmpReg = 2.3f;
super.Display = 1;
super.weight = 37;
super.price = 950000;
super.itemLore = "";
break;

case "100-Cribal Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Cribal Staff";
super.itemImgDir = "/assets/item/weapon/ITWM301.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 100;
super.rStr = 70;
super.rSpi = 190;
super.rTal = 90;
super.MINintegrity = 144;
super.MAXintegrity = 195;
super.MINatkMin = 42;
super.MAXatkMin = 47;
super.MINatkMax = 51;
super.MAXatkMax = 54;
super.range = 205;
super.atkSpd = 8;
super.MINatkRtg = 171;
super.MAXatkRtg = 181;
super.critChance = 13;
super.MINblock = 8;
super.MAXblock = 8;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 9;
super.sMAXmagicAPT = 11;
super.sDivAtkPow = 6;
super.sMINmpReg = 2.1f;
super.sMAXmpReg = 2.4f;
super.Display = 1;
super.weight = 38;
super.price = 950000;
super.itemLore = "";
break;

case "104-Oracle Wand":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Oracle Wand";
super.itemImgDir = "/assets/item/weapon/ITWM122.BMP";
super.itemIconDir = ICON_ONE_HANDED_WAND;
super.oneOrTwoHanded = ONE_HANDED;
super.rLvl = 104;
super.rStr = 70;
super.rSpi = 185;
super.rTal = 90;
super.MINintegrity = 140;
super.MAXintegrity = 150;
super.MINatkMin = 37;
super.MAXatkMin = 40;
super.MINatkMax = 44;
super.MAXatkMax = 46;
super.range = 195;
super.atkSpd = 8;
super.MINatkRtg = 164;
super.MAXatkRtg = 174;
super.critChance = 12;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 8;
super.sMAXmagicAPT = 12;
super.sDivAtkPow = 7;
super.sMINmpReg = 1.1f;
super.sMAXmpReg = 1.4f;
super.Display = 1;
super.weight = 34;
super.price = 1000000;
super.itemLore = "";
break;

case "106-Blessed Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Blessed Staff";
super.itemImgDir = "/assets/item/weapon/ITWM303.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 106;
super.rStr = 70;
super.rSpi = 195;
super.rTal = 90;
super.MINintegrity = 150;
super.MAXintegrity = 160;
super.MINatkMin = 48;
super.MAXatkMin = 52;
super.MINatkMax = 56;
super.MAXatkMax = 59;
super.range = 205;
super.atkSpd = 8;
super.MINatkRtg = 173;
super.MAXatkRtg = 183;
super.critChance = 14;
super.MINblock = 8;
super.MAXblock = 8;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 10;
super.sMAXmagicAPT = 13;
super.sDivAtkPow = 6;
super.sMINmpReg = 2.2f;
super.sMAXmpReg = 2.6f;
super.Display = 1;
super.weight = 40;
super.price = 1100000;
super.itemLore = "";
break;

case "110-Celestial Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Celestial Staff";
super.itemImgDir = "/assets/item/weapon/ITWM123.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 110;
super.rStr = 70;
super.rSpi = 205;
super.rTal = 90;
super.MINintegrity = 160;
super.MAXintegrity = 170;
super.MINatkMin = 60;
super.MAXatkMin = 64;
super.MINatkMax = 72;
super.MAXatkMax = 75;
super.range = 210;
super.atkSpd = 8;
super.MINatkRtg = 180;
super.MAXatkRtg = 194;
super.critChance = 15;
super.MINblock = 9;
super.MAXblock = 9;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 11;
super.sMAXmagicAPT = 14;
super.sDivAtkPow = 6;
super.sMINmpReg = 2.4f;
super.sMAXmpReg = 2.8f;
super.Display = 1;
super.weight = 44;
super.price = 1250000;
super.itemLore = "";
break;

case "114-Mystic Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Mystic Staff";
super.itemImgDir = "/assets/item/weapon/ITWM304.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 114;
super.rStr = 70;
super.rSpi = 240;
super.rTal = 90;
super.MINintegrity = 170;
super.MAXintegrity = 180;
super.MINatkMin = 70;
super.MAXatkMin = 74;
super.MINatkMax = 82;
super.MAXatkMax = 85;
super.range = 210;
super.atkSpd = 8;
super.MINatkRtg = 186;
super.MAXatkRtg = 200;
super.critChance = 16;
super.MINblock = 9;
super.MAXblock = 9;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 12;
super.sMAXmagicAPT = 15;
super.sDivAtkPow = 6;
super.sMINmpReg = 2.6f;
super.sMAXmpReg = 3f;
super.Display = 1;
super.weight = 48;
super.price = 1325000;
super.itemLore = "";
break;

case "116-Brutal Wand":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Brutal Wand";
super.itemImgDir = "/assets/item/weapon/ITWM305.BMP";
super.itemIconDir = ICON_ONE_HANDED_WAND;
super.oneOrTwoHanded = ONE_HANDED;
super.rLvl = 116;
super.rStr = 70;
super.rSpi = 200;
super.rTal = 90;
super.MINintegrity = 155;
super.MAXintegrity = 165;
super.MINatkMin = 44;
super.MAXatkMin = 48;
super.MINatkMax = 50;
super.MAXatkMax = 52;
super.range = 200;
super.atkSpd = 8;
super.MINatkRtg = 174;
super.MAXatkRtg = 184;
super.critChance = 15;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 9;
super.sMAXmagicAPT = 13;
super.sDivAtkPow = 7;
super.sMINmpReg = 1.2f;
super.sMAXmpReg = 1.5f;
super.Display = 1;
super.weight = 36;
super.price = 1150000;
super.itemLore = "";
break;

case "120-Elf Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Elf Staff";
super.itemImgDir = "/assets/item/weapon/ITWM124.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 120;
super.rStr = 70;
super.rSpi = 280;
super.rTal = 90;
super.MINintegrity = 180;
super.MAXintegrity = 190;
super.MINatkMin = 81;
super.MAXatkMin = 85;
super.MINatkMax = 92;
super.MAXatkMax = 96;
super.range = 210;
super.atkSpd = 8;
super.MINatkRtg = 194;
super.MAXatkRtg = 208;
super.critChance = 17;
super.MINblock = 10;
super.MAXblock = 10;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 13;
super.sMAXmagicAPT = 16;
super.sDivAtkPow = 6;
super.sMINmpReg = 2.8f;
super.sMAXmpReg = 3.2f;
super.Display = 1;
super.weight = 52;
super.price = 1450000;
super.itemLore = "";
break;

case "122-Crystal Wand":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Crystal Wand";
super.itemImgDir = "/assets/item/weapon/ITWM306.BMP";
super.itemIconDir = ICON_ONE_HANDED_WAND;
super.oneOrTwoHanded = ONE_HANDED;
super.rLvl = 122;
super.rStr = 70;
super.rSpi = 270;
super.rTal = 90;
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
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 12;
super.sMAXmagicAPT = 15;
super.sDivAtkPow = 7;
super.sMINmpReg = 1.6f;
super.sMAXmpReg = 1.9f;
super.Display = 1;
super.weight = 46;
super.price = 1500000;
super.itemLore = "";
break;

case "126-Freyja Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Freyja Staff";
super.itemImgDir = "/assets/item/weapon/ITWM125.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 126;
super.rStr = 70;
super.rSpi = 320;
super.rTal = 90;
super.MINintegrity = 200;
super.MAXintegrity = 210;
super.MINatkMin = 92;
super.MAXatkMin = 96;
super.MINatkMax = 103;
super.MAXatkMax = 107;
super.range = 210;
super.atkSpd = 8;
super.MINatkRtg = 210;
super.MAXatkRtg = 224;
super.critChance = 18;
super.MINblock = 10;
super.MAXblock = 10;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 14;
super.sMAXmagicAPT = 17;
super.sDivAtkPow = 6;
super.sMINmpReg = 3f;
super.sMAXmpReg = 3.4f;
super.Display = 1;
super.weight = 60;
super.price = 1650000;
super.itemLore = "";
break;

case "130-Mythology Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Mythology Staff";
super.itemImgDir = "/assets/item/weapon/ITWM307.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 130;
super.rStr = 70;
super.rSpi = 360;
super.rTal = 90;
super.MINintegrity = 210;
super.MAXintegrity = 220;
super.MINatkMin = 103;
super.MAXatkMin = 107;
super.MINatkMax = 114;
super.MAXatkMax = 118;
super.range = 210;
super.atkSpd = 8;
super.MINatkRtg = 226;
super.MAXatkRtg = 240;
super.critChance = 18;
super.MINblock = 10;
super.MAXblock = 10;
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 15;
super.sMAXmagicAPT = 18;
super.sDivAtkPow = 6;
super.sMINmpReg = 3.2f;
super.sMAXmpReg = 3.6f;
super.Display = 1;
super.weight = 70;
super.price = 1800000;
super.itemLore = "";
break;

case "134-Corrupted Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Corrupted Staff";
super.itemImgDir = "/assets/item/weapon/ITWM129.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 134;
super.rStr = 70;
super.rSpi = 420;
super.rTal = 90;
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
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 16;
super.sMAXmagicAPT = 19;
super.sDivAtkPow = 6;
super.sMINmpReg = 3.5f;
super.sMAXmpReg = 3.9f;
super.Display = 1;
super.weight = 80;
super.price = 1980000;
super.itemLore = "";
break;

case "138-Eternal Wand":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "Eternal Wand";
super.itemImgDir = "/assets/item/weapon/ITWM308.BMP";
super.itemIconDir = ICON_ONE_HANDED_WAND;
super.oneOrTwoHanded = ONE_HANDED;
super.rLvl = 138;
super.rStr = 70;
super.rSpi = 430;
super.rTal = 90;
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
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 13;
super.sMAXmagicAPT = 18;
super.sDivAtkPow = 7;
super.sMINmpReg = 1.7f;
super.sMAXmpReg = 2f;
super.Display = 1;
super.weight = 68;
super.price = 2240000;
super.itemLore = "";
break;

case "142-Rapture Staff":
            //Identificaçao item
            super.itemClass = "Magic";
            super.itemType = "Wand";
            super.itemName = "Rapture Staff";
            super.itemImgDir = "/assets/item/weapon/ITWM309.BMP";
            super.itemIconDir = ICON_ONE_HANDED_WAND;
            super.oneOrTwoHanded = TWO_HANDED;
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
            super.classSpec = new String[]{PRS, MGS, NS};
            //Misc
            super.weight = 90;
            super.price = 2390000;
            super.itemLore = "";
            
            break;

case "160-WM130 Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "WM130 Staff";
super.itemImgDir = "/assets/item/weapon/ITWM130.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 160;
super.rStr = 70;
super.rSpi = 420;
super.rTal = 90;
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
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 16;
super.sMAXmagicAPT = 19;
super.sDivAtkPow = 6;
super.sMINmpReg = 0f;
super.sMAXmpReg = 0f;
super.weight = 80;
super.price = 1980000;
super.itemLore = "";
break;

case "160-WM131 Staff":
super.itemClass = "Magic";
super.itemType = "Wand";
super.itemName = "WM131 Staff";
super.itemImgDir = "/assets/item/weapon/ITWM131.BMP";
super.itemIconDir = ICON_TWO_HANDED_WAND;
super.oneOrTwoHanded = TWO_HANDED;
super.rLvl = 160;
super.rStr = 70;
super.rSpi = 420;
super.rTal = 90;
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
super.classSpec = new String[]{NS};
super.sMINmagicAPT = 16;
super.sMAXmagicAPT = 19;
super.sDivAtkPow = 6;
super.sMINmpReg = 0f;
super.sMAXmpReg = 0f;
super.weight = 80;
super.price = 1980000;
super.itemLore = "";
break;


        }
    }
}
