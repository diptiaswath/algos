package com.daswath.examples.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.Pack200;

/**
 * Created by DAswath on 10/27/2016.
 */
public class BFSListOfTreeNodes {

    public static List<LinkedList<TreeNode<Integer>>> createBFSListOfTreeNodes(TreeNode<Integer> root) {
        List<LinkedList<TreeNode<Integer>>> lists = new ArrayList<LinkedList<TreeNode<Integer>>>();

        LinkedList<TreeNode<Integer>> current = new LinkedList<TreeNode<Integer>>();
        if (root != null) {
            current.add(root);
        }
        while (!current.isEmpty()) {
            lists.add(current);
            LinkedList<TreeNode<Integer>> parent = current;
            current = new LinkedList<TreeNode<Integer>>();
            for (TreeNode<Integer> p : parent) {
                if (p.left != null) {
                    current.add(p.left);
                }
                if (p.right != null) {
                    current.add(p.right);
                }
            }
        }
        return lists;
    }
}
