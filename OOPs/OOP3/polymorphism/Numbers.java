package OOPs.OOP3.polymorphism;

public class Numbers {
    int sum(int a, int b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }

    void sum(int a, int b, int c, int d) {
        System.out.println("This sum is: " + (a + b + c + d));
    }

    double sum(double a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        // method overloading
        Numbers num = new Numbers();
        System.out.println(num.sum(2, 3));
        System.out.println(num.sum(2d, 3));

    }

}
