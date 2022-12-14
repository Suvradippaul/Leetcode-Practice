class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
        return solve(arr, n-1, dp);
    }
    
    int solve(int[] arr, int index, int[] dp) {
		if (index==0) return arr[0];
		if (index < 0) return 0;
		
		if (dp[index] != -1) return dp[index];

		int lootCurr = arr[index] + solve(arr, index-2, dp);

		int dontLootCurr = solve(arr, index-1, dp);
		
		dp[index] = Math.max(lootCurr, dontLootCurr);

		return dp[index];
	}
}