package pers.kinp.datastructure.linkedlist;

public class Test {


    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 5; i ++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 145);
        linkedList.delAtIndex(2);
        System.out.println(linkedList);
        linkedList.delFirst();
        System.out.println(linkedList);
        linkedList.delLast();
        System.out.println(linkedList);

    }
}
