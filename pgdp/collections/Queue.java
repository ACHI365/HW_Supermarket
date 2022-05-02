package pgdp.collections;

public interface Queue <T> extends DataStructure {
    void enqueue(T e); //adds an object of the generic type to the queue
    T dequeue(); //removes an object of the generic type from the queue
}