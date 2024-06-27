package OOP.OOP5.Abstraction;

public class Child extends Parent {
    Child() {
        super(45);
    }

    @Override
    void career(String name) {
        System.out.println("I am going to be a " + name);
    }

    @Override
    void partner(String name, int age) {
        System.out.println("I love " + name + " and her age is " + age + ".");
    }
}
