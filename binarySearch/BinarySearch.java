package binarySearch;

//array will already be sorted
//1. find the middle element
//2. if(target<mid) => then it exists on the left half -> search in left only
//   if(target>mid) => then it exists on the right half -> search in right only

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { -99, 1, 2, 4, 16, 22, 32, 69 };
        System.out.println(binarySearch(arr, 69));
    }

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + (end - start) / 2);
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }
}
