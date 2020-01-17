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
            data[i + 1] = data[i];
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
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        return data[index];
    }

    /**
     * Set an element at index of @Array
     * @param index
     * @param element
     */
    public void set(int index, int element) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Set failed. Illegal index.");
        data[index] = element;
    }

    /**
     * Remove an element at index
     * @param index
     * @return value of removed element
     */
    public int remove(int index) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");

        int ret = data[index];

        // loop to move elements
        for(int i = index + 1; i < size; i ++) {
            data[i - 1] = data[i];
        }

        size --;
        return ret;
    }

    /**
     * Remove an element
     * @param element
     */
    public void removeElement(int element) {
        int index = find(element);

        if(index < 0) {
            throw new IllegalArgumentException("Remove failed. No such element in Array.");
        }else {
            remove(index);
        }
    }

    /**
     * Remove the first element
     */
    public void removeFirst() {
        remove(0);
    }

    /**
     * Remove the last element
     */
    public void removeLast() {
        remove(size - 1);
    }

    /**
     * Find an element, returns true if it exists in @Array
     * @param element
     * @return
     */
    public boolean contains(int element) {
        for(int i = 0; i < size; i ++) {
            if(data[i] == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * Find an element or elements, returns its or the first element's index.
     * @param element
     * @return
     */
    public int find(int element) {
        for(int i = 0; i < size; i ++) {
            if(data[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public int findAll(int element) {
        return -1;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array size: %d, capacity: %d \n", size, getCapacity()));
        res.append("[");
        if(size > 0) {
            for(int i = 0; i < size; i ++) {
                res.append(data[i]);
                if(i < size - 1) {
                    res.append(", ");
                }
            }
        }
        res.append("] \n");

        return res.toString();
    }


}
