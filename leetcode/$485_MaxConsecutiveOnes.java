package leetcode;

import java.util.ArrayList;

public class $485_MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 1, 1, 1 };
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                list.add(count);
                count = 0;
            }
        }
        list.add(count);
        System.out.println(list);
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
        }
        return max;
    }
}
