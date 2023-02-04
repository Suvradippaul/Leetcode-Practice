class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        if (n2 < n1) return false;
        
        int[] s1Chars = new int[26];
        int noOfChars = 0;
        for (int i = 0; i < n1; i++) {
            if (s1Chars[s1.charAt(i)-'a'] == 0) noOfChars++;
            s1Chars[s1.charAt(i)-'a']++;
        }
        
        int i = 0;
        int j = 0;
        
        int[] s2Chars = new int[26];
        while (j < n2) {
            if (j - i < n1) {
                s2Chars[s2.charAt(j)-'a']++;
                j++;
            }
            else {
                s2Chars[s2.charAt(i)-'a']--;
                i++;
            }
            
            if (same(s1Chars, s2Chars)) return true;
        }
        
        return false;
    }
    
    boolean same(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}