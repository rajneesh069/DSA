package recursion.stringsQuestions;

public class RemoveACharacter {

    public static void main(String[] args) {
        String s = new String("baccadcsa");
        // System.out.println(removeChar(s, 0));
        System.out.println(skip(s));
    }

    static String removeChar(String s, int start) {
        StringBuilder ans = new StringBuilder("");
        if (start == s.length()) {
            return ans.toString();
        }
        if (s.charAt(start) != 'a') {
            ans.append(s.charAt(start));
        }
        StringBuilder prevAns = new StringBuilder(removeChar(s, ++start));
        ans.append(prevAns);
        return ans.toString();
    }

    // static String skip(String up) {
    // if (up.isEmpty()) {
    // return "";
    // }
    // char ch = up.charAt(0);
    // if (up.charAt(0) == 'a') {
    // return skip(up.substring(1));
    // }
    // return ch + skip(up.substring(1));

    // }

    static String skip(String up, String ans) {
        if (up.isEmpty()) {
            return ans;
        }

        char ch = up.charAt(0);
        if (ch == 'a') {
            return skip(up.substring(1), ans);
        }
        return skip(up.substring(1), ans + ch);
    }

    static String skip(String s) {
        String ans = new String();
        if (s.isEmpty()) {
            return ans;
        }

        if (s.charAt(0) != 'a') {
            ans = s.charAt(0) + ans;
            return ans + skip(s.substring(1));
        }

        return skip(s.substring(1));

    }

}
