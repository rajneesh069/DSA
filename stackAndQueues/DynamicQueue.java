package stackAndQueues;

public class DynamicQueue {
    public static void main(String[] args) {
        DynamicQueue queue = new DynamicQueue();

        queue.add(1);
        queue.add(2);
        queue.display();

        queue.remove();
        queue.display();
    }

    private int[] data;
    private int first = 0;
    private int last = 0;
    private int size = 0;
    private static final int DEFAULT_SIZE = 10;

    public DynamicQueue() {
        this(DEFAULT_SIZE);
    }

    public DynamicQueue(int initialSize) {
        this.data = new int[initialSize];
    }

    private boolean isFull() {
        return size == data.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean resize() {
        int[] temp = new int[2 * data.length];
        for (int i = first; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
        return true;
    }

    public boolean add(int value) {
        if (isFull()) {
            resize();
        }
        data[this.last] = value;
        last = last + 1;
        this.size++;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Cannot remove from an empty queue.");
            return -1;
        }

        int value = data[this.first];
        first = first + 1;
        this.size--;
        return value;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        for (int i = first; i < last; i++) {
            System.out.print(data[i] + " -> ");
        }
        System.out.print("END\n");
    }
}
