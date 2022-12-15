class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
		int[][] dp = new int[n][m];
		for (int[] a : dp) Arrays.fill(a, -1);
        
        return solve(s1, s2, n-1, m-1, dp);
    }
    
    int solve(String s1, String s2, int index1, int index2, int[][] dp) {
		if (index1 < 0 || index2 < 0) return 0;

		if (dp[index1][index2] != -1) return dp[index1][index2];

		if (s1.charAt(index1) == s2.charAt(index2)) {
			return dp[index1][index2] = 1 + solve(s1, s2, index1 - 1, index2 - 1, dp);
		} else {
			return dp[index1][index2] = Math.max(solve(s1, s2, index1 - 1, index2, dp), solve(s1, s2, index1, index2 - 1, dp));
		}
	}
}