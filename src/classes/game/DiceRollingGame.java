package classes.game;

import static classes.game.Adventure.*;
import static classes.tools.MessagesEditor.printInInformationFrame;
import static classes.tools.RandomGenerator.getRandomIntInRange;

public class DiceRollingGame {

    public static void fightMonster() {
        String[] messages = {"Time To Fight!!!"};
        printInInformationFrame(messages);
        printInInformationFrame(new String[]
                        {"====================================",
                        "|   Starting dice rolling mini game  |",
                        "===================================="});
        while (player.getHP() != 0 && monster.getHP() != 0) {
            player.showCharacteristics();
            monster.showCharacteristics();
            String[] command_messages = {player.getName() + ", choose one number of options below:",
                    "1. roll",
                    "2. run away",
                    "3. use a weapon"};
            String[] correctCommands = {"1", "2", "3"};
            String correctCommand = getCorrectCommand(command_messages, correctCommands);
            switch (correctCommand) {
                case "1":
                    roll();
                    break;
                case "2":
                    printInInformationFrame(new String[]{"You can't run away from fight", " The game will end!"});
                    quitRestartGame();
                    break;
                case "3":
                    if (player.useWeapon()) {
                        monster.setHP(0);
                    }
                    break;
            }
        }
        if (player.checkIfDead()) {
            endGameCauseDead();
        } else {
            printInInformationFrame(new String[]{"Awesome, you defeated a monster!", "Let's continue our journey!"});
            player.showCharacteristics();
            countDefeatedInFightMonsters++;
        }
    }

    public static void roll() {
        int playerMinRollPoint = player.getMinRollPoint();
        if (player.hasStoneOfFortune()) {
            playerMinRollPoint += player.useStoneOfFortune();
        }
        int monstersRollPoint = getRandomIntInRange(monster.getMinRollPoint(), monster.getMaxRollPoint() + 1);
        int playersRollPoint = getRandomIntInRange(playerMinRollPoint, player.getMaxRollPoint() + 1);
        String[] textMessages = {
                "Monster rolls first!", "Rolling... " + monstersRollPoint,
                "Now, " + player.getName() + "'s turn!",
                "Rolling... " + playersRollPoint};

        printInInformationFrame(textMessages);

        if (monstersRollPoint == playersRollPoint) {
            printInInformationFrame(new String[]{"You both have the same roll points! Let's try again!"});
        } else if (monstersRollPoint > playersRollPoint) {
            printInInformationFrame(new String[]{
                    "Monster rolled more points",
                    "Monster makes damage " + monster.takeDamage()});
            player.takeDamage(monster.takeDamage());
        } else {
            printInInformationFrame(new String[]{player.getName() + " rolled more points",
                    player.getName() + " makes damage " + player.takeDamage()});
            monster.takeDamage(player.takeDamage());
        }
    }

}
