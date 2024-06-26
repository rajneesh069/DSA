package OOPs.OOP3.polymorphism;

public class Square extends Shapes {
    @Override // it's an annotation and gives a check if the method is over-ridden here.
    void area() {
        System.out.println("Area of square is : side * side.");
    }
}
