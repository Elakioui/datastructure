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

    private void insertUsingRecursion(AvlNode node, int value){

        AvlNode nodeToAdd = new AvlNode(0);

        if (value < node.getValue() ) {

            if (node.getLeftChild() == null) {
                node.setLeftChild(nodeToAdd);
                return;
            }

            insertUsingRecursion(node.getLeftChild(), value);
        }

        else if (value > node.getValue()) {

            if (node.getRightChild() == null) {
                node.setRightChild(nodeToAdd);
                return;
            }

            insertUsingRecursion(node.getRightChild(), value);
        }
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

        root.height = Math.max(
                height(root.leftChild),
                height(root.rightChild)
        ) + 1;

        if (isLeftHeavy(root))
            System.out.println(root.leftChild.getValue() + " is left heavy!");

        else if (isRightHeavy(root))
            System.out.println(root.rightChild.getValue() + " is right heavy!");

        return root;
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
