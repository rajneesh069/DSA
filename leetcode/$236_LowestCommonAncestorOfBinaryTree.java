package leetcode;

public class $236_LowestCommonAncestorOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        StringBuilder pPath = new StringBuilder(""), qPath = new StringBuilder("");
        traverseFromRootToNode(root, p, pPath);
        traverseFromRootToNode(root, q, qPath);
        TreeNode LCA = root;
        int i = 0;
        while (i < pPath.length() && i < qPath.length() && pPath.charAt(i) == qPath.charAt(i)) {
            if (pPath.charAt(i) == 'L') {
                LCA = LCA.left;
            } else if (pPath.charAt(i) == 'R') {
                LCA = LCA.right;
            }
            i++;
        }
        return LCA;
    }

    public boolean traverseFromRootToNode(TreeNode root, TreeNode node, StringBuilder path) {
        if (root == null) {
            return false;
        }
        if (node == root) {
            return true;
        }

        path.append("L");
        if (traverseFromRootToNode(root.left, node, path)) {
            return true;
        }
        path.setLength(path.length() - 1);

        path.append("R");
        if (traverseFromRootToNode(root.right, node, path)) {
            return true;
        }
        path.setLength(path.length() - 1);
        return false;
    }

    // Optimized Way
}
