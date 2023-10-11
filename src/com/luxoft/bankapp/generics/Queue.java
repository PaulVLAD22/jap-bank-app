package com.luxoft.bankapp.generics;

import java.util.LinkedList;
import java.util.List;

public class Queue<T> {
    private List<T> queue;

    public Queue() {
        queue = new LinkedList<>();
    }

    public void add(T item) {
        queue.add(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.remove(0);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.get(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
