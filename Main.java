import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please input the value of a: ");
        int a = in.nextInt();
        in.close();
        System.out.println("The value of a is: " + a);
    }
}
