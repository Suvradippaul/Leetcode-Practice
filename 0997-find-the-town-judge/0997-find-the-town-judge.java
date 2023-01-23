class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0 && n == 1) return 1;
        Set<Integer> set = new HashSet<>();   // cannot be judge
            
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] t : trust) {
            if (!map.containsKey(t[1])) map.put(t[1], new ArrayList<>());
            map.get(t[1]).add(t[0]);
            set.add(t[0]);
        }
        
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i) && map.containsKey(i) && map.get(i).size() == n-1) return i;
        }
        
        return -1;
    }
}