package javaPlayground.revision1.recursion;

public class Permuatations {
    public static void main(String[] args) {
        String up = new String("abc");
        String p = new String("");
        permuatations(up, p);
    }

    static void permuatations(String up, String p) {
        // since there will be variable function(recursive) calls at each step
        // hence we'll use loops to handle them
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permuatations(up.substring(1), f + ch + s);
        }
    }
}
