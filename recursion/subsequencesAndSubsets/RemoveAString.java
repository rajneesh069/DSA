package recursion.subsequencesAndSubsets;

public class RemoveAString {
    public static void main(String[] args) {
        String s = new String("bccappleadappseapple");
        System.out.println(skip(s));
    }

    static String removeString(String s) {
        if (s.isEmpty()) {
            return "";
        }

        if (s.startsWith("apple")) {
            return removeString(s.substring(5));
        }
        return s.charAt(0) + removeString(s.substring(1));
    }

    static String skip(String s) {
        if (s.isEmpty()) {
            return "";
        }

        if (!s.startsWith("apple") && s.startsWith("app")) {
            return removeString(s.substring(5));
        }
        return s.charAt(0) + removeString(s.substring(1));
    }
}
