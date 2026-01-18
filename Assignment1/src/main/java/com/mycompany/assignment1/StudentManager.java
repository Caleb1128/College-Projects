/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mkbph
 */
public class StudentManager {
     private ArrayList<Student> students;
    private Scanner input;

    private boolean applicationRunning;

    public StudentManager() {
        students = new ArrayList<Student>();
        applicationRunning = false;
        input = new Scanner(System.in);
    }
    
    public void printReturnToMainMenu() {
    System.out.println(String.format("Enter (1) to launch main menu or any other key to exit"));
    }

    public void StartApplication() {
        applicationRunning = true;
        System.out.println(String.format("SYSTEM MANAGEMENT APPLICATION"));
        System.out.println(String.format("*******************************************"));
        while (applicationRunning) {
            printReturnToMainMenu();
            if (input.hasNextInt()) {
                int command = input.nextInt();

                switch (command) {
                    case 1:
                        ShowMainMenu();
                        break;
                    default:
                        ExitStudentApplication();
                        break;
                }
            } else {
                input.next();
            }
        }
    }
    
        public void SaveStudent(Student student) throws Exception {
        // Check if Student already exists
        if (SearchStudent(student.getStudentId()) != null) {
            throw new Exception("Student already Exists");
        }

        // Store Student
        students.add(student);
    }



    public void printBreakLines() {
        System.out.println("-------------------------------------");
    }

        //a switch case to start a menu for the application
    public void ShowMainMenu() {
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new Student");
        System.out.println("(2) Search for a Student");
        System.out.println("(3) Delete a Student");
        System.out.println("(4) Print student report");
        System.out.println("(5) Exit Application");
        System.out.println("-------------------------------------");

        if (input.hasNextInt()) {
            int command = input.nextInt();

            switch (command) {
                case 1:
                    StartCaptureStudentWizard();
                    break;
                case 2: 
                    SearchStudentWizard();
                    break;
                case 3: 
                    StartDeleteStudentWizard(); 
                    break;
                case 4:
                    StudentReport();
                    break;
                case 5: 
                    ExitStudentApplication();
                default:
                    ExitStudentApplication();
                    break;
            }

        } else {
            ExitStudentApplication();
        }
    }

    //A capture wizard for the student
    private void StartCaptureStudentWizard() {
        System.out.println(String.format("CAPTURE A NEW STUDENT"));
        System.out.println(String.format("*******************************"));

        System.out.print("Enter the student ID: ");
        int studentId = input.nextInt();
        input.nextLine();

        System.out.print("Enter the student name: ");
        String studentName = input.nextLine();

        int studentAge = 0;
        while (studentAge < 16) {
            System.out.print("Enter the student age: ");
            if (input.hasNextInt()) {
                studentAge = input.nextInt();
            }
            input.nextLine();

            if (studentAge < 16) {
                System.out.println("You have entered an incorrect student age!!!");
            }
        }

        System.out.print("Enter the student email: ");
        String studentEmail = input.nextLine();

        System.out.print("Enter the student course: ");
        String studentCourse = input.nextLine();

        Student student = new Student(studentId, studentName, studentCourse, studentAge, studentEmail);

        students.add(student);

        System.out.println("CAPTURED STUDENT INFORMATION");
        System.out.println("**********************************");
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Student Age: " + studentAge);
        System.out.println("Student Email: " + studentEmail);
        System.out.println("Student Course: " + studentCourse);
    }
    
        //A method to search for the student
        public void SearchStudentWizard() {
        System.out.print("Enter the student id to search: ");

        if (!input.hasNextInt()) {
            printBreakLines();
            String value = input.next();
            System.out.println(String.format("Student with Student Id: %s was not found", value));
            printBreakLines();

            return;
        }

        int studentId = input.nextInt();
        Student student = SearchStudent(studentId);

        if (student == null) {
            printBreakLines();
            System.out.println(String.format("Student with Student Id: %d was not found", studentId));
            printBreakLines();
            return;
        }

        printBreakLines();
        System.out.println(String.format("STUDENT ID: %d", student.getStudentId()));
        System.out.println(String.format("STUDENT NAME: %s", student.getName()));
        printBreakLines();
    }
        public Student SearchStudent(int studentId) {
        if (students.size() == 0) {
            return null;
        }

        for (int x = 0; x < students.size(); x++) {
            Student temp = students.get(x);
            if (temp.getStudentId() == studentId) {
                return temp;
            }
        }

        return null;
    }
    
        //A method to delete the student
    private void StartDeleteStudentWizard() {
        System.out.println(String.format("DELETE STUDENT"));
         printBreakLines();
        System.out.print("Enter the Student ID to delete");
    int studentId = input.nextInt();
    input.nextLine();  // Consume the newline character

    // Find student with the provided ID
    Student studentToDelete = null;
    for (Student student : students) {
        if (student.getStudentId() == studentId) {
            studentToDelete = student;
            break;
        }
    }
    if (studentToDelete != null) {
        // Display student details to confirm
        System.out.println("Student to be deleted:");
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentToDelete.getName());
        System.out.println("Student Age: " + studentToDelete.getAge());
        System.out.println("Student Email: " + studentToDelete.getEmail());
        System.out.println("Student Course: " + studentToDelete.getCourse());

        // Confirm deletion
        System.out.print("Are you sure you want to delete Student  " + studentId + "? (yes/no): ");
        String confirmation = input.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            // Remove the student from the list
            students.remove(studentToDelete);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student deletion cancelled.");
        }
    } else {
        System.out.println("No student found with the provided ID.");
    }
        
            }
     public boolean DeleteStudent(int studentId) throws Exception {
        // Search for student using given studentId
        Student student = SearchStudent(studentId);

        // Error Out if student does not exist
        if (student == null) {
            throw new Exception("Student does not exist");
        }

        students.remove(student);
        return true;
    }
     
     //A method to display the students
    public void StudentReport() {
        for (int x = 0 ; x < students.size(); x++) {
            Student student = students.get(x);
            System.out.println(String.format("STUDENT %d", x));
            System.out.println("-------------------------------------");
            System.out.println(String.format("STUDENT ID: %d", student.getStudentId()));
            System.out.println(String.format("STUDENT NAME: %s", student.getName()));
            System.out.println(String.format("STUDENT AGE: %d", student.getAge()));
            System.out.println(String.format("STUDENT EMAIL: %s", student.getEmail()));
            System.out.println(String.format("STUDENT COURSE: %s", student.getCourse()));
            System.out.println("-------------------------------------");
        }
    }

    //A method to exit the application
    public void ExitStudentApplication() {
        applicationRunning = false;
    } 
}
