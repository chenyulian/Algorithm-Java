package src.datastructure.array;

/**
 * An implementation of Array, one of the basic data structure.
 * Array is a container that stores homogeneous size and stored in contiguous memory.
 * See wikipedia of Array for more information.
 * This implementation is capable of resizing itself as elements added in or removed out.
 * It implements basic operation for a data structure, including insert, remove, modify, and find.
 * It supports for almost all kind of classes.
 *
 * @author Chen Yulian
 * @param <E> type of the element to be stored in the list.
 *           No support for primitive types. Use their Wrapper class.
 *           e.g. Use Array<Integer> if you want to store int.
 *
 */
public class Array<E> {

    /**
     * describes how many elements are actually stored in the container.
     */
    private int size;

    /**
     * the container to store data
     */
    private E[] data;

    /**
     * default capacity of container
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The INCREASE_FACTOR is used when the array needs to increase its capacity.
     * When an array is created, its capacity(how many elements can it stores) is fixed.
     * If the array is full, we need to increase its capacity if we want to add more by creating a new array
     * The new array's capacity is INCREASE_FACTOR times larger than the old one.
     */
    private static final int INCREASE_FACTOR = 2;


    /**
     * The DECREASE_FACTOR is used when the array needs to decrease its capacity.
     * As we move the elements out of the list, the capacity may be to large to store a small number of elements.
     * To not to waste the space, we can decrease capacity of the list.
     * The new array's capacity is DECREASE_FACTOR times smaller than the old one.
     */
    private static final float DECREASE_FACTOR = 0.25f;

    /**
     * Constructor of @Array
     * create an Array<E> of given capacity
     * @param capacity how many elements can the container stores
     */
    public Array(int capacity) {
        data = (E[])new Object[capacity];
    }

    /**
     * Constructor of @Array
     * create an @Array of default capacity 10
     */
    @SuppressWarnings("unchecked")
    public Array(){
        data = (E[])new Object[DEFAULT_CAPACITY];
    }

    /**
     * Constructor of Array
     * create an Array class with specified elements.
     * @param arr an array who's elements are to be placed in the list
     */
    public Array(E[] arr) {
        this.data = arr;
        size = arr.length;
    }

    /**
     * get the numbers of elements that the array can store
     * @return capacity of the array
     */
    public int capacity() {
        return data.length;
    }

    /**
     * get the numbers of elements in array
     * @return size of the array.
     */
    public int size() {
        return size;
    }

    /**
     * Check if the list is empty
     * @return true if there's no element in the list
     */
    public boolean isEmpty() {
        return data.length == 0;
    }


    /**
     * Add an element at specific index of the list
     * @param index index at which the specified element to be insert
     * @param element element to be insert
     */
    public void add(int index, E element) {

        if(index < 0) {
            throw new IllegalArgumentException("Add failed. Invalid index.");
        }

        if(index > size) {
            throw new IndexOutOfBoundsException("Add failed. Index out of bounds.");
        }

        if(size == data.length) {
            // increase capacity
            resize(INCREASE_FACTOR * data.length);
        }

        for(int i = size - 1; i >= index; i --) {
            data[i + 1] = data[i];
        }
        data[index] = element;

        size ++;
    }

    /**
     * Add an element at last index of an @Array
     * @param element element to be add to the array
     */
    public void addLast(E element) {
        add(size, element);
    }

    /**
     * Add an element at first index of an @Array
     * @param element element to be add to the array
     */
    public void addFirst(E element) {
        add(0, element);
    }

    /**
     * Get an element at index of @Array
     * @param index index of the element to return
     * @return the element at specific position
     */
    public E get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        return data[index];
    }

    /**
     * Set an element at index of the list
     * @param index index of the element to be set
     * @param element element to be stored at the specific position
     */
    public void set(int index, E element) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        data[index] = element;
    }

    /**
     * Remove an element at index
     * @param index position of the element to be removed
     * @return value of removed element
     */
    public E remove(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }

        E ret = data[index];

        // loop to move elements
        for(int i = index + 1; i < size; i ++) {
            data[i - 1] = data[i];
        }

        size --;
        if(size == data.length * DECREASE_FACTOR && size > 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    /**
     * Remove an element
     * @param element element to be removed. if there is more than one element in the list, remove the first one.
     */
    public void removeElement(E element) {
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
     * @param element element who's persistence to be tested
     * @return true if there exists the specified element in the list
     */
    public boolean contains(E element) {
        for(int i = 0; i < size; i ++) {
            if(data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Find an element or elements, returns its or the first element's index.
     * @param element element to be searched in the list
     * @return the index of element to be found. If not found, return -1.
     */
    public int find(E element) {
        for(int i = 0; i < size; i ++) {
            if(data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array size: %d, capacity: %d \n", size, capacity()));
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

    /**
     * increase or decrease capacity of the list
     * @param newCapacity capacity of new array
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {

        E[] newData = (E[])new Object[newCapacity];

        for(int i = 0; i < size; i ++) {
            newData[i] = data[i];
        }

        data = newData;
    }

}
