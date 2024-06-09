package leetcode;

public class $287_FindRepeatedNumber {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 2, 2 };
        System.out.println(findRepeatedNumber(arr));
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }

    public static int findRepeatedNumber(int[] arr) {
        int ans = -1;
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (correctIndex < arr.length && arr[correctIndex] != arr[i]) {
                swap(arr, i, correctIndex);
            } else {
                if (arr[i] != i + 1) {
                    return arr[i];
                }
                i++;
            }
        }

        // for (int j = 0; j < arr.length; j++) {
        // if (arr[j] != j + 1) {
        // ans = arr[j];
        // break;
        // }
        // }

        return ans;
    }
}
