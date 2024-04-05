package methods;
import java.util.Arrays;
import java.util.Scanner;

public class methods {
    public static void main(String[] args) {
        System.out.println("The sum is: " + sum());
        System.out.println(greet("Sachin"));
        int[] arr = { 1, 2, 3 };
        System.out.println(Arrays.toString(swap(arr)));
    }

    static int sum() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number 1: ");
        int num1 = in.nextInt();
        System.out.print("Enter the number 2: ");
        int num2 = in.nextInt();
        in.close();
        return num1 + num2;
    }

    static String greet(String a) {
        return String.format("Hello %s!", a);
    }

    static int[] swap(int[] arr) {
        arr[0] = 22;
        return arr;
    }
}
