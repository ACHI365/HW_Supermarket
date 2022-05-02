package pgdp.collections;

public interface DataStructureConnector<T> {
    boolean hasNextElement(); // returns whether the data structure still contains elements
    void addElement(T e); // adds an element
    T removeNextElement(); // takes the next element
}
