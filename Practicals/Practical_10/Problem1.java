package Practicals.Practical_10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Problem1 { // Rename to ThreadPoolRunner if your file is named ThreadPoolRunner.java
    public static void main(String[] args) throws InterruptedException {
        // Create a fixed thread pool of 3 threads
        ExecutorService service = Executors.newFixedThreadPool(3);

        // Submit 10 tasks
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            service.submit(() -> {
                System.out.println("Task " + taskId + " running on " + Thread.currentThread().getName());
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Stop accepting new tasks
        service.shutdown();

        // Wait for all tasks to complete
        service.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("All tasks completed.");
    }
}
