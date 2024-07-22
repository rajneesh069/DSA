package javaPlayground.playground;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class test {

    public test() {

    }

    private class testClass {
        public int a = 10;
    }

    public static void main(String[] args) {

        ArrayList<Integer> innerList = new ArrayList<>();
        innerList.add(200);
        innerList.add(3);
        innerList.add(3);
        innerList.add(200);
        // for (int i = 0; i <= innerList.size() / 2; i++) {
        // if (innerList.get(i) != innerList.get(innerList.size() - 1 - i)) {
        // System.out.println("Here");
        // }
        // }
        int start = 0;
        int end = innerList.size() - 1;
        
        while (start <= end) {
            int a = innerList.get(start);
            int b = innerList.get(end);
            if (a != b) {
                System.out.println("here");
            }
            start++;
            end--;
        }

    }

}
