package leetcode;

public class $2096_StepByStepDirectionsFromABinaryTreeNodeToAnother {
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

    StringBuilder s = new StringBuilder(""), d = new StringBuilder("");

    public String getDirections(TreeNode root, int startValue, int destValue) {
        traverse(root, startValue, s); // s -> start
        traverse(root, destValue, d); // d -> destination
        int i = 0;
        // Find the common path prefix length
        while (i < s.length() && i < d.length() && s.charAt(i) == d.charAt(i)) {
            i++;
        }

        // Number of steps to move up from the start node to the common ancestor
        StringBuilder finalPath = new StringBuilder();
        for (int j = i; j < s.length(); j++) {
            finalPath.append('U');
        }

        // Append remaining path to the destination node
        finalPath.append(d.substring(i));

        return finalPath.toString();
    }

    private boolean traverse(TreeNode root, int value, StringBuilder path) {
        // Optimize traversal by stopping it the moment value is found!!
        if (root == null) {
            return false;
        }

        if (root.val == value) {
            return true;
        }

        path.append("L");
        if (traverse(root.left, value, path)) {
            return true;
        }

        path.setLength(path.length() - 1);

        path.append("R");
        if (traverse(root.right, value, path)) {
            return true;
        }
        path.setLength(path.length() - 1);
        return false;
    }
}
