package OOPs.OOP3;

//Multi-level inheritance
//Box -> BoxWithWeight ->  BoxWithColor

public class BoxWithColor extends BoxWithWeight {
    String color;

    BoxWithColor() {
        super(100, 200, 100, 300, 250);
        this.color = "red";
    }

    BoxWithColor(String color) {
        super();
        this.color = color;
    }

    BoxWithColor(double weight, int price, String color) {
        super(weight, price);
        this.color = color;
    }

}
