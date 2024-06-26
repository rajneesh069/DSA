package OOPs.OOP3;

public class Box {
    double h, w, l;
    double price; // declared just for a use case of super keyword.
    private String color;

    Box() {
        super(); // this calls the Object class constructor, every class is inherited from
        // the in-built Object class
        this.h = -1;
        this.l = -1;
        this.w = -1;
        // BoxWithWeight(); // can't be called here as it is undefined for type Box
    }

    Box(double l, double w, double h) {
        this.h = h;
        this.w = w;
        this.l = l;
    }

    Box(Box b) {
        this.h = b.h;
        this.w = b.w;
        this.l = b.l;
    }

    Box(double side) { // cube
        this.w = this.h = this.l = side;
    }
}
