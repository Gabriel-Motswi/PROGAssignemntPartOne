/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progassignemntpartone;

import java.util.Scanner;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Student
 */


public class Main {
    
    private static int totalMessages = 0;
    private static ArrayList<Message> sentMessages = new ArrayList<>();
    
    // Main entry point: starts the application and manages user input
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Registration ===");
        
         System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter South African cell phone number: ");
        String cellPhone = scanner.nextLine();

        Login user = new Login(username, password, cellPhone); // Creates a Login object using the registration details.

        System.out.println();
        System.out.println(user.registerUser());
        
        System.out.println("\n=== Login ===");
        
        System.out.println("Enter your username: ");
        String loginUsername = scanner.nextLine();
        
        System.out.println("Enter your password: ");
        String loginPassword = scanner.nextLine();
        
        boolean loginSuccessful = user.loginUser(loginUsername, loginPassword); // Checks the login details and displays the login status.
        
        System.out.println(user.returnLoginStatus(loginSuccessful));
        
        if (loginSuccessful) {
            
            System.out.println("Welcome to QuickChat.");
            
            System.out.println("How many messages do you want to enter?");
            int maxMessages = scanner.nextInt(); // Gets the maximum number of message entries allowed
            scanner.nextLine();
            
            int messagesEntered = 0;
            
            int option;
            
            do { // Repeats the menu until the user chooses to quit.
                
            System.out.println("\n=== QuickChat ===");
            
            System.out.println("1. Send Message");
            System.out.println("2. Show Messages");
            System.out.println("3. Quit");
            
            System.out.println("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();
            
            if (option == 1) { // Processes the user's selected menu option.
                if (messagesEntered >= maxMessages) {
                    System.out.println("You have reached your message limit.");
                } else {
                    System.out.println("\n=== Send Message ===");
                
                
                System.out.println("Enter recipient cellphone number: ");
                String recipient = scanner.nextLine();
                
                System.out.println("Enter your message: ");
                String messageText = scanner.nextLine();
                
                Message message = new Message(totalMessages + 1, recipient, messageText);
                messagesEntered++;
                
                System.out.println("\nMessage ID: " + message.getMessageID());
                System.out.println("Recipient: " + message.getRecipient());
                System.out.println("Message: " + message.getMessage());
                System.out.println("Message Hash: " + message.getMessageHash());
                
                if (!message.checkMessageID()) {
                    System.out.println("Message ID is not valid.");
                } else if (!message.checkRecipientCell()) {
                    System.out.println("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
                } else if (!message.checkMessageLength()) {
                    int excess = messageText.length() - 250;
                    
                    System.out.println("Message exceeds 250 characters by "
                            + excess + "; please reduce this size.");
                } else {
                    System.out.println("Cell phone number successfully captured.");
                    System.out.println("Message ready to send.");
                    
                    System.out.println("\nChoose an option");
                    System.out.println("1. Send Message");
                    System.out.println("2. Disregard Message");
                    System.out.println("3. Store Message to send later");
                    System.out.println("Enter your choice");
                    
                    
                    int messageChoice = scanner.nextInt();
                    scanner.nextLine();
                    
                if (messageChoice == 1) { // Handles the user's decision to send, disregard or store the message.
                    System.out.println(message.SentMessage(messageChoice));
                    sentMessages.add(message);
                    totalMessages++;
                } else if (messageChoice == 2) {
                    System.out.println(message.SentMessage(messageChoice));
                } else if (messageChoice == 3) {
                    storeMessage(message);
                } else {
                    System.out.println("Invalid option.");
                }
                        }
                    }
                } else if (option == 2) {
                        System.out.println("\nComing Soon.");
                } else if (option == 3) {
                        System.out.println("\nThank you for using QuickChat.");
                } else {
                        System.out.println("\nInvalid option.");
                }
           
        } while (option != 3); 
            System.out.println("Total messages sent: " + totalMessages);
        
            
             scanner.close();
        }
        
     }
    
    public static void storeMessage(Message message) {
        try {
            JSONObject jsonObject = new JSONObject();
            
            jsonObject.put("MessageID", message.getMessageID());
            jsonObject.put("Meesage Number", message.getMessageNumber());
            jsonObject.put("Recipient", message.getRecipient());
            jsonObject.put("Message", message.getMessage());
            jsonObject.put("MessageHash", message.getMessageHash());
            
            FileWriter file = new FileWriter("messages.json", true);
            file.write(jsonObject.toString(4));
            file.write(System.lineSeparator());
            file.close();
            
            System.out.println("Message successfully stored.");
            
            } catch (IOException e) {
            System.out.println("Error storing message.");
        }
    }
    
    public static int returnTotalMessages() { // Returns the total number of messages successfully sent.
        return totalMessages;
    }
    
    public static String printMessages() {
    StringBuilder result = new StringBuilder();

    for (Message message : sentMessages) {
        result.append("Message ID: ")
              .append(message.getMessageID())
              .append("\nMessage Hash: ")
              .append(message.getMessageHash())
              .append("\nRecipient: ")
              .append(message.getRecipient())
              .append("\nMessage: ")
              .append(message.getMessage())
              .append("\n\n");
    }

    return result.toString();
}
}

// Reference List
//Department for Environment, Food and Rural Affairs, 2007. Sustainable developement: the bigger picture. [video online] Available at: <youtube.com> [Accessed 23 June 2012]
// GeeksForGeeks, 2024. How to check password validility in Java. Available at: <geeksforgeeks.org> [Accessed 5 September 2026]
//Oracle, 2023. Class Scanner - Java Platform SE 8. Available at: <docs.oracle.com> [Accessed 11 September 2026]
//W3Schools, 2024. Java RegEx - Regular Expressions. Available at: <w3schools.com> [Accessed 18 September 2026]