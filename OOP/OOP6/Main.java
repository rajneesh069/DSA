package OOP.OOP6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        CustomArrayList list = new CustomArrayList();
        list.add(33);
        list.add(45);
        list.add(98);
        System.out.println(list);

        System.out.println(Arrays.toString(new int[] { 1, 2, 4 }));
    }
}
