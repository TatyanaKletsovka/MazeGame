package classes.characters;

import java.util.Objects;
import java.util.Scanner;

import static classes.game.Adventure.monster;
import static classes.tools.MessagesEditor.*;

public class Player extends Character {

    private String name = "Who_cannot_be_named";
    private int[] location = {1, 0};

    private int weaponQuantity = 0;
    private boolean stoneOfFortune = false;
    private boolean shield = false;

    private int shieldQuality = 10;
    private final int stoneOfFortuneQuality = 3;

    public Player(int HP, int damage) {
        super(HP, damage);
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setNameIfWritten() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (!Objects.equals(name, "")) {
            this.name = name;
        }
    }

    public int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    public boolean hasStoneOfFortune() {
        return stoneOfFortune;
    }

    public boolean hasShield() {
        return shield;
    }

    public void showCharacteristics() {
        String shieldMessage;
        String stoneOfFortuneMessage;
        if (!shield) {
            shieldMessage = "Shield: -";
        } else {
            shieldMessage = "Shield protection: " + shieldQuality;
        }
        if (!stoneOfFortune) {
            stoneOfFortuneMessage = "Stone of fortune: -";
        } else {
            stoneOfFortuneMessage = "Stone of fortune quality: " + stoneOfFortuneQuality;
        }
        String[] messages = {"Your game characteristics:",
                "Player: " + name,
                "HP: " + HP,
                "Damage: " + damage,
                "Weapons: " + weaponQuantity,
                shieldMessage,
                stoneOfFortuneMessage
        };

        printInInformationFrame(messages);
    }

    @Override
    public void takeDamage(int damagePoints) {
        if (shield) {
            damagePoints = useShield(damagePoints);
        }
        super.takeDamage(damagePoints);
    }

    public int useShield(int damagePoint) {
        int damageAfterEffect = damagePoint - shieldQuality;
        printInInformationFrame(new String[]{
                "The shield took " + shieldQuality + " damage points to itself!",
                "The shield is half broken!"});
        shieldQuality -= 5;
        if (shieldQuality == 0) {
            shield = false;
            shieldQuality = 15;
            printInInformationFrame(new String[]{"Shield was over used and was broken!"});
        }
        return damageAfterEffect;
    }

    public boolean useWeapon() {
        if (weaponQuantity == 0) {
            String[] message = {"You currently have no weapon...",
                    "While you were searching monster used the moment to attack."};
            printInInformationFrame(message);
            takeDamage(monster.damage);
            return false;
        } else {
            weaponQuantity--;
            printInInformationFrame(new String[]{"You used a Weapon", "The monster was defeated immediately!"});
            return true;
        }
    }

    public int useStoneOfFortune() {
        printInInformationFrame(new String[]{"The stone of fortune increased your minimum roll point!"});
        return stoneOfFortuneQuality;
    }

    public void pickUpWeapon() {
        printInEventFrame(new String[]{"You found a weapon!!!"});
        weaponQuantity++;
    }

    public void pickUpStoneOfFortune() {
        printInEventFrame(new String[]{"You found a stone of fortune!!!"});
        stoneOfFortune = true;
    }

    public void pickUpShield() {
        printInEventFrame(new String[]{"You found a shield!!!"});
        shield = true;
    }

}
