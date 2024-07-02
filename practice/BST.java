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

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public int height() {
        return height(root);
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (node.value < value) {
            node.right = insert(node.right, value);
        }
        if (node.value > value) {
            node.left = insert(node.left, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            root = insert(root, nums[i]);
        }
    }

    public void populateSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);
    }

    public void display() {
        display("Root node is : ", root);
    }

    private void display(String details, Node node) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);

        display("Left child of " + node.value + " is: ", node.left);
        display("Right child of " + node.value + " is: ", node.right);

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3};
        BST tree = new BST();
        tree.populateSorted(nums, 0, nums.length);
        System.out.println("The height of the tree is : " + tree.height());
        tree.display();
    }
}
