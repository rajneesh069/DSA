package OOP.OOP6.Generics;

@SuppressWarnings("unchecked")
public class CustomArrayList<T> {
    private Object[] arr;
    private final static int DEFAULT_SIZE = 10;
    private int size = 0;

    private boolean isFull() {
        return (arr.length == size);

    }

    private void resize() {
        Object[] temp = new Object[2 * size];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    CustomArrayList() {
        arr = new Object[DEFAULT_SIZE];
    }

    public T get(int index) {
        return (T) (arr[index]);
    }

    public void add(T data) {
        if (isFull()) {
            resize();
        }
        arr[size++] = data; // I like this line
    }

    public T remove() {
        T removed = (T) (arr[--size]);
        return removed;
    }

    public void set(int index, T data) {
        if (index >= size) {
            resize();
        }
        arr[index] = data;
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
