package pgdp.collections;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedQueue<T> implements Queue<T> {
    private List<T> head;
    private List<T> tail;

    public LinkedQueue() {
        head = tail = null;
    }

    @Override
    // using list class's function to find length
    public int size() {
        if (head == null ) return 0;
        return head.length();
    }

    @Override
    public void enqueue(T e) {
        //using list class's constructor to add element to queue
        if (head == null) head = tail = new List<>(e);
        else{
            // if we have a element already, insert next element
            tail.insert(e);
            tail = tail.getNext();
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) return null;

        //save value in a variable
        T result = head.getInfo();
        //change the value of current element
        if (head == tail) tail = null;
        head = head.getNext();
        return result;
    }

    @Override
    public String toString() {
        return "LinkedQueue{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}