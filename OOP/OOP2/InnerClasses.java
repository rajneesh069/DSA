package OOP.OOP2;

import OOP.OOP2.InnerClasses.Example.InnerExampleClass;

// A top-level class can't be static because the static keyword is used in the context
// of nested classes. It indicates that the static class (inner) is independent of
// the outer class in which it is defined and can be instantiated without an object of the parent class.
@SuppressWarnings("unused")
public class InnerClasses {

    static class Example {
        // this could be static as it is defined inside a class and in this context it
        // means that is independent of the class it is enclosed in.

        static class InnerExampleClass {
            // nested static class
        }

        // since static stuff doesn't depend on objects hence they are resolved during
        // the compile-time.
    }

    class NonStatic {

    }

    public static void main(String[] args) {
        InnerExampleClass innerExampleClassObj = new InnerExampleClass(); // can be instantiated without the need of an
        // object from parent class

        Example exampleObj = new Example(); // static keyword independence

        // NonStatic obj = new NonStatic(); //gives error as an object of parent class
        // is required to instantiate.
        InnerClasses mainObj = new InnerClasses();
        NonStatic nestedObj = mainObj.new NonStatic(); // Now it can be instantiated

    }

}

// static class OuterClass { // Error because not enclosed inside any class.

// }
