/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.initblocks;

/**
 *
 * @author Windows 10 Pro
 */
public class InitBlocks {
    //Explain: Static initialization block 1 - executes once when the class is first loaded into memory
    static {
        System.out.println("Static block 1"); 
    }
    
    //Explain: Static initialization block 2 - executes immediately after the first static block during class loading
    static {
        System.out.println("Static block 2"); 
    }

    //Explain: Instance initialization block 1 - executes every time a new object is created, right before the constructor
    {
        System.out.println("Instance block 1"); 
    }
    
    //Explain: Instance initialization block 2 - executes right after the first instance block during object creation
    {
        System.out.println("Instance block 2"); 
    }

    //Explain: Constructor - executes last during object creation, right after all instance blocks have run
    InitBlocks() { 
        System.out.println("Constructor"); 
    }

    public static void main(String[] args) {
        //Explain: Create the first instance; triggers static blocks (once per class), then instance blocks, then the constructor
        System.out.println("--- First Object ---");
        new InitBlocks();
        
        //Explain: Create the second instance; static blocks are skipped, but instance blocks and constructor run again
        System.out.println("--- Second Object ---");
        new InitBlocks();
    }
}
