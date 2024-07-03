package practice;

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

    public void display() {
        display("Root node is : ", root);
    }

    private void display(String details, Node node) {
        if (node == null) {
            return;
        }

        System.out.println(details + node.value);
        display("Left node of " + node.value + " is : ", node.left);
        display("Right node of " + node.value + " is : ", node.right);
    }

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
        int diff = height(node.left) - height(node.right);
        if (diff > 1) {
            if (height(node.left.left) - height(node.left.right) > 0) {
                // left-left
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                // left-right
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (diff < -1) {
            if (height(node.right.left) - height(node.right.right) < 0) {
                // right-right
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                // left-right
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
        c.height = Math.max(height(p.left), height(p.right)) + 1;
        return c;
    }

    private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;
        c.right = t;
        p.left = c;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        c.height = Math.max(height(p.left), height(p.right)) + 1;
        return p;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        AVL tree = new AVL();
        for (int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }
        tree.display();
    }
}
