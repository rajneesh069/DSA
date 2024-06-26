package OOPs.OOP2;

@SuppressWarnings("unused")
public class StaticBlock {
    public static void main(String[] args) {
        StaticBlock obj = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b); // > Hey from Static Block 10 30

        // Hence static block ran just once after the creation of the first object which
        // is 'obj'

        StaticBlock.b += 10;
        System.out.println(StaticBlock.a + " " + StaticBlock.b); // > 10 40

        StaticBlock obj2 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);// > 10 40
    }
    // When an object is instantiated the static variables and blocks run first

    static int a = 10;
    static int b;

    // will run only once, when the first object of the class is instantiated.
    static {
        // could be used to initialize the static variables
        System.out.println("Hey from Static Block");
        b = a * 3;
    }

}
