package Practicals.Practical_07;

// Functional interface
interface Notifier {
    void send(String message);
}

// Marker interface (empty interface used to tag classes/objects)
interface Urgent {
}

// Main class (Rename to Problem2 / Problem6 if required by your repo)
public class Problem2 {
    public static void main(String[] args) {
        // Casting lambda to an intersection type (Notifier & Urgent) to mark it as urgent
        Notifier email = (Notifier & Urgent) (message -> System.out.println("Email: " + message));

        Notifier sms = message -> System.out.println("SMS: " + message);

        Notifier[] senders = {email, sms};
        String message = "Exam is tomorrow!";

        for (int i = 0; i < senders.length; i++) {
            senders[i].send(message);

            // Send twice if sender is marked as urgent
            if (senders[i] instanceof Urgent) {
                senders[i].send(message);
            }
        }
    }
}
