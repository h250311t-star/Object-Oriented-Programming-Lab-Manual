/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rectangledemo;

/**
 *
 * @author Windows 10 Pro
 */

class Rectangle {
    //Explain: Fields to store the width and height of the rectangle
    double width, height;

    //Explain: Constructor to initialize a Rectangle object with specific dimensions
    Rectangle(double width, double height) {
        this.width = width; 
        this.height = height;
    }

    //Explain: Method to calculate and return the area of the rectangle
    double area() { 
        return width * height; 
    }

    //Explain: Method to calculate and return the perimeter of the rectangle
    double perimeter() { 
        return 2 * (width + height); 
    }
}

public class RectangleDemo {
    public static void main(String[] args) {
        //Explain: Create and initialize an array of multiple Rectangle objects
        Rectangle[] rs = { 
            new Rectangle(2,3), 
            new Rectangle(5,4),
            new Rectangle(1,9), 
            new Rectangle(7,2), 
            new Rectangle(3,3) 
        };

        //Explain: Initialize the first rectangle as the current largest
        Rectangle largest = rs[0];

        //Explain: Loop through the array to find the rectangle with the largest area
        for (Rectangle r : rs) {
            if (r.area() > largest.area()) {
                largest = r;
            }
        }

        //Explain: Print the area and perimeter of the largest rectangle found
        System.out.println("Largest area: " + largest.area());
        System.out.println("Perimeter: " + largest.perimeter());
    }
}

