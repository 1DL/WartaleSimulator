/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.game.item;

import java.text.DecimalFormat;
import view.JdiGearSelector;

/**
 *
 * @author luiz
 */
public class ItemDescriptionFactory {

    Item it;
    
    /*
        render img on html
        <br><img src='"+this.getClass().getResource("/assets/images/logoTempskrons.png")+"'></img>
    */

    public ItemDescriptionFactory(Item it) {
        this.it = it;
    }

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
        it.itemViewDesc = "<html><div style='max-width: 300px'><div style='text-align: center;'>";
        if (!this.it.itemMix.isEmpty()) {
            it.itemViewDesc += "<font color='aqua'><b>" + this.it.itemName + "</b></font><br><font color='blue'>" + this.it.itemMix + "</font><br><br>";
        } else if (it.itemAged) {
            it.itemViewDesc += "<font color='yellow'><b>" + this.it.itemName + "</b></font><br><font color='white'>+" + this.it.agingLevel + "</font><br><br>";
        } else {
            it.itemViewDesc += "<font color='white'><b>" + this.it.itemName + "</b></font><br><br>";
        }

        if (!it.itemLore.isEmpty()) {
            it.itemViewDesc += "<font color='purple'> " + it.itemViewDesc + "</font><br><br>";
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
        it.itemViewDesc += "</div><font color='white'>";
        it.itemViewDesc += "<table>";
        if ((it.MINatkMin != 0 && it.MAXatkMin != 0 && it.MINatkMax != 0 && it.MAXatkMax != 0) || (it.mMINAtkMin != 0 || it.mMAXAtkMin != 0 || it.mMINAtkMax != 0 || it.mMAXAtkMax != 0)) {
            it.itemViewDesc += "<tr><td style='width: 150px'>" + ac(String.valueOf(it.mMINAtkMin + it.mMINAtkMax)) + "Attack Power:</td><td><b>" + (it.MINatkMin + it.mMINAtkMin) + "/" + (it.MAXatkMin + it.mMAXAtkMin) + " - " + (it.MINatkMax + it.mMINAtkMax) + "/" + (it.MAXatkMax + it.mMAXAtkMax) + ec(String.valueOf(it.mMINAtkMax)) + "</b></td></tr>";
        }
        it.itemViewDesc +="</table>";
        if (it.atkSpd != 0 || it.mAtkSpd != 0) {
            it.itemViewDesc += ac(String.valueOf(it.mAtkSpd)) + "Attack Speed: <b>" + (it.atkSpd + it.mAtkSpd) + ec(String.valueOf(it.mAtkSpd)) + "</b><br>";
        }
        if (it.critChance != 0 || it.mCritChance != 0) {
            it.itemViewDesc += ac(String.valueOf(it.mCritChance)) + "Critical: <b>" + (int) (it.critChance + it.mCritChance) + ec(String.valueOf(it.mCritChance)) + "</b><br>";
        }
        if ((it.MINatkRtg != 0 && it.MAXatkRtg != 0) || (it.mMINAtkRtg != 0 && it.mMAXAtkRtg != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINAtkRtg)) + "Attack Rating: <b>" + (it.MINatkRtg + it.mMINAtkRtg) + "/" + (it.MAXatkRtg + it.mMAXAtkRtg) + ec(String.valueOf(it.mMAXAtkRtg)) + "</b><br>";
        }
        if ((it.MINCritDamage != 0 && it.MAXCritDamage != 0) || (it.mMINCritDamage != 0 && it.mMAXCritDamage != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINCritDamage)) + "Critical Damage: <b>" + (it.MINCritDamage + it.mMINCritDamage) + "/" + (it.MAXCritDamage + it.mMAXCritDamage) + ec(String.valueOf(it.mMAXCritDamage)) + "</b><br>";
        }
        if (it.range != 0) {
            it.itemViewDesc += "Range: <b>" + it.range + "</b><br>";
        }
        if ((it.MINdefense != 0 && it.MAXdefense != 0) || (it.mMINdefense != 0 && it.mMAXdefense != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINdefense)) + "Defense: <b>" + (int) (it.MINdefense + it.mMINdefense) + "/" + (int) (it.MAXdefense + it.mMAXdefense) + ec(String.valueOf(it.mMAXdefense)) + "</b><br>";
        }
        if ((it.MINabs != 0 && it.MAXabs != 0) || (it.mMINabs != 0 && it.mMAXabs != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINabs)) + "Absorb: <b>" + new DecimalFormat("##.0").format((it.MINabs + it.mMINabs)) + "/" + new DecimalFormat("##.0").format((it.MAXabs + it.mMAXabs)) + ec(String.valueOf(it.mMAXabs)) + "</b><br>";
        }
        if ((it.MINblock != 0 && it.MAXblock != 0) || (it.mMINblock != 0 && it.mMAXblock != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINblock)) + "Block: <b>" + (it.MINblock + it.mMINblock) + "/" + (it.MAXblock + it.mMAXblock) + ec(String.valueOf(it.mMAXblock)) + "</b><br>";
        }
        if (it.MINevasion != 0 && it.MAXevasion != 0) {
            it.itemViewDesc += "Evasion: <b>" + it.MINevasion + "/" + it.MAXevasion + "</b><br>";
        }
        if ((it.MINmoveSpeed != 0 && it.MAXmoveSpeed != 0) || (it.mMINmoveSpeed != 0 && it.mMAXmoveSpeed != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINmoveSpeed)) + "Speed: <b>" + (it.MINmoveSpeed + it.mMINmoveSpeed) + "/" + (it.MAXmoveSpeed + it.mMAXmoveSpeed) + ec(String.valueOf(it.mMAXmoveSpeed)) + "</b><br>";
        }
        if (it.MINintegrity != 0 && it.MAXintegrity != 0) {
            it.itemViewDesc += "Integrity: <b>" + it.MINintegrity + "/" + it.MAXintegrity + "</b><br>";
        }
        if ((it.MINorganicResist != 0 && it.MAXorganicResist != 0) || (it.mMINorganicResist != 0 && it.mMAXorganicResist != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINorganicResist)) + "Organic: <b>" + (it.MINorganicResist + it.mMINorganicResist) + "/" + (it.MAXorganicResist + it.mMAXorganicResist) + ec(String.valueOf(it.mMAXorganicResist)) + "</b><br>";
        }
        if ((it.MINfireResist != 0 && it.MAXfireResist != 0) || (it.mMINfireResist != 0 && it.mMAXfireResist != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINfireResist)) + "Fire: <b>" + (it.MINfireResist + it.mMINfireResist) + "/" + (it.MAXfireResist + it.mMAXfireResist) + ec(String.valueOf(it.mMAXfireResist)) + "</b><br>";
        }
        if ((it.MINiceResist != 0 && it.MAXiceResist != 0) || (it.mMINiceResist != 0 && it.mMAXiceResist != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINiceResist)) + "Frost: <b>" + (it.MINiceResist + it.mMINiceResist) + "/" + (it.MAXiceResist + it.mMAXiceResist) + ec(String.valueOf(it.mMAXiceResist)) + "</b><br>";
        }
        if ((it.MINlightningResist != 0 && it.MAXlightningResist != 0) || (it.mMINlightningResist != 0 && it.mMAXlightningResist != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINlightningResist)) + "Lightning: <b>" + (it.MINlightningResist + it.mMINlightningResist) + "/" + (it.MAXlightningResist + it.mMAXlightningResist) + ec(String.valueOf(it.mMAXlightningResist)) + "</b><br>";
        }
        if ((it.MINpoisonResist != 0 && it.MAXpoisonResist != 0) || (it.mMINpoisonResist != 0 && it.mMAXpoisonResist != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINpoisonResist)) + "Poison: <b>" + (it.MINpoisonResist + it.mMINpoisonResist) + "/" + (it.MAXpoisonResist + it.mMAXpoisonResist) + ec(String.valueOf(it.mMAXpoisonResist)) + "</b><br>";
        }
        if ((it.MINhpReg != 0 && it.MAXhpReg != 0) || (it.mMINhpReg != 0 && it.mMAXhpReg != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINhpReg)) + "HP Regen: <b>" + (it.MINhpReg + it.mMINhpReg) + "/" + (it.MAXhpReg + it.mMAXhpReg) + ec(String.valueOf(it.mMAXhpReg)) + "</b><br>";
        }
        if ((it.MINmpReg != 0 && it.MAXmpReg != 0) || (it.mMINmpReg != 0 && it.mMAXmpReg != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINmpReg)) + "MP Regen: <b>" + (it.MINmpReg + it.mMINmpReg) + "/" + (it.MAXmpReg + it.mMAXmpReg) + ec(String.valueOf(it.mMAXmpReg)) + "</b><br>";
        }
        if ((it.MINstmReg != 0 && it.MAXstmReg != 0) || (it.mMINstmReg != 0 && it.mMAXstmReg != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINstmReg)) + "STM Regen: <b>" + (it.MINstmReg + it.mMINstmReg) + "/" + (it.MAXstmReg + it.mMAXstmReg) + ec(String.valueOf(it.mMAXstmReg)) + "</b><br>";
        }
        if ((it.MINhp != 0 && it.MAXhp != 0) || (it.mMINhp != 0 && it.mMAXhp != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINhp)) + "Add HP: <b>" + (it.MINhp + it.mMINhp) + "/" + (it.MAXhp + it.mMAXhp) + ec(String.valueOf(it.mMAXhp)) + "</b><br>";
        }
        if ((it.MINmp != 0 && it.MAXmp != 0) || (it.mMINmp != 0 && it.mMAXmp != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINmp)) + "Add MP: <b>" + (it.MINmp + it.mMINmp) + "/" + (it.MAXmp + it.mMAXmp) + ec(String.valueOf(it.mMAXmp)) + "</b><br>";
        }
        if ((it.MINstm != 0 && it.MAXstm != 0) || (it.mMINstm != 0 && it.mMAXstm != 0)) {
            it.itemViewDesc += ac(String.valueOf(it.mMINstm)) + "Add SP: <b>" + (it.MINstm + it.mMINstm) + "/" + (it.MAXstm + it.mMAXstm) + ec(String.valueOf(it.mMAXstm)) + "</b><br>";
        }
        if (it.potCount != 0) {
            it.itemViewDesc += "Pot Count: <b>" + it.potCount + "</b><br>";
        }
        it.itemViewDesc += "</font>";

        //Requerimentos
        it.itemViewDesc += "<font color='orange'>";
        if (it.rLvl != 0) {
            it.itemViewDesc += arlvl() + "Req. Level: <b>" + al(String.valueOf(it.rLvl), String.valueOf(it.rLvl + it.mLvl)) + erlvl() + "</b><br>";
        }
        if (it.rStr != 0) {
            it.itemViewDesc += arstr() + "Req. Strenght: <b>" + ar(String.valueOf(it.rStr), String.valueOf(it.mMINstr), String.valueOf(it.mMAXstr)) + erstr() + "</b><br>";
        }
        if (it.rSpi != 0) {
            it.itemViewDesc += arspi() + "Req. Spirit: <b>" + ar(String.valueOf(it.rSpi), String.valueOf(it.mMINspi), String.valueOf(it.mMAXspi)) + erspi() + "</b><br>";
        }
        if (it.rTal != 0) {
            it.itemViewDesc += artal() + "Req. Talent: <b>" + ar(String.valueOf(it.rTal), String.valueOf(it.mMINtal), String.valueOf(it.mMAXtal)) + ertal() + "</b><br>";
        }
        if (it.rAgi != 0) {
            it.itemViewDesc += aragi() + "Req. Agility: <b>" + ar(String.valueOf(it.rAgi), String.valueOf(it.mMINagi), String.valueOf(it.mMAXagi)) + eragi() + "</b><br>";
        }
        if (it.rVit != 0) {
            it.itemViewDesc += "Req. Health: <b>" + it.rVit + "</b><br>";
        }
        it.itemViewDesc += "</font>";

        //Spec
        it.itemDescSpec += "<div style='text-align: center;'><font color='yellow'>    " + it.selectedSpec + " Spec</font></div>";
        it.itemDescSpec += "<font color='green'>";
        if (it.sMINdefense != 0 && it.sMAXdefense != 0) {
            it.itemDescSpec += "Spec Defense: <b>" + it.sMINdefense + "/" + it.sMAXdefense + "</b><br>";
        }
        if (it.sMINabs != 0 && it.sMAXabs != 0) {
            it.itemDescSpec += "Spec Absorb: <b>" + it.sMINabs + "/" + it.sMAXabs + "</b><br>";
        }
        if (it.sCritChance != 0) {
            it.itemDescSpec += "Spec Critical: <b>" + it.sCritChance + "</b><br>";
        }
        if (it.sDivAtkPow != 0) {
            it.itemDescSpec += "Spec ATK Pwr: <b>LV/" + it.sDivAtkPow + "</b><br>";
        }
        if (it.sMINDivAtkRtg != 0 && it.sMAXDivAtkRtg != 0) {
            it.itemDescSpec += "Spec ATK Rtg: <b>LV/" + it.sMINDivAtkRtg + "-" + it.sMAXDivAtkRtg + "</b><br>";
        }
        if (it.sRange != 0) {
            it.itemDescSpec += "Spec Range: <b>" + it.sRange + "</b><br>";
        }
        if (it.sMINmagicAPT != 0 && it.sMAXmagicAPT != 0) {
            it.itemDescSpec += "Magic APT: <b>" + it.sMINmagicAPT + "/" + it.sMAXmagicAPT + "</b><br>";
        }
        if (it.sBlock != 0) {
            it.itemDescSpec += "Spec Block: <b>" + it.sBlock + "</b><br>";
        }
        if (it.sMINmoveSpeed != 0 && it.sMAXmoveSpeed != 0) {
            it.itemDescSpec += "Spec Speed: <b>" + it.sMINmoveSpeed + "/" + it.sMAXmoveSpeed + "</b><br>";
        }
        if (it.sDivHp != 0) {
            it.itemDescSpec += "Max HP Boost: <b>LV/" + it.sDivHp + "</b><br>";
        }
        if (it.sDivHp != 0) {
            it.itemDescSpec += "Max HP Boost: <b>LV/" + it.sDivHp + "</b><br>";
        }
        if (it.sDivMp != 0) {
            it.itemDescSpec += "Max MP Boost: <b>LV/" + it.sDivMp + "</b><br>";
        }
        if (it.sHpReg != 0) {
            it.itemDescSpec += "Spec HP Regen: <b>" + it.sHpReg + "</b><br>";
        }
        if (it.sMINmpReg != 0 && it.sMAXmpReg != 0) {
            it.itemDescSpec += "Spec MP Regen: <b>" + it.sMINmpReg + "/" + it.sMAXmpReg + "</b><br>";
        }
        if (it.sStmReg != 0) {
            it.itemDescSpec += "Spec STM Regen: <b>" + it.sStmReg + "</b><br>";
        }
        it.itemDescSpec += "</font>";

        //Misc
        it.itemDescMisc = "<font color='silver'><br>";
        if (it.price != 0) {
            it.itemDescMisc += "No Spec Price: <b>" + new DecimalFormat("###,###,###,###").format((int) it.price) + "</b><br>";
        }
        if (it.specPrice != 0) {
            it.itemDescMisc += "Spec Price: <b>" + new DecimalFormat("###,###,###,###").format((int) it.specPrice) + "</b><br>";
        }
        if (it.itemAged) {
            it.itemDescMisc += "Aging Price: <b>" + new DecimalFormat("###,###,###,###").format((int) it.agingCost) + "</b><br>";
        }
        if (it.itemAged) {
            it.itemDescMisc += "Total Aging Cost: <b>" + new DecimalFormat("###,###,###,###").format((int) it.totalAgingCost) + "</b><br>";
        }
        if (!it.itemMix.isEmpty()) {
            it.itemDescMisc += "Mix Price: <b>" + new DecimalFormat("###,###,###,###").format((int) it.mixCost) + "</b><br>";
        }
        if (it.weight != 0) {
            it.itemDescMisc += "Weight: <b>" + it.weight + "</b><br>";
        }

        it.itemDescMisc += getListaSpec();

        it.itemDescMisc += "</font>";

        if (!it.selectedSpec.equals("No Spec")) {
            it.itemViewDesc += it.itemDescSpec + it.itemDescMisc;
        } else {
            it.itemViewDesc += it.itemDescMisc;
        }

        it.itemViewDesc += "</div>";
    }

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
        it.itemDesc = "<html><div style='max-width: 200px'><div style='text-align: center;'>";
        if (!this.it.itemMix.isEmpty()) {
            it.itemDesc += "<font color='aqua'><b>" + this.it.itemName + "</b></font><br><font color='blue'>" + this.it.itemMix + "</font><br><br>";
        } else if (it.itemAged) {
            it.itemDesc += "<font color='yellow'><b>" + this.it.itemName + "</b></font><br><font color='white'>+" + this.it.agingLevel + "</font><br><br>";
        } else {
            it.itemDesc += "<font color='white'><b>" + this.it.itemName + "</b></font><br><br>";
        }

        if (!it.itemLore.isEmpty()) {
            it.itemDesc += "<font color='purple'> " + it.itemDesc + "</font><br><br>";
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
        it.itemDesc += "</div><font color='white'>";
        if ((it.MINatkMin != 0 && it.MAXatkMin != 0 && it.MINatkMax != 0 && it.MAXatkMax != 0) || (it.mMINAtkMin != 0 || it.mMAXAtkMin != 0 || it.mMINAtkMax != 0 || it.mMAXAtkMax != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINAtkMin + it.mMINAtkMax)) + "Attack Power: <b>" + (it.MAXatkMin + it.mMAXAtkMin) + " - " + (it.MAXatkMax + it.mMAXAtkMax) + ec(String.valueOf(it.mMINAtkMax)) + "</b><br>";
        }
        if (it.atkSpd != 0 || it.mAtkSpd != 0) {
            it.itemDesc += ac(String.valueOf(it.mAtkSpd)) + "Attack Speed: <b>" + (it.atkSpd + it.mAtkSpd) + ec(String.valueOf(it.mAtkSpd)) + "</b><br>";
        }
        if (it.critChance != 0 || it.mCritChance != 0) {
            it.itemDesc += ac(String.valueOf(it.mCritChance)) + "Critical: <b>" + (int) (it.critChance + it.mCritChance) + ec(String.valueOf(it.mCritChance)) + "</b><br>";
        }
        if ((it.MINatkRtg != 0 && it.MAXatkRtg != 0) || (it.mMINAtkRtg != 0 && it.mMAXAtkRtg != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINAtkRtg)) + "Attack Rating: <b>" + (it.MAXatkRtg + it.mMAXAtkRtg) + ec(String.valueOf(it.mMAXAtkRtg)) + "</b><br>";
        }
        if ((it.MINCritDamage != 0 && it.MAXCritDamage != 0) || (it.mMINCritDamage != 0 && it.mMAXCritDamage != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINCritDamage)) + "Critical Damage: <b>" + (it.MAXCritDamage + it.mMAXCritDamage) + ec(String.valueOf(it.mMAXCritDamage)) + "</b><br>";
        }
        if (it.range != 0) {
            it.itemDesc += "Range: <b>" + it.range + "</b><br>";
        }
        if ((it.MINdefense != 0 && it.MAXdefense != 0) || (it.mMINdefense != 0 && it.mMAXdefense != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINdefense)) + "Defense: <b>" + (int) (it.MAXdefense + it.mMAXdefense) + ec(String.valueOf(it.mMAXdefense)) + "</b><br>";
        }
        if ((it.MINabs != 0 && it.MAXabs != 0) || (it.mMINabs != 0 && it.mMAXabs != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINabs)) + "Absorb: <b>" + new DecimalFormat("##.0").format((it.MAXabs + it.mMAXabs)) + ec(String.valueOf(it.mMAXabs)) + "</b><br>";
        }
        if ((it.MINblock != 0 && it.MAXblock != 0) || (it.mMINblock != 0 && it.mMAXblock != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINblock)) + "Block: <b>" + (it.MAXblock + it.mMAXblock) + ec(String.valueOf(it.mMAXblock)) + "</b><br>";
        }
        if (it.MINevasion != 0 && it.MAXevasion != 0) {
            it.itemDesc += "Evasion: <b>" + it.MINevasion + "/" + it.MAXevasion + "</b><br>";
        }
        if ((it.MINmoveSpeed != 0 && it.MAXmoveSpeed != 0) || (it.mMINmoveSpeed != 0 && it.mMAXmoveSpeed != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINmoveSpeed)) + "Speed: <b>" + (it.MAXmoveSpeed + it.mMAXmoveSpeed) + ec(String.valueOf(it.mMAXmoveSpeed)) + "</b><br>";
        }
        if (it.MINintegrity != 0 && it.MAXintegrity != 0) {
            it.itemDesc += "Integrity: <b>" + it.MAXintegrity + "</b><br>";
        }
        if ((it.MINorganicResist != 0 && it.MAXorganicResist != 0) || (it.mMINorganicResist != 0 && it.mMAXorganicResist != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINorganicResist)) + "Organic: <b>" + (it.MAXorganicResist + it.mMAXorganicResist) + ec(String.valueOf(it.mMAXorganicResist)) + "</b><br>";
        }
        if ((it.MINfireResist != 0 && it.MAXfireResist != 0) || (it.mMINfireResist != 0 && it.mMAXfireResist != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINfireResist)) + "Fire: <b>" + (it.MAXfireResist + it.mMAXfireResist) + ec(String.valueOf(it.mMAXfireResist)) + "</b><br>";
        }
        if ((it.MINiceResist != 0 && it.MAXiceResist != 0) || (it.mMINiceResist != 0 && it.mMAXiceResist != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINiceResist)) + "Frost: <b>" + (it.MAXiceResist + it.mMAXiceResist) + ec(String.valueOf(it.mMAXiceResist)) + "</b><br>";
        }
        if ((it.MINlightningResist != 0 && it.MAXlightningResist != 0) || (it.mMINlightningResist != 0 && it.mMAXlightningResist != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINlightningResist)) + "Lightning: <b>" + (it.MAXlightningResist + it.mMAXlightningResist) + ec(String.valueOf(it.mMAXlightningResist)) + "</b><br>";
        }
        if ((it.MINpoisonResist != 0 && it.MAXpoisonResist != 0) || (it.mMINpoisonResist != 0 && it.mMAXpoisonResist != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINpoisonResist)) + "Poison: <b>" + (it.MAXpoisonResist + it.mMAXpoisonResist) + ec(String.valueOf(it.mMAXpoisonResist)) + "</b><br>";
        }
        if ((it.MINhpReg != 0 && it.MAXhpReg != 0) || (it.mMINhpReg != 0 && it.mMAXhpReg != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINhpReg)) + "HP Regen: <b>" + (it.MAXhpReg + it.mMAXhpReg) + ec(String.valueOf(it.mMAXhpReg)) + "</b><br>";
        }
        if ((it.MINmpReg != 0 && it.MAXmpReg != 0) || (it.mMINmpReg != 0 && it.mMAXmpReg != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINmpReg)) + "MP Regen: <b>" + (it.MAXmpReg + it.mMAXmpReg) + ec(String.valueOf(it.mMAXmpReg)) + "</b><br>";
        }
        if ((it.MINstmReg != 0 && it.MAXstmReg != 0) || (it.mMINstmReg != 0 && it.mMAXstmReg != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINstmReg)) + "STM Regen: <b>" + (it.MAXstmReg + it.mMAXstmReg) + ec(String.valueOf(it.mMAXstmReg)) + "</b><br>";
        }
        if ((it.MINhp != 0 && it.MAXhp != 0) || (it.mMINhp != 0 && it.mMAXhp != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINhp)) + "Add HP: <b>" + (it.MAXhp + it.mMAXhp) + ec(String.valueOf(it.mMAXhp)) + "</b><br>";
        }
        if ((it.MINmp != 0 && it.MAXmp != 0) || (it.mMINmp != 0 && it.mMAXmp != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINmp)) + "Add MP: <b>" + (it.MAXmp + it.mMAXmp) + ec(String.valueOf(it.mMAXmp)) + "</b><br>";
        }
        if ((it.MINstm != 0 && it.MAXstm != 0) || (it.mMINstm != 0 && it.mMAXstm != 0)) {
            it.itemDesc += ac(String.valueOf(it.mMINstm)) + "Add SP: <b>" + (it.MAXstm + it.mMAXstm) + ec(String.valueOf(it.mMAXstm)) + "</b><br>";
        }
        if (it.potCount != 0) {
            it.itemDesc += "Pot Count: <b>" + it.potCount + "</b><br>";
        }
        it.itemDesc += "</font>";

        //Requerimentos
        it.itemDesc += "<font color='orange'>";
        if (it.rLvl != 0) {
            it.itemDesc += arlvl() + "Req. Level: <b>" + alm(String.valueOf(it.rLvl), String.valueOf(it.rLvl + it.mLvl)) + erlvl() + "</b><br>";
        }
        if (it.rStr != 0) {
            it.itemDesc += arstr() + "Req. Strenght: <b>" + arm(String.valueOf(it.rStr), String.valueOf(it.mMINstr), String.valueOf(it.mMAXstr)) + erstr() + "</b><br>";
        }
        if (it.rSpi != 0) {
            it.itemDesc += arspi() + "Req. Spirit: <b>" + arm(String.valueOf(it.rSpi), String.valueOf(it.mMINspi), String.valueOf(it.mMAXspi)) + erspi() + "</b><br>";
        }
        if (it.rTal != 0) {
            it.itemDesc += artal() + "Req. Talent: <b>" + arm(String.valueOf(it.rTal), String.valueOf(it.mMINtal), String.valueOf(it.mMAXtal)) + ertal() + "</b><br>";
        }
        if (it.rAgi != 0) {
            it.itemDesc += aragi() + "Req. Agility: <b>" + arm(String.valueOf(it.rAgi), String.valueOf(it.mMINagi), String.valueOf(it.mMAXagi)) + eragi() + "</b><br>";
        }
        if (it.rVit != 0) {
            it.itemDesc += "Req. Health: <b>" + it.rVit + "</b><br>";
        }
        it.itemDesc += "</font>";

        //Spec
        it.itemDescSpec += "<div style='text-align: center;'><font color='yellow'>    " + it.selectedSpec + " Spec</font></div>";
        it.itemDescSpec += "<font color='green'>";
        if (it.sMINdefense != 0 && it.sMAXdefense != 0) {
            it.itemDescSpec += "Spec Defense: <b>" + it.sMAXdefense + "</b><br>";
        }
        if (it.sMINabs != 0 && it.sMAXabs != 0) {
            it.itemDescSpec += "Spec Absorb: <b>" + it.sMAXabs + "</b><br>";
        }
        if (it.sCritChance != 0) {
            it.itemDescSpec += "Spec Critical: <b>" + it.sCritChance + "</b><br>";
        }
        if (it.sDivAtkPow != 0) {
            it.itemDescSpec += "Spec ATK Pwr: <b>LV/" + it.sDivAtkPow + "</b><br>";
        }
        if (it.sMINDivAtkRtg != 0 && it.sMAXDivAtkRtg != 0) {
            it.itemDescSpec += "Spec ATK Rtg: <b>LV/" + it.sMINDivAtkRtg + "</b><br>";
        }
        if (it.sRange != 0) {
            it.itemDescSpec += "Spec Range: <b>" + it.sRange + "</b><br>";
        }
        if (it.sMINmagicAPT != 0 && it.sMAXmagicAPT != 0) {
            it.itemDescSpec += "Magic APT: <b>" + it.sMAXmagicAPT + "</b><br>";
        }
        if (it.sBlock != 0) {
            it.itemDescSpec += "Spec Block: <b>" + it.sBlock + "</b><br>";
        }
        if (it.sMINmoveSpeed != 0 && it.sMAXmoveSpeed != 0) {
            it.itemDescSpec += "Spec Speed: <b>" + it.sMAXmoveSpeed + "</b><br>";
        }
        if (it.sDivHp != 0) {
            it.itemDescSpec += "Max HP Boost: <b>LV/" + it.sDivHp + "</b><br>";
        }
        if (it.sDivHp != 0) {
            it.itemDescSpec += "Max HP Boost: <b>LV/" + it.sDivHp + "</b><br>";
        }
        if (it.sDivMp != 0) {
            it.itemDescSpec += "Max MP Boost: <b>LV/" + it.sDivMp + "</b><br>";
        }
        if (it.sHpReg != 0) {
            it.itemDescSpec += "Spec HP Regen: <b>" + it.sHpReg + "</b><br>";
        }
        if (it.sMINmpReg != 0 && it.sMAXmpReg != 0) {
            it.itemDescSpec += "Spec MP Regen: <b>" + it.sMAXmpReg + "</b><br>";
        }
        if (it.sStmReg != 0) {
            it.itemDescSpec += "Spec STM Regen: <b>" + it.sStmReg + "</b><br>";
        }
        it.itemDescSpec += "</font>";

        if (!it.selectedSpec.equals("No Spec")) {
            it.itemDesc += it.itemDescSpec;
        }

        it.itemDesc += "</div>";
        
    }

    /*Método que verifica se um valor adicional modificado é maior que zero.
    Caso seja, adiciona a tag de cor azul, para indicar que foi alterado por 
    efeito de Aging ou Mix.
    É chamado no começo da linha que adiciona o valor do status em questão
    no texto de descrição do item.
     */
    public String ac(String modValue) {
        if (modValue.equals("0") || modValue.equals("0.0")) {
            return "";
        } else {
            return "<font color='blue'>";
        }
    }

    /*Método que verifica se um valor adicional modificado é maior que zero.
    Caso seja, adiciona a tag de encerramento de cor, para indicar que foi alterado por 
    efeito de Aging ou Mix.
    É chamado no fim da linha que adiciona o valor do status em questão
    no texto de descrição do item.
     */
    public String ec(String modValue) {
        if (modValue.equals("0") || modValue.equals("0.0")) {
            return "";
        } else {
            return "</font>";
        }
    }

    /*Método que verifica se o requerimento de status foi alterado
    devido a efeitos de troca de Spec. Caso sim,
    adiciona uma seta e exibe os valores alterados.
     */
    public String ar(String origValue, String modMINValue, String modMAXValue) {
        if (origValue.equals(modMINValue) && origValue.equals(modMAXValue)) {
            return origValue;
        } else {
            return origValue + "->" + modMINValue + "/" + modMAXValue;
        }
    }
    
    public String arm(String origValue, String modMINValue, String modMAXValue) {
        if (origValue.equals(modMINValue) && origValue.equals(modMAXValue)) {
            return origValue;
        } else {
            return modMINValue;
        }
    }
    

    /*
    Métodos que verifica se os level/status do personagem dono do item batem com 
    os requerimentos do item. Caso não, renderiza a linha em negrito e vermelho.
     */
    public String arlvl() {
        if (it.reqLvlMatch) {
            return "";
        } else {
            return "<font color='red'><b>";
        }
    }

    public String erlvl() {
        if (it.reqLvlMatch) {
            return "";
        } else {
            return "</b></font>";
        }
    }

    public String arstr() {
        if (it.reqStrMatch) {
            return "";
        } else {
            return "<font color='red'><b>";
        }
    }

    public String erstr() {
        if (it.reqStrMatch) {
            return "";
        } else {
            return "</b></font>";
        }
    }

    public String arspi() {
        if (it.reqSpiMatch) {
            return "";
        } else {
            return "<font color='red'><b>";
        }
    }

    public String erspi() {
        if (it.reqSpiMatch) {
            return "";
        } else {
            return "</b></font>";
        }
    }

    public String artal() {
        if (it.reqTalMatch) {
            return "";
        } else {
            return "<font color='red'><b>";
        }
    }

    public String ertal() {
        if (it.reqStrMatch) {
            return "";
        } else {
            return "</b></font>";
        }
    }

    public String aragi() {
        if (it.reqAgiMatch) {
            return "";
        } else {
            return "<font color='red'><b>";
        }
    }

    public String eragi() {
        if (it.reqAgiMatch) {
            return "";
        } else {
            return "</b></font>";
        }
    }

    /*Método que verifica se o requerimento de level foi alterado
    devido a efeitos de Aging. Caso sim,
    adiciona uma seta e exibe os valores alterados.
     */
    public String al(String origValue, String modValue) {
        if (it.mLvl != 0) {
            return origValue + "->" + modValue;
        } else {
            return origValue;
        }
    }
    
    public String alm(String origValue, String modValue) {
        if (it.mLvl != 0) {
            return (modValue);
        } else {
            return origValue;
        }
    }

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
