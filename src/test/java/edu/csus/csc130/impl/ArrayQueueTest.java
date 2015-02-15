package edu.csus.csc130.impl;

import org.junit.*;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ArrayQueueTest {
    @Test
    public void testArrayQueue() {
        int capacity = 2;
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>(capacity);
        assertEquals(2, queue.getCapacity());
        assertEquals(0, queue.size());
        assertNull(queue.peek());
        assertTrue(queue.isEmpty());

        int[] a = {1, 2 ,3};
        int size = 0;
        for (int i=0; i<a.length; i++) {
            queue.enqueue(a[i]);
            size++;
            assertEquals(size, queue.size());
            assertFalse(queue.isEmpty());
            assertEquals(a[0], (int) queue.peek());
        }

        assertEquals(4, queue.getCapacity());

        assertEquals(3, queue.size());

        for (int i=0; i<a.length; i++) {
            assertEquals(a[i], (int) queue.dequeue());
            size--;
            assertEquals(size, queue.size());
        }

        assertEquals(2, queue.getCapacity());
        assertEquals(0, queue.size());
        assertNull(queue.peek());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIterator() {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>(5);
        int[] a = {1, 2 ,3};
        int size = 0;
        for (int i=0; i<a.length; i++) {
            queue.enqueue(a[i]);
        }

        Iterator<Integer> iterator = queue.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(a[i], (int) iterator.next());
            i++;
        }
        assertEquals(i, a.length);
    }

}