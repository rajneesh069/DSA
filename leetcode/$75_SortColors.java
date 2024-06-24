package leetcode;

public class $75_SortColors {
    public static void main(String[] args) {

    }

    public static void sortColors(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int end = arr.length - 1 - i;
            int max = getMaxElementIndex(arr, end);
            swap(arr, max, end);
        }
    }

    public static int getMaxElementIndex(int[] arr, int end) {
        int max = 0;
        for (int i = 0; i <= end; i++) {
            if (arr[max] <= arr[i]) {
                max = i;
            }
        }
        return max;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }
}
