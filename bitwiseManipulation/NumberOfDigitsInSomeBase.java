package bitwiseManipulation;

public class NumberOfDigitsInSomeBase {
    public static void main(String[] args) {
        System.out.println(numOfDigits(34567, 10));
    }

    // other way is to right shift till the number is 0

    static int numOfDigits(int num, int base) {
        return (int) (Math.log10(num) / Math.log10(base)) + 1;
    }
}
