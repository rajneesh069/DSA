package bitwiseManipulation;

public class FindSqaureRootUsingBinarySearch {
    public static void main(String[] args) {
        System.out.println(squareRoot(64));
    }

    static int squareRoot(int n) {
        if (n < 0) {
            return -1;
        }

        int ans = 0;
        int start = 0;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == n) {
                ans = mid;
                break;
            } else if (mid * mid > n) {
                end = mid - 1;
            } else if (mid * mid < n) {
                start = mid + 1;
            }

        }
        return ans;
    }
}
