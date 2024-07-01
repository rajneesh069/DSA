package binaryTrees;

import java.util.Scanner;

public class BinaryTree {
    private Node root; // intially null

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

    }

    public void populate(Scanner scanner) {
        System.out.println("Input the value of root node: ");
        root = new Node(scanner.nextInt());
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.print("Do you want to add a left node to  " + node.value + ": ");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.print("Enter the value of the left node: ");
            int val = scanner.nextInt();
            node.left = new Node(val);
            populate(scanner, node.left);
        }

        System.out.print("Do you want to add a right node to " + node.value + ": ");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.print("Enter the value of the right node: ");
            int val = scanner.nextInt();
            node.right = new Node(val);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(this.root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, "\t");
        display(node.right, "\t");
    }

}
