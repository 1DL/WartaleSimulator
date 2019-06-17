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
    protected boolean itemCanAge = false;
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
    protected String itemLore = "";
    
    public static final boolean ONEHANDED = false;
    public static final boolean TWOHANDED = true;

    public boolean isOneOrTwoHanded() {
        return oneOrTwoHanded;
    }

    public String getItemType() {
        return itemType;
    }
    
    public boolean isItemAgeable(){
        return itemCanAge;
    }

    //Requerimentos - r = base = m modificado por spec
    protected int rLvl = 0;
    protected int mLvl = 0;
    protected int rStr = 0;
    protected int mStr = 0;
    protected int rSpi = 0;
    protected int mSpi = 0;
    protected int rTal = 0;
    protected int mTal = 0;
    protected int rAgi = 0;
    protected int mAgi = 0;
    protected int rVit = 0;
    protected int mVit = 0;
    //Status base
    protected int MAXintegrity = 0;
    protected int MINintegrity = 0;
    //Ofensivos    
    protected int MINatkMin = 0;
    protected int MAXatkMin = 0;
    protected int mMINAtkMin = 0;
    protected int mMAXAtkMin = 0;
    protected int MINatkMax = 0;
    protected int MAXatkMax = 0;
    protected int mAtkMax = 0;
    protected int mMINAtkMax = 0;
    protected int mMAXAtkMax = 0;
    protected int MINatkRtg = 0;
    protected int MAXatkRtg = 0;
    protected int mAtkRtg = 0;
    protected int mMINAtkRtg = 0;
    protected int mMAXAtkRtg = 0;
    protected int atkSpd = 0;
    protected float critChance = 0;
    protected float mCritChance = 0;
    //Defensivos
    protected float MINdefense = 0;
    protected float MAXdefense = 0;
    protected float mMINdefense = 0;
    protected float mMAXdefense = 0;
    protected float MINblock = 0;
    protected float MAXblock = 0;
    protected float mMINblock = 0;
    protected float mMAXblock = 0;
    protected int MINevasion = 0;
    protected int MAXevasion = 0;
    protected float MINabs = 0;
    protected float MAXabs = 0;
    protected float mMINabs = 0;
    protected float mMAXabs = 0;
    protected int MINhp = 0;
    protected int MAXhp = 0;
    protected int mMINhp = 0;
    protected int mMAXhp = 0;
    protected float MINhpReg = 0;
    protected float MAXhpReg = 0;
    protected float mMINhpReg = 0;
    protected float mMAXhpReg = 0;
    protected int MINorganicResist = 0;
    protected int MINpoisonResist = 0;
    protected int MINiceResist = 0;
    protected int MINfireResist = 0;
    protected int MINlightningResist = 0;
    protected int MAXorganicResist = 0;
    protected int MAXpoisonResist = 0;
    protected int MAXiceResist = 0;
    protected int MAXfireResist = 0;
    protected int MAXlightningResist = 0;
    //gerais
    protected int range = 0;
    protected int MINmp = 0;
    protected int MAXmp = 0;
    protected int mMINmp = 0;
    protected int mMAXmp = 0;
    protected float MINmpReg = 0;
    protected float MAXmpReg = 0;
    protected int MINstm = 0;
    protected int MAXstm = 0;
    protected float MINstmReg = 0;
    protected float MAXstmReg = 0;
    protected float MINmoveSpeed = 0;
    protected float MAXmoveSpeed = 0;
    protected int potCount = 0;
    //misc
    protected String[] classSpec = new String[11];
    protected int weight = 0;
    protected double price = 0;    
    protected double agingCost = 0;
    protected double mixCost = 0;
    //spec ofensivo
    protected int sDivAtkPow = 0;
    protected int sMINDivAtkRtg = 0;
    protected int sMAXDivAtkRtg = 0;
    protected int sAtkSpd = 0;
    protected int sCritChance = 0;
    //spec defensivo    
    protected int sMINdefense = 0;
    protected int sMAXdefense = 0;
    protected float sBlock = 0;
    protected float sMINabs = 0;
    protected float sMAXabs = 0;
    protected int sDivHp = 0;
    protected float sHpReg = 0;
    //spec gerais
    protected int sDivMp = 0;
    protected float sMINmpReg = 0;
    protected float sMAXmpReg = 0;
    protected float sStmReg = 0;
    protected int sRange = 0;
    protected int sMagicAPT = 0;
    protected float sMINmoveSpeed = 0;
    protected float sMAXmoveSpeed = 0;

    public ItemStats() {

    }

    public void addAging(int agingLevel) {
        this.agingLevel = agingLevel;
        mMINAtkMin = 0;
        mMAXAtkMin = 0;
        mMAXAtkMax = 0;
        mMAXAtkMax = 0;
        mCritChance = 0;
        mMINAtkRtg = 0;
        mMAXAtkRtg = 0;
        mLvl = 0;
        mMINdefense = 0;
        mMAXdefense = 0;
        mMINabs = 0;
        mMAXabs = 0;
        mMINblock = 0;
        mMAXblock = 0;
        mMp = 0;
        agingCost = 0;

        switch (itemType) {
            case "Sword":
            case "Scythe":
            case "Claw":
            case "Dagger":
                for (int i = 1; i <= agingLevel; i++) {
                    calcularPrecoAging(i);
                    if (i <= 9) {
                        mMINAtkMin += 1;
                        mMAXAtkMin += 1;
                        mMINAtkMax += 1;
                        mMAXAtkMax += 1;
                        mCritChance += 0.5f;
                        mMINAtkRtg += 5;
                        mMAXAtkRtg += 5;
                    } else if (i > 9 && i <= 19) {
                        mMINAtkMin += 2;
                        mMAXAtkMin += 2;
                        mMINAtkMax += 2;
                        mMAXAtkMax += 2;
                        mCritChance += 0.5f;
                        mMINAtkRtg += 5;
                        mMAXAtkRtg += 5;
                    } else if (i >= 20) {
                        mMINAtkMin += 3;
                        mMAXAtkMin += 3;
                        mMINAtkMax += 3;
                        mMAXAtkMax += 3;
                        mCritChance += 0.5f;
                        mMINAtkRtg += 5;
                        mMAXAtkRtg += 5;
                    }
                    if (i % 2 == 0) {
                        mLvl++;
                    }
                }
                mCritChance = (float) Math.floor(mCritChance);
                break;
            case "Axe":
                for (int i = 1; i <= agingLevel; i++) {
                    calcularPrecoAging(i);
                    if (i <= 9) {
                        mMINAtkMin += 1;
                        mMAXAtkMin += 1;
                        mMINAtkMax += 1;
                        mMAXAtkMax += 1;
                        mMINAtkRtg += 10;
                        mMAXAtkRtg += 10;
                    } else if (i > 9 && i <= 19) {
                        mMINAtkMin += 2;
                        mMAXAtkMin += 2;
                        mMINAtkMax += 2;
                        mMAXAtkMax += 2;
                        mMINAtkRtg += 10;
                        mMAXAtkRtg += 10;
                    } else if (i >= 20) {
                        mMINAtkMin += 3;
                        mMAXAtkMin += 3;
                        mMINAtkMax += 3;
                        mMAXAtkMax += 3;
                        mMINAtkRtg += 10;
                        mMAXAtkRtg += 10;
                    }
                    if (i % 2 == 0) {
                        mLvl++;
                    }
                }
                break;
            case "Hammer":
                for (int i = 1; i <= agingLevel; i++) {
                    calcularPrecoAging(i);
                    if (i <= 9) {
                        mMINAtkMin += 1;
                        mMAXAtkMin += 1;
                        mMINAtkMax += 1;
                        mMAXAtkMax += 1;
                        mCritChance += 0.3f;
                        mMINAtkRtg += 8;
                        mMAXAtkRtg += 8;
                    } else if (i > 9 && i <= 19) {
                        mMINAtkMin += 2;
                        mMAXAtkMin += 2;
                        mMINAtkMax += 2;
                        mMAXAtkMax += 2;
                        mCritChance += 0.3f;
                        mMINAtkRtg += 8;
                        mMAXAtkRtg += 8;
                    } else if (i >= 20) {
                        mMINAtkMin += 3;
                        mMAXAtkMin += 3;
                        mMINAtkMax += 3;
                        mMAXAtkMax += 3;
                        mCritChance += 0.3f;
                        mMINAtkRtg += 8;
                        mMAXAtkRtg += 8;
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
                    calcularPrecoAging(i);
                    if (i <= 9) {
                        mMINAtkMin += 1;
                        mMAXAtkMin += 1;
                        mMINAtkMax += 1;
                        mMAXAtkMax += 1;
                        mCritChance += 0.5f;
                    } else if (i > 9 && i <= 19) {
                        mMINAtkMin += 2;
                        mMAXAtkMin += 2;
                        mMINAtkMax += 2;
                        mMAXAtkMax += 2;
                        mCritChance += 0.5f;
                    } else if (i >= 20) {
                        mMINAtkMin += 3;
                        mMAXAtkMin += 3;
                        mMINAtkMax += 3;
                        mMAXAtkMax += 3;
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
                    calcularPrecoAging(i);
                    if (i <= 9) {
                        mMINAtkMin += 1;
                        mMAXAtkMin += 1;
                        mMINAtkMax += 1;
                        mMAXAtkMax += 1;
                        mCritChance += 0.3f;
                        mMINAtkRtg += 10;
                        mMAXAtkRtg += 10;
                        mMp += 10;
                    } else if (i > 9 && i <= 19) {
                        mMINAtkMin += 2;
                        mMAXAtkMin += 2;
                        mMINAtkMax += 2;
                        mMAXAtkMax += 2;
                        mCritChance += 0.3f;
                        mMINAtkRtg += 10;
                        mMAXAtkRtg += 10;
                    } else if (i >= 20) {
                        mMINAtkMin += 3;
                        mMAXAtkMin += 3;
                        mMINAtkMax += 3;
                        mMAXAtkMax += 3;
                        mCritChance += 0.3f;
                        mMINAtkRtg += 10;
                        mMAXAtkRtg += 10;
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
                    calcularPrecoAging(i);
                    if (i <= 9) {
                        mMINdefense += (MINdefense + mMINdefense) * 0.05f;
                        mMAXdefense += (MAXdefense + mMAXdefense) * 0.05f;                        
                        mMINabs += 0.5f;
                        mMAXabs += 0.5f;
                    } else if (i > 9 && i <= 19) {
                        mMINdefense += (MINdefense + mMINdefense) * 0.05f;
                        mMAXdefense += (MAXdefense + mMAXdefense) * 0.05f;                        
                        mMINabs += 1f;
                        mMAXabs += 1f;
                    } else if (i >= 20) {
                        mMINdefense += (MINdefense + mMINdefense) * 0.05f;
                        mMAXdefense += (MAXdefense + mMAXdefense) * 0.05f;                        
                        mMINabs += 1.5f;
                        mMAXabs += 1.5f;
                    }
                    if (i % 2 == 0) {
                        mLvl++;
                    }
                    mMINdefense = (float) Math.floor(mMINdefense);
                    mMAXdefense = (float) Math.floor(mMINdefense);
                }
                break;
            case "Shield":
                for (int i = 1; i <= agingLevel; i++) {
                    calcularPrecoAging(i);
                    if (i <= 9) {
                        mMINdefense += 10;
                        mMAXdefense += 10;
                        mMINblock += 0.5f;
                        mMAXblock += 0.5f;
                        mMINabs += 0.4f;
                        mMAXabs += 0.4f;
                    } else if (i > 9 && i <= 19) {
                        mMINdefense += 20;
                        mMAXdefense += 20;
                        mMINblock += 0.5f;
                        mMAXblock += 0.5f;
                        mMINabs += 0.8f;
                        mMAXabs += 0.8f;
                    } else if (i >= 20) {
                        mMINdefense += 30;
                        mMAXdefense += 30;
                        mMINblock += 0.5f;
                        mMAXblock += 0.5f;
                        mMINabs += 1.2f;
                        mMAXabs += 1.2f;
                    }
                    if (i % 2 == 0) {
                        mLvl++;
                    }
                }
                break;
            case "Orb":
                for (int i = 1; i <= agingLevel; i++) {
                    calcularPrecoAging(i);
                    if (i <= 9) {
                        mMINdefense += (MINdefense + mMINdefense) * 0.1f;
                        mMAXdefense += (MAXdefense + mMAXdefense) * 0.1f; 
                        mMINabs += 0.5f;
                        mMAXabs += 0.5f;
                    } else if (i > 9 && i <= 19) {
                        mMINdefense += (MINdefense + mMINdefense) * 0.1f;
                        mMAXdefense += (MAXdefense + mMAXdefense) * 0.1f; 
                        mMINabs += 1f;
                        mMAXabs += 1f;
                    } else if (i >= 20) {
                        mMINdefense += (MINdefense + mMINdefense) * 0.1f;
                        mMAXdefense += (MAXdefense + mMAXdefense) * 0.1f; 
                        mMINabs += 1.5f;
                        mMAXabs += 1.5f;
                    }
                    if (i % 2 == 0) {
                        mLvl++;
                    }
                    mMINdefense = (float) Math.floor(mMINdefense);
                    mMAXdefense = (float) Math.floor(mMINdefense);
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
    
    private void calcularPrecoAging(int nvlAge) {
        float priceMultiplier = 0.5f * nvlAge;
        if (nvlAge >= 1 && nvlAge <=4) {
            agingCost = (price * priceMultiplier);
        } else if (nvlAge >= 5 && nvlAge <= 9) {
            agingCost =  (price * priceMultiplier) * 2;
        } else if (nvlAge >= 10 && nvlAge <= 14) {
            agingCost =  (price * priceMultiplier) * 3;
        } else if (nvlAge >= 15 && nvlAge <= 19) {
            agingCost =  (price * priceMultiplier) * 4;
        } else if (nvlAge >= 20 && nvlAge <= 24) {
            agingCost =  (price * priceMultiplier) * 5;
        } else if (nvlAge >= 25 && nvlAge <= 29) {
            agingCost =  (price * priceMultiplier) * 6;
        } else if (nvlAge >= 30 && nvlAge <= 34) {
            agingCost =  (price * priceMultiplier) * 7;
        } else if (nvlAge >= 35 && nvlAge <= 39) {
            agingCost =  (price * priceMultiplier) * 8;
        } else if (nvlAge >= 40 && nvlAge <= 44) {
            agingCost =  (price * priceMultiplier) * 9;
        } else if (nvlAge >= 45 && nvlAge <= 49) {
            agingCost =  (price * priceMultiplier) * 10;
        } else if (nvlAge >= 50 && nvlAge <= 59) {
            agingCost =  (price * priceMultiplier) * 11;
        } else if (nvlAge >= 60 && nvlAge <= 64) {
            agingCost =  (price * priceMultiplier) * 12;
        } else if (nvlAge >= 65 && nvlAge <= 69) {
            agingCost =  (price * priceMultiplier) * 13;
        } else if (nvlAge >= 70 && nvlAge <= 74) {
            agingCost =  (price * priceMultiplier) * 14;
        } else if (nvlAge >= 75 && nvlAge <= 79) {
            agingCost =  (price * priceMultiplier) * 15;
        } else if (nvlAge >= 80 && nvlAge <= 84) {
            agingCost =  (price * priceMultiplier) * 16;
        } else if (nvlAge >= 85 && nvlAge <= 89) {
            agingCost =  (price * priceMultiplier) * 17;
        } else if (nvlAge >= 90 && nvlAge <= 94) {
            agingCost =  (price * priceMultiplier) * 18;
        } else if (nvlAge >= 95 && nvlAge <= 99) {
            agingCost =  (price * priceMultiplier) * 19;
        } else if (nvlAge >= 100 && nvlAge <= 104) {
            agingCost =  (price * priceMultiplier) * 20;
        }
    }

    public void addAgingDefense(int agingLevel) {

    }
    /*
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
    }*/

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
        
        if (!itemLore.equals("")){
            itemDesc += "<font color='purple'> "+ itemDesc + "<br><br>";
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
        if (this.MINatkMin != 0 && this.MAXatkMin != 0 && this.MINatkMax != 0 && this.MAXatkMax != 0) {
            itemDesc += ac() + "Attack Power: " + (MINatkMin + mMINAtkMin) + "/" + (MAXatkMin + mMAXAtkMin) + " - " + (MINatkMax + mMINAtkMax) + "/" +(MAXatkMax + mMAXAtkMax) + ec() + "<br>";
        }
        if (this.atkSpd != 0) {
            itemDesc += "Attack Speed: " + this.atkSpd + "<br>";
        }
        if (this.critChance != 0) {
            itemDesc += ac() + "Critical: " + (this.critChance + this.mCritChance) + ec() + "<br>";
        }
        if (MINatkRtg != 0 && MAXatkRtg != 0) {
            itemDesc += ac() + "Attack Rating: " + (MINatkRtg + mMINAtkRtg) + "/" + (MAXatkRtg + mMAXAtkRtg) + ec() + "<br>";
        }
        if (range != 0) {
            itemDesc += "Range: " + range + "<br>";
        }
        if (MINdefense != 0 && MAXdefense != 0) {
            itemDesc += ac() + "Defense: " + (MINdefense + mMINdefense) + "/" +(MAXdefense + mMAXdefense) + ec() + "<br>";
        }
        if (MINabs != 0  && MAXabs != 0) {
            itemDesc += ac() + "Absorb: " + (MINabs + mMINabs) + "/" + (MAXabs + mMAXabs) + ec() + "<br>";
        }
        if (MINblock != 0 && MAXblock != 0) {
            itemDesc += ac() + "Block: " + (MINblock + mMINblock) + "/" + (MAXblock + mMAXblock) + ec() + "<br>";
        }
        if (MINevasion != 0 && MAXevasion != 0) {
            itemDesc += "Evasion: " + MINevasion + "/" + MAXevasion + "<br>";
        }
        if (moveSpeed != 0) {
            itemDesc += "Speed: " + moveSpeed + "<br>";
        }
        if (MINintegrity != 0 && MAXintegrity != 0) {
            itemDesc += ac() + "Integrity: " + MINintegrity + "/" + MAXintegrity + ec() + "<br>";
        }
        if (MINorganicResist != 0 && MAXorganicResist != 0) {
            itemDesc += "Organic: " + MINorganicResist + "/" + MAXorganicResist + "<br>";
        }
        if (MINfireResist != 0 && MAXfireResist != 0) {
            itemDesc += "Organic: " + MINfireResist + "/" + MAXfireResist + "<br>";
        }
        if (MINiceResist != 0 && MAXiceResist != 0) {
            itemDesc += "Organic: " + MINiceResist + "/" + MAXiceResist + "<br>";
        }
        if (MINlightningResist != 0 && MAXlightningResist != 0) {
            itemDesc += "Organic: " + MINlightningResist + "/" + MAXlightningResist + "<br>";
        }
        if (MINpoisonResist != 0 && MAXpoisonResist != 0) {
            itemDesc += "Organic: " + MINpoisonResist + "/" + MAXpoisonResist + "<br>";
        }
        if (MINhpReg != 0 && MAXhpReg != 0) {
            itemDesc += "HP Regen: " + MINhpReg + "/" + MAXhpReg + "<br>";
        }
        if (mpReg != 0) {
            itemDesc += "MP Regen: " + mpReg + "<br>";
        }
        if (stmReg != 0) {
            itemDesc += "STM Regen: " + stmReg + "<br>";
        }
        if (MINhp != 0 && MAXhp != 0) {
            itemDesc += "Add HP: " + MINhp + "/" + MAXhp + "<br>";
        }
        if (mp != 0) {
            itemDesc += ac() + "Add MP: " + (mp + mMp) + ec() + "<br>";
        }
        if (stm != 0) {
            itemDesc += "Add STM: " + stm + "<br>";
        }
        if (potCount != 0) {
            itemDesc += "Pot Count: " + potCount + "<br>";
        }
        itemDesc += "</font>";

        //Requerimentos
        itemDesc += "<font color='orange'>";
        if (rLvl != 0) {
            itemDesc += "Req. Level: " + (rLvl + mLvl) + "<br>";
        }
        if (rStr != 0) {
            itemDesc += "Req. Strenght: " + rStr + "<br>";
        }
        if (rSpi != 0) {
            itemDesc += "Req. Spirit: " + rSpi + "<br>";
        }
        if (rTal != 0) {
            itemDesc += "Req. Talent: " + rTal + "<br>";
        }
        if (rAgi != 0) {
            itemDesc += "Req. Agility: " + rAgi + "<br>";
        }
        if (rVit != 0) {
            itemDesc += "Req. Health: " + rVit + "<br>";
        }
        itemDesc += "</font>";

        //Spec
        itemDescSpec += "<font color='yellow'>    " + selectedSpec + " Spec</font><br>";
        itemDescSpec += "<font color='green'>";
        if (sCritChance != 0) {
            itemDescSpec += "Spec Critical: " + sCritChance + "<br>";
        }
        if (sDivAtkPow != 0) {
            itemDescSpec += "Spec ATK Pwr: LV/" + sDivAtkPow + "<br>";
        }
        if (sMINDivAtkRtg != 0 && sMAXDivAtkRtg != 0) {
            itemDescSpec += "Spec ATK Rtg: LV/" + sMINDivAtkRtg + "/" + sMAXDivAtkRtg + "<br>";
        }
        if (sRange != 0) {
            itemDescSpec += "Spec Range: " + sRange + "<br>";
        }
        if (sMagicAPT != 0) {
            itemDescSpec += "Magic APT : " + sMagicAPT + "<br>";
        }
        if (sDefense != 0) {
            itemDescSpec += "Spec Defense: " + sDefense + "<br>";
        }
        if (sAbs != 0) {
            itemDescSpec += "Spec Absorb: " + sAbs + "<br>";
        }
        if (sBlock != 0) {
            itemDescSpec += "Spec Block: " + sBlock + "<br>";
        }
        if (sMoveSpeed != 0) {
            itemDescSpec += "Spec Speed: " + sMoveSpeed + "<br>";
        }
        if (sDivHp != 0) {
            itemDescSpec += "Max HP Boost: LV/" + sDivHp + "<br>";
        }
        if (sDivHp != 0) {
            itemDescSpec += "Max HP Boost: LV/" + sDivHp + "<br>";
        }
        if (sDivMp != 0) {
            itemDescSpec += "Max MP Boost: LV/" + sDivMp + "<br>";
        }
        if (sHpReg != 0) {
            itemDescSpec += "Spec HP Regen: " + sHpReg + "<br>";
        }
        if (sMpReg != 0) {
            itemDescSpec += "Spec MP Regen: " + sMpReg + "<br>";
        }
        if (sStmReg != 0) {
            itemDescSpec += "Spec STM Regen: " + sStmReg + "<br>";
        }
        itemDescSpec += "</font>";

        //Misc
        itemDescMisc = "<font color='silver'><br>";
        if (price != 0) {
            itemDescMisc += "Price: " + price + "<br>";
        }
        if (weight != 0) {
            itemDescMisc += "Weight: " + weight + "<br>";
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
