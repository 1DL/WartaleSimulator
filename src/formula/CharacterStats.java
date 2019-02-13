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
    protected String classe;
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
    protected int total;

    protected static void setStrenght(int strenght) {
        CharacterStats.strenght = strenght;
    }

    protected static void setSpirit(int spirit) {
        CharacterStats.spirit = spirit;
    }

    protected static void setTalent(int talent) {
        CharacterStats.talent = talent;
    }

    protected static void setAgility(int agility) {
        CharacterStats.agility = agility;
    }

    protected static void setHealth(int health) {
        CharacterStats.health = health;
    }

    public static int getStrenght() {
        return strenght;
    }

    public static int getSpirit() {
        return spirit;
    }

    public static int getTalent() {
        return talent;
    }

    public static int getAgility() {
        return agility;
    }

    public static int getHealth() {
        return health;
    }
    
    public static int getRemainStat() {
        return remainStats;
    }
    
    
    
    
    protected static int strenght;
    protected static int spirit;
    protected static int talent;
    protected static int agility;
    protected static int health;
    protected static int remainStats = 25;
    
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
    
    public void setRemainStats(){
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
    }
    
    public int getRemainStats() {
     return this.remainStats;   
    }
    
    public static void setStatus(boolean subirStatus10, String tipoStat) {
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
}
