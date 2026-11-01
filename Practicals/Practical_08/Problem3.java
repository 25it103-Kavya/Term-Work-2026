package Practicals.Practical_08;

// Custom resource implementing AutoCloseable
class MyResource implements AutoCloseable {
    public MyResource() {
        System.out.println("Resource opened.");
    }

    public void use() throws Exception {
        System.out.println("Using resource...");
        throw new Exception("Exception occurred while using resource.");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing resource...");
        throw new Exception("Exception occurred while closing resource.");
    }
}

public class Problem3 { // Rename to AutoCloseableDemo if your file is AutoCloseableDemo.java
    public static void main(String[] args) {
        try (MyResource resource = new MyResource()) {
            resource.use();
        } catch (Exception e) {
            System.out.println("\nMain Exception:");
            System.out.println(e.getMessage());

            System.out.println("\nSuppressed Exceptions:");
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable s : suppressed) {
                System.out.println(s.getMessage());
            }
        }
    }
}
