package pers.kinp.datastructure.stack;

import pers.kinp.datastructure.linkedlist.LinkedList;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }
    /**
     * get size of stack
     */
    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    /**
     * check if stack is empty
     *
     * @return true if there exists element in stack
     */
    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    /**
     * push an element into stack
     *
     * @param e element to be added
     */
    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    /**
     * pop an element out of stack
     *
     * @return element to be removed
     */
    @Override
    public E pop() {
        return linkedList.delFirst();
    }

    /**
     * get the element at the top of stack, but not remove it from stack
     *
     * @return element at the top
     */
    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        res.append("Stack: top ");
        res.append(linkedList);

        return res.toString();
    }
}
