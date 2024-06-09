package stringsAndStringbuilder;

import java.util.ArrayList;

public class Operators {
    public static void main(String[] args) {
        System.out.println('a' + 'b'); // converts character 'a' and 'b' into ASCII and adding them together
        System.out.println("a" + "b"); // concatenates the strings
        System.out.println((char) ('a' + 3)); // typecasting into char
        System.out.println("a" + 1);
        /*
         * 1 gets converted from int -> Integer wrapper class and then calls
         * '.toString()' method on it and prints "a1"
         */

        System.out.println("Rajneesh" + new ArrayList<>()); // if any object then it calls ".toString()" method to print
        // System.out.println(56 + new ArrayList<>()); // gives error
        // The operator '+' in Java is defined for primitives and to use it
        // for objects,
        // atleast one of the objects should
        // be string and then all the objects will result in String type.

        System.out.println(56 + "" + new ArrayList<>()); // works fine

        System.out.println("something");
        /*
         * a new object with value 'something' is created hence after garbage
         * collection leads to cleaning of unused variables/values
         */
    }
}
