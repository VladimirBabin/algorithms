package com.github.vladimirbabin.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class DepthSearchContainer<T> implements SearchContainer<T> {

    private final Deque<T> stack;

    public DepthSearchContainer() {
        this.stack = new ArrayDeque<>();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void add(T v) {
        stack.push(v);
    }

    @Override
    public T getNextAndRemove() {
        return stack.pop();
    }

    @Override
    public void refresh() {
        stack.clear();
    }
}
