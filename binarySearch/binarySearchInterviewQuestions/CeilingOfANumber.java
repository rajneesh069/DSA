package binarySearch.binarySearchInterviewQuestions;

public class CeilingOfANumber {
    public static void main(String[] args) {
        int[] arr = { 30, 25, 20, 18, 15, 12, 10, 8, 5, 3, 2 };
        int[] arr1 = { 2, 3, 5, 9, 14, 16, 18 };
        System.out.println(ceilingOfANumber(arr, 13));
        System.out.println(ceilingOfANumber(arr1, 7));
    }

    static int ceilingOfANumber(int[] arr, int target) {
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
                } else {
                    return arr[mid];
                }
            } else {
                if (target < arr[mid]) {
                    start = mid + 1;
                } else if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    return arr[mid];
                }
            }
        }
        return isAsc ? arr[start] : arr[end];
    }

}
