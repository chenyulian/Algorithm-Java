package com.algorithm.sort;

import com.test.Student;

public class SelectionSort {
    public static void main(String args[]) {
        SortTestHelper test = new SortTestHelper();
        int n = 10000;
        Student stu1 = new Student("Jack", 89);
        Student stu2 = new Student("Mary", 91);
        Student stu3 = new Student("Paul", 79);
        Student[] arr1 = {stu1, stu2, stu3};
        Integer[] arr = test.generateRandomArray(100, 1, 100);
        SelectionSort.sort(arr);

        //test.printArray(arr);
        for(int i = 0; i < arr.length; i ++){
            System.out.print(arr[i] +" ");
        }
        //System.out.print("\n" + "运行时间："+ (endTime - startTime) + "ms");
    }

    public static void sort(Comparable[] arr) {
        //从第一个数开始，遍历序列，找出这个序列中的最小值并与第一个数交换
        for(int i = 0; i < arr.length; i ++) {
            //用来找[i, size)区间中的最小值的索引
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j ++){
                if(arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(i, minIndex, arr);
        }
    }

    public static void swap(int i, int j, Comparable[]arr){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
