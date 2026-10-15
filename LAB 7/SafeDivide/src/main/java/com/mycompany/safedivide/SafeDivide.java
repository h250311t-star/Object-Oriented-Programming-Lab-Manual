/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.safedivide;

/**
 *
 * @author Windows 10 Pro
 */
import java.util.Scanner;

public class SafeDivide {
    public static void main(String[] args) {
        //Explain: Try-with-resources statement automatically closes the Scanner resource when done
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter two integers: ");
            int a = sc.nextInt(), b = sc.nextInt();
            //Explain: Division might trigger an ArithmeticException if b is zero
            System.out.println("Answer: " + (a / b));
        } catch (ArithmeticException e) {
            //Explain: Catches division by zero errors gracefully
            System.out.println("Cannot divide by zero.");
        } catch (java.util.InputMismatchException e) {
            //Explain: Catches invalid input types (e.g., entering text instead of numbers)
            System.out.println("Please enter integers only.");
        }
    }
}
