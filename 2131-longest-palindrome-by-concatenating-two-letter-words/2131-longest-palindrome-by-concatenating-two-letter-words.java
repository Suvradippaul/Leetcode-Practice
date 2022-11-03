class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        
        int ans = 0;
        for (String word : words) {
            String flipped = "" + word.charAt(1) + word.charAt(0);
            if (map.containsKey(flipped)) {
                ans += 4;
                map.put(flipped, map.get(flipped)-1);
                if (map.get(flipped) == 0) map.remove(flipped);
            }
            else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            if (map.containsKey("" + ch + ch) && map.get("" + ch+ch) > 0) {
                ans += 2;
                break;
            }
        }
        
        return ans;
    }
}