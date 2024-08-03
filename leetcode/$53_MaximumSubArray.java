package leetcode;

public class $53_MaximumSubArray {
    // Kadane's Algorithm, carry the max sum and make it zero if it becomes negative.
    public int maxSubArray(int[] nums) {
        int maxi = nums[0];
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            if(sum > maxi) maxi = sum;
            if(sum < 0) sum = 0;
        }
        return maxi;
    }
}
