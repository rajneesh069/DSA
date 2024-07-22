package javaPlayground.playground;

import java.util.ArrayList;

public class LinearSearch2 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2 };
        System.out.println(search(arr, 2, 0));
    }

    static ArrayList<Integer> search(int[] arr, int target, int start) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (start == arr.length) {
            return ans;
        }
        if (arr[start] == target) {
            ans.add(start);
        }

        ArrayList<Integer> temp = search(arr, target, ++start);
        ans.addAll(temp);
        return ans;
    }
}
