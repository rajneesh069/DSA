package bitwiseManipulation;

public class GCD {
    public static void main(String[] args) {
        System.out.println(HCF(4, 8));
    }

    static int HCF(int a, int b) {
        if (a == 0) {
            return b;
        }
        return HCF(b % a, b);
    }
}
