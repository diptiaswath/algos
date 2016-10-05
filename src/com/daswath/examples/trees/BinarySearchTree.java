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

    public Node<E> lookUp(E target) {
        return lookUp(target, root);
    }

    public Node<E> findMin() {
        return findMin(root);
    }

    private Node<E> findMin(Node<E> curNode) {
        while (curNode.left != null) {
            curNode = curNode.left;
        }
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


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(8);
        bst.insert(4);
        bst.insert(2);
        bst.insert(12);
        bst.insert(10);
        bst.insert(20);

        //bst.preOrderTraversal(bst.getRootOfTree());

        Node<Integer> node = bst.lookUp(12);
        System.out.println(node.element);
        System.out.println(node.left.element);
        System.out.println(node.right.element);

        System.out.println(bst.findMin().element);
    }


}
