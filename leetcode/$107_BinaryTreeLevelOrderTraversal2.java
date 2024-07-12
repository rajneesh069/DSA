package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class $107_BinaryTreeLevelOrderTraversal2 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> currentLevelList = new ArrayList<Integer>(levelSize);
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();
                    currentLevelList.add(currentNode.val);
                    if (currentNode.left != null) {
                        queue.offer(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.offer(currentNode.right);
                    }
                }
                result.add(currentLevelList);
                // result.add(0, currentLevelList); -> this, and don't reverse the list then
            }

            return result.reversed();
        }
    }
}
