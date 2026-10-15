/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.removeeven;

/**
 *
 * @author Windows 10 Pro
 */
import java.util.*;
import java.util.function.Predicate;

public class RemoveEven {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8));

        //Explain: Define a Predicate (a functional interface representing a boolean-valued function) to check if a number is even.
        Predicate<Integer> isEven = n -> n % 2 == 0;

        //Explain: Use removeIf to mutate the collection in place, removing all elements that match the given predicate condition.
        nums.removeIf(isEven);

        System.out.println(nums);
    }
}
