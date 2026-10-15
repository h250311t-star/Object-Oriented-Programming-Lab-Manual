/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.defaultconflictdemo;

/**
 *
 * @author Windows 10 Pro
 */
interface A { 
    //Explain: Interface default method providing a fallback implementation
    default void hello() {
        System.out.println("Hello from A"); 
    } 
}

interface B { 
    //Explain: Conflicting default method with the same signature in another interface
    default void hello() {
        System.out.println("Hello from B"); 
    } 
}

class Both implements A, B {
    //Explain: Resolving the diamond/multiple inheritance conflict by explicitly overriding the method
    public void hello() {
        //Explain: Explicitly invoking interface A's default implementation
        A.super.hello();
        //Explain: Explicitly invoking interface B's default implementation
        B.super.hello();
    }
}

public class DefaultConflictDemo {
    public static void main(String[] args) { 
        new Both().hello(); 
    }
}