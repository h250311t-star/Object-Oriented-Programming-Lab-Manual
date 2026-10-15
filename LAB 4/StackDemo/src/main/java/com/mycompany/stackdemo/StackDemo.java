/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.stackdemo;

/**
 *
 * @author Windows 10 Pro
 */
import java.util.ArrayList; //Explain: Import ArrayList to act as the underlying data structure for storing stack elements

//Explain: A generic class using type parameter <T> to allow the stack to work with any data type safely
class SimpleStack<T> {
    //Explain: Private final ArrayList to hold the stack elements internally, ensuring encapsulation
    private final ArrayList<T> items = new ArrayList<>();

    //Explain: Method to add a new item to the top of the stack
    void push(T value) { 
        items.add(value); 
    }

    //Explain: Method to remove and return the top item, throwing an exception if the stack is empty (stack underflow protection)
    T pop() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.remove(items.size() - 1);
    }

    //Explain: Helper method to check whether the stack has any elements remaining
    boolean isEmpty() { 
        return items.isEmpty(); 
    }
}

public class StackDemo {
    public static void main(String[] args) {
        //Explain: Instantiate a generic SimpleStack specifically for Integer objects
        SimpleStack<Integer> s = new SimpleStack<>();
        
        //Explain: Push elements 10 and 20 onto the stack (20 becomes the top element following LIFO order)
        s.push(10); 
        s.push(20);
        
        //Explain: Pop the top element from the stack and print it (outputs 20)
        System.out.println(s.pop()); // 20
    }
}
