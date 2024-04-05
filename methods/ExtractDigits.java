package methods;
public class ExtractDigits {
    public static void main(String[] args) {
        digitsOfANumber(597);
    }

    static void digitsOfANumber(int num) {
        int numberOfDigits = 0;
        int preservedNumber = num;
        while (num != 0) {
            numberOfDigits++;
            num = num / 10;
        }
        System.out.println("numberOfDigits: " + numberOfDigits);

        while (preservedNumber != 0) {
            int digit;
            digit = preservedNumber % 10;
            preservedNumber = preservedNumber / 10;

            System.out.print(digit);
        }
    }
}
