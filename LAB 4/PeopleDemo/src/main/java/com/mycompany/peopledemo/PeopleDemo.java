/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.peopledemo;

/**
 *
 * @author Windows 10 Pro
 */
class Person {
    //Explain: Protected fields allow subclasses (like Student and Teacher) direct access to inherited properties
    protected String name; 
    protected int age;

    //Explain: Base constructor to initialize the shared name and age properties
    Person(String name, int age) { 
        this.name = name; 
        this.age = age; 
    }

    //Explain: Base method to print the general details (name and age) of a person
    void display() { 
        System.out.println(name + ", age " + age); 
    }
}

//Explain: Student class inherits from Person using the 'extends' keyword (Inheritance)
class Student extends Person {
    private String course;

    //Explain: Constructor uses 'super(...)' to delegate name and age initialization to the parent Person constructor
    Student(String name, int age, String course) { 
        super(name, age); 
        this.course = course; 
    }

    //Explain: Method overriding - reuses the parent's display logic via 'super.display()' and adds course-specific information
    @Override
    void display() { 
        super.display(); 
        System.out.println("Course: " + course); 
    }
}

//Explain: Teacher class also inherits from Person, representing another specialized type of person
class Teacher extends Person {
    private String subject;

    //Explain: Constructor chains to the parent constructor using 'super' and initializes the teaching subject
    Teacher(String name, int age, String subject) { 
        super(name, age); 
        this.subject = subject; 
    }

    //Explain: Overridden display method that leverages Person's output and adds the teacher's subject details
    @Override
    void display() { 
        super.display(); 
        System.out.println("Subject: " + subject); 
    }
}

public class PeopleDemo {
    public static void main(String[] args) {
        //Explain: Create an anonymous Student object and invoke its overridden display method
        new Student("Tariro", 20, "Computing").display();
        
        //Explain: Create an anonymous Teacher object and invoke its overridden display method
        new Teacher("Mr Dube", 40, "Java").display();
    }
}
