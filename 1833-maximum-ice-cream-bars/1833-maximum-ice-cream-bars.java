class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] freq = new int[100001];
        for (int i = 0; i < costs.length; i++) {
            freq[costs[i]]++;
        }
        
        int count = 0;
        
        for (int i = 1; i < 100001; i++) {
            if (freq[i] > 0) {
                while (freq[i]-- > 0) {
                    if (coins >= i) {
                        count++;
                        coins -= i;
                    }
                    else {
                        return count;
                    }
                }
            }
        }
        
        return count;
    }
}