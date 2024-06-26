package OOPs.OOP2;

public class Classes {
    // String name;
    // int age;

    public static void main(String[] args) {
        Classes obj1 = new Classes();
        // System.out.println(obj1.age); // > 0
        // System.out.println(obj1.name);// > null, set by default constructor
        Classes obj2; // reference is null, because object hasn't been instantiated.
        // System.out.println(obj2); // error that it's un-initialized
        System.out.println(obj1.toString()); // > the reference itself is never null
    }

}
