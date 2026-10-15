/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accounthistorydemo;

/**
 *
 * @author Windows 10 Pro
 */
import java.util.*; //Explain: Import Java utility classes like List, ArrayList, and Collections

class BankAccount {
    //Explain: Private field to securely store the account balance
    private double balance;
    
    //Explain: Private final list to track the account's transaction history securely
    private final List<String> history = new ArrayList<>();

    //Explain: Constructor to initialize the account with an opening balance and log it in the history
    BankAccount(double opening) { 
        balance = opening; 
        history.add("Opened: " + opening); 
    }

    //Explain: Method to deposit funds, with input validation ensuring the amount is strictly positive
    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance += amount; 
        history.add("Deposit: " + amount);
    }

    //Explain: Getter method that returns an unmodifiable copy of the history list to preserve encapsulation and prevent external tampering
    List<String> getHistory() {
        return Collections.unmodifiableList(new ArrayList<>(history));
    }
}

public class AccountHistoryDemo {
    public static void main(String[] args) {
        //Explain: Create a new BankAccount object with an opening balance of 100
        BankAccount a = new BankAccount(100);
        
        //Explain: Deposit 50 into the account, which updates the balance and records the transaction in history
        a.deposit(50);
        
        //Explain: Iterate through and print each secure transaction record retrieved from the account history log
        for (String item : a.getHistory()) {
            System.out.println(item);
        }
    }
}