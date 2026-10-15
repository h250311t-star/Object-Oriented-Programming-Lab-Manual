/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.listnumbers;

/**
 *
 * @author Windows 10 Pro
 */
import java.util.*;

public class ListNumbers {

    public static void main(String[] args) {
        //Explain: Initializing an ArrayList with a convenient list factory method
        ArrayList<Integer> nums = new ArrayList<>(List.of(4, 7, 2, 9, 1, 5, 8, 3, 6, 10));

        int sum = 0, max = nums.get(0);

        //Explain: Iterating through the list to accumulate the sum and track the highest value
        for (int n : nums) {
            sum += n;
            if (n > max) {
                max = n;
            }
        }

        System.out.println("Sum: " + sum + ", max: " + max);

        //Explain: Using Collections utility to reverse the elements in-place
        Collections.reverse(nums);
        System.out.println(nums);
    }
}
