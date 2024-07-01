package binaryTrees;

public class Main {
    public static void main(String[] args) {
        // BinaryTree tree = new BinaryTree();
        // Scanner scanner = new Scanner(System.in);
        // tree.populate(scanner);
        // tree.display();
        int[] nums = { 5, 7, 2, 9, 3, 22 };

        BST bst = new BST();
        bst.populate(nums);
        bst.display();
    }
}
