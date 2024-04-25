package linearSearch;

public class MaxIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 23, 3 },
                { 2, 19, 8 },
                { 6, 7 }
        };
        System.out.println(maxElementIn2DArray(arr));
    }

    static int maxElementIn2DArray(int[][] arr) {
        int max = arr[0][0];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (max <= arr[row][col]) {
                    max = arr[row][col];
                }
            }
        }
        return max;
    }
}
