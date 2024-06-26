package OOPs.OOP2;

public class Human {
    int age;
    String name;
    int salary;
    boolean married;
    static long population; // without objects too static variables can be accessed. no need to reference it
    // by an object.

    static void message() {
        System.out.println("Hello world");
        // System.out.println(this.age); // gives error, because message is a 'static' method and since 'this' represents
        // an object of the class and 'static' methods are independent of objects hence
        // can't be used inside a static method.
    }

    public Human(String name, int age, int salary, boolean married) {
        this.age = age;
        this.married = married;
        this.name = name;
        this.salary = salary;
        Human.population += 1;
    }

}
