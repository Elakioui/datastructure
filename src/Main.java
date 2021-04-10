import avltree.AvlTree;
import nolinear.BinarySearchTree;

import java.util.*;
import java.util.Stack;


public class Main {

    private static String s;

    public static void main(String[] args){
        //    12
        //      14
         //       15

        //
        //
        //      25
        //    20
        //      24
        //
        //

        AvlTree avlTree = new AvlTree();
        avlTree.insertUsingRecursion(25);
        avlTree.insertUsingRecursion(20);
        avlTree.insertUsingRecursion(24);


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
