class Stack<T> {

    private T[] stack;
    private int top;
    private int size;

    @SuppressWarnings("unchecked")
    Stack(int size) {
        this.size = size;
        stack = (T[]) new Object[size];
        top = -1;
    }

    void push(T value) {

        if (top == size - 1) {
            System.out.println("Stack Overflow!");
            return;
        }

        stack[++top] = value;
        System.out.println("Pushed: " + value);
    }

    T pop() {

        if (top == -1) {
            System.out.println("Stack is Empty!");
            return null;
        }

        return stack[top--];
    }

    void display() {

        if (top == -1) {
            System.out.println("Stack is Empty!");
            return;
        }

        System.out.println("Stack Elements:");

        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}

public class GenericStack {

    public static void main(String[] args) {

        // Integer Stack
        Stack<Integer> s1 = new Stack<>(5);

        s1.push(10);
        s1.push(20);
        s1.push(30);

        s1.display();

        System.out.println("Popped: " + s1.pop());

        // String Stack
        Stack<String> s2 = new Stack<>(5);

        s2.push("Java");
        s2.push("Python");

        s2.display();

        System.out.println("Popped: " + s2.pop());
    }
}
