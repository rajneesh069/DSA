package binaryTrees;

@SuppressWarnings("unused")
public class LevelOfNodes {
    // We'll find the level of nodes.
    private class Node {
        private int value;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    private int findLevel(Node node, Node x, int level) {
        if (root == null) {
            return -1;
        }

        if (node == null) {
            return 0;
        }

        if (node == x) {
            return level;
        }

        int left = findLevel(node.left, x, level + 1);
        if (left != 0) {
            return left;
        }
        return findLevel(node.right, x, level + 1);

    }
}
