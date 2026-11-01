package Practicals.Practical_10;

import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity = 3;

    // Producer adds an item
    public synchronized void put(int value) throws InterruptedException {
        // Wait if buffer is full
        while (buffer.size() == capacity) {
            wait();
        }

        buffer.add(value);
        System.out.println("Produced: " + value);

        // Notify consumer
        notify();
    }

    // Consumer removes an item
    public synchronized int get() throws InterruptedException {
        // Wait if buffer is empty
        while (buffer.isEmpty()) {
            wait();
        }

        int value = buffer.remove();
        System.out.println("Consumed: " + value);

        // Notify producer
        notify();
        return value;
    }
}

public class Problem2 { // Rename to ProducerConsumer if your file is named ProducerConsumer.java
    public static void main(String[] args) throws InterruptedException {
        SharedBuffer buffer = new SharedBuffer();

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.put(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.get();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Start threads
        producer.start();
        consumer.start();

        // Wait for both threads
        producer.join();
        consumer.join();

        System.out.println("Production and consumption completed.");
    }
}
