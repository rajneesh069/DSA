package leetcode;

public class FindPeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 5, 3, 2, 0 };
        System.out.println(peakIndex(arr));
    }

    static int peakIndex(int[] arr) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else if (arr[mid] > arr[mid + 1]) {
                end = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
