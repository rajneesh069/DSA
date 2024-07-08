package practice;

public class SLL {
    public static void main(String[] args) {
        SLL list = new SLL();
        int[] array = { 1, 2, 3, 4, 5 };
        list.addRecursively(array);
        list.insert(22, 3);
        list.display();
    }

    private class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public SLL() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            this.size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        this.size++;
        // newNode.next = null;
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

    public void insertFirst(int value) {
        Node newNode = new Node(value);
        if (tail == null) {
            tail = newNode;
            head = newNode;
            this.size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        this.size++;
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

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds, node doesn't exist.");
            return null;
        }
        Node temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return temp;
    }

    public void delete(int index) {
        Node nodeAtThatIndex = getNode(index);
        Node nodeBeforeThatIndex = getNode(index - 1);
        if (nodeAtThatIndex == head) {
            if (head.next != null) {
                head = head.next;
            } else {
                head = null;
                tail = null;
            }
        } else if (nodeAtThatIndex != null && nodeBeforeThatIndex != null && nodeAtThatIndex.next != null) {
            nodeBeforeThatIndex.next = nodeAtThatIndex.next;
        } else if (nodeAtThatIndex == tail) {
            tail = nodeBeforeThatIndex;
            tail.next = null;
        } else {
            System.out.println("Cannot delete element.");
            return;
        }
        this.size--;
    }

    public void display() {
        Node temp = head;
        if (temp == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END\n");
        System.out.println("Size : " + this.size);
    }

}
