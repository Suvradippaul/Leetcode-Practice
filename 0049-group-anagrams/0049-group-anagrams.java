class Solution {
    public List<List<String>> groupAnagrams(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            String sortedStr = sort(arr[i]);
            if (map.isEmpty() || !map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(arr[i]);
        }
        
        return new ArrayList<>(map.values());
    }
    
    String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}