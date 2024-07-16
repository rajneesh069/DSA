package leetcode;

@SuppressWarnings("unused")
public class $543_DiameterOfBinaryTree {
    private class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }

    int diameter = 0;

    public int diameter(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
