/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.payrolldemo;

/**
 *
 * @author Windows 10 Pro
 */
class Employee {
    String name;
    double salary;

    //Explain: Constructor to initialize the employee's name and salary
    Employee(String name, double salary) { 
        this.name = name; 
        this.salary = salary; 
    }

    //Explain: Base method to calculate pay, which can be overridden by subclasses
    double calculatePay() { 
        return salary; 
    }
}

class Intern extends Employee {
    //Explain: Constructor that chains to the parent class constructor using super() to pass the stipend
    Intern(String name, double stipend) { 
        super(name, stipend); 
    }

    //Explain: Method overriding - provides a specific implementation of calculatePay() for an intern
    @Override
    double calculatePay() { 
        return salary; 
    }
}

public class PayrollDemo {
    public static void main(String[] args) {
        //Explain: Polymorphism in action - an array of type Employee holding both a base Employee and an Intern subclass instance
        Employee[] staff = { 
            new Employee("Manager", 2000), 
            new Intern("Intern", 400) 
        };
        
        double total = 0;
        
        //Explain: Dynamic method dispatch - at runtime, Java automatically determines the actual object type and calls its specific calculatePay() method
        for (Employee e : staff) {
            total += e.calculatePay();
        }
        
        //Explain: Print the final computed payroll sum to the console
        System.out.println("Payroll: " + total);
    }
}
