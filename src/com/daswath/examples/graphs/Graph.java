package com.daswath.examples.graphs;

import com.daswath.examples.stringmanipulation.PalindromeChecker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DAswath on 10/26/2016.
 */
public class Graph {
    private Node[] nodes;

    static class Node {
        String name;
        State state;
        List<Node> adjacent;

        public Node() {
            adjacent = new ArrayList<Node>();
        }
    }

    public Node[] getNodes() {
        return nodes;
    }
}
