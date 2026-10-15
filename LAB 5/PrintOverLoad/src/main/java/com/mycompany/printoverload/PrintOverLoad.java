/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.printoverload;

/**
 *
 * @author Windows 10 Pro
 */
import java.util.Arrays; //Explain: Import the Arrays utility class to easily convert arrays into readable string format

public class PrintOverLoad {
    //Explain: Overloaded print method for integer parameters
    static void print(int x) { 
        System.out.println(x); 
    }

    //Explain: Overloaded print method for double parameters
    static void print(double x) { 
        System.out.println(x); 
    }

    //Explain: Overloaded print method for String parameters
    static void print(String x) { 
        System.out.println(x); 
    }

    //Explain: Overloaded print method for integer array parameters, utilizing Arrays.toString()
    static void print(int[] x) { 
        System.out.println(Arrays.toString(x)); 
    }

    public static void main(String[] args) {
        //Explain: The compiler automatically resolves and calls the correct print method based on the argument type passed
        print(7);          // Calls print(int)
        print(3.5);        // Calls print(double)
        print("Java");     // Calls print(String)
        print(new int[]{1, 2, 3}); // Calls print(int[])
    }
}
