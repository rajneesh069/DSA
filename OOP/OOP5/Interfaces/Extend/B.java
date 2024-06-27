package OOP.OOP5.Interfaces.Extend;

public interface B extends A {
    default void fun() {
        System.out.println("This is default fun.");
    };

    static void somefn() {
        // body is required
        System.out.println("This is static.");
    }
}
