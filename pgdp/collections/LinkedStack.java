package pgdp.collections;

public class LinkedStack<T> implements Stack<T> {
    private List<T> list;

    // initialize value
    public LinkedStack() {
        list = null;
    }

    @Override
    // using list class's function to find length
    public int size() {
        if (list == null) return 0;
        return list.length();
    }

    @Override
    public void push(T e) {
        //using list class's constructor to add element to stack
        list = new List<T>(e, list);
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;

        //save value in a variable
        T result = list.getInfo();
        //change the value of current element
        list = list.getNext();
        return result;
    }

    @Override
    public String toString() {
        return "" + list ;
    }
}
