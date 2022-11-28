class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int n = matches.length;
        int[][] players = new int[100001][2];     // for all players --> participate, lose
        
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            
            players[winner][0] = 1;
            players[loser][0] = 1;    
                
            players[loser][1] += 1;
        }
        
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        
        for (int i = 1; i < players.length; i++) {
            int[] player = players[i];
            if (player[0] == 1) {
                if (player[1] == 0) {
                    list0.add(i);
                }
                else if (player[1] == 1) {
                    list1.add(i);
                }
            }
        }
        
        return new ArrayList<>(List.of(list0, list1));
    }
}