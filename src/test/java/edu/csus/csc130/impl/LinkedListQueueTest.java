package edu.csus.csc130.impl;

import org.junit.*;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class LinkedListQueueTest {
    @Test
    public void testLinkedListQueue() {
        int capacity = 2;
        LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();

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

        assertEquals(3, queue.size());

        for (int i=0; i<a.length; i++) {
            assertEquals(a[i], (int) queue.dequeue());
            size--;
            assertEquals(size, queue.size());
        }

        assertEquals(0, queue.size());
        assertNull(queue.peek());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIterator() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
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