package Practicals.Practical_12;

import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {

        String paragraph = "java is easy and java is powerful and easy";

        // Split paragraph into words
        String[] words = paragraph.toLowerCase().split("\\s+");

        // Count frequency using HashMap
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Sort words by frequency
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(map.entrySet());

        list.sort((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());

            if (result == 0) {
                return a.getKey().compareTo(b.getKey());
            }

            return result;
        });

        // Print result
        System.out.println("Words sorted by frequency:");

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
