/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentsortdemo;

/**
 *
 * @author Windows 10 Pro
 */
import java.util.*;

//Explain: Implementing Comparable to define the class's natural ordering
class Student implements Comparable<Student> {
    String name;
    int marks;
    
    Student(String name, int marks) { 
        this.name = name; 
        this.marks = marks; 
    }
    
    //Explain: Natural sorting logic based alphabetically on the student's name
    public int compareTo(Student other) { 
        return name.compareTo(other.name); 
    }
    
    public String toString() { 
        return name + ":" + marks; 
    }
}

public class StudentSortDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(
            new Student("Tariro", 70), 
            new Student("Alice", 90), 
            new Student("Brian", 80)
        ));
        
        //Explain: Collections.sort uses the natural ordering defined by Comparable (by name)
        Collections.sort(list); 
        System.out.println("By name: " + list);
        
        //Explain: Using a lambda-based Comparator to override natural ordering and sort by marks instead
        list.sort(Comparator.comparingInt(s -> s.marks));
        System.out.println("By marks: " + list);
    }
}
