package libearSearch;

public class FindMinNumber {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, -1, 6 };
        System.out.println(minNum(arr));
    }

    static int minNum(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            // if (min >= arr[i]) {
            // min = arr[i];
            // }
            min = Math.min(min, arr[i]);
        }
        return min;
    }
}
