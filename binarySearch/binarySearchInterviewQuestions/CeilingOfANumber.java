package binarySearch.binarySearchInterviewQuestions;

public class CeilingOfANumber {
    public static void main(String[] args) {
        // ascending order
        int[] arr1 = { 2, 3, 5, 7, 9, 14, 16, 18 };
        System.out.println(ceilingOfANumber(arr1, 7));

        // descending order
        int[] arr = { 30, 25, 20, 18, 15, 12, 10, 8, 5, 3, 2 };
        System.out.println(ceilingOfANumber(arr, 19));
    }

    static int ceilingOfANumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isAsc) {
                if (arr[mid] >= target) {
                    ans = arr[mid];
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] >= target) {
                    ans = arr[mid];
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return ans;
    }

}
