package com.daswath.examples.linkedlists;

import java.util.NoSuchElementException;

/**
 * Queue implemented as a linked list
 */
public class Queue<T> {
    private static class Node<T> {
        T element;
        Node<T> next;

        Node(T element) {
            this.element = element;
            this.next = null;
        }
    }

    private Node<T> first = null;
    private Node<T> last = null;

    // add to end of list
    public void add(T item) {
        Node<T> newNode = new Node<T>(item);
        if (first == null) {
            first = newNode;
            last = first;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    // remove first item from list
    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        T element = first.element;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return element;
    }

}
