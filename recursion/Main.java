package recursion;

public class Main {
    public static void main(String[] args) {
        message(1);
    }

    static void message(int n) {
        // base condition should always be written first or it'll go in an infinite loop
        if (n == 5) {
            System.out.println("n: " + n);
            return;
        }
        System.out.println("n: " + n);
        message(n + 1);
    }

}
