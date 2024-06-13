public class Main {
    public static void main(String[] args) {
        StringBuilder sum = new StringBuilder("");
        sum.append("a");
        sum.append("b");
        sum.insert(0, "c");
        System.out.println(sum.toString());
    }

}
