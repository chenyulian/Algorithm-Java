public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    /**
     * get size of queue
     *
     * @return size of queue
     */
    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    /**
     * check if queue is empty
     *
     * @return true if queue is empty
     */
    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    /**
     * get element at front of queue
     *
     * @return element at front of queue
     */
    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    /**
     * insert an element at the end of queue
     *
     * @param e element to be added
     */
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    /**
     * remove the element at the front of queue
     */
    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }
}
