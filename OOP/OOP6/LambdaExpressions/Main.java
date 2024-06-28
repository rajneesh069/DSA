package OOP.OOP6.LambdaExpressions;

import java.util.ArrayList;

//They are a single line functions and generally don't have names.
//They enable functional features in Java.

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.forEach((item) -> System.out.println(2 * item)); // Consumer interface implementation

        Operation sum = (a, b) -> a + b;
        Operation prod = (a, b) -> a * b;
        Operation sub = (a, b) -> a - b;
        Main obj = new Main();

        sum.operate(1, 2);

    }

}

interface Operation {
    int operate(int a, int b);
}