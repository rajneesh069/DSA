package libearSearch;

public class FindMaxNumber {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, -1, 6 };
        System.out.println(maxNumber(arr));
    }

    static int maxNumber(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            // if (max <= arr[i])
            // max = arr[i];
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
