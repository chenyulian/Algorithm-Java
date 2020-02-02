package pers.kinp.datastructure.queue;

import pers.kinp.datastructure.array.Array;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;
    /**
     * get size of queue
     *
     * @return size of queue
     */
    @Override
    public int getSize() {
        return array.size();
    }

    /**
     * check if queue is empty
     *
     * @return true if queue is empty
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * get element at front of queue
     * @return element at front of queue
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    /**
     * insert an element at the end of queue
     *
     * @param e element to be added
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * remove the element at the front of queue
     */
    @Override
    public void dequeue() {
        array.removeFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0; i < getSize(); i ++) {
            res.append(array.get(i));
            if(i != getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("]");

        return res.toString();
    }
}
