package Recursion;

public class UniquePaths {
    public static void main(String args[]) {
        int m=3;
        int n=3;
        int res = wrapperUniquePaths(m, n, new int[m+1][n+1]);
        System.out.println(res);
    }

    public static int wrapperUniquePaths(int m, int n, int[][] dp) {
        if (m==1 && n ==1) return 1;
        if (m>0 && n>0 && dp[m][n] == 0) {
            dp[m][n] = wrapperUniquePaths(m-1, n, dp) + wrapperUniquePaths(m, n-1, dp);
        }

        return dp[m][n];
    }
}
