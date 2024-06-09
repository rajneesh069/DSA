package stringsAndStringbuilder;

public class StringBuilderApp {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder(); // it is mutable, strings are immutable
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            builder.append(ch);
        }
        System.out.println(builder); // or System.out.println(builder.toString());
        builder.reverse();
        System.out.println(builder.toString());
    }
}
