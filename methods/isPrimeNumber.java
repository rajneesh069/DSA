package methods;
public class isPrimeNumber {

    public static void main(String[] args) {
        System.out.println(isPrime(100));
    }

    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        int c = 2;
        while (c * c <= num) {
            if (num % c == 0)
                return false;
            c++;
        }
        return c * c > num;
    }

}
