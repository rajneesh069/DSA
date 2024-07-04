package linkedList;

public class SinglyLinkedList {
    private class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }

        private Node(int value, Node next) {
            this.next = next;
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    public SinglyLinkedList(){
        this.size = 0;
    }
}
