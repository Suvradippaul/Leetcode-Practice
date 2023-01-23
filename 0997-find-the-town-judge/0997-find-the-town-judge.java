class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustees = new int[n+1];       // how many people trust this person
        int[] trusts = new int[n+1];         // this person trusts how many persons
        
        for (int[] t : trust) {
            trusts[t[0]]++;
            trustees[t[1]]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (trusts[i] == 0 && trustees[i] == n-1) return i;
        }
        
        return -1;
    }
}