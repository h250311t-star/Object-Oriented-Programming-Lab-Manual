/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentdemo;

/**
 *
 * @author Windows 10 Pro
 */
class Student {
    //Explain: Private fields for name and marks to ensure proper encapsulation and data hiding
    private String name; 
    private int marks;

    //Explain: Constructor that initializes the name and uses the setter method to safely validate the marks
    Student(String name, int marks) { 
        this.name = name; 
        setMarks(marks); 
    }

    //Explain: Setter method with validation logic to ensure marks stay within the valid range of 0 to 100
    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be 0–100");
        }
        this.marks = marks;
    }

    //Explain: Getter method to safely access the private name field from outside the class
    public String getName() { 
        return name; 
    }

    //Explain: Getter method to safely access the private marks field from outside the class
    public int getMarks() { 
        return marks; 
    }

    //Explain: Business logic method to calculate and return a letter grade based on the student's marks
    public char getGrade() {
        if (marks >= 80) return 'A';
        if (marks >= 70) return 'B';
        if (marks >= 50) return 'C';
        return 'F';
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        //Explain: Create a new Student object with a name and valid marks (76, which maps to a 'B')
        Student s = new Student("Tariro", 76);
        
        //Explain: Print the student's name and their calculated grade using getter methods
        System.out.println(s.getName() + ": " + s.getGrade());
    }
}
