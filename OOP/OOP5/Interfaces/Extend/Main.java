package OOP.OOP5.Interfaces.Extend;

public class Main implements B {
    public interface NestedInterface {
        boolean isOdd(int num);
    };

    @Override
    public void fun() {
        System.out.println("Fun");
    }

    @Override // Annotations are checks only
    public void greet() {
        System.out.println("Greet");
    }

    public static void main(String[] args) {
        B.somefn();
        ;

    }

}
