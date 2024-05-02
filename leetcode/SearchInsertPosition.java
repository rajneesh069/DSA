package leetcode;

public class SearchInsertPosition {
    // basically return the index of ceiling
    public static void main(String[] args) {

    }

    static int searchInsertPosition(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        int[] arr = nums;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                ans = arr[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return ans;
    }
}
