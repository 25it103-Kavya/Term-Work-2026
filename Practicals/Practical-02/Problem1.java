public class Thermostat {

    private String location;
    private int temperature;

    private static final int MIN = 16;
    private static final int MAX = 30;

    private static int activeCount = 0;

    // Constructor with location and starting temperature
    public Thermostat(String location, int startTemp) {

        this.location = location;

        if (startTemp >= MIN && startTemp <= MAX) {
            temperature = startTemp;
        } else {
            temperature = 22;
        }

        activeCount++;
    }

    // Constructor with only location
    public Thermostat(String location) {
        this(location, 22);
    }

    // Increase temperature
    public void raise() {

        if (temperature < MAX) {
            temperature++;
        } else {
            System.out.println("Already at maximum (30)");
        }
    }

    // Decrease temperature
    public void lower() {

        if (temperature > MIN) {
            temperature--;
        } else {
            System.out.println("Already at minimum (16)");
        }
    }

    // Getter for temperature
    public int getTemperature() {
        return temperature;
    }

    // Static method to get number of thermostats
    public static int getActiveCount() {
        return activeCount;
    }

    public static void main(String[] args) {

        Thermostat t1 = new Thermostat("Living Room");
        Thermostat t2 = new Thermostat("Bedroom", 25);

        System.out.println("Initial Temperature: "
                + t1.getTemperature());

        // Raise temperature 10 times
        for (int i = 0; i < 10; i++) {
            t1.raise();
            System.out.println("Temperature: "
                    + t1.getTemperature());
        }

        // Lower temperature 20 times
        for (int i = 0; i < 20; i++) {
            t1.lower();
            System.out.println("Temperature: "
                    + t1.getTemperature());
        }

        System.out.println("Active Thermostats: "
                + Thermostat.getActiveCount());
    }
}
