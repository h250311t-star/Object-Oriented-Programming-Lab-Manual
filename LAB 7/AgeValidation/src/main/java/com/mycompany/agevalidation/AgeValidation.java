/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.agevalidation;

/**
 *
 * @author Windows 10 Pro
 */
//Explain: Creating a custom checked exception by extending the Exception class
class InvalidAgeException extends Exception {
    InvalidAgeException(String message) { 
        super(message); 
    }
}

public class AgeValidation {
    static void validateAge(int age) throws InvalidAgeException {
        //Explain: Explicitly throwing a custom checked exception if the validation fails
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age must be from 0 to 120");
        }
    }
    
    public static void main(String[] args) {
        try {
            validateAge(150); 
            System.out.println("Valid"); 
        } catch (InvalidAgeException e) {
            //Explain: Handling the custom exception and extracting its error message
            System.out.println(e.getMessage()); 
        }
    }
}
