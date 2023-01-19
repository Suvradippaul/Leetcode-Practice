class Solution {
    public int countHomogenous(String s) {
        int n = s.length();
        int ans = 0;
        int mod = (int)1e9+7;
        
        int freq = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i-1)) {
                freq++;
            }
            else {
                freq = 1;
            }
            
            ans = (ans + freq) % mod;
        }
        
        return ans;
    }
}