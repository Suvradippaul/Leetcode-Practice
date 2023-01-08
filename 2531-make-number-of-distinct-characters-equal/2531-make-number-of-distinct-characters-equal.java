class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        
        for (char ch : word1.toCharArray()) map1[ch-'a']++;
        for (char ch : word2.toCharArray()) map2[ch-'a']++;
        
        for (int i = 0; i < 26; i++) {
        	if (map1[i] == 0) continue;
        	for (int j = 0; j < 26; j++) {
        		if (map2[j] == 0) continue;
        		
        		map1[j]++;
        		map1[i]--;
        		map2[i]++;
        		map2[j]--;
        		
        		if (same(map1, map2)) return true;
        		
        		map1[j]--;
        		map1[i]++;
        		map2[i]--;
        		map2[j]++;
        	}
        }
        
        return false;
    }
    
    boolean same(int[] map1, int[] map2) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < 26; i++) {
            if (map1[i] > 0) count1++;
            if (map2[i] > 0) count2++;
        }
        
        return count1 == count2;
    }
}