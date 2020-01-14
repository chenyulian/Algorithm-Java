package com.algorithm.sort;

public class InsertionSort {
    public static void main(String args[]){
        InsertionSort insertionSort = new InsertionSort();
        SortTestHelper test = new com.algorithm.sort.SortTestHelper();
        Integer[] arr = test.generateRandomArray(100000, 1, 3);

        insertionSort.sort(arr);
        //test.printIntArray(arr);
        test.testSort("me.ylchen.InsertionSort", arr);
    }
    public void sort(Comparable[] arr ){
        //从第二个数开始比较，因为第一个数可以看做已经排好的序列
        for(int i = 1; i < arr.length; i ++){
            Comparable temp = arr[i];
            int j;
            for(j = i ; j > 0 && temp.compareTo(arr[j - 1]) < 0; j --) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }


    public void swap(Comparable arr[], int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
