/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.bubblesortdemo;

/**
 *
 * @author Windows 10 Pro
 */
import java.util.Arrays;

public class BubbleSortDemo {

    //Explain: Bounded type parameter ensures T supports comparisons via Comparable
    static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //Explain: Comparing adjacent elements and swapping them if they are out of order
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 2, 4, 1};
        String[] words = {"pear", "apple", "mango"};

        //Explain: The same generic method correctly sorts both Integer and String arrays
        bubbleSort(nums);
        bubbleSort(words);

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(words));
    }
}
