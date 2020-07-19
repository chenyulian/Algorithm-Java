public class LinkedList<E> {

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

    private Node dummyhead;
    private int size;

    public LinkedList() {
        dummyhead = new Node(null,null);
        size = 0;
    }

    /**
     * Get size of linked list.
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Check if list is empty
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Add element e at head
     * @param e
     */
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//        dummyhead = new Node(e, dummyhead);
//        size ++;
        add(0, e);
    }

    /**
     * add element at given index
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, index out of bounds");
        }

        Node prev = dummyhead;
        for(int i = 0; i < index; i ++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);

        size ++;
    }

    public void addLast(E e) {
        this.add(size, e);
    }

    /**
     * Get element at index
     * @param index
     * @return
     */
    public E get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, index out of bounds");
        }

        Node cur = dummyhead.next;
        for(int i = 0; i < index; i ++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * set element at given index
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Invalid index.");
        }

        Node cur = dummyhead.next;
        for(int i = 0; i < index; i ++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * Check if linked list contains given element e
     * @param e element to be checked
     * @return true if linked list contains given element
     */
    public boolean contains(E e) {
        Node cur = dummyhead.next;
        while(cur != null) {
            if(cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * remove element at given index
     * @param index
     * @return
     */
    public E delAtIndex(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Delete failed. Invalid index.");
        }

        Node prev = dummyhead;
        for(int i = 0; i < index; i ++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;

        size --;
        return delNode.e;
    }

    public E delFirst() {
        return delAtIndex(0);
    }

    public E delLast() {
        return delAtIndex(size - 1);
    }

    public void removeElement(E e) {
        Node pre = dummyhead;
        while(pre.next != null) {
           if(e.equals(pre.next.e)) {
               pre.next = pre.next.next;
           }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = dummyhead.next;
        while(cur != null ) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("null");

        return res.toString();
    }
}
