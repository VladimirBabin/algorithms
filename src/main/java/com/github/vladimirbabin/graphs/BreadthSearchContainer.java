package com.github.vladimirbabin.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthSearchContainer<T> implements SearchContainer<T> {

    private final Queue<T> queue;

    public BreadthSearchContainer() {
        this.queue = new ArrayDeque<>();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void add(T v) {
        queue.add(v);
    }

    @Override
    public T getNextAndRemove() {
        return queue.remove();
    }

    @Override
    public void refresh() {
        queue.clear();
    }
}
