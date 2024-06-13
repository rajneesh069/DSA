package bitwiseManipulation;

public class NewtonRaphsonMethod {
    public static void main(String[] args) {
        double n = 40;
        System.out.println(sqrt(n));
    }

    static double sqrt(double n) {
        double x = n;
        double root = 0.0;
        while (true) {
            root = 0.5 * (x + (n / x));

            if (Math.abs(root - x) < 0.00001) {
                break;
            }

            x = root;
        }

        return root;
    }
}
