package com.daswath.examples.linkedlists;

/**
 * Created by DAswath on 10/4/2016.
 */

import java.util.EmptyStackException;

/**
 * This is a LIFO data structure implemented with a linked list
 */
public class Stack<E> {
    private static class Node<T> {
        T element;
        Node<T> next;

        Node(T element) {
            this.element = element;
            this.next = null;
        }
    }

    private Node<E> top = null;

    public E pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        E element = top.element;
        top = top.next;
        return element;
    }

    public void push(E element) {
        Node<E> newNode = new Node(element);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public E peek() {
        return top.element;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
