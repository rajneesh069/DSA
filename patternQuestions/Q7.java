package patternQuestions;

//             1
//         2   1   2 
//     3   2   1   2   3
// 4   3   2   1   2   3   4    

public class Q7 {

    public static void main(String[] args) {
        pattern6(4);
    }

    static void pattern6(int n) {
        for (int row = 1; row <= n; row++) {
            int numOfSpaces = n - row;
            for (int spaces = 1; spaces <= numOfSpaces; spaces++) {
                System.out.print(" " + " "); // extra space for cleanliness
            }

            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }

            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }

            System.out.println();
        }
    }
}
