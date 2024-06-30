package backtracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        // System.out.println(totalNumberOfPaths(new int[] { 0, 0 }, new int[] { 2, 1
        // }));
        // printPaths("", 3, 3);
        // System.out.println(pathArray("", 3, 3));
        System.out.println(pathArrayDiagonal("", 3, 3));
    }

    static int totalNumberOfPaths(int[] start, int[] target) {
        int count = 0;
        if (start[0] == target[0] || start[1] == target[1]) {
            count++;
            return count;
        }

        int right = totalNumberOfPaths(new int[] { start[0], start[1] + 1 }, target);
        int down = totalNumberOfPaths(new int[] { start[0] + 1, start[1] }, target);
        count += right + down;
        return count;
    }

    static void printPaths(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 1) {
            printPaths(p + "D", r - 1, c);
        }

        if (c > 1) {
            printPaths(p + "R", r, c - 1);
        }
    }

    static ArrayList<String> pathArray(String p, int r, int c) {
        ArrayList<String> ans = new ArrayList<>();
        if (r == 1 && c == 1) {
            ans.add(p);
            return ans;
        }

        if (r > 1) {
            ArrayList<String> left = pathArray(p + "D", r - 1, c);
            ans.addAll(left);
        }

        if (c > 1) {
            ArrayList<String> right = pathArray(p + "R", r, c - 1);
            ans.addAll(right);
        }
        return ans;
    }

    static ArrayList<String> pathArrayDiagonal(String p, int r, int c) {
        ArrayList<String> ans = new ArrayList<>();
        if (r == 1 && c == 1) {
            ans.add(p);
            return ans;
        }

        if (r > 1 && c > 1) {
            ArrayList<String> diagonal = pathArrayDiagonal(p + "D", r - 1, c);
            ans.addAll(diagonal);
        }

        if (r > 1) {
            ArrayList<String> down = pathArrayDiagonal(p + "V", r - 1, c);
            ans.addAll(down);
        }

        if (c > 1) {
            ArrayList<String> right = pathArrayDiagonal(p + "H", r, c - 1);
            ans.addAll(right);
        }
        return ans;
    }
}
