package com.github.vladimirbabin.graphs;

import java.util.*;

public class AdjacencyMatrixGraph implements Graph<Integer> {

    private int numVertices;
    private int[][] matrix;

    public AdjacencyMatrixGraph() {
        this.numVertices = 0;
    }

    @Override
    public void addVertex(Integer v) {
        int newSize = numVertices + 1;

        int[][] newMatrix = new int[newSize][newSize];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }

        matrix = newMatrix;
        numVertices = newSize;
    }

    @Override
    public void addEdge(Integer v1, Integer v2) {
        matrix[v1][v2] = 1;
        matrix[v2][v1] = 1;
    }

    @Override
    public void removeEdge(Integer v1, Integer v2) {
        matrix[v1][v2] = 0;
        matrix[v2][v1] = 0;
    }

    @Override
    public List<Integer> getNeighbors(Integer v) {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (matrix[v][i] == 1) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }

    @Override
    public void print() {
        System.out.println("Graph details: ");
        for (int i = 0; i < numVertices; i++) {
            StringBuilder row = new StringBuilder("\t" + i + " -> [");
            for (int j = 0; j < numVertices; j++) {
                if (matrix[i][j] == 1) {
                    row.append(j).append(", ");
                }
            }
            row.delete(row.length() - 2, row.length());
            System.out.print(row + "]\n");
        }

        System.out.println("\nGraph matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
