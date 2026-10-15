/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.uniquenames;

/**
 *
 * @author Windows 10 Pro
 */
import java.util.*;

public class UniqueNames {

    public static void main(String[] args) {
        List<String> names = List.of("Tariro", "Rudo", "Tariro", "Kuda");

        //Explain: Passing a collection to a LinkedHashSet removes duplicates while preserving insertion order
        Set<String> unique = new LinkedHashSet<>(names);

        System.out.println(unique);
    }
}
