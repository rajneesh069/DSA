package leetcode;

public class $67_AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1111", "10"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder("");
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int base = 2;

        // while (i >= 0 && j >= 0) {
        // int sum = 0;
        // int digit1 = a.charAt(i) - '0';
        // int digit2 = b.charAt(j) - '0';
        // sum = digit1 ^ digit2 ^ carry;
        // ans.append(sum);
        // if (digit1 + digit2 + carry >= 2) {
        // carry = 1;
        // } else {
        // carry = 0;
        // }
        // i--;
        // j--;

        // }

        // while (i >= 0) {
        // int sum = 0;
        // int digit1 = a.charAt(i) - '0';
        // sum = digit1 ^ carry;
        // ans.append(sum);
        // if (digit1 + carry >= 2) {
        // carry = 1;
        // } else {
        // carry = 0;
        // }
        // i--;
        // }

        // while (j >= 0) {
        // int sum = 0;
        // int digit2 = b.charAt(j) - '0';
        // sum = digit2 ^ carry;
        // ans.append(sum);
        // if (digit2 + carry >= 2) {
        // carry = 1;
        // } else {
        // carry = 0;
        // }
        // j--;
        // }

        // if(carry==1){
        // ans.append(1);
        // }

        while (i >= 0 || j >= 0) {
            int digit1 = 0;
            int digit2 = 0;
            int sum = 0;
            if (i >= 0) {
                digit1 = a.charAt(i--) - '0';
            }
            if (j >= 0) {
                digit2 = b.charAt(j--) - '0';
            }

            sum = digit1 + digit2 + carry;
            if (sum >= base) {
                carry = 1;
                sum -= base;

            } else {
                carry = 0;
            }
            ans.append(sum);
        }
        if (carry == 1) {
            ans.append(1);
        }
        return ans.reverse().toString();
    }

}
