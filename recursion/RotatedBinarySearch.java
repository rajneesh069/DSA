package recursion;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(pivotElementWithDuplicateElementsIndex(arr, 0, arr.length - 1));
    }

    static int pivotElementWithDuplicateElementsIndex(int[] arr, int start, int end) {
        if (start > end) {
            return start - 1;
        }
        int mid = start + (end - start) / 2;
        if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (mid >= 1 && arr[mid - 1] > arr[mid]) {
            return mid - 1;
        } else if (arr[mid] < arr[start]) {
            end = mid - 1;
            return pivotElementWithDuplicateElementsIndex(arr, start, end);
        } else if (arr[mid] == arr[end] && arr[mid] == arr[start]) {
            if (start < end && arr[start] > arr[start + 1]) {
                return start;
            }
            start++;
            end--;
            return pivotElementWithDuplicateElementsIndex(arr, start, end);
        } else {
            start = mid + 1;
            return pivotElementWithDuplicateElementsIndex(arr, start, end);
        }
    }

    /* 
     * static int pivotElementWithDuplicateElementsIndex(int[] arr, int start, int end) {
        if (start > end) {
            return start - 1;
        }
        int mid = start + (end - start) / 2;
        if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (mid >= 1 && arr[mid - 1] > arr[mid]) {
            return mid - 1;
        } else if (arr[mid] > arr[start]) {
            start = mid + 1;
            return pivotElementWithDuplicateElementsIndex(arr, start, end);
        } else if (arr[start] == arr[mid] && arr[mid] != arr[end]) {
            start = mid + 1;
            return pivotElementWithDuplicateElementsIndex(arr, start, end);
        } else if (arr[mid] == arr[end] && arr[mid] == arr[start]) {
            if (start < end && arr[start] > arr[start + 1]) {
                return start;
            }
            start++;
            end--;
            return pivotElementWithDuplicateElementsIndex(arr, start, end);
        } else {
            end = mid - 1;
            return pivotElementWithDuplicateElementsIndex(arr, start, end);
        }
    }
     */
}
