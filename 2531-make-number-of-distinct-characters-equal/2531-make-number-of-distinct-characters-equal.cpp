class Solution {
public:
    bool isItPossible(string word1, string word2) {
        vector<int> map1(26, 0);
        vector<int> map2(26, 0);
        
        // store frequency of characters
        for (int i = 0; i < word1.length(); i++) map1[word1[i]-'a']++;
        for (int i = 0; i < word2.length(); i++) map2[word2[i]-'a']++;

        int count1 = 0, count2 = 0;
		// count no of distinct characters in each string
        for (int i = 0; i < 26; i++) {
            if (map1[i] > 0) count1++;
            if (map2[i] > 0) count2++;
        }
        
        // as explained in step 3
        if (count1 == count2 && word1.length() == word2.length()) return true;
        
        for (int i = 0; i < 26; i++) {
        	for (int j = 0; j < 26; j++) {
                if (map1[i] == 0 || map2[j] == 0) continue;
                
                int tempCount1 = count1, tempCount2 = count2;
                
				// changing char count for map1
                if (map1[j] == 0) tempCount1++;
                map1[j]++;
                
                if (map1[i] == 1) tempCount1--;
                map1[i]--;
                
				// changing char count for map2
                if (map2[i] == 0) tempCount2++;
                map2[i]++;
                
                if (map2[j] == 1) tempCount2--;
                map2[j]--;
                
				// if count of unique chars are same, return true
                if (tempCount1 == tempCount2) return true;
                
                map1[j]--;
                map1[i]++;
                map2[i]--;
                map2[j]++;
            }
        }
        
        return false;
    }
};