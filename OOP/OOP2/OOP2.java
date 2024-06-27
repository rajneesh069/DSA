package OOP.OOP2;
//Since Human class is 'public' and in same folder so no need to import it. 

import static OOP.example.Message.messageFn;

//Everything is eventually called inside a 'static' method(which is main obviously) and non-static methods/variables
//need an object's reference to work in 'static' environments.

@SuppressWarnings("unused")
public class OOP2 {
    public static void main(String[] args) {
        // packages are simply folders!!!
        // and it helps avoid the names of files to clash with each other
        messageFn();
        Human rajneesh = new Human("Rajneesh", 21, 100000, false);
        Human sachin = new Human("Sachin", 35, 1000000, true);
        System.out.println(rajneesh.name); // only possible if either the Human class is in same folder or if the
        // property is made public.
        System.out.println(Human.population);

        // greeting(); // gives error because it's non-static hence can't be accessed
        // inside static methods until or unless it is called using an object/instance

        // Running fun() method:

    }

    static void test() {
        // greeting(); // gives error here as well
        // to call the greeting function, we need an object of the class it is in, which
        // is OOP2, so:
        OOP2 obj = new OOP2();
        obj.greeting(); // now it works, because we referenced it with an object.
    }

    void fun() {
        // it works because, fun() itself is non-static so it will work only when called
        // with the help of an object so greeting will get that object's reference
        // too!!!
        greeting();
    }

    void greeting() { // non-static
        messageFn(); // static method could be called inside non-static because it is 'independent'
        // of objects
        System.out.println("Hello");
    }

}
