package leetcode;

public class $83_RemoveDuplicatesFromList {
    public static void main(String[] args) {
        int[] array = { 1, 1, 1, 2, 2, 2, 3, 4, 4, 5 };
        $83_RemoveDuplicatesFromList list = new $83_RemoveDuplicatesFromList();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        list.removeDuplicate();
        list.display();
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

    public void removeDuplicate() {
        if (head == null) {
            return;
        }
        head = removeDuplicates(head);
    }

    private Node removeDuplicates(Node head) {
        Node node = head;
        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                this.size--;
            } else {
                node = node.next;
            }
        }
        return node;
    }

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
