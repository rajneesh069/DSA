package binarySearch;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arr = { 33, 32, 31, 30, 29 };
        System.out.println(unknownSortingOrderBinarySearch(arr, 29));
        int[] arr1 = { 29, 30, 31 };
        System.out.println(unknownSortingOrderBinarySearch(arr1, 29));
    }

    static int unknownSortingOrderBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isAsc) {
                if (arr[mid] > target) {
                    end = mid - 1;
                } else if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    ans = arr[mid];
                    start = mid + 1;
                }
            } else {
                if (arr[mid] > target) {
                    start = mid + 1;
                } else if (arr[mid] < target) {
                    end = mid - 1;
                } else {
                    ans = arr[mid];
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
