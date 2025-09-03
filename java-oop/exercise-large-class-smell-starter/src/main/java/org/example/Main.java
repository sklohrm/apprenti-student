package org.example;

public class Main {
    public static void main(String[] args) {

        // I included the class diagrams in: src/main/resources/class-diagram.png

        // I just wanted to add that I didn't use inheritance to make the Student a subclass of a Person and make the
        // teacher a person because it seemed like overkill to add inheritance when there is only one different field.
        // If this was a larger program I would probably have a Person parent class with Staff as a subclass and extend
        // Teacher from Staff.

        Student student = new Student();
        // Create a new Teacher to assign to the Student
        Teacher homeroomTeacher = new Teacher();

        ConsoleIO.display("Welcome to Better School Tracker!");

        student.setFirstName(ConsoleIO.promptString("Enter Student First Name"));
        student.setLastName(ConsoleIO.promptString("Enter Student Last Name"));
        student.setGPA(ConsoleIO.promptDouble("Enter Student's GPA"));

        // Teacher fields are now updated on the Teacher object.
        student.setHomeroomTeacher(homeroomTeacher);
        homeroomTeacher.setFirstName(ConsoleIO.promptString("Enter Homeroom teacher's first Name"));
        homeroomTeacher.setLastName(ConsoleIO.promptString("Enter Homeroom teacher's last name"));

        System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("GPA: " + student.getGPA());
        System.out.println("Homeroom Teacher: " + homeroomTeacher.getFirstName() + " " + homeroomTeacher.getLastName());

    }
}