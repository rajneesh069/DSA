package bitwiseManipulation;

public class FindNumberOfPrimesUsingSieveMethod {
    public static void main(String[] args) {
        int n = 40;
        boolean[] primes = new boolean[n + 1];
        System.out.println(sieve(n, primes));
    }

    static int sieve(int n, boolean[] primes) {
        int numberOfPrimes = 0;
        if (n <= 1) {
            return numberOfPrimes;
        }

        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) {
                for (int j = 2 * i; j < primes.length; j += i) {
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i < primes.length; i++) {
            if (!primes[i]) {
                numberOfPrimes++;
            }

        }
        return numberOfPrimes;
    }
}
