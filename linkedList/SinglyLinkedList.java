package linkedList;

public class SinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        int[] array = { 1, 2, 3, 4, 5 };
        list.addRecursively(array);
        list.display();
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

    // add using recursion
    public void addRecursively(int[] array) {
        for (int i = 0; i < array.length; i++) {
            head = addRecursively(head, array[i]);
        }
    }

    private Node addRecursively(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            newNode.next = null;
            this.size++;
            return newNode;
        }

        node.next = addRecursively(node.next, value);
        tail = node;
        return node;
    }

    // insert with recursion
    public void insert(int value, int index) {
        head = insert(head, value, index);
    }

    private Node insert(Node node, int value, int index) {
        if (index == 0) {
            Node newNode = new Node(value);
            newNode.next = node.next;
            this.size++;
            return newNode;
        }
        node.next = insert(node.next, value, index - 1);
        return node;
    }

}