class Solution {
    public int countSubstrings(String s) {
        int[] dp = new int[s.length()];
		Arrays.fill(dp, -1);
		solve(s, 0, dp);
		return count;
    }
    
    int count = 0;
	void solve(String s, int i, int[] dp) {
		if (i == s.length()) return;
		
		if (dp[i] != -1) return;
		
		for (int start = i; start < s.length(); start++) {
			if (palindrome(s, i, start)) {
				count++;
			}
			solve(s, i+1, dp);
		}
		
		dp[i] = count;
	}

	boolean palindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}
}