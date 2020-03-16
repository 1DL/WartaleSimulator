/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import item.Item;
import item.defense.ItemArmor;
import item.defense.ItemBoots;
import item.defense.ItemBracelets;
import item.defense.ItemGauntlets;
import item.defense.ItemOrb;
import item.defense.ItemRobe;
import item.defense.ItemShield;
import item.weapon.ItemAxe;
import item.weapon.ItemBow;
import item.weapon.ItemClaw;
import item.weapon.ItemDagger;
import item.weapon.ItemHammer;
import item.weapon.ItemJavelin;
import item.weapon.ItemPhantom;
import item.weapon.ItemScythe;
import item.weapon.ItemSword;
import item.weapon.ItemWand;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

/**
 *
 * @author Luiz
 */
public class JdiGearSelectorController {

    /**
     * Retorna um item já instanciado de acordo com os parâmetros informados.
     * Recebe o nome do item selecionado na JList e o grupo de botões dos sub
     * itens. Com base no texto do item selecionado nesse grupo, define qual
     * tipo de sub item instanciar.
     *
     * @param itemName - O nome do item, cujo valor vem da opção selecionada na
     * JList de items
     * @param gearType - O grupo de radio buttons responsável pelos sub itetms -
     * (sword, jav, axe, etc)
     * @return
     */
    public static Item getItem(String itemName, ButtonGroup gearType) {

        String itemType = getSelectedButtonText(gearType);

        Item item = new Item();

        switch (itemType) {

            case "Axe":
                item = new ItemAxe(itemName);
                break;
            case "Bow":
                item = new ItemBow(itemName);
                break;
            case "Claw":
                item = new ItemClaw(itemName);
                break;
            case "Dagger":
                item = new ItemDagger(itemName);
                break;
            case "Hammer":
                item = new ItemHammer(itemName);
                break;
            case "Javelin":
                item = new ItemJavelin(itemName);
                break;
            case "Phantom":
                item = new ItemPhantom(itemName);
                break;
            case "Scythe":
                item = new ItemScythe(itemName);
                break;
            case "Sword":
                item = new ItemSword(itemName);
                break;
            case "Wand":
                item = new ItemWand(itemName);
                break;
            case "Armor":
                item = new ItemArmor(itemName);
                break;
            case "Robe":
                item = new ItemRobe(itemName);
                break;
            case "Shield":
                item = new ItemShield(itemName);
                break;
            case "Orb":
                item = new ItemOrb(itemName);
                break;
            case "Bracelet":
                item = new ItemBracelets(itemName);
                break;
            case "Gauntlet":
                item = new ItemGauntlets(itemName);
                break;
            case "Boots":
                item = new ItemBoots(itemName);
                break;
        }

        return item;
    }

    /**
     * Retorna o texto da label do radio button atualmente selecionado no grupo
     * de sub tipo de items
     *
     * @param buttonGroup
     * @return
     */
    protected static String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

}
