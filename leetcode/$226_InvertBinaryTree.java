package leetcode;

@SuppressWarnings("unused")
public class $226_InvertBinaryTree {

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

    public TreeNode invertTree(TreeNode node) {
        if (node == null) {
            return node;
        }

        if (node.left == null && node.right == null) {
            return node;
        }

        invertTree(node.left);
        invertTree(node.right);
        return swap(node);
    }

    private TreeNode swap(TreeNode x) {
        TreeNode temp = x.left;
        x.left = x.right;
        x.right = temp;
        return x;
    }
}
