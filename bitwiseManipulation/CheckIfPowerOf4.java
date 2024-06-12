package bitwiseManipulation;

public class CheckIfPowerOf4 {

    public static void main(String[] args) {
        powerOf4(5);
    }

    static boolean powerOf4(int n) {
        int count = 0;
        int pos = -1;
        if (n <= 0) {
            return false;
        }

        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
                pos = i;
            }
            if (count >= 2) {
                return false;
            }
        }

        System.out.println("count: " + count);
        System.out.println("pos: " + pos);

        return false;
    }

}
