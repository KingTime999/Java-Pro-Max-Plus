package Lab1_AdvJava;

public class Student {
    private String id;
    private String name;
    private double grade;
    
    public Student(String id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public double getGrade() {
        return grade;
    }
    

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Grade: " + grade;
    }
}