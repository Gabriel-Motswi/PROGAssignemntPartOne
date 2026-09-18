/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progassignemntpartone;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Registration ===");
        
         System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter South African cell phone number: ");
        String cellPhone = scanner.nextLine();

        Login user = new Login(username, password, cellPhone);

        System.out.println();
        System.out.println(user.registerUser());
        
        System.out.println("\n=== Login ===");
        
        System.out.println("Enter your username: ");
        String loginUsername = scanner.nextLine();
        
        System.out.println("Enter your password: ");
        String loginPassword = scanner.nextLine();
        
        boolean loginSuccessful = user.loginUser(loginUsername, loginPassword);
        
        System.out.println(user.returnLoginStatus(loginSuccessful));

        scanner.close();
    } 
}

// Reference List
//Department for Environment, Food and Rural Affairs, 2007. Sustainable developement: the bigger picture. [video online] Available at: <youtube.com> [Accessed 23 June 2012]
// GeeksForGeeks, 2024. How to check password validility in Java. Available at: <geeksforgeeks.org> [Accessed 5 September 2026]
//Oracle, 2023. Class Scanner - Java Platform SE 8. Available at: <docs.oracle.com> [Accessed 11 September 2026]
//W3Schools, 2024. Java RegEx - Regular Expressions. Available at: <w3schools.com> [Accessed 18 September 2026]