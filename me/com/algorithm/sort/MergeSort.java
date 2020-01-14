package com.algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String args[]) {
        int arr[] = {7, 22, 12, 15, 9, 33, 2, 6};

        System.out.print("\n");
        MergeSort.sort(arr);
        SortTestHelper test = new SortTestHelper();
        test.printIntArray(arr);
    }

    public static void sort(int arr[]) {
        int l = 0;
        int r = arr.length - 1;
        sort(arr, l, r);
    }

    //递归使用归并排序，对arr[l, r]范围进行排序
    private static void sort(int arr[], int l, int r) {
        //处理递归跳出的条件
        if(l >= r){
            return;
        }
        //取左半部分的最后一个数为mid
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    //将arr[l, mid]和arr[mid + 1, r]的数组进行归并
    private static void merge(int[] arr, int l, int mid, int r){
        int aux[] = Arrays.copyOfRange(arr, l, r + 1);
        //初始化，i指向左半部分起始位置l, j指向右半部分起始位置mid + 1;
        int i = l;
        int j = mid + 1;

        for(int k = l; k <= r; k ++) {
            //左半部分元素已经处理完毕，将右半部分剩下的元素归并
            if(i > mid) {
                arr[k] = aux[j - l];
                j ++;
            }else if(j > r) {
                //右半部分元素已经处理完毕，将左半部分剩下的元素归并
                arr[k] = aux[i - l];
                i ++;
            }else if(aux[i - l] < aux[j - l]) {
                //左半部分所指元素小于右半部分所指元素
                arr[k] = aux[i - l];
                i ++;
            }else{
                //右半部分所指元素小于左半部分所指元素
                arr[k] = aux[j - l];
                j ++;
            }
        }
    }


}
