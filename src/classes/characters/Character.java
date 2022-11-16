package classes.characters;

public class Character {
    protected int HP;
    protected int damage;

    private final int MIN_ROLL_POINT = 1;
    private final int MAX_ROLL_POINT = 10;

    public Character() {
    }

    public Character(int HP, int damage) {
        this.HP = HP;
        this.damage = damage;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int takeDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMinRollPoint() {
        return MIN_ROLL_POINT;
    }

    public int getMaxRollPoint() {
        return MAX_ROLL_POINT;
    }

    public void showCharacteristics() {
    }

    public boolean checkIfDead(){
        return this.HP <= 0;
    }

    public void takeDamage(int damagePoints) {
        HP -= damagePoints;
        if(HP < 0) {
            HP = 0;
        }
    }
}
