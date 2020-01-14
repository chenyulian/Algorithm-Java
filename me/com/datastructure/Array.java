package com.datastructure;

public class Array {

    private int size;

    private int[] data;

    private static final int DEFAULT_CAPACITY = 10;

    private static final int FACTOR = 2;

    /**
     * Constructor of @Array
     * create an @Array of given capacity
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
    }

    /**
     * Constructor of @Array
     * create an @Array of default capacity 10
     */
    public Array() {
        data = new int[DEFAULT_CAPACITY];
    }

    /**
     * Constructor of @Array
     * create a
     * @param arr
     */
    public Array(int[] arr) {
        this.data = arr;
        size = arr.length;
    }


    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }

    /**
     * Returns true if @Array is empty
     * @return
     */
    public boolean isEmpty() {
        return data.length == 0;
    }


    /**
     * Add an element at specific index of the @Array
     * @param index
     * @param element
     * @return
     */
    public void add(int index, int element) {
        if(size == data.length) {
            throw new IllegalArgumentException("Add failed. Array is full.");
        }

        if(index < 0) {
            throw new IllegalArgumentException("Add failed. Invalid index.");
        }

        if(index > size) {
            throw new IndexOutOfBoundsException("Add failed. Index out of bounds.");
        }

        for(int i = size - 1; i >= index; i --) {
            data[i+1] = data[i];
        }
        data[index] = element;

        size ++;
    }

    /**
     * Add an element at last index of an @Array
     * @param element
     */
    public void addLast(int element) {
        add(size, element);
    }

    /**
     * Add an element at first index of an @Array
     * @param element
     */
    public void addFirst(int element) {
        add(0, element);
    }

    /**
     * Get an element at index of @Array
     * @param index
     * @return
     */
    public int get(int index) {
        return data[index];
    }

}
