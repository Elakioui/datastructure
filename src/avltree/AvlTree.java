package avltree;

public class AvlTree {

    private class AvlNode {

        private int value;
        private int height;
        private AvlNode leftChild;
        private AvlNode rightChild;

        public AvlNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public AvlNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(AvlNode leftChild) {
            this.leftChild = leftChild;
        }

        public AvlNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(AvlNode rightChild) {
            this.rightChild = rightChild;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public String toString(){
            return "Value=" + value;
        }
    }

    private AvlNode root;

    public void insert(int value) {

        if (root == null) {
            root = new AvlNode(value);
            return;
        }

        AvlNode current = root;

        while (true){

            if (value < current.getValue()) {

                if (current.getLeftChild() == null) {
                    current.setLeftChild(new AvlNode(value));
                    break;
                }

                current = current.getLeftChild();

            }

            else if (value > current.getValue()) {

                if (current.getRightChild() == null) {
                    current.setRightChild(new AvlNode(value));

                    break;
                }

                current = current.getRightChild();

            }

        }
    }

    public void insertUsingRecursion(int value){
        root = this.insertUsingRecursionV2(root, value);
    }

    private AvlNode  insertUsingRecursionV2(AvlNode root, int value){
        if (root == null)
            return new AvlNode(value);

        if(value < root.getValue())
            root.leftChild = insertUsingRecursionV2(root.getLeftChild(), value);

        else if (value > root.getValue())
            root.rightChild = insertUsingRecursionV2(root.getRightChild(), value);

        root.height = setHeight(root);

        return balance(root);

    }
    private  AvlNode balance(AvlNode root){
        if (isLeftHeavy(root)) {

            if (balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);

            return rotateRight(root);
        }

        else if (isRightHeavy(root)) {

            if (balanceFactor(root.rightChild) > 0)
                 root.rightChild = rotateRight(root.rightChild);

            rotateLeft(root);
        }

        return root;

    }

    private AvlNode rotateLeft(AvlNode root){

        AvlNode newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(newRoot);
        setHeight(root);

        return newRoot;
    }

    private AvlNode rotateRight(AvlNode root){

        AvlNode newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(newRoot);
        setHeight(root);

        return newRoot;
    }

    private int setHeight(AvlNode root){
        return Math.max(
                height(root.leftChild),
                height(root.rightChild)
        ) + 1;
    }

    private int height(AvlNode node){
        return (node == null) ? -1 : node.height;
    }

    private int balanceFactor( AvlNode node ){
        return ( node == null ) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private boolean isLeftHeavy( AvlNode node ) {
        return balanceFactor( node ) > 1;
    }

    private boolean isRightHeavy(AvlNode node) {
        return balanceFactor( node ) < -1;
    }
}
