package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class $116_PopulatingNextRightPointersInEachNode {
    // given -> perfect binary tree
    private class Node {
        private int val;
        private Node left;
        private Node right;
        private Node next;
    }

    private Node root;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();

                currentNode.next = queue.peek();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                if (i == levelSize - 1) {
                    currentNode.next = null;
                }
            }
        }
        return root;
    }

}
