package javaPlayground;

//BST implementation
public class j4 {
    public static void main(String[] args) {
        j4 bst = new j4();
        int[] arr = { 1, 2, 3, 4, 5 };
        bst.insertSorted(arr);
        bst.display();
    }

    private class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

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

        return node;
    }

    public void insertSorted(int[] arr) {
        insertSortedArray(root, arr, 0, arr.length);
    }

    private void insertSortedArray(Node node, int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        insert(arr[mid]);
        insertSortedArray(root, arr, start, mid);
        insertSortedArray(root, arr, mid + 1, end);
    }

    public void display() {
        display("Root node is : ", root);
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
