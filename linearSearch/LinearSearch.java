package linearSearch;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println((linearSearch(arr, 3)));

    }

    static int linearSearch(int[] arr, int el) {
        if (arr.length != 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == el) {
                    return i;
                }
            }
        }
        return -1;
    }
}
