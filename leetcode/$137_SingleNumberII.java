package leetcode;

public class $137_SingleNumberII {
    public static void main(String[] args) {
        int[] arr = { -2, -2, 1, 1, 4, 1, 4, 4, -4, -2 };
        // int[] arr = { 6, 6, 6, 4, 4, 4, 3 };
        System.out.println(findNonRepeatingNumber(arr));
    }

    static int findNonRepeatingNumber(int[] arr) {
        int result = 0;
        int[] bitCount = new int[32];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < bitCount.length; j++) {
                if ((arr[i] & (1 << j)) != 0) {
                    bitCount[bitCount.length - 1 - j]++;
                }
            }
        }

        for (int i = bitCount.length - 1; i >= 0; i--) {
            if (bitCount[i] % 3 != 0) {
                result |= (1 << bitCount.length - i - 1);
            }
        }

        return result;
    }

}
