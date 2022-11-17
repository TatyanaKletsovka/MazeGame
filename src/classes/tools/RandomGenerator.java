package classes.tools;

import java.util.Random;

public class RandomGenerator {

    private static final Random random = new Random();

    public static boolean willHappened(double probability){
        return random.nextDouble() < probability;
    }

    public static double randomDouble(){
        return random.nextDouble();
    }

    public static int getRandomIntInRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
