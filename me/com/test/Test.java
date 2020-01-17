package com.test;

import com.datastructure.Array;

public class Test {
    public static void main(String[] args) {
        Array array = new Array(20);

        for(int i = 0; i < 10; i ++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(3,300);
        System.out.println(array);

        array.addFirst(999);
        System.out.println(array);

        array.remove(10);
        System.out.println(array);

        array.removeElement(5);
        System.out.println(array);

        array.removeLast();
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);

        System.out.println(array.find(4));
    }
}
