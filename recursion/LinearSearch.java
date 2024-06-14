package recursion;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 78, 32, 9 };
        int target = 69;
        System.out.println(search(arr, target, 0));
    }

    static int search(int[] arr, int target, int start) {
        if (start == arr.length - 1) {
            if (arr[start] == target) {
                return start;
            } else {
                return -1;
            }
        } else if (arr[start] == target) {
            return start;
        }
        return search(arr, target, ++start);
    }
}
