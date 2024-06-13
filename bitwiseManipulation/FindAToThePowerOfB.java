package bitwiseManipulation;

public class FindAToThePowerOfB {
    public static void main(String[] args) {
        System.out.println(pow(2, 4));
    }

    // O(log(b)) -> time complexity

    public static int pow(int base, int index) {
        int ans = 1;
        while (index != 0) {
            if ((index & 1) != 0) {
                ans = ans * base;
            }
            base *= base;
            index = index >> 1;
        }
        return ans;
    }
}
