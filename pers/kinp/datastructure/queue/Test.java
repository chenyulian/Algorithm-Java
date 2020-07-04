package pers.kinp.datastructure.queue;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> linkedListQueue = new LinkedListQueue<>();
        System.out.println("is empty: " + linkedListQueue.isEmpty());
        // enqueue test
        for(int i = 0; i < 20; i += 2) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
        }

        System.out.println("front : " + linkedListQueue.getFront());

        // dequeue test
        for(int i = 0; i < 5; i ++) {
            linkedListQueue.dequeue();
            System.out.println(linkedListQueue);
        }

        System.out.println("front : " + linkedListQueue.getFront());

    }
}
