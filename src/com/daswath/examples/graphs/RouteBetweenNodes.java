package com.daswath.examples.graphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by DAswath on 10/26/2016.
 */
public class RouteBetweenNodes {


    // BFS
    public static boolean search(Graph g, Graph.Node start, Graph.Node end) {
        LinkedList<Graph.Node> que = new LinkedList<Graph.Node>();

        for (Graph.Node n : g.getNodes()) {
            n.state = State.UNVISITED;
        }

        que.add(start);
        start.state = State.VISITING;
        while (!que.isEmpty()) {
            Graph.Node u = que.removeFirst();
            if (u == null) {
                return false;
            }

            for (Graph.Node v : u.adjacent) {
                if (v.state == State.UNVISITED) {
                    if (end == v) {
                        return true;
                    } else {
                        v.state = State.VISITING;
                        que.add(v);
                    }
                }
            }

            u.state = State.VISITED;
        }
        return false;
    }
}
