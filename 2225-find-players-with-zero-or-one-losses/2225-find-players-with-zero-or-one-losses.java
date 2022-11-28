class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> players = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            players.add(winner);
            players.add(loser);
            map.put(loser, map.getOrDefault(loser, 0) + 1);
        }
        
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int player : players) {
            if (!map.containsKey(player)) {
                list0.add(player);
            }
            else if (map.get(player) == 1) {
                list1.add(player);
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(list0);
        ans.add(list1);
        
        return ans;
    }
}