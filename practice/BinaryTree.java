package practice;

public class BinaryTree {
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

    public void insert(int value) {
        root = insert(root, value);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (node.left == null) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public void display() {
        display("Root node is: ", root);
    }

    private void display(String details, Node node) {
        if (node == null) {
            return;
        }
        System.out.println(details + " " + node.value);
        display("Left child of " + node.value + " is: " + " and height = " + node.height, node.left);
        display("Right child of " + node.value + " is: " + " and height = " + node.height, node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(7);
        tree.insert(8);
        tree.display();
    }
}