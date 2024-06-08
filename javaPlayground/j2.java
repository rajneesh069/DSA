package javaPlayground;

public class j2 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 3, 1 };
        System.out.println(peakIndexInBitonicMountainArray(arr));
    }

    /* 
     * 
     *  
     */

    static int peakIndexInBitonicMountainArray(int[] arr) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < arr.length - 1 && arr[mid] < arr[mid + 1]) { // ascending side of mountain
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
}
