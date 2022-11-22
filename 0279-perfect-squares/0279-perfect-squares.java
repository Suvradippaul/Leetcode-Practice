class Solution {
    public int numSquares(int n) {
        list = new ArrayList<>();
        int num = (int)Math.sqrt(n)+1;
        for (int i = 1; i <= num; i++) {
            list.add(i*i);
        }
        
        int[][] dp = new int[num][num*num];
        for (int[] a : dp) Arrays.fill(a, -1);
        return solve(num-1, n, dp);
    }
    
    List<Integer> list = new ArrayList<>();
    int solve(int i, int n, int[][] dp) {
    	if (n == 0) return 0;
        if (i < 0 || n < 0) return 10000;
        
        if (dp[i][n] != -1) return dp[i][n];
        
        int pick = 10000;
        if (n >= list.get(i)) {
            pick = 1 + solve(i, n-list.get(i), dp);
        }
        int notPick = solve(i-1, n, dp);
        
        return dp[i][n] = Math.min(pick, notPick);
    }
}