package OOPs.OOP3.inheritance;

// Multiple and Hybrid inheritance is not supported in Java, it can be implemented using interfacs.

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box(10);
        Box box3 = new Box(11, 3, 9);

        System.out.println(box1.l + " " + box1.w + " " + box1.h);
        System.out.println(box2.l + " " + box2.w + " " + box2.h);
        System.out.println(box3.l + " " + box3.w + " " + box3.h);

        BoxWithColor box4 = new BoxWithColor();
        System.out.println(box4.color);

        BoxWithColor box5 = new BoxWithColor("blue");
        System.out.println(box5.color + " " + box5.price);

        BoxWithColor box6 = new BoxWithColor(100.12d, 100, "green");
        System.out.println(box6.weight + " " + box6.price + " " + box6.color);
    }
}
