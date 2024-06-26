package OOPs.OOP3;

@SuppressWarnings("unused")
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
    }
}
