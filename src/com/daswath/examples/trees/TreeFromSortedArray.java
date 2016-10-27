package com.daswath.examples.trees;

/**
 * PROBLEM : Creating a binary search tree from a sorted array
 */
public class TreeFromSortedArray {

    private static TreeNode<Integer> createRTreeFromArray(int[] a, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (end + start) / 2;
        TreeNode<Integer> newNode = new TreeNode<Integer>(a[mid]);
        newNode.left = createRTreeFromArray(a, start, mid - 1);
        newNode.right = createRTreeFromArray(a, mid + 1, end);
        return newNode;

    }

    public static TreeNode<Integer> createTreeFromArray(int[] a) {
        return createRTreeFromArray(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 7, 8};
        TreeNode<Integer> root = createTreeFromArray(a);
        System.out.println(root.data);
    }
}
