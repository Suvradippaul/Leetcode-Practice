class Solution {
    int mod = (int)1e9+7;
    public int numTilings(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;
        
        int prev3 = 1;
        int prev2 = 2;
        int prev1 = 5;
        int curr = 0;
        
        for (int i = 4; i <= n; i++) {
            curr = (2*prev1%mod + prev3%mod) % mod;
            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        
        return curr;
    }
}