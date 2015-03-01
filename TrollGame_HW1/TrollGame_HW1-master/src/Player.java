import java.util.Random;
import java.util.Scanner;

/**
 * Player is the main character of the game.
 * He always gets random parameters of speed, power and intellect, hungry, etc.
 * from 0 to 10, when he born.
 * Player can answer the questions
 */
public class Player {

    /** Random number generator */
    private final static Random random = new Random();

    /** Max value of random number */
    private final static int maxRandom = 10;

    /** Player speed. */
    private int speed;

    /** Player power. */
    private int power;

    /** Player intellect. */
    private int intellect;

    /** Player hungry. */
    private int hungry;

    /** Player boring level. */
    private int bored;

    /**
     * Player constructor.
     */
    public Player() {
        speed = randomLevel();
        power = randomLevel();
        intellect = randomLevel();
        hungry = randomLevel();
        bored = randomLevel();
    }

    /**
     * Player answers to Troll.
     *
     * @param troll  Troll object
     * @return  Number
     */
    public int answerTo(Troll troll) {
        int i = 0;
        Scanner in;
        do {
            try {
                System.out.print("Your answer: ");
                in = new Scanner(System.in);
                i = in.nextInt();
            } catch (Exception e) {
                continue;
            }
        } while (i < 1 || i > 3);
        return i;
    }

    /**
     * Speed accessor.
     *
     * @return  Speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Power accessor.
     *
     * @return  Power
     */
    public int getPower() {
        return power;
    }

    /**
     * Intellect accessor.
     *
     * @return  Intellect
     */
    public int getIntellect() {
        return intellect;
    }

    /**
     * Hungry level accessor.
     *
     * @return  Hungry level
     */
    public int getHungry() {
        return hungry;
    }

    /**
     * Boring level accessor.
     *
     * @return  Boring level
     */
    public int getBored() {
        return bored;
    }

    /**
     * Get random level.
     * @return  Level
     */
    public static int randomLevel() {
        return random.nextInt(maxRandom);
    }
}
