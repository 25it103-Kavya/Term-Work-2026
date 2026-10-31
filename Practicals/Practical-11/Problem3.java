import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Problem3 { // Rename class to Main if using Main.java
    public static void main(String[] args) {
        Path folder = Paths.get(".");
        Path report = Paths.get("file_report.txt");

        try {
            StringBuilder output = new StringBuilder();
            output.append("===== FILE REPORT =====\n\n");

            Files.walkFileTree(folder, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
                    try {
                        output.append("File Name: ").append(file.getFileName()).append("\n");
                        output.append("Size: ").append(attributes.size()).append(" bytes\n");
                        output.append("Modified: ").append(attributes.lastModifiedTime()).append("\n\n");
                    } catch (Exception e) {
                        output.append("Could not read file information\n\n");
                    }
                    return FileVisitResult.CONTINUE;
                }
            });

            Files.writeString(report, output.toString());
            System.out.println("File report created successfully.");
            System.out.println("Report saved to: " + report.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
