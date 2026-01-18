/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.assignment1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mkbph
 */
public class StudentManagerTest {
    

    @Test
    public void testSaveStudent() throws Exception {
        System.out.println("SaveStudent");
        Student student = null;
        StudentManager instance = new StudentManager();
        instance.SaveStudent(student);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSearchStudent() {
        System.out.println("SearchStudentWizard");
        StudentManager instance = new StudentManager();
        instance.SearchStudentWizard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testSearchStudent_StudentNotFound(){
    StudentManager studentmanager = new StudentManager();   
    }
    
    @Test
    public void testDeleteStudent() throws Exception {
        System.out.println("DeleteStudent");
        int studentId = 0;
        StudentManager instance = new StudentManager();
        boolean expResult = false;
        boolean result = instance.DeleteStudent(studentId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } 
    
    @Test
    public void testDeleteStudent_StudentNotFound(){
    StudentManager studentmanager = new StudentManager(); 

    }

    @Test
    public void testStudentAge_StudentAgeValid(){
    StudentManager studentmanager = new StudentManager();    
    }
    
    @Test
    public void testStudentAge_StudentAgeinvalid(){
    StudentManager studentmanager = new StudentManager();    
    }
    
    @Test
    public void testStudentAge_StudentAgeinvalidCharacter(){
    StudentManager studentmanager = new StudentManager();    
    }
}
