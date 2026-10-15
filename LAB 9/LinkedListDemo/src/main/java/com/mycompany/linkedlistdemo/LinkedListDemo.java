/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.linkedlistdemo;

/**
 *
 * @author Windows 10 Pro
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

class SimpleLinkedList<T> implements Iterable<T> {

    //Explain: A static nested class representing a single node in the linked list
    private static class Node<T> {

        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head, tail;

    void add(T value) {
        Node<T> n = new Node<>(value);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
    }

    //Explain: Implementing Iterable allows the custom collection to be used in enhanced for-loops
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }
}

public class LinkedListDemo {

    public static void main(String[] args) {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("One");
        list.add("Two");

        //Explain: The enhanced for-loop automatically invokes the iterator() method under the hood
        for (String s : list) {
            System.out.println(s);
        }
    }
}
