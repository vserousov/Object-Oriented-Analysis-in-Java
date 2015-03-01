import java.util.Iterator;

/** Factorial */
public class Factorial implements Iterable<Integer> {

    /** Factorial starts with lowerLimit. */
    private final int lowerLimit;

    /** Factorial ends with upperLimit. */
    private final int upperLimit;

    /**
     * Constructor initialize lowerLimit and upperLimit.
     *
     * @param lowerLimit  start
     * @param upperLimit  end
     * @throws IllegalArgumentException  if {@code lowerLimit < 1 || lowerLimit > upperLimit}
     */
    public Factorial(int lowerLimit, int upperLimit) throws IllegalArgumentException {
        if (lowerLimit < 1) {
            throw new IllegalArgumentException("lowerLimit must be positive");
        } else if (lowerLimit > upperLimit) {
            throw new IllegalArgumentException("lowerLimit can't be more than upperLimit");
        }

        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    /** Iterator class implementation. */
    public Iterator<Integer> iterator() {

        /** Local class FactorialIterator. */
        class FactorialIterator implements Iterator<Integer> {

            /** Result for current position of iteration */
            private int result;

            /** Current position of iteration starting with lowerLimit */
            private int current;

            public FactorialIterator() {
                this.current = lowerLimit;
                this.result = 1;
            }

            public boolean hasNext() {
                return current <= upperLimit;
            }

            public Integer next() {
                result *= current++;
                return result;
            }
        }

        // return local class object
        return new FactorialIterator();
    }

    public static void main(String[] args) {
        try {
            Factorial fact = new Factorial(1, 11);
            for (int i : fact) {
                System.out.println(i);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}