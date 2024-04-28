package binarySearch.binarySearchInterviewQuestions;

public class FloorOfANumber {
    public static void main(String[] args) {
        int[] arr = { 30, 25, 20, 18, 15, 12, 10, 8, 5, 3, 2 };
        int[] arr1 = { 2, 3, 5, 9, 14, 16, 18 };
        System.out.println(floor(arr, 19));
    }

    static int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return arr[mid];
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else if (target > arr[mid]) {
                    start = mid + 1;
                }
            } else {
                if (target < arr[mid]) {
                    start = mid + 1;
                } else if (target > arr[mid]) {
                    end = mid - 1;
                }
            }
        }
        return isAsc ? arr[end] : arr[start];
    }
}
