package OOP.OOP5.Interfaces;

public class PetrolEngine implements Engine {

    @Override
    public void acc() {
        System.out.println("Petrol Engine Car accelerate.");
    }

    @Override
    public void start() {
        System.out.println("Petrol Engine Car start.");
    }

    @Override
    public void stop() {
        System.out.println("Petrol Engine Car stop.");
    }

    @Override
    public void type(String type) {
        System.out.printf("Type : %s Engine", type);
    }

}
