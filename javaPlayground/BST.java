package javaPlayground;

public class BST {
    private Node root;

    private class Node {
        int value;
        Node left;
        Node right;
        int height;

        public Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public int height(Node node) {
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

        node.height = Math.max(height(node.left), height(node.right));

        return node;
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            root = insert(root, nums[i]);
        }
    }

    public boolean isBalanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.absExact(height(node.left) - height(node.right)) <= 1 && balanced(node.left)
                && balanced(node.right);
    }

    public void populateSorted(int[] nums, int start, int end) {
        // O(n*log(n))
        if (start >= end) {
            return;
        }

        int mid = (start) + (end - start) / 2;
        insert(root, nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);

    }

    public void display() {
        display(root, "Root Node : ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }

        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " is: ");
        display(node.right, "Right child of " + node.value + " is: ");
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] nums = { 5, 4, 6, 3, 2, 4 };
        bst.populate(nums);
        System.out.println(bst.isBalanced());
        bst.display();
    }
}
