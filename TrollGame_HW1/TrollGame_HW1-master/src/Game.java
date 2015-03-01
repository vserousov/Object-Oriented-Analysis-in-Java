/**
 * Main class of the game.
 */
public class Game {

    /** Constant number of game iterations. **/
    public static int GAME_ITERATIONS = 4;

    /**
     * Program starts here.
     * Creating player and troll objects.
     * And then starts discussion between player and troll.
     *
     * @param args  Command line arguments
     */
    public static void main(String[] args) {
        Player player = new Player();
        Troll troll   = new Troll();
        start(troll);
        for (int i = 0; i < GAME_ITERATIONS; i++) {
            troll.ask(player);
            int answer = player.answerTo(troll);
            troll.listenTo(answer);
        }
        troll.sayGoodBye();
    }

    /**
     * Starting message.
     * It depends on troll parameters.
     *
     * @param troll  Troll Object
     */
    public static void start(Troll troll) {
        String hungryLevel = getTextLevel(troll.getHungry());
        String boredLevel = getTextLevel(troll.getBored());
        System.out.println("You were walking through the forest and suddenly" +
                " met a " + hungryLevel + " hungry and " + boredLevel + " bored Troll.");
    }

    /**
     * Some different adjectives for describing parameters.
     *
     * @param level  Level of player or troll
     * @return  Adjective
     */
    public static String getTextLevel(int level) {
        String result = "";

        if (level < 2) {
            result = "slightly";
        } else if (level >= 3 && level <= 6) {
            result = "quite";
        } else if (level >= 7 && level <= 8) {
            result = "very";
        } else  {
            result = "incredibly";
        }

        return result;
    }
}
