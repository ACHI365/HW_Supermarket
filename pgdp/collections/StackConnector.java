package pgdp.collections;

public class StackConnector<T> implements DataStructureConnector<T> {
    private Stack<T> stack;

    public StackConnector(Stack<T> stack) {
        this.stack = stack;
        if(stack == null) ExceptionUtil.unsupportedOperation("Stack is null");
    }

    @Override
    public boolean hasNextElement() {

        return !stack.isEmpty();
    }

    @Override
    public void addElement(T e) {
        stack.push(e);
    }


    @Override
    public T removeNextElement() {
        if (!hasNextElement()) return null;
        return stack.pop();
    }
}
