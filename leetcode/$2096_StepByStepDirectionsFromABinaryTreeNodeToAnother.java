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

    String s1 = "";
    String s2 = "";

    public String getDirections(TreeNode root, int startValue, int destValue) {
        String s = "";
        traverse(root, startValue, s1); // s1 -> start
        traverse(root, destValue, s2); // s2 -> destination
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        // same path
        if (s1.length() > s2.length()) {
            StringBuilder finalPath = new StringBuilder("");
            if (s1.startsWith(s2)) {
                while (!s2.isEmpty()) {
                    finalPath.append("U");
                    s2.substring(1);
                }
                return finalPath.toString();
            }
        } else if (s1.length() < s2.length()) {
            if (s2.startsWith(s1)) {
                s = s2.substring(s1.length());
                return s;
            }
        }
        // different path

        // 1. same subtree
        if (s1.charAt(0) == s2.charAt(0)) {
            StringBuilder finalPath = new StringBuilder("");
            s1 = s1.substring(1);
            s2 = s2.substring(1);
            while (!s1.isEmpty()) {
                finalPath.append("U");
                s.substring(1);
            }
            finalPath.append(s2);
            return finalPath.toString();
        }

        // 2. different subtree
        if (s1.charAt(0) != s2.charAt(0)) {
            StringBuilder finalPath = new StringBuilder("");
            while (!s1.isEmpty()) {
                finalPath = finalPath.append("U");
                s1.substring(1);
            }
            finalPath = finalPath.append(s2);
            return finalPath.toString();
        }
        return s;
    }

    private void traverse(TreeNode root, int value, String s) {
        if (root == null) {
            return;
        }

        if (root.val == value) {
            if (s1.isEmpty()) {
                s1 = s;
            } else if (s2.isEmpty()) {
                s2 = s;
            }
            return;
        }

        traverse(root.left, value, s + ("L"));
        traverse(root.right, value, s + ("R"));
    }
}
