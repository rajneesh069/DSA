package leetcode;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = { 'e',
                'e',
                'e',
                'e',
                'e',
                'e',
                'e',
                'n',
                'n',
                'n',
                'n',
                'n', };
        char[] letters1 = { 'g', 'f', 'c' };
        char[] letters2 = { 'c', 'f', 'g' };
        System.out.println(nextGreatestChar(letters, 'e'));
        System.out.println(nextGreatestChar(letters1, 'f'));
        System.out.println(nextGreatestChar(letters2, 'g'));
    }

    static char nextGreatestChar(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        boolean isAsc = letters[start] < letters[end];
        char[] arr = letters;
        char ans = letters[0]; // ye condition thii
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isAsc) {
                if (arr[mid] > target) {
                    ans = arr[mid];
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] > target) {
                    ans = arr[mid];
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return ans;
    }
}
