package OOP.OOP5.Interfaces;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.acc();
        car.brake();
        car.stop();

        Engine car1 = new Car();
        // LHS/reference variables tell which properties/methods can be accessed.
        // RHS/contructor call tells which methods/properties or versions of
        // methods/properties are there, accessibility depends on the type of reference
        // variable.
        car1.start();
        car1.acc();
        car1.stop();
        // car1.brake(); // Can't access it for obvious reasons

        MediaPlayer car2 = new Car();
        car2.start(); // > car start -> wrong output as MediaPlayer shouldn't start or stop the car.
        car2.stop(); // > car stop
    }
}
