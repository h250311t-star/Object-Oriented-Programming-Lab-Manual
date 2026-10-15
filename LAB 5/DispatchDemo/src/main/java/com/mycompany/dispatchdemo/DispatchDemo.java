/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dispatchdemo;

/**
 *
 * @author Windows 10 Pro
 */
class Animal {
    //Explain: Base class field 'type' initialized to "Animal"
    String type = "Animal";
    
    //Explain: Base class method providing a default sound
    void sound() { 
        System.out.println("Animal sound"); 
    }
}

class Dog extends Animal {
    //Explain: Subclass field 'type' shadows (hides) the parent class field of the same name rather than overriding it
    String type = "Dog";
    
    //Explain: Method overriding - provides a specialized implementation of sound() for Dog objects
    @Override
    void sound() { 
        System.out.println("Woof"); 
    }
}

public class DispatchDemo {
    public static void main(String[] args) {
        //Explain: Polymorphism in action - an Animal reference variable pointing to an actual Dog object instance
        Animal a = new Dog();
        
        //Explain: Fields are bound at compile-time based on the *declared reference type* (Animal), so it prints "Animal"
        System.out.println(a.type); // Animal: field follows declared reference type
        
        //Explain: Methods are bound at runtime based on the *actual object type* (Dog) via Dynamic Method Dispatch, so it prints "Woof"
        a.sound();                  // Woof: overridden method follows actual object
    }
}