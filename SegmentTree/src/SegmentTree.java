
public class SegmentTree<E> {
    private E[] data;

    private E[] tree;

    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;

        data = (E[]) new Object[arr.length];
        for(int i = 0; i < arr.length; i ++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[4 * data.length];

        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 构建以treeIndex为根，区间为[left, right]的线段树
     *
     */
    private void buildSegmentTree(int treeIndex, int left, int right) {
        // 递归终止条件
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = left + (right - left) / 2;

        // 构建左子树，区间[left, mid]
        buildSegmentTree(leftTreeIndex, left, mid);
        // 构建右子树，区间[mid+1, right]
        buildSegmentTree(rightTreeIndex, mid + 1, right);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if(index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    public int leftChild(int index) {
        return 2 * index + 1;
    }

    public int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * 查找data区间[queryL, queryR]的值
     * @param queryL
     * @param queryR
     * @return
     */
    public E query(int queryL, int queryR) {
        if(queryL < 0 || queryL > data.length - 1
                || queryR < 0 || queryR > data.length - 1
                || queryL > queryL) {
            throw new IllegalArgumentException("Illegal index.");
        }

        return query(0, 0, data.length - 1, queryL, queryR);

    }

    /**
     * 在以treeIndex为根的节点中[left, right]的范围里，查找data区间[queryL, queryR]的值
     * @param treeIndex 线段树的根
     * @param left 线段树表示的区间范围的左边界
     * @param right 线段树表示的区间范围的右边界
     * @param queryL 查询的区间范围的左边界
     * @param queryR 查询的区间范围的右边界
     * @return
     */
    private E query(int treeIndex, int left, int right, int queryL, int queryR) {

        if (left == queryL && right == queryR) {
            return tree[treeIndex];
        }

        int mid = left + (right - left) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if(queryL >= mid + 1) {
            return query(rightTreeIndex, mid + 1, right, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftTreeIndex, left, mid, queryL, queryR);
        }

        // [queryL, queryR] 一部分在左孩子，一部分在右孩子
        E leftResult = query(leftTreeIndex, left, mid, queryL, queryR);
        E rightResult = query(rightTreeIndex, mid + 1, right, queryL, queryR);

        return merger.merge(leftResult, rightResult);
    }

    /**
     * 将index位置的值更新为e
     * @param index 待更新位置的索引
     * @param e 新元素
     */
    public void set(int index, E e) {

        if (index < 0 || index > data.length - 1) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        data[index] = e;

        // 更新线段树
        set(0, 0, data.length - 1, index, e);

    }

    /**
     * 更新线段树
     * @param treeIndex 线段树根节点
     * @param left 线段树表示的区间范围的左边界
     * @param right 线段树表示的区间范围的右边界
     * @param index 需要更新的元素的坐标
     * @param e 更新的值
     */
    private void set(int treeIndex, int left, int right, int index, E e) {

        // 递归终止条件
        if (left == right) {
            tree[treeIndex] = e;
        }

        int mid = left + (right - left) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (index >= mid + 1) {
            set(rightTreeIndex, mid + 1, right, index, e);
        }else{
            set(leftTreeIndex, left, mid, index, e);
        }

        merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("SegmentTree: [");
        for (int i = 0; i < tree.length; i ++) {
            if(tree[i] != null) {
                res.append(tree[i]);
            }else{
                res.append("null");
            }

            if(i < tree.length - 1) {
                res.append(", ");
            }
        }
        res.append("]");

        return res.toString();
    }


}
