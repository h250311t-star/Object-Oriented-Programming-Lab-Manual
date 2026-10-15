/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.aboveavarage;

/**
 *
 * @author Windows 10 Pro
 */
import java.util.*;

public class AboveAvarage {

    //Explain: Define a Java record to act as a concise, immutable data carrier for student info.
    record Student(String name, int marks) {}

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Tariro", 80),
                new Student("Alice", 90),
                new Student("Brian", 60)
        );

        //Explain: Extract student marks into an IntStream, compute the average, and default to 0 if the stream is empty.
        double average = students.stream()
                .mapToInt(Student::marks)
                .average()
                .orElse(0);

        //Explain: Filter students scoring above average, extract their names, sort them alphabetically, and print each name.
        students.stream()
                .filter(s -> s.marks() > average)
                .map(Student::name)
                .sorted()
                .forEach(System.out::println);

        System.out.println("Average: " + average);
    }
}
