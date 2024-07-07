package practice;

public class AVL {
    public static void main(String[] args) {
        AVL tree = new AVL();
        int[] arr = { 1, 2, 3, 4, 5 };
        for (int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }
        tree.display();

    }

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

        return rotate(node);
    }

    private Node rotate(Node node) {

        // left-heavy
        if (height(node.left) - height(node.right) > 1) {
            if (height(node.left.left) - height(node.left.right) > 0) {
                // left-left heavy
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                // left-right heavy
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        // right-heavy
        if (height(node.left) - height(node.right) < -1) {
            if (height(node.right.left) - height(node.right.right) < 0) {
                // right-right heavy
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                // right-left heavy
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node rightRotate(Node p) {

        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;

        return c;
    }

    private Node leftRotate(Node c) {

        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;

        return p;
    }

    public void display() {
        display("Root Node is: ", root);
        System.out.println(height(root));
    }

    private void display(String details, Node node) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display("Left node of " + node.value + " is : ", node.left);
        display("Right node of " + node.value + " is : ", node.right);
    }

}