package Practicals.Practical_01;

import java.util.Scanner;

public class TollBooth {

    // (a) Vehicle record definition
    record Vehicle(String number, String type) {
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int totalToll = 0;
        int bikeCount = 0;
        int carCount = 0;
        int truckCount = 0;

        // (c) Loop until user enters "done"
        while (true) {

            System.out.print("Enter vehicle number (or 'done' to stop): ");
            String number = scanner.next();

            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter vehicle type (bike, car, truck): ");
            String type = scanner.next().toLowerCase();

            Vehicle vehicle = new Vehicle(number, type);

            // Switch expression to derive toll and track count
            int toll = switch (vehicle.type()) {

                case "bike" -> {
                    bikeCount++;
                    yield 20;
                }

                case "car" -> {
                    carCount++;
                    yield 50;
                }

                case "truck" -> {
                    truckCount++;
                    yield 150;
                }

                default -> {
                    System.out.println("Unknown vehicle type. No toll added.");
                    yield 0;
                }
            };

            totalToll += toll;
        }

        // (d) Determine vehicle type with highest count
        String mostFrequent = "none";

        int maxCount = Math.max(
                bikeCount,
                Math.max(carCount, truckCount)
        );

        if (maxCount > 0) {

            if (maxCount == carCount) {
                mostFrequent = "car";

            } else if (maxCount == bikeCount) {
                mostFrequent = "bike";

            } else {
                mostFrequent = "truck";
            }
        }

        System.out.println("Total toll: " + totalToll);
        System.out.println("Most frequent: " + mostFrequent);

        scanner.close();
    }
}
