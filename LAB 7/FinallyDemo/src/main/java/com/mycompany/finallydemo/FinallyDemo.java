/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.finallydemo;

/**
 *
 * @author Windows 10 Pro
 */
public class FinallyDemo {
    static int test() {
        try {
            System.out.println("Inside try");
            //Explain: Even though return is called here, the finally block executes first
            return 5;
        } finally {
            //Explain: Finally block guarantees execution before the method officially returns its value
            System.out.println("Finally runs before the method returns");
        }
    }
    
    public static void main(String[] args) { 
        System.out.println("Result: " + test()); 
    }
}
