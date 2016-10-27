package com.daswath.examples.linkedlists;

import java.util.AbstractCollection;
import java.util.Iterator;

public class LinkedCollection<E> extends AbstractCollection<E> {
    static class Node<T> {
        T element;
        Node<T> next = null;

        Node(T element) {
            this.element = element;
        }
    }

    private Node<E> first = null;
    private Node<E> last = first;
    private int size = 0;

    public LinkedCollection() {}

    /**
     * Adding an element to the tail of the list
     */
    public boolean add(E element) {
        if (first == null) {
            first = new Node<E>(element);
            last = first;
        } else {
            last.next = new Node<E>(element);
            last = last.next;
        }
        size++;
        return true;
    }

    public LinkedCollection<E> rearrangeWithRunnerTechnique() {
        Node<E> slow = first;
        Node<E> fast = first.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = first;
        slow = slow.next;
        LinkedCollection<E> newCol = new LinkedCollection<E>();
        while (slow.next != null) {
            newCol.add(fast.element);
            fast = fast.next;
            newCol.add(slow.element);
            slow = slow.next;
        }
        newCol.add(fast.element);
        newCol.add(slow.element);
        return newCol;
    }

    /**
     * Deleting from the list (head or tail)
     * @return
     */
    public <E> boolean delete(E element) {
        if (first == null) {
            return false;
        }
        if (element.equals(first.element)) {
            first = first.next;
            return true;
        }
        Node current = first;
        while (current.next != null) {
            if (element.equals(current.next.element)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public Iterator<E> iterator() {
        return new LinkedListIterator<E>(first);
    }

    public Node<E> getFirst() {
        return first;
    }

    public int size() {
        return size;
    }

    private static class LinkedListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public LinkedListIterator(Node<T> first) {
            this.current = first;
        }

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

        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }


    public static void main(String[] args) {
        LinkedCollection<Integer> collection = new LinkedCollection<Integer>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);
        collection.add(6);
        collection.add(7);
        collection.add(8);
        Iterator<Integer> listIt = collection.iterator();
        while (listIt.hasNext()) {
            System.out.print(listIt.next() + "->");
        }
        System.out.println();
       /* collection.delete(4);
        listIt = collection.iterator();
        while (listIt.hasNext()) {
            System.out.print(listIt.next() + "->");
        }*/

        LinkedCollection<Integer> newCol = collection.rearrangeWithRunnerTechnique();
        listIt = newCol.iterator();
        while (listIt.hasNext()) {
            System.out.print(listIt.next() + "->");
        }
    }
}
