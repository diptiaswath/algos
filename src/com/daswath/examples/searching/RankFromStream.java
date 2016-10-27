package com.daswath.examples.searching;

/**
 * Rank of a number X is the number of values less than or equal to x
 */
public class RankFromStream {
    private static class RankNode {
        int data = 0;
        RankNode left;
        RankNode right;
        RankNode parent;
        int leftSize = 0;

        RankNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private RankNode root = null;

    public void track(int x) {
        root = insert(x, root);
    }

    private RankNode insert(int x, RankNode curNode) {
        RankNode newNode = new RankNode(x);
        newNode.parent = curNode;

        if (curNode == null) {
            curNode = newNode;
        } else if (x < curNode.data) {
            curNode.leftSize++;
            curNode.left = insert(x, curNode.left);
        } else if (x > curNode.data) {
            curNode.right = insert(x, curNode.right);
        }
        return curNode;
    }

    public int getRank(int x) {
        return getRank(x, root);
    }

    private int getRank(int x, RankNode curNode) {
        if (curNode == null) {
            return -1;
        }
        if (curNode.data == x) {
            return curNode.leftSize;
        } else if (x < curNode.data) {
            return getRank(x, curNode.left);
        } else {
            return curNode.leftSize + 1 + getRank(x, curNode.right);
        }
    }


    public static void main(String[] args) {
        RankFromStream rs = new RankFromStream();
        rs.track(5);
        rs.track(10);
        rs.track(15);
        rs.track(20);
        rs.track(13);
        rs.track(25);
        rs.track(23);
        rs.track(24);

        System.out.println(rs.getRank(24));
    }
}
