package binaryTrees;

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

    private Node findNode(Node root, Node node) {
        if (root == null) {
            return null;
        }

        if(root == node){
            return node;
        }

        
    }

}
