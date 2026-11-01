package Practicals.Practical_11;

import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String name;
    
    // Transient field - will NOT be saved during serialization
    private transient double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println("ID    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Marks : " + marks);
    }
}

public class Problem1 { // Rename class to Main if using Main.java
    public static void main(String[] args) {
        String fileName = "students.dat";

        try {
            Student[] students = {
                new Student(101, "Kavya", 85.5),
                new Student(102, "Rahul", 90.0),
                new Student(103, "Priya", 78.5)
            };

            // Save objects to file
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(students);
            out.close();
            System.out.println("Objects saved successfully.\n");

            // Read objects from file
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            Student[] loadedStudents = (Student[]) in.readObject();
            in.close();

            System.out.println("Objects loaded successfully:");
            for (Student s : loadedStudents) {
                s.display();
                System.out.println();
            }

            System.out.println("Notice: Marks became 0.0 because it was transient.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
