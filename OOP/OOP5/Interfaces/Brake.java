package OOP.OOP5.Interfaces;

public class Brake implements Brakes {

    @Override
    public void brake() {
        System.out.println("Brakes engaged.");

    }

    @Override
    public void stop() {
        System.out.println("Brakes disengaged.");

    }

}
