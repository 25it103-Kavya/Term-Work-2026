package Practicals.Practical_02;

public class ParkingLot {

    private int twoWheelers;
    private int fourWheelers;

    private final int twoCap;
    private final int fourCap;

    private static long revenue = 0;

    // Constructor
    public ParkingLot(int twoCap, int fourCap) {
        this.twoCap = twoCap;
        this.fourCap = fourCap;

        this.twoWheelers = 0;
        this.fourWheelers = 0;
    }

    // Park a vehicle
    public void park(String type) {

        if (type.equals("two")) {

            if (twoWheelers < twoCap) {
                twoWheelers++;
                revenue += 20;
                System.out.println("Two-wheeler parked");
            } else {
                System.out.println("Full");
            }

        } else if (type.equals("four")) {

            if (fourWheelers < fourCap) {
                fourWheelers++;
                revenue += 40;
                System.out.println("Four-wheeler parked");
            } else {
                System.out.println("Full");
            }
        }
    }

    // Vehicle leaves
    public void leave(String type) {

        if (type.equals("two")) {

            if (twoWheelers > 0) {
                twoWheelers--;
                System.out.println("Two-wheeler left");
            }

        } else if (type.equals("four")) {

            if (fourWheelers > 0) {
                fourWheelers--;
                System.out.println("Four-wheeler left");
            }
        }
    }

    // Get two-wheeler count
    public int getTwoWheelers() {
        return twoWheelers;
    }

    // Get four-wheeler count
    public int getFourWheelers() {
        return fourWheelers;
    }

    // Get total revenue
    public static long getRevenue() {
        return revenue;
    }

    public static void main(String[] args) {

        ParkingLot p = new ParkingLot(2, 2);

        p.park("two");
        p.park("two");
        p.park("two");

        p.park("four");
        p.park("four");
        p.park("four");

        p.leave("two");
        p.leave("four");

        p.park("two");
        p.park("four");

        System.out.println("Two-Wheelers: "
                + p.getTwoWheelers());

        System.out.println("Four-Wheelers: "
                + p.getFourWheelers());

        System.out.println("Revenue: "
                + ParkingLot.getRevenue());
    }
}
