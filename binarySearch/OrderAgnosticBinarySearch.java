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
        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (target == mid) {
                return mid;
            }

            if (arr[start] < arr[end]) {
                // ascending order
                if (target < arr[mid]) {
                    // exists in the left half
                    end = mid - 1;
                } else if (target > arr[mid]) {
                    // exists in the right half
                    start = mid + 1;
                } else {
                    System.out.println("ascending order: ");
                    return mid;
                }

            } else {
                // descending order
                if (target < arr[mid]) {
                    // exists in the right half
                    start = mid + 1;
                } else if (target > arr[mid]) {
                    // exists in the left half
                    end = mid - 1;
                } else {
                    System.out.println("descending order: ");
                    return mid;
                }
            }

        }
        return -1;
    }
}
