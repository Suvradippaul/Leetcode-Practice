class Solution {
    public String smallestEquivalentString(String s1, String s2, String t) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < 26; i++) adj.add(new ArrayList<>());
        
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            
            adj.get(ch1-'a').add(ch2-'a');
            adj.get(ch2-'a').add(ch1-'a');
        }
        
        int[] minimums = new int[26];
        for (int i = 0; i < 26; i++) {
        	int[] min = new int[1];
        	min[0] = i;
        	dfs(i, adj, new int[26], min);
        	minimums[i] = min[0];
        }
        
        char[] ans = new char[t.length()];
        for (int i = 0; i < t.length(); i++) {
        	int index = t.charAt(i) - 'a';
        	ans[i] = (char) (minimums[index] + 'a');
        }
        
        return String.valueOf(ans);
    }
	
	void dfs(int node, List<List<Integer>> adj, int[] visited, int[] min) {
        visited[node] = 1;
        min[0] = Math.min(node, min[0]);
        
        for (int adjacent : adj.get(node)) {
            if (visited[adjacent] == 0) {
                dfs(adjacent, adj, visited, min);
            }
        }
    }
}