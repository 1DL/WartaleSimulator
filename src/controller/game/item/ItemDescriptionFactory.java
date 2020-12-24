/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.game.item;

import controller.assets.assetsController;
import java.text.DecimalFormat;
import view.JdiGearSelector;

/**
 *
 * @author luiz
 */
public class ItemDescriptionFactory extends assetsController {

    Item it;

    /*
        render img on html
        <br><img src='"+this.getClass().getResource("/assets/images/logoTempskrons.png")+"'></img>
     */
    /**
     * Receives an Item parameter in order to build it's item description html codes.
     * @param it - Item object of Item class
     */
    public ItemDescriptionFactory(Item it) {
        this.it = it;
    }
    
    /**
     * Returns HTML code with image tag. The source of image is the icon with the
     * +XX (where XX is the aging level). 
     * @return The img tag with image of current aging level.
     */
    public String agingLvlImg() {
        if (it.agingLevel > 0) {
            return "<img src='"+loadImage(AGING_DIR, "aging"+it.agingLevel+".png")+"'>";
        } else {
            return "";
        }
    }
    /**
     * Returns HTML code with image tag. The source of image is the icon for the
     * item being equipped / mouse hovered.
     * @return The img tag with image of current item type.
     */
    public String gearIcon() {
        if (!it.getItemIconDir().isEmpty()) {
            return "<img src='"+loadImage(GEARICON_DIR, it.getItemIconDir())+"'>";
        } else {
            return "";
        }
    }
    
    
    /**
     * First, check if the current view mode of Gear Selector window.
     * If the user is just viewing, not equipping items, will not call for
     * checkStatusReq() method. If user is equipping, it will check 
     * for itemStatusRequirement to apply HTML changes based on current state
     * of the character who is equipping or owns the item.
     * Creates the full item description HTML codes to be rendered on Gear Select
     * window. Includes every status and parameters of a given item.
     * Cheack each possible status and parameters, and returns HTML code if they're
     * not empty. Applies changes on HTML tags and colors based on real item changes
     * like Aging, Mixes, matching of Requirement and Requirement modifications by spec. 
     * Then, sets itemViewDesc attribute of Item object with the final HTML code.
     */
    public void createViewItemDesc() {
        if (JdiGearSelector.VIEW_MODE == JdiGearSelector.EQUIP_MODE) {
            it.checkStatusReq();
        }
        if (it.itemType.equals("No Gear")) {
            it.itemViewDesc = "<html><div style='max-width: 200px'><div style='text-align: center;'>"
                    + "<font color='white'><b>No gear equipped.<br><br>Left click and select a gear to equip.</div>";
            return;
        }
        it.specPrice = it.price * 1.10;
        it.itemViewDesc = "";
        it.itemDescSpec = "";
        it.itemDescMisc = "";
        //Definição cabeçalho
        it.itemViewDesc = "<html><div style='width: 150px'>";
        if (!this.it.itemMix.isEmpty()) {
            it.itemViewDesc += "<div style='text-align: center; margin-right: 30px'><font color='#92f8f9'><b>" + this.it.itemName + gearIcon()+"</b></font></div>"
                    + "<div style='text-align: center; margin-right: 40px'><font color='blue'>" + this.it.itemMix + "</font></div>";
        } else if (it.itemAged) {
            it.itemViewDesc += "<div style='text-align: center; margin-right: 30px'><font color='#fffa5f'><b>" + this.it.itemName + gearIcon()+"</b></font></div>"
                    + "<div style='text-align: center; margin-right: 40px'>"+agingLvlImg()+"</img></div>";
        } else {
            it.itemViewDesc += "<div style='text-align: center; margin-right: 30px'><font color='#dee7ff'><b>" + this.it.itemName + gearIcon()+"</b></font></div>";
        }

        if (!it.itemLore.isEmpty()) {
            it.itemViewDesc += "<div style='text-align: center;'><font color='#7db4af'> " + it.itemLore + "</font></div>";
        }
        //Status base
        /*
        stats aging
        mAtkMin = 0;
        mAtkMax = 0;
        mCritChance = 0;
        mAtkRtg = 0;
        mLvl = 0;
        mDefense = 0;
        mAbs = 0;
        mBlock = 0;
        mMp = 0;

         */
        it.itemViewDesc += "<br><font color='white'>";
        it.itemViewDesc += "<table cellspacing='0' cellpadding='0'>";
        if ((it.MINatkMin != 0 && it.MAXatkMin != 0 && it.MINatkMax != 0 && it.MAXatkMax != 0) || (it.mMINAtkMin != 0 || it.mMAXAtkMin != 0 || it.mMINAtkMax != 0 || it.mMAXAtkMax != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINAtkMin + it.mMINAtkMax)) + rt() + "Attack Power:" + bt() + (it.MINatkMin + it.mMINAtkMin) + "/" + (it.MAXatkMin + it.mMAXAtkMin) + " - " + (it.MINatkMax + it.mMINAtkMax) + "/" + (it.MAXatkMax + it.mMAXAtkMax) + et() + ec(String.valueOf(it.mMINAtkMax));
        }
        if (it.atkSpd != 0 || it.mAtkSpd != 0) {
            it.itemViewDesc += ac(String.valueOf(it.mAtkSpd)) + rt() + "Attack Speed: " + bt() + (it.atkSpd + it.mAtkSpd) + ec(String.valueOf(it.mAtkSpd)) + et();
        }
        if (it.critChance != 0 || it.mCritChance != 0) {
            it.itemViewDesc += ac(String.valueOf(it.mCritChance)) + rt() + "Critical: " + bt() + (int) (it.critChance + it.mCritChance) + "%" + ec(String.valueOf(it.mCritChance)) + et();
        }
        if ((it.MINatkRtg != 0 && it.MAXatkRtg != 0) || (it.mMINAtkRtg != 0 && it.mMAXAtkRtg != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINAtkRtg)) + rt() + "Attack Rating: " + bt() + (it.MINatkRtg + it.mMINAtkRtg) + "/" + (it.MAXatkRtg + it.mMAXAtkRtg) + ec(String.valueOf(it.mMAXAtkRtg)) + et();
        }
        if ((it.MINCritDamage != 0 && it.MAXCritDamage != 0) || (it.mMINCritDamage != 0 && it.mMAXCritDamage != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINCritDamage)) + rt() + "Critical Damage: " + bt() + (it.MINCritDamage + it.mMINCritDamage) + "%/" + (it.MAXCritDamage + it.mMAXCritDamage) + "%" + ec(String.valueOf(it.mMAXCritDamage)) + et();
        }
        if (it.range != 0) {
            it.itemViewDesc += rt() + "Range: " + bt() + it.range + et();
        }
        if ((it.MINdefense != 0 && it.MAXdefense != 0) || (it.mMINdefense != 0 && it.mMAXdefense != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINdefense)) + rt() + "Defense: " + bt() + (int) (it.MINdefense + it.mMINdefense) + "/" + (int) (it.MAXdefense + it.mMAXdefense) + ec(String.valueOf(it.mMAXdefense)) + et();
        }
        if ((it.MINabs != 0 && it.MAXabs != 0) || (it.mMINabs != 0 && it.mMAXabs != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINabs)) + rt() + "Absorb: " + bt() + new DecimalFormat("0.0").format((it.MINabs + it.mMINabs)) + "/" + new DecimalFormat("0.0").format((it.MAXabs + it.mMAXabs)) + ec(String.valueOf(it.mMAXabs)) + et();
        }
        if ((it.MINblock != 0 && it.MAXblock != 0) || (it.mMINblock != 0 && it.mMAXblock != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINblock)) + rt() + "Block: " + bt() + new DecimalFormat("0.#").format((it.MINblock + it.mMINblock)) + "%/" + new DecimalFormat("0.#").format((it.MAXblock + it.mMAXblock)) + "%" + ec(String.valueOf(it.mMAXblock)) + et();
        }
        if (it.MINevasion != 0 && it.MAXevasion != 0) {
            it.itemViewDesc += rt() + "Evasion: " + bt() + it.MINevasion + "%/" + it.MAXevasion + "%" + et();
        }
        if ((it.MINmoveSpeed != 0 && it.MAXmoveSpeed != 0) || (it.mMINmoveSpeed != 0 && it.mMAXmoveSpeed != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINmoveSpeed)) + rt() + "Speed: " + bt() + (it.MINmoveSpeed + it.mMINmoveSpeed) + "/" + (it.MAXmoveSpeed + it.mMAXmoveSpeed) + ec(String.valueOf(it.mMAXmoveSpeed)) + et();
        }
        if (it.MINintegrity != 0 && it.MAXintegrity != 0) {
            it.itemViewDesc += rt() + "Integrity: " + bt() + it.MINintegrity + "/" + it.MAXintegrity + et();
        }
        if ((it.MINorganicResist != 0 && it.MAXorganicResist != 0) || (it.mMINorganicResist != 0 && it.mMAXorganicResist != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINorganicResist)) + rt() + "Organic: " + bt() + (it.MINorganicResist + it.mMINorganicResist) + "/" + (it.MAXorganicResist + it.mMAXorganicResist) + ec(String.valueOf(it.mMAXorganicResist)) + et();
        }
        if ((it.MINfireResist != 0 && it.MAXfireResist != 0) || (it.mMINfireResist != 0 && it.mMAXfireResist != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINfireResist)) + rt() + "Fire: " + bt() + (it.MINfireResist + it.mMINfireResist) + "/" + (it.MAXfireResist + it.mMAXfireResist) + ec(String.valueOf(it.mMAXfireResist)) + et();
        }
        if ((it.MINiceResist != 0 && it.MAXiceResist != 0) || (it.mMINiceResist != 0 && it.mMAXiceResist != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINiceResist)) + rt() + "Frost: " + bt() + (it.MINiceResist + it.mMINiceResist) + "/" + (it.MAXiceResist + it.mMAXiceResist) + ec(String.valueOf(it.mMAXiceResist)) + et();
        }
        if ((it.MINlightningResist != 0 && it.MAXlightningResist != 0) || (it.mMINlightningResist != 0 && it.mMAXlightningResist != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINlightningResist)) + rt() + "Lightning: " + bt() + (it.MINlightningResist + it.mMINlightningResist) + "/" + (it.MAXlightningResist + it.mMAXlightningResist) + ec(String.valueOf(it.mMAXlightningResist)) + et();
        }
        if ((it.MINpoisonResist != 0 && it.MAXpoisonResist != 0) || (it.mMINpoisonResist != 0 && it.mMAXpoisonResist != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINpoisonResist)) + rt() + "Poison: " + bt() + (it.MINpoisonResist + it.mMINpoisonResist) + "/" + (it.MAXpoisonResist + it.mMAXpoisonResist) + ec(String.valueOf(it.mMAXpoisonResist)) + et();
        }
        if ((it.MINhpReg != 0 && it.MAXhpReg != 0) || (it.mMINhpReg != 0 && it.mMAXhpReg != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINhpReg)) + rt() + "HP Regen: " + bt() + (it.MINhpReg + it.mMINhpReg) + "/" + (it.MAXhpReg + it.mMAXhpReg) + ec(String.valueOf(it.mMAXhpReg)) + et();
        }
        if ((it.MINmpReg != 0 && it.MAXmpReg != 0) || (it.mMINmpReg != 0 && it.mMAXmpReg != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINmpReg)) + rt() + "MP Regen: " + bt() + (it.MINmpReg + it.mMINmpReg) + "/" + (it.MAXmpReg + it.mMAXmpReg) + ec(String.valueOf(it.mMAXmpReg)) + et();
        }
        if ((it.MINstmReg != 0 && it.MAXstmReg != 0) || (it.mMINstmReg != 0 && it.mMAXstmReg != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINstmReg)) + rt() + "STM Regen: " + bt() + (it.MINstmReg + it.mMINstmReg) + "/" + (it.MAXstmReg + it.mMAXstmReg) + ec(String.valueOf(it.mMAXstmReg)) + et();
        }
        if ((it.MINhp != 0 && it.MAXhp != 0) || (it.mMINhp != 0 && it.mMAXhp != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINhp)) + rt() + "Add HP: " + bt() + (it.MINhp + it.mMINhp) + "/" + (it.MAXhp + it.mMAXhp) + ec(String.valueOf(it.mMAXhp)) + et();
        }
        if ((it.MINmp != 0 && it.MAXmp != 0) || (it.mMINmp != 0 && it.mMAXmp != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINmp)) + rt() + "Add MP: " + bt() + (it.MINmp + it.mMINmp) + "/" + (it.MAXmp + it.mMAXmp) + ec(String.valueOf(it.mMAXmp)) + et();
        }
        if ((it.MINstm != 0 && it.MAXstm != 0) || (it.mMINstm != 0 && it.mMAXstm != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINstm)) + rt() + "Add SP: " + bt() + (it.MINstm + it.mMINstm) + "/" + (it.MAXstm + it.mMAXstm) + ec(String.valueOf(it.mMAXstm)) + et();
        }
        if (it.potCount != 0) {
            it.itemViewDesc += rt() + "Pot Count: " + bt() + it.potCount + et();
        }
        it.itemViewDesc += "</table>";
        it.itemViewDesc += "</font>";

        //Requerimentos
        it.itemViewDesc += "<table cellspacing='0' cellpadding='0'>";
        if (it.rLvl != 0) {
            it.itemViewDesc += arlvl() + bt() + al(String.valueOf(it.rLvl), String.valueOf(it.rLvl + it.mLvl)) + erlvl();
        }
        if (it.rStr != 0) {
            it.itemViewDesc += arstr() + bt() + ar(String.valueOf(it.rStr), String.valueOf(it.mMINstr), String.valueOf(it.mMAXstr)) + erstr();
        }
        if (it.rSpi != 0) {
            it.itemViewDesc += arspi() + bt() + ar(String.valueOf(it.rSpi), String.valueOf(it.mMINspi), String.valueOf(it.mMAXspi)) + erspi();
        }
        if (it.rTal != 0) {
            it.itemViewDesc += artal() + bt() + ar(String.valueOf(it.rTal), String.valueOf(it.mMINtal), String.valueOf(it.mMAXtal)) + ertal();
        }
        if (it.rAgi != 0) {
            it.itemViewDesc += aragi() + bt() + ar(String.valueOf(it.rAgi), String.valueOf(it.mMINagi), String.valueOf(it.mMAXagi)) + eragi();
        }
        if (it.rVit != 0) {
            it.itemViewDesc += arvit() + bt() + ar(String.valueOf(it.rVit), String.valueOf(it.mMINvit), String.valueOf(it.mMAXvit)) + eragi();
        }
        it.itemViewDesc += "</table>";

        //Spec
        it.itemDescSpec += "<div style='text-align: center; margin-right: 30px'><font color='#ffdc5f'>" + it.selectedSpec + " Spec</font></div>";
        it.itemDescSpec += "<table cellspacing='0' cellpadding='0'>";

        if (it.sMINdefense != 0 && it.sMAXdefense != 0) {
            it.itemDescSpec += rts() + "Spec Defense:" + bt() + it.sMINdefense + "/" + it.sMAXdefense + ets();
        }
        if (it.sMINabs != 0 && it.sMAXabs != 0) {
            it.itemDescSpec += rts() + "Spec Absorb:" + bt() + new DecimalFormat("0.0").format(it.sMINabs) + "/" + new DecimalFormat("0.0").format(it.sMAXabs) + ets();
        }
        if (it.sCritChance != 0) {
            it.itemDescSpec += rts() + "Spec Critical:" + bt() + it.sCritChance + "%" + ets();
        }
        if (it.sDivAtkPow != 0) {
            it.itemDescSpec += rts() + "Spec ATK Pwr:" + bt() + "LV/" + it.sDivAtkPow + ets();
        }
        if (it.sMINDivAtkRtg != 0 && it.sMAXDivAtkRtg != 0) {
            it.itemDescSpec += rts() + "Spec ATK Rtg:" + bt() + "LV/" + it.sMINDivAtkRtg + "-" + it.sMAXDivAtkRtg + ets();
        }
        if (it.sRange != 0) {
            it.itemDescSpec += rts() + "Spec Range:" + bt() + it.sRange + ets();
        }
        if (it.sMINmagicAPT != 0 && it.sMAXmagicAPT != 0) {
            it.itemDescSpec += rts() + "Magic APT:" + bt() + it.sMINmagicAPT + "/" + it.sMAXmagicAPT + ets();
        }
        if (it.sBlock != 0) {
            it.itemDescSpec += rts() + "Spec Block:" + bt() + new DecimalFormat("0.#").format(it.sBlock) + "%" + ets();
        }
        if (it.sMINmoveSpeed != 0 && it.sMAXmoveSpeed != 0) {
            it.itemDescSpec += rts() + "Spec Speed:" + bt() + it.sMINmoveSpeed + "/" + it.sMAXmoveSpeed + ets();
        }
        if (it.sDivHp != 0) {
            it.itemDescSpec += rts() + "Max HP Boost:" + bt() + "LV/" + it.sDivHp + ets();
        }
        if (it.sDivHp != 0) {
            it.itemDescSpec += rts() + "Max HP Boost:" + bt() + "LV/" + it.sDivHp + ets();
        }
        if (it.sDivMp != 0) {
            it.itemDescSpec += rts() + "Max MP Boost:" + bt() + "LV/" + it.sDivMp + ets();
        }
        if (it.sHpReg != 0) {
            it.itemDescSpec += rts() + "Spec HP Regen:" + bt() + it.sHpReg + ets();
        }
        if (it.sMINmpReg != 0 && it.sMAXmpReg != 0) {
            it.itemDescSpec += rts() + "Spec MP Regen:" + bt() + it.sMINmpReg + "/" + it.sMAXmpReg + ets();
        }
        if (it.sStmReg != 0) {
            it.itemDescSpec += rts() + "Spec STM Regen:" + bt() + it.sStmReg + ets();
        }
        it.itemDescSpec += "</table>";

        //Misc
        it.itemDescMisc += "<table cellspacing='0' cellpadding='0'>";
        if (it.price != 0) {
            it.itemDescMisc += rtm() + "No Spec Price: " + bt() + new DecimalFormat("###,###,###,###").format((int) it.price) + etm();
        }
        if (it.specPrice != 0) {
            it.itemDescMisc += rtm() + "Spec Price: " + bt() + new DecimalFormat("###,###,###,###").format((int) it.specPrice) + etm();
        }
        if (it.itemAged) {
            it.itemDescMisc += rtm() + "Aging Price: " + bt() + new DecimalFormat("###,###,###,###").format((int) it.agingCost) + etm();
        }
        if (it.itemAged) {
            it.itemDescMisc += rtm() + "Total Aging Cost: " + bt() + new DecimalFormat("###,###,###,###").format((int) it.totalAgingCost) + etm();
        }
        if (!it.itemMix.isEmpty()) {
            it.itemDescMisc += rtm() + "Mix Price: " + bt() + new DecimalFormat("###,###,###,###").format((int) it.mixCost) + etm();
        }
        if (it.weight != 0) {
            it.itemDescMisc += rtm() + "Weight: " + bt() + it.weight + etm();
        }

        it.itemDescMisc += "</table>";
        it.itemDescMisc += "<font color='silver'>";
        it.itemDescMisc += getListaSpec();
        it.itemDescMisc += "</font>";

        if (!it.selectedSpec.equals("No Spec")) {
            it.itemViewDesc += it.itemDescSpec + it.itemDescMisc;
        } else {
            it.itemViewDesc += it.itemDescMisc;
        }

        it.itemViewDesc += "</div></html>";

    }

    /**
     * Creates a reduced item description HTML codes to be rendered as a tooltip
     * when mouse-hovering the gear slot. Includes every status and parameters of a given item, except 
     * miscelaneous info like price, weight and other character class specs.
     * Check each status and parameters, and returns HTML code if they're
     * not empty. Applies changes on HTML tags and colors based on real item changes
     * like Aging, Mixes, matching of Requirement and Requirement modifications by spec. 
     * Then, sets the itemDesc attribute of an Item object with the final HTML code.
     */
    public void createItemDesc() {

        if (it.itemType.equals("No Gear")) {
            it.itemDesc = "<html><div style='max-width: 200px'><div style='text-align: center;'>"
                    + "<font color='white'><b>No gear equipped.<br><br>Left click and select a gear to equip.</div>";
            return;
        }
        it.specPrice = it.price * 1.10;
        it.itemDesc = "";
        it.itemDescSpec = "";
        it.itemDescMisc = "";
        //Definição cabeçalho
        it.itemDesc = "<html><div style='padding: 5px; width: 115px'>";
        if (!this.it.itemMix.isEmpty()) {
            it.itemDesc += "<div style='text-align: center;'><font color='#92f8f9'><b>" + this.it.itemName + gearIcon()+"</b></font></div>"
                    + "<div style='text-align: center;'><font color='blue'>" + this.it.itemMix + "</font></div>";
        } else if (it.itemAged) {
            it.itemDesc += "<div style='text-align: center;'><font color='#fffa5f'><b>" + this.it.itemName + gearIcon()+"</b></font></div>"
                    + "<div style='text-align: center;'>"+agingLvlImg()+"</img></div>";
        } else {
            it.itemDesc += "<div style='text-align: center;'><font color='#dee7ff'><b>" + this.it.itemName + gearIcon()+"</b></font></div>";
        }

        if (!it.itemLore.isEmpty()) {
            it.itemDesc += "<div style='text-align: center;'><font color='#7db4af'> " + it.itemLore + "</font></div>";
        }
        //Status base
        /*
        stats aging
        mAtkMin = 0;
        mAtkMax = 0;
        mCritChance = 0;
        mAtkRtg = 0;
        mLvl = 0;
        mDefense = 0;
        mAbs = 0;
        mBlock = 0;
        mMp = 0;

         */
        it.itemDesc += "<br><table cellspacing='0' cellpadding='0' style='color: white'>";
        if ((it.MINatkMin != 0 && it.MAXatkMin != 0 && it.MINatkMax != 0 && it.MAXatkMax != 0) || (it.mMINAtkMin != 0 || it.mMAXAtkMin != 0 || it.mMINAtkMax != 0 || it.mMAXAtkMax != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINAtkMin + it.mMINAtkMax)) + rt() + "Attack Power:" + bt() + (it.MAXatkMin + it.mMAXAtkMin) + " - " + (it.MAXatkMax + it.mMAXAtkMax) + et() + ec(String.valueOf(it.mMINAtkMax));
        }
        if (it.atkSpd != 0 || it.mAtkSpd != 0) {
            it.itemDesc += ac(String.valueOf(it.mAtkSpd)) + rt() + "Attack Speed: " + bt() + (it.atkSpd + it.mAtkSpd) + ec(String.valueOf(it.mAtkSpd)) + et();
        }
        if (it.critChance != 0 || it.mCritChance != 0) {
            it.itemDesc += ac(String.valueOf(it.mCritChance)) + rt() + "Critical: " + bt() + (int) (it.critChance + it.mCritChance) + "%" + ec(String.valueOf(it.mCritChance)) + et();
        }
        if ((it.MINatkRtg != 0 && it.MAXatkRtg != 0) || (it.mMINAtkRtg != 0 && it.mMAXAtkRtg != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINAtkRtg)) + rt() + "Attack Rating: " + bt() + (it.MAXatkRtg + it.mMAXAtkRtg) + ec(String.valueOf(it.mMAXAtkRtg)) + et();
        }
        if ((it.MINCritDamage != 0 && it.MAXCritDamage != 0) || (it.mMINCritDamage != 0 && it.mMAXCritDamage != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINCritDamage)) + rt() + "Critical Damage: " + bt() + (it.MAXCritDamage + it.mMAXCritDamage) + "%" + ec(String.valueOf(it.mMAXCritDamage)) + et();
        }
        if (it.range != 0) {
            it.itemDesc += rt() + "Range: " + bt() + it.range + et();
        }
        if ((it.MINdefense != 0 && it.MAXdefense != 0) || (it.mMINdefense != 0 && it.mMAXdefense != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINdefense)) + rt() + "Defense: " + bt() + (int) (it.MAXdefense + it.mMAXdefense) + ec(String.valueOf(it.mMAXdefense)) + et();
        }
        if ((it.MINabs != 0 && it.MAXabs != 0) || (it.mMINabs != 0 && it.mMAXabs != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINabs)) + rt() + "Absorb: " + bt() + new DecimalFormat("0.0").format((it.MAXabs + it.mMAXabs)) + ec(String.valueOf(it.mMAXabs)) + et();
        }
        if ((it.MINblock != 0 && it.MAXblock != 0) || (it.mMINblock != 0 && it.mMAXblock != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINblock)) + rt() + "Block: " + bt() + new DecimalFormat("0.#").format((it.MAXblock + it.mMAXblock)) + "%" + ec(String.valueOf(it.mMAXblock)) + et();
        }
        if (it.MINevasion != 0 && it.MAXevasion != 0) {
            it.itemDesc += rt() + "Evasion: " + bt() + it.MAXevasion + "%" + et();
        }
        if ((it.MINmoveSpeed != 0 && it.MAXmoveSpeed != 0) || (it.mMINmoveSpeed != 0 && it.mMAXmoveSpeed != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINmoveSpeed)) + rt() + "Speed: " + bt() + (it.MAXmoveSpeed + it.mMAXmoveSpeed) + ec(String.valueOf(it.mMAXmoveSpeed)) + et();
        }
        if (it.MINintegrity != 0 && it.MAXintegrity != 0) {
            it.itemDesc += rt() + "Integrity: " + bt() + it.MAXintegrity + et();
        }
        if ((it.MINorganicResist != 0 && it.MAXorganicResist != 0) || (it.mMINorganicResist != 0 && it.mMAXorganicResist != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINorganicResist)) + rt() + "Organic: " + bt() + (it.MAXorganicResist + it.mMAXorganicResist) + ec(String.valueOf(it.mMAXorganicResist)) + et();
        }
        if ((it.MINfireResist != 0 && it.MAXfireResist != 0) || (it.mMINfireResist != 0 && it.mMAXfireResist != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINfireResist)) + rt() + "Fire: " + bt() + (it.MAXfireResist + it.mMAXfireResist) + ec(String.valueOf(it.mMAXfireResist)) + et();
        }
        if ((it.MINiceResist != 0 && it.MAXiceResist != 0) || (it.mMINiceResist != 0 && it.mMAXiceResist != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINiceResist)) + rt() + "Frost: " + bt() + (it.MAXiceResist + it.mMAXiceResist) + ec(String.valueOf(it.mMAXiceResist)) + et();
        }
        if ((it.MINlightningResist != 0 && it.MAXlightningResist != 0) || (it.mMINlightningResist != 0 && it.mMAXlightningResist != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINlightningResist)) + rt() + "Lightning: " + bt() + (it.MAXlightningResist + it.mMAXlightningResist) + ec(String.valueOf(it.mMAXlightningResist)) + et();
        }
        if ((it.MINpoisonResist != 0 && it.MAXpoisonResist != 0) || (it.mMINpoisonResist != 0 && it.mMAXpoisonResist != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINpoisonResist)) + rt() + "Poison: " + bt() + (it.MAXpoisonResist + it.mMAXpoisonResist) + ec(String.valueOf(it.mMAXpoisonResist)) + et();
        }
        if ((it.MINhpReg != 0 && it.MAXhpReg != 0) || (it.mMINhpReg != 0 && it.mMAXhpReg != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINhpReg)) + rt() + "HP Regen: " + bt() + (it.MAXhpReg + it.mMAXhpReg) + ec(String.valueOf(it.mMAXhpReg)) + et();
        }
        if ((it.MINmpReg != 0 && it.MAXmpReg != 0) || (it.mMINmpReg != 0 && it.mMAXmpReg != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINmpReg)) + rt() + "MP Regen: " + bt() + (it.MAXmpReg + it.mMAXmpReg) + ec(String.valueOf(it.mMAXmpReg)) + et();
        }
        if ((it.MINstmReg != 0 && it.MAXstmReg != 0) || (it.mMINstmReg != 0 && it.mMAXstmReg != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINstmReg)) + rt() + "STM Regen: " + bt() + (it.MAXstmReg + it.mMAXstmReg) + ec(String.valueOf(it.mMAXstmReg)) + et();
        }
        if ((it.MINhp != 0 && it.MAXhp != 0) || (it.mMINhp != 0 && it.mMAXhp != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINhp)) + rt() + "Add HP: " + bt() + (it.MAXhp + it.mMAXhp) + ec(String.valueOf(it.mMAXhp)) + et();
        }
        if ((it.MINmp != 0 && it.MAXmp != 0) || (it.mMINmp != 0 && it.mMAXmp != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINmp)) + rt() + "Add MP: " + bt() + (it.MAXmp + it.mMAXmp) + ec(String.valueOf(it.mMAXmp)) + et();
        }
        if ((it.MINstm != 0 && it.MAXstm != 0) || (it.mMINstm != 0 && it.mMAXstm != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINstm)) + rt() + "Add SP: " + bt() + (it.MAXstm + it.mMAXstm) + ec(String.valueOf(it.mMAXstm)) + et();
        }
        if (it.potCount != 0) {
            it.itemDesc += rt() + "Pot Count: " + bt() + it.potCount + et();
        }
        it.itemDesc += "</table>";

        //Requerimentos
        it.itemDesc += "<table cellspacing='0' cellpadding='0'>";
        if (it.rLvl != 0) {
            it.itemDesc += arlvl() + bt() + alm(String.valueOf(it.rLvl), String.valueOf(it.rLvl + it.mLvl)) + erlvl();
        }
        if (it.rStr != 0) {
            it.itemDesc += arstr() + bt() + arm(String.valueOf(it.rStr), String.valueOf(it.mMINstr), String.valueOf(it.mMAXstr)) + erstr();
        }
        if (it.rSpi != 0) {
            it.itemDesc += arspi() + bt() + arm(String.valueOf(it.rSpi), String.valueOf(it.mMINspi), String.valueOf(it.mMAXspi)) + erspi();
        }
        if (it.rTal != 0) {
            it.itemDesc += artal() + bt() + arm(String.valueOf(it.rTal), String.valueOf(it.mMINtal), String.valueOf(it.mMAXtal)) + ertal();
        }
        if (it.rAgi != 0) {
            it.itemDesc += aragi() + bt() + arm(String.valueOf(it.rAgi), String.valueOf(it.mMINagi), String.valueOf(it.mMAXagi)) + eragi();
        }
        if (it.rVit != 0) {
            it.itemDesc += arvit() + bt() + arm(String.valueOf(it.rVit), String.valueOf(it.mMINvit), String.valueOf(it.mMAXvit)) + eragi();
        }
        it.itemDesc += "</table>";

        //Spec
        it.itemDescSpec += "<div style='text-align: center;'><font color='#ffdc5f'>" + it.selectedSpec + " Spec</font></div>";
        it.itemDescSpec += "<table cellspacing='0' cellpadding='0'>";

        if (it.sMINdefense != 0 && it.sMAXdefense != 0) {
            it.itemDescSpec += rts() + "Spec Defense:" + bt() + it.sMAXdefense + ets();
        }
        if (it.sMINabs != 0 && it.sMAXabs != 0) {
            it.itemDescSpec += rts() + "Spec Absorb:" + bt() + new DecimalFormat("0.0").format(it.sMAXabs) + ets();
        }
        if (it.sCritChance != 0) {
            it.itemDescSpec += rts() + "Spec Critical:" + bt() + it.sCritChance + "%" + ets();
        }
        if (it.sDivAtkPow != 0) {
            it.itemDescSpec += rts() + "Spec ATK Pwr:" + bt() + "LV/" + it.sDivAtkPow + ets();
        }
        if (it.sMINDivAtkRtg != 0 && it.sMAXDivAtkRtg != 0) {
            it.itemDescSpec += rts() + "Spec ATK Rtg:" + bt() + "LV/" + it.sMINDivAtkRtg + ets();
        }
        if (it.sRange != 0) {
            it.itemDescSpec += rts() + "Spec Range:" + bt() + it.sRange + ets();
        }
        if (it.sMINmagicAPT != 0 && it.sMAXmagicAPT != 0) {
            it.itemDescSpec += rts() + "Magic APT:" + bt() + it.sMAXmagicAPT + ets();
        }
        if (it.sBlock != 0) {
            it.itemDescSpec += rts() + "Spec Block:" + bt() + new DecimalFormat("0.#").format(it.sBlock) + "%" + ets();
        }
        if (it.sMINmoveSpeed != 0 && it.sMAXmoveSpeed != 0) {
            it.itemDescSpec += rts() + "Spec Speed:" + bt() + it.sMAXmoveSpeed + ets();
        }
        if (it.sDivHp != 0) {
            it.itemDescSpec += rts() + "Max HP Boost:" + bt() + "LV/" + it.sDivHp + ets();
        }
        if (it.sDivHp != 0) {
            it.itemDescSpec += rts() + "Max HP Boost:" + bt() + "LV/" + it.sDivHp + ets();
        }
        if (it.sDivMp != 0) {
            it.itemDescSpec += rts() + "Max MP Boost:" + bt() + "LV/" + it.sDivMp + ets();
        }
        if (it.sHpReg != 0) {
            it.itemDescSpec += rts() + "Spec HP Regen:" + bt() + it.sHpReg + ets();
        }
        if (it.sMINmpReg != 0 && it.sMAXmpReg != 0) {
            it.itemDescSpec += rts() + "Spec MP Regen:" + bt() + it.sMAXmpReg + ets();
        }
        if (it.sStmReg != 0) {
            it.itemDescSpec += rts() + "Spec STM Regen:" + bt() + it.sStmReg + ets();
        }
        it.itemDescSpec += "</table>";
        
        if (!it.selectedSpec.equals("No Spec")) {
            it.itemDesc += it.itemDescSpec + it.itemDescMisc;
        } else {
            it.itemDesc += it.itemDescMisc;
        }

        it.itemDesc += "</div></html>";

    }

    /**
     * Row tag. Applies HTML tags used on beginning of table row lines to
     * display the Item Status within a table row.
     *
     * @return A String with
     * <tr><td style='width: 65px; margin: 0; padding: 0;'>
     */
    public String rt() {
        return "<tr><td style='width: 65px; margin: 0; padding: 0;'>";
    }

    /**
     * Row tag for spec stats. HTML tags used on beginning lines to display the
     * Item Status within a table row.
     *
     * @return A String with <font color='#a5c828'> and the return of rt()
     * method
     */
    public String rts() {
        return "<font color='#a5c828'>" + rt();
    }

    /**
     * Row tag for misc stats. HTML tags used on beginning lines to display the
     * Item Status within a table row.
     *
     * @return A String with <font color='#faf0be'> and the return of rt()
     * method
     */
    public String rtm() {
        return "<font color='#faf0be'>" + rt();
    }

    /**
     * Between values Tags. Applies tags after the Status name and before the
     * Item Status value. HTML to end and open tags on the middle of the table
     * row.
     *
     * @return '</td><b><td>' - Close Status name TD tag and opens B and TD for
     * the status value
     */
    public String bt() {
        return "</td><td><b>";
    }

    /**
     * Ending Tags. HTMl on the end of a Item Status table row.
     *
     * @return '</b></td></tr>' - Closes bold, td and tr tag after Item Stats
     * value.
     */
    public String et() {
        return "</b></td></tr>";
    }

    /**
     * Ending tags for spec stats. HTMl on the end of a Item Spec Status table
     * row.
     *
     * @return "</b></td></tr></font>" - Close bold, td, tr and font tag after
     * the Status Spec Value.
     */
    public String ets() {
        return "</b></td></tr></font>";
    }

    /**
     * Ending tags for misc stats. HTMl on the end of a Item Misc Status table
     * row.
     *
     * @return {< /b></td></tr></font >} - Finishes bold attribute, td,tr and
     * font tags after the Item Misc Status value
     */
    public String etm() {
        return "</b></td></tr></font>";
    }

    /**
     * Apply-Color: Applies a font color tag if the status of the item was
     * modified by aging or mixing.
     *
     * @param modValue - The modified status of an item
     * @return empty in case if is empty or zero, font color='#6ea5fa' if is
     * higher than 0
     */
    public String ac(String modValue) {
        if (modValue.equals("0") || modValue.equals("0.0")) {
            return "";
        } else {
            return "<font color='#6ea5fa'>";
        }
    }

    /**
     * End-Color: Checks if the status of an item is modified by aging or
     * mixing. If it does, adds a close font tag.
     *
     * @param modValue - The modified status of an item
     * @return empty if modValue is 0 or empty, </font> if modValue is higher
     * than 0
     */
    public String ec(String modValue) {
        if (modValue.equals("0") || modValue.equals("0.0")) {
            return "";
        } else {
            return "</font>";
        }
    }

    /**
     * Apply-Requirement Spec changes: Compares if modified values are different
     * than 0.
     *
     * @param origValue - The original item requirement status
     * @param modMINValue - The Modified minimum value of original item
     * requirement status
     * @param modMAXValue - The modified maximum value of original item
     * requirement
     * @return If modified requirement status by Class spec is the same as the
     * original, returns the original requirement value. Otherwise returns
     * originalValue->minValue/maxValue
     */
    public String ar(String origValue, String modMINValue, String modMAXValue) {
        if (origValue.equals(modMINValue) && origValue.equals(modMAXValue)) {
            return origValue;
        } else {
            return origValue + "->" + modMINValue + "/" + modMAXValue;
        }
    }

    /**
     * Apply-Requirement only minimum Spec Changes: Checks if the item
     * requirement status was modified by Class Spec. Returns the lowest, be it
     * the original or the modified. Compares if modified values are different
     * than 0.
     *
     * @param origValue - The original requirement of the item without spec
     * modifiers
     * @param modMINValue - The lowest requirement after being modified by spec
     * @param modMAXValue - The highest requirement after being modified by spec
     * @return A string with the lowest requirement value, original or modified
     * requirement value
     */
    public String arm(String origValue, String modMINValue, String modMAXValue) {
        if (origValue.equals(modMINValue) && origValue.equals(modMAXValue)) {
            return origValue;
        } else {
            return modMINValue;
        }
    }

    /**
     * Apply Requirement Level Changes: Checks if the item current required
     * level matches with the character that owns or is trying to equip the
     * item. Applies HTML code before the Req. Level word. Applies bold if
     * character level is lower.
     *
     * @return HTML font tag with a specific color. Red and bold for when the
     * character has lower leven than the item required level.
     */
    public String arlvl() {
        if (it.reqLvlMatch) {
            return "<font color='#f2ab5f'>" + rt() + "Req. Level: ";
        } else {
            return "<font color='red'>" + rt() + "<b>Req. Level: </b>";
        }
    }

    /**
     * End Required level changes: HTML tag code applied after the Item required
     * level table row
     *
     * @return closes bold, td, tr and font tags afer the required level number
     * value in table row.
     */
    public String erlvl() {
//        if (it.reqLvlMatch) {
//            return "";
//        } else {
//            return "</b></font>";
//        }

        return "</b></td></tr></font>";
    }

    /**
     * Apply-Requirement Strenght changes. HTML inserted before the Req.
     * -Status- word in table row.
     *
     * @return A font tag with a color - red if requirement doesnt match, the
     * return of rt() method and opens and closes bold tag between Red. -Status-
     * word.
     */
    public String arstr() {
        if (it.reqStrMatch) {
            return "<font color='#f2ab5f'>" + rt() + "Req. Strenght: ";
        } else {
            return "<font color='red'>" + rt() + "<b>Req. Strenght: </b>";
        }
    }

    /**
     * End-Requirement Strenght changes. HTML inserted after the Required status
     * value table row.
     *
     * @return HTML code that closes b, td, tr and font tags
     */
    public String erstr() {
        /*if (it.reqStrMatch) {
            return "</b>";
        } else {
            return "</b></font>";
        }*/
        return "</b></td></tr></font>";
    }

    /**
     * Apply-Requirement Spirit changes. HTML inserted before the Req. -Status-
     * word in table row.
     *
     * @return A font tag with a color - red if requirement doesnt match, the
     * return of rt() method and opens and closes bold tag between Red. -Status-
     * word.
     */
    public String arspi() {
        if (it.reqSpiMatch) {
            return "<font color='#f2ab5f'>" + rt() + "Req. Spirit: ";
        } else {
            return "<font color='red'>" + rt() + "<b>Req. Spirit: </b>";
        }
    }

    /**
     * End-Requirement Spirit changes. HTML inserted after the Required status
     * value table row.
     *
     * @return HTML code that closes b, td, tr and font tags
     */
    public String erspi() {
//        if (it.reqSpiMatch) {
//            return "";
//        } else {
//            return "</b></font>";
//        }

        return "</b></td></tr></font>";
    }

    /**
     * Apply-Requirement Talent changes. HTML inserted before the Req. -Status-
     * word in table row.
     *
     * @return A font tag with a color - red if requirement doesnt match, the
     * return of rt() method and opens and closes bold tag between Red. -Status-
     * word.
     */
    public String artal() {
        if (it.reqTalMatch) {
            return "<font color='#f2ab5f'>" + rt() + "Req. Talent: ";
        } else {
            return "<font color='red'>" + rt() + "<b>Req. Talent: </b>";
        }
    }

    /**
     * End-Requirement Talent changes. HTML inserted after the Required status
     * value table row.
     *
     * @return HTML code that closes b, td, tr and font tags
     */
    public String ertal() {
//        if (it.reqStrMatch) {
//            return "";
//        } else {
//            return "</b></font>";
//        }

        return "</b></td></tr></font>";
    }

    /**
     * Apply-Requirement Agility changes. HTML inserted before the Req. -Status-
     * word in table row.
     *
     * @return A font tag with a color - red if requirement doesnt match, the
     * return of rt() method and opens and closes bold tag between Red. -Status-
     * word.
     */
    public String aragi() {
        if (it.reqAgiMatch) {
            return "<font color='#f2ab5f'>" + rt() + "Req. Agility: ";
        } else {
            return "<font color='red'>" + rt() + "<b>Req. Agility: </b>";
        }
    }

    /**
     * End-Requirement Agility changes. HTML inserted after the Required status
     * value table row.
     *
     * @return HTML code that closes b, td, tr and font tags
     */
    public String eragi() {
//        if (it.reqAgiMatch) {
//            return "";
//        } else {
//            return "</b></font>";
//        }

        return "</b></td></tr></font>";
    }

    /**
     * Apply-Requirement Health changes. HTML inserted before the Req. -Status-
     * word in table row.
     *
     * @return A font tag with a color - red if requirement doesnt match, the
     * return of rt() method and opens and closes bold tag between Red. -Status-
     * word.
     */
    public String arvit() {
        if (it.reqAgiMatch) {
            return "<font color='#f2ab5f'>" + rt() + "Req. Health: ";
        } else {
            return "<font color='red'>" + rt() + "<b>Req. Health: </b>";
        }
    }

    /**
     * End-Requirement Health changes. HTML inserted after the Required status
     * value table row.
     *
     * @return HTML code that closes b, td, tr and font tags
     */
    public String ervit() {
//        if (it.reqAgiMatch) {
//            return "";
//        } else {
//            return "</b></font>";
//        }

        return "</b></td></tr></font>";
    }

    /**
     * Apply-Level changes. Checks if the item original
     * required level is different than the modified item required level due to aging
     * process.
     * @param origValue - Original item required level
     * @param modValue - Modified item required level
     * @return If item is aged, returns the originalLevel->modifiedLevel. If not, 
     * returns the original required item level.
     */
    public String al(String origValue, String modValue) {
        if (it.mLvl != 0) {
            return origValue + "->" + modValue;
        } else {
            return origValue;
        }
    }
    /**
     * Apply-Level only Modified changes.
     * Checks if the item required level has been changed at all.
     * @param origValue - Item original required level
     * @param modValue - Item modified required level
     * @return It item has a modified required level, returns it. If not, returns 
     * the original required level.
     */
    public String alm(String origValue, String modValue) {
        if (it.mLvl != 0) {
            return (modValue);
        } else {
            return origValue;
        }
    }
    
    /**
     * Builds HTML code with Primary and Secondary Spec possibilities
     * for the item. 
     * @return HTML code containing all class names that the item can have 
     * a spec class for.
     */
    public String getListaSpec() {

        String specHtml = "";
        int i = 0;
        if (it.classSpec.length == 1) {
            return "";
        }
        for (String spec : it.classSpec) {
            if (spec.equals("No Spec")) {
                return specHtml;
            } else {
                switch (i) {
                    case 0:
                        specHtml = "<br>Primary Spec: ";
                        specHtml += spec;
                        break;
                    case 1:
                        specHtml += "<br>Secondary Spec: ";
                        specHtml += spec;
                        break;
                    default:
                        specHtml += ", " + spec;
                        break;
                }
            }
            i++;
        }
        return specHtml;
    }

}
