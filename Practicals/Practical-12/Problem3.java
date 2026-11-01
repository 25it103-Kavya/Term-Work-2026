import java.util.*;

public class Leaderboard {
    public static void main(String[] args) {

        // Player names and scores
        Map<String, Integer> scores = new HashMap<>();

        scores.put("Kavya", 95);
        scores.put("Rahul", 88);
        scores.put("Amit", 95);
        scores.put("Priya", 91);
        scores.put("Neha", 85);

        // Convert Map entries into a list
        List<Map.Entry<String, Integer>> players =
                new ArrayList<>(scores.entrySet());

        // Sort by score descending
        // If scores are equal, sort by name
        players.sort((a, b) -> {

            int result = b.getValue().compareTo(a.getValue());

            if (result == 0) {
                return a.getKey().compareTo(b.getKey());
            }

            return result;
        });

        // Top 3 players
        int topN = 3;

        System.out.println("Top " + topN + " Players:");

        for (int i = 0; i < topN && i < players.size(); i++) {

            Map.Entry<String, Integer> player = players.get(i);

            System.out.println(
                    (i + 1) + ". " +
                    player.getKey() + " - " +
                    player.getValue()
            );
        }
    }
}
