package OOPs.OOP4;

public class ObjectClassDemo {
    int num;
    float gpa;

    ObjectClassDemo(int num, float gpa) {
        this.num = num;
        this.gpa = gpa;
    }

    @Override
    public boolean equals(Object obj) {
        return this.num == ((ObjectClassDemo) obj).num; // type cast the Object type obj to ObjectClassDemo as every
        // class inherits from the Object class directly or indirectly
    }

    public static void main(String[] args) {
        ObjectClassDemo obj1 = new ObjectClassDemo(10, 8.7f);
        ObjectClassDemo obj2 = new ObjectClassDemo(10, 7.36f);
        ObjectClassDemo obj3 = obj2;

        if (obj1 == obj2) { // checks reference in the memory if they are pointing to same object, basically
            // addresses
            System.out.println("obj1 == obj2");
        }

        if (obj2 == obj3) { // runs as the reference variables point to the same object
            System.out.println("obj2==obj3");
        }

        if (obj1.equals(obj2)) { // doesn't know which property/ how to check the equality here, we need to
            // override it
            System.out.println("Equal");
        }

        System.out.println(obj1 instanceof ObjectClassDemo); // > true
        System.out.println(obj1 instanceof Object); // > true
        System.out.println(obj1.getClass());
        System.out.println(obj1.getClass().getConstructors());
    }
}
