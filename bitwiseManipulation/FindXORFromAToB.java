package bitwiseManipulation;

public class FindXORFromAToB {
    public static void main(String[] args) {
        // find xor from 3 to 9
        System.out.println(xor(2) ^ xor(9));
    }

    static int xor(int a) {
        if (a % 4 == 0) {
            return a;
        } else if (a % 4 == 1) {
            return 1;
        } else if (a % 4 == 2) {
            return a + 1;
        }
        return 1;
    }
}
