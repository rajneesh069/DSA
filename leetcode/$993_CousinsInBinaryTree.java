package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class $993_CousinsInBinaryTree {

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

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        boolean foundX = false;
        boolean foundY = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevelNodes = new ArrayList<Integer>();
            for (int i = 0; i < levelSize; i++) {
                foundX = false;
                foundY = false;
                TreeNode currentNode = queue.poll();
                currentLevelNodes.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                    if (currentNode.left.val == x) {
                        foundX = true;
                    }
                    if (currentNode.left.val == y) {
                        foundY = true;
                    }
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);

                    if (currentNode.right.val == x) {
                        foundX = true;
                    }
                    if (currentNode.right.val == y) {
                        foundY = true;
                    }
                }

                if (foundX && foundY) {
                    return false;
                }

            }

            foundX = binarySearch(currentLevelNodes, x);
            foundY = binarySearch(currentLevelNodes, y);
            System.out.println(foundX + " "+ foundY);
            System.out.println(currentLevelNodes);
            if(foundX && foundY){
                return true;
            }
        }

        return (foundX & foundY);
    }

    public static boolean binarySearch(List<Integer> currentLevelNodes, int target) {
        for(int i=0; i<currentLevelNodes.size(); i++){
            if(currentLevelNodes.get(i)==target){
                return true;
            }
        }
        return false;
    }

}
