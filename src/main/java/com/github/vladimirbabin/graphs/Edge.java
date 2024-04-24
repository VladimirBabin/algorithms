package com.github.vladimirbabin.graphs;

public class Edge<T> {
    private Node<T> destination;
    private int weight;

    public Edge(Node<T> destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public Node<T> getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return destination +
                " : " + weight;
    }
}
