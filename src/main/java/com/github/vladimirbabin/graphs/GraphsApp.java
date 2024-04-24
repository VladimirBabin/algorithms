package com.github.vladimirbabin.graphs;

import java.util.Set;

public class GraphsApp {

    public static void main(String[] args) {
        createAndSearchWeightedGraph();
    }

    private static void createAndSearchWeightedGraph() {
        WeightedGraph<String> graph = new WeightedGraph<>();

        Node<String> paris = new Node<>("Paris");
        Node<String> riga = new Node<>("Riga");
        Node<String> stockholm = new Node<>("Stockholm");
        Node<String> athens = new Node<>("Athens");
        Node<String> rome = new Node<>("Rome");
        Node<String> bern = new Node<>("Bern");
        Node<String> berlin = new Node<>("Berlin");
        Node<String> madrid = new Node<>("Madrid");

        graph.addVertex(paris);
        graph.addVertex(berlin);
        graph.addVertex(stockholm);
        graph.addVertex(athens);
        graph.addVertex(rome);
        graph.addVertex(bern);
        graph.addVertex(riga);
        graph.addVertex(madrid);

        graph.addEdgeWithWeight(paris, berlin, 4);
        graph.addEdgeWithWeight(paris, stockholm, 17);
        graph.addEdgeWithWeight(paris, madrid, 3);
        graph.addEdgeWithWeight(madrid, stockholm, 21);
        graph.addEdgeWithWeight(stockholm, bern, 8);
        graph.addEdgeWithWeight(paris, bern, 4);
        graph.addEdgeWithWeight(bern, rome, 3);
        graph.addEdgeWithWeight(paris, athens, 10);
        graph.addEdgeWithWeight(athens, rome, 7);
        graph.addEdgeWithWeight(berlin, rome, 4);
        graph.addEdgeWithWeight(bern, berlin, 1);
        graph.addEdgeWithWeight(bern, madrid, 13);
        graph.addEdgeWithWeight(stockholm, berlin, 4);
        graph.addEdgeWithWeight(paris, riga, 8);
        graph.addEdgeWithWeight(stockholm, riga, 2);

        graph.print();

        System.out.println("Before Dijkstra");
        graph.printDistances();
        graph.calculateDijkstraShortestPaths(bern);
        System.out.println("After Dijkstra");
        graph.printDistances();



        SearchContainer<Node<String>> container = new BreadthSearchContainer<>();

        Set<Node<String>> spanningTree = graph.searchGraph(container, paris);

        System.out.println("\n" + "Search result: " + spanningTree);
    }

    private static void createAndSearchSimpleGraph() {
        Graph<Integer> graph = new AdjacencyMatrixGraph();

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addVertex(8);

        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(0, 7);
        graph.addEdge(0, 8);
        graph.addEdge(7, 4);
        graph.addEdge(8, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 1);
        graph.addEdge(3, 1);

        graph.print();

        SearchContainer<Integer> container = new BreadthSearchContainer<>();

        Set<Integer> spanningTree = graph.searchGraph(container, 0);

        System.out.println("\n" + "Search result: " + spanningTree);
    }

}
