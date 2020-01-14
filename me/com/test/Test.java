package com.test;

import com.datastructure.Array;

public class Test {
    public static void main(String[] args) {
        Array array = new Array();

        array.add(0,1);
        array.addFirst(2);
        array.addLast(6);

        for(int i = 0; i < array.getSize(); i ++) {
            System.out.println(array.get(i));
        }

    }
}
