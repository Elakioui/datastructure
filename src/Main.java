import avltree.AvlTree;
import nolinear.BinarySearchTree;

import java.util.*;
import java.util.Stack;


public class Main {

    private static String s;

    public static void main(String[] args){
        //    10
        //      13
        //   9
        //  7
        // 6

        AvlTree avlTree = new AvlTree();
        avlTree.insertUsingRecursion(10);
        avlTree.insertUsingRecursion(13);
        avlTree.insertUsingRecursion(9);
        avlTree.insertUsingRecursion(7);
        avlTree.insertUsingRecursion(6);


    }

    public static void reverse(Queue<Integer> queue){
        int[] array = new int[queue.size()];
        int i = 0;
        while(!queue.isEmpty()){
            int head = queue.remove();
            array[i++] = head;

        }

        for (int j = array.length -1; j >= 0; j--){
            queue.add(array[j]);
        }

    }

    public static void reverseWithStack(Queue<Integer> queue) {

        Stack<Integer> stack = new Stack<>();

        while(!queue.isEmpty())
            stack.push(queue.remove());

        while(!stack.isEmpty())
            queue.add(stack.pop());
    }


}
