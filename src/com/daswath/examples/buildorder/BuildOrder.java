package com.daswath.examples.buildorder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by DAswath on 10/27/2016.
 */
public class BuildOrder {

    public static Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.createNode(project);
        }

        for (int i = 0; i < dependencies.length; i++) {
            graph.addEdge(dependencies[i] [1], dependencies[i] [0]);
        }
        return graph;
    }


    public static Project[] orderProjects(Collection<Project> projects) {
        Project[] projectBuildOrder = new Project[projects.size()];

        int size = addNonDependentProjects(projectBuildOrder, projects, 0);

        int ctr = 0;
        while (ctr < projectBuildOrder.length) {
            Project p = projectBuildOrder[ctr];

            for (Project pChild : p.getDependents()) {
                pChild.decrementDependencies();
            }
            size = addNonDependentProjects(projectBuildOrder, p.getDependents(), size);
            ctr++;
        }
        return projectBuildOrder;
    }

    private static int addNonDependentProjects(Project[] buildOrder, Collection<Project> projects, int index) {
        for (Project p : projects) {
            if (p.getDependencies() == 0) {
                buildOrder[index++] = p;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String[] projects = new String[] {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {
                {"a", "d"},
                {"f", "b"},
                {"b", "d"},
                {"f", "a"},
                {"d", "c"}
        };

        Graph g = buildGraph(projects, dependencies);
       /* for (Project p : g.getProjects()) {
            System.out.println(p.getName());
            System.out.println("it depends on : ");
            for (Project pDepend : p.getDependencies()) {
                System.out.println(pDepend.getName());
            }
            System.out.println("-----");
        }*/

        Project[] ps = orderProjects(g.getProjects());
        for (Project p : ps) {
            System.out.println(p.getName());

        }

    }

}
