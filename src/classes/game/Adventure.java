package classes.game;

import classes.characters.Monster;
import classes.characters.Player;
import classes.map.Labyrinth;

import java.util.*;
import java.util.stream.IntStream;

import static classes.game.DiceRollingGame.fightMonster;
import static classes.game.DifficultyLevels.rangeOfProbabilitiesMap;
import static classes.tools.MessagesEditor.*;
import static classes.tools.Pictures.*;
import static classes.tools.RandomGenerator.*;


public class Adventure {

    final static String[] gameRules = {
            "Welcome to Map of Fortune: Adventure!",
            "Important information before beginning:",
            "1) The goal of this game is to get out of a map",
            "2) You can find during your journey various items:",
            "STONE OF FORTUNE - will increase your fortune (minimum roll point)",
            "SHIELD - will take part of damage to itself",
            "WEAPON - can defeat one monster, then will disappear",
            "If you try to use weapon while you don't have one,",
            "you will get a damage from monster because of spending time for searching during a fight",
            "3) During journey you will meet monsters:",
            "You can run away from a monster, but you might get back damage",
            "You also can run away during fight, but it will mean loosing game",

    };
    public static Player player = new Player();
    public static Monster monster;
    static DifficultyLevels difficultyLevels;
    static Labyrinth labyrinth = new Labyrinth();
    static int countDefeatedInFightMonsters = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void startGame() {

        printInCommandFrame(new String[]{"Hi! Welcome to the game!", "How should we call you?"});
        printInputSymbols();
        player.setNameIfWritten();
        printInInformationFrame(new String[]{"Hi, " + player.getName() + "!"});
        chooseMap();
        chooseDifficultyLevel();
        printInInformationFrame(new String[]{"Here the shortest path!",
                "You can go this way or choose another one!"});
        labyrinth.showShortestPath();
        String[] messages = joinArrays(new String[]{"Let's start our GAME!"}, WELCOME);
        printInInformationFrame(messages);
        printInInformationFrame(gameRules);
        player.showCharacteristics();

        while (true) {
            int[] way_address = chooseTheNextLocation();
            getNextEvent(way_address);
        }
    }

    public static void chooseMap() {
        String[] list = labyrinth.getMapNames();
        String[] messages = new String[list.length + 1];
        messages[0] = player.getName() + ", choose map from list below:";
        for (int i = 1; i < list.length + 1; i++) {
            messages[i] = i + ". " + list[i - 1];
        }
        int[] rangeArray = IntStream.rangeClosed(1, list.length).toArray();
        String[] correctCommands = Arrays.stream(rangeArray)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        String mapNumber = getCorrectCommand(messages, correctCommands);
        labyrinth.convert(list[Integer.parseInt(mapNumber) - 1]);
    }

    public static void chooseDifficultyLevel() {
        String[] correctCommands = {"1", "2", "3"};
        String[] messages = {player.getName() + ", choose the difficulty level of your journey:",
                "1. easy", "2. medium", "3. hard"};
        String levelOfDifficulty = getCorrectCommand(messages, correctCommands);
        String[] levelMessages = {};
        switch (levelOfDifficulty) {
            case "1":
                levelMessages = new String[]{"You love nice journeys, enjoy it!"};
                difficultyLevels = DifficultyLevels.EASY;
                break;
            case "2":
                levelMessages = new String[]{"Good choice! I believe you will like it!"};
                difficultyLevels = DifficultyLevels.MEDIUM;
                break;
            case "3":
                levelMessages = new String[]{"I hope you're a lucky dude! Let's get started!"};
                difficultyLevels = DifficultyLevels.HARD;
                break;
        }
        printInInformationFrame(levelMessages);
        player.setHP(difficultyLevels.playerHP);
        player.setDamage(difficultyLevels.playerDamage);
    }

    public static String getCorrectCommand(String[] command_messages, String[] correctCommands) {
        while (true) {
            printInCommandFrame(command_messages);
            printInputSymbols();
            String command = scanner.nextLine();
            if (checkIfCommandCorrect(correctCommands, command)) {
                return command;
            }
        }
    }

    public static boolean checkIfCommandCorrect(String[] correctCommands, String command) {
        boolean isCorrect = Arrays.asList(correctCommands).contains(command);
        if (!isCorrect) {
            printInInformationFrame(new String[]{"Your command is incorrect, try another one!"});
        }
        return isCorrect;
    }

    public static int[] chooseTheNextLocation() {
        while (true) {
            labyrinth.showMap();
            String[] command_messages = {"To choose way enter: l(left), r(right), u(up), d(down) ",
                    "To show map enter: m", "To show shortest path: p", "To quit/restart enter: 0"};
            String[] correctCommands = {"l", "r", "u", "d", "m", "p", "0"};
            String nextWay = getCorrectCommand(command_messages, correctCommands);
            if (nextWay.equals("0")) {
                quitRestartGame();
            } else if (nextWay.equals("m")) {
                labyrinth.showMap();
            } else if (nextWay.equals("p")) {
                labyrinth.showShortestPath();
            } else {
                return findNextWayAddress(nextWay);
            }
        }
    }

    private static int[] findNextWayAddress(String way) {
        int[] way_address = player.getLocation().clone();
        switch (way) {
            case "l" -> way_address[1] -= 1;
            case "r" -> way_address[1] += 1;
            case "u" -> way_address[0] -= 1;
            case "d" -> way_address[0] += 1;
        }
        return way_address;
    }

    public static void quitRestartGame() {
        String[] correctCommands = {"1", "2", "0"};
        String[] command_messages = {"You want to quit or restart?", "1. quit", "2. restart", "0. return"};
        String choice = getCorrectCommand(command_messages, correctCommands);
        if (choice.equals("1")) {
            printInInformationFrame(new String[]{"Thank you for the game! See you later!"});
            System.exit(0);
        } else if (choice.equals("2")) {
            printInInformationFrame(new String[]{"Let's start new!"});
            startGame();
        }
    }

    public static void getNextEvent(int[] nextWayCoordinates) {
        boolean isRunAway = false;
        int[] currenLocation = player.getLocation();
        if (checkIfEntry(nextWayCoordinates)) {
            String[] messages = {"You can't go out from entry!!!"};
            printInInformationFrame(messages);
            return;
        } else if (checkIfExit(nextWayCoordinates)) {
            String[] messages = {"CONGRATULATIONS!", "====================", "YOU WON!!!"};
            printInInformationFrame(joinArrays(messages, WINNER));
            System.exit(0);
        } else if (checkIfLastLocation(nextWayCoordinates) && countDefeatedInFightMonsters == 0) {
            isRunAway = !meetMonster();
        } else {
            char nextMoveChar = getNexLocationChar(nextWayCoordinates);
            switch (nextMoveChar) {
                case 'x':
                    String[] messages = {"You can't go through walls!"};
                    printInInformationFrame(messages);
                    return;
                case '-':
                    double randomDouble = randomDouble();
                    Map<String, Double> range = rangeOfProbabilitiesMap(difficultyLevels);
                    if (randomDouble <= range.get("monsterProbability")) {
                        isRunAway = !meetMonster();
                    } else if (randomDouble <= range.get("weaponProbability")) {
                        player.pickUpWeapon();
                    } else if (randomDouble <= range.get("shieldProbability")) {
                        if (!player.hasStoneOfFortune()) {
                            player.pickUpStoneOfFortune();
                        }
                    } else if (randomDouble <= range.get("stoneOfFortuneProbability")) {
                        if (!player.hasShield()) {
                            player.pickUpShield();
                        }
                    }
                    break;
                case '@':
                    printInEventFrame(new String[]{"You've met a monster!"});
                    isRunAway = !meetMonster();
                    break;
            }
        }
        if (isRunAway) {
            runAwayFromMonster();
            labyrinth.maze[nextWayCoordinates[0]][nextWayCoordinates[1]] = '@';
        } else {
            labyrinth.maze[currenLocation[0]][currenLocation[1]] = 'o';
            labyrinth.maze[nextWayCoordinates[0]][nextWayCoordinates[1]] = '■';
            player.setLocation(nextWayCoordinates);
        }
    }

    public static boolean checkIfEntry(int[] coordinates) {
        int[] entry = {1, -1};
        return Arrays.equals(coordinates, entry);
    }

    public static boolean checkIfExit(int[] coordinates) {
        return coordinates[0] == labyrinth.maze.length || coordinates[0] == -1
                || coordinates[1] == labyrinth.maze[0].length || coordinates[1] == -1;
    }

    public static char getNexLocationChar(int[] nextWayCoordinates) {
        return labyrinth.maze[nextWayCoordinates[0]][nextWayCoordinates[1]];
    }

    public static boolean checkIfLastLocation(int[] coordinates) {
        return (!Arrays.equals(coordinates, new int[]{1, 0}))
                && (coordinates[0] == labyrinth.maze.length - 1 || coordinates[0] == 0
                || coordinates[1] == labyrinth.maze[0].length - 1 || coordinates[1] == 0
                && getNexLocationChar(coordinates) == '-');
    }

    public static boolean meetMonster() {
        monster = new Monster(difficultyLevels.monsterHP, difficultyLevels.monsterDamage);
        printInEventFrame(joinArrays(new String[]{"Oh no! There's a monster in the way!"}, MONSTER));
        player.showCharacteristics();
        monster.showCharacteristics();
        String[] command_messages = {player.getName() + ", what are you going to do next",
                "1. fight",
                "2. run away",
                "3. use a weapon",
                "0. quit/restart"};
        String[] correctCommands = {"1", "2", "3", "0"};
        while (true) {
            String nextDecision = getCorrectCommand(command_messages, correctCommands);
            switch (nextDecision) {
                case "1":
                    fightMonster();
                    return true;
                case "2":
                    return false;
                case "3":
                    if (!player.useWeapon()) {
                        fightMonster();
                    }
                    return true;
                case "0":
                    quitRestartGame();
                    break;
            }
        }
    }

    public static void runAwayFromMonster() {
        printInInformationFrame(new String[]{"Trying to run away from monster..."});
        if (willHappened(difficultyLevels.runAwayWithoutDamageProbability)) {
            printInInformationFrame(new String[]{"Congratulations, you run away successfully!"});
        } else {
            String[] messages = {"You got damage " + monster.takeDamage() + "HP in the back while running away!"};
            printInInformationFrame(messages);
            player.setHP(player.getHP() - monster.takeDamage());
            if (player.checkIfDead()) {
                endGameCauseDead();
            }
        }
        player.showCharacteristics();
    }

    public static void endGameCauseDead() {
        String[] messages = joinArrays(new String[]{
                        "You were killed by a monster!",
                        "You were brave till the end!",
                        "Try another one!"},
                GAME_OVER);
        printInInformationFrame(messages);
        System.exit(0);
    }

}