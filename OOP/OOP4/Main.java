package OOP.OOP4;

public class Main {
    public static void main(String[] args) {
        Example obj1 = new Example();
        obj1.a = 10; // publically accessible, in the same package, same class , different package
        // and in inherited classes as well of same or different packages
        System.out.println(obj1.a);

        // System.out.println(obj.c); // private variable, nowhere accessible except
        // it's own class

        obj1.b = 20;
        // protected : accessible in the same class, same package/file and inside
        // inherited
        // classes may or may not be of the same package and can only be accessed by the
        // inherited classes in different packages and not even the same class
        // can access it inside that subclass in a different package

        obj1.d = 30; // no access modifier : accessible inside the same class, same package,
                     // inherited
        // classes inside the same package and that's all

        // To access private variables : we use setter and getter methods
        obj1.setC(69);
        int c = obj1.getC();
        System.out.println("c : " + c);
    }
}
