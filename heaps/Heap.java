package heaps;

import java.util.*;

@SuppressWarnings("unused")

// Min heap
public class Heap<T extends Comparable<T>> {

    public static void main(String[] args) {

    }

    private ArrayList<T> list;

    private void swap(int first, int second) {
        T temp = list.get(second);
        list.set(second, list.get(first));
        list.set(first, temp);
    }

    // these methods return the indices -> left, right and parent
    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }

    public void insert(T value) {
        list.add(value);
        // Now we'll apply upheap
        upheap(list.size() - 1);
    }

    private void upheap(int i) {
        if (i == 0) {
            return;
        }
        int p = parent(i);
        if (list.get(i).compareTo(list.get(p)) < 0) {
            swap(i, p);
            upheap(p);
        }

    }

    private void downheap(int i) {
        if (i == list.size()) {
            return;
        }
        int min = i;
        int left = left(i);
        int right = right(i);

        if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }
        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }

        if (min != i) {
            swap(i, min);
            downheap(min);
        }
    }

    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("List is empty.");
        }
        T last = list.get(list.size() - 1);
        T temp = list.get(0);
        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }

        return temp;
    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();
        while (!list.isEmpty()) {
            data.add(this.remove());
        }

        return data;
    }

    public Heap() {

    }
}