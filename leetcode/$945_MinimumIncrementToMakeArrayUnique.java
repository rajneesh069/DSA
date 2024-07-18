package leetcode;

import java.util.Arrays;

public class $945_MinimumIncrementToMakeArrayUnique {
    public static void main(String[] args) {

    }

    public int minIncrementForUnique(int[] nums) {
        long gapSum = 0;
        long duplicateSum = 0;
        int numOfDuplicates = 0;
        long tempDuplicate = 0;
        int startIndex = -1;
        int[] f = new int[(int) (1e5 + 1)];

        for (int i = 0; i < nums.length; i++) {
            f[nums[i]]++;
        }

        for (int i = 0; i < f.length; i++) {
            if (startIndex == -1 && f[i] != 0) {
                startIndex = f[i];
            }
            if (f[i] > 1) {
                duplicateSum += (f[i] - 1) * i;
                numOfDuplicates += (f[i] - 1);
            }
        }
        System.out.println("frequencyArray: " + Arrays.toString(f));
        System.out.println("startIndex: " + startIndex);
        for (int i = startIndex; i < f.length; i++) {
            if (f[i] > 1) {
                tempDuplicate += f[i] - 1;
            }

            if (tempDuplicate != 0 && f[i] == 0) {
                gapSum += i;
                numOfDuplicates--;
                tempDuplicate--;
            }
            if (numOfDuplicates == 0) {
                break;
            }

        }
        System.out.println("gapSum: " + gapSum);
        System.out.println("duplicateSum: " + duplicateSum);
        if (tempDuplicate != 0) {
            gapSum += (long) (1e5) + (tempDuplicate) * (tempDuplicate + 1) / 2;
        }
        return (int) (gapSum - duplicateSum);
    }
}
