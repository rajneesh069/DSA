package linkedList;

public class DoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(0, 0);
        list.add(1);
        list.display();
    }

    private class Node {
        private int value;
        private Node next = null;
        private Node previous = null;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        this.size++;
        if (head == null) { // for the first node, we don't need to update the head ever
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.previous = tail;
        tail.next = newNode;
        tail = newNode;
    }

    public void insertFirst(int value) {
        Node newNode = new Node(value);
        this.size++;
        if (tail == null) { // for the first node, we don't need to update the tail ever again
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        head.previous = newNode;
        head = newNode;

    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL\n");
        System.out.println("Size: " + this.size);
        return;
    }

    public void displayInverted() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.previous;
        }
        System.out.print("NULL\n");
        System.out.println("Size: " + this.size);
    }

    public Node getNodeAtIndex(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Cannot be deleted. Index out of bounds.");
            return;
        }

        this.size--; // size is at least 1
        Node nodeToBeDeleted = getNodeAtIndex(index);

        if (nodeToBeDeleted == head) {
            if (head.next != null) { // head.next will be null if there's only one element
                head = head.next;
                head.previous = null;
            } else {
                head = null;
                tail = null;
            }
            return;
        } else if (nodeToBeDeleted == tail) {
            if (tail.previous != null) {
                tail = tail.previous;
                tail.next = null;
            } else { // tail.previous will be null if and only there's one element
                head = null;
                tail = null;
            }
            return;
        }

        nodeToBeDeleted.previous.next = nodeToBeDeleted.next;
        nodeToBeDeleted.next.previous = nodeToBeDeleted.previous;
    }

    public void insert(int value, int index) {
        if (index < 0) {
            System.out.println("Index out of bounds.");
            return;
        }
        Node newNode = new Node(value);
        Node nodeAtThatIndex = getNodeAtIndex(index);
        if (nodeAtThatIndex != null && nodeAtThatIndex == head) {
            this.size++;
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
            head.previous = null;
        } else if (nodeAtThatIndex != null && nodeAtThatIndex != tail) {
            this.size++;
            newNode.previous = nodeAtThatIndex;
            newNode.next = nodeAtThatIndex.next;
            nodeAtThatIndex.next.previous = newNode;
            nodeAtThatIndex.next = newNode;
        } else {
            this.add(value);
            return;
        }
    }

}
