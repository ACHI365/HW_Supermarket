package pgdp.collections;

public interface Stack <T> extends DataStructure {
    void push(T e); // adds an object of the generic type to the stack
    T    pop(); // removes an object of the generic type from the stack

}
