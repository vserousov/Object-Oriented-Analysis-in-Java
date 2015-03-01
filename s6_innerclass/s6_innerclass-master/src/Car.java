/**
 * Abstract class Car.
 */
public abstract class Car {

    /** Label of the car. */
    private String make;

    /** Start. */
    public abstract void start();

    /** Set make. */
    public void setMake(String make) {
        this.make = make;
    }

    /** Get make. */
    public String getMake() {
        return make;
    }

}

/**
 * Main class.
 */
class Main {

    /** Method main. */
    public static void main(String[] args) {

        /** Anonymous class Hybrid is instance of Car. */
        Car Hybrid = new Car() {

            /** Battery power. */
            private int battery = 3000;

            /** Start method. */
            public void start() {
                System.out.println("Started");
                battery -= 100;
            }

            /** Method getMake will print Label + Battery power. */
            @Override
            public String getMake() {
                return super.getMake() + battery;
            }
        };

        // Set label to hybrid car.
        Hybrid.setMake("Battery power: ");

        // Print data of label.
        System.out.println(Hybrid.getMake());

        // Start hybrid car.
        Hybrid.start();

        // Print data of label.
        System.out.println(Hybrid.getMake());
    }

}
