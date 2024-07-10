package leetcode;


public class $21_MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
    }

    private class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }

        private Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private int size;

    public void add(int value) {
        if (head == null) {
            Node newNode = new Node(value);
            head = newNode;
            this.size++;
            return;
        }
        Node temp = head;
        Node newNode = new Node(value);
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = null;
        this.size++;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END\n");
        System.out.println("Size: " + this.size);
    }
}

