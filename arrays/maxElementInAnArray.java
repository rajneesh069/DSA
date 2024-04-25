package arrays;

public class maxElementInAnArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 34, 5 };
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);
    }
}
