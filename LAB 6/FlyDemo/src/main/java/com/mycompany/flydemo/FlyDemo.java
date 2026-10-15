/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.flydemo;

/**
 *
 * @author Windows 10 Pro
 */
//Explain: Interface defines a contract (behavior) that implementing classes must fulfill
interface Flyable { 
    void fly(); 
}

class Bird implements Flyable { 
    //Explain: Implementing the interface contract for a biological entity
    public void fly() {
        System.out.println("Bird flaps wings"); 
    } 
}

class Aeroplane implements Flyable { 
    //Explain: Implementing the interface contract for a machine
    public void fly() { 
        System.out.println("Aeroplane uses engines"); 
    } 
}

public class FlyDemo {
    public static void main(String[] args) {
        //Explain: Polymorphism via interface type allowing uniform handling of unrelated classes
        Flyable[] flyers = { new Bird(), new Aeroplane() };
        for (Flyable f : flyers) {
            f.fly();
        }
    }
}
