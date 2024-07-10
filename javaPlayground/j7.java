package javaPlayground;

public class j7 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        j7 DLL = new j7();
        for (int i = 0; i < arr.length; i++) {
            DLL.add(arr[i]);
        }
        DLL.display();
        DLL.insertAfter(-1, 10);
        DLL.display();
    }

    private class Node {
        private int value;
        private Node next;
        private Node previous;

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
            Node headNode = new Node(value);
            head = headNode;
            this.size++;
            return headNode;
        }

        Node newNode = new Node(value);
        tail.next = newNode;
        newNode.previous = tail;
        this.size++;
        return newNode;
    }

    public void insertFirst(int value) {
        head = insertFirst(tail, value);
    }

    private Node insertFirst(Node node, int value) {
        if (node == null) {
            Node tailNode = new Node(value);
            tail = tailNode;
            this.size++;
            return tailNode;
        }
        Node newNode = new Node(value);
        newNode.next = head;
        head.previous = newNode;
        this.size++;
        return newNode;
    }

    public void insertAfter(int index, int value) {
        if (head == null) {
            this.add(value);
        } else if (index == size - 1) {
            this.add(value);
            this.size++;
        } else {
            Node temp = head;
            Node newNode = new Node(value);
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next.previous = newNode;
            temp.next = newNode;
            newNode.previous = temp;
            this.size++;
        }
    }

    public void delete(int index) {
        if (head == null) {
            System.out.println("Cannot delete from empty linked list.");
            return;
        } else if (index < 0 || index >= size) {
            System.out.println("Index out of bounds. Cannot delete.");
            return;
        } else if (index == 0) {
            head = head.next;
            head.previous = null;
            this.size--;
            return;
        } else if (index == size - 1) {
            tail = tail.previous;
            tail.next = null;
            this.size--;
            return;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            temp.next.previous = temp;
            this.size--;
            return;
        } else {
            System.out.println("Cannot delete.");
        }

    }

    public void display() {
        display(head);
    }

    private void display(Node node) {
        if (node == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END\n");
        System.out.println("Size: " + size);
    }

}
