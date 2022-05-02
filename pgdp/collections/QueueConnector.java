package pgdp.collections;

public class QueueConnector<T> implements DataStructureConnector<T> {
    private Queue<T> queue;

    public QueueConnector(Queue<T> queue) {
        this.queue = queue;
        if (queue == null) ExceptionUtil.unsupportedOperation("Queue is null");
    }

    @Override
    public boolean hasNextElement() {
        return !queue.isEmpty();
    }

    @Override
    public void addElement(T e) {
        queue.enqueue(e);
    }

    @Override
    public T removeNextElement() {
        if (!hasNextElement()) return null;
        return queue.dequeue();
    }

}
