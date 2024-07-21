package javaPlayground.revision1.recursion;

public class RemoveACharacter {
    public static void main(String[] args) {
        String up = new String("baccd");
        System.out.println(removeAChar(up));

    }

    static String removeAChar(String up) {
        if (up.isEmpty()) {
            return "";
        }
        if (up.charAt(0) == 'c') {
            return removeAChar(up.substring(1));
        }
        return up.charAt(0) + removeAChar(up.substring(1));
    }
}
