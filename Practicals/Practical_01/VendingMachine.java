package Practicals.Practical_01;

import java.util.Scanner;

public class VendingMachine {

    // (a) Enum for accepted coins
    enum Coin {
        ONE, TWO, FIVE, TEN
    }

    public static void main(String[] args) {

        // (b) Set target price and total
        final int PRICE = 15;
        int total = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Snack price: 15. Enter coins (ONE, TWO, FIVE, TEN):");

        // (c) & (d) Loop until total reaches 15 or more
        while (total < PRICE) {

            System.out.print("Insert coin: ");
            String input = scanner.next().toUpperCase();

            try {
                Coin coin = Coin.valueOf(input);

                // Switch expression to derive coin value
                int value = switch (coin) {
                    case ONE -> 1;
                    case TWO -> 2;
                    case FIVE -> 5;
                    case TEN -> 10;
                };

                total += value;

                System.out.println("Total inserted so far: " + total);

            } catch (IllegalArgumentException e) {
                System.out.println(
                    "Invalid coin! Please enter ONE, TWO, FIVE, or TEN."
                );
            }
        }

        // (e) Calculate and print change
        int change = total - PRICE;

        System.out.println("Paid. Change: " + change);

        scanner.close();
    }
}
