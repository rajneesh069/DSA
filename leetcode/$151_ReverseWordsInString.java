package leetcode;

public class $151_ReverseWordsInString {
    public static void main(String[] args) {
        String s = "a";
        System.out.println("reverseWords Output:" + reverseWords(s));
    }

    public static String reverseWords(String s) {
        StringBuilder temp = new StringBuilder("");
        boolean isCharacterFound = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                isCharacterFound = true;
                temp.append(s.charAt(i));
            } else if (isCharacterFound == true && i != s.length() - 1) {
                isCharacterFound = false;
                temp.append(s.charAt(i));
            }
        }
        System.out.println(temp.length());
        StringBuilder finalString = new StringBuilder("");
        int start = temp.length() - 1;
        int end = temp.length() - 1;
        while (start >= 0) {
            if (start == 0) {
                finalString.append(temp.subSequence(start, end + 1));
                start--;
            } else if (temp.charAt(start) != ' ') {
                start--;
            } else if (temp.charAt(start) == ' ') {
                finalString.append(temp.subSequence(start + 1, end + 1)).append(" ");
                start--;
                end = start;

            }

        }

        return finalString.toString().trim();
    }
}
