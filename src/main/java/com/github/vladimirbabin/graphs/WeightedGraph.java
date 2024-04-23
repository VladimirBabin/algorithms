package com.github.vladimirbabin.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<T> implements Graph<Node<T>> {

    private final Map<Node<T>, List<Node<T>>> adjacencyList;

    public WeightedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    @Override
    public void addVertex(Node<T> v) {
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new ArrayList<>());
        }
    }

    @Override
    public void addEdge(Node<T> v1, Node<T> v2) {
        if (adjacencyList.containsKey(v1) && adjacencyList.containsKey(v2)) {
            adjacencyList.get(v1).add(v2);
            adjacencyList.get(v2).add(v1);
        } else {
            throw new IllegalArgumentException("Both vertices must be present to add edge between them");
        }
    }

    @Override
    public void removeEdge(Node<T> v1, Node<T> v2) {
        if (adjacencyList.containsKey(v1) && adjacencyList.containsKey(v2)) {
            adjacencyList.get(v1).remove(v2);
            adjacencyList.get(v2).remove(v1);
        }
    }

    @Override
    public List<Node<T>> getNeighbors(Node<T> v) {
        if (!adjacencyList.containsKey(v)) {
            throw new IllegalArgumentException("Vertex " + v + " is not present");
        }
        return adjacencyList.get(v);
    }

    @Override
    public void print() {
        System.out.println("Graph details: ");
        for (Map.Entry<Node<T>, List<Node<T>>> entry : adjacencyList.entrySet()) {
            System.out.println("\t" + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
