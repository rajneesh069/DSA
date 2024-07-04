package recursion;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // message(1);
        System.out.println(message(0));
    }

    // static void message(int n) {
    // // base condition should always be written first or it'll go in an infinite
    // loop
    // if (n == 5) {
    // System.out.println("n: " + n);
    // return;
    // }
    // System.out.println("n: " + n);
    // message(n + 1); // since this is the last line which is the function call,
    // this is tail
    // // recursion
    // }

    // static String message(int n) {
    // String str = "";
    // if (n == 5) {
    // return str;
    // }
    // str = "Print\n";
    // String ansFromBelow = message(++n);
    // str += ansFromBelow;
    // return str;
    // }

    static ArrayList<String> message(int n) {
        ArrayList<String> local = new ArrayList<>();
        if (n == 5) {
            return local;
        }
        local.add("Print\s" + (n+1));
        ArrayList<String> ansFromBelow = message(++n);
        local.addAll(ansFromBelow);
        return local;
    }

}
