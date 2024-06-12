package bitwiseManipulation;

public class SumOfNthRowOfPascalsTriangle {
    public static void main(String[] args) {
        System.out.println(sum(2));
    }

    static int sum(int n) {
        return 1 << (n - 1);
    }
}
