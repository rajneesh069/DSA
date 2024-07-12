package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("unused")
public class $103_BinaryTreeZigZagLevelOrderTraversal {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root); // left to right once done
        boolean reverse = true;

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> currentLevelList = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                // TreeNode currentNode = queue.poll(); // keep it here in original BFS, as we
                // have to extract the node each time

                if (reverse) {
                    TreeNode currentNode = deque.removeLast();
                    currentLevelList.add(currentNode.val);
                    if (currentNode.left != null) {
                        deque.addFirst(currentNode.left);
                    }

                    if (currentNode.right != null) {
                        deque.addFirst(currentNode.right);
                    }
                } else {
                    TreeNode currentNode = deque.removeFirst();
                    currentLevelList.add(currentNode.val);
                    if (currentNode.right != null) {
                        deque.addLast(currentNode.right);
                    }

                    if (currentNode.left != null) {
                        deque.addLast(currentNode.left);
                    }
                }

            }
            result.add(currentLevelList);
            if (reverse == true) {
                reverse = false;
            } else {
                reverse = true;
            }
        }

        return result;
    }
}
