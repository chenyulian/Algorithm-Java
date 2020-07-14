public class Test {
    public static void main(String[] args) {
        int[] nums = {5, 3, 6, 8, 4, 2};
        ////////////////
        //     5      //
        //    / \     //
        //   2  6     //
        //  / \  \    //
        // 3   4  8   //
        ////////////////

        BST<Integer> bst = new BST<>();

        for(int num: nums) {
            bst.add(num);
        }

        // 前序遍历
        bst.preOrder();
        System.out.println();

        // 中序遍历
        bst.inOrder();
        System.out.println();

        // 后序遍历
        bst.postOrder();
        System.out.println();

        //System.out.println(bst);
    }
}
