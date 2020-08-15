import java.util.ArrayList;

// 二分搜索树中的key，必须是可比较的，因为要把key存在二分搜索树中
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 辅助方法
     * @param node 要执行添加操作的BST的根
     * @param value 添加的值
     * @return 执行完添加操作之后BST的根
     */
    private Node add(Node node, K key, V value) {
        if(node == null) {
            size ++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        }else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        }else {
            // key值重复，更新value
            node.value = value;
        }

        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if(node != null) {
            root = remove(root, key);
            return node.value;

        }
        return null;
    }

    /**
     * 辅助函数，删除掉以node为根的二分搜索树中，键为key的节点
     * @param node
     * @param key
     * @return
     */
    private Node remove(Node node, K key) {

        if(key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else if(key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else { // 找到了这个节点
            // 左子树为空
            if(node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            // 右子树为空
            if(node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 左右子树都不为空
            // 1. 找到这个节点删除后应放在此处的节点（后继节点）
            Node successor = minimun(node.right);
            // 2 将删除掉了后继节点的子树接到此处
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }

    }

    /**
     * 辅助函数，找到以node为根的二分搜索树中的最小节点
     * @param node
     * @return
     */
    private Node minimun(Node node) {
        if(node.left == null) {
            return node;
        }
        return minimun(node.left);
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if(node.left == null) {
            // do delete
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    /**
     * 辅助方法，查找以node为根节点的二分搜索树中，key为传入参数key的节点
     * @param node 根节点
     * @param key key
     * @return 以node为根节点的二分搜索树中，key为传入参数key的节点
     */
    private Node getNode(Node node, K key) {
        // 递归终止条件
        if(node == null) {
            return null;
        }

        if(key.compareTo(node.key) == 0) {
            return node;
        }else if(key.compareTo(node.key) > 0){
            return getNode(node.right, key);
        }else{
            return getNode(node.left, key);
        }
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }


    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist.");
        }

        node.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("Map/pride-and-prejudice.txt", words)) {
            System.out.println("[BSTMap] Total words: " + words.size());
            BSTMap<String, Integer> wordsMap = new BSTMap<>();
            for(String word:words) {
                if(wordsMap.contains(word)) {
                    wordsMap.set(word, wordsMap.get(word) + 1);
                }else{
                    wordsMap.add(word, 1);
                }
            }

            System.out.println("[BSTMap] Total different words: " + wordsMap.size);
            System.out.println("[BSTMap] Frequency of pride: " + wordsMap.get("pride"));
            System.out.println("[BSTMap] Frequency of pride: " + wordsMap.get("prejudice"));

        }
    }

}
