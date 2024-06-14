package recursion;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 78, 32, 9 };
        int target = 69;
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println(findAllIndices(arr, target, 0, list));
    }

    static int search(int[] arr, int target, int start) {
        if (start == arr.length - 1) {
            if (arr[start] == target) {
                return start;
            } else {
                return -1;
            }
        } else if (arr[start] == target) {
            return start;
        }
        return search(arr, target, ++start);
    }

    static boolean doesExistInArray(int[] arr, int target, int start) {
        if (start == arr.length) {
            return false;
        }
        return arr[start] == target || doesExistInArray(arr, target, ++start);
    }

    static ArrayList<Integer> findAllIndices(int[] arr, int target, int start, ArrayList<Integer> list) {
        if (start == arr.length) {
            return list;
        }
        if (arr[start] == target) {
            list.add(start);
        }
        return findAllIndices(arr, target, ++start, list);
    }
}
