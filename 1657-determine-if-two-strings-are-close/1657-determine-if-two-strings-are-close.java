class Solution {
    public boolean closeStrings(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        if (n1 != n2) return false;
        
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        
        for (int i = 0; i < n1; i++) {
            freq1[s1.charAt(i) - 'a'] += 1;
            freq2[s2.charAt(i) - 'a'] += 1;
        }
        
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] > 0) || (freq2[i] == 0 && freq1[i] > 0)) return false;
        }
        
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) return false;
        }
        
        return true;
    }
}