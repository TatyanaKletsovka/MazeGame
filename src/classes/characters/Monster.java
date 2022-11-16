package classes.characters;

import static classes.tools.MessagesEditor.printInInformationFrame;

public class Monster extends Character {
    public Monster(int HP, int damage) {
        super(HP, damage);
    }
    public void showCharacteristics() {
        String[] messages = {"Monster's characteristics:",
                "HP: " + HP,
                "Damage: " + damage,
        };
        printInInformationFrame(messages);
    }
}
