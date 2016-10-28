package com.daswath.examples.buildorder;

import java.util.*;

/**
 * Created by DAswath on 10/27/2016.
 */
public class Graph {
    private Map<String, Project> map = new HashMap<String, Project>();

    public Project createNode(String name) {
        if (!map.containsKey(name)) {
            Project node = new Project(name);
            map.put(name, node);
        }
        return map.get(name);
    }

    public void addEdge(String startName, String endName) {
        Project start = createNode(startName);
        Project end = createNode(endName);
        start.addDependents(end);
    }

    public Collection<Project> getProjects() {
        return map.values();
    }
}
