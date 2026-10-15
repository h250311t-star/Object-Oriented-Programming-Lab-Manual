/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rectanglealias;

/**
 *
 * @author Windows 10 Pro
 */
public class RectangleAlias {
    //Explain: A static inner class representing a simple Rectangle with a width property
    static class Rectangle { 
        int width; 
        
        //Explain: Constructor to initialize the rectangle's width
        Rectangle(int width) { 
            this.width = width; 
        } 
    }

    public static void main(String[] args) {
        //Explain: Create a new Rectangle object with a width of 4, referenced by r1
        Rectangle r1 = new Rectangle(4);
        
        //Explain: Object aliasing - r2 is assigned r1, meaning both variables point to the exact same object in memory
        Rectangle r2 = r1; 
        
        //Explain: Modify the width of the shared object through the r2 reference
        r2.width = 10;
        
        //Explain: Print the width using r1; it outputs 10 because both r1 and r2 share the same underlying object
        System.out.println(r1.width); // 10
    }
}
