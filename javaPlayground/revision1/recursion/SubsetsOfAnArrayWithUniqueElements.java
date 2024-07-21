package javaPlayground.revision1.recursion;

import java.util.ArrayList;

public class SubsetsOfAnArrayWithUniqueElements {
    public static void main(String[] args) {
        int[] arr = { 1, 2 };
        // subsets : {}, {1}, {2}, {1,2}
        System.out.println(subsetsOfAnArray(arr));
    }
    // we use iterative approach in this case as the recursive one needs
    // backtracking and is less intuitive as well

    static ArrayList<ArrayList<Integer>> subsetsOfAnArray(int[] arr) {
        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>()); // [ [] ]
        for (int i = 0; i < arr.length; i++) {
            int n = outerList.size();
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> innerList = new ArrayList<>(outerList.get(j)); // copy of the outer list elements
                innerList.add(arr[i]);
                outerList.add(innerList);
            }
        }
        return outerList;
    }
}
