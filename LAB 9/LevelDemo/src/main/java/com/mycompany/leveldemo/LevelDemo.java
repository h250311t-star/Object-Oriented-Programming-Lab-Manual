/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.leveldemo;

/**
 *
 * @author Windows 10 Pro
 */
//Explain: Defining an enum type with constant values representing priority or urgency levels
enum Level {
    LOW, MEDIUM, HIGH
}

public class LevelDemo {

    public static void main(String[] args) {
        //Explain: Level.values() returns an array of all enum constants
        for (Level level : Level.values()) {
            //Explain: Enhanced switch expression (arrow syntax) handles each enum constant cleanly
            switch (level) {
                case LOW ->
                    System.out.println("LOW: Work at a steady pace.");
                case MEDIUM ->
                    System.out.println("MEDIUM: Pay attention.");
                case HIGH ->
                    System.out.println("HIGH: Take action now.");
            }
        }
    }
}
