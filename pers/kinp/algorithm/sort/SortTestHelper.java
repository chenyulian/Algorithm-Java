package pers.kinp.algorithm.sort;

import java.lang.reflect.Method;
import java.util.Random;

public class SortTestHelper {

    //随机生成值在指定闭区间内的数组
    public Integer[] generateRandomArray(int size, int startNum, int endNum){
        Integer[] arr = new Integer[size];
        Random random = new Random();
        for(int i = 0; i < size; i ++){
            arr[i] = random.nextInt(endNum)%(endNum - startNum  + 1) + startNum;
        }
        return arr;
    }

    //打印排序好的数组
    public void printIntArray(Integer[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i ++){
            System.out.print(arr[i] + " ");
        }
    }

    public void printIntArray(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i ++){
            System.out.print(arr[i] + " ");
        }
    }

    //判断是否已经排好序
    public boolean isSorted(int[] arr){
        for(int i = 0; i < arr.length - 1; i ++){
            if(arr[i] > arr[i + 1]){
                return false;
            }
        }
        return true;
    }

    //测试sortClass对应的排序算法运算给定的数组需要的时间
    //通过反射获取方法
    public void testSort(String sortClassName, Comparable arr[]){
        try{
            Class sortClass = Class.forName(sortClassName);
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            long startTime = System.currentTimeMillis();
            Object[] params = new Object[]{arr};
            sortMethod.invoke(new InsertionSort(), params);
            long endTime = System.currentTimeMillis();
            System.out.print("\n" + "运行时间：" + (endTime - startTime) + "\n");
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    //打印任意类型的数组的信息
    public void printArray(){

    }
}
