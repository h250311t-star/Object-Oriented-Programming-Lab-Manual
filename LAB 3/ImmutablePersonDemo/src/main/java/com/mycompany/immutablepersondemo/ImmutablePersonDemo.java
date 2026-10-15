/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.immutablepersondemo;

/**
 *
 * @author Windows 10 Pro
 */
//Explain: Declaring the class as final prevents subclassing, ensuring that subclasses cannot compromise its immutability
final class ImmutablePerson {
    //Explain: Private and final fields ensure that the object's state cannot be changed once initialized
    private final String name;
    private final int age;

    //Explain: Constructor that validates inputs, rejecting null names, blank strings, or negative ages
    ImmutablePerson(String name, int age) {
        if (name == null || name.isBlank() || age < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name; 
        this.age = age;
    }

    //Explain: Getter method to safely read the name; no setter methods exist to preserve immutability
    public String getName() { 
        return name; 
    }

    //Explain: Getter method to safely read the age
    public int getAge() { 
        return age; 
    }
}

public class ImmutablePersonDemo {
    public static void main(String[] args) {
        //Explain: Create a new ImmutablePerson instance and print its state using getter methods
        ImmutablePerson p = new ImmutablePerson("Chipo", 20);
        System.out.println(p.getName() + " " + p.getAge());
    }
}