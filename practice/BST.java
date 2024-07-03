package practice;

public class BST {
    private class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void display() {
        display("Root node is: ", root);
    }

    private void display(String details, Node node) { // keep the updated details and node available from the
        // function call
        if (node == null) {
            return;
        }

        System.out.println(details + node.value);
        display("Left child of " + node.value + " is: ", node.left);
        display("Right child of " + node.value + " is: ", node.right);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        }
        if (value > node.value) {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    private boolean balanced(Node node) {
        if(node==null){
            return true;
        }
        return Math.absExact(height(node.left) - height(node.right)) <= 1 && balanced(node.left)
                && balanced(node.right);
    }

    public void isBalanced() {
        if (balanced(root)) {
            System.out.println("The tree is balanced.");
            return;
        }
        System.out.println("The tree is unbalanced.");
        return;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(5);
        tree.isBalanced();
    }

}
