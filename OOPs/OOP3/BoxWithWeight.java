package OOPs.OOP3;

// Child class = Parent class's non-private methods and properties + some extra methods and properties 

public class BoxWithWeight extends Box {
    double weight;
    double price;

    BoxWithWeight() {
        // Box(); // one class cannot call the constructor of any other class,
        // it is not considered a constructor here, rather
        // a mere method.
        // super(); // Calls the constructor of the class just above it, i.e., Box class
        super(10, 11, 12); // Constructor call must be the first statement inside a constructor
        // if no super() call was made, Java automatically makes it without any argument
        // for the parent class.

        this.weight = -1;
        super.price = 10; // price is of the box class.
        this.price = 10000; // price is of 'this'(BoxWithWeight) class, if price property doesn't exist in
        // this class then it will set the price
        // in the Box (parent) class and inherit it.
    }

    // BoxWithWeight(String color) {
    // super.color = color;
    // not allowed as it is a private property in the paerent.
    // }

    BoxWithWeight(double l, double w, double h, double weight, double price) {
        // this(l, w, h, weight, price); //Not allowed, recursive constructor call.
        // this(); //allowed as it calls 'another' constructor (BoxWithWeight())
        super(l, w, h); // sets the value by calling the Box constructor, and then those values are
        // inherited by the object of BoxWithWeight class

        // this.w = 1000; // also possible but we prefer the super() constructor call,
        // will do the same thing

        this.weight = weight;
        this.price = price; // sets price for the object of BoxWithWeight class
        // super.price = price; // sets price for the parent class which could be
        // inherited if a constructor is
        // made in the parent class
    }

    public static void main(String[] args) {
        BoxWithWeight boxWithWeight1 = new BoxWithWeight();
        System.out.println(
                boxWithWeight1.l + " " + boxWithWeight1.w + " " + boxWithWeight1.h + " " + boxWithWeight1.weight);

        Box box = new BoxWithWeight(); // doesn't give error, why?
        // Because reference variable(box, here) determines the 'type of object' and NOT
        // the constructor call.
        // Obviously, only l, h, w can be accessed using the box object as Box class
        // doesn't have the weight property.
        System.out.println(box.l + " " + box.w + " " + box.h);
        // And the values will be initialized based on the BoxWithWeight() constructor
        // body.

        BoxWithWeight boxWithWeight2 = new BoxWithWeight(10, 11, 12, 13, 100);
        System.out.println(boxWithWeight2.l + " " + boxWithWeight2.w + " " + boxWithWeight2.h + " "
                + boxWithWeight2.weight + " " + boxWithWeight2.price);

        Box box2 = new BoxWithWeight(100, 100, 100, 250, 10000);
        System.out.println(box2.price + " " + box2.l + " " + box2.w + " " + box2.h);
        // BoxWithWeight boxWithWeight3 = new Box(); // not possible as boxWithWeight
        // class is a child class and may posses
        // extra properties which couldn't be set by the Box() constructor
    }
}
