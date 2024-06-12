package bitwiseManipulation;

public class FindTheMagicNumber {
    public static void main(String[] args) {
        System.out.println(magicNum(6));
    }

    static int magicNum(int n) {
        int num = 0;
        int k = 5;
        while (n != 0) {
            int bit = n & 1;
            n = n >> 1;
            num += bit * k;
            k = k * 5;
        }
        return num;
    }
}
