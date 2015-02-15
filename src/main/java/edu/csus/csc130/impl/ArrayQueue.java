package edu.csus.csc130.impl;

import edu.csus.csc130.Queue;

import java.util.Iterator;

/**
 * Created by FirstName LastName
 * Circular, resizable array Queue implementation
 */
public class ArrayQueue<E> implements Queue<E> {
	
	private int capacity;
	private int size;
	private Object[] data;
	
    /**
     * Create a new Queue with initial array capacity
     */
    public ArrayQueue(final int capacity) {
    	this.capacity = capacity;
    	this.data = new Object[capacity];
    	this.size = 0;
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
    	data[size] = item;
    	size++;
    	if (size == capacity) {
    		Object[] data2 = new Object[capacity * 2];
    		capacity *= 2;
    		for (int i = 0; i < size; i++) {
    			data2[i] = data[i];
    			data = data2;
    		}
    	}
    }

    /**
     * Remove an time from the head of the queue,
     * when array is 1/4 full, reduce the array size
     * to half
     */
    @Override
    public E dequeue() {
        @SuppressWarnings("unchecked")
		final E obj = (E)data[0];
        for (int i = 1; i < size; i++) {
        	if (data[i] != null) {
        		data[i - 1] = data[i];
        	} else {
        		data[i] = null;
        	}
        }
        size--;
        if (size > 0 && size < (capacity / 4)) {
        	capacity /= 2;
        	Object[] data2 = new Object[capacity];
        	for (int i = 0; i < size; i++) {
        		data2[i] = data[i];
        		data = data2;
        	}
        }
        return obj;
    }

    @SuppressWarnings("unchecked")
	@Override
    public E peek() {
        return (data[0] != null) ? (E)data[0] : null;
    }

    @Override
    public boolean isEmpty() {
    	return (size > 0) ? false : true;
    }

    @Override
    public int size() {
        return size;
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
