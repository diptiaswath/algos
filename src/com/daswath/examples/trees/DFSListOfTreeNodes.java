package com.daswath.examples.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a Binary search tree, create a linked list of tree nodes at each depth. Each element in the list
 * is a linked list of treenodes at that level.
 */
public class DFSListOfTreeNodes {

    private static void createListOfTreeNodesAtLevel(TreeNode<Integer> root, List<LinkedList<TreeNode<Integer>>> lists, int level) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode<Integer>> list = null;
        if (lists.size() == level) { // level is not in list
            list = new LinkedList<TreeNode<Integer>>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createListOfTreeNodesAtLevel(root.left, lists, level + 1);
        createListOfTreeNodesAtLevel(root.right, lists, level + 1);

    }

    public static List<LinkedList<TreeNode<Integer>>> createListOfTreeNodes(TreeNode<Integer> root) {
        List<LinkedList<TreeNode<Integer>>> lists = new ArrayList<LinkedList<TreeNode<Integer>>>();
        createListOfTreeNodesAtLevel(root, lists, 0);
        return lists;
    }

}
