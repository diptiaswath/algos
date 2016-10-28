package com.daswath.examples.buildorder;

import java.util.*;

/**
 * Each project keeps track if its incoming edges, that are its dependencies
 * so for (A->B) project Bs dependency is A. A needs to
 */
public class Project {
    private Set<Project> dependents = new HashSet<Project>();
    private String name;
    private int dependencies = 0;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addDependents(Project node) {
        dependents.add(node);
        node.incrementDependencies();

    }

    public Set<Project> getDependents() {
        return dependents;
    }

    public void incrementDependencies() {
        dependencies++;
    }

    public void decrementDependencies() {
        dependencies--;
    }

    public int getDependencies() {
        return dependencies;
    }
}
