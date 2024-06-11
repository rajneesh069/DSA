package bitwiseManipulation;

public class NumberIsEvenOrOdd {
    public static void main(String[] args) {
        System.out.println(isNumberEvenOrOdd(37));
    }

    static String isNumberEvenOrOdd(int n) {
        if ((n & 1) == 0) {
            return "Even";
        }
        return "Odd";
    }
}
