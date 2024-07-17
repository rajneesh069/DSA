package leetcode;

public class $108_ConvertSortedArrayIntoBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode root;

    public TreeNode sortedArrayToBST(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            root = insert(root, nums[i]);
        }
        return root;
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        }

        if (val > root.val) {
            root.right = insert(root.right, val);
        }

        return rotate(root);
    }

    private TreeNode rotate(TreeNode root) {

        if (height(root.left) - height(root.right) > 1) {
            // left heavy tree

            if (height(root.left.left) - height(root.left.right) > 0) {
                // left-left heavy tree
                root = rightRotate(root);

            }
            if (height(root.left.right) - height(root.left.left) > 0) {
                // left-right heavy tree
                leftRotate(root.left);
                root = rightRotate(root);
            }

        }

        if (height(root.left) - height(root.right) < -1) {
            // right heavy tree
            if (height(root.right.right) - height(root.right.left) > 0) {
                // right-right heavy tree
                root = leftRotate(root);
            }
            if (height(root.right.left) - height(root.right.right) > 0) {
                // right-left heavy tree
                rightRotate(root.right);
                root = leftRotate(root);
            }

        }

        return root;
    }

    private TreeNode rightRotate(TreeNode p) {
        TreeNode c = p.left;
        TreeNode t = c.right;

        c.right = p;
        p.left = t;

        return c;
    }

    private TreeNode leftRotate(TreeNode c) {
        TreeNode p = c.right;
        TreeNode t = p.left;

        p.left = c;
        c.right = t;

        return p;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
