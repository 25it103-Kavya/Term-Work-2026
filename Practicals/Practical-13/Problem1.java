class Box<T> {
    private T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}

class Pair<A, B> {
    private A first;
    private B second;

    Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    void display() {
        System.out.println("First: " + first);
        System.out.println("Second: " + second);
    }
}

public class GenericContainers {

    // Generic method
    public static <T> T getFirst(T[] array) {
        return array[0];
    }

    public static void main(String[] args) {

        Box<Integer> b1 = new Box<>();
        b1.set(100);
        System.out.println("Integer Box: " + b1.get());

        Box<String> b2 = new Box<>();
        b2.set("Hello Java");
        System.out.println("String Box: " + b2.get());

        Pair<String, Integer> p =
                new Pair<>("Kavya", 20);

        p.display();

        String[] names = {"Kavya", "Rahul", "Amit"};

        System.out.println("First Element: " + getFirst(names));
    }
}
