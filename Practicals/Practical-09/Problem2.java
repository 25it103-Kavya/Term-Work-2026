class SeatManager {
    private int seatsLeft = 5;

    // Unsynchronized method (demonstrates race condition/overselling)
    boolean bookSeatUnsafe() {
        if (seatsLeft > 0) {
            try {
                Thread.sleep(10); // Delay to increase race condition probability
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            seatsLeft--;
            return true;
        }
        return false;
    }

    // Synchronized method (thread-safe)
    synchronized boolean bookSeatSafe() {
        if (seatsLeft > 0) {
            seatsLeft--;
            return true;
        }
        return false;
    }

    int getSeatsLeft() {
        return seatsLeft;
    }
}

public class Problem2 { // Rename class to SeatBooking if your file is named SeatBooking.java
    public static void main(String[] args) throws InterruptedException {
        SeatManager manager = new SeatManager();
        int numberOfThreads = 10;
        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            final int threadNumber = i + 1;
            threads[i] = new Thread(() -> {
                boolean booked = manager.bookSeatSafe();
                if (booked) {
                    System.out.println("Thread " + threadNumber + " successfully booked a seat.");
                } else {
                    System.out.println("Thread " + threadNumber + " failed to book a seat.");
                }
            });
        }

        // Start threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println();
        System.out.println("Seats remaining: " + manager.getSeatsLeft());
    }
}
