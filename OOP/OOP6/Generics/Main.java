package OOP.OOP6.Generics;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        CustomArrayList<Integer> list = new CustomArrayList<Integer>();
        list.add(33);
        list.add(45);
        list.add(98);
        System.out.println(list);


        CustomArrayList<String> list2 = new CustomArrayList<String>();
        list2.add("2");
        list2.add("3");
        list2.add("4");
        System.out.println(list2);
    }

}
