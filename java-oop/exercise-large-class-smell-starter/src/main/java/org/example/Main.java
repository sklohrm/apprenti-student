package org.example;

public class Main {
    public static void main(String[] args) {

        // I included the class diagrams in: src/main/resources/class-diagram.png

        Student student = new Student();
        // Create a new Teacher to assign to the Student
        Teacher homeroomTeacher = new Teacher();

        ConsoleIO.display("Welcome to Better School Tracker!");

        student.setFirstName(ConsoleIO.promptString("Enter Student First Name"));
        student.setLastName(ConsoleIO.promptString("Enter Student Last Name"));
        student.setGPA(ConsoleIO.promptDouble("Enter Student's GPA"));

        // Teacher fields are now updated on the Teacher object.
        student.setHomeroomTeacher(homeroomTeacher);
        student.getHomeroomTeacher().setFirstName(ConsoleIO.promptString("Enter Homeroom teacher's first Name"));
        student.getHomeroomTeacher().setLastName(ConsoleIO.promptString("Enter Homeroom teacher's last name"));

        System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("GPA: " + student.getGPA());
        System.out.println("Homeroom Teacher: " + student.getHomeroomTeacher().getFirstName() + " " + student.getHomeroomTeacher().getLastName());

    }
}