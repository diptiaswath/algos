package com.daswath.examples.linkedlists;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by DAswath on 10/10/2016.
 */
public class DuplicateEliminator<E> {


    /**
     * Removes all duplicates from a list in O(n) time with the use of a buffer node previous
     * Another question may be to not use a buffer - need two loops so O(n^2) solution
     * @param curNode
     * @param <E>
     * @return
     */
    public <E> boolean removeDuplicates(LinkedCollection.Node<E> curNode) {
        if (curNode == null) {
            return false;
        }

        Set<E> seen = new HashSet<E>();
        LinkedCollection.Node<E> previous = null;
        while (curNode != null) {
            if (seen.contains(curNode.element)) {
                previous.next = curNode.next;
            } else {
                seen.add(curNode.element);
                previous = curNode;
            }
            curNode = curNode.next;
        }
        return true;
    }


    public static void main(String[] args) {
        LinkedCollection<Integer> collection = new LinkedCollection<Integer>();
        collection.add(12);
        collection.add(10);
        collection.add(13);
        collection.add(10);
        collection.add(9);
        collection.add(10);

        DuplicateEliminator<Integer> elim = new DuplicateEliminator<Integer>();
        elim.removeDuplicates(collection.getFirst());

        Iterator<Integer> it = collection.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
