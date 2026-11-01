package Practicals.Practical_03;

import java.util.Objects;

// Non-public helper class
class Fraction {
    private int num;
    private int den;

    public Fraction(int num, int den) {
        if (den == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }

        // Handle negative signs (keep denominator positive)
        if (den < 0) {
            num = -num;
            den = -den;
        }

        // Reduce to lowest terms using GCD
        int g = gcd(Math.abs(num), Math.abs(den));
        this.num = num / g;
        this.den = den / g;
    }

    // Helper method to calculate the Greatest Common Divisor
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fraction fraction = (Fraction) obj;
        return num == fraction.num && den == fraction.den;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, den);
    }
}

// Ensure this class name MATCHES your filename on GitHub exactly
public class Problem3 {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = new Fraction(3, 6);

        // Printing automatically calls toString()
        System.out.println("f1: " + f1);
        System.out.println("f2: " + f2);
        System.out.println("f3: " + f3);

        // Verification checks
        System.out.println("\nEquality Checks:");
        System.out.println("f2.equals(f1): " + f2.equals(f1));
        System.out.println("f3.equals(f1): " + f3.equals(f1));
        System.out.println("f2.equals(f3): " + f2.equals(f3));
    }
}
