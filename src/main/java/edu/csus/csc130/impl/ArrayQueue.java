package edu.csus.csc130.impl;

import edu.csus.csc130.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by FirstName LastName
 * Circular, resizable array Queue implementation
 */
public class ArrayQueue<E> implements Queue<E> {
	
	private Object[] q;
	private int N = 0;
	private int first = 0;
	private int last = 0;
	private int capacity = 0;
	
    /**
     * Create a new Queue with initial array capacity
     */
    public ArrayQueue(final int capacity) {
    	this.capacity = capacity;
    	this.q = new Object[capacity];
    }
    
    private void resize(final int max) {
    	if (max < N) return;
    	Object[] temp = new Object[max];
    	for (int i = 0; i < N; i++) {
    		temp[i] = q[(first + i) % q.length];
    	}
    	q = temp;
    	first = 0;
    	last = N;
    	capacity = max;
    	
    }

    /**
     * Return the array capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Add an item to the end of the queue,
     * when array is full, double the array size
     * to allow addition
     */
    @Override
    public void enqueue(final E item) {
    	if (N == q.length)
    		resize(2 * q.length);
    	q[last++] = item;
    	if (last == q.length)
    		last = 0;
    	N++;
    }

    /**
     * Remove an time from the head of the queue,
     * when array is 1/4 full, reduce the array size
     * to half
     */
    @SuppressWarnings("unchecked")
	@Override
    public E dequeue() {
    	Object obj = q[first];
    	q[first] = null;
    	N--;
    	first++;
    	if (first == q.length) first = 0;
    	if (N > 0 && N == q.length / 4)
    		resize(q.length / 2);
    	return (E) obj;
    }

    @SuppressWarnings("unchecked")
	@Override
    public E peek() {
        return (E) q[first];
    }

    @Override
    public boolean isEmpty() {
    	return N == 0;
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
        return new ArrayIterator();
    }
    
    private class ArrayIterator implements Iterator<E> {
    	private int i = 0;
    	
    	@Override
    	public boolean hasNext() {
    		return i < N;
    	}
    	
    	@Override
    	public void remove() {
    		throw new UnsupportedOperationException();
    	}
    	
    	@SuppressWarnings("unchecked")
		@Override
    	public E next() {
    		if (!hasNext()) {
    			throw new NoSuchElementException();
    		}
    		Object obj = q[(i + first) % q.length];
    		i++;
    		return (E) obj;
    	}
    }
}
