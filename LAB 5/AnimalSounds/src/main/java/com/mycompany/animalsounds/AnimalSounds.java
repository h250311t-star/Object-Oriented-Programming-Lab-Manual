/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.animalsounds;

/**
 *
 * @author Windows 10 Pro
 */
class Animal {
    //Explain: Base method in the superclass providing a generic default sound
    void sound() {
        System.out.println("Unknown sound"); 
    } 
}

class Cat extends Animal { 
    //Explain: Method overriding - provides a specific implementation of sound() for Cat objects
    @Override 
    void sound() {
        System.out.println("Meow"); 
    } 
}

class Cow extends Animal { 
    //Explain: Method overriding - provides a specific implementation of sound() for Cow objects
    @Override 
    void sound() {
        System.out.println("Moo"); 
    } 
}

class Duck extends Animal { 
    //Explain: Method overriding - provides a specific implementation of sound() for Duck objects
    @Override 
    void sound() {
        System.out.println("Quack"); 
    } 
}

public class AnimalSounds {
    public static void main(String[] args) {
        //Explain: Polymorphism in action - creating an array of Animal references holding various subclass instances (Cat, Cow, Duck)
        Animal[] animals = { new Cat(), new Cow(), new Duck() };
        
        //Explain: Dynamic method dispatch - at runtime, Java automatically determines the actual object type and calls its specific overridden sound() method
        for (Animal a : animals) {
            a.sound();
        }
    }
}
