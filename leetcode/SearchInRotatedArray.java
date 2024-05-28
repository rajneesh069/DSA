package leetcode;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(pivotElementIndex(arr));
        // System.out.println(searchIndex(arr, 3));
    }

    static int searchIndex(int[] arr, int target) {
        int ans = -1;
        int ind = pivotElementIndex(arr);
        int search1 = binarySearchAscending(0, ind, target, arr);
        int search2 = binarySearchAscending(ind + 1, arr.length - 1, target, arr);
        if (search1 != -1) {
            ans = search1;
        } else {
            ans = search2;
        }
        return ans;
    }
    //this won't work for duplicate values
    static int pivotElementIndex(int[] arr) {
        int index = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < arr.length - 1 && mid > 0) {
                if (arr[mid] < arr[mid - 1]) {
                    index = mid - 1;
                    break;
                } else if (arr[mid] > arr[mid + 1]) {
                    index = mid;
                    break;
                } else if (arr[start] >= arr[mid]) {
                    end = mid - 1;
                } else if (arr[start] < arr[mid]) {
                    start = mid + 1;
                }
            } else {
                break;
            }

        }
        return index;
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
