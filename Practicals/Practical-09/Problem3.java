import java.util.Random;

class SumWorker extends Thread {
    private int[] array;
    private int start;
    private int end;
    public long localSum = 0;

    public SumWorker(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            localSum += array[i];
        }
    }
}

public class Problem3 { // Rename class to ArraySumThreads if your file is named ArraySumThreads.java
    public static void main(String[] args) throws InterruptedException {
        int size = 10000;
        int[] numbers = new int[size];
        Random random = new Random();

        // Generate random numbers
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(100);
        }

        int numberOfThreads = 4;
        SumWorker[] workers = new SumWorker[numberOfThreads];
        int partSize = size / numberOfThreads;

        // Create workers and divide array ranges
        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * partSize;
            int end = (i == numberOfThreads - 1) ? size : (start + partSize);
            workers[i] = new SumWorker(numbers, start, end);
        }

        // Start threads
        for (SumWorker worker : workers) {
            worker.start();
        }

        // Wait for threads to complete
        for (SumWorker worker : workers) {
            worker.join();
        }

        // Combine local sums
        long total = 0;
        for (SumWorker worker : workers) {
            total += worker.localSum;
        }

        System.out.println("Array size: " + size);
        System.out.println("Number of threads: " + numberOfThreads);
        System.out.println("Total sum: " + total);
    }
}
