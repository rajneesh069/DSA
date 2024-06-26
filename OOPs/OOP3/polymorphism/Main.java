package OOPs.OOP3.polymorphism;

//Encapsulation : Implementation Issue / Internal, helps achieve data hiding. Wrapping up
//the implementation of data members and methods in a class

//Abstraction : Design Issue / External, hides un-necesary details and provides relevant methods/properties.

//Types of polymorphism :

//1. Complile time/Static polymorphism -> achieved via method overloading,
//can also be achieved via operator overloading but Java doesn't support it.

//2. Runtime or dynamic polymorphism -> achieved via method overriding.

// Overriding depends on objects, and static doesn't hence can't be overridden
// Static methods can be inherited, but can't be overridden because they are independent of objects.
// If you put final keyword before a class name it won't be inherited and implicitly all the methods will be marked as final too.
// 'final' methods(of the parent class) cannot be overridden.

public class Main {
    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Shapes circle = new Circle();
        Shapes square = new Square();

        // message() is a static method in Shapes class hence inherited
        // circle.message(); // this works as well, but use class to call it in a static
        // manner.
        Circle.message(); // proper way to use a static method
        Shapes.message();

        /*
         * Parent object = new Child();
         * LHS tells what properties/methods could be accessed by the reference
         * variable(Parent object).
         * RHS tells which properties/methods could be accessed in the class(Child()).
         * 
         * It is known as upcasting. Which results in method overriding.
         * Q) How Java determines which version of the method to call?
         * Ans : By using Dynamic Method Dispatch as the version of the method depends
         * on the object(new Child()) which calls it, hence memory allocation is done at
         * runtime.
         */

        shape.area();
        circle.area();// method overriding
        square.area();// method overriding

        Numbers num = new Numbers();
        // method overloading, same name but different return types or arguments types
        int sum1 = num.sum(1, 2);
        int sum2 = num.sum(1, 2, 3);
        num.sum(1, 2, 3, 4); // void type
        System.out.println("sum1: " + sum1 + " sum2: " + sum2);
        System.out.println(num.sum(2, 3)); // calls the method where arguments are both int
        System.out.println(num.sum(2d, 3)); // calls the method where one argument is double and other is int
    }
}
