package javaPlayground.playground;

public class RemoveACharacter {
    public static void main(String[] args) {
        String s = new String("bacaadaas");
        // remove(s, new StringBuilder(""));s
        System.out.println(skipChar(s));

    }

    static void remove(String s, StringBuilder ans) {
        if (s.isEmpty()) {
            System.out.println(ans);
            return;
        }

        if (s.charAt(0) == 'a') {
            remove(s.substring(1), ans);
        } else {
            ans.append(s.charAt(0));
            remove(s.substring(1), ans);
        }
    }

    static String skip(String s, StringBuilder ans) {
        if (s.isEmpty()) {
            return ans.toString();
        }

        if (s.charAt(0) == 'a') {
            return skip(s.substring(1), ans);
        } else {
            ans.append(s.charAt(0));
            return skip(s.substring(1), ans);
        }
    }

    static String skipChar(String s) {

        if (s.isEmpty()) {
            return "";
        }

        if (s.charAt(0) == 'a') {
            return skipChar(s.substring(1));
        }
        char ch = s.charAt(0);
        return (ch + skipChar(s.substring(1))).toString();

    }
}
