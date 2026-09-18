/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progassignemntpartone;

/**
 *
 * @author Student
 */
public class Login {
    
    
    private final String username;
    private final String password;
    private final String cellPhone;
    
    // constructor
    public Login(String username, String password, String cellPhone) {
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;
    }
    
    // checking the username
    public boolean checkUserName() {
       boolean Username;
       
       if (username.contains("_") && username.length() <=5){
       Username = true;
           System.out.println("Username sucessfully captured");
       }else{
       Username = false;
           System.out.println("Username is not correctly formatted");
       }
       return Username;
    }
    
   // checking the password
    public boolean checkPasswordComplexity() {

    if (password.length() < 8) {
        return false;
    }

    boolean hasCapital = false;
    boolean hasNumber = false;
    boolean hasSpecial = false;

    for (int i = 0; i < password.length(); i++) {
        char character = password.charAt(i);

        if (Character.isUpperCase(character)) {
            hasCapital = true;
        }

        if (Character.isDigit(character)) {
            hasNumber = true;
        }

        if (!Character.isLetterOrDigit(character)) {
            hasSpecial = true;
        }
    }

    return hasCapital && hasNumber && hasSpecial;
}
    
    // checking cell phone number
    public boolean checkCellPhoneNumber() { // regex method
        
        String phoneRegex = "^\\+27[0-9]{9}$";
        
        return cellPhone.matches(phoneRegex);
    }
    
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }
    
    public String returnLoginStatus(boolean loginSuccessful) {
        if (loginSuccessful) {
            return "Welcome" + username + ", it is great to see you again";
        } else {
            return "Username or password incorrect, please try again";
        }
    }
    
    
    // register the user
    public String registerUser() {
        
        if(!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no longer than five charcters in length";
            
        }
        
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character";
            
        }
        
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted  or does not contain international code";
            
        }
        
        return "Registration successful";
    }
    
    
}
