package practice;

public class SegmentTree {
    private class Node {
        private int data;
        private int startIndex;
        private int endIndex;
        private Node left;
        private Node right;

        private Node(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }

    private Node root;

    public void display() {
        display("Root node data: ", root);
    }

    private void display(String details, Node node) {
        if (node == null) {
            return;
        }
        System.out
                .println(details + node.data + " with interval [" + node.startIndex + ", " + node.endIndex + "]");
        display("Left Node of " + node.data + " has data : ", node.left);
        display("Right Node of " + node.data + " has data : ", node.right);
    }

    public SegmentTree(int[] nums) {
        this.root = construct(nums, 0, nums.length - 1);
    }

    private Node construct(int[] nums, int start, int end) {
        if (start == end) {
            Node leafNode = new Node(start, end);
            leafNode.data = nums[start];
            return leafNode;
        }

        Node node = new Node(start, end);
        int mid = (start + end) / 2;
        node.left = this.construct(nums, start, mid);
        node.right = this.construct(nums, mid + 1, end);

        node.data = node.left.data + node.right.data;

        return node;
    }

    public int query(int qsi, int qei) {
        return query(root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        if (qsi > node.endIndex || qei < node.startIndex) {
            return 0;
        } else if (node.startIndex >= qsi && node.endIndex <= qei) {
            return node.data;
        }
        return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
    }

    public void update(int index, int value) {
        this.root.data = update(root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startIndex && index <= node.endIndex) {
            if (index == node.startIndex && node.endIndex == index) {
                node.data = value;
                return node.data;
            } else {
                int leftAns = this.update(node.left, index, value);
                int rightAns = this.update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }

        return node.data;
    }

    public static void main(String[] args) {
        SegmentTree tree = new SegmentTree(new int[] { 1, 2, 3, 4, 5 });
        tree.display();
        tree.update(2, 7);
        tree.display();
    }
}
