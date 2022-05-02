package pgdp.collections;

public interface DataStructure {
    int size(); //return the number of stored element
    default boolean isEmpty(){ //checks whether the data structure is empty
        return (size() == 0);
    }
}