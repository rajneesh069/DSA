package stackAndQueues;

public class Queue {
    public static void main(String[] args) {
        Queue queue = new Queue();
        for (int i = 0; i < 15; i++) {
            queue.add(i);
        }
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }

    private int[] data;
    private int first = 0;
    private int current = -1;
    private static final int DEFAULT_SIZE = 10;

    public Queue() {
        this(DEFAULT_SIZE);
    }

    public Queue(int size) {
        this.data = new int[size];
    }

    public boolean add(int value) {
        if (isFull()) {
            System.out.println("Cannot add to a full queue.");
            return false;
        }
        data[++this.current] = value;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Cannot remove from an empty queue.");
            return -1;
        }
        return data[this.first++];
    }

    private boolean isFull() {
        return this.current == data.length - 1;
    }

    private boolean isEmpty() {
        return this.current == -1;
    }

}
