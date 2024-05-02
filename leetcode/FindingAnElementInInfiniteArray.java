package leetcode;

public class FindingAnElementInInfiniteArray {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
        System.out.println(searchFn(arr, 10));
    }

    static int searchFn(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while (target > arr[end]) {
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        System.out.println("start: " + start + " end: " + end);
        return binarySearch(arr, start, end, target);

    }

    static int binarySearch(int[] arr, int start, int end, int target) {
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans; // Target not found
    }
}
