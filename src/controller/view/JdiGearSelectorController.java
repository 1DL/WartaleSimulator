/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.view;

import item.Item;
import item.acessory.ItemAmulet;
import item.acessory.ItemRing;
import item.acessory.ItemSheltom;
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
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import view.JdiGearSelector;

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
     * @param getGearType() - O grupo de radio buttons responsável pelos sub
     * itetms - (sword, jav, axe, etc)
     * @return
     */
    public Item getItem(String itemName, ButtonGroup GearType) {

        String itemType = getSelectedButtonText(GearType);

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
            case "Amulet":
                item = new ItemAmulet(itemName);
                break;
            case "Ring":
                item = new ItemRing(itemName);
                break;
            case "Sheltom":
                item = new ItemSheltom(itemName);
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
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    public void selectItem(JdiGearSelector jdi) {
        //Limpa lista de classes de spec
        jdi.getCmbSpec().removeAllItems();

        //Verifica qual o tipo de item a ser instanciado
        jdi.setSelectingItem(this.getItem(jdi.getJlistItem().getSelectedValue(), jdi.getGearType()));

        //Define quem é o personagem dono do item
        if (jdi.viewMode == JdiGearSelector.EQUIP_MODE) {
            jdi.getSelectingItem().setOwnerCharacter(jdi.getCharacter());
        }

        //Altera flag que permite equipar
        jdi.setAllowEquip(true);
        //Exibe a imagem do icone
        jdi.getLblGearImage().setIcon(jdi.getTextureWork().addTranspBMP(jdi.getSelectingItem().getItemImgDir()));

        //Popula a lista de classes de spec basedo no item selecionado
        for (String spec : jdi.getSelectingItem().getClassSpec()) {
            if (spec == null) {
                break;
            }
            jdi.getCmbSpec().addItem(spec);
        }
        //Torna ativo a lista de Spec
        jdi.getCmbSpec().setEnabled(true);

        //Busca se o item possui spec da classe, e se tiver, já o seleciona
        if (jdi.viewMode == JdiGearSelector.EQUIP_MODE) {

            if (!jdi.getCallType().equals("all")) {
                for (String spec : jdi.getSelectingItem().getClassSpec()) {
                    if (jdi.getCharacter().getClasse().equals(spec)) {
                        jdi.getCmbSpec().setSelectedItem(spec);
                    }
                }
            }
        }
        //Define o spec selecionado para o item
        jdi.getSelectingItem().setSelectedSpec(String.valueOf(jdi.getCmbSpec().getSelectedItem()));

        //Habilita a lista de Aging caso o item possa realizar aging
        jdi.getCmbAgingLevel().setEnabled(jdi.getSelectingItem().getCanAge());

        //Habilita a lista de Mix
        jdi.getCmbMix().setEnabled(true);

        //Verifica qual foi o ultimo tipo de ação aplicada no item, Aging ou Mix
        switch (jdi.getLastSelectedMixOrAge()) {
            case JdiGearSelector.NONE:

                break;

            case JdiGearSelector.AGING:
                if (jdi.getSelectingItem().getCanAge() && jdi.getCmbAgingLevel().getSelectedIndex() != 0) {
                    jdi.getSelectingItem().addAging(jdi.getCmbAgingLevel().getSelectedIndex());
                }
                break;

            case JdiGearSelector.MIX:
                if (jdi.getCmbMix().getSelectedIndex() != 0) {
                    String[] nomeMix = String.valueOf(jdi.getCmbMix().getSelectedItem()).split("-");
                    if (jdi.getRbtWeapon().isSelected()) {
                        jdi.getSelectingItem().addMix(jdi.getRbtWeapon().getText(), nomeMix[0]);
                    } else {
                        jdi.getSelectingItem().addMix(getSelectedButtonText(jdi.getGearType()), nomeMix[0]);
                    }
                }
                break;
        }

        jdi.atualizarSheltomsUsados();
        jdi.getLblGearDesc().setText(jdi.getSelectingItem().getItemViewDesc());
    }

    public void setSelectedItem(JdiGearSelector jdi, java.awt.event.MouseEvent evt) {
        //click esquerdo
        if (evt.getButton() == MouseEvent.BUTTON1) {
            selectItem(jdi);
            
            //click duplo
            if (jdi.viewMode == JdiGearSelector.EQUIP_MODE) {
                if (evt.getClickCount() == 2) {
                    int index = jdi.getJlistItem().locationToIndex(evt.getPoint());
                    jdi.checkReqStats(true);
                }
            }

        }

        //click meio
        if (evt.getButton() == MouseEvent.BUTTON2) {

        }

        //click direito
        if (evt.getButton() == MouseEvent.BUTTON3) {
            //JOptionPane.showMessageDialog(panCompareItem, evt);

            //Verifica qual o tipo de item a ser instanciado
            jdi.setComparingItem(this.getItem(jdi.getJlistItem().getSelectedValue(), jdi.getGearType()));

            //Exibe a imagem do icone
            jdi.getLblGearImageC().setIcon(jdi.getTextureWork().addTranspBMP(jdi.getComparingItem().getItemImgDir()));

            //Limpa lista de classes de spec
            jdi.getCmbSpecC().removeAllItems();

            //Popula a lista de classes de spec basedo no item selecionado
            for (String spec : jdi.getComparingItem().getClassSpec()) {
                if (spec == null) {
                    break;
                }
                jdi.getCmbSpecC().addItem(spec);
            }
            //Habilita a lista de Aging caso o item possa realizar aging
            jdi.getCmbAgingLevelC().setEnabled(jdi.getComparingItem().getCanAge());

            //Habilita a lista de Mix
            jdi.getCmbMixC().setEnabled(true);

            //Verifica qual foi o ultimo tipo de ação aplicada no item, Aging ou Mix
            switch (jdi.getLastSelectedMixOrAgeC()) {
                case JdiGearSelector.NONE:

                    break;

                case JdiGearSelector.AGING:
                    if (jdi.getComparingItem().getCanAge() && jdi.getCmbAgingLevelC().getSelectedIndex() != 0) {
                        jdi.getComparingItem().addAging(jdi.getCmbAgingLevelC().getSelectedIndex());
                    }
                    break;

                case JdiGearSelector.MIX:
                    if (jdi.getCmbMixC().getSelectedIndex() != 0) {
                        String[] nomeMix = String.valueOf(jdi.getCmbMixC().getSelectedItem()).split("-");
                        if (jdi.getRbtWeapon().isSelected()) {
                            jdi.getComparingItem().addMix(jdi.getRbtWeapon().getText(), nomeMix[0]);
                        } else {
                            jdi.getComparingItem().addMix(getSelectedButtonText(jdi.getGearType()), nomeMix[0]);
                        }
                    }
                    break;
            }

            jdi.atualizarSheltomsUsadosC();
            jdi.getLblGearDescC().setText(jdi.getComparingItem().getItemViewDesc());

        }
    }
    
    
}
