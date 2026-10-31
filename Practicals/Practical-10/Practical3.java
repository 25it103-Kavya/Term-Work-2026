public class Problem3 { // Rename to DeadlockDemo if your file is named DeadlockDemo.java
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    // Both threads follow the same lock order to prevent deadlock
    private void task(String name) {
        synchronized (lock1) {
            System.out.println(name + " acquired lock1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            synchronized (lock2) {
                System.out.println(name + " acquired lock2");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Problem3 demo = new Problem3();

        Thread t1 = new Thread(() -> {
            demo.task("Thread 1");
        });

        Thread t2 = new Thread(() -> {
            demo.task("Thread 2");
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads
        t1.join();
        t2.join();

        System.out.println("No deadlock: both threads completed.");
    }
}
