// package leetcode;

// public class RomanToInteger {
//     public static void main(String[] args) {
//         String s = "III";

//     }

//     static int romanToInt(String s) {
//         char[] arr = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
//         int ans = 0;
//         for (int i = s.length() - 1; i > 0; i--) {
//             int sub = subtract(s.charAt(i - 1), s.charAt(i));
//             ans -= sub;
//         }
//         return ans;
//     }

//     static int subtract(char first, char second) {
//         if (first == 'I' && second == 'V') {
//             return 4;
//         } else if (first == 'I' && second == 'X') {
//             return 9;
//         } else if (first == 'X' && second == 'L') {
//             return 40;
//         } else if (first == 'X' && second == 'C') {
//             return 90;
//         } else if (first == 'C' && second == 'D') {
//             return 400;
//         } else if (first == 'C' && second == 'M') {
//             return 900;
//         }
//         return 0;
//     }
// }
