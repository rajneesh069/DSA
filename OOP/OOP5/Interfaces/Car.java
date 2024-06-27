package OOP.OOP5.Interfaces;

public class Car implements Engine, Brakes, MediaPlayer {
    @Override
    public void brake() {
        System.out.println("Brakes engaged.");
    }

    @Override
    public void start() {
        System.out.println("Car start.");
    }

    @Override
    public void stop() {
        System.out.println("Car stop.");
    }

    @Override
    public void acc() {
        System.out.println("Car accelerated.");
    }

}
