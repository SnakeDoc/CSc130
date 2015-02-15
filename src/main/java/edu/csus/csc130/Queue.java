package edu.csus.csc130;

/**
 * Created by ychen on 1/25/2015.
 */
public interface Queue<E> extends Iterable<E> {
    public void enqueue(E item);
    public E dequeue();
    public E peek();
    public boolean isEmpty();
    public int size();
}
