class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        
        for (char ch : word1.toCharArray()) map1[ch-'a']++;
        for (char ch : word2.toCharArray()) map2[ch-'a']++;
        
        for (int i = 0; i < 26; i++) {
        	if (map1[i] == 0) continue;
        	char ch1 = (char)(i+'a');
        	for (int j = 0; j < 26; j++) {
        		if (map2[j] == 0) continue;
        		char ch2 = (char)(j+'a');
        		
        		map1[ch2-'a']++;
        		map1[ch1-'a']--;
        		map2[ch1-'a']++;
        		map2[ch2-'a']--;
        		
        		if (count(map1) == count(map2)) return true;
        		
        		map1[ch2-'a']--;
        		map1[ch1-'a']++;
        		map2[ch1-'a']--;
        		map2[ch2-'a']++;
        	}
        }
        
        return false;
    }
    
    int count(int[] map) {
		int count = 0;
		for (int n : map) {
			if (n > 0) count++;
		}
		return count;
	}
}