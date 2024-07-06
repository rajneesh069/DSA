package leetcode;

public class $35_searchInsertPosition {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 6 };
        int target = 5;
        System.out.println(searchInsert(arr, target));
    }

    public static int searchInsert(int[] arr, int target) {
        int start = 0;
        boolean isTargetFound = false;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
       
        return -1;

    }
}
