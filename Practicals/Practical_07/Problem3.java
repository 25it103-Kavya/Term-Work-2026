package Practicals.Practical_07;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// 1. Define custom @Column annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

// 2. Student Model Class
class Student {
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "course")
    private String course;

    @Column(name = "age")
    private int age;

    public Student() {}

    public void displayDetails() {
        System.out.println("Student Details:");
        System.out.println("ID     : " + id);
        System.out.println("Name   : " + name);
        System.out.println("Course : " + course);
        System.out.println("Age    : " + age);
    }
}

// 3. Main Public Class (Matches filename Problem3.java; change to Main if running on OneCompiler)
public class Problem3 {

    public static <T> T mapRowToObject(Class<T> clazz, String[] headers, String[] rowData) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();

        Map<String, Integer> headerIndexMap = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
            headerIndexMap.put(headers[i].trim().toLowerCase(), i);
        }

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {
                Column columnAnno = field.getAnnotation(Column.class);
                String columnName = columnAnno.name().trim().toLowerCase();

                // Skip missing columns gracefully
                if (!headerIndexMap.containsKey(columnName)) {
                    continue;
                }

                int colIndex = headerIndexMap.get(columnName);
                if (colIndex >= rowData.length) {
                    continue;
                }

                String rawValue = rowData[colIndex];
                field.setAccessible(true);
                
                Object convertedValue = convertType(field.getType(), rawValue);
                field.set(instance, convertedValue);
            }
        }

        return instance;
    }

    private static Object convertType(Class<?> targetType, String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        value = value.trim();

        if (targetType == String.class) return value;
        if (targetType == int.class || targetType == Integer.class) return Integer.parseInt(value);
        if (targetType == long.class || targetType == Long.class) return Long.parseLong(value);
        if (targetType == double.class || targetType == Double.class) return Double.parseDouble(value);

        return value;
    }

    public static void main(String[] args) {
        try {
            String[] headers = {"id", "name", "course", "age"};
            String[] rowData = {"101", "Kavya", "IT", "19"};

            Student student = mapRowToObject(Student.class, headers, rowData);
            student.displayDetails();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
