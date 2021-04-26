import arraySearch.FirstAssignment;
import arraySearch.SecondAssignment;
import avltree.AvlTree;
import nolinear.BinarySearchTree;

import java.util.*;
import java.util.Stack;


public class Main {

    private static String s;

    public static void main(String[] args){

//        String returnedDay  = FirstAssignment.search("Fri", 22);
//
//        System.out.println(returnedDay);

        int[] seats = {5, 4, 8};
        int[] persons = {3, 2, 5};

        int carsToUser = SecondAssignment.getNumberOfCars(seats, persons);

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
