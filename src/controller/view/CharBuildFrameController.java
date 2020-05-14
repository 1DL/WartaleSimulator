/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.view;

import controller.view.animation.ChooseGear;
import controller.game.ItemController;
import controller.game.formula.CharacterStats;
import javax.swing.JButton;
import view.CharBuildFrame;
import javax.swing.JLabel;
import view.JdiGearSelector;
import controller.game.main;

/**
 *
 * @author luiz
 */
public class CharBuildFrameController {
    
    CharBuildFrame cbFrame;
    
    static final boolean PLAYER = true;
    static final boolean ENEMY = false;

    public CharBuildFrameController(CharBuildFrame cbFrame) {
        this.cbFrame = cbFrame;
    }
    
    public void openGearSelector(String callType, boolean playerOrEnemy, ChooseGear animGear, String slotToEquip, JButton btn, JLabel lbl) {
        CharacterStats c;
        
        JdiGearSelector jdi = new JdiGearSelector(cbFrame, true);
        jdi.setLocationRelativeTo(cbFrame);
        jdi.setLocation(cbFrame.getLocation());
        jdi.clearSelectingItem();
        
        if (playerOrEnemy == PLAYER) {
            c = main.pChar;
        } else {
            c = main.eChar;
        }
        
        jdi.setFlags(callType, c, animGear, slotToEquip, btn, lbl);
        animGear.open(jdi.getPanelGear(), true, null);
        jdi.setVisible(true);
        
        
        refreshCharStats(playerOrEnemy);
    }
    
    public void refreshCharStats(boolean playerOrEnemy) {
        if (playerOrEnemy == PLAYER) {
            cbFrame.getTxtPLevel().setText(String.valueOf(main.pChar.getLevel()));
            //main.pChar.resetStats();
            cbFrame.getTxtPRemainStats().setText(String.valueOf(main.pChar.getRemainStats()));
            cbFrame.getTxtPStrenght().setText(String.valueOf(main.pChar.getStrenght()));
            cbFrame.getTxtPSpirit().setText(String.valueOf(main.pChar.getSpirit()));
            cbFrame.getTxtPTalent().setText(String.valueOf(main.pChar.getTalent()));
            cbFrame.getTxtPAgility().setText(String.valueOf(main.pChar.getAgility()));
            cbFrame.getTxtPHealth().setText(String.valueOf(main.pChar.getHealth()));
        } else {
            cbFrame.getTxtELevel().setText(String.valueOf(main.pChar.getLevel()));
            //main.pChar.resetStats();
            cbFrame.getTxtERemainStats().setText(String.valueOf(main.eChar.getRemainStats()));
            cbFrame.getTxtEStrenght().setText(String.valueOf(main.eChar.getStrenght()));
            cbFrame.getTxtESpirit().setText(String.valueOf(main.eChar.getSpirit()));
            cbFrame.getTxtETalent().setText(String.valueOf(main.eChar.getTalent()));
            cbFrame.getTxtEAgility().setText(String.valueOf(main.eChar.getAgility()));
            cbFrame.getTxtEHealth().setText(String.valueOf(main.eChar.getHealth()));
        }
            checkAllItemReqStatsMatch(playerOrEnemy);
            atualizarTooltip(playerOrEnemy);
        
    }
    
    private void checkAllItemReqStatsMatch(boolean playerOrEnemy) {
        ItemController ic = new ItemController();
        
        if (playerOrEnemy == PLAYER) {
            //Main gears        
            ic.checkItemRequirement(main.pChar, cbFrame.getLblSlotHover1HP(), main.pChar.getItemWeaponOneHand());
            ic.checkItemRequirement(main.pChar, cbFrame.getLblSlotHover2HP(), main.pChar.getItemWeaponTwoHand());
            ic.checkItemRequirement(main.pChar, cbFrame.getLblSlotHoverArmorP(), main.pChar.getItemArmor());
            ic.checkItemRequirement(main.pChar, cbFrame.getLblSlotHoverShieldP(), main.pChar.getItemShield());
            //Defensive
            ic.checkItemRequirement(main.pChar, cbFrame.getLblSlotHoverBraceletP(), main.pChar.getItemBracelet());
            ic.checkItemRequirement(main.pChar, cbFrame.getLblSlotHoverGauntletP(), main.pChar.getItemGauntlet());
            ic.checkItemRequirement(main.pChar, cbFrame.getLblSlotHoverBootsP(), main.pChar.getItemBoots());
            //Accessory
            ic.checkItemRequirement(main.pChar, cbFrame.getLblSlotHoverAmuletP(), main.pChar.getItemAmulet());
            ic.checkItemRequirement(main.pChar, cbFrame.getLblSlotHoverRing1P(), main.pChar.getItemRing1());
            ic.checkItemRequirement(main.pChar, cbFrame.getLblSlotHoverRing2P(), main.pChar.getItemRing2());
            ic.checkItemRequirement(main.pChar, cbFrame.getLblSlotHoverSheltomP(), main.pChar.getItemSheltom());
            
        } else {
            ic.checkItemRequirement(main.eChar, cbFrame.getLblSlotHover1HE(), main.eChar.getItemWeaponOneHand());
            ic.checkItemRequirement(main.eChar, cbFrame.getLblSlotHover2HE(), main.eChar.getItemWeaponTwoHand());
            ic.checkItemRequirement(main.eChar, cbFrame.getLblSlotHoverArmorE(), main.eChar.getItemArmor());
            ic.checkItemRequirement(main.eChar, cbFrame.getLblSlotHoverShieldE(), main.eChar.getItemShield());

            ic.checkItemRequirement(main.eChar, cbFrame.getLblSlotHoverBraceletE(), main.eChar.getItemBracelet());
            ic.checkItemRequirement(main.eChar, cbFrame.getLblSlotHoverGauntletE(), main.eChar.getItemGauntlet());
            ic.checkItemRequirement(main.eChar, cbFrame.getLblSlotHoverBootsE(), main.eChar.getItemBoots());

            ic.checkItemRequirement(main.eChar, cbFrame.getLblSlotHoverAmuletE(), main.eChar.getItemAmulet());
            ic.checkItemRequirement(main.eChar, cbFrame.getLblSlotHoverRing1E(), main.eChar.getItemRing1());
            ic.checkItemRequirement(main.eChar, cbFrame.getLblSlotHoverRing2E(), main.eChar.getItemRing2());
            ic.checkItemRequirement(main.eChar, cbFrame.getLblSlotHoverSheltomE(), main.eChar.getItemSheltom());
        }
        
    }
    
    private void atualizarTooltip(boolean playerOrEnemy) {
        
        if (playerOrEnemy == PLAYER) {
            
            cbFrame.getBtnPlayerWeapon1().setToolTipText(main.pChar.getItemWeaponOneHand().getItemDesc());
            cbFrame.getBtnPlayerWeapon2().setToolTipText(main.pChar.getItemWeaponTwoHand().getItemDesc());
            cbFrame.getBtnPlayerArmor().setToolTipText(main.pChar.getItemArmor().getItemDesc());
            cbFrame.getBtnPlayerShield().setToolTipText(main.pChar.getItemShield().getItemDesc());
            cbFrame.getBtnPlayerBracelet().setToolTipText(main.pChar.getItemBracelet().getItemDesc());
            cbFrame.getBtnPlayerGauntlet().setToolTipText(main.pChar.getItemGauntlet().getItemDesc());
            cbFrame.getBtnPlayerBoots().setToolTipText(main.pChar.getItemBoots().getItemDesc());
            cbFrame.getBtnPlayerAmulet().setToolTipText(main.pChar.getItemAmulet().getItemDesc());
            cbFrame.getBtnPlayerRing1().setToolTipText(main.pChar.getItemRing1().getItemDesc());
            cbFrame.getBtnPlayerRing2().setToolTipText(main.pChar.getItemRing2().getItemDesc());
            cbFrame.getBtnPlayerSheltom().setToolTipText(main.pChar.getItemSheltom().getItemDesc());
            
        } else {

            cbFrame.getBtnEnemyWeapon1().setToolTipText(main.eChar.getItemWeaponOneHand().getItemDesc());
            cbFrame.getBtnEnemyWeapon2().setToolTipText(main.eChar.getItemWeaponTwoHand().getItemDesc());
            cbFrame.getBtnEnemyArmor().setToolTipText(main.eChar.getItemArmor().getItemDesc());
            cbFrame.getBtnEnemyShield().setToolTipText(main.eChar.getItemShield().getItemDesc());
            cbFrame.getBtnEnemyBracelet().setToolTipText(main.eChar.getItemBracelet().getItemDesc());
            cbFrame.getBtnEnemyGauntlet().setToolTipText(main.eChar.getItemGauntlet().getItemDesc());
            cbFrame.getBtnEnemyBoots().setToolTipText(main.eChar.getItemBoots().getItemDesc());
            cbFrame.getBtnEnemyAmulet().setToolTipText(main.eChar.getItemAmulet().getItemDesc());
            cbFrame.getBtnEnemyRing1().setToolTipText(main.eChar.getItemRing1().getItemDesc());
            cbFrame.getBtnEnemyRing2().setToolTipText(main.eChar.getItemRing2().getItemDesc());
            cbFrame.getBtnEnemySheltom().setToolTipText(main.eChar.getItemSheltom().getItemDesc());
        }
        
    }
    
    public void unequipGear() {
        
    }


}
