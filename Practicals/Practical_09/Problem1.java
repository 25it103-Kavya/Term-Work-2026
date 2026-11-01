package Practicals.Practical_09;

class Counter {
    int count = 0;

    // Unsynchronized increment (causes race condition)
    void increment() {
        count++;
    }

    // Synchronized increment (thread-safe)
    synchronized void incrementSynchronized() {
        count++;
    }
}

public class Problem1 { // Rename class to CounterRace if your file is named CounterRace.java
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        int numberOfThreads = 10;
        int incrementsPerThread = 1000;
        Thread[] threads = new Thread[numberOfThreads];

        // Create threads
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    // Change to counter.incrementSynchronized() to get exact expected output
                    counter.increment();
                }
            });
        }

        // Start threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        int expected = numberOfThreads * incrementsPerThread;
        System.out.println("Expected count: " + expected);
        System.out.println("Actual count: " + counter.count);
    }
}
