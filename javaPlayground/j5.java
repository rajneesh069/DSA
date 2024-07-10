package javaPlayground;

public class j5 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 43, 22, 99, 5 };
        j5 avl = new j5();
        for (int i = 0; i < arr.length; i++) {
            avl.insert(arr[i]);
        }
        avl.display();
        if (avl.isBalanced()) {
            System.out.println("Tree is balanced.");
        } else {
            System.out.println("Tree is unbalanced.");
        }
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

    public boolean isBalanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
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
            Node newNode = new Node(value);
            return newNode;
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

        if (height(node.left) - height(node.right) > 1) {
            // left-heavy tree
            if (height(node.left.left) - height(node.left.right) > 0) {
                // left-left heavy tree
                return rightRotate(node);
            }

            if (height(node.left.left) - height(node.left.right) < 0) {
                // left-right heavy tree
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        } else if (height(node.left) - height(node.right) < -1) {
            // right-heavy tree
            if (height(node.right.right) - height(node.right.left) > 0) {
                // right-right heavy tree
                return leftRotate(node);
            }

            if (height(node.right.left) - height(node.right.right) > 0) {
                // right-left heavy tree
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
        display("Root node is: ", root);
        System.out.println("Height of the tree is : " + root.height);
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
