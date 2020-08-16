import java.util.Random;

public class Test {
    private static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if(isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        }else{
            maxHeap = new MaxHeap<>();
            for(int num:testData) {
                maxHeap.add(num);
            }
        }

        int arr[] = new int[testData.length];
        for(int i = 0; i < testData.length; i ++) {
            arr[i] = maxHeap.extractMax();
        }

        for(int i = 1; i < testData.length; i ++) {
            if(arr[i - 1] < arr[i]) {
                throw new RuntimeException("Error");
            }
        }

        System.out.println("MaxHeap test complete.");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
    public static void main(String[] args) {
        int n = 10000000;
        Integer[] testData = new Integer[n];
        MaxHeap<Integer> heap = new MaxHeap<>();
        Random random = new Random();
        for(int i = 0; i < n; i ++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }


        double time1 = testHeap(testData, false);
        System.out.println("not heapify: " + time1);
        double time2 = testHeap(testData, true);
        System.out.println("is heapify: " + time2);

    }
}
