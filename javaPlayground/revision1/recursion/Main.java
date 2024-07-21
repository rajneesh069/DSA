package javaPlayground.revision1.recursion;

public class Main {
    public static void main(String[] args) {
        message(0);
        message2(0);
    }

    private static void message(int n) {
        if (n == 5) { // base condition
            return;
        }
        System.out.println("Hello this is the message function.\s" + n); // prints the message
        message(++n); // calls itself till its 5
    }

    private static void message2(int n) {
        if (n == 5) { // base condition
            return;
        }
        message2(n+1); // calls itself till its 5
        System.out.println("Hello this is the message function.\s" + n); // prints the message
    }
}
