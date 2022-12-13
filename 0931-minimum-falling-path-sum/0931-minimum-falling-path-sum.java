class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        // int m = matrix[0].length;  same as n --> mentioned in question
        
        int[][] dp = new int[n][n];
        
        int minSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, solve(matrix, 0, col, n, dp));
        }
        
        return minSum;
    }
    
    int solve(int[][] matrix, int i, int j, int n, int[][] dp) {
        if (j >= n || j < 0) return 100000;
        if (i == n-1) return matrix[i][j];
        
        if (dp[i][j] != 0) return dp[i][j];
        
        int down = matrix[i][j] + solve(matrix, i+1, j, n, dp);
        int downLeft = matrix[i][j] + solve(matrix, i+1, j-1, n, dp);
        int downUp = matrix[i][j] + solve(matrix, i+1, j+1, n, dp);
        
        return dp[i][j] = Math.min(down, Math.min(downLeft, downUp));
    }
}