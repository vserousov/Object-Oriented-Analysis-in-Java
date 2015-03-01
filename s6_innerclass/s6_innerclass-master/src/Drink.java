/**
 * Drink class.
 */
public abstract class Drink {

    /** Serial number. */
    private int serialNo;

    /** Drink description. */
    private String description;

    /** Content of sugar. */
    private int sugarContent;

    /** Constructor. */
    public Drink(final int serialNo, final String description) {
        this.serialNo = serialNo;
        this.description = description;
        this.sugarContent = 0;
    }

    @Override
    public String toString() {
        return "Serial number: " + serialNo + "\n" +
                "Description: " + description + "\n" +
                "Sugar content: " + sugarContent;
    }

    /** Get drink's ingredients. */
    public abstract String getIngredients();

    /** Increase sugar. */
    public Drink increaseSugarContent(int amount) {
        sugarContent += amount;
        return this;
    }
}