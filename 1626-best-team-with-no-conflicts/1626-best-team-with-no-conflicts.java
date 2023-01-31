class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        
        int[][] players = new int[n][2];  // [i][0] = age, [i][1] = score
        for (int i = 0; i < n; i++) {
            players[i][0] = ages[i];
            players[i][1] = scores[i];
        }
        
        Arrays.sort(players, (a, b) -> a[0] != b[0] ? (a[0] - b[0]) : (a[1] - b[1]));
        
        int[] dp = new int[n];
        int ans = 0; 
        
        for (int i = 0; i < n; i++) {
            dp[i] = players[i][1];
            for (int j = 0; j < i; j++) {
                if (players[j][1] <= players[i][1]) {
                    dp[i] = Math.max(dp[i], players[i][1] + dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}