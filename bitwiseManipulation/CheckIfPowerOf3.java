package bitwiseManipulation;

public class CheckIfPowerOf3 {
    public static void main(String[] args) {
        System.out.println(powerOf3(3));
    }

    static boolean powerOf3(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        }
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n = n / 3;
        }

        return true;
    }
}
