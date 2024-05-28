public class Main {
    public static void main(String[] args) {
        System.out.println(binarySearchAlgo(new int[] {1,2,2,3,4,5,5,6}, 4));
    }

    static int binarySearchAlgo(int[] arr, int target) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
}
