package OOPs.OOP2;

//Methods and variables both could be static, if they are independent of the enclosing class.
//Use of the static keyword depends on the context (static is used in case of nesting) it is being used.
//Nested static classes represent that they don't need each other's object to get instantiated.
//Top level classes cannot be static as they are not enclosed by any class hence the keyword static there doesn't make any sense.

public class SingletonClass {
    private SingletonClass() {// this cannot be static because obviously objects use constructors to
        // instantiate themselves.

        // constructor has been made private so that it cannot be called to make an
        // object, elsewhere outside the class.
    }

    private static SingletonClass instance; // instance made static because it needs to get called inside a static
    // method and needs to get checked if it is null or not.

    // SingletonClass someObj = new SingletonClass(); -> cannot be done elsewhere,
    // hence object of this class cannot be instantiated.

    public static SingletonClass getInstance() { // since this method needs to get invoked in order to create an
        // instance, and an instance cannot be created elsewhere because the constructor
        // is private so I had to make it static, because I don't want the user to be
        // able to create more than one objects/instances.
        if (instance == null) {
            instance = new SingletonClass(); // instantiated the object now, if it didn't exist already.
        }
        return instance; // returns same instance everytime.
    }

    public static void main(String[] args) {

    }

}
