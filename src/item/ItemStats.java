/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import javax.swing.JComboBox;

/**
 *
 * @author Administrator
 */
public class ItemStats {

    protected String itemClass = "";
    protected String itemType = "";
    protected String itemName = "";
    protected boolean itemAged = false;
    protected String ageType = "";
    protected int agingLevel = 0;
    protected String itemMix = "";
    protected String itemImgDir = null;
    protected String itemIconDir = "";
    protected String itemDesc = "";
    protected String itemDescSpec = "";
    protected String itemDescMisc = "";
    protected String selectedSpec = "";
    protected boolean oneOrTwoHanded = false;

    public boolean isOneOrTwoHanded() {
        return oneOrTwoHanded;
    }

    public String getItemType() {
        return itemType;
    }

    //Requerimentos
    protected int rLvl = 0;
    protected int mLvl = 0;
    protected int rStr = 0;
    protected int rSpi = 0;
    protected int rTal = 0;
    protected int rAgi = 0;
    protected int rVit = 0;
    //Status base
    protected int integrity = 0;
    //Ofensivos
    protected int atkMin = 0;
    protected int mAtkMin = 0;
    protected int atkMax = 0;
    protected int mAtkMax = 0;
    protected int atkRtg = 0;
    protected int mAtkRtg = 0;
    protected int atkSpd = 0;
    protected float critChance = 0;
    protected float mCritChance = 0;
    //Defensivos
    protected float defense = 0;
    protected float mDefense = 0;
    protected float block = 0;
    protected float mBlock = 0;
    protected int evasion = 0;
    protected float abs = 0;
    protected float mAbs = 0;
    protected int hp = 0;
    protected float hpReg = 0;
    protected int organicResist = 0;
    protected int poisonResist = 0;
    protected int iceResist = 0;
    protected int fireResist = 0;
    protected int lightningResist = 0;
    //gerais
    protected int range = 0;
    protected int mp = 0;
    protected int mMp = 0;
    protected float mpReg = 0;
    protected int stm = 0;
    protected float stmReg = 0;
    protected float moveSpeed = 0;
    protected int potCount = 0;
    //misc
    protected String primarySpec = "NS";
    protected String[] secondarySpec = new String[10];
    protected int weight = 0;
    protected int price = 0;
    //spec ofensivo
    protected int sDivAtkPow = 0;
    protected int sDivAtkRtg = 0;
    protected int sAtkSpd = 0;
    protected int sCritChance = 0;
    //spec defensivo    
    protected int sDefense = 0;
    protected float sBlock = 0;
    protected float sAbs = 0;
    protected int sDivHp = 0;
    protected float sHpReg = 0;
    //spec gerais
    protected int sDivMp = 0;
    protected float sMpReg = 0;
    protected float sStmReg = 0;
    protected int sRange = 0;
    protected int sMagicAPT = 0;
    protected float sMoveSpeed = 0;

    public ItemStats() {

    }

    public void addAging(int agingLevel) {
        this.agingLevel = agingLevel;
        mAtkMin = 0;
        mAtkMax = 0;
        mCritChance = 0;
        mAtkRtg = 0;
        mLvl = 0;
        mDefense = 0;
        mAbs = 0;
        mBlock = 0;
        mMp = 0;

        switch (itemType) {
            case "Sword":
            case "Scythe":
            case "Claw":
            case "Dagger":
                for (int i = 1; i <= agingLevel; i++) {
                    if (i <= 9) {
                        mAtkMin += 1;
                        mAtkMax += 1;
                        mCritChance += 0.5f;
                        mAtkRtg += 5;
                    } else if (i > 9 && i <= 19) {
                        mAtkMin += 2;
                        mAtkMax += 2;
                        mCritChance += 0.5f;
                        mAtkRtg += 5;
                    } else if (i >= 20) {
                        mAtkMin += 3;
                        mAtkMax += 3;
                        mCritChance += 0.5f;
                        mAtkRtg += 5;
                    }
                    if (i % 2 == 0) {
                        mLvl++;
                    }
                }
                mCritChance = (float) Math.floor(mCritChance);
                break;
            case "Axe":
                for (int i = 1; i <= agingLevel; i++) {
                    if (i <= 9) {
                        mAtkMin += 1;
                        mAtkMax += 1;
                        mAtkRtg += 10;
                    } else if (i > 9 && i <= 19) {
                        mAtkMin += 2;
                        mAtkMax += 2;
                        mAtkRtg += 10;
                    } else if (i >= 20) {
                        mAtkMin += 3;
                        mAtkMax += 3;
                        mAtkRtg += 10;
                    }
                    if (i % 2 == 0) {
                        mLvl++;
                    }
                }
                break;
            case "Hammer":
                for (int i = 1; i <= agingLevel; i++) {
                    if (i <= 9) {
                        mAtkMin += 1;
                        mAtkMax += 1;
                        mCritChance += 0.3f;
                        mAtkRtg += 8;
                    } else if (i > 9 && i <= 19) {
                        mAtkMin += 2;
                        mAtkMax += 2;
                        mCritChance += 0.3f;
                        mAtkRtg += 8;
                    } else if (i >= 20) {
                        mAtkMin += 3;
                        mAtkMax += 3;
                        mCritChance += 0.3f;
                        mAtkRtg += 8;
                    }
                    if (i % 2 == 0) {
                        mLvl++;
                    }
                }
                mCritChance = (float) Math.floor(mCritChance);
                break;
            case "Bow":
            case "Javelin":
                for (int i = 1; i <= agingLevel; i++) {
                    if (i <= 9) {
                        mAtkMin += 1;
                        mAtkMax += 1;
                        mCritChance += 0.5f;
                    } else if (i > 9 && i <= 19) {
                        mAtkMin += 2;
                        mAtkMax += 2;
                        mCritChance += 0.5f;
                    } else if (i >= 20) {
                        mAtkMin += 3;
                        mAtkMax += 3;
                        mCritChance += 0.5f;
                    }
                    if (i % 2 == 0) {
                        mLvl++;
                    }
                }
                mCritChance = (float) Math.floor(mCritChance);
                break;
            case "Wand":
            case "Staff":
            case "Phantom":
                for (int i = 1; i <= agingLevel; i++) {
                    if (i <= 9) {
                        mAtkMin += 1;
                        mAtkMax += 1;
                        mCritChance += 0.3f;
                        mAtkRtg += 10;
                        mMp += 10;
                    } else if (i > 9 && i <= 19) {
                        mAtkMin += 2;
                        mAtkMax += 2;
                        mCritChance += 0.3f;
                        mAtkRtg += 10;
                    } else if (i >= 20) {
                        mAtkMin += 3;
                        mAtkMax += 3;
                        mCritChance += 0.3f;
                        mAtkRtg += 10;
                        mMp += 10;
                    }
                    if (i % 2 == 0) {
                        mLvl++;
                    }
                }
                mCritChance = (float) Math.floor(mCritChance);
                break;
            case "Armor":
            case "Robe":
                for (int i = 1; i <= agingLevel; i++) {
                    if (i <= 9) {
                        mDefense += (defense + mDefense) * 0.05f;
                        mAbs += 0.5f;
                    } else if (i > 9 && i <= 19) {
                        mDefense += (defense + mDefense) * 0.05f;
                        mAbs += 1f;
                    } else if (i >= 20) {
                        mDefense += (defense + mDefense) * 0.05f;
                        mAbs += 1.5f;
                    }
                    if (i % 2 == 0) {
                        mLvl++;
                    }
                }
                break;
            case "Shield":
                for (int i = 1; i <= agingLevel; i++) {
                    if (i <= 9) {
                        mDefense += 10;
                        mBlock += 0.5f;
                        mAbs += 0.4f;
                    } else if (i > 9 && i <= 19) {
                        mDefense += 20;
                        mBlock += 0.5f;
                        mAbs += 0.8f;
                    } else if (i >= 20) {
                        mDefense += 30;
                        mBlock += 0.5f;
                        mAbs += 1.2f;
                    }
                    if (i % 2 == 0) {
                        mLvl++;
                    }
                }
                break;
            case "Orb":
                for (int i = 1; i <= agingLevel; i++) {
                    if (i <= 9) {
                        mDefense += (mDefense + defense) * 0.1f;
                        mAbs += 0.5f;
                    } else if (i > 9 && i <= 19) {
                        mDefense += (mDefense + defense) * 0.1f;
                        mAbs += 1f;
                    } else if (i >= 20) {
                        mDefense += (mDefense + defense) * 0.1f;
                        mAbs += 1.5f;
                    }
                    if (i % 2 == 0) {
                        mLvl++;
                    }
                }
                break;
            default:
                break;
        }

        if (agingLevel > 0) {
            itemAged = true;
        } else {
            itemAged = false;
        }

        createItemDesc();
    }

    public void addAgingDefense(int agingLevel) {

    }

    public void atualizarListaSpec(JComboBox cmbSpec) {
        cmbSpec.removeAllItems();
        cmbSpec.addItem(primarySpec);
        for (String secondSpec : this.secondarySpec) {
            try {
                cmbSpec.addItem(secondSpec);
            } catch (NullPointerException npe) {

            }
        }
        cmbSpec.addItem(String.valueOf("No Spec"));
    }

    public void setSelectedSpec(String classe) {
        this.selectedSpec = classe;
        createItemDesc();
    }

    public String getItemImgDir() {
        return itemImgDir;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void createItemDesc() {
        itemDesc = "";
        itemDescSpec = "";
        itemDescMisc = "";
        //Definição cabeçalho
        itemDesc = "<html>";
        if (!this.itemMix.equals("")) {
            itemDesc += "<font color='aqua'>" + this.itemName + "</font><br><font color='blue'>" + this.itemMix + "</font><br><br>";
        } else if (itemAged) {
            itemDesc += "<font color='yellow'>" + this.itemName + "</font><br><font color='white'>+" + this.agingLevel + "</font><br><br>";
        } else {
            itemDesc += "<font color='white'>" + this.itemName + "<br><br>";
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
        itemDesc += "<font color='white'>";
        if (this.atkMin != 0 && this.atkMax != 0) {
            itemDesc += ac() + "Attack Power: " + (this.atkMin + this.mAtkMin) + " - " + (this.atkMax + this.mAtkMax) + ec() + "<br>";
        }
        if (this.atkSpd != 0) {
            itemDesc += "Attack Speed: " + this.atkSpd + "<br>";
        }
        if (this.critChance != 0) {
            itemDesc += ac() + "Critical: " + (this.critChance + this.mCritChance) + ec() + "<br>";
        }
        if (this.atkRtg != 0) {
            itemDesc += ac() + "Attack Rating: " + (this.atkRtg + this.mAtkRtg) + ec() + "<br>";
        }
        if (this.range != 0) {
            itemDesc += "Range: " + this.range + "<br>";
        }
        if (this.defense != 0) {
            itemDesc += ac() + "Defense: " + (this.defense + this.mDefense) + ec() + "<br>";
        }
        if (this.abs != 0) {
            itemDesc += ac() + "Absorb: " + (this.abs + this.mAbs) + ec() + "<br>";
        }
        if (this.block != 0) {
            itemDesc += ac() + "Block: " + (this.block + this.mBlock) + ec() + "<br>";
        }
        if (this.evasion != 0) {
            itemDesc += "Evasion: " + this.evasion + "<br>";
        }
        if (this.moveSpeed != 0) {
            itemDesc += "Speed: " + this.moveSpeed + "<br>";
        }
        if (this.integrity != 0) {
            itemDesc += ac() + "Integrity: " + this.integrity + "/" + this.integrity + ec() + "<br>";
        }
        if (this.organicResist != 0) {
            itemDesc += "Organic: " + this.organicResist + "<br>";
        }
        if (this.fireResist != 0) {
            itemDesc += "Fire: " + this.fireResist + "<br>";
        }
        if (this.iceResist != 0) {
            itemDesc += "Frost: " + this.iceResist + "<br>";
        }
        if (this.lightningResist != 0) {
            itemDesc += "Lightning: " + this.lightningResist + "<br>";
        }
        if (this.poisonResist != 0) {
            itemDesc += "Poison: " + this.poisonResist + "<br>";
        }
        if (this.hpReg != 0) {
            itemDesc += "HP Regen: " + this.hpReg + "<br>";
        }
        if (this.mpReg != 0) {
            itemDesc += "MP Regen: " + this.mpReg + "<br>";
        }
        if (this.stmReg != 0) {
            itemDesc += "STM Regen: " + this.stmReg + "<br>";
        }
        if (this.hp != 0) {
            itemDesc += "Add HP: " + this.hp + "<br>";
        }
        if (this.mp != 0) {
            itemDesc += ac() + "Add MP: " + (this.mp + this.mMp) + ec() + "<br>";
        }
        if (this.stm != 0) {
            itemDesc += "Add STM: " + this.stm + "<br>";
        }
        if (this.potCount != 0) {
            itemDesc += "Pot Count: " + this.potCount + "<br>";
        }
        itemDesc += "</font>";

        //Requerimentos
        itemDesc += "<font color='orange'>";
        if (this.rLvl != 0) {
            itemDesc += "Req. Level: " + (this.rLvl + this.mLvl) + "<br>";
        }
        if (this.rStr != 0) {
            itemDesc += "Req. Strenght: " + this.rStr + "<br>";
        }
        if (this.rSpi != 0) {
            itemDesc += "Req. Spirit: " + this.rSpi + "<br>";
        }
        if (this.rTal != 0) {
            itemDesc += "Req. Talent: " + this.rTal + "<br>";
        }
        if (this.rAgi != 0) {
            itemDesc += "Req. Agility: " + this.rAgi + "<br>";
        }
        if (this.rVit != 0) {
            itemDesc += "Req. Health: " + this.rVit + "<br>";
        }
        itemDesc += "</font>";

        //Spec
        itemDescSpec += "<font color='yellow'>    " + this.selectedSpec + " Spec</font><br>";
        itemDescSpec += "<font color='green'>";
        if (this.sCritChance != 0) {
            itemDescSpec += "Spec Critical: " + this.sCritChance + "<br>";
        }
        if (this.sDivAtkPow != 0) {
            itemDescSpec += "Spec ATK Pwr: LV/" + this.sDivAtkPow + "<br>";
        }
        if (this.sDivAtkRtg != 0) {
            itemDescSpec += "Spec ATK Rtg: LV/" + this.sDivAtkRtg + "<br>";
        }
        if (this.sRange != 0) {
            itemDescSpec += "Spec Range: " + this.sRange + "<br>";
        }
        if (this.sMagicAPT != 0) {
            itemDescSpec += "Magic APT : " + this.sMagicAPT + "<br>";
        }
        if (this.sDefense != 0) {
            itemDescSpec += "Spec Defense: " + this.sDefense + "<br>";
        }
        if (this.sAbs != 0) {
            itemDescSpec += "Spec Absorb: " + this.sAbs + "<br>";
        }
        if (this.sBlock != 0) {
            itemDescSpec += "Spec Block: " + this.sBlock + "<br>";
        }
        if (this.sMoveSpeed != 0) {
            itemDescSpec += "Spec Speed: " + this.sMoveSpeed + "<br>";
        }
        if (this.sDivHp != 0) {
            itemDescSpec += "Max HP Boost: LV/" + this.sDivHp + "<br>";
        }
        if (this.sDivHp != 0) {
            itemDescSpec += "Max HP Boost: LV/" + this.sDivHp + "<br>";
        }
        if (this.sDivMp != 0) {
            itemDescSpec += "Max MP Boost: LV/" + this.sDivMp + "<br>";
        }
        if (this.sHpReg != 0) {
            itemDescSpec += "Spec HP Regen: " + this.sHpReg + "<br>";
        }
        if (this.sMpReg != 0) {
            itemDescSpec += "Spec MP Regen: " + this.sMpReg + "<br>";
        }
        if (this.sStmReg != 0) {
            itemDescSpec += "Spec STM Regen: " + this.sStmReg + "<br>";
        }
        itemDescSpec += "</font>";

        //Misc
        itemDescMisc = "<font color='silver'><br>";
        if (this.price != 0) {
            itemDescMisc += "Price: " + this.price + "<br>";
        }
        if (this.weight != 0) {
            itemDescMisc += "Weight: " + this.weight + "<br>";
        }
        itemDescMisc += "</font>";

        if (!selectedSpec.equals("No Spec")) {
            itemDesc += itemDescSpec + itemDescMisc;
        } else {
            itemDesc += itemDescMisc;
        }
    }

    public String ac() {
        if (this.itemAged) {
            return "<font color='blue'>";
        } else {
            return "";
        }
    }

    public String ec() {
        if (this.itemAged) {
            return "</font>";
        } else {
            return "";
        }
    }
}
