package com.daswath.examples.linkedlists;
import java.lang.Integer;

/**
 * Created by DAswath on 10/10/2016.
 */
public class ListPartitioner<E> {

    /*public <Integer> LinkedCollection.Node<Integer> partition(LinkedCollection.Node<Integer> head, Integer pivot) {
        LinkedCollection.Node<Integer> lessListStart = null;
        LinkedCollection.Node<Integer> lessListEnd = null;

        LinkedCollection.Node<Integer> greatListStart = null;
        LinkedCollection.Node<Integer> greatListEnd = null;

        while (head != null) {
            LinkedCollection.Node<Integer> next = head.next;
            Integer val = head.element;
            if (head.element < pivot) {
                if (lessListStart == null) {
                    lessListStart = head;
                    lessListEnd = lessListStart;
                } else {
                    lessListEnd.next = head;
                    lessListEnd = head;
                }
            } else  { // if head.element > pivot
                if (greatListStart == null) {
                    greatListStart = head;
                    greatListEnd = greatListStart;
                } else {
                    greatListEnd.next = head;
                    greatListEnd = head;
                }

            }
            head = next;
        }

        if (lessListStart == null) {
            return greatListStart;
        }

        // merge the 2 lists
        lessListEnd.next = greatListStart;
        return lessListStart;
    }*/
}
