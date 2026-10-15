/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.learnerreports;

/**
 *
 * @author Windows 10 Pro
 */
import java.nio.file.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class LearnerReports {

    record Learner(String name, int marks) {

        //Explain: Custom business logic method to determine the grade band based on learner marks.
        String band() {
            if (marks >= 80) {
                return "A";
            }
            if (marks >= 60) {
                return "B";
            }
            return "C";
        }
    }

    public static void main(String[] args) throws IOException {
        //Explain: Read the CSV file, skip the header row, split each line by commas, and map them into Learner objects.
        List<Learner> learners = Files.readAllLines(Path.of("learners.csv")).stream()
                .skip(1)
                .map(line -> line.split(","))
                .map(a -> new Learner(a[0].trim(), Integer.parseInt(a[1].trim())))
                .toList();

        //Explain: Group the learners into a Map where the key is the grade band ("A", "B", "C") and the value is a List of learners in that band.
        Map<String, List<Learner>> groups = learners.stream()
                .collect(Collectors.groupingBy(Learner::band));

        //Explain: Iterate through each band, format the learner data into CSV-like strings, and write each group to its own report file.
        for (String band : List.of("A", "B", "C")) {
            List<String> report = groups.getOrDefault(band, List.of()).stream()
                    .map(l -> l.name() + "," + l.marks())
                    .toList();
            Files.write(Path.of("grade-" + band + ".txt"), report);
        }
    }
}
