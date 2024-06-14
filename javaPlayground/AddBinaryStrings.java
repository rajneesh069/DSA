package javaPlayground;

public class AddBinaryStrings {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0, base = 2;
        StringBuilder ans = new StringBuilder("");
        while (i >= 0 || j >= 0) {
            int digit1 = 0, digit2 = 0, sum = 0;
            if (i >= 0) {
                digit1 = a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                digit2 = b.charAt(j) - '0';
                j--;
            }
            sum = digit1 + digit2 + carry;
            if (sum >= base) {
                sum -= base;
                carry = 1;
            } else {
                carry = 0;
            }
            ans.append(sum);
        }

        if (carry == 1) {
            ans.append(carry);
        }

        return ans.reverse().toString();
    }
}
