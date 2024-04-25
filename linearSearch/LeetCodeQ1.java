package linearSearch;

public class LeetCodeQ1 {
    public static void main(String[] args) {
        int[] nums = { 12, 345, 2, 6, 7896, 23, 333 };
        // System.out.println(evenNumOfDigits(nums));
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (optimisedNumOfDigits(nums[i]) % 2 == 0) {
                k++;
            }
        }
        System.out.println(k);
    }

    static int evenNumOfDigits(int[] nums) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            // Integer l = nums[i];
            // if (l.toString().length() % 2 == 0) {
            // c++;
            // }
            int numOfDigits = 0;

            if (nums[i] == 0)
                return 1;

            if (nums[i] < 0)
                nums[i] = -1 * nums[i];

            while (nums[i] != 0) {
                numOfDigits++;
                nums[i] = nums[i] / 10;
            }

            if (numOfDigits % 2 == 0)
                c++;
        }
        return c;

    }

    static int optimisedNumOfDigits(int nums) {
        if (nums < 0) {
            nums = -1 * nums;
        }
        if (nums == 0) {
            return 1;
        }
        return (int) (Math.log10(nums)) + 1;
    }
}
