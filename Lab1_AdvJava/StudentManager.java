package Lab1_AdvJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        

        students.add(new Student("S001", "Nguyen Van A", 8.5));
        students.add(new Student("S002", "Tran Thi B", 7.2));
        students.add(new Student("S003", "Le Van C", 9.1));
        students.add(new Student("S004", "Pham Thi D", 6.8));
        
        int choice;
        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Display all students");
            System.out.println("2. Search student by ID");
            System.out.println("3. Remove student by ID");
            System.out.println("4. Sort students by grade (descending)");
            System.out.println("5. Add new student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    displayStudents(students);
                    break;
                case 2:
                    System.out.print("Enter student ID to search: ");
                    String searchId = scanner.nextLine();
                    searchStudent(students, searchId);
                    break;
                case 3:
                    System.out.print("Enter student ID to remove: ");
                    String removeId = scanner.nextLine();
                    removeStudent(students, removeId);
                    break;
                case 4:
                    sortStudentsByGrade(students);
                    System.out.println("Students sorted by grade (descending):");
                    displayStudents(students);
                    break;
                case 5:
                    addNewStudent(students, scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
        
        scanner.close();
    }
    
    public static void displayStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        
        for (Student student : students) {
            System.out.println(student);
        }
    }
    
    public static void searchStudent(ArrayList<Student> students, String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println("Student found: " + student);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }
    
    public static void removeStudent(ArrayList<Student> students, String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                Student removed = students.remove(i);
                System.out.println("Removed student: " + removed);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }
    
    public static void sortStudentsByGrade(ArrayList<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getGrade(), s1.getGrade()); // Descending order
            }
        });
    }
    
    public static void addNewStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine();
        
        students.add(new Student(id, name, grade));
        System.out.println("Student added successfully.");
    }
}