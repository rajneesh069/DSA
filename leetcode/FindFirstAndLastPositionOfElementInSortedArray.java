package leetcode;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 12, 20, 10 };
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }

    static int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                ans[0] = mid;
                end = mid - 1;
            }
        }

        if (ans[0] != -1) {
            start = 0;
            end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] > target) {
                    end = mid - 1;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    ans[1] = mid;
                    start = mid + 1;
                }
            }
        }

        return ans;
    }
}
