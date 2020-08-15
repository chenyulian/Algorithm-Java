import java.util.ArrayList;

public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        // key是唯一的
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append(" key: " + key);
            res.append(" value: " + value);

            return res.toString();
        }
    }

    private int size;
    private Node dummyHead;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while(cur != null) {
            if(cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {

        Node node = getNode(key);
        if(node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size ++;
        }else{
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {

        Node prev = dummyHead;
        while (prev.next != null) {
            if(prev.next.key.equals(key))
                break;
            prev = prev.next;
        }

        if(prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        return this.getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if(node == null)
            throw new IllegalArgumentException(key + "doesn't exist");
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
            System.out.println("[LinkedListMap] Total words: " + words.size());
            LinkedListMap<String, Integer> wordsMap = new LinkedListMap<>();
            for(String word:words) {
                if(wordsMap.contains(word)) {
                    wordsMap.set(word, wordsMap.get(word) + 1);
                }else{
                    wordsMap.add(word, 1);
                }
            }

            System.out.println("[LinkedListMap] Total different words: " + wordsMap.size);
            System.out.println("[LinkedListMap] Frequency of pride: " + wordsMap.get("pride"));
            System.out.println("[LinkedListMap] Frequency of pride: " + wordsMap.get("prejudice"));

        }
    }
}
