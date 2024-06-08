package javaPlayground;

public class j1 {
    public static void main(String[] args) {
        int[] arr = { 1, 3 };
        System.out.println(pivotElementIndex(arr));
    }

    static int pivotElementIndex(int[] arr) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                /*
                 * always put the condition first as it would be
                 * evaluated first hence arr[someIllegalIndex] case
                 * will never happen as the first condition will be
                 * false and due to '&&' operator language will never
                 * evaluate the second expression
                 */
                ans = mid;
                break;
            } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                ans = mid - 1;
                break;
            } else if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
