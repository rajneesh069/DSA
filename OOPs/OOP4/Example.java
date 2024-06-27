package OOPs.OOP4;

//Access Modifiers
public class Example {
    public int a = 10;
    protected int b = 20;
    private int c = 30;
    int d = 40; // no access modifier

    public void setC(int c) {
        this.c = c;
    }

    public int getC() {
        return c;
    }
}

class Subclass extends Example { // protected inside the same package/file
    public static void main(String[] args) {
        Example e = new Example();
        e.d = 20;

    }
}
