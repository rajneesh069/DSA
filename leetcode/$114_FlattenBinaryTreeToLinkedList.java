package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class $114_FlattenBinaryTreeToLinkedList {
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

    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode head = null;
    TreeNode tail = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        fillQueue(queue, root);
        while(!queue.isEmpty()){
        TreeNode currentNode = queue.poll();
        currentNode.left = null;
        currentNode.right = queue.peek();
        }
    }

    public void fillQueue(Queue<TreeNode> queue, TreeNode node) {
        if(node==null){
            return;
        }
        queue.offer(node);
        fillQueue(queue,node.left);
        fillQueue(queue,node.right);
    }
}
