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



    // 20 step 1
    // 12 (value) step2
    //  3 (value)  step3
    private AvlNode  insertUsingRecursionV2(AvlNode root, int value){
        if (root == null)
            return new AvlNode(value);

        if(value < root.getValue())
            root.leftChild = insertUsingRecursionV2(root.getLeftChild(), value);

        else if (value > root.getValue())
            root.rightChild = insertUsingRecursionV2(root.getRightChild(), value);

        root.height = calculateHeight(root);

        root = balance(root);

        return root;
    }
    private  AvlNode balance(AvlNode root){
        if (isLeftHeavy(root)) {

            if (balanceFactor(root.leftChild) < 0)
                 root = rotateLeft(root.leftChild);

            root = rotateRight(root);
        }

        else if (isRightHeavy(root)) {

            if (balanceFactor(root.rightChild) > 0)
                 root = rotateRight(root.rightChild);

            root = rotateLeft(root);
        }

        return root;

    }

    //
    //   20
    // 10   30
    //   19

    // 19 -> newRootLeft


    private AvlNode rotateLeft(AvlNode root){

        AvlNode newRoot = root.rightChild;

        if (newRoot.leftChild != null) {
            AvlNode newRootLeft = newRoot.leftChild;
            newRoot.leftChild = root;
            root.rightChild = newRootLeft;
        }
        else {
            newRoot.leftChild = root;
            root.rightChild = null;
        }

        calculateHeight(newRoot);
        calculateHeight(root);

        return newRoot;
    }

    //       22
    //     19
    //    18  20
    //
    //
    private AvlNode rotateRight(AvlNode root){

        AvlNode newRoot = root.leftChild;

        if (newRoot.rightChild != null) {
            AvlNode newRootRight = newRoot.rightChild;
            newRoot.rightChild = root;
            root.leftChild = newRootRight;
        }
        else {
            newRoot.rightChild = root;
            root.leftChild = null;
        }

        calculateHeight(newRoot);
        calculateHeight(root);

        return newRoot;
    }

    private int calculateHeight(AvlNode root){
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
