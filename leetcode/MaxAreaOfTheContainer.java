package leetcode;

public class MaxAreaOfTheContainer {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        // int[] height = { 2, 1 };
        System.out.println(maxArea(height));
    }

    static int maxArea(int[] height) {
        int max = -1;
        for (int i = 0; i < height.length; i++) {
            
        }
        
        //O(n^2)
        // for (int i = 0; i < height.length; i++) {
        //     for (int j = 0; j <= i; j++) {
        //         max = Math.max(max, ((i - j) * Math.min(height[i], height[j])));
        //     }
        // }
        return max;
    }
}
