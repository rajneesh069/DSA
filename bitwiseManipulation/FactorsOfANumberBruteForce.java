package bitwiseManipulation;

import java.util.ArrayList;

public class FactorsOfANumberBruteForce {
    public static void main(String[] args) {
        factors(40);
    }

    static void factors(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        int i = 1;
        while (i * i <= n) {
            if (n % i == 0) {
                if (n / i == i) {
                    System.out.print(i + " ");
                    continue;
                }
                System.out.print(i + " ");
                list.add(n / i);
            }
            i++;
        }
        for (int j = list.size() - 1; j >= 0; j--) {
            System.out.print(list.get(j) + " ");
        }
    }
}
