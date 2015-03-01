/**
 * Class Popsi.
 */
public class Popsi extends Drink {

    /** Constructor. */
    public Popsi() {
        super(10, "Great carbonated soda");
    }

    @Override
    public String getIngredients() {
        return "Sugar and caffeine";
    }

    @Override
    public String toString() {
        return super.toString() + " " + getIngredients();
    }

    @Override
    public void finalize() throws Throwable {
        super.finalize();
        System.out.println("This object was finalized!");
    }
}
