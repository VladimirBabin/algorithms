package com.github.vladimirbabin.graphs;

import java.util.*;

public class WeightedGraph<T> implements Graph<Node<T>> {

    private final Map<Node<T>, List<Edge<T>>> adjacencyList;

    public WeightedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    @Override
    public void addVertex(Node<T> v) {
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new ArrayList<>());
        }
    }

    /**
     * Sets weight as default value for the Edge (1)
     * @param v1 Node
     * @param v2 Node
     */
    @Override
    public void addEdge(Node<T> v1, Node<T> v2) {
        if (adjacencyList.containsKey(v1) && adjacencyList.containsKey(v2)) {
            Edge<T> edgeForV1 = new Edge<>(v2, 1);
            Edge<T> edgeForV2 = new Edge<>(v1, 1);
            adjacencyList.get(v1).add(edgeForV1);
            adjacencyList.get(v2).add(edgeForV2);
        } else {
            throw new IllegalArgumentException("Both vertices must be present to add edge between them");
        }
    }

    public void addEdgeWithWeight(Node<T> v1, Node<T> v2, int weight) {
        if (adjacencyList.containsKey(v1) && adjacencyList.containsKey(v2)) {
            Edge<T> edgeForV1 = new Edge<>(v2, weight);
            Edge<T> edgeForV2 = new Edge<>(v1, weight);
            adjacencyList.get(v1).add(edgeForV1);
            adjacencyList.get(v2).add(edgeForV2);
        } else {
            throw new IllegalArgumentException("Both vertices must be present to add edge between them");
        }
    }

        @Override
    public void removeEdge(Node<T> v1, Node<T> v2) {
        if (adjacencyList.containsKey(v1) && adjacencyList.containsKey(v2)) {
            adjacencyList.get(v1).removeIf(e -> e.getDestination().equals(v2));
            adjacencyList.get(v2).removeIf(e -> e.getDestination().equals(v1));
        }
    }

    @Override
    public List<Node<T>> getNeighbors(Node<T> v) {
        if (!adjacencyList.containsKey(v)) {
            throw new IllegalArgumentException("Vertex " + v + " is not present");
        }
        return adjacencyList.get(v).stream()
                .map(Edge::getDestination)
                .toList();
    }

    @Override
    public void print() {
        System.out.println("Weighted Graph details: ");
        adjacencyList.forEach((key, value) -> System.out.println("\t" + key + " -> " + value));
    }

    public void printDistances() {
        System.out.println("Weighted Graph distances: ");
        adjacencyList.keySet()
                .stream().sorted(Comparator.comparingInt(Node::getDistance))
                .forEach(key -> System.out.println("\t -> " + key + " " + key.getDistance()));
    }

    public void calculateDijkstraShortestPaths(Node<T> v) {
        // initialize distances
        adjacencyList.keySet().forEach(vert -> vert.setDistance(Integer.MAX_VALUE));
        v.setDistance(0);
        Set<Node<T>> settledNodes = new HashSet<>();

        Queue<Node<T>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
        priorityQueue.addAll(adjacencyList.keySet());

        while (!priorityQueue.isEmpty()) {
            Node<T> current = priorityQueue.poll();
            settledNodes.add(current);
            getNeighbors(current).forEach(adj -> relax(current, adj));
        }

    }

    private void relax(Node<T> current, Node<T> adj) {
        int weight = adjacencyList.get(current).stream()
                .filter(e -> e.getDestination().equals(adj))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Illegal state with no edge existing where it should"))
                .getWeight();
        if (adj.getDistance() > current.getDistance() + weight) {
            adj.setDistance(current.getDistance() + weight);
            adj.setParent(current);
        }
    }
}
