package libearSearch;

public class LeetcodeRichestCustomerWealth {
    public static void main(String[] args) {
        int[][] acc = {
                { 1, 2, 3 },
                { 1, 2, 3 },
                { 1, 2, 3, 4 },
                { 1, 2, 3, 4, 5 },
        };
        System.out.println(richestCustomerWealth(acc));
    }

    static int richestCustomerWealth(int[][] acc) {
        int maxSum = 0;
        for (int row = 0; row < acc.length; row++) {
            int temp = maxSum;
            maxSum = 0;
            for (int col = 0; col < acc[row].length; col++) {
                maxSum = maxSum + acc[row][col];
            }
            maxSum = Math.max(maxSum, temp);
        }
        return maxSum;
    }
}
