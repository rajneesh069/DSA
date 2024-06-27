package OOP.OOP6.CompareObjects;

public class Student implements Comparable<Student> {
    float marks = 0;
    int roll = 0;

    Student(int roll, float marks) {
        this.roll = roll;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return marks + "";
    }

    @Override
    public int compareTo(Student o) {
        return (int) (this.marks - o.marks);
    }

}
