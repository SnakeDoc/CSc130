package edu.csus.csc130.impl;

import edu.csus.csc130.Queue;

import java.util.Iterator;

/**
 * Created by FirstName LastName
 * Circular linked list implementation of Queue
 */
public class LinkedListQueue<E> implements Queue<E> {
    public LinkedListQueue() {

    }

    @Override
    public void enqueue(E item) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     * Return a fail-fast iterator, which throw a java.util.ConcurrentModificationException
     * if the client modifies the collection (via enqueue(...) or dequeue()) during iteration.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
