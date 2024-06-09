package leetcode;

public class $41_MissingPositive {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 2 };
        System.out.println(firstMissingPositive(arr));
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static int firstMissingPositive(int[] arr) {
        int ans = 1;
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }

        if (min <= 1) {
            int i = 0;
            while (i < arr.length) {
                int correctIndex = arr[i] - 1;
                if (correctIndex > -1 && correctIndex < arr.length && arr[correctIndex] != arr[i]) {
                    swap(arr, i, correctIndex);
                } else {
                    i++;
                }
            }

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != j + 1) {
                    return j + 1;
                }
            }

            ans = arr.length + 1;
        }

        return ans;
    }
}
