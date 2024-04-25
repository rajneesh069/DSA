package arrays;

import java.util.*;

public class ArrayLists {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(10);
        list.add(100);
        list.add(100);
        list.add(100);
        list.add(100);
        list.add(100);
        list.add(100);

        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
        list2.add(list);
        for (int i = 0; i < list2.size(); i++) {
            for (int j = 0; j < list2.get(i).size(); j++) {
                System.out.print(list2.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
