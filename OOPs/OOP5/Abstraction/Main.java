package OOPs.OOP5.Abstraction;

//Since static methods can't be overridden hence they can't be abstract.

//Final classes cannot be abstract, as abstract classes need to be inherited to modify abstract variables.

public class Main {
    public static void main(String[] args) {
        Child rajneesh = new Child();
        rajneesh.career("Coder");
        System.out.println(rajneesh.age);
        // rajneesh.age = 99; //cannot be re-assigned after assignment in constructor as
        // it is a final property

        // Parent mom = new Parent() { //This is how parent object could be created
        // @Override
        // void career(String name) {
        // System.out.println("I am a " + name);
        // }

        // @Override
        // void partner(String name, int age) {
        // System.out.println("Your father is me partner his name is " + name + " and
        // his age is " + age + ".");
        // }
        // };

        Parent sachin = new Child(); // this is possible obviously
        sachin.career("Engineer");
        sachin.partner("Shreya", 22);
        Parent.hello();
    }
}
