package Practicals.Practical_08;

import java.util.Scanner;

// Custom checked exception
class DivideByZeroException extends Exception {
    public DivideByZeroException(String message) {
        super(message);
    }
}

public class Problem1 { // Rename to GuardedCalculator if your file is GuardedCalculator.java

    // Calculator method with exception handling
    static double calculate(double a, double b, char operator) throws DivideByZeroException {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new DivideByZeroException("Cannot divide by zero.");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Guarded Calculator ===");
        System.out.println("Enter 'q' to quit.");

        while (true) {
            try {
                System.out.print("\nEnter first number: ");
                String input = sc.next();
                if (input.equalsIgnoreCase("q")) {
                    break;
                }

                double a = Double.parseDouble(input);

                System.out.print("Enter operator (+, -, *, /): ");
                char operator = sc.next().charAt(0);

                System.out.print("Enter second number: ");
                double b = sc.nextDouble();

                double result = calculate(a, b, operator);
                System.out.println("Result = " + result);

            } catch (DivideByZeroException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: Invalid input.");
                sc.nextLine(); // Clear buffer
            } finally {
                System.out.println("[Log] Attempt completed.");
            }
        }

        sc.close();
        System.out.println("\nCalculator closed.");
    }
}
