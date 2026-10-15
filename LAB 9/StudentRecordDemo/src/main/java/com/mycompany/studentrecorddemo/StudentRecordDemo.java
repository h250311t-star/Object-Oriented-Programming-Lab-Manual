/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.studentrecorddemo;

/**
 *
 * @author Windows 10 Pro
 */
//Explain: A record automatically generates a constructor, private final fields, accessors, equals(), hashCode(), and toString()
record Student(String name, int age) {}

public class StudentRecordDemo {

    public static void main(String[] args) {
        Student a = new Student("Tariro", 20), b = new Student("Tariro", 20);

        //Explain: toString() is automatically provided by the record
        System.out.println(a);

        //Explain: equals() compares component-by-component value equality rather than memory reference
        System.out.println(a.equals(b)); // true: same component values

        //Explain: Record components act as accessor methods (e.g., name() instead of getName())
        System.out.println(a.name());   // record accessor
    }
}
