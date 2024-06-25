package recursion.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 55, 66, 78 };
        int ans = search(arr, 66, 0, arr.length - 1);
        System.out.println("ans: " + ans); // 5 is returned.
        int ans1 = search(arr, -33, 0, arr.length - 1);
        System.out.println("ans1: " + ans1); // -1 is returned.
    }

    static int search(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            end = mid - 1;
            return search(arr, target, start, end);
        }
        start = mid + 1;
        return search(arr, target, start, end);

    }
}
