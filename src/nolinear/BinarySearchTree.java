package nolinear;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinarySearchTree {

    private class Node {

        private Integer value;
        private Node left;
        private Node right;

        public Node(Integer value) {
            this.value = value;
        }


        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString(){
            return "Node=" + value;
        }
    }

    private static final  Logger LOGGER = Logger.getLogger(BinarySearchTree.class.getName());
    private  Node root;



    public void insert(int value){

        Node node =  new Node(value);

       if(root == null) {
           root = node;
           return;
       }

       Node current = root;
       while(true){

           if(value < current.getValue()) {

               if (current.getLeft() == null){
                   current.setLeft(node);
                   break;
               }

               current = current.getLeft();
           }

           else {

               if (current.getRight() == null){
                   current.setRight(node);
                   break;
               }

               current = current.getRight();
           }
       }
    }

    public Boolean find(Integer value){

        Node current = root;

        while (current != null){

            if (value < current.getValue())
                current = current.getLeft();

            else if (value > current.getValue())
                current = current.getRight();

            else return true;
        }

        return false;
    }

    public void traverseTree(){
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node current){
        if (current == null)
            return;
        System.out.println(current.getValue());
        LOGGER.log(Level.INFO, "Testing jjfjfjjf");
        preOrderTraversal(current.getLeft());
        preOrderTraversal(current.getRight());
    }
    public int height(){
        return height(this.root);
    }

    public int height(Node root){

        if(root == null)
            return -1;

        if (root.getLeft() == null && root.getRight() == null)
            return 0;

        return  1 + Math.max(height(root.getLeft()), height(root.getRight()));

    }

    public int min(){

        int minValue = this.root.getValue();
        Node current = root;

        while(current != null){
            if (current.getLeft().getValue() < minValue) {
                minValue = current.getLeft().getValue();
                current = current.getLeft();
            }
        }

        return minValue;
    }

    public int leafMin(){

        if (root == null)
            return -1;

        Node current = root;

        while(true){

            if (current.getLeft() == null) {
                break;
            }

            current = current.getLeft();
        }

        return current.getValue();
    }

    public int minTree(){
        return minTree(root);
    }

    private int minTree(Node node){

        if (node == null)
            return -1;

        int minValue = node.getValue();

        int minLeft  = minTree(node.getLeft());
        int minRight = minTree(node.getRight());

        if (minValue > minLeft && minLeft >= 0 )
            minValue = minLeft;

        if(minValue > minRight && minRight >= 0)
            minValue = minRight;

        return minValue;

    }

    public Node getRoot() {
        return root;
    }


    public boolean equalsBinaryTree(BinarySearchTree tree){
        return equalsBinaryTree(root, tree.getRoot());
    }

    private boolean equalsBinaryTree(
            Node firstTree,
            Node secondTree
    ){

        if(firstTree == null && secondTree == null)
            return true;

        else if(firstTree == null)
            return false;

        else if(secondTree == null)
            return false;

        if (!firstTree.getValue().equals(secondTree.getValue()))
            return false;

        boolean isLeftTrue = equalsBinaryTree(root.getLeft(), secondTree.getLeft());
        boolean isRightTrue = equalsBinaryTree(root.getRight(), secondTree.getRight());

        return isLeftTrue && isRightTrue;

    }

    public boolean check(){
        if (root == null)
            return true;

        return this.check(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean check(Node node, int min , int max){

        if (node == null)
            return true;

        if (node.getValue() < min ||  node.getValue() < max)
            return false;


        return check(node.getLeft(), Integer.MIN_VALUE, node.getValue() - 1)
                && check(node.getRight(), node.getValue(), Integer.MAX_VALUE);
    }

    public List<Integer> nodeAtKDistance(int distance){

        List<Integer> nodesAtdistance = new ArrayList<>();
        this.nodeAtKDistance(this.root, distance, nodesAtdistance);
        return nodesAtdistance;

    }

    private void  nodeAtKDistance(
            Node node,
            int distance,
            List<Integer> nodesAtdistance
    ){

        if (node == null)
            return;

        if (distance == 0){
            nodesAtdistance.add(node.getValue());
            return;
        }

        distance--;

        nodeAtKDistance(node.getLeft(), distance, nodesAtdistance);
        nodeAtKDistance(node.getRight(), distance, nodesAtdistance);

    }
}
