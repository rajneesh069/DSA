package stackAndQueues;

public class DynamicCircularQueue {
    public static void main(String[] args) {
        DynamicCircularQueue queue = new DynamicCircularQueue();
        for (int i = 0; i < 20; i++) {
            queue.add(i);
        }
        queue.remove();
        queue.display();
    }

    private int[] data;
    private int size;
    private int first;
    private int last;
    private final static int DEFAULT_SIZE = 10;

    public DynamicCircularQueue() {
        this(DEFAULT_SIZE);
    }

    public DynamicCircularQueue(int initialSize) {
        this.data = new int[initialSize];
    }

    private boolean resize() {
        int[] temp = new int[data.length * 2];
        int i = 0;
        do {
            temp[i] = data[(first + i) % data.length];
            ++i;
        } while (i != data.length);
        first = 0;
        last = data.length;
        data = temp;
        return true;
    }

    private boolean isFull() {
        return size == data.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public boolean add(int value) {
        if (isFull()) {
            resize();
        }
        data[last] = value;
        last = (last + 1) % data.length;
        this.size++;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Cannot remove from an empty queue.");
            return -1;
        }

        int value = data[first];
        first = (first + 1) % data.length;
        this.size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Cannot peak in an empty queue.");
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
}
