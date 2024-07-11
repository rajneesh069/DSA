package stackAndQueues;

import java.util.Arrays;

public class QueueWithOnePointer {
    public static void main(String[] args) {
        QueueWithOnePointer queue = new QueueWithOnePointer();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        queue.remove();
        queue.remove();
        queue.display();
    }

    private int ptr = -1;
    private int[] data;
    private static final int DEFAULT_SIZE = 10;

    public QueueWithOnePointer() {
        this(DEFAULT_SIZE);
    }

    public QueueWithOnePointer(int size) {
        this.data = new int[size];
    }

    public boolean add(int value) {
        if (isFull()) {
            System.out.println("Cannot add to a full queue.");
            return false;
        }
        data[++ptr] = value;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Cannot remove from an empty queue.");
            return -1;
        }
        int deletedValue = data[0];
        for (int i = 0; i < data.length - 1; i++) { // left shifting the array by 1
            data[i] = data[i + 1];
        }
        this.ptr--;
        return deletedValue;
    }

    public void display() {
        for (int i = 0; i <= ptr; i++) {
            System.out.print(data[i] + " <-\s");
        }
        System.out.print("END");
    }

    private boolean isEmpty() {
        return ptr == -1;
    }

    private boolean isFull() {
        return ptr == data.length - 1;
    }
}
