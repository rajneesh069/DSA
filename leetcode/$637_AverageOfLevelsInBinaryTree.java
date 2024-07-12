package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unused")
public class $637_AverageOfLevelsInBinaryTree {
    private class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        private TreeNode(int value) {
            this.value = value;
        }
    }

    private TreeNode root;

    private List<Double> BFSTraversal() {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>(); // to maintain the order of the nodes that needs to be explored and
        // keep track of current level nodes to be processed.
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double averageLevel = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                averageLevel += currentNode.value;
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add((averageLevel) / (levelSize));
        }

        return result;
    }
}
