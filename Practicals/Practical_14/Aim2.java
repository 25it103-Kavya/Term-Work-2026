package Practicals.Practical_14;

import java.util.*;
import java.io.*;

class StudentRecord14 implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;
    String name;

    StudentRecord14(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class StudentService14 {

    ArrayList<StudentRecord14> students = new ArrayList<>();

    void addStudent(StudentRecord14 s) {
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

        students = (ArrayList<StudentRecord14>) in.readObject();
        in.close();

        System.out.println("Data Loaded Successfully!");
    }
}

public class Aim2 {

    public static void main(String[] args) {

        try {
            StudentService14 service = new StudentService14();

            service.addStudent(new StudentRecord14(101, "Kavya"));
            service.addStudent(new StudentRecord14(102, "Rahul"));

            service.saveData();

            StudentService14 newService = new StudentService14();

            newService.loadData();

            System.out.println("Total Students: " +
                    newService.getCount());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
