class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int i = 0;
        int j = n/2;
        
        int fHalf = 0;
        int sHalf = 0;
        while (j < n) {
            if (isVowel(s.charAt(i))) fHalf++;
            if (isVowel(s.charAt(j))) sHalf++;
            i++;
            j++;
        }
        
        return fHalf == sHalf;
    }
    
    boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') return true;
        return false;
    }
}