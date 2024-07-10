package binaryTrees;

public class Main {
    public static void main(String[] args) {
        // BinaryTree tree = new BinaryTree();
        // Scanner scanner = new Scanner(System.in);
        // tree.populate(scanner);
        // tree.display();
        int[] arr = { 1, 2, 3, 43, 22, 99, 5 };

        // BST bst = new BST();
        // bst.populateSorted(nums, 0, nums.length);
        // bst.display();

        AVL tree = new AVL();
        tree.populate(arr);
        tree.display();
    }
}
