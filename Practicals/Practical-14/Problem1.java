import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
}

class StudentService {
    ArrayList<Student> students = new ArrayList<>();

    void addStudent(Student s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid Student");
        }
        students.add(s);
    }

    void removeStudent(int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);

        if (!removed) {
            throw new IllegalArgumentException("Student Not Found");
        }
    }

    int getCount() {
        return students.size();
    }
}

public class Aim1 {
    public static void main(String[] args) {

        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Count Students");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();

                        System.out.print("Enter Name: ");
                        String name = sc.next();

                        service.addStudent(new Student(id, name));
                        System.out.println("Student Added!");
                        break;

                    case 2:
                        System.out.print("Enter ID: ");
                        int removeId = sc.nextInt();

                        service.removeStudent(removeId);
                        System.out.println("Student Removed!");
                        break;

                    case 3:
                        System.out.println("Total Students: " +
                                service.getCount());
                        break;

                    case 0:
                        System.out.println("Program Exited.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid Choice!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
