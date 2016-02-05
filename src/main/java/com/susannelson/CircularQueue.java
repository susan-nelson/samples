package com.susannelson;

import org.apache.commons.lang3.NotImplementedException;

import java.util.*;

/**
 * FIFO queue built on fixed size array.
 * It is circular because it reuses positions in the array that were previously deleted.
 */
public class CircularQueue<T> implements Queue<T>{

    private T[] array;
    private int maxsize;
    private int size = 0;
    private int front = 0;
    private int end = 0;

    public CircularQueue(int maxSize) {
        this.array = (T[])new Object[maxSize];
        this.maxsize = maxSize;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean offer(T o) {

        if (size >= maxsize) {
            return false;
        }

        size++;
        array[end] = o;
        //set end to the next index in the array
        //end wraps around to 0 if end index goes beyond the length of the array
        end = (end + 1) % maxsize;

        return true;
    }

    @Override
    public T poll() {

        if (size == 0) {
            return null;
        }

        size--;
        T o = array[front];
        front = front + 1 % maxsize;

        return o;
    }

    @Override
    public T peek() {
        return array[front];
    }

    @Override
    public boolean contains(Object o) {
        throw new NotImplementedException("method contains() is not implemented yet");
    }

    @Override
    public Iterator iterator() {
        return Arrays.asList(array).iterator();
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public T[] toArray(Object[] a) {
        throw new NotImplementedException("method contains() is not implemented yet");
    }

    @Override
    public boolean add(Object o) {
        throw new NotImplementedException("method contains() is not implemented yet");
    }

    @Override
    public boolean remove(Object o) {
        throw new NotImplementedException("method contains() is not implemented yet");
    }

    @Override
    public boolean addAll(Collection c) {
        throw new NotImplementedException("method contains() is not implemented yet");
    }

    @Override
    public void clear() {
        throw new NotImplementedException("method contains() is not implemented yet");
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new NotImplementedException("method contains() is not implemented yet");
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new NotImplementedException("method contains() is not implemented yet");
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new NotImplementedException("method contains() is not implemented yet");
    }

    @Override
    public T remove() {
        throw new NotImplementedException("method contains() is not implemented yet");
    }

    @Override
    public T element() {
        throw new NotImplementedException("method contains() is not implemented yet");
    }
}
