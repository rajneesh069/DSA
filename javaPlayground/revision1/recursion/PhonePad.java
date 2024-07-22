package javaPlayground.revision1.recursion;

import java.util.ArrayList;

public class PhonePad {
    public static void main(String[] args) {
        String up = new String("234");
        String p = new String("");
        phonePadCombinations(p, up);
    }

    static void phonePadCombinations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int n = (int) (up.charAt(0) - '0');
        if (n == 7) {
            for (int i = 3 * (n - 2); i < 3 * (n - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                String f = p.substring(0, p.length());
                phonePadCombinations(f + ch, up.substring(1));
            }
        } else if (n == 8) {
            for (int i = 3 * (n - 2) + 1; i < 3 * (n - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                String f = p.substring(0, p.length());
                phonePadCombinations(f + ch, up.substring(1));
            }
        } else if (n == 9) {
            for (int i = 3 * (n - 2) + 1; i < 3 * (n - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                String f = p.substring(0, p.length());
                phonePadCombinations(f + ch, up.substring(1));
            }
        } else {
            for (int i = 3 * (n - 2); i < 3 * (n - 1); i++) {
                char ch = (char) ('a' + i);
                String f = p.substring(0, p.length());
                phonePadCombinations(f + ch, up.substring(1));
            }
        }
    }

    static ArrayList<String> phonePadCombinationsList(String p, String up) {
        ArrayList<String> currentList = new ArrayList<>();
        if (up.isEmpty()) {
            currentList.add(p);
            return currentList;
        }
        int n = (int) (up.charAt(0) - '0');
        if (n == 7) {
            for (int i = 3 * (n - 2); i < 3 * (n - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                String f = p.substring(0, p.length());
                ArrayList<String> prev = phonePadCombinationsList(f + ch, up.substring(1));
                currentList.addAll(prev);
            }
        } else if (n == 8) {
            for (int i = 3 * (n - 2) + 1; i < 3 * (n - 1) + 1; i++) {
                char ch = (char) ('a' + i);
                String f = p.substring(0, p.length());
                ArrayList<String> prev = phonePadCombinationsList(f + ch, up.substring(1));
                currentList.addAll(prev);
            }
        } else if (n == 9) {
            for (int i = 3 * (n - 2) + 1; i < 3 * (n - 1) + 2; i++) {
                char ch = (char) ('a' + i);
                String f = p.substring(0, p.length());
                ArrayList<String> prev = phonePadCombinationsList(f + ch, up.substring(1));
                currentList.addAll(prev);
            }
        } else {
            for (int i = 3 * (n - 2); i < 3 * (n - 1); i++) {
                char ch = (char) ('a' + i);
                String f = p.substring(0, p.length());
                ArrayList<String> prev = phonePadCombinationsList(f + ch, up.substring(1));
                currentList.addAll(prev);
            }
        }
        return currentList;
    }

}
