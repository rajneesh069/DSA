package linearSearch;

public class MinIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                { -1, 23, 3 },
                { 2, 19, 8 },
                { 6, 7 }
        };
        System.out.println(minElementIn2DArray(arr));
    }

    static int minElementIn2DArray(int[][] arr) {
        int min = arr[0][0];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[col].length; col++) {
                if (min >= arr[row][col])
                    min = arr[row][col];
            }
        }
        return min;

    }
}
