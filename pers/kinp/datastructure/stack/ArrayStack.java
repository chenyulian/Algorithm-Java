package pers.kinp.datastructure.stack;

import pers.kinp.datastructure.array.Array;

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack() {
        array = new Array<E>();
    }

    public ArrayStack(int capacity) {
        array = new Array<E>(capacity);
    }

    /**
     * get size of stack
     */
    @Override
    public int getSize() {
        return array.size();
    }

    /**
     * check if stack is empty
     *
     * @return true if there exists element in stack
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * push an element into stack
     *
     * @param e element to be added
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * pop an element out of stack
     *
     * @return element to be removed
     */
    @Override
    public E pop() {
        E e = array.getLast();
        array.removeLast();
        return e;
    }

    /**
     * get the element at the top of stack, but not remove it from stack
     *
     * @return element at the top
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for(int i = 0; i < getSize(); i ++) {
            res.append(array.get(i));
            if(i != getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        res.append(" top");

        return res.toString();
    }
}
