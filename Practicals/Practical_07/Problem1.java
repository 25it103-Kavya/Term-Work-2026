package Practicals.Practical_07;

// Interface with abstract and default methods
interface Switchable {
    void on();
    void off();

    default void toggle() {
        on();
    }
}

// Concrete class 1
class Fan implements Switchable {
    @Override
    public void on() {
        System.out.println("Fan is ON");
    }

    @Override
    public void off() {
        System.out.println("Fan is OFF");
    }
}

// Concrete class 2
class Light implements Switchable {
    @Override
    public void on() {
        System.out.println("Light is ON");
    }

    @Override
    public void off() {
        System.out.println("Light is OFF");
    }
}

// Functional interface
@FunctionalInterface
interface Permission {
    boolean maySwitchOn(Switchable device, int hour);
}

// Main class (Rename to Problem1 / Problem6 if required by your repo)
public class Problem1 {
    public static void main(String[] args) {
        Switchable fan = new Fan();
        Switchable light = new Light();

        Switchable[] devices = {fan, light};

        for (int i = 0; i < devices.length; i++) {
            devices[i].toggle();
        }

        // 1. Implementation using Anonymous Class
        Permission p1 = new Permission() {
            @Override
            public boolean maySwitchOn(Switchable device, int hour) {
                return hour >= 6 && hour <= 22;
            }
        };

        System.out.println("Anonymous class:");
        System.out.println(p1.maySwitchOn(fan, 10));
        System.out.println(p1.maySwitchOn(fan, 23));

        // 2. Implementation using Lambda Expression
        Permission p2 = (device, hour) -> hour >= 6 && hour <= 22;

        System.out.println("Lambda:");
        System.out.println(p2.maySwitchOn(light, 15));
        System.out.println(p2.maySwitchOn(light, 2));
    }
}
