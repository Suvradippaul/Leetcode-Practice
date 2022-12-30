class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        list.add(0);
        dfs(0, graph);
        
        return ans;
    }
    
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    
    void dfs(int node, int[][] adj) {
    	if (node == adj.length-1) {         // means it has reached (n-1)th node
        	ans.add(new ArrayList<>(list));
        	return;
        }
        
        for (int neighbour : adj[node]) {
        	list.add(neighbour);
        	dfs(neighbour, adj);
        	list.remove(list.size()-1);
        }
    }
}