package OOP.OOP5.Interfaces;

public class ElectricEngine implements Engine {

    @Override
    public void type(String type) {
        System.out.printf("Type : %s Engine", type);
    }

    @Override
    public void acc() {
        System.out.println("Electric car accelerate.");
    }

    @Override
    public void start() {
        System.out.println("Electric car start.");
    }

    @Override
    public void stop() {
        System.out.println("Electric car stop.");
    }

}
