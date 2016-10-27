package com.daswath.examples.linkedlists;


public class LinkedListIntersector {
    static class ResultNode {
        int size;
        LinkedCollection.Node tail;

        ResultNode(int size, LinkedCollection.Node tail) {
            this.size = size;
            this.tail = tail;
        }
    }

    public static LinkedCollection.Node findIntersectingNode(LinkedCollection.Node list1, LinkedCollection.Node list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        // get tail node and size of both lists
        ResultNode tailOfList1 = getTailAndSize(list1);
        ResultNode tailOfList2 = getTailAndSize(list2);

        // if tail nodes do not reference the same node, then the lists do not intersect
        if (tailOfList1 != tailOfList2) {
            return null;
        }

        // find the longer of the lists, so you can advance head to the difference in size on longer
        LinkedCollection.Node longer = null;
        LinkedCollection.Node shorter = null;
        if (tailOfList1.size > tailOfList2.size) {
            longer = list1;
            shorter = list2;
        } else {
            longer = list2;
            shorter = list1;
        }

        int sizeDiff = Math.abs(tailOfList1.size - tailOfList2.size);
        for (int i = 0; i < sizeDiff; i++) {
            longer = longer.next;
        }

        // now both lists are of same size, find if they point to same node, that becomes the intersecting node
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return shorter;
    }

    private static ResultNode getTailAndSize(LinkedCollection.Node curNode) {
        int ctr = 0;
        while (curNode.next != null) {
            curNode = curNode.next;
            ctr++;
        }
        return new ResultNode(ctr, curNode);
    }


}
