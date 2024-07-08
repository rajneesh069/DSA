package linkedList;

public class CircularLinkedList {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.delete(3);
        list.display();
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

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        this.size++;

        if (head == null) {
            tail = newNode;
            head = newNode;
            newNode.next = head;
            return;
        }

        tail.next = newNode;
        newNode.next = head;
        tail = newNode;

    }

    private Node getNode(int index) {
        Node temp = head;
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds. Node doesn't exist.");
            return null;
        } else if (index == 0) {
            return head;
        }

        do {
            temp = temp.next;
            index--;
        } while (index > 0 && temp != null);

        return temp;
    }

    public void insertAfter(int value, int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds. Cannot insert.");
            return;
        }
        this.size++;
        Node nodeAtThatIndex = getNode(index);
        Node newNode = new Node(value);
        newNode.next = nodeAtThatIndex.next;
        nodeAtThatIndex.next = newNode;
    }

    public void delete(int value) {
        Node temp = head;
        if (temp == null) {
            System.out.println("Cannot delete as linked list is empty.");
            return;
        }

        if (head.value == value) {
            if (head.next != null) {
                tail.next = head.next;
                head = head.next;
                this.size--;
            } else {
                this.size--;
                head = null;
                tail = null;
            }
            return;
        }

        int index = 0;
        do {
            temp = temp.next;
            index++;
        } while (temp.value != value && temp != head && temp != null);

        Node nodeBeforeTheNodeThatWillBeDeleted = getNode(index - 1);
        nodeBeforeTheNodeThatWillBeDeleted.next = temp.next;
        this.size--;
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        } while (temp != head && temp != null);
        System.out.print("HEAD\n");
        System.out.println("Size : " + this.size);
    }

}
