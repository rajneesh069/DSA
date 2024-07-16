package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")

public class IsSibling {
    // We'll find if the nodes of a binary tree are siblings.

    private class Node {
        private int value;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    private boolean isSibling(Node root, int x, int y) {

        if (root == null) {
            return false;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        boolean foundX = false;
        boolean foundY = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                // in each iteration, we are looking at the node itself
                foundX = false;
                foundY = false;
                Node currentNode = queue.poll();

                // Sibling check
                if (currentNode.left != null && currentNode.right != null) {
                    if ((currentNode.left.value == x && currentNode.right.value == y) ||
                            (currentNode.left.value == y && currentNode.right.value == x)) {
                        return true;
                    }
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

            }
        }
        return false;
    }
}
