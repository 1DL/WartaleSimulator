/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import formula.CharacterStats;
import formula.morion.Atalanta;
import formula.morion.Knight;
import formula.morion.Magician;
import formula.morion.Priestess;
import formula.morion.Shaman;
import formula.tempskron.Archer;
import formula.tempskron.Assassin;
import formula.tempskron.Fighter;
import formula.tempskron.Mechanician;
import formula.tempskron.Pikeman;
import item.ItemStats;
import java.util.ArrayList;

/**
 *
 * @author LuizV1
 */
public class Characters {

    private CharacterStats charStats;

    private String charName = "DarkLink64";
    private int level = 0;
    private int remainStats = 0;
    private int str = 0;
    private int spi = 0;
    private int tal = 0;
    private int agi = 0;
    private int vit = 0;
    

    private ItemStats armor;
    private ItemStats weapon1;
    private ItemStats weapon2;
    private ItemStats shield;

    private ItemStats bracelet;
    private ItemStats gaunglet;
    private ItemStats boots;

    private ItemStats sheltom;
    private ItemStats ring1;
    private ItemStats ring2;
    private ItemStats amulet;

    public Characters(String CharClass) {
        level = 155;
        switch (CharClass) {
            case "Archer":
                charStats = new Archer();
                break;
            case "Mechanician":
                charStats = new Mechanician();
                break;
            case "Fighter":
                charStats = new Fighter();
                break;
            case "Pikeman":
                charStats = new Pikeman();
                break;
            case "Assassin":
                charStats = new Assassin();
                break;
            case "Knight":
                charStats = new Knight();
                break;
            case "Atalanta":
                charStats = new Atalanta();
                break;
            case "Mage":
                charStats = new Magician();
                break;
            case "Priestess":
                charStats = new Priestess();
                break;
            case "Shaman":
                charStats = new Shaman();
                break;
        }
        charStats.setLevel(level);
        remainStats = charStats.getRemainStats();
        str = charStats.getStrenght();
        spi = charStats.getSpirit();
        tal = charStats.getTalent();
        agi = charStats.getAgility();
        vit = charStats.getHealth();

    }
    
    public ArrayList<Integer> getBaseStats(){
        ArrayList<Integer> listaStats = new ArrayList<>();
        listaStats.add(charStats.getBaseStr());
        listaStats.add(charStats.getBaseSpi());
        listaStats.add(charStats.getBaseTal());
        listaStats.add(charStats.getBaseAgi());
        listaStats.add(charStats.getBaseVit());
        return listaStats;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        charStats.setLevel(level);
    }

    public int getRemainStats() {
        return remainStats;
    }

    public void setRemainStats(int remainStats) {
        this.remainStats = remainStats;
    }
    
    public int resetRemainStats() {
        remainStats = charStats.getRemainStats();
        return remainStats;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getSpi() {
        return spi;
    }

    public void setSpi(int spi) {
        this.spi = spi;
    }

    public int getTal() {
        return tal;
    }

    public void setTal(int tal) {
        this.tal = tal;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public ItemStats getArmor() {
        return armor;
    }

    public void setArmor(ItemStats armor) {
        this.armor = armor;
    }

    public ItemStats getWeapon1() {
        return weapon1;
    }

    public void setWeapon1(ItemStats weapon1) {
        this.weapon1 = weapon1;
    }

    public ItemStats getWeapon2() {
        return weapon2;
    }

    public void setWeapon2(ItemStats weapon2) {
        this.weapon2 = weapon2;
    }

    public ItemStats getShield() {
        return shield;
    }

    public void setShield(ItemStats shield) {
        this.shield = shield;
    }

    public ItemStats getBracelet() {
        return bracelet;
    }

    public void setBracelet(ItemStats bracelet) {
        this.bracelet = bracelet;
    }

    public ItemStats getGaunglet() {
        return gaunglet;
    }

    public void setGaunglet(ItemStats gaunglet) {
        this.gaunglet = gaunglet;
    }

    public ItemStats getBoots() {
        return boots;
    }

    public void setBoots(ItemStats boots) {
        this.boots = boots;
    }

    public ItemStats getSheltom() {
        return sheltom;
    }

    public void setSheltom(ItemStats sheltom) {
        this.sheltom = sheltom;
    }

    public ItemStats getRing1() {
        return ring1;
    }

    public void setRing1(ItemStats ring1) {
        this.ring1 = ring1;
    }

    public ItemStats getRing2() {
        return ring2;
    }

    public void setRing2(ItemStats ring2) {
        this.ring2 = ring2;
    }

    public ItemStats getAmulet() {
        return amulet;
    }

    public void setAmulet(ItemStats amulet) {
        this.amulet = amulet;
    }

    public CharacterStats getCharStats() {
        return charStats;
    }
}
