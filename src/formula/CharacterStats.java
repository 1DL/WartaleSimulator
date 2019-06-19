/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula;

/**
 *
 * @author Administrator
 */
public class CharacterStats {

    
    //Personagem
    private String nome;
    private String classe;
    private String title;
    protected int level;
    
    //Resistência Elemental
    protected int organic; 
    protected int poison; 
    protected int fire;
    protected int lightning;
    protected int ice;
    protected int water;
    
    //HP, Stamina, Mana e seus regens
    protected float hp;
    protected float stm;
    protected float mp;
    protected float hpReg;
    protected float stmReg;
    protected float mpReg;
    
    //Pontos de stats
    protected int totalStats;    
    private int strenght;
    private int spirit;
    private int talent;
    private int agility;
    private int health;
    private int remainStats = 25;
    
    //Pontos de stats base
    private int baseStr;
    private int baseSpi;
    private int baseTal;
    private int baseAgi;
    private int baseVit;
    
    //Status normais
    protected float attackRating;
    protected float attackDamageMin;
    protected float attackDamageMax;
    protected float defense;
    protected float abs;
    protected float moveSpeed;
    
    //Status ocultos
    protected float attackSpeed;
    protected float block;
    protected float critChance;
    protected float critDamage;
    protected float[] evasion;
    protected float damageReduction;
    
    //Itens equipados
    protected String weaponType;
    protected String weaponClass;
    protected int weaponMinAtk;
    protected int weaponMaxAtk;
    protected int weaponSpecDamage;
    protected int weaponSpecAttackRating;
    protected int gauntletSpecDamage;
    protected int sheltomMinAtk;
    protected int sheltomMaxAtk;
    
    //Buffs e Coroas
    protected String forceOrb;
    protected String siegeWarCrown;
    
    public CharacterStats(String classe, int level, int strenght, int spirit, 
            int talent, int agility, int health, String weaponType, 
            int weaponMinAtk, int weaponMaxAtk, int weaponSpecDamage, int weaponSpecAttackRating,
            String forceOrb, String siegeWarCrown, int gauntletSpecDamage, 
            int sheltomMinAtk, int sheltomMaxAtk) {
        this.classe = classe;
        this.level = level;
        this.strenght = strenght;
        this.spirit = spirit;
        this.talent = talent;
        this.agility = agility;
        this.health = health;
        this.weaponType = weaponType;
        if (weaponType.equals("Bow") || weaponType.equals("Javelin")){
            this.weaponClass = "Ranged";
        } else if(weaponType.equals("Wand") || weaponType.equals("Phantom")){
            this.weaponClass = "Magic";
        } else if(weaponType.equals("No Weapon")){
            this.weaponClass = "No Weapon";
        } else {
            this.weaponClass = "Melee";
        }
        this.weaponMinAtk = weaponMinAtk;
        this.weaponMaxAtk = weaponMaxAtk;
        this.weaponSpecDamage = weaponSpecDamage;
        this.weaponSpecAttackRating = weaponSpecAttackRating;
        this.forceOrb = forceOrb;
        this.siegeWarCrown = siegeWarCrown;
        this.gauntletSpecDamage = gauntletSpecDamage;
        this.sheltomMinAtk = sheltomMinAtk;
        this.sheltomMaxAtk = sheltomMaxAtk;
        
        
    }

    public CharacterStats() {
    }
    
    

    public float getAttackDamageMin() {
        return attackDamageMin;
    }

    public void setAttackDamageMin(float attackDamageMin) {
        this.attackDamageMin = attackDamageMin;
    }

    public float getAttackDamageMax() {
        return attackDamageMax;
    }

    public void setAttackDamageMax(float attackDamageMax) {
        this.attackDamageMax = attackDamageMax;
    }
    
    public void updateRemainStats(){
        this.remainStats = 25;
        for (int i = 2; i <= this.level; i++) {
            if(i <= 79) {
                this.remainStats += 5;
            } else if( i > 79 && i <= 89) {
                this.remainStats += 7;
            } else {
                this.remainStats += 10;
            }
        }
        this.totalStats = remainStats;
        if ((remainStats + 99 )< (strenght + spirit + talent + agility + health)) {
            this.strenght = this.baseStr;
            this.spirit = this.baseSpi;
            this.talent = this.baseTal;
            this.agility = this.baseAgi;
            this.health = this.baseVit;
        }
        this.remainStats = remainStats + 99 - (strenght + spirit + talent + agility + health);
        
    }
    
        
    public int getRemainStats() {
     return this.remainStats;   
    }
    
    public void setStatus(boolean subirStatus10, String tipoStat) {
        if (remainStats != 0){
            if(remainStats > 9 && subirStatus10){
                switch (tipoStat) {
                    case "str":
                        strenght += 10;
                        remainStats -= 10;
                        break;
                    case "spi":
                        spirit += 10;
                        remainStats -= 10;
                        break;
                    case "tal": 
                        talent += 10;
                        remainStats -= 10;
                        break;
                    case "agi":
                        agility += 10;
                        remainStats -= 10;
                        break;
                    case "hp":
                        health += 10;
                        remainStats -= 10;
                        break;
                }
            } else {
                switch (tipoStat) {
                    case "str":
                        strenght += 1;
                        remainStats -= 1;
                        break;
                    case "spi":
                        spirit += 1;
                        remainStats -= 1;
                        break;
                    case "tal":
                        talent += 1;
                        remainStats -= 1;
                        break;
                    case "agi":
                        agility += 1;
                        remainStats -= 1;
                        break;
                    case "hp":
                        health += 1;
                        remainStats -= 1;
                        break;
                }
            }
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        updateRemainStats();
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
        updateRemainStats();
    }

    public int getSpirit() {
        return spirit;
    }

    public void setSpirit(int spirit) {
        this.spirit = spirit;
        updateRemainStats();
    }

    public int getTalent() {
        return talent;
    }

    public void setTalent(int talent) {
        this.talent = talent;
        updateRemainStats();
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
        updateRemainStats();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        updateRemainStats();
    }

    public int getBaseStr() {
        return baseStr;
    }

    public void setBaseStr(int baseStr) {
        this.baseStr = baseStr;
        this.strenght = this.baseStr;
    }

    public int getBaseSpi() {
        return baseSpi;
    }

    public void setBaseSpi(int baseSpi) {
        this.baseSpi = baseSpi;
        this.spirit = this.baseSpi;
    }

    public int getBaseTal() {
        return baseTal;
    }

    public void setBaseTal(int baseTal) {
        this.baseTal = baseTal;
        this.talent = this.baseTal;
    }

    public int getBaseAgi() {
        return baseAgi;
    }

    public void setBaseAgi(int baseAgi) {
        this.baseAgi = baseAgi;
        this.agility = this.baseAgi;
    }

    public int getBaseVit() {
        return baseVit;
    }

    public void setBaseVit(int baseVit) {
        this.baseVit = baseVit;
        this.health = this.baseVit;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
    
    
}
