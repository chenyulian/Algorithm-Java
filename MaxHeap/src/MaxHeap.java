public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    /**
     * Heapify的方式创建堆
     * @param arr 普通数组
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for(int i = parent(arr.length - 1); i >= 0; i --) {
            siftDown(i);
        }
    }

    public int getSize() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 获取数组中某个元素的父节点的索引
     * @param index 元素的索引
     * @return 父节点的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have a parent.");
        }

        return (index - 1) / 2;
    }

    /**
     * 返回某个元素的左子节点的索引
     * @param index 元素的索引
     * @return 左子节点的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回某个元素的右子节点的索引
     * @param index 元素的索引
     * @return 右子节点的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.size() - 1);
    }

    /**
     *
     * @param index
     */
    private void siftUp(int index) {

        while(index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            // 交换元素和父节点元素的位置
            data.swap(index, parent(index));
            // 当前的index改变
            index = parent(index);
        }
    }

    /**
     * 查找堆中的最大元素，即数组的第一个元素
     * @return 堆中的最大元素
     */
    public E findMax() {
        if(data.size() == 0) {
            throw new IllegalArgumentException("Heap is empty.");
        }

        return data.getFirst();
    }

    public E extractMax() {
        E ret = findMax();

        // 1. 将最后一个元素放到根的地方，即索引为0的地方
        data.swap(0, data.size() - 1);
        data.removeLast();
        // 2. 第一个元素下沉到它应该待的地方
        siftDown(0);

        return ret;

    }

    private void siftDown(int index) {
        while(leftChild(index) < data.size()) {
            // 从当前节点的左右孩子节点找出较大的那一个，和当前节点比较
            // 如果比当前节点要大，就交换位置
            // 需要判断右孩子节点是否存在
            int j = leftChild(index);
            if (j + 1 < data.size() && data.get(j).compareTo(data.get(j + 1)) < 0) {
                // 说明存在右孩子节点
                j = rightChild(index);
            }
            // 此时data[j]是index左右两个子节点中的较大元素
            if(data.get(j).compareTo(data.get(index)) < 0) {
                break;
            }
            data.swap(index, j);
            index = j;
        }
    }

    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);

        return ret;
    }

}
