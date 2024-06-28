package recursion.stringsQuestions;

public class RemoveAString {
    public static void main(String[] args) {
        String s = new String("bccappleadseapple");
        System.out.println(removeString(s));
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
}
