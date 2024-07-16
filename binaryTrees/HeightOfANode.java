package binaryTrees;

@SuppressWarnings("unused")
public class HeightOfANode {
    private class Node {
        private int value;
        private Node left;
        private Node right;
    }

    private Node root;

    private int height(Node node) {
        if (node == null) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        return Math.max(left, right) + 1;

    }
}
