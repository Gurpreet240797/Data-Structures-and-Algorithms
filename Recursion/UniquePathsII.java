package Recursion;

public class UniquePathsII {
    public static void main(String args[]) {
        int[][] obstacle = {{0}};
        int m = obstacle.length;
        int n = obstacle[m-1].length;
        int res = wrapperUniquePaths(m, n, obstacle, new int[m+1][n+1]);
        System.out.println(res);
    }

    public static int wrapperUniquePaths(int m, int n, int[][] obstacle, int[][] dp) {
        if (m == 1 && n == 1) return 1;
        if (m>0 && n>0 && obstacle[m-1][n-1] != 1 && dp[m][n] == 0) {
            dp[m][n] = wrapperUniquePaths(m-1, n, obstacle, dp) + wrapperUniquePaths(m, n-1, obstacle, dp);
        }
        return dp[m][n];
    }
}
