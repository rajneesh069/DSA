package javaPlayground;

public class j3 {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 4 }; // array can have same elements
        System.out.println(CheckIfRoatatedAndSorted(arr));
    }

    static boolean CheckIfRoatatedAndSorted(int[] arr) {
        int pivotCount = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                pivotCount++;
            }
            if (pivotCount > 1) { // not sorted if the array has more than one pivot
                return false;
            }
        }

        if (pivotCount == 1) {
            return arr[0] >= arr[arr.length - 1];
        }

        return true;
    }
}
