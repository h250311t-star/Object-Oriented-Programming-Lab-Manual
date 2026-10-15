/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accountdemo;

/**
 *
 * @author Windows 10 Pro
 */
abstract class Account {
    //Explain: Protected field accessible by subclasses
    protected double balance;
    
    //Explain: Constructor to initialize common state
    Account(double balance) { 
        this.balance = balance; 
    }
    
    //Explain: Concrete method inherited and shared by all account types
    void deposit(double amount) {
        if (amount > 0) balance += amount;
    }
    
    //Explain: Abstract method forcing subclasses to define their specific fee structure
    abstract double monthlyFee();
}

class SavingsAccount extends Account {
    SavingsAccount(double b) { super(b); }
    double monthlyFee() { return 2.0; }
}

class CurrentAccount extends Account {
    CurrentAccount(double b) { super(b); }
    double monthlyFee() { return 5.0; }
}

public class AccountDemo {
    public static void main(String[] args) {
        //Explain: Instantiating a subclass via abstract superclass reference
        Account a = new SavingsAccount(100);
        a.deposit(25); // Uses inherited concrete method
        System.out.println(a.balance + " fee " + a.monthlyFee()); // Uses subclass implementation
    }
}