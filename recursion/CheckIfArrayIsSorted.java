package recursion;

public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        int[] arr = { 1, 23, 2 };
        System.out.println(isSorted(arr, 0));
    }

    // static boolean isSorted(int[] arr, int start) {
    // if (start == arr.length - 1) {
    // return true;
    // }
    // return arr[start] <= arr[start + 1] && isSorted(arr, ++start); // ascending
    // order
    // }
    static boolean isSorted(int[] arr, int start) {
        if (start == arr.length - 1) {
            return true;
        }
        if (arr[start] <= arr[start + 1]) {
            return isSorted(arr, ++start);
        }
        return false;
    }
}
