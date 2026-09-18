/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progassignemntpartone;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class LoginTest {
    
    @Test
    
    public void testCheckUserName() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99", "+2783896896");

        assertTrue(login.checkUserName());
    }

    @Test
    public void testCheckUserNameIncorrect() {
        Login login = new Login("kyle!!!!!!!", "Ch&&sec@ke99", "+2783896896");

        assertFalse(login.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexity() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99", "+2783896896");

        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexityIncorrect() {
        Login login = new Login("kyl_1", "password", "+2783896896");

        assertFalse(login.checkPasswordComplexity());
    }

    @Test
    public void testCheckCellPhoneNumber() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99", "+27838968976");

        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void testCheckCellPhoneNumberIncorrect() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99", "08966553");

        assertFalse(login.checkCellPhoneNumber());
    }

    @Test
    public void testLoginUser() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99", "+2783896896");
        
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99"));
    }
    
    @Test
    public void testLoginUserIncorrect() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99", "+2783896896");
        
        assertFalse(login.loginUser("wrong", "wrong"));
    }
    
    @Test
    public void testReturnLoginStatus() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99", "+2783896896");
        
        assertEquals(
              "Welcomekyl_1, it is great to see you again",
                login.returnLoginStatus(true)
        );
        
        assertEquals(
               "Username or password incorrect, please try again",
                login.returnLoginStatus(false)
        );
    }
        
    }

    

