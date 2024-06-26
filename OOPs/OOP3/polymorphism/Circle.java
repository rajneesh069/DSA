package OOPs.OOP3.polymorphism;

public class Circle extends Shapes {
    @Override
    final void area() { //no problem because it is a child class
        System.out.println("Area of circle is : pi * r * r.");
    }
}
