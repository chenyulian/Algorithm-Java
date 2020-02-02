package pers.kinp.datastructure.queue;

public interface Queue<E> {

    /**
     * get size of queue
     * @return size of queue
     */
    int getSize();

    /**
     * check if queue is empty
     * @return true if queue is empty
     */
    boolean isEmpty();

    /**
     * get element at front of queue
     * @return element at front of queue
     */
    E getFront();

    /**
     * insert an element at the end of queue
     * @param e element to be added
     */
    void enqueue(E e);

    /**
     * remove the element at the front of queue
     */
    void dequeue();


}
