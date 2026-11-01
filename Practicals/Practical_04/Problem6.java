package Practicals.Practical_04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Non-public helper class (removed 'public' so both classes can coexist in one file)
class TemplateFiller {

    public static String fillTemplate(String template, String[] names, String[] values) {
        Pattern pattern = Pattern.compile("\\{(\\w+)\\}");
        Matcher matcher = pattern.matcher(template);
        StringBuilder result = new StringBuilder();
        int lastPosition = 0;

        while (matcher.find()) {
            result.append(template, lastPosition, matcher.start());
            String placeholder = matcher.group(1);
            String replacement = "[?]";

            for (int i = 0; i < names.length; i++) {
                if (names[i].equals(placeholder)) {
                    replacement = values[i];
                    break;
                }
            }

            result.append(replacement);
            lastPosition = matcher.end();
        }

        result.append(template.substring(lastPosition));
        return result.toString();
    }
}

// Main public class (Make sure this class name MATCHES your GitHub file name exactly, e.g., Problem6 or Problem1)
public class Problem6 {

    public static void main(String[] args) {
        String template = "Dear {name}, order {id} ships {date}.";
        String[] names = {
            "name",
            "id"
        };
        String[] values = {
            "Riya",
            "A07"
        };

        String result = TemplateFiller.fillTemplate(template, names, values);
        System.out.println(result);
    }
}
