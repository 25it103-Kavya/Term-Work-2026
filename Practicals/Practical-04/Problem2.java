import java.util.Scanner;

// Non-public helper class (removed 'public' so both classes can coexist in one file)
class ChatFilter {
    public static String filterLogs(String[] logs, String keyword) {
        int count = 0;
        StringBuilder report = new StringBuilder();
        for (String line : logs) {
            String[] parts = line.split(" ", 3);
            if (parts.length < 3) {
                continue;
            }
            String time = parts[0];
            String user = parts[1];
            String message = parts[2];
            if (message.toLowerCase().contains(keyword.toLowerCase())) {
                count++;
                report.append(time)
                    .append(" ")
                    .append(user)
                    .append(": ")
                    .append(message)
                    .append("\n");
            }
        }
        return "Matches: " + count + "\n" + report;
    }
}

// Main public class (Make sure this class name MATCHES your GitHub file name exactly, e.g. Problem5 or Problem1)
public class Problem5 {
    public static void main(String[] args) {
        String[] logs = {
            "10:05 alice Hello there",
            "10:10 bob Good morning",
            "10:15 Charlie hello everyone",
            "10:20"
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine();
        String result = ChatFilter.filterLogs(logs, keyword);
        System.out.println(result);
        sc.close();
    }
}
