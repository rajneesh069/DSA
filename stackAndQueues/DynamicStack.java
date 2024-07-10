package stackAndQueues;

public class DynamicStack {
    public static void main(String[] args) {
        DynamicStack stack = new DynamicStack();
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        System.out.println(stack.peek());

    }

    private int top = -1;
    private static final int DEFAULT_SIZE = 10;
    private int[] data;

    public DynamicStack() {
        this.data = new int[DEFAULT_SIZE];
    }

    public boolean push(int value) {
        if (isFull()) {
            resize();
        }
        data[++this.top] = value;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Cannot pop from an empty stack.");
            return -1;
        }
        return data[top--];
    }

    public int peek() {
        return data[top];
    }

    private boolean isFull() {
        return top == data.length - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private void resize() {
        int[] temp = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        this.data = temp; // very important line
    }

}
