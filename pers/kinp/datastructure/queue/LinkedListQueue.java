package pers.kinp.datastructure.queue;

public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node (E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }


        @Override
        public String toString() {
            return e.toString();
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public LinkedListQueue() {
        size = 0;
        head = null;
        tail = null;
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

    /**
     * check if queue is empty
     *
     * @return true if queue is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * get element at front of queue
     *
     * @return element at front of queue
     */
    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new NullPointerException("Queue is empty");
        }
        return head.e;
    }

    /**
     * insert an element at the end of queue
     * 添加到链表的尾部
     * @param e element to be added
     */
    @Override
    public void enqueue(E e) {
        Node node = new Node(e);
        if(size == 0) {
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = tail.next;
        }
        size ++;

    }

    /**
     * remove the element at the front of queue
     * 从链表的头部移除
     */
    @Override
    public void dequeue() {
        if(size == 0) {
            throw new NullPointerException("Cannot dequeue from an empty queue");
        }
        Node curHead = head;
        head = head.next;
        curHead.next = null;
        if(head == null) {
            tail = null;
        }
        size --;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedListQueue size = ");
        res.append(this.size);
        res.append(" : front ");

        Node cur = head;
        while(cur.next != null) {
            res.append(cur.e);
            res.append("->");
            cur = cur.next;
        }

        res.append("NULL");
        res.append(" end");

        return res.toString();
    }



}
