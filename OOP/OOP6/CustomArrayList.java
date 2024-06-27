package OOP.OOP6;

import java.util.Arrays;

public class CustomArrayList {
    private int[] arr;
    private static int DEFAULT_SIZE = 10;
    public static int size = 0;

    private boolean isFull() {
        return (arr.length == size);

    }

    private void resize() {
        arr = new int[2 * size];
    }

    CustomArrayList() {
        arr = new int[DEFAULT_SIZE];
    }

    public int get(int index) {
        return arr[index];
    }

    public void add(int num) {
        if (isFull()) {
            resize();
        }
        arr[size++] = num; // I like this line
    }

    public void remove() {
        --size;
    }

    public void set(int index, int num) {
        if (index >= size) {
            resize();
        }
        arr[index] = num;
    }

    @Override
    public String toString() {
        StringBuilder array = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                array.append(arr[i]);
                break;
            }
            array.append(arr[i] + ", ");
        }
        array.append("]");

        return array.toString();
    }

}
