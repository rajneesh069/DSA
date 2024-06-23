package leetcode;

public class $1903_FindLargestOddNumber {
    public static void main(String[] args) {

    }

    public static String largestOddNumber(String num) {
        int end = num.length() - 1;
        while (end >= 0) {
            if (num.charAt(end) == '1' || num.charAt(end) == '3' || num.charAt(end) == '5'
                    || num.charAt(end) == '7' || num.charAt(end) == '9') {
                break;
            } else {
                end--;
            }
        }
        if (end == -1) {
            return "";
        }
        return num.subSequence(0, end + 1).toString();
    }
}
