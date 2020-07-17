import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] nums = {5, 3, 6, 8, 4, 2};
        ////////////////
        //     5      //
        //    / \     //
        //   3  6     //
        //  / \  \    //
        // 2   4  8   //
        ////////////////

        BST<Integer> bst = new BST<>();

        for(int num: nums) {
            bst.add(num);
        }

        // 前序遍历
        bst.preOrder();
        System.out.println();

        // 前序遍历（非递归）
        bst.preOrderNR();
        System.out.println();

        // 中序遍历
        bst.inOrder();
        System.out.println();

        // 后序遍历
        bst.postOrder();
        System.out.println();

        // 层序遍历
        bst.levelOrder();
        System.out.println();

        System.out.println("测试找到树中的最小元素：");
        System.out.println(bst.minimum());

        System.out.println("测试找到树中的最大元素：");
        System.out.println(bst.maximum());

        System.out.println();

        System.out.println("测试删除树中的最小元素 start");
        BST<Integer> bst2 = new BST<>();
        Random random = new Random();
        // 随机生成一棵二分搜索树，每次从树中删除最小元素，按顺序存入ArrayList
        // 如果删除树中的最小元素方法正确，则ArrayList中的元素是按从小到大的顺序排列的
        for(int i = 0; i < 1000; i ++) {
            bst2.add(random.nextInt(1000));
        }
        ArrayList<Integer> list1 = new ArrayList<>(bst2.getSize());
        for(int i = 0; i < bst2.getSize(); i ++) {
            list1.add(bst2.removeMin());
        }
        for(int j = 1; j < list1.size(); j ++) {
            if(list1.get(j) < list1.get(j - 1)) {
                System.out.println("测试删除树中的最小元素 未通过");
            }
        }
        System.out.println(list1);
        System.out.println("测试删除树中的最小元素 通过");
        System.out.println("测试删除树中的最小元素 end");
        System.out.println();

        System.out.println("测试删除树中的最大元素 start");
        // 随机生成一棵二分搜索树，每次从树中删除最大元素，按顺序存入ArrayList
        // 如果删除树中的最大元素方法正确，则ArrayList中的元素是按从大到小的顺序排列的
        bst2 = new BST<>();
        for(int i = 0; i < 1000; i ++) {
            bst2.add(random.nextInt(1000));
        }
        list1 = new ArrayList<>(bst2.getSize());
        for(int i = 0; i < bst2.getSize(); i ++) {
            list1.add(bst2.removeMax());
        }
        for(int j = 1; j < list1.size(); j ++) {
            if(list1.get(j) > list1.get(j - 1)) {
                System.out.println("测试删除树中的最大元素 未通过");
            }
        }
        System.out.println(list1);
        System.out.println("测试删除树中的最大元素 通过");
        System.out.println("测试删除树中的最大元素 end");

        //System.out.println(bst);
    }
}
