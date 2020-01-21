package pers.kinp.problems;

import java.util.Arrays;
import java.util.List;

public class MyLinkedList {

    /**
     * Create a linked list. 创建链表
     * @param data
     * @return Head of the linked list. The return list ends with last node with getNext() == null.
     */
    public Node createLinkedList(List<Integer> data) {
        if(data.isEmpty()) {
            return null;
        }
        Node firstNode = new Node(data.get(0));
        //递归调用方法
        Node headOfSublist = createLinkedList(data.subList(1, data.size()));
        firstNode.setNext(headOfSublist);
        return firstNode;
    }

    public static void main(String args[]) {
        MyLinkedList list = new MyLinkedList();
        //Node.printList(list.createLinkedList(new ArrayList<>()));
        Node.printList(list.createLinkedList(Arrays.asList(1)));
        Node.printList(list.createLinkedList(Arrays.asList(1, 2, 3, 4, 5)));
    }
}
