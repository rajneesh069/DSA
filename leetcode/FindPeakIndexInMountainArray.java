package leetcode;

public class FindPeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = { 1,2,3,4,5,3,1 };
        System.out.println(peakIndex(arr));
    }

    /*
     * this solution works for the easy problem only
     * static int peakIndex(int[] arr) {
     * int ans = -1;
     * int start = 0;
     * int end = arr.length - 1;
     * while (start <= end) {
     * int mid = start + (end - start) / 2;
     * if (arr[mid] < arr[mid + 1]) {
     * start = mid + 1;
     * } else if (arr[mid] > arr[mid + 1]) {
     * end = mid - 1;
     * ans = mid;
     * }
     * }
     * return ans;
     * }
     */

    // works for the medium solution as well
    /*
     * insight : check for index out of bounds, in medium, it was not bitnoic
     * mountain array, but it could just be an increasing array or an array with a
     * single or two elements. so always check for index out of bounds condition
     * and use a simple array of 1 or 2 or 3 elements for that. Until or unless said
     * that its bitonic don't consider it.
     */
    static int peakIndex(int[] arr) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + (end - start) / 2);
            if (mid < arr.length - 1) {
                if (arr[mid] < arr[mid + 1]) {
                    start = mid + 1; // ascending part of the array
                } else {
                    ans = mid;
                    end = mid - 1;
                }
            } else {
                return mid;
            }

        }
        return ans;
    }
}
