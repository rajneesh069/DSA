package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class FindNode {
    // Program to find a node in Binary Tree

    public static void main(String[] args) {

    }

    private class Node {
        private int value;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    private Node findNodeByValue(Node root, int val) {
        if (root == null) {
            return null;
        }

        if (root.value == val) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if (currentNode.value == val) {
                    return currentNode;
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return null;
    }

    private Node findNode(Node root, Node target) {
        if (root == null) {
            return null;
        }

        if (root == target) {
            return target;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if (currentNode == target) {
                    return target;
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return null;
    }

}
