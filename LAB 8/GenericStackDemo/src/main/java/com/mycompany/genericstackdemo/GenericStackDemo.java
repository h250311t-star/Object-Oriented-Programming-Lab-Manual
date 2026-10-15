/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.genericstackdemo;

/**
 *
 * @author Windows 10 Pro
 */
import java.util.ArrayList;

//Explain: Creating a generic class with type parameter T to support any data type safely
class Stack<T> {
    private final ArrayList<T> items = new ArrayList<>();
    
    void push(T value) { 
        items.add(value); 
    }
    
    T pop() {
        if (isEmpty()) throw new IllegalStateException("Empty stack");
        //Explain: Removing and returning the top element from the end of the backing list
        return items.remove(items.size() - 1);
    }
    
    T peek() {
        if (isEmpty()) throw new IllegalStateException("Empty stack");
        //Explain: Viewing the top element without removing it
        return items.get(items.size() - 1);
    }
    
    boolean isEmpty() { 
        return items.isEmpty(); 
    }
}

public class GenericStackDemo {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>(); 
        s.push("A"); 
        s.push("B");
        
        System.out.println(s.peek()); 
        System.out.println(s.pop());
    }
}