package edu.csus.csc130.impl;

import edu.csus.csc130.Queue;

import java.util.Iterator;

/**
 * Created by Jason Sipula
 * Circular linked list implementation of Queue
 */
public class LinkedListQueue<E> implements Queue<E> {
	
	private int N;
	private Node first;
	private Node last;
	
	private class Node {
		private E item;
		private Node next;
	}
	
    public LinkedListQueue() {
    	first = new Node();
    	last = null;
    	N = 0;
    }

    @Override
    public void enqueue(E item) {
    	Node oldLast = last;
    	last = new Node();
    	last.item = item;
    	last.next = null;
    	if (isEmpty())
    		first = last;
    	else
    		oldLast.next = last;
    	N++;
    }

    @Override
    public E dequeue() {
		E item = (E) first.item;
		if (first.next == null)
			first = new Node();
		else
			first = first.next;
        N--;
        if (isEmpty()) last = null;
        return item;
    }

    @Override
    public E peek() {
        return first.item;
    }

    @Override
    public boolean isEmpty() {
        return first.item == null;
    }

    @Override
    public int size() {
        return N;
    }

    /**
     * Return a fail-fast iterator, which throw a java.util.ConcurrentModificationException
     * if the client modifies the collection (via enqueue(...) or dequeue()) during iteration.
     */
    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator<E> {
    	private Node current = first;
    	
    	@Override
    	public boolean hasNext() {
    		return current != null;
    	}
    	
    	@Override
    	public void remove() {
    		throw new UnsupportedOperationException();
    	}
    	
    	@SuppressWarnings("unchecked")
		@Override
    	public E next() {
    		Object item = current.item;
    		current = current.next;
    		return (E) item;
    	}
    }
}
