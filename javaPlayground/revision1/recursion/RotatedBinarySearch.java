package javaPlayground.revision1.recursion;

public class RotatedBinarySearch {
    public static void main(String[] args) {

    }

    static int rotatedBinarySearch(int[] arr, int start, int end) {
        if (start >= end) {
            return start - 1;
        }
        int mid = start + (end - start) / 2;
        if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
            return mid + 1;
        } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        } else if (arr[mid] < arr[start]) {
            end = mid - 1;
            return rotatedBinarySearch(arr, start, end);
        } else if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
            if (arr[start] > arr[start + 1]) {
                return start;
            }
            start++;
            end--;
            return rotatedBinarySearch(arr, start, end);
        } else {
            start = mid + 1;
            return rotatedBinarySearch(arr, start, end);
        }
    }
}
