package pers.kinp.datastructure.stack;

public class Test {
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for(int i = 0; i < 5; i ++) {
            stack.push(i);
            System.out.println(stack.toString());
        }

        stack.pop();

        System.out.println(stack.toString());
    }
}
