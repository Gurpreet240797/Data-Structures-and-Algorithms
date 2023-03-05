package Recursion;

public class ClimbingStaircase {
    public static void main (String[] args) {
        int n = 3;
        int res = climbStairsWrapper(n, new int[n+1]);
        System.out.println(res);
    }

    public static int climbStairsWrapper(int i, int[] dp) {
        if (i == 1) return 1;
        if (i == 2) return 2;

        if (dp[i] == 0) {
            dp[i] = climbStairsWrapper(i-1, dp) + climbStairsWrapper(i-2, dp);
        }

        return dp[i];
    }
}
