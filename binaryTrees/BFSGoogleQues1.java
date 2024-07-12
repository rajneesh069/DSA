package binaryTrees;

import java.util.*;

@SuppressWarnings("unused")
public class BFSGoogleQues1 {
    private class Node {
        private int value;
        private Node left;
        private Node right;
    }

    private Node root;

    // BFS algo
    private List<List<Integer>> BFS(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Node currentNode = queue.poll();
            List<Integer> currentLevelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                currentLevelList.add(currentNode.value);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevelList);
        }

        return result;
    }

    /*
     * Modification in the algo for the question to find the right
     * neighbour/successor
     */

    private int RightSuccessor(Node root, int nodeVal) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return -1;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Node currentNode = queue.poll();
            List<Integer> currentLevelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                currentLevelList.add(currentNode.value);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.addAll(currentLevelList);
        }

        // Binary Search to find that node
        int start = 0;
        int end = result.size();
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (result.get(mid) == nodeVal) {
                ans = mid;
            } else if (result.get(mid) > nodeVal) {
                end = mid - 1;
            } else if (result.get(mid) < nodeVal) {
                start = mid + 1;
            }
        }
        // return the right neighbour
        return ans + 1 == 0 ? -1 : ans + 1;
    }

    private Node findSuccessor(Node root, int key) {

        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Node currentNode = queue.poll();
            List<Integer> currentLevelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                currentLevelList.add(currentNode.value);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            if (currentNode.value == key) {
                break;
            }
        }
        return queue.peek();

    }
}
