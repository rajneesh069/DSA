package stringsAndStringbuilder;

public class StringPerformance {
    public static void main(String[] args) {
        String series = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            series += ch;
        }
        // in each iteration a new object is created and the previously created objects
        // basically waste memory[O(n^2) = O(1+2+3+...+25 == 1+2+3+...+N)]
        // to avoud that we'll use StringBuilder data type
        System.out.println("Series: " + series);
    }
}
