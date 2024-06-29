package recursion.searching;

import java.util.ArrayList;

public class LinearSearch2 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 69, 3, 69, 69 };
        int target = 69;
        int start = 0;
        System.out.println(search(arr, target, start));

    }

    static ArrayList<Integer> search(int[] arr, int target, int start) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (start == arr.length) {
            return list;
        }
        if (arr[start] == target) {
            list.add(start);
        }

        ArrayList<Integer> ansFromBelow = search(arr, target, ++start); // very clever line!
        list.addAll(ansFromBelow);

        return list;
    }
}
