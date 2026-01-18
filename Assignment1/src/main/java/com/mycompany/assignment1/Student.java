 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment1;

/**
 *
 * @author mkbph
 */
public class Student {
    private int studentId;
    private String name;
    private String course;
    private int age;
    private String email;
    //what is needed for the application
    
    public Student(int studentId, String name, String course, int age, String email) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.age = age;
        this.email = email;
    }
    
    //setters and getters for the application
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int value) {
        studentId = value;
    }
    
        
    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }
    
        
    public String getCourse() {
        return course;
    }

    public void setCourse(String value) {
        course = value;
    }
    
        
    public int getAge() {
        return age;
    }

    public void setAge(int value) {
        studentId = age;
    }
    
        
    public String getEmail () {
        return email;
    }

    public void setEmail(String value) {
        email = value;
    }
    
}
