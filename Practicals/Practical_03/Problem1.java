package Practicals.Practical_03;

import java.util.Objects;

// Non-public helper class (removed 'public' keyword so it can live in the same file)
class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Point point = (Point) obj;

        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

// Public class matching the GitHub file name Problem1.java
public class Problem1 {

    public static void main(String[] args) {

        // Build Point array with 5 points and 2 repeats
        Point[] points = {
            new Point(1, 2),
            new Point(3, 4),
            new Point(1, 2), // Repeat 1
            new Point(5, 6),
            new Point(3, 4)  // Repeat 2
        };

        int distinctCount = 0;

        for (int i = 0; i < points.length; i++) {

            boolean isDuplicate = false;

            // Check if points[i] appeared earlier in the array
            for (int j = 0; j < i; j++) {

                if (points[i].equals(points[j])) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                distinctCount++;
            }
        }

        System.out.println("Distinct: " + distinctCount);
    }
}
