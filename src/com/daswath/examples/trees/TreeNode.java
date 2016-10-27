package com.daswath.examples.trees;

/**
 * Created by DAswath on 10/26/2016.
 */
public class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
    }
}
