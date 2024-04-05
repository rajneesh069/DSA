package methods;
public class armstrongNumber {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            if (isArmstrong(i)) {
                System.out.print(i + " ");
            } else {
                continue;
            }
        }
    }

    static boolean isArmstrong(int num) {
        int sum = 0;
        int check = num;
        int numberOfDigits = 0;
        int preservedNumber = num;
        while (num != 0) {
            numberOfDigits++;
            num = (num) / 10;
        }
        while (preservedNumber != 0) {
            int digit;
            digit = preservedNumber % 10;
            preservedNumber = preservedNumber / 10;
            sum = sum + (int) (Math.pow(digit, numberOfDigits));
        }

        if (sum == check)
            return true;
        return false;
    }
}
