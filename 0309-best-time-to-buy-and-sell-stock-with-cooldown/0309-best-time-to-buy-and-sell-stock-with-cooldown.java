class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        for (int[] row : dp) Arrays.fill(row, -1);
        
        return solve(prices, 0, 1, dp);
    }
    
    int solve(int[] arr, int i, int toBuy, int[][] dp) {
        if (i >= arr.length) return 0;
        
        if (dp[i][toBuy] != -1) return dp[i][toBuy];
        
        if (toBuy == 1) {
            int buy = -arr[i] + solve(arr, i+1, 0, dp);
            int notBuy = solve(arr, i+1, 1, dp);
            
            return dp[i][toBuy] = Math.max(buy, notBuy);
        }
        else {
            int sell = arr[i] + solve(arr, i+2, 1, dp);
            int notSell = solve(arr, i+1, 0, dp);
            
            return dp[i][toBuy] = Math.max(sell, notSell);
        }
    }
}