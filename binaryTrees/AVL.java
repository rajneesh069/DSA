package binaryTrees;

public class AVL {
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

        if (value > node.value) {
            node.right = insert(node.right, value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return rotate(node);

    }

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            // left heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                // left-left case
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                // left-right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (height(node.left) - height(node.right) < -1) {
            // right heavy
            if (height(node.right.left) - height(node.right.right) < 0) {
                // right-right
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                // right-left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        c.right = t;
        p.left = c;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return p;
    }

    private Node rightRotate(Node p) {

        Node c = p.left;
        Node t = c.left;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

    public void populate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
    }

    public void display() {
        display("Root node is : ", root);
        System.out.println("Height is : " + root.height);
    }

    private void display(String details, Node node) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display("Left child of " + node.value + " is : ", node.left);
        display("Right child of " + node.value + " is : ", node.right);
    }
}
