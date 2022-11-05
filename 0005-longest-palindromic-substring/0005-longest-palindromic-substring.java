class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        
        // stores if substring from i to j is palindrome or not
        boolean[][] dp = new boolean[n][n];
        
        // denotes start and end of longest palindrome
        int start = 0, end = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                // check if the chars char at i and j are same
                boolean startEqualsEnd = s.charAt(i) == s.charAt(j);
                
                // only one character in window, it is always palindrome
                if (i == j) {
                    dp[i][j] = true;
                }
                
                // if 2 characters in window, it is palindrome if chars at i and j are same
                else if (i - j == 1) {
                    dp[i][j] = startEqualsEnd;
                }
                
                // if chars at i and j are same and the subtring from j+1 to i-1 is palindrome, then i to j is palindrome
                else if (startEqualsEnd && dp[i-1][j+1]) {
                    dp[i][j] = true;
                }
                
                
                // if this window is palindrome and length of it is longer than prev start and end, update them
                if (dp[i][j] && i-j > end-start) {
                    start = j;
                    end = i;
                }
            }
        }
        
        return s.substring(start, end+1);
    }
}