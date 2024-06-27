package OOPs.OOP1;

public class OOP1 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Student rajneesh = new Student(80, 56, "Rajneesh");
        // new keyword instantiates the class, and the Student(80, 56, "Rajneesh") is
        // basically constructor getting called.
        System.out.println("Rajneesh:");
        System.out.println(rajneesh.marks);
        System.out.println(rajneesh.name);
        System.out.println(rajneesh.rollNo);
        Student sachin = new Student();
        System.out.println("Sachin:");
        System.out.println(sachin.marks);
        System.out.println(sachin.name);
        System.out.println(sachin.rollNo);

        // 'final' keyword, an object or a primitive of final type must be intialized at
        // the time of declaration.
        final int a = 5; // in case of primitives it doesn't allow you to change the value of the
        // variable.
        // a = 6; // not allowed
        System.out.println("a: " + a);

        // In case of objects, you can change the value of it's properties but you
        // cannot re-assign it.
        final Student mishra = new Student(90, 25, "Mishra");
        // mishra = rajneesh; // not allowed because of 'final' keyword.
        mishra.name = "Rajneesh"; // allowed
        System.out.println("mishra.name: " + mishra.name); // > Rajneesh
        System.out.println("mishra.marks: " + mishra.marks);// > 90
        System.out.println("mishra.rollNo: " + mishra.rollNo); // > 25

        Student random;
        for (int i = 0; i < 1000000; i++) { // simulating a good load on memory so that garbage collection hits
            random = new Student();
        }

    }
}

class Student {
    // Every class has a default constructor, and in this case it has been replaced
    // by the custom constructor.

    int marks = 700; // now default value of this property is 700.
    int rollNo;
    String name;

    Student() {
        System.out.println("Object has been created.");
        // calling another constructor from another constructor(in this case, the
        // default one), here 'this' calls the constructor.

        this(0, 0, "Default Name"); // calls the custom constructor

        // if there was no constructor / a constructor with no body or args was there
        // like this one, but no body, then default constructor will run and initialize
        // the default values if not provided by the user, like for int, it'll be 0, for
        // float, it'll be 0.0 and for objects like name in this case as it is a String
        // object it'll be 'null' by default.
    }

    Student(int marks, int rollNo, String name) {
        // here 'this' represents the future object that is going to be created for this
        // class, and binds that object's properties with these properties.
        this.marks = marks;
        this.name = name;
        this.rollNo = rollNo;
    }

    // Student(int marks, int rollNo, String name) {
    // marks = marks;
    // 'this' keyword here helps in distinguishing the local and object variables
    // this.name = name;
    // this.rollNo = rollNo;
    // }

    // In C++, we have destructors which basically gets exectued when an object is
    // destroyed and we can execute manual code. In Java, since it's garbage
    // collected we cannot really call a destructor but can call a finalize method
    // to tell what to do after Garbage Collection removes the object from Heap
    // Memory. Garbage collection automatically hits when there is a good load on
    // heap memory.

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is getting destroyed.");
    }

}
