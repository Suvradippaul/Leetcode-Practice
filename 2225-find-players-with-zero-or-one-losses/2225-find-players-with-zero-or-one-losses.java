class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int n = matches.length;
        int[] losers = new int[100001];
        Set<Integer> players = new TreeSet<>();
        
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            
            players.add(winner);
            players.add(loser);
                
            losers[loser] += 1;
        }
        
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        
        for (int player : players) {
            if (losers[player] == 0) {
                list0.add(player);
            }
            else if (losers[player] == 1) {
                list1.add(player);
            }
        }
        
        return new ArrayList<>(List.of(list0, list1));
    }
}