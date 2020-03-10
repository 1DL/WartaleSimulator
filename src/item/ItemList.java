/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import javax.swing.DefaultListModel;

/**
 *
 * @author LuizV1
 */
public class ItemList {
    
    //Swords
    static String oneHandSword[] = {
        "0-Cutter",
        "0-Celtic Blade",
        "0-Sword Breaker",
        "6-Short Sword",
        "13-Broad Sword",
        "17-Blade",
        "24-Templar Sword",
        "30-Shield Sword",
        "43-Claymore",
        "48-Slayer",
        "70-Ancient Sword",
        "84-Avanger Sword",
        "92-Wyvern Sword",
        "98-Silver Blade",
        "100-Predator",
        "106-Inferno Sword",
        "114-Imperial Sword",
        "122-Relic Sword", 
        "142-Valiant Sword"       
    };
    static String twoHandSword[] = {        
        "9-Long Sword",        
        "37-Plated Sword",
        "40-Platinum Sword",        
        "53-Gigantic Sword",
        "57-Highlander",
        "61-Bastard Sword",
        "65-Fatal Sword",
        "75-Twin Sword",
        "80-Salamander Sword",
        "88-Titan Sword",
        "96-Dragon Sword",
        "104-Justice Sword",
        "110-Extreme Sword",
        "116-Emperor Sword",
        "120-Mirage Sword",
        "126-Tirbing Sword",
        "130-Mythology Sword",
        "134-Deadly Sword",
        "138-Hellbringer Sword"
    };
    static String allSword[] = {
        "0-Cutter",
        "0-Celtic Blade",
        "0-Sword Breaker",
        "6-Short Sword",
        "9-Long Sword",
        "13-Broad Sword",
        "17-Blade",
        "24-Templar Sword",
        "30-Shield Sword",
        "37-Plated Sword",
        "40-Platinum Sword",
        "43-Claymore",
        "48-Slayer",
        "53-Gigantic Sword",
        "57-Highlander",
        "61-Bastard Sword",
        "65-Fatal Sword",
        "70-Ancient Sword",
        "75-Twin Sword",
        "80-Salamander Sword",
        "84-Avanger Sword",
        "88-Titan Sword",
        "92-Wyvern Sword",
        "96-Dragon Sword",
        "98-Silver Blade",
        "100-Predator",
        "104-Justice Sword",
        "106-Inferno Sword",
        "110-Extreme Sword",
        "114-Imperial Sword",
        "116-Emperor Sword",
        "120-Mirage Sword",
        "122-Relic Sword",
        "126-Tirbing Sword",
        "130-Mythology Sword",
        "134-Deadly Sword",
        "138-Hellbringer Sword",
        "142-Valiant Sword"
    };
    //Axes
    static String oneHandAxe[] = {
        "0-Stone Axe",
        "0-Steel Axe",
        "7-Battle Axe",
        "10-War Axe",
        "22-Bat Axe",
        "30-Mechanic Axe",
        "55-Jagged Axe",
        "70-Tomahawk",
        "88-Relic Axe",
        "106-Inferno Axe",
        "122-Gladiator Axe",
        "142-Havoc Axe"
    };
    static String twoHandAxe[] = {
        
        "16-Double Sided War Axe",
        "37-Double Headed Axe",
        "40-Demon Hunter",
        "44-Great Axe",
        "50-Diamond Axe",
        "60-Cleaver",
        "65-Gigantic Axe",
        "75-Titan Axe",
        "80-Chaos Axe",
        "84-Ancient Axe",
        "92-Extreme Axe",
        "96-Fury Axe",
        "98-Shard Axe",
        "100-Shadow Axe",
        "104-Wyvern Axe",
        "110-Zecram Axe",
        "114-Blazing Axe",
        "116-Demolition Axe",
        "120-Dragon Axe",
        "126-Kronos Axe",
        "130-Mythology Axe",
        "134-Deadly Axe",
        "138-Zealous Axe"
    };
    static String allAxe[] = {
        "0-Stone Axe",
        "0-Steel Axe",
        "7-Battle Axe",
        "10-War Axe",
        "16-Double Sided War Axe",
        "22-Bat Axe",
        "30-Mechanic Axe",
        "37-Double Headed Axe",
        "40-Demon Hunter",
        "44-Great Axe",
        "50-Diamond Axe",
        "55-Jagged Axe",
        "60-Cleaver",
        "65-Gigantic Axe",
        "70-Tomahawk",
        "75-Titan Axe",
        "80-Chaos Axe",
        "84-Ancient Axe",
        "88-Relic Axe",
        "92-Extreme Axe",
        "96-Fury Axe",
        "98-Shard Axe",
        "100-Shadow Axe",
        "104-Wyvern Axe",
        "106-Inferno Axe",
        "110-Zecram Axe",
        "114-Blazing Axe",
        "116-Demolition Axe",
        "120-Dragon Axe",
        "122-Gladiator Axe",
        "126-Kronos Axe",
        "130-Mythology Axe",
        "134-Deadly Axe",
        "138-Zealous Axe",
        "142-Havoc Axe"
    };
    //Hammers
    static String oneHandHammer[] = {
        "0-Club",
        "0-War Mace",
        "7-Pole Mace",
        "9-Gothic Mace",
        "12-War Hammer",
        "37-Star",
        "40-Meteorite",
        "54-Rune Hammer",
        "59-Solar",
        "80-Brutal Hammer",
        "95-Justice Hammer",
        "122-Molten Hammer",
        "142-Headcrusher"
    };
    static String twoHandHammer[] = {
        "16-Metal Hammer",
        "22-Cross Hammer",
        "30-Holy Mace",
        "43-Maximum",
        "48-Meditation",
        "64-War Maul",
        "69-Titan Maul",
        "75-Chaos Mace",
        "85-Gladiator Hammer",
        "90-Archon Hammer",
        "100-Extreme Hammer",
        "104-Guardian Hammer",
        "106-Inferno Hammer",
        "110-Bane Hammer",
        "114-Legendary Hammer",
        "116-Destructive Hammer",
        "120-Dragon Hammer",
        "126-Kronos Hammer",
        "130-Mythology Hammer",
        "134-Ruby Hammer",
        "138-Taurus"
    };
    static String allHammer[] = {
        "0-Club",
        "0-War Mace",
        "7-Pole Mace",
        "9-Gothic Mace",
        "12-War Hammer",
        "16-Metal Hammer",
        "22-Cross Hammer",
        "30-Holy Mace",
        "37-Star",
        "40-Meteorite",
        "43-Maximum",
        "48-Meditation",
        "54-Rune Hammer",
        "59-Solar",
        "64-War Maul",
        "69-Titan Maul",
        "75-Chaos Mace",
        "80-Brutal Hammer",
        "85-Gladiator Hammer",
        "90-Archon Hammer",
        "95-Justice Hammer",
        "100-Extreme Hammer",
        "104-Guardian Hammer",
        "106-Inferno Hammer",
        "110-Bane Hammer",
        "114-Legendary Hammer",
        "116-Destructive Hammer",
        "120-Dragon Hammer",
        "122-Molten Hammer",
        "126-Kronos Hammer",
        "130-Mythology Hammer",
        "134-Ruby Hammer",
        "138-Taurus",
        "142-Headcrusher"
    };
    //Scythes
    static String oneHandScythe[] = {
        "0-Pole",
        "0-Spear",
        "7-Bill",
        "122-Double Sided Spear",
        "142-Diamond Spear"
    };
    static String twoHandScythe[] = {
        
        "10-Halberd",
        "14-Horn Scythe",
        "16-Trident",
        "22-Enriched Scythe",
        "30-Double Scythe",
        "37-Evil Scythe",
        "40-Devil Scythe",
        "44-Silver Bird",
        "50-Chaos Spear",
        "55-Titan Spear",
        "60-Styx Scythe",
        "65-Dragon Wing",
        "70-Butterfly",
        "75-Mystic Spear",
        "80-Hyper Scythe",
        "84-Oracle Spear",
        "88-Immortal Scythe",
        "92-Extreme Spear",
        "96-Phoenix Spear",
        "98-Golden Sickle",
        "100-Frost Scythe",
        "104-Dreadnaught Spear",
        "106-Inferno Scythe",
        "110-Reaper Scythe",
        "114-Death Scythe",
        "116-Twin Scythe",
        "120-Dragon Scythe",
        "126-Kronos Scythe",
        "130-Mythology Scythe",
        "134-Diabolic Scythe",
        "138-Tormentor Scythe"
    };
    static String allScythe[] = {
        "0-Pole",
        "0-Spear",
        "7-Bill",
        "10-Halberd",
        "14-Horn Scythe",
        "16-Trident",
        "22-Enriched Scythe",
        "30-Double Scythe",
        "37-Evil Scythe",
        "40-Devil Scythe",
        "44-Silver Bird",
        "50-Chaos Spear",
        "55-Titan Spear",
        "60-Styx Scythe",
        "65-Dragon Wing",
        "70-Butterfly",
        "75-Mystic Spear",
        "80-Hyper Scythe",
        "84-Oracle Spear",
        "88-Immortal Scythe",
        "92-Extreme Spear",
        "96-Phoenix Spear",
        "98-Golden Sickle",
        "100-Frost Scythe",
        "104-Dreadnaught Spear",
        "106-Inferno Scythe",
        "110-Reaper Scythe",
        "114-Death Scythe",
        "116-Twin Scythe",
        "120-Dragon Scythe",
        "122-Double Sided Spear",
        "126-Kronos Scythe",
        "130-Mythology Scythe",
        "134-Diabolic Scythe",
        "138-Tormentor Scythe",
        "142-Diamond Spear"
    };
    //Claws
    static String claw[] = {
        "0-Eagle Claw",
        "0-Tiger Claw",
        "7-Griffin Claw",
        "10-Snake Tooth",
        "16-Lightning Arm",
        "22-Fingered Edge",
        "30-Hand Blade",
        "37-Pharaoh",
        "40-Ancient Revenge",
        "44-Brutal Claw",
        "50-Hydra Claw",
        "55-Leviathan",
        "60-Wyvern Claw",
        "65-Chaos Claw",
        "70-Wing Talon",
        "75-Doom Talon",
        "80-Titan Talon",
        "84-Salamander Talon",
        "88-Phoenix Talon",
        "92-Chimera Talon",
        "96-Dragon Talon",
        "100-Bloody Claw",
        "104-Viper Talon",
        "106-Inferno Claw",
        "110-Injustice Talon",
        "114-Imperial Talon",
        "116-Raging Claw",
        "120-Heretic Talon",
        "122-Avenger Talon",
        "126-Legend Talon",
        "130-Mythology Claw",
        "134-Diabolic Claw",
        "138-Ferocious Claw",
        "142-Valiant Claw"        
    };
    //Bows
    static String oneHandBow[] = {        
        "0-Horned Bow",
        "0-Hand CrossBow",
        "30-Metal Hand CrossBow",
        "122-Fatal Hand CrossBow",
        "142-Astral Hand Crossbow"
    };
    static String twoHandBow[] = {
        "0-Short Bow",
        "6-CrossBow",
        "9-Battle Bow",
        "15-Great Bow",
        "20-War Bow",
        "25-Great CrossBow",
        "36-Double CrossBow",
        "40-Mist",
        "41-Bone Bow",
        "47-Sagittarius",
        "53-Ancient CrossBow",
        "59-Titan Bow",
        "64-Chaos Bow",
        "70-Swift Bow",
        "75-Relic CrossBow",
        "80-Thunder Bow",
        "84-Wave Bow",
        "88-Grand CrossBow",
        "92-Mirage Bow",
        "96-Dragon Bow",
        "98-Hunters CrossBow",
        "100-Viper Bow",
        "104-Wyvern Bow",
        "106-Enigma Bow",
        "110-Immortal Bow",
        "114-Supreme Bow",
        "116-Rogue Bow",
        "120-Salamander Bow",
        "126-Kronos Bow",
        "130-Mythology Bow",
        "134-Corrupted Bow",
        "138-Lucifer Bow"
    };
    static String allBow[] = {
        "0-Short Bow",
        "0-Horned Bow",
        "0-Hand CrossBow",
        "6-CrossBow",
        "9-Battle Bow",
        "15-Great Bow",
        "20-War Bow",
        "25-Great CrossBow",
        "30-Metal Hand CrossBow",
        "36-Double CrossBow",
        "40-Mist",
        "41-Bone Bow",
        "47-Sagittarius",
        "53-Ancient CrossBow",
        "59-Titan Bow",
        "64-Chaos Bow",
        "70-Swift Bow",
        "75-Relic CrossBow",
        "80-Thunder Bow",
        "84-Wave Bow",
        "88-Grand CrossBow",
        "92-Mirage Bow",
        "96-Dragon Bow",
        "98-Hunters CrossBow",
        "100-Viper Bow",
        "104-Wyvern Bow",
        "106-Enigma Bow",
        "110-Immortal Bow",
        "114-Supreme Bow",
        "116-Rogue Bow",
        "120-Salamander Bow",
        "122-Fatal Hand CrossBow",
        "126-Kronos Bow",
        "130-Mythology Bow",
        "134-Corrupted Bow",
        "138-Lucifer Bow",
        "142-Astral Hand Crossbow"
    };
    //Javelins
    static String javelin[] = {
        "0-Javelin",
        "0-War Javelin",
        "0-Edged Javelin",
        "6-Steel Javelin",
        "11-Double Javelin",
        "16-Elven Javelin",
        "22-Fatal Javelin",
        "30-Matal Javelin",
        "37-Cobra Javelin",
        "40-Anaconda",
        "44-Winged Javelin",
        "50-Holy Javelin",
        "55-Throwing Trident",
        "60-Wyvern Javelin",
        "65-Twisted Javelin",
        "70-Link Javelin",
        "75-Mirage Javelin",
        "80-Mystic Javelin",
        "84-Extreme Javelin",
        "88-Dragon Javelin",
        "92-Spike Javelin",
        "96-Legend Javelin",
        "100-Oblique Javelin",
        "104-Immortal Javelin",
        "106-Inferno Javelin",
        "110-Heretic Javelin",
        "114-Flame Javelin",
        "116-Blessed Javelin",
        "120-Salamander Javelin",
        "122-Royal Javelin",
        "126-Kronos Javelin",
        "130-Mythology Javelin",
        "134-Chaotic Javelin",
        "138-Ophidian Javelin",
        "142-Strider Javelin"
    };
    //Wands
    static String oneHandWand[] = {
        "0-Wand",
        "0-Sphere Wand",
        "0-Obi Wand",
        "16-Elven Wand",
        "22-Dryad Wand",
        "50-Faith Wand",
        "60-Arch Wand",
        "70-Rune Wand",
        "80-Apostle Wand",
        "92-Wyvern Wand",
        "104-Oracle Wand",
        "116-Brutal Wand",
        "122-Crystal Wand",
        "138-Eternal Wand"
    };
    static String twoHandWand[] = {
        
        "6-Root Staff",
        "11-Poly Staff",
        "30-Meditation Staff",
        "37-Skull Staff",
        "40-Ghost",
        "44-Mage Staff",
        "55-Lofty Staff",
        "65-Chaos Staff",
        "75-Rune Staff",
        "84-Relic Staff",
        "88-Dragon Staff",
        "96-Astral Staff",
        "100-Cribal Staff",
        "106-Blessed Staff",
        "110-Celestial Staff",
        "114-Mystic Staff",
        "120-Elf Staff",
        "126-Freyja Staff",
        "130-Mythology Staff",
        "134-Corrupted Staff",
        "142-Rapture Staff"
    };
    static String allWand[] = {
        "0-Wand",
        "0-Sphere Wand",
        "0-Obi Wand",
        "6-Root Staff",
        "11-Poly Staff",
        "16-Elven Wand",
        "22-Dryad Wand",
        "30-Meditation Staff",
        "37-Skull Staff",
        "40-Ghost",
        "44-Mage Staff",
        "50-Faith Wand",
        "55-Lofty Staff",
        "60-Arch Wand",
        "65-Chaos Staff",
        "70-Rune Wand",
        "75-Rune Staff",
        "80-Apostle Wand",
        "84-Relic Staff",
        "88-Dragon Staff",
        "92-Wyvern Wand",
        "96-Astral Staff",
        "100-Cribal Staff",
        "104-Oracle Wand",
        "106-Blessed Staff",
        "110-Celestial Staff",
        "114-Mystic Staff",
        "116-Brutal Wand",
        "120-Elf Staff",
        "122-Crystal Wand",
        "126-Freyja Staff",
        "130-Mythology Staff",
        "134-Corrupted Staff",
        "138-Eternal Wand",
        "142-Rapture Staff"
    };
    //Phantoms
    static String phantom[] = {
        "0-Skild Phantom",
        "6-Creak Phantom",
        "11-Pin Phantom",
        "16-Terte Phantom",
        "21-Okute Phantom",
        "28-Wankala Phantom",
        "35-Paha Phantom",
        "42-Piskin Phantom",
        "49-Tatanka Phantom",
        "56-Naja Phantom",
        "63-Yumni Phantom",
        "70-Siha Phantom",
        "77-Wi Phantom",
        "84-Roan Phantom",
        "90-Canku Phantom",
        "96-Owa Phantom",
        "100-Nkeez Phantom",
        "104-Pejula Phantom",
        "106-Luta Phantom",
        "110-Natanh Phantom",
        "114-Kahsehtha Phantom",
        "116-Niyaha Phantom",
        "120-Acala Phantom",
        "122-Wakinyan Phantom",
        "126-Wakan Phantom",
        "130-Mythology Phantom",
        "134-Chaotic Phantom",
        "138-Psionic Phantom",
        "142-Ethereal Phantom"

    };
    //Daggers
    static String dagger[] = {
        "0-Dagger",
        "4-Ivory Dagger",
        "9-Pointy Dagger",
        "15-Cutlas",
        "21-Hanger",
        "28-Neptunian Dagger",
        "35-Slaughter Knife",
        "42-Saint Dagger",
        "49-Falchion",
        "56-Thunder Dagger",
        "63-Abyss Dagger",
        "70-Celestial Dagger",
        "77-Solstice Dagger",
        "84-Flamberge",
        "90-Fortress Dagger",
        "96-Chameleon Dagger",
        "100-Arcana Dagger",
        "104-Moonstone Dagger",
        "106-Inferno Dagger",
        "110-Plunder Dagger",
        "114-Enigma Dagger",
        "116-Flaming Dagger",
        "120-Devilian Dagger",
        "122-Venomous Dagger",
        "126-Crystal Dagger",
        "130-Mythology Dagger",
        "134-Ruby Dagger",
        "138-Devious Dagger",
        "142-Nightblade"

    };
    //Armors
    static String armor[] = {
        "0-Battle Suit",
        "6-Leather Armor",
        "10-Brigandine",
        "17-Steel Armor",
        "22-Rounded Armor",
        "29-Breast Plate",
        "35-Ring Armor",
        "39-Scale Armor",
        "43-Synthetic Armor",
        "47-Full Plate Armor",
        "51-Full Metal Armor",
        "55-Supreme Armor",
        "60-Spiked Armor",
        "65-Titan Armor",
        "70-Extreme Armor",
        "75-Ancient Armor",
        "80-Minotaur Armor",
        "85-Doom Armor",
        "90-Salamander Armor",
        "95-Wyvern Armor",
        "100-Dragon Armor",
        "100-Phantom Armor",
        "104-Phoenix Armor",
        "106-Inferno Armor",
        "110-Frenzy Armor",
        "114-Hades Armor",
        "116-Mythril Armor",
        "120-Highlander Armor",
        "124-Imperial Armor",
        "128-Kronos Armor",
        "132-Stygian Armor",
        "136-Royal Armor",
        "140-Quantum Armor",
        "144-Malefic Armor",
    };
    //Robes
    static String robe[] = {
        "0-Robe",
        "6-Enhanced Robe",
        "11-Battle Robe",
        "17-Elven Robe",
        "23-Dryad Robe",
        "29-Nymph Robe",
        "35-Apprentice Robe",
        "39-Disciple Robe",
        "43-Master Robe",
        "47-Arch Robe",
        "51-Saint Robe",
        "55-Royal Robe",
        "60-Mystic Robe",
        "65-Devine Robe",
        "70-Bishop Robe",
        "75-Celestial Robe",
        "80-Salvation Robe",
        "85-Alchemist Robe",
        "90-Astral Robe",
        "95-Archon Robe",
        "100-Angel Robe",
        "100-Phantom Robe",
        "104-Ruah Robe",
        "106-Inferno Robe",
        "110-Eternal Robe",
        "114-Elf Robe",
        "116-Lunar Robe",
        "120-Archangel Robe",
        "124-Cherub Robe",
        "128-Freyja Robe",
        "132-Seraphim Robe",
        "136-Chaotic Robe",
        "140-Warlock Robe",
        "144-Malefic Robe",

    };
    //Shields
    static String shield[] = {
        "0-Wood Shield",
        "0-Targe",
        "0-Steel Buckler",
        "9-Kite Shield",
        "16-Tower Shield",
        "22-Metal Shield",
        "30-Scutum",
        "37-Blaze Shield",
        "44-Claw Shield",
        "50-Wing Shield",
        "55-Great Shield",
        "60-Spiked Shield",
        "65-Grand Shield",
        "70-Extreme Shield",
        "75-Gladiator Shield",
        "80-Synthetic Shield",
        "84-Titan Shield",
        "88-Mystic Shield",
        "92-Vampire Shield",
        "96-Dragon Shield",
        "98-Dark Shield",
        "100-Chaos Shield",
        "104-Phoenix Shield",
        "106-Crystal Shield",
        "110-Dreadnaught Shield",
        "110-Mythology Shield",
        "114-Runic Shield",
        "116-Aegis Shield",
        "120-Inferno Shield",
        "124-Torment Shield",
        "128-Kronos Shield",
        "132-Angel Shield",
        "136-Stygian Shield",
        "140-Imperial Shield",
        "144-Nether Shield",
    };
    //Orbs
    static String orb[] = {
        "0-Pearl Beads",
        "0-Crystal Sphere",
        "0-Prizm Sphere",
        "9-Bone Beads",
        "16-Skull Beads",
        "23-Orb",
        "30-Holy Orb",
        "37-Arch Orb",
        "44-Dark Moon",
        "47-Ceremonial Sphere",
        "50-Orbital Beads",
        "55-Harmony Sphere",
        "60-Angel",
        "65-Lucifer",
        "70-Astral Orb",
        "75-Rune Beads",
        "80-Creation Beads",
        "85-Mundane",
        "90-Salamander Beads",
        "95-Cosmos",
        "100-Clairvoyance",
        "104-Ebony Manes",
        "106-Kelvezu Claw",
        "110-Avernus Beads",
        "114-Dynasty Sphere",
        "116-Runic Orb",
        "120-Malice Rosary",
        "124-Aeon Sphere",
        "128-Freyja Orb",
        "132-Midranda's Bane",
        "136-Orbitron",
        "140-Sentinel",
        "144-Dreadsoul",
    };
    //Boots
    static String boot[] = {
        "0-Leather Boots",
        "0-Elven Boots",
        "0-Steel Boots",
        "9-Long Boots",
        "16-Chain Boots",
        "22-Plated Boots",
        "30-Brass Boots",
        "37-War Boots",
        "44-Mechanic Boots",
        "50-Chaos Boots",
        "55-Holy Boots",
        "60-Spike Boots",
        "65-Grand Boots",
        "70-Wing Boots",
        "75-Titan Boots",
        "80-Saint Boots",
        "85-Wyvern Boots",
        "90-Rune Boots",
        "95-Royal Boots",
        "100-Dragon Boots",
        "104-Inferno Boots",
        "105-Mokova Boots",
        "106-Golden Boots",
        "110-Phoenix Boots",
        "114-Highlander Boots",
        "116-Eragon Boots",
        "120-Frenzy Boots",
        "124-Dryad Boots",
        "128-Kronos Boots",
        "132-Eternal Boots",
        "134-Hell Boots",
        "136-Guardian Boots",
        "138-Draxos Boots",
        "140-Mercurial Boots",
        "144-Twilight Boots",
    };
    //Gauntlets
    static String gauntlet[] = {
        "0-Leather Gloves",
        "0-Leather Half Gloves",
        "0-Steel Half Gauntlets",
        "9-Clamshell Gauntlets",
        "16-Finger Gauntlets",
        "22-Gothic Gauntlets",
        "30-War Gauntlets",
        "37-Metal Gauntlets",
        "44-Holy Gauntlets",
        "50-Great Gauntlets",
        "55-Brass Gauntlets",
        "60-Giant Gauntlets",
        "65-Titan Gauntlets",
        "70-Grand Gauntlets",
        "75-Ivory Gauntlets",
        "80-Saint Gauntlets",
        "85-Diamond Gauntlets",
        "90-Angel Gauntlets",
        "95-Relic Gauntlets",
        "100-Dragon Gauntlets",
        "104-Inferno Gauntlets",
        "106-Golden Gauntlets",
        "110-Phoenix Gauntlets",
        "114-Highlander Gauntlets",
        "116-Eragon Gauntlets",
        "120-Frenzy Gauntlets",
        "124-Dryad Gauntlets",
        "128-Kronos Gauntlets",
        "132-Eternal Gauntlets",
        "134-Hell Gauntlets",
        "136-Guardian Gauntlets",
        "136-Greedy Gauntlets",
        "140-Mercurial Gauntlets",
        "144-Twilight Gauntlets",

    };
    //Bracelets
    static String bracelet[] = {
        "0-Leather Armlets",
        "0-Long Armlets",
        "0-Wide Armlets",
        "9-Fold Armlets",
        "16-Scale Armlets",
        "22-Elven Armlets",
        "30-Solid Armlets",
        "37-Mechanic Armlets",
        "44-Wing Bracelets",
        "50-Great Bracelets",
        "55-Grand Bracelets",
        "60-Magicial Bracelets",
        "65-Spike Bracelets",
        "70-Justice Bracelets",
        "75-Minotaur Bracelets",
        "80-Metal Bracelets",
        "85-Titan Bracelets",
        "90-Saint Bracelets",
        "95-Wyvern Bracelets",
        "100-Dragon Bracelets",
        "104-Inferno Bracelets",
        "106-Golden Bracelets",
        "110-Phoenix Bracelets",
        "114-Highlander Bracelets",
        "116-Eragon Bracelets",
        "120-Frenzy Bracelets",
        "124-Dryad Bracelets",
        "128-Kronos Bracelets",
        "132-Eternal Bracelets",
        "134-Hell Bracelets",
        "136-Guardian Bracelets",
        "140-Mercurial Bracelets",
        "142-Centlon Bracelets",
        "144-Twilight Bracelets",
    };
    //Sheltom
    static String sheltom[] = {
        "5-Lucidy",
        "12-Sereneo",
        "20-Fadeo",
        "30-Sparky",
        "40-Raident",
        "45-Transparo",
        "50-Murky",
        "55-Devine",
        "60-Celesto",
        "70-Mirage",
        "80-Inferna",
        "80-Dark Guardian Sheltom",
        "90-Enigma",
        "100-Bellum",
        "100-Fury Sheltom",
        "110-Oredo",
        "115-Sapphire",
        "120-Sol",
        "120-Throne Sheltom",
    };
    //Rings
    static String rings[] = {
        "0-Round Ring",
        "0-Round Ring +1",
        "0-Round Ring +2",
        "0-Round Ring +3",
        "5-Gem Ring",
        "10-Gem Ring +1",
        "15-Gem Ring +2",
        "20-Gem Ring +3",
        "25-Magic Ring",
        "30-Magic Ring +1",
        "35-Magic Ring +2",
        "40-Magic Ring +3",
        "45-Rune Ring",
        "50-Rune Ring +1",
        "55-Rune Ring +2",
        "60-Rune Ring +3",
        "65-Sealed Ring",
        "70-Sealed Ring +1",
        "75-Sealed Ring +2",
        "80-Sealed Ring +3",
        "80-Valento Ring",
        "85-Mystic Ring",
        "90-Mystic Ring +1",
        "95-Mystic Ring +2",
        "100-Mystic Ring +3",
        "100-Lucifer Ring",
        "105-Spirit Ring",
        "110-Spirit Ring +1",
        "115-Spirit Ring +2",
        "120-Spirit Ring +3",
        "120-Throne Ring",
        "122-Enigma Ring",
        "124-Enigma Ring +1",
        "126-Enigma Ring +2",
        "128-Enigma Ring +3",
        "130-Guide Ring",
        "134-Guide Ring +1",
        "138-Guide Ring +2",
        "142-Guide Ring +3",
    };
    //Ammulet
    static String necklace[] = {
        "0-Round Amulet",
        "0-Round Amulet +1",
        "0-Round Amulet +2",
        "0-Round Amulet +3",
        "5-Gem Amulet",
        "10-Gem Amulet +1",
        "15-Gem Amulet +2",
        "20-Gem Amulet +3",
        "25-Magic Amulet",
        "30-Magic Amulet +1",
        "35-Magic Amulet +2",
        "40-Magic Amulet +3",
        "45-Rune Amulet",
        "50-Rune Amulet +1",
        "55-Rune Amulet +2",
        "60-Rune Amulet +3",
        "65-Sealed Amulet",
        "70-Sealed Amulet +1",
        "75-Sealed Amulet +2",
        "80-Sealed Amulet +3",
        "80-Kelvezu Amulet",
        "85-Mystic Amulet",
        "90-Mystic Amulet +1",
        "95-Mystic Amulet +2",
        "100-Mystic Amulet +3",
        "100-Tulla Amulet",
        "105-Spirit Amulet",
        "110-Spirit Amulet +1",
        "115-Spirit Amulet +2",
        "120-Spirit Amulet +3",
        "120-Throne Amulet",
        "122-Enigma Amulet",
        "124-Enigma Amulet +1",
        "126-Enigma Amulet +2",
        "128-Enigma Amulet +3",
        "130-Guide Amulet",
        "134-Guide Amulet +1",
        "138-Guide Amulet +2",
        "142-Guide Amulet +3",

    };
    //Forces
    static String force[] = {
        "5-Lucidy Force",
        "12-Sereneo Force",
        "20-Fadeo Force",
        "30-Sparky Force",
        "40-Raident Force",
        "45-Transparo Force",
        "50-Murky Force",
        "55-Devine Force",
        "60-Celesto Force",
        "70-Mirage Force",
        "80-Inferna Force",
        "90-Enigma Force",
        "100-Bellum Force",
        "110-Oredo Force",
        "115-Sapphire Force",
        "120-Sol Force",
    };
    
    
    
    
    public DefaultListModel gerarLista(String flag){
        DefaultListModel model = new DefaultListModel();
        switch (flag){
            case "1h,sword":
                for (String item : oneHandSword) {
                    model.addElement(item);
                }
            break;
            case "2h,sword":
                for (String item : twoHandSword) {
                    model.addElement(item);
                }
            break;
            case "all,sword":
                for (String item : allSword) {
                    model.addElement(item);
                }
            break;
                case "1h,axe":
                for (String item : oneHandAxe) {
                    model.addElement(item);
                }
            break;
            case "2h,axe":
                for (String item : twoHandAxe) {
                    model.addElement(item);
                }
            break;
            case "all,axe":
                for (String item : allAxe) {
                    model.addElement(item);
                }
            break;
                case "1h,scythe":
                for (String item : oneHandScythe) {
                    model.addElement(item);
                }
            break;
            case "2h,scythe":
                for (String item : twoHandScythe) {
                    model.addElement(item);
                }
            break;
            case "all,scythe":
                for (String item : allScythe) {
                    model.addElement(item);
                }
            break;
                case "1h,hammer":
                for (String item : oneHandHammer) {
                    model.addElement(item);
                }
            break;
            case "2h,hammer":
                for (String item : twoHandHammer) {
                    model.addElement(item);
                }
            break;
            case "1h,claw":
                for (String item : claw) {
                    model.addElement(item);
                }
            break;
            case "1h,bow":
                for (String item : oneHandBow) {
                    model.addElement(item);
                }
            break;
            case "2h,bow":
                for (String item : twoHandBow) {
                    model.addElement(item);
                }
            break;
            case "all,bow":
                for (String item : allBow) {
                    model.addElement(item);
                }
            break;
            case "1h,javelin":
                for (String item : javelin) {
                    model.addElement(item);
                }
            break;
            case "1h,wand":
                for (String item : oneHandWand) {
                    model.addElement(item);
                }
            break;
            case "2h,wand":
                for (String item : twoHandWand) {
                    model.addElement(item);
                }
            break;
            case "all,wand":
                for (String item : allWand) {
                    model.addElement(item);
                }
            case "1h,phantom":
                for (String item : phantom) {
                    model.addElement(item);
                }
            break;
            case "1h,dagger":
                for (String item : dagger) {
                    model.addElement(item);
                }
            break;
            case "armor":
                for (String item : armor) {
                    model.addElement(item);
                }
            break;
            case "robe":
                for (String item : robe) {
                    model.addElement(item);
                }
            break;
            case "shield":
                for (String item : shield) {
                    model.addElement(item);
                }
            break;
            case "orb":
                for (String item : orb) {
                    model.addElement(item);
                }
            break;
            case "boots":
                for (String item : boot) {
                    model.addElement(item);
                }
            break;
            case "gauntlet":
                for (String item : gauntlet) {
                    model.addElement(item);
                }
            break;
            case "bracelet":
                for (String item : bracelet) {
                    model.addElement(item);
                }
            break;
            case "sheltom":
                for (String item : sheltom) {
                    model.addElement(item);
                }
            break;
            case "ring":
                for (String item : rings) {
                    model.addElement(item);
                }
            break;
            case "necklace":
                for (String item : necklace) {
                    model.addElement(item);
                }
            break;
            case "force":
                for (String item : force) {
                    model.addElement(item);
                }
            break;                
        }
        return model;
    }
    
    
}
