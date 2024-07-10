package javaPlayground;

public class j6 {
    public static void main(String[] args) {
        j6 SLL = new j6();
        for (int i = 0; i < 10; i++) {
            SLL.insertFirst(i);
        }
        SLL.display();
        int deletedValue = SLL.delete(2);
        System.out.println("The deleted value is: " + deletedValue);
        SLL.display();
        SLL.insertAfter(1, deletedValue);
        SLL.display();
    }

    private class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(int value) {
        tail = add(head, value);
    }

    private Node add(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            head = newNode;
            this.size++;
            return newNode;
        }

        Node newNode = new Node(value);
        tail.next = newNode;
        this.size++;
        return newNode;
    }

    public void insertFirst(int value) {
        head = insertFirst(tail, value);
    }

    private Node insertFirst(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            tail = newNode;
            this.size++;
            return newNode;
        }

        Node newNode = new Node(value);
        newNode.next = head;
        this.size++;
        return newNode;
    }

    public int delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds for deletion.");
            return -1;
        }
        if (index == 0) {
            int value = head.value;
            head = head.next;
            this.size--;
            return value;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        if (temp.next != null) {
            int value = temp.next.value;
            temp.next = temp.next.next;
            this.size--;
            return value;
        } else {
            System.out.println("Cannot delete null value.");
            return -1;
        }
    }

    public void insertAfter(int index, int value) {
        if (head == null) {
            this.add(value);
            return;
        } else if (index < 0 || index >= size) {
            System.out.println("Out of bounds.");
            return;
        } else if (index == size - 1) {
            this.add(value);
            this.size++;
            return;
        }

        // for indices between 0(included) and size(excluded)
        Node temp = head;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;
        this.size++;
        return;
    }

    public void display() {
        display(head);
    }

    private void display(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END\n");
        System.out.println("Size: " + size);
    }
}
