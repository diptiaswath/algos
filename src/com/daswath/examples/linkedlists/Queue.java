package com.daswath.examples.linkedlists;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Queue implemented as a linked list
 */
public class Queue<T> implements Iterable<T> {
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

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = first;
            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T element = null;
                if (hasNext()) {
                    element = current.element;
                    current = current.next;
                }
                return element;
            }
        };
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.add(3);
        queue.add(18);
        queue.add(5);
        queue.add(2);

        Iterator<Integer> it = queue.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(queue.remove());
    }
}
