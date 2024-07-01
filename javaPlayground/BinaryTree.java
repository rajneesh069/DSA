package javaPlayground;

import java.util.Scanner;

public class BinaryTree {

    private Node root;

    private class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public void populate(Scanner scanner) {
        System.out.print("Enter the value of root node: ");
        root = new Node(scanner.nextInt());
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.print("Do you want to add a left node to " + node.value + ": ");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.print("Enter the value of left node: ");
            node.left = new Node(scanner.nextInt());
            populate(scanner, node.left);
        }
        System.out.print("Do you want to add a right node to " + node.value + ": ");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.print("Enter the value of right node: ");
            node.right = new Node(scanner.nextInt());
            populate(scanner, node.right);
        }
    }

    public void display() {
        prettyDisplay(root, 0);
    }

    @SuppressWarnings("unused")
    private void display(String indent, Node node) {
        if (node == null) {
            return;
        }

        System.out.println(indent + node.value);
        display("\t", node.left);
        display("\t", node.right);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|--------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        binaryTree.populate(scanner);
        binaryTree.display();
    }
}
