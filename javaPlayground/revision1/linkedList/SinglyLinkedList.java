package javaPlayground.revision1.linkedList;

public class SinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        list.display();
    }

    private class Node {
        private int val;
        private Node next;

        private Node(int val) {
            this.val = val;
        }
    }

    private Node head = null;
    private int size = 0;

    public void add(int val) {
        head = add(head, val);
    }

    private Node add(Node head, int val) {
        if (head == null) {
            Node newNode = new Node(val);
            this.size++;
            head = newNode;
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            /*
             * we need to stop right at the tail when temp = tail,
             * hence temp.next!=null.
             */
            temp = temp.next;
        }
        Node newNode = new Node(val);
        temp.next = newNode;
        newNode.next = null;
        this.size++;
        return head;
    }

    public void display() {
        display(head);
    }

    private void display(Node head) {
        if (head == null) {
            System.out.println("Linkedlist is empty." + " Size: " + this.size);
            return;
        }
        Node temp = head;
        while (temp != null) {
            /*
             * this loop prints the value hence it needs to run for the tail
             * but it will stop at tail and come out as temp = tail,
             * and since we need it to run for the tail to print its value,
             * hence temp!=null condition is there.
             */
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL\n");
        System.out.println("Size: " + this.size);
    }

    public void insertAfter(int index, int val) {
        head = insertAfter(head, index, val);
    }

    private Node insertAfter(Node head, int index, int val) {
        if (head == null) {
            System.out.println("Linked list is empty. Consider adding an element first.");
            return null;
        } else if (index < 0 && index >= size) {
            System.out.println("Index out of bounds.");
            return head;
        } else if (index == size) {
            head = add(head, val);
            this.size++;
            return head;
        }

        Node newNode = new Node(val);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        this.size++;
        return head;
    }

    public void remove(int index) {
        head = remove(head, index);
    }

    private Node remove(Node head, int index) {
        if (head == null) {
            System.out.println("Linked list is empty, cannot remove.");
            return null;
        } else if (index < 0 || index >= size) {
            System.out.println("Invalid index, cannot remove.");
            return head;
        } else if (index == 0) {
            head = head.next;
            this.size--;
            return head;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        this.size--;
        return head;
    }
}
