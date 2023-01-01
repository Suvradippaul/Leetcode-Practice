class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (!map1.containsKey(ch)) {
                map1.put(ch, words[i]);
            }
            
            if (!map2.containsKey(words[i])) {
                map2.put(words[i], ch);
            }
            
            if (!map1.get(ch).equals(words[i]) || map2.get(words[i]) != ch) return false;
        }
        
        return true;
    }
}