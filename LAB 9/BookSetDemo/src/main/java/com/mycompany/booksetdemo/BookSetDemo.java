/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.booksetdemo;

/**
 *
 * @author Windows 10 Pro
 */
import java.util.*;

class Book {

    String isbn, title;

    Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    //Explain: Overriding equals() using pattern matching for instanceof to compare books based solely on ISBN
    public boolean equals(Object obj) {
        if (!(obj instanceof Book other)) {
            return false;
        }
        return isbn.equals(other.isbn);
    }

    //Explain: Overriding hashCode() to remain consistent with equals() (same ISBN produces the same hash code)
    public int hashCode() {
        return Objects.hash(isbn);
    }
}

public class BookSetDemo {

    public static void main(String[] args) {
        Set<Book> books = new HashSet<>();
        books.add(new Book("123", "Java Basics"));
        //Explain: This second book is treated as a duplicate because its ISBN matches an existing entry in the HashSet
        books.add(new Book("123", "Java Basics - second copy"));

        //Explain: Size is 1 because duplicate elements based on equals/hashCode are rejected by the Set
        System.out.println(books.size()); // 1
    }
}
