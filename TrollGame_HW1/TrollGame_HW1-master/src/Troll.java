/**
 * Troll extends Player, it has skills also
 * but it's quite different from player
 * Troll can ask questions
 * and can react on the answers
 */
public class Troll extends Player {

    /** Angry parameter. */
    private boolean angry;

    /** Questions asked. */
    private int step;

    /**
     * Troll constructor
     */
    public Troll() {
        super();
        angry = isAngry();
        step  = 1;
    }

    /**
     * Returns true if troll is angry.
     *
     * @return  True if level is more than 5,
     *    otherwise return False
     */
    private boolean isAngry() {
        if (randomLevel() >= 5) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Troll ask player.
     *
     * @param player  Player object
     */
    public void ask(Player player) {
        switch (step) {
            case 1:
                if (this.angry) {
                    shout("Ha-ha-ha, I want to kill you, stupid player... " +
                            "So, what can you offer me that I will change my mind?\n" +
                            "1) Some food\n" +
                            "2) Some drink\n" +
                            "3) Tell me a story \n");
                } else {
                    shout("Hey, guy! My name is Troll. Can you help me? I need one of these things: \n" +
                    "1) 1000$ dollar\n" +
                            "2) New car\n" +
                            "3) New house \n");
                }
                break;
            case 2:
                if (this.getSpeed() > player.getSpeed()) {
                    shout("I think that we can challenge into running throw the forest, what do you think? \n" +
                            "1) Yes \n" +
                            "2) No \n" +
                            "3) I don't know \n"
                    );
                } else {
                    shout("You are looking so fast, so let's challenge into running throw the forest? \n" +
                            "1) Yes \n" +
                            "2) No \n" +
                            "3) I don't know \n"
                    );
                }
                break;
            case 3:
                if (this.getPower() > player.getPower()) {
                    shout("I am so powerful, ahahahahaha, let's fight! \n" +
                            "1) Ok, go \n" +
                            "2) No, I'm afraid \n" +
                            "3) What is fighting? \n");
                } else {
                    shout("You looks strong, would you like to participate in sparring? \n" +
                            "1) Ok, go \n" +
                            "2) No, I'm afraid \n" +
                            "3) What is fighting? \n");
                }
                break;
            case 4:
                if (this.getIntellect() > player.getIntellect()) {
                    shout("You looks so stupid, lol, I think I can win you in chess, checkers and even in a poker." +
                            "In which game you'd like to play with me? \n" +
                            "1) Chess \n" +
                            "2) Checkers \n" +
                            "3) Poker \n");
                } else {
                    shout("Hmm...You looks clever, but lets play in chess, checkers or in a poker and we " +
                            "will see who of us are smarter. What game do you prefer? \n" +
                            "1) Chess \n" +
                            "2) Checkers \n" +
                            "3) Poker \n");
                }
                break;
        }
    }

    /**
     * Troll reaction on player answers.
     *
     * @param answer  Answer
     */
    public void listenTo(int answer) {
        switch (step) {
            case 1:
                if (this.angry) {
                    shout("Hmm...it's ok, but anyway, you're stupid!");
                } else {
                    shout("Thanks, guy! You've really helped me!");
                }
                break;
            case 2:
                if (answer == 1) {
                    shout("Nice race!");
                } else if (answer == 2) {
                    shout("Heh, you are so slow, that's why you don't want to participate in race!");
                } else {
                    shout("WTF!!??!");
                }
                break;
            case 3:
                if (answer == 1) {
                    shout("That was good fighting!");
                } else if (answer == 2) {
                    shout("You are so funky");
                } else {
                    shout("You really don't know what is fighting???");
                }
                break;
            case 4:
                if (answer == 1) {
                    shout("Ok, you're not bad in chess");
                } else if (answer == 2) {
                    shout("Heh, you are not good in checkers");
                } else {
                    shout("Heh, poker is a good game, but not for you");
                }
                break;
        }
        step++;
    }

    /**
     * Final speech.
     */
    public void sayGoodBye() {
        if (this.angry) {
            shout("Ok, player, you're so boring.... Bye bye!");
        } else {
            shout("Glad to see you, player, have a nice day in the forest!");
        }
    }

    /**
     * Method for troll speech.
     *
     * @param text  Text
     */
    void shout(String text) {
        System.out.println("Troll: " + text);
    }
}
