/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.withdrawdemo;

/**
 *
 * @author Windows 10 Pro
 */
//Explain: Custom checked exception representing a business rule failure
class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) { 
        super(message); 
    }
}

class BankAccount {
    private double balance;
    
    BankAccount(double balance) { 
        this.balance = balance; 
    }
    
    void withdraw(double amount) throws InsufficientFundsException {
        //Explain: Unchecked IllegalArgumentException thrown for invalid negative or zero parameters
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        
        //Explain: Checked exception thrown when withdrawal exceeds the available account balance
        if (amount > balance) {
            throw new InsufficientFundsException("Not enough money");
        }
        
        balance -= amount;
    }
    
    double getBalance() { 
        return balance; 
    }
}

public class WithdrawDemo {
    public static void main(String[] args) {
        BankAccount a = new BankAccount(100);
        try {
            a.withdraw(150); 
        } catch (InsufficientFundsException e) {
            //Explain: Catching the custom exception and printing the error message
            System.out.println(e.getMessage()); 
        }
        //Explain: Balance remains unchanged due to the intercepted withdrawal attempt
        System.out.println(a.getBalance());
    }
}
