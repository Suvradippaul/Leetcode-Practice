class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        if (n2 < n1) return false;
        
        int[] s1Chars = new int[26];
        for (int i = 0; i < n1; i++) {
            s1Chars[s1.charAt(i)-'a']++;
        }
        
        int i = 0;
        int j = 0;
        
        while (j < n2) {
            if (j - i < n1) {
                s1Chars[s2.charAt(j)-'a']--;
                j++;
            }
            else {
                s1Chars[s2.charAt(i)-'a']++;
                i++;
            }
            
            if (allZeroes(s1Chars)) return true;
        }
        
        return false;
    }
    
    boolean allZeroes(int[] arr) {
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) return false;
        }
        
        return true;
    }
}