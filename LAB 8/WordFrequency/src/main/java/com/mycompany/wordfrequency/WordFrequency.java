/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.wordfrequency;

/**
 *
 * @author Windows 10 Pro
 */
import java.util.*;

public class WordFrequency {

    public static void main(String[] args) {
        String paragraph = "java is fun and java is useful";
        Map<String, Integer> count = new HashMap<>();

        //Explain: Normalizing text to lowercase and splitting by non-word characters into tokens
        for (String word : paragraph.toLowerCase().split("\\W+")) {
            //Explain: Incrementing frequency or defaulting to 0 if the word is seen for the first time
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        //Explain: Converting map entries to a stream, sorting by frequency in descending order, and printing results
        count.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
