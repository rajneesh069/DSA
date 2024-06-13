package bitwiseManipulation;

public class FindLCMOfTwoNumbers {
    public static void main(String[] args) {
        System.out.println(LCM(33, 11));
    }

    static int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }

    static int GCD(int a, int b) { // Euclid's algo
        if (a == 0) {
            return b;
        }
        return GCD(b % a, a);
    }
}
