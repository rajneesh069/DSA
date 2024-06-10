package recursion;

//if the problem can be broken down into smaller problems then it could be solved via recursion plus practice.
public class fibonacciSequence {
    public static void main(String[] args) {
        int ans = fibo(7);
        System.out.println(ans);
    }

    static int fibo(int n) {
        if (n < 2) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2); // find the recurrence relation, any recursion has some formula
    }
}
