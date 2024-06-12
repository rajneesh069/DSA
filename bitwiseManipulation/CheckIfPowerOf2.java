package bitwiseManipulation;

public class CheckIfPowerOf2 {
    public static void main(String[] args) {
        System.out.println(0);
    }

    static boolean powerOf2(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
