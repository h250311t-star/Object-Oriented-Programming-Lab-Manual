/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.circledemo;

/**
 *
 * @author Windows 10 Pro
 */
class Circle {
    //Explain: Instance variable to store the radius of the circle
    double radius;

    //Explain: Default constructor that chains to the parameterized constructor, setting a default radius of 1.0
    Circle() { 
        this(1.0); 
    }

    //Explain: Parameterized constructor to initialize the circle with a specific radius
    Circle(double radius) { 
        this.radius = radius; 
    }

    //Explain: Method to calculate and return the area of the circle using Math.PI
    double area() { 
        return Math.PI * radius * radius; 
    }
}

public class CircleDemo {
    public static void main(String[] args) {
        //Explain: Create an anonymous Circle object using the default constructor and print its radius (1.0)
        System.out.println(new Circle().radius);
        
        //Explain: Create an anonymous Circle object with a radius of 3 and print its calculated area
        System.out.println(new Circle(3).area());
    }
}