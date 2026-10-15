/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.circlecountdemo;

/**
 *
 * @author Windows 10 Pro
 */
class Circle {
    //Explain: A private static variable shared across all Circle instances to keep track of the total number of circles created
    private static int count = 0;
    
    double radius;

    //Explain: Default constructor that chains to the parameterized constructor, setting a default radius of 1.0
    Circle() { 
        this(1.0); 
    }

    //Explain: Parameterized constructor that initializes the radius and increments the static count variable for every new object
    Circle(double radius) { 
        this.radius = radius; 
        count++; 
    }

    //Explain: Static getter method to safely access the private static count variable from outside the class
    static int getCount() { 
        return count; 
    }
}

public class CircleCountDemo {
    public static void main(String[] args) {
        //Explain: Instantiate three Circle objects using both the default and parameterized constructors
        new Circle(); 
        new Circle(2); 
        new Circle(4);
        
        //Explain: Call the static getCount method directly on the class to print the total number of created circles (3)
        System.out.println(Circle.getCount()); // 3
    }
}