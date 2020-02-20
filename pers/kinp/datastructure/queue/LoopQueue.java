package pers.kinp.datastructure.queue;

import java.util.Objects;

public class LoopQueue<E> implements Queue<E>{

    private E[] array;
    private int head;
    private int tail;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public LoopQueue() {
        array = (E[])new Object[DEFAULT_CAPACITY + 1];
        head = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(int capacity) {
        array = (E[])new Object[capacity + 1];
        head = 0;
        tail = 0;
        size = 0;
    }

    /**
     * get size of queue
     *
     * @return size of queue
     */
    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return array.length - 1;
    }
    /**
     * check if queue is empty
     *
     * @return true if queue is empty
     */
    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * get element at front of queue
     *
     * @return element at front of queue
     */
    @Override
    public E getFront() {
        if(size > 0) {
            return array[head];
        }else{
            throw new NullPointerException("No element in queue.");
        }
    }

    /**
     * insert an element at the end of queue
     *
     * @param e element to be added
     */
    @Override
    public void enqueue(E e) {
        if(getCapacity() == size) {
            resize(getCapacity() * 2);
        }
        array[tail] = e;
        tail = (tail + 1) % array.length;
        size ++;
    }

    /**
     * remove the element at the front of queue
     */
    @Override
    public void dequeue() {
        if(size <= getCapacity() / 4 && getCapacity() / 2 > 0) {
            resize(getCapacity() / 2);
        }
        array[head] = null;
        head = (head + 1) % array.length;
        size --;
    }

    private void resize(int newCapacity) {
        E[] newArray = (E[])new Object[newCapacity + 1];
        // move elements
        for(int i = 0; i < size; i ++) {
            newArray[i] = array[(head + i) % array.length];
        }
        array = newArray;
        head = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Loop Queue: size:"+size+" capacity:" +getCapacity());
        sb.append(" front [");
        for(int i = head; i != tail; i = (i + 1) % array.length) {
            if(i != tail - 1) {
                sb.append(array[i] + ", ");
            }else{
                sb.append(array[i]);
            }
        }

        sb.append("] tail");

        return sb.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>(10);
        for(int i = 0; i < 30; i ++) {
            if(i % 3 != 1) {
                loopQueue.enqueue(i);
            }else{
                loopQueue.dequeue();
            }
            System.out.println(loopQueue);
        }
    }
}
