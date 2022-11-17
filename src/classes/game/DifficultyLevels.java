package classes.game;

import java.util.HashMap;
import java.util.Map;

public enum DifficultyLevels {
    EASY(0.1, 0.05, 0.12, 0.1, 0.5, 100, 30, 30, 15),
    MEDIUM(0.12, 0.04, 0.11, 0.08, 0.45, 90, 30, 15, 15),
    HARD(0.15, 0.03, 0.1, 0.05, 0.4, 80, 30, 10, 15);

    public final double monsterProbability;
    public final double weaponProbability;
    public final double shieldProbability;
    public final double stoneOfFortuneProbability;
    public final double runAwayWithoutDamageProbability;
    public final int playerHP;
    public final int monsterHP;
    public final int playerDamage;
    public final int monsterDamage;

    DifficultyLevels(double monsterProbabilityArg, double weaponProbabilityArg,
                     double shieldProbabilityArg, double stoneOfFortuneProbabilityArg,
                     double runAwayWithoutDamageProbabilityArg,
                     int playerHPArg, int monsterHPArg, int playerDamageArg, int monsterDamageArg) {
        monsterProbability = monsterProbabilityArg;
        weaponProbability = weaponProbabilityArg;
        shieldProbability = shieldProbabilityArg;
        stoneOfFortuneProbability = stoneOfFortuneProbabilityArg;
        runAwayWithoutDamageProbability = runAwayWithoutDamageProbabilityArg;
        playerHP = playerHPArg;
        monsterHP = monsterHPArg;
        playerDamage = playerDamageArg;
        monsterDamage = monsterDamageArg;
    }

    public static Map<String, Double> rangeOfProbabilitiesMap(DifficultyLevels difficultyLevel) {
        Map<String, Double> map = new HashMap<>();
        double range = difficultyLevel.monsterProbability;
        map.put("monsterProbability", range);
        range += difficultyLevel.weaponProbability;
        map.put("weaponProbability", range);
        range += difficultyLevel.shieldProbability;
        map.put("shieldProbability", range);
        range += difficultyLevel.stoneOfFortuneProbability;
        map.put("stoneOfFortuneProbability", range);
        return map;
    }

}

