package leetcode;

import java.util.Arrays;

public class MaxAreaOfTheContainer {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
    }

    static int maxArea(int[] height) {
        Arrays.sort(height);
        int max = height[height.length - 1];
        for (int i = height.length - 1; i > 0; i--) {
            if (height[i] < max) {
                max = height[i];
                break;
            }
        }
        return max * max;
    }
}
