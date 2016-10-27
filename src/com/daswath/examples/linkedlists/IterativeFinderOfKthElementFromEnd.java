package com.daswath.examples.linkedlists;

/**
 * Created by DAswath on 10/10/2016.
 */
public class IterativeFinderOfKthElementFromEnd<E> {

    public E getKthToLast(LinkedCollection.Node<E> head, int k) {
        LinkedCollection.Node<E> first = head;
        LinkedCollection.Node<E> second = head;

        if (head == null) {
            return null;
        }

        for (int i = 1; i <=k; i++) {
            second = second.next;
            if (second == null) {
                return null;
            }
        }

        while (second != null) {
            first = first.next;
            second = second.next;
        }

        return first.element;
    }
}
