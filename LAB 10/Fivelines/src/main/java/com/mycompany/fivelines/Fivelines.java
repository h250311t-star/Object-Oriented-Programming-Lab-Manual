/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.fivelines;

/**
 *
 * @author Windows 10 Pro
 */
import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class Fivelines {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<String> lines = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            System.out.print("Line " + i + ": ");
            lines.add(sc.nextLine());
        }

        //Explain: Create a Path object pointing to the file "lines.txt" in the current directory using modern NIO.2 API.
        Path file = Path.of("lines.txt");

        //Explain: Write the entire list of strings to the file in a single operation. This automatically handles opening, writing, and closing.
        Files.write(file, lines);

        //Explain: Read all lines from the file into memory as a List<String> and iterate through them to print each one.
        for (String line : Files.readAllLines(file)) {
            System.out.println(line);
        }
    }
}
