package bitwiseManipulation;

public class FindTheNumberOfSetBits {
    public static void main(String[] args) {
        System.out.println(setBits(11));
    }

    static int setBits(int n) {
        int ans = 0;

        // for (int i = 0; i < 32; i++) {
        // if ((n & (1 << i)) != 0) {
        // ans++;
        // System.out.println("ans: " + ans);
        // }
        // }

        while (n > 0) {
            ans++;
            n = n - (n & (-n));
        }

        return ans;
    }
}
