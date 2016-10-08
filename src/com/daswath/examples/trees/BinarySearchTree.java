package com.daswath.examples.trees;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
    // void remove( x )       --> Remove x
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// int depthTree()        --> Prints depth of tree
// boolean hasPathForSum() --> returns true if there is a path from root of node to leaf, whos sum equals provided target
// isBST()                  -->
// inOrderSuccessor(Node curNode)
// isBalancedTree()
// lookUp(E element)
    // printAllPaths()
public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<T extends Comparable<T>> {
        T element;
        Node<T> left;
        Node<T> right;

        Node(T element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }

    private Node<E> root = null;

    public void insert(E x) {
       root = insert(x, root);
    }

    public Node<E> getRootOfTree() {
        return root;
    }

    public void inOrderTraversal(Node<E> curNode) {
        if (curNode == null) {
            return;
        }
        inOrderTraversal(curNode.left);
        System.out.println(curNode.element);
        inOrderTraversal(curNode.right);
    }

    public void preOrderTraversal(Node<E> curNode) {
        if (curNode == null) {
            return;
        }
        System.out.println(curNode.element);
        preOrderTraversal(curNode.left);
        preOrderTraversal(curNode.right);
    }

    public int depthOfTree() {
        return depthOfTree(getRootOfTree());
    }

    public Node<E> lookUp(E target) {
        return lookUp(target, root);
    }

    public Node<E> findMin() {
        return findMin(root);
    }



    private E findMaxValueOnLeft(Node<E> curNode) {
        E max = curNode.element;
        Node<E> maxNode = curNode;
        while (curNode.left != null) {
            if (curNode.element.compareTo(max) > 0) {
                max = curNode.element;
                maxNode = curNode;
            }
            curNode = curNode.left;
        }
        return maxNode.element;
    }

    private E findMinValueOnRight(Node<E> curNode) {
        E min = curNode.element;
        Node<E> minNode = curNode;
        while (curNode.right != null) {
            if (curNode.element.compareTo(min) < 0) {
                min = curNode.element;
                minNode = curNode;
            }
            curNode = curNode.right;
        }
        return minNode.element;
    }

    /**
     * Condition : all left nodes must be less than or equal to current node
     *             all right nodes must be greater than or equal to current node
     *             then BST
     *
     * Each node has to be traversed once atleast so the runtime for validating if
     * tree is a binary search tree will always be O(n)
     *
     * But in this, its slow because each node maybe traversed more than one time.
     *
     * @param curNode
     * @return
     */
    public boolean isBSTSolution1(Node<E> curNode) {
        if (curNode == null) {
            return true;
        }

        System.out.println("BST Sol1 " + curNode.element);
        // false if the max on the left is > than current node
        if (curNode.left != null && findMaxValueOnLeft(curNode.left).compareTo(curNode.element) > 0) {
            return false;
        }

        // false if the min of the right is <= than current node
        if (curNode.right != null && findMinValueOnRight(curNode.right).compareTo(curNode.element) <= 0)
            return(false);

        // false if, recursively, the left or right is not a BST
        if( !isBSTSolution1(curNode.left) || !isBSTSolution1(curNode.right)) {
            return false;
        }

        return true;
    }

    // O(n) runtime and O(log n) space, and each node is traversed once
    public boolean isBSTBetterSolution(Node<E> curNode) {
        return isBSTBetterSolution(curNode, null, null);
    }

    private boolean isBSTBetterSolution(Node<E> curNode, E min, E max) {
        if (curNode == null) {
            return true;
        }
        System.out.println("curNode = " + curNode.element + ", max = " + max + " , min = " + min);
        if ((min != null && curNode.element.compareTo(min) <= 0) || (max != null && curNode.element.compareTo(max) > 0)) {
            return false;
        }
        if (!isBSTBetterSolution(curNode.left, min, curNode.element) || !isBSTBetterSolution(curNode.right, curNode.element, max)) {
            return false;
        }
        return true;
    }

    private int checkHeight(Node<E> curNode) {
        if (curNode == null) {
            return 0;
        }
        int lDepth = checkHeight(curNode.left);
        int rDepth = checkHeight(curNode.right);

        int diff = Math.abs(lDepth - rDepth);
        System.out.println("diff = " + diff);

        if (diff > 1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(lDepth, rDepth) + 1;

    }
    // check if a tree is balanced
    // strategy: check if the heights of the 2 subtrees of any node
    // never differ by more than one
    public boolean isBalancedTree(Node<E> curNode) {
        return checkHeight(curNode) != Integer.MIN_VALUE;
    }
     /**
     * /**
     * Given a tree and a sum, return true if there is a path from the root
     * down to a leaf, such that adding up all the values along the path
     * equals the given sum.
     * Strategy: subtract the node value from the sum when recurring down,
     * and check to see if the sum is 0 when you run out of tree.
     */
     public boolean hasPathWithSum(Node<Integer> curNode, int sum) {
        if (curNode == null) {
            return (sum == 0);
        }
        sum = sum - curNode.element;
        return (hasPathWithSum(curNode.left, sum) || hasPathWithSum(curNode.right, sum));
     }

    private Node<E> findMin(Node<E> curNode) {
        while (curNode.left != null) {
            curNode = curNode.left;
        }
        System.out.println("min = " + curNode.element);
        return curNode;
    }

    private Node<E> findMax(Node<E> curNode) {
        while (curNode.right != null) {
            curNode = curNode.right;
        }
        System.out.println("max = " + curNode.element);
        return curNode;
    }

    private Node<E> lookUp(E target, Node<E> curNode) {
        if (curNode == null) {
            throw new NoSuchElementException();
        }
        if (target.compareTo(curNode.element) < 0) {
            return lookUp(target, curNode.left);
        } else if (target.compareTo(curNode.element) > 0) {
            return lookUp(target, curNode.right);
        } else {
            return curNode;
        }
    }

    private Node<E> insert(E x, Node<E> curNode) {
        Node<E> newNode = new Node(x);
        if (curNode == null) {
            curNode = newNode;
        } else if (x.compareTo(curNode.element) < 0) {
            curNode.left = insert(x, curNode.left);
        } else if (x.compareTo(curNode.element) > 0) {
            curNode.right = insert(x, curNode.right);
        }
        // same value, hence duplicate do nothing
        return curNode;
    }

    private int depthOfTree(Node<E> curNode) {
        if (curNode == null) {
            return 0;
        }
        int lTreeDepth = depthOfTree(curNode.left);
        int rTreeDepth = depthOfTree(curNode.right);
        return Math.max(lTreeDepth, rTreeDepth) + 1;
    }

    /**
     * Find in-order successor of a give node in a BST tree
     * @param curNode
     * @return
     */
    public Node<E> inOrderSuccessor(Node<E> curNode) {
        // left -> cur -> right
        // traverse right subtree of curNode. in that traverse to hit leftmost node
        if (curNode.right != null) {
            return findLeftNode(curNode.right);
        } else { // no right subtree, back up to parent,
            // and find a node whose subtree has not been traversed yet.
            // happens when you move from left to parent
            Node<E> n = curNode;
            Node<E> q = getParent(n, getRootOfTree());
            while (q != null && q.left != null) {
                n = q;
                q = getParent(q, getRootOfTree());
            }
            return q;
        }
    }

    private Node<E> findLeftNode(Node<E> cur) {
        if (cur == null) {
            return null;
        }
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    private Node<E> getParent(Node<E> curNode, Node<E> rootNode) {
        if (rootNode == null) {
            return null;
        }
        if (rootNode.left == curNode || rootNode.right == curNode) {
            return rootNode;
        }
        Node<E> l = getParent(curNode, rootNode.left);
        Node<E> r = getParent(curNode, rootNode.right);

        return l != null ? l : r;
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(8);
        bst.insert(4);
        bst.insert(2);
        bst.insert(6);
        bst.insert(10);
        bst.insert(20);

        bst.inOrderTraversal(bst.getRootOfTree());

        /*Node<Integer> node = bst.lookUp(12);
        System.out.println(node.element);
        System.out.println(node.left.element);
        System.out.println(node.right.element);

        System.out.println(bst.findMin().element);*/
        System.out.println(bst.isBSTSolution1(bst.getRootOfTree()));
        System.out.println(bst.isBSTBetterSolution(bst.getRootOfTree()));
        System.out.println(bst.isBalancedTree(bst.getRootOfTree()));


    }


}
