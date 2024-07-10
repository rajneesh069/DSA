public class Stack {
    public static void main(String[] args) {
        Stack stack = new Stack(15);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            int val = stack.pop();
            System.out.println(val);
        }
    }

    private int[] data;
    private int top = -1;
    private static final int DEFAULT_SIZE = 10;

    public Stack() {
        // data = new int[DEFAULT_SIZE];
        this(DEFAULT_SIZE); // calls the appropriate constructor
    }

    public Stack(int size) {
        data = new int[size];
    }

    public boolean push(int value) {
        if (isFull()) {
            System.out.println("Cannot add to a full stack.");
            return false;
        }
        data[++this.top] = value;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Cannot remove from an empty stack.");
            return -1;
        }
        return data[this.top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Cannot peek in an empty stack.");
            return -1;
        }
        return data[top];
    }

    private boolean isFull() {
        return top == data.length - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

}
