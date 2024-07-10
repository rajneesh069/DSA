package backtracking;

@SuppressWarnings("unused")
public class NQueens2 {
    public static void main(String[] args) {

    }

    static void queens(boolean[][] board, int r, int c, int target) {
        if (r == board.length && c == board.length) {
            return;
        }

        if (r < board.length && c < board.length) {

        }

    }

    static boolean isSafe(boolean[][] board, int r, int c, int target) {
        // can place if empty
        if (board[r][c]) {
            return false;
        }

        // can't place in the same row
        for (int i = 0; i < board.length; i++) {
            if (board[r][c + i]) {
                return false;
            }
        }

        // can't place in the same column
        for (int i = 0; i < board.length; i++) {
            if (board[r + i][c]) {
                return false;
            }
        }

        // can't place on the left diagonal
        int maxLeft = Math.max(r, c);

        // can't place on the right diagonal
        int maxRight = Math.max(r, board.length - c - 1);

        return true;
    }
}
