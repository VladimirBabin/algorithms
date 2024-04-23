package com.github.vladimirbabin.graphs;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public interface Graph<T> {

    void addVertex(T v);

    void addEdge(T v1, T v2);

    void removeEdge(T v1, T v2);

    List<T> getNeighbors(T v);

    default Set<T> searchGraph(SearchContainer<T> container, T v) {
        Set<T> visited = new LinkedHashSet<>();
        container.add(v);
        while (!container.isEmpty()) {
            T current = container.getNextAndRemove();
            if (!visited.contains(current)) {
                visited.add(current);
                getNeighbors(current).forEach(n -> {
                    if (!visited.contains(n)) {
                        container.add(n);
                    }
                });
            }
        }
        container.refresh();
        return visited;
    }

    void print();

}
