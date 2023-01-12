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
        
        solve(0, adj, labels, visited, new int[26], ans);
        
        return ans;
    }
    
    void solve(int node, List<List<Integer>> adj, String labels, int[] visited, int[] map, int[] ans) {
        visited[node] = 1;
        
        for (int neighbour : adj.get(node)) {
            
            if (visited[neighbour] == 0) {
                int[] newMap = new int[26];
                solve(neighbour, adj, labels, visited, newMap, ans);
                for (int i = 0; i < 26; i++) {
                    map[i] += newMap[i];
                }
            }
        }
        
        int i = (int) (labels.charAt(node) - 'a');
        ans[node] = ++map[i];
    }
}