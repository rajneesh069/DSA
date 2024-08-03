package leetcode;
public class $3239_MinimumNumberOfFlipsToMakeBinaryGridPalindromic{
    public int minFlips(int[][] grid) {
        int flips = 0;
        flips = Math.min(rowPalindrome(grid), colPalindrome(grid));
        return flips;
    }

    private int flips(int[] grid){
        int ans = 0;
        for(int i=0; i<grid.length/2; i++){
            if(grid[i]!=grid[grid.length-i-1]){
                ans++;
            }
        }
        return ans;
    }

    private int rowPalindrome(int[][] grid){
        int n = grid.length;
        int ans = 0;

        for(int i=0; i < n; i++){
            ans+=flips(grid[i]);
        }

        return ans;

    }

    

    private int colPalindrome(int[][] grid){
        int m = grid[0].length;
        int n = grid.length;
        int col[] = new int[n];
        int ans = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j < n; j++){
                col[j] = grid[j][i];
            }
            ans+=flips(col);
        }
        return ans;
    }
}