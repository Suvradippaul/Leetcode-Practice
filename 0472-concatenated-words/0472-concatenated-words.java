class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) set.add(word);
        
        List<String> ans = new ArrayList<>();
        
        for (String word : words) {
            int n = word.length();
            int[] dp = new int[n+1];
            dp[0] = 1;
            
            for (int i = 0; i < n; i++) {
                if (dp[i] == 0) continue;
                for (int j = i+1; j <= n; j++) {
//                	System.out.println("checking for " + word.substring(i, j) + " and j-i = " + (j-i));
                    if (j - i < n && set.contains(word.substring(i, j))) {
                        dp[j] = 1;
                    }
                }
                
                if (dp[n] == 1) {
                    ans.add(word);
                    break;
                }
            }
        }
        
        return ans;
    }
}