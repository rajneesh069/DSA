package javaPlayground.playground;

public class j8 {
    public static void main(String[] args) {
        j8 CLL = new j8();
        for (int i = 0; i < 10; i++) {
            CLL.add(i);
        }
        CLL.display();
        CLL.insertAfter(9, 33);
        CLL.display();
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

    /*
     * To reach the node just before the head
     * Node temp = head;
     * do{
     * temp = temp.next;
     * }while(temp.next!=head);
     * Now temp, just before head and obviously since temp.next == head, hence for
     * that last node the do{} block won't run obviously.
     */

    public void add(int value) {
        if (head == null) {
            Node headNode = new Node(value);
            head = headNode;
            headNode.next = head;
            this.size++;
            return;
        }

        Node newNode = new Node(value);
        Node temp = head;
        do {
            temp = temp.next;
        } while (temp.next != head);
        temp.next = newNode;
        newNode.next = head;
        this.size++;
        return;
    }

    public void insertFirst(int value) {
        if (head == null) {
            Node headNode = new Node(value);
            head = headNode;
            headNode.next = head;
            this.size++;
            return;
        }

        Node temp = head;
        Node newNode = new Node(value);
        newNode.next = head;

        do {
            temp = temp.next;
        } while (temp.next != head);

        temp.next = newNode;
        head = newNode;
        this.size++;
    }

    public void insertAfter(int index, int value) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds, cannot insert.");
            return;
        } else if (index == size - 1) {
            this.add(value);
            this.size++;
        } else {
            Node newNode = new Node(value);
            Node temp = head;
            int i = 0;
            do {
                temp = temp.next;
                i++;
            } while (temp.next != head && i < index);
            newNode.next = temp.next;
            temp.next = newNode;
            this.size++;
            return;
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
        do {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        } while (temp != head); // keep this in mind, we have to go till head
        System.out.print("HEAD\n");
        System.out.println("Size: " + size);
    }

}
