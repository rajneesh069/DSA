package stringsAndStringbuilder;

import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {
        String name = "Rajneesh Mishra";
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(name.toLowerCase()); // won't change the original object but will create a new object
        System.out.println(name); // "Rajneesh Mishra"
        System.out.println("   Rajneesh  ".strip()); // whitespaces are removed, it removes space in the start and end
        // of the string
        System.out.println("Rajneesh Mishra".strip()); // Rajneesh Mishra, as the space in between isn't a whitespace
    }
}
