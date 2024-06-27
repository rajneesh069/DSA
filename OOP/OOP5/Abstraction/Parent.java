package OOP.OOP5.Abstraction;

public abstract class Parent {
    final int age;

    abstract void career(String name);

    abstract void partner(String name, int age);

    Parent(int age) {
        this.age = age;
    }

    void normal() {
        System.out.println("This is a normal function.");
    }

    static void hello() {
        System.out.println("This is the parent.");
    }
}
