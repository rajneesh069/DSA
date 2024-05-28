package leetcode;

public class FindInMountainArray {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 2 };
        System.out.println(findElement(arr, 5));
    }

    // my method and it works!
    static int findElement(int[] arr, int target) {
        int peakIndex = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < arr.length - 1) { // index out of bounds check !!very important
                if (arr[mid] < arr[mid + 1]) {
                    start = mid + 1;

                } else if (arr[mid] > arr[mid + 1]) {
                    end = mid - 1;
                    peakIndex = mid;
                }
            } else {
                peakIndex = mid;
                break;
            }
        }

        start = 0;
        end = peakIndex;
        int min = binarySearchAscending(start, end, target, arr);

        start = peakIndex;
        end = arr.length - 1;
        int max = binarySearchDescending(start, end, target, arr);

        if (min != -1) {
            return min;
        } else if (min == -1 && max != -1) { // when the element is on decreasing side only
            return max;
        }
        return min;
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

    static int binarySearchDescending(int start, int end, int target, int[] arr) {
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                end = mid - 1;
            } else if (arr[mid] > target) {
                start = mid + 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
}
