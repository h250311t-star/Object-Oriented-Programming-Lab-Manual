/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardemo;

/**
 *
 * @author Windows 10 Pro
 */

import java.time.Year; //Explain: Import the Year class to dynamically retrieve the current year

class Car {
    String brand;
    int year;
    double mileage;

    //Explain: Constructor used to initialize a new Car object with brand, year, and mileage values
    Car(String brand, int year, double mileage) {
        this.brand = brand; 
        this.year = year; 
        this.mileage = mileage;
    }

    //Explain: Method to print the car's brand, manufacturing year, and mileage to the console
    void display() {
        System.out.println(brand + ", year " + year + ", mileage " + mileage);
    }

    //Explain: Method to determine if the car is an antique by checking if it is older than 25 years
    boolean isAntique() { 
        return Year.now().getValue() - year > 25; 
    }
}

public class CarDemo {
    public static void main(String[] args) {
        //Explain: Create and initialize an array of multiple Car objects
        Car[] cars = {
            new Car("Toyota", 1998, 180000),
            new Car("Honda", 2018, 65000),
            new Car("Mazda", 2000, 150000)
        };

        //Explain: Iterate through each car in the array to display its details and check its antique status
        for (Car car : cars) {
            car.display();
            System.out.println("Antique? " + car.isAntique());
        }
    }
}



