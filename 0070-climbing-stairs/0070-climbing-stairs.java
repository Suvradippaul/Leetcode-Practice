class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return solve(n, dp);
    }
    
    int solve(int n, int[] dp) {
        if (n==0 || n==1) return 1;
        if (dp[n] != 0) return dp[n];
        
        int takeOneStep = solve(n-1, dp);
        int takeTwoStep = solve(n-2, dp);
        
        return dp[n] = takeOneStep + takeTwoStep;
    }
}