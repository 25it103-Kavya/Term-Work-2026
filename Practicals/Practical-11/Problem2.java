import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class Problem2 { // Rename class to Main if using Main.java
    public static void main(String[] args) {
        try {
            // Create sample log files
            Path file1 = Paths.get("log1.txt");
            Path file2 = Paths.get("log2.txt");
            Path file3 = Paths.get("log3.txt");

            Files.write(file1, List.of(
                "INFO: Application started",
                "ERROR: Database connection failed",
                "INFO: User logged in",
                "ERROR: File not found"
            ));

            Files.write(file2, List.of(
                "INFO: Server started",
                "INFO: User logged in",
                "WARNING: Low memory",
                "ERROR: Network failure"
            ));

            Files.write(file3, List.of(
                "INFO: Login successful",
                "ERROR: Invalid password",
                "INFO: Data saved"
            ));

            Path[] files = {file1, file2, file3};
            String keyword = "ERROR";
            int totalLines = 0;
            int keywordLines = 0;

            System.out.println("LOG ANALYSIS");
            System.out.println("----------------------------------------");

            for (Path file : files) {
                List<String> lines = Files.readAllLines(file);
                int fileKeywordCount = 0;

                for (String line : lines) {
                    totalLines++;
                    if (line.contains(keyword)) {
                        fileKeywordCount++;
                        keywordLines++;
                    }
                }

                long size = Files.size(file);
                System.out.println("File: " + file);
                System.out.println("Size: " + size + " bytes");
                System.out.println("Lines containing " + keyword + ": " + fileKeywordCount);
                System.out.println();
            }

            System.out.println("Total lines: " + totalLines);
            System.out.println("Total lines containing " + keyword + ": " + keywordLines);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
