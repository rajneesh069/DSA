package leetcode;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 1, 1 };
        System.out.println(pivotElementWithDuplicateElementsIndex(arr));
        // System.out.println(pivotElementansWithUniqueElementsans(arr));

    }

    static boolean searchAns(int[] arr, int target) {
        int ans = -1;
        int ind = pivotElementWithDuplicateElementsIndex(arr);
        int search1 = binarySearchAscending(0, ind, target, arr);
        int search2 = binarySearchAscending(ind + 1, arr.length - 1, target, arr);
        if (search1 != -1) {
            ans = search1;
        } else {
            ans = search2;
        }
        return ans != -1 ? true : false;
    }

    // this won't work for duplicate values
    static int pivotElementansWithUniqueElementsIndex(int[] arr) {
        int ans = 0;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < arr.length - 1) {
                if (arr[mid] > arr[mid + 1]) {
                    ans = mid;
                    break;
                } else if (mid == 0) {
                    start++;
                } else if (arr[mid] < arr[mid - 1]) {
                    ans = mid - 1;
                    break;
                } else if (arr[start] > arr[mid]) {
                    end = mid - 1;
                } else if (arr[start] <= arr[mid]) {
                    start = mid + 1;
                }
            } else {
                ans = mid;
                break;
            }

        }
        return ans;
    }

    // works for duplicate values
    static int pivotElementWithDuplicateElementsIndex(int[] arr) {
        /*
         * int ans = -1;
         * int start = 0;
         * int end = arr.length - 1;
         * while (start <= end) {
         * int mid = start + (end - start) / 2;
         * if (mid < arr.length - 1) {
         * if (arr[mid] > arr[mid + 1]) {
         * ans = mid;
         * return ans;
         * } else if (mid == 0) {
         * start++;
         * } else if (arr[mid] < arr[mid - 1]) {
         * return mid - 1;
         * } else if (arr[start] > arr[mid]) {
         * end = mid - 1;
         * } else if (arr[start] < arr[mid]) {
         * start = mid + 1;
         * } else {
         * if (arr[start] > arr[start + 1]) {
         * return start;
         * }
         * start++;
         * }
         * } else {
         * ans = mid;
         * break;
         * }
         * }
         * return ans;
         */
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                /*
                 * always put the condition first as it would be
                 * evaluated first hence arr[someIllegalIndex] case
                 * will never happen as the first condition will be
                 * false and due to '&&' operator language will never
                 * evaluate the second expression
                 */
                ans = mid;
                break;
            } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                ans = mid - 1;
                break;
            } else if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    static int binarySearchAscending(int start, int end, int target, int[] arr) {
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
        return ans;
    }

}
