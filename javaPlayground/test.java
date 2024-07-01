package javaPlayground;

@SuppressWarnings("unused")
public class test {

    public test() {

    }

    private class testClass {
        public int a = 10;
    }

    public static void main(String[] args) {
        test obj1 = new test();
        testClass obj = obj1.new testClass();
        int b = obj.a;
    }
}
