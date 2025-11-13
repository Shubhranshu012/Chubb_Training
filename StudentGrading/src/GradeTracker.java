import java.util.*;

import Exception_handle.InvalidInputException;
class GradeTracker {
    private Map<String, Student> students;

    public GradeTracker() {
        students = new HashMap<>();
    }

    public void addStudent(String name) throws InvalidInputException {
        if (name == null || name.trim().isEmpty())
            throw new InvalidInputException("Student name cannot be empty.");
        if (students.containsKey(name))
            throw new InvalidInputException("Student already exists.");
        students.put(name, new Student(name));
        System.out.println("✅ Student added: " + name);
    }

    public void updateGrades(String name, double maths, double science, double english)
            throws InvalidInputException {
        Student s = students.get(name);
        if (s == null)
            throw new InvalidInputException("Student not found: " + name);

        s.setMaths(maths);
        s.setScience(science);
        s.setEnglish(english);

        System.out.println("✅ Grades updated for " + name);
    }

    public void viewAll() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("\n--- Student Grades ---");
            for (Student s : students.values()) {
                System.out.println(s);
            }
        }
    }
}