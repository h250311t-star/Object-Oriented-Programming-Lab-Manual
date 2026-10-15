/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.textstats;

/**
 *
 * @author Windows 10 Pro
 */
import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class TextStats {

    public static void main(String[] args) throws IOException {
        //Explain: Load all lines from "input.txt" into a List of strings.
        List<String> lines = Files.readAllLines(Path.of("input.txt"));

        //Explain: Use a stream to count total words by trimming each line, splitting by whitespace regex, and summing the lengths.
        long words = lines.stream()
                .mapToLong(s -> s.trim().isEmpty() ? 0 : s.trim().split("\\s+").length)
                .sum();

        //Explain: Use a stream mapping function to sum the character count of every line.
        long chars = lines.stream()
                .mapToLong(String::length)
                .sum();

        System.out.println("Lines: " + lines.size());
        System.out.println("Words: " + words);
        System.out.println("Characters (excluding newline separators): " + chars);
    }
}
