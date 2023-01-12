class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int [] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];
            adj.get(nodeA).add(nodeB);
            adj.get(nodeB).add(nodeA);
        }
        
        int[] visited = new int[n];
        int[] ans = new int[n];
        
        solve(0, adj, labels, visited, new HashMap<>(), ans);
        
        return ans;
    }
    
    void solve(int node, List<List<Integer>> adj, String labels, int[] visited, Map<Character, Integer> map, int[] ans) {
        visited[node] = 1;
        
        for (int neighbour : adj.get(node)) {
            
            if (visited[neighbour] == 0) {
                HashMap<Character, Integer> newMap = new HashMap<>();
                solve(neighbour, adj, labels, visited, newMap, ans);
                for (var entry : newMap.entrySet()) {
					char ch = entry.getKey();
					map.put(ch, map.getOrDefault(ch, 0) + entry.getValue());
				}
            }
        }
        
        char ch = labels.charAt(node);
        map.put(ch, map.getOrDefault(ch, 0)+1);
        ans[node] = map.get(ch);
    }
}