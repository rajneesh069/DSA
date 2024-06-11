package bitwiseManipulation;

public class FindTheNonRepeatingNumber {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 1, 6, 4, 3, 3, 4, 0, 0 };
        System.out.println(nonRepeatingNumber(arr));
    }

    private static int nonRepeatingNumber(int[] arr) {
        int ans = 0;
        for (int n : arr) {
            ans ^= n;
        }
        return ans;
    }

}
