class Solution {
    public List<List<String>> groupAnagrams(String[] arr) {
        Map<String, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            String sortedStr = sort(arr[i]);
            if (map.isEmpty() || !map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(i);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for (var entry : map.entrySet()) {
            List<String> list = new ArrayList<>();
            for (Integer i : entry.getValue()) {
                list.add(arr[i]);
            }
            ans.add(list);
        }
        
        return ans;
    }
    
    String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}