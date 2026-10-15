/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.paymentdemo;

/**
 *
 * @author Windows 10 Pro
 */
//Explain: Define an interface to establish a common contract (behavioral standard) for all payment types
interface Payment { 
    void process(); 
}

//Explain: Concrete class implementing the Payment interface for card transactions
class CardPayment implements Payment {
    @Override
    public void process() { 
        System.out.println("Processing card payment"); 
    }
}

//Explain: Concrete class implementing the Payment interface for mobile money transactions
class MobileMoneyPayment implements Payment {
    @Override
    public void process() { 
        System.out.println("Processing mobile money"); 
    }
}

//Explain: A processor class that accepts any object implementing the Payment interface, keeping code extensible without needing 'instanceof' checks
class PaymentProcessor {
    void pay(Payment p) { 
        p.process(); // Polymorphic call: executes the correct process() method based on the actual object passed
    } 
}

public class PaymentDemo {
    public static void main(String[] args) {
        //Explain: Instantiate the PaymentProcessor helper
        PaymentProcessor processor = new PaymentProcessor();
        
        //Explain: Pass different payment implementations polymorphically into the same processor method
        processor.pay(new CardPayment());
        processor.pay(new MobileMoneyPayment());
    }
}
