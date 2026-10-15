/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arrayaccessdemo;

/**
 *
 * @author Windows 10 Pro
 */
public class ArrayAccessDemo {
    static void show(int[] values, int index) {
        try {
            //Explain: Attempting to access an index outside the array bounds
            System.out.println(values[index]); 
        } catch (ArrayIndexOutOfBoundsException e) {
            //Explain: Catches out-of-bounds access and prevents program crash
            System.out.println("Invalid array index"); 
        }
    }
    
    public static void main(String[] args) { 
        show(new int[]{4, 8, 12}, 5); 
    }
}
