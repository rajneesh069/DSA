package leetcode;

public class $98_ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        return traverseAndValidate(root, null, null);
    }

    private boolean traverseAndValidate(TreeNode node, Integer high, Integer low) {
        if (node == null) {
            return true;
        }

        boolean left = true;
        boolean right = true;

        if (node.left != null) {
            if ( node.left.val < node.val && node.left.val < high) {
                left = traverseAndValidate(node.left, node.val, null);
            } else if (node.left.val > node.val) {
                return false;
            }
        }

        if (left == false) {
            return false;
        }

        if (node.right != null) {
            if (node.right.val > node.val && node.right.val > low) {
                right = traverseAndValidate(node.right, null, node.val);
            } else if (node.right.val < node.val) {
                return false;
            }
        }

        if (right == false) {
            return false;
        }

        return left && right;
    }
}
