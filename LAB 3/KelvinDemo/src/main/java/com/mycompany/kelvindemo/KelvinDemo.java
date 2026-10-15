/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.kelvindemo;

/**
 *
 * @author Windows 10 Pro
 */
class Temperature {
    //Explain: Private and final field to store the temperature in Kelvin securely and ensure immutability
    private final double kelvin;

    //Explain: Constructor that validates the input to ensure it is not below absolute zero (0 Kelvin)
    Temperature(double kelvin) {
        if (kelvin < 0) {
            throw new IllegalArgumentException("Below absolute zero");
        }
        this.kelvin = kelvin;
    }

    //Explain: Method to calculate and return the temperature converted from Kelvin to Celsius
    double getCelsius() { 
        return kelvin - 273.15; 
    }

    //Explain: Method to calculate and return the temperature converted to Fahrenheit by leveraging the Celsius conversion
    double getFahrenheit() { 
        return getCelsius() * 9 / 5 + 32; 
    }
}

public class KelvinDemo {
    public static void main(String[] args) {
        //Explain: Create a Temperature object with 300 Kelvin and print its converted Celsius and Fahrenheit values
        Temperature t = new Temperature(300);
        System.out.println(t.getCelsius());
        System.out.println(t.getFahrenheit());
    }
}
