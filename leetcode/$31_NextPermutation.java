package leetcode;

public class $31_NextPermutation {
    public void nextPermutation(int[] arr) {
        int ind = -1;
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                ind = i;
                break;
            }
        }

        if (ind == -1) {
            reverse(arr, 0, arr.length - 1);
            return;
        }

        for (int i = n - 1; i >= ind; i--) {
            if (arr[i] > arr[ind]) {
                swap(arr, i, ind);
                break;
            }
        }

        reverse(arr, ind + 1, n - 1);

        return;
    }

    private void reverse(int[] arr, int start, int end) {
        // 1 2 3 4 -> 4 2 3 1 -> 4 3 2 1
        while (start < end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
