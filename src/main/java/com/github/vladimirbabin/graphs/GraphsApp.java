package com.github.vladimirbabin.graphs;

import java.util.Set;

public class GraphsApp {

    public static void main(String[] args) {
        createAndSearchWeightedGraph();
    }

    private static void createAndSearchWeightedGraph() {
        Graph<Node<String>> graph = new AdjacencyListsGraph<>();

        Node<String> vilnius = new Node<>("Vilnius");
        Node<String> kaunas = new Node<>("Kaunas");
        Node<String> panevezys = new Node<>("Panevezys");
        Node<String> klaipeda = new Node<>("Klaipeda");
        Node<String> palanga = new Node<>("Palanga");
        Node<String> siauliai = new Node<>("Siauliai");
        Node<String> riga = new Node<>("Riga");
        Node<String> ukmerge = new Node<>("Ukmerge");

        graph.addVertex(vilnius);
        graph.addVertex(kaunas);
        graph.addVertex(panevezys);
        graph.addVertex(klaipeda);
        graph.addVertex(palanga);
        graph.addVertex(siauliai);
        graph.addVertex(riga);
        graph.addVertex(ukmerge);

        graph.addEdge(vilnius, kaunas);
        graph.addEdge(vilnius, panevezys);
        graph.addEdge(vilnius, ukmerge);
        graph.addEdge(ukmerge, panevezys);
        graph.addEdge(panevezys, siauliai);
        graph.addEdge(vilnius, siauliai);
        graph.addEdge(vilnius, klaipeda);
        graph.addEdge(klaipeda, palanga);
        graph.addEdge(kaunas, palanga);
        graph.addEdge(vilnius, riga);
        graph.addEdge(siauliai, riga);
        graph.addEdge(panevezys, riga);

        graph.print();

        SearchContainer<Node<String>> container = new BreadthSearchContainer<>();

        Set<Node<String>> spanningTree = graph.searchGraph(container, vilnius);

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
