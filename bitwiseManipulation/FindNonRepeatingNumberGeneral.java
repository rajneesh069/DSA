package bitwiseManipulation;

public class FindNonRepeatingNumberGeneral {
    public static void main(String[] args) {
        int[] arr = { 6, 6, 6, 3, 7, 7, 7, 3, 3, 69 };
        int[] arr1 = { 6, 6, 7, 7, 3, 3, 69 };
        System.out.println(findNonRepeatingNumber(arr, 3));
        System.out.println(findNonRepeatingNumber(arr1, 2));
    }

    static int binaryToDecimal(int num) {
        int ans = 0;
        int k = 1;
        while (num != 0) {
            ans = ans + (num % 10) * k;
            k = k * 2;
            num = num / 10;
        }
        return ans;
    }

    static int decimalToBinary(int num) {
        int ans = 0;
        int k = 1;
        while (num != 0) {
            ans = ans + (num % 2) * k;
            k = k * 10;
            num = num / 2;
        }

        return ans;
    }

    static int findNonRepeatingNumber(int[] arr, int numberOfMaxFixedRepitions) {
        if (numberOfMaxFixedRepitions % 2 == 0) {
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                ans ^= arr[i];
            }
            return ans;
        }

        int ans = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = decimalToBinary(arr[i]);
            sum += num;
        }
        
        int multiplyBy2 = 1;
        while (sum != 0) {
            int digit = sum % 10;
            if (digit % numberOfMaxFixedRepitions != 0) {
                ans = ans + (digit % numberOfMaxFixedRepitions) * multiplyBy2;
            }
            multiplyBy2 = multiplyBy2 * 2;
            sum = sum / 10;
        }

        return ans;
    }
}
