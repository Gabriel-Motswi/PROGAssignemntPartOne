/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.progassignemntpartone;

import java.util.Random;

// Stores message details and provides methods to generate messageID, messageHash, and validate messages
public class Message {
    
    // Variables used to store the details
    private String messageID;
    private String recipient;
    private String message;
    private String messageHash;
    private int messageNumber;
    
    // Initialises a new message with its number, recipient and text message.
    public Message(int messageNumber, String recipient, String message) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;
        
        generateMessageID();
        generateMessageHash();
    }
    
    // Generates a random ten digit ID to identify the message
    private void generateMessageID() {
        Random random = new Random();
        long id = 1000000000L
                 + (long) (Math.random() * 900000000L);
        
        messageID = String.valueOf(id);
    }
    
    // Creates a hash using the first two ID digits, message number and first and last words of the message
    private void generateMessageHash() {
        String[] words = message.trim().split("\\s+");
        
        String firstWord = words.length > 0
                ? words[0].replaceAll("[^a-zA-Z0-9]", "") : "";
        
        String lastWord = words.length > 0 
                ? words[words.length - 1].replaceAll("[^a-zA-Z0-9]", "") : "";
        
        String firstTwo = messageID.substring(0, 2);
        
        messageHash = (firstTwo + ":"
                + messageNumber + ":"
                + firstWord + lastWord).toUpperCase();
    }
    
    //Getter methods return the stored message information
    public String getMessageID() {
        return messageID;
    }
    
    public String getRecipient() {
        return recipient;
    }
    
    public String getMessage() {
        return message;
    }
    
    public String getMessageHash() {
        return messageHash;
    }
    
    public int getMessageNumber() {
        return messageNumber;
    }
    
    public boolean checkMessageID() {  // It will check whether the generated messages contains 10 characters
        return messageID != null && messageID.length() == 10;
    }
    
    public boolean checkRecipientCell() // Checks international code
    {
        return recipient != null && recipient.length() <=13 && recipient.contains("+27");
    }
    public boolean checkMessageLength()
    {
        return message != null && message.length() <= 250;
    }
    
    public String SentMessage(int choice) {
    if (choice == 1) {
        return "Message successfully sent.";
    } else if (choice == 2) {
        return "Press 0 to delete the message.";
    } else if (choice == 3) {
        return "Message successfully stored.";
    } else {
        return "Invalid option.";
   }
    }
  }

