class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int [] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];
            adj.get(nodeA).add(nodeB);
            adj.get(nodeB).add(nodeA);
        }
        
        int[] visited = new int[n];
        return solve(0, adj, hasApple, 0, visited);
    }
    
    int solve(int node, List<List<Integer>> adj, List<Boolean> hasApple, int myCost, int[] visited) {
        visited[node] = 1;
        
        int childrenCost = 0;
        
        for (int neighbour : adj.get(node)) {
            if (visited[neighbour] != 1) {
                childrenCost += solve(neighbour, adj, hasApple, 2, visited);
            }
        }
        
        if (childrenCost == 0 && !hasApple.get(node)) return 0;
        
        return childrenCost + myCost;
    }
}