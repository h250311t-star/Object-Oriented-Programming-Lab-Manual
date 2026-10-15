/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employeedemo;

/**
 *
 * @author Windows 10 Pro
 */
class Employee {
    //Explain: A private static variable shared across all instances to automatically generate a unique, sequential ID
    private static int nextId = 1;
    
    int id;
    String name; 
    double salary;

    //Explain: Default constructor that chains to the two-argument constructor with default values
    Employee() { 
        this("Unknown", 0); 
    }

    //Explain: Overloaded single-argument constructor that chains to the two-argument constructor, setting a default salary
    Employee(String name) { 
        this(name, 0); 
    }

    //Explain: Primary constructor that assigns an auto-incremented ID and initializes the employee's name and salary
    Employee(String name, double salary) {
        this.id = nextId++; 
        this.name = name; 
        this.salary = salary;
    }

    //Explain: Copy constructor that creates a new Employee using the values from an existing Employee object
    Employee(Employee other) { 
        this(other.name, other.salary); 
    }

    //Explain: Method to print the employee's ID, name, and salary to the console
    void display() { 
        System.out.println(id + " " + name + " " + salary); 
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        //Explain: Create the first Employee object using the name and salary constructor (gets ID = 1)
        Employee a = new Employee("Tariro", 900);
        
        //Explain: Create a second Employee using the copy constructor, duplicating 'a's details (gets ID = 2)
        Employee b = new Employee(a);
        
        //Explain: Display the details of both employees
        a.display(); 
        b.display();
    }
}
