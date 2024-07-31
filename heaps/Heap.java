package heaps;

import java.util.*;

// Min heap
public class Heap<T extends Comparable<T>> {

    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.insert(10);
        heap.insert(11);
        heap.insert(12);
        heap.insert(13);
        System.out.println(heap.heapSort());
        // if an unsorted array is given and we want to make a heap out of it, start
        // from N/2 till 1 and then do downheap on every index.
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
        T root = list.get(0);
        T last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }
        return root;
    }

    public ArrayList<T> heapSort() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("The list is empty.");
        }
        ArrayList<T> data = new ArrayList<>();
        while (!list.isEmpty()) {
            data.add(this.remove());
        }

        return data;
    }

    public Heap() {
        list = new ArrayList<>();
    }
}