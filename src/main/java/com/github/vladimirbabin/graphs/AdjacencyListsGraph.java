package com.github.vladimirbabin.graphs;

import java.util.*;

public class AdjacencyListsGraph<T> implements Graph<T> {

    private final Map<T, List<T>> adjacencyList;

    public AdjacencyListsGraph() {
        this.adjacencyList = new HashMap<>();
    }

    @Override
    public void addVertex(T v) {
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new ArrayList<>());
        }
    }

    @Override
    public void addEdge(T v1, T v2) {
        if (adjacencyList.containsKey(v1) && adjacencyList.containsKey(v2)) {
            adjacencyList.get(v1).add(v2);
            adjacencyList.get(v2).add(v1);
        } else {
            throw new IllegalArgumentException("Both vertices must be present to add edge between them");
        }
    }

    @Override
    public void removeEdge(T v1, T v2) {
        if (adjacencyList.containsKey(v1) && adjacencyList.containsKey(v2)) {
            adjacencyList.get(v1).remove(v2);
            adjacencyList.get(v2).remove(v1);
        }
    }

    @Override
    public List<T> getNeighbors(T v) {
        if (!adjacencyList.containsKey(v)) {
            throw new IllegalArgumentException("Vertex " + v + " is not present");
        }
        return adjacencyList.get(v);
    }


    @Override
    public void print() {
        System.out.println("Graph details: ");
        for (Map.Entry<T, List<T>> entry : adjacencyList.entrySet()) {
            System.out.println("\t" + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
