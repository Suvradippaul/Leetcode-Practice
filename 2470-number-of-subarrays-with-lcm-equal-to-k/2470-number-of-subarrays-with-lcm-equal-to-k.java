class Solution {
    public int subarrayLCM(int[] arr, int k) {
        int ans = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int lcm = 1;
            for (int j = i; j < arr.length; j++) {
                lcm = lcm(lcm, arr[j]);
                if (lcm == k) ans++;
            }
        }
        
        return ans;
    }
    
    int findGCD(int a, int b) {
        return b == 0 ? a : findGCD(b, a % b);   
    }
    
    int lcm(int a, int b) {
        return (a*b)/findGCD(a,b);
    }
}