package binaryTrees;

public class SegmentTree {
    public static void main(String[] args) {
        int[] nums = { 3, 8, 6, 7, -2, -8, 4, 9 };
        SegmentTree tree = new SegmentTree(nums);

        tree.display();
        tree.update(7, 25);
        System.out.println("New Data : ");
        tree.display();
    }

    private class Node {
        private int data;
        private int startInterval;
        private int endInterval;
        private Node left;
        private Node right;

        private Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    private Node root;

    public SegmentTree(int[] nums) {
        this.root = constructTree(nums, 0, nums.length - 1);
    }

    private Node constructTree(int[] nums, int start, int end) {
        if (start == end) {
            Node leafNode = new Node(start, end);
            leafNode.data = nums[start];
            return leafNode;
        }

        Node node = new Node(start, end);
        int mid = (start + end) / 2;
        node.left = constructTree(nums, start, mid);
        node.right = constructTree(nums, mid + 1, end);
        node.data = node.left.data + node.right.data;

        return node;
    }

    public void display() {
        display("Root node data: ", root);
    }

    private void display(String details, Node node) {
        if (node == null) {
            return;
        }
        System.out
                .println(details + node.data + " with interval [" + node.startInterval + ", " + node.endInterval + "]");
        display("Left Node of " + node.data + " has data : ", node.left);
        display("Right Node of " + node.data + " has data : ", node.right);
    }

    public int query(int qsi, int qei) {
        return query(root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            return node.data;
        }
        if (node.startInterval > qei || node.endInterval < qsi) {
            return 0;
        }
        return this.query(node.right, qsi, qei) + this.query(node.left, qsi, qei);
    }

    public void update(int index, int data) {
        this.root.data = update(root, index, data);
    }

    private int update(Node node, int index, int data) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.data = data;
                return node.data;
            } else {
                int leftAns = update(node.left, index, data);
                int rightAns = update(node.right, index, data);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }
}
