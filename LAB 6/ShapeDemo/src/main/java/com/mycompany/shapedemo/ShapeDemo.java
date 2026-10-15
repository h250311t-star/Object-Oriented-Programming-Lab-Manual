/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.shapedemo;

/**
 *
 * @author Windows 10 Pro
 */
abstract class Shape {
    //Explain: Abstract class cannot be instantiated directly and serves as a template
    abstract double area();
    abstract double perimeter();
}

class Circle extends Shape {
    double r;
    Circle(double r) { this.r = r; }
    
    //Explain: Concrete subclass providing specific implementation for Circle area
    double area() { return Math.PI * r * r; }
    double perimeter() { return 2 * Math.PI * r; }
}

class Rectangle extends Shape {
    double w, h;
    Rectangle(double w, double h) { this.w = w; this.h = h; }
    
    //Explain: Concrete subclass providing specific implementation for Rectangle area
    double area() { return w * h; }
    double perimeter() { return 2 * (w + h); }
}

class Square extends Shape {
    double side;
    Square(double side) { this.side = side; }
    
    double area() { return side * side; }
    double perimeter() { return 4 * side; }
}

public class ShapeDemo {
    public static void main(String[] args) {
        //Explain: Polymorphic array storing different subclasses under the common superclass type
        Shape[] shapes = { new Circle(2), new Rectangle(3, 4), new Square(5) };
        
        //Explain: Dynamic method dispatch calls the correct overridden method for each shape at runtime
        for (Shape s : shapes) {
            System.out.println(s.area() + " " + s.perimeter());
        }
    }
}