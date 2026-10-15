/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.temperaturedemo;

/**
 *
 * @author Windows 10 Pro
 */
class Temperature {
    //Explain: A private and final field to store the temperature in Celsius, ensuring object immutability
    private final double celsius;

    //Explain: A private constructor that validates the input against absolute zero (-273.15°C) before initialization
    private Temperature(double celsius) {
        if (celsius < -273.15) {
            throw new IllegalArgumentException("Below absolute zero");
        }
        this.celsius = celsius;
    }

    //Explain: Static factory method to create a Temperature instance directly from a Celsius value
    static Temperature fromCelsius(double c) { 
        return new Temperature(c); 
    }

    //Explain: Static factory method to convert Fahrenheit to Celsius and return a new Temperature instance
    static Temperature fromFahrenheit(double f) {
        return new Temperature((f - 32) * 5 / 9);
    }

    //Explain: Getter method to retrieve the stored temperature in Celsius
    double getCelsius() { 
        return celsius; 
    }

    //Explain: Getter method that calculates and returns the temperature converted to Fahrenheit
    double getFahrenheit() { 
        return celsius * 9 / 5 + 32; 
    }
}

public class TemperatureDemo {
    public static void main(String[] args) {
        //Explain: Create a Temperature object from 25°C and print its value converted to Fahrenheit (77.0)
        System.out.println(Temperature.fromCelsius(25).getFahrenheit());
        
        //Explain: Create a Temperature object from 32°F and print its value converted to Celsius (0.0)
        System.out.println(Temperature.fromFahrenheit(32).getCelsius());
    }
}
