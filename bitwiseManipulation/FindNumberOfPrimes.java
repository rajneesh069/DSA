package bitwiseManipulation;

public class FindNumberOfPrimes {
    public static void main(String[] args) {
        System.out.println(isPrime(10));
    }

    static boolean isPrime(int n) {
        int c = 2;
        if (n <= 1) {
            return false;
        }
        while (c * c <= n) {
            if (n % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }
}
