package stringsAndStringbuilder;

public class Main {
    public static void main(String[] args) {
        // '==' is a comparator and '.equals()' is a method.

        String name = "Rajneesh";
        // name = "Mishra"; // creates new object named Mishra and Rajneesh is left
        // without any reference
        // variable, immutability still holds as Rajneesh didn't get changed to Mishra
        // rather a new object Mishra was created
        String name1 = "Rajneesh";
        System.out.println("name==name1: " + name == name1); // true

        // to create new objects of same value use the new keyword
        String a = new String("Rajneesh");
        String b = new String("Rajneesh");
        System.out.println("a==b: " + a == b); // false

        // to just check values, use '.equals()' method
        System.out.println(a.equals(b)); // true
        System.out.println(name.equals(name1)); // true
        System.out.println(name.equals(b)); // true

        // placeholders in Java
        System.out.printf("Hello my name is %s, and I live in %s.\n", "Rajneesh", "Gonda");
    }

}
