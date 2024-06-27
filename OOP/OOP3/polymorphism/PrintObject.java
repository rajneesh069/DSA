package OOP.OOP3.polymorphism;

public class PrintObject {
    int num;

    PrintObject(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        PrintObject obj = new PrintObject(10);
        System.out.println(obj.toString());
    }

    // Overriding the default toString() method
    @Override
    public String toString() {
        return "num = " + num;
    }
}
