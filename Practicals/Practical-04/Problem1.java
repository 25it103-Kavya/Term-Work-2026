// Non-public helper class (removed 'public' keyword so both classes can exist in one file)
class PasswordChecker {

    public static boolean hasMinimumLength(String pw) {
        return pw.length() >= 8;
    }

    public static boolean hasUppercase(String pw) {
        return pw.matches(".*[A-Z].*");
    }

    public static boolean hasDigit(String pw) {
        return pw.matches(".*[0-9].*");
    }

    public static boolean hasSpecialCharacter(String pw) {
        return pw.matches(".*[^a-zA-Z0-9].*");
    }

    public static String strength(String pw) {
        int count = 0;
        if (hasMinimumLength(pw)) {
            count++;
        }
        if (hasUppercase(pw)) {
            count++;
        }
        if (hasDigit(pw)) {
            count++;
        }
        if (hasSpecialCharacter(pw)) {
            count++;
        }

        if (count <= 1) {
            return "Weak";
        } else if (count <= 3) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

// Main public class (Make sure this class name MATCHES your GitHub file name exactly, e.g. Problem4 or Problem1)
public class Problem4 {

    public static void main(String[] args) {
        String[] passwords = {
            "abc",
            "abcdefgh",
            "Abcdefgh",
            "Abcd1234",
            "Abcd1234!"
        };

        for (String pw : passwords) {
            System.out.println("Password: " + pw);
            System.out.println("Length >= 8: " + PasswordChecker.hasMinimumLength(pw));
            System.out.println("Uppercase: " + PasswordChecker.hasUppercase(pw));
            System.out.println("Digit: " + PasswordChecker.hasDigit(pw));
            System.out.println("Special character: " + PasswordChecker.hasSpecialCharacter(pw));
            System.out.println("Strength: " + PasswordChecker.strength(pw));
            System.out.println();
        }
    }
}
