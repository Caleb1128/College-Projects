/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.st10443421poe1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mkbph
 */
public class LoginTest {
    
    public LoginTest() {
    }

    @Test
    public void testCheckUsername() {
        Login login = new Login();
        boolean valid = true;
        boolean actual = login.checkUsername("ky_1");
        assertEquals(valid, actual);
    }

    @Test
    public void testCheckPassword() {
        Login login = new Login();
        boolean valid = true;
        boolean actual = login.checkPassword("Ch&&sec@ke99!");
        assertEquals(valid, actual);
    }

    @Test
    public void testRegisterUser() {
    }

    @Test
    public void testLoginUser() {
    }
    
}
