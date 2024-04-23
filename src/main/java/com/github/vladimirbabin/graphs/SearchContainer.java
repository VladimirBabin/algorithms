package com.github.vladimirbabin.graphs;

public interface SearchContainer<T> {
    boolean isEmpty();

    void add(T v);

    T getNextAndRemove();

    void refresh();
}
