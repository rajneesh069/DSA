package stackAndQueues;

public class CircularQueue {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        queue.remove();
        queue.add(99);
        queue.display();
        // for (int i = 0; i < 10; i++) {
        // System.out.println(queue.remove());
        // }
    }

    private int first = 0;
    private int last = 0;
    private int[] data;
    private int size;
    private final static int DEFAULT_SIZE = 10;

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean add(int value) {
        if (isFull()) {
            System.out.println("Cannot add to a full circular queue.");
            return false;
        }
        data[last] = value;
        this.last = this.last + 1;
        this.last = (this.last) % data.length;
        this.size++;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Cannot remove from an empty circular queue.");
            return -1;
        }
        int value = data[this.first];
        this.first = this.first + 1;
        this.first = (this.first) % data.length;
        this.size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Cannot peek in an empty circular queue.");
            return -1;
        }
        return data[first];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        int i = first;
        do {
            System.out.print(data[i] + " -> ");
            i = (i + 1) % data.length;
        } while (i != last);
        System.out.print("END");
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == data.length;
    }
}
