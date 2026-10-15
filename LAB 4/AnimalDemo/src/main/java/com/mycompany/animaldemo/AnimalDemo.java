/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.animaldemo;

/**
 *
 * @author Windows 10 Pro
 */
class Animal {
    String name;
    
    //Explain: Parameterized constructor in the parent class; notice that no default (no-argument) constructor is provided
    Animal(String name) { 
        this.name = name; 
    }
}

class Dog extends Animal {
    //Explain: The subclass constructor must explicitly call super(name) because Animal lacks a default constructor, passing the name up the chain
    Dog(String name) { 
        super(name); 
    } 
}

public class AnimalDemo {
    public static void main(String[] args) { 
        //Explain: Create a new Dog object and print its inherited 'name' field ("Rex") directly to the console
        System.out.println(new Dog("Rex").name); 
    }
}
