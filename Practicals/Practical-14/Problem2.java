import java.util.*;
import java.io.*;

class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class StudentService {

    ArrayList<Student> students = new ArrayList<>();

    void addStudent(Student s) {
        students.add(s);
    }

    int getCount() {
        return students.size();
    }

    void saveData() throws IOException {

        ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream("students.dat"));

        out.writeObject(students);
        out.close();

        System.out.println("Data Saved Successfully!");
    }

    @SuppressWarnings("unchecked")
    void loadData() throws IOException, ClassNotFoundException {

        ObjectInputStream in =
                new ObjectInputStream(
                        new FileInputStream("students.dat"));

        students = (ArrayList<Student>) in.readObject();
        in.close();

        System.out.println("Data Loaded Successfully!");
    }
}

public class Aim2 {

    public static void main(String[] args) {

        try {
            StudentService service = new StudentService();

            service.addStudent(new Student(101, "Kavya"));
            service.addStudent(new Student(102, "Rahul"));

            service.saveData();

            StudentService newService = new StudentService();

            newService.loadData();

            System.out.println("Total Students: " +
                    newService.getCount());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
