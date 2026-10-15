/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vehicledemo;

/**
 *
 * @author Windows 10 Pro
 */
class Vehicle {
    //Explain: Base class constructor that runs first in the inheritance chain when any vehicle is created
    Vehicle() {
        System.out.println("Vehicle constructor"); 
    }
}

class Car extends Vehicle {
    //Explain: Subclass constructor that implicitly calls super() first, triggering the Vehicle constructor before its own body
    Car() {
        System.out.println("Car constructor"); 
    }
}

class ElectricCar extends Car {
    //Explain: Deepest subclass constructor that implicitly chains up to Car (and transitively Vehicle) before printing its message
    ElectricCar() { 
        System.out.println("ElectricCar constructor");
    }
}

public class VehicleDemo {
    public static void main(String[] args) { 
        //Explain: Instantiating ElectricCar triggers constructor chaining from top to bottom: Vehicle -> Car -> ElectricCar
        new ElectricCar(); 
    }
}
