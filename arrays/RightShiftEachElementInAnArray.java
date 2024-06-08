// package arrays;

// import java.util.Arrays;

// public class RightShiftEachElementInAnArray {
//      public static void rightShiftArray(int[] arr) {
//         if(arr == null || arr.length == 0) {
//             return; // No need to shift an empty array or null array
//         }
        
//         int last = arr[arr.length - 1]; // Store the last element
//         for(int i = 0; i < arr.length - 1; i++) {
//             arr[i + 1] = arr[i]; // Shift each element to the right
//         }
//         arr[0] = -1; // Set the first element to -1
//     }

//     public static void main(String[] args) {
//         int[] arr = {1, 2, 3, 4, 5};
//         System.out.println("Original array: " + Arrays.toString(arr));
        
//         rightShiftArray(arr);
//         System.out.println("Array after right shift: " + Arrays.toString(arr));
//     }
// }
