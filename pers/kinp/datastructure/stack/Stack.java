package pers.kinp.datastructure.stack;

public interface Stack<E> {

    /**
     * get size of stack
     */
    int getSize();

    /**
     * check if stack is empty
     * @return true if there exists element in stack
     */
    boolean isEmpty();

    /**
     * push an element into stack
     * @param e element to be added
     */
    void push(E e);

    /**
     * pop an element out of stack
     * @return element to be removed
     */
    E pop();

    /**
     * get the element at the top of stack, but not remove it from stack
     * @return element at the top
     */
    E peek();

}
