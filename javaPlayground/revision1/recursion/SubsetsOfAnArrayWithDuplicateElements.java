package javaPlayground.revision1.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsOfAnArrayWithDuplicateElements {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2 };
        System.out.println(subsets(arr));
    }

    static ArrayList<ArrayList<Integer>> subsets(int[] arr) {
        Arrays.sort(arr); // sort the array first
        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());
        int start = 0, end = outerList.size() - 1;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            if (start < end && i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = outerList.size() - 1;
            // int n = outerList.size();
            for (int j = start; j <= end; j++) {
                ArrayList<Integer> innerList = new ArrayList<>(outerList.get(j));
                innerList.add(arr[i]);
                outerList.add(innerList);
            }
        }
        return outerList;
    }
}
