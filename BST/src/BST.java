import java.util.Stack;

public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left;
        public Node right;

        //构造函数
        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(E e) {
//        if(root == null) {
//            root = new Node(e);
//            size ++;
//        }else{
//            add(root, e);
//        }
        // 改进了私有add方法之后的写法
        root = add(root, e);
    }
      // 向以node为根的二分搜索树中插入元素
//    private void add(Node node, E e) {
//        if(node.e.compareTo(e) == 0) {
//            return;
//        }else if(node.e.compareTo(e) > 0 && node.left == null) {
//            // 添加到左子树
//            node.left = new Node(e);
//            size ++;
//            return;
//        }else if(node.e.compareTo(e) < 0 && node.right == null) {
//            //添加到右子树
//            node.right = new Node(e);
//            size ++;
//            return;
//        }
//
//        // 如果没有触发边界条件，就继续递归调用add方法
//        if(node.e.compareTo(e) > 0) {
//            //将e传递给左子树的根节点
//            add(node.left, e);
//        }else{
//            add(node.right, e);
//        }
//    }

    // 一种更简洁的写法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {
        if(node == null) {
            size ++;
            return new Node(e);
        }else{
            if(e.compareTo(node.e) > 0) {
                node.right = add(node.right, e);
            }else if(e.compareTo(node.e) < 0) {
                node.left = add(node.left, e);
            }

            return node;
        }
    }

    // 查看二分搜索树中是否包含e
    public boolean contains(E e) {
        return contains(root, e);
    }

    // 查看以node为根的树中是否包含e
    private boolean contains(Node node, E e) {
        if(node == null) return false;

        if (e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        }else{ // e < node.e，去node的左子树中查
            return contains(node.left, e);
        }
    }

    // 前序遍历
    public void preOrder() {
        System.out.println("前序遍历：");
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null) {
            return;
        }

        // 这里访问节点只对该节点进行打印操作，其他场景根据需求不同有可能需要对该节点做别的操作
        System.out.println(node.e);
        //先遍历左子树，再遍历右子树
        preOrder(node.left);
        preOrder(node.right);
    }

    // 非递归的方式实现前序遍历
    public void preOrderNR() {
        System.out.println("前序遍历（非递归）：");
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()) {
            // 对当前节点进行操作，并出栈
            Node cur = stack.pop();
            System.out.println(cur.e);

            // 如果存在子节点，就压入栈。
            // 栈是先进后出，我们需要先处理左节点，再处理右节点，因此先将右节点压入栈
            if(cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    // 中序遍历
    public void inOrder() {
        System.out.println("中序遍历：");
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 后序遍历
    public void postOrder() {
        System.out.println("后序遍历：");
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        generateBSTString(root, res, 0);

        return res.toString();
    }

    // 前序遍历的方式生成
    private void generateBSTString(Node node, StringBuilder res, int depth) {
        if(node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");

        generateBSTString(node.left, res, depth + 1);
        generateBSTString(node.right, res, depth + 1);
    }

    // 生成depth层的打印结果（root在第0层，子树的层数依次递增）
    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i ++) {
            res.append("--");
        }
        return res.toString();
    }

}
