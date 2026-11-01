import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {

        List<String> logins = Arrays.asList(
                "Kavya", "Rahul", "Amit", "Kavya",
                "Priya", "Rahul", "Neha", "Amit"
        );

        // HashSet for finding unique users
        HashSet<String> uniqueUsers = new HashSet<>(logins);

        // LinkedHashSet keeps first-seen order
        LinkedHashSet<String> firstSeenUsers =
                new LinkedHashSet<>(logins);

        // Print unique count
        System.out.println("Unique visitors: " + uniqueUsers.size());

        // Print first three distinct names
        System.out.println("First three distinct visitors:");

        int count = 0;

        for (String user : firstSeenUsers) {
            System.out.println(user);
            count++;

            if (count == 3) {
                break;
            }
        }
    }
}
