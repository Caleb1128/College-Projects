/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10443421poe1;
import javax.swing.JOptionPane;//import what is needed for JOptionPane.
/**
 *
 * @author mkbph
 */
public class Login {

    private String name;//for the user to enter their name
    private String surname;//for the user to enter their surname
    private String username;//for the user to enter their username
    private String password;//for the user to enter their password
    private String enteredUsername;//login method captures entered username
    private String enteredPassword;//login method captures entered Password
    
    public static boolean checkUsername(String username)//Method for Username complexity
    {
        return username.contains("_") && username.length() <= 5;//checks if username contains underscore
    }

    public boolean checkPassword(String Password) //Sets/Checks the complexity of the password
    {
        boolean length = false;//helps checks for character length
        boolean uppercase = false;//helps check for character uppercase
        boolean digit = false;//helps check for digit in password
        boolean specialChar = false;//helps check if password has specialcharacters

        for (int i = 0; i < password.length(); i++) {
            char complexP = password.charAt(i);
            if (password.length() >= 8) {
                length = true;
            }
            if (Character.isUpperCase(complexP)) {
                uppercase = true;
            }
            if (Character.isDigit(complexP)) {
                digit = true;
            }
            if (!Character.isLetterOrDigit(complexP)) {
                specialChar = true;
            }
        }
        return length && uppercase && digit && specialChar;
    }

    public boolean registerUser() {//User Registers themselelves
        JOptionPane.showMessageDialog(null, "Welcome to Kanban website \n You can register here.");
        name = JOptionPane.showInputDialog("Please enter your Name");//User enters their name
        surname = JOptionPane.showInputDialog("Please enter your Surname");//user eneters their surname
        username = JOptionPane.showInputDialog("Please enter your preferred Username");//user enters their username

        if (checkUsername(username)) {
            JOptionPane.showMessageDialog(null, "Username is successfully captured");//Username meets requirements

        } //(Michael,2019)
        else {
            JOptionPane.showMessageDialog(null, "Username is invalid, please try again \n Username must contain: *an underscore \n *5 characters or less");//Username does not meet requirements
            return false;
        }

        password = JOptionPane.showInputDialog("PLease enter your preferred Password");//User enters password

        if (checkPassword(password)){
            JOptionPane.showMessageDialog(null, "Password is successfully captured");//Password meets requirements
            }
        else{
            JOptionPane.showMessageDialog(null, "Password is invalid, please try again \n Password must contain: + \n *8 Characters or more  \n *Digits \n *Special Characters \n *Uppercase letter/s");//Password does not meet requirements
            }
        return false;
    }
        /*Refernce list:
        Michael, 2019. Password Strength Validation java[Online]
        Available at: https://stackoverflow.com/q/54869952/24321433
        [Accessed 14 April 2024]
        */
            
        public boolean loginUser(){
             enteredUsername = JOptionPane.showInputDialog(null, "Confirm username:");//Type in Username
             enteredPassword = JOptionPane.showInputDialog(null, "Confirm password:");//Type in Password
            
            if(enteredUsername.equals(username) && enteredPassword.equals(password)){
            //message to be displayed if the login has been successful
            //(Aaron Maenpaa,2023)
            JOptionPane.showMessageDialog(null, "Welcome " + " , " + name + " " + surname + " ! ");
            return true;
        } else {
            //error message to be displayed if the login was unsuccessful
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again.");
           return false;
        }
        /*
        Reference List:
        Aaron Maenpaa, 2023. How do i compare Strings in java[Online]
        Available at: https://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java
        [Accessed 14 April 2024]
        */
    } 
}
    

