package OOP.OOP5.Interfaces.Extend;

public class Main2 implements Main.NestedInterface {
    // Nested Interface could be public, private, protected or anything but
    // top-level needs to be public.

    @Override
    public boolean isOdd(int num) {
        if ((num & 1) != 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Main2 obj = new Main2();
        boolean ans = obj.isOdd(32);
        System.out.println(ans);
    }
}
