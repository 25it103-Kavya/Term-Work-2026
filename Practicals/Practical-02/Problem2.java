public class CinemaShow {

    private String title;
    private int seatsAvailable;
    private final int capacity;

    private static int totalBooked = 0;

    // Constructor with title and capacity
    public CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    // Constructor with default capacity of 100
    public CinemaShow(String title) {
        this(title, 100);
    }

    // Book seats
    public boolean book(int n) {

        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        }

        return false;
    }

    // Cancel seats
    public void cancel(int n) {

        seatsAvailable += n;

        if (seatsAvailable > capacity) {
            seatsAvailable = capacity;
        }
    }

    // Get available seats
    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    // Get total booked seats
    public static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {

        CinemaShow show = new CinemaShow("Avengers", 50);

        System.out.println(show.book(20));
        System.out.println("Seats Available: "
                + show.getSeatsAvailable());

        System.out.println(show.book(25));
        System.out.println("Seats Available: "
                + show.getSeatsAvailable());

        System.out.println(show.book(10));
        System.out.println("Seats Available: "
                + show.getSeatsAvailable());

        show.cancel(15);

        System.out.println("Seats Available: "
                + show.getSeatsAvailable());

        System.out.println(show.book(10));
        System.out.println("Seats Available: "
                + show.getSeatsAvailable());

        System.out.println("Total Booked: "
                + CinemaShow.getTotalBooked());
    }
}
