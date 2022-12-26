class Solution {
    List<Integer> ans;
    public List<Integer> eventualSafeNodes(int[][] adj) {
        int V = adj.length;
        ans = new ArrayList<>();
        
		int[] visited = new int[V];
		int[] pathVisited = new int[V];
		
		for (int i = 0; i < V; i++) {
			if (visited[i] == 0) {
				isSafe(i, adj, visited, pathVisited);
			}
		}
		
		Collections.sort(ans);
		return ans;
    }
    
	private boolean isSafe(int i, int[][] adj, int[] visited, int[] pathVisited) {
		visited[i] = 1;
		pathVisited[i] = 1;
		
		for (int neighbour : adj[i]) {
			if (visited[neighbour] == 0) {
				if (!isSafe(neighbour, adj, visited, pathVisited)) return false;
			}
			else if (visited[neighbour] == 1 && pathVisited[neighbour] == 1) {
				return false;
			}
		}
		
		pathVisited[i] = 0;
		ans.add(i);
		return true;
	}
}