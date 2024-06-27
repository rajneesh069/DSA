package OOP.OOP6.CompareObjects;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student rajneesh = new Student(2056, 76.3f);
        Student harsh = new Student(2023, 8.3f);
        Student lakshya = new Student(2048, 7.65f);
        Student[] students = { rajneesh, harsh, lakshya };
        System.out.println(Arrays.toString(students));
        Arrays.sort(students); // based on compareTo method
        System.out.println(Arrays.toString(students));
        Arrays.sort(students, (o1, o2) -> (int) (o2.marks - o1.marks));
        System.out.println(Arrays.toString(students));

    }
}
