package linkedList;

public class SinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        // list.insertFirst(1);
        // list.insertFirst(2);
        // list.insertFirst(3);
        // list.insertFirst(4);

        list.add(1); // index = 0
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(6); // index = 5
        list.add(4, 3);
        list.delete(5);
        list.display();
        System.out.println(list.find(3));
    }

    private class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }

    }

    private Node head; // head is initially null
    private Node tail; // tail is initially null
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    public void add(int value) { // 18 -> 7
        Node newNode = new Node(value);
        this.size += 1;
        if (head == null) {
            head = newNode;
            tail = head;
            return; // neat way of initializing the first node
        }
        tail.next = newNode;
        tail = newNode;

    }

    public void add(int value, int index) {
        Node node = new Node(value);
        Node temp = head;
        this.size++;
        if (index == 0) {
            node.next = head;
            head = node;
            return;
        }

        else if (index == size) {
            tail.next = node;
            tail = node;
            return;
        }
        for (int i = 0; i < index; i++) {
            if (i == index - 1) {
                Node preserveNextNode = temp.next;
                temp.next = node;
                node.next = preserveNextNode;
                break;
            }
            temp = temp.next;
        }
    }

    public void delete(int index) {
        this.size--;
        if (index == 0) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            if (i == index - 1) {
                Node node = temp.next;
                temp.next = node.next;
                return;
            }
            temp = temp.next;
        }
        if (head == null) {
            tail = null;
        }
    }

    public Node nodeAtIndex(int index) { // a utility function for getting node at a particular index
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void insertFirst(int value) {
        Node newNode = new Node(value);
        this.size += 1;
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
    }

    public Node find(int value) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
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